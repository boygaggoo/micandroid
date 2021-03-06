/**
 * Copyright 2010 Nicholas Blair, Eric Dalquist
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.ehcache.annotations.key;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.MethodCallback;

import com.googlecode.ehcache.annotations.util.guice.FinalizableReference;
import com.googlecode.ehcache.annotations.util.guice.ReferenceMap;
import com.googlecode.ehcache.annotations.util.guice.ReferenceType;


/**
 * {@link ReflectionHelper} that uses a cache to track reflection operations. A background thread is started on first
 * usage to perform cache cleanup to avoid class reference leaks. Code that uses this class should call {@link #destroy()}
 * when complete to ensure the cleanup thread shuts down.  
 * 
 * @author Eric Dalquist
 * @version $Revision: 519 $
 */
public final class CachingReflectionHelper implements DisposableBean, ReflectionHelper {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private enum ImplementsMethod {
        HASH_CODE,
        EQUALS,
        TO_STRING;
    }
    
    private final ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
    private final Map<Class<?>, Set<ImplementsMethod>> implementsCache = new ReferenceMap<Class<?>, Set<ImplementsMethod>>(ReferenceType.WEAK, ReferenceType.STRONG, this.referenceQueue);
    private final Thread cleanupThread;
    private final AtomicBoolean running = new AtomicBoolean(false);

    public CachingReflectionHelper() {
        this.cleanupThread = new Thread("CachingReflectionHelper_CleanupThread") {
            @Override
            public void run() {
                while (running.get()) {
                    try {
                        final Reference<? extends Object> reference = referenceQueue.remove();
                        ((FinalizableReference) reference).finalizeReferent();
                    }
                    catch (InterruptedException e) {
                        /* ignore */
                    }
                    catch (Throwable t) {
                        logger.error("Error finalizing reference.", t);
                    }
                }
            }
        };

        this.cleanupThread.setDaemon(true);
    }
    

    public void setThreadName(String threadName) {
        this.cleanupThread.setName("CachingReflectionHelper_CleanupThread" + (threadName != null ? "-" + threadName : ""));
    }



    private Map<Class<?>, Set<ImplementsMethod>> getCache() {
        if (!this.running.get() && this.running.compareAndSet(false, true)) {
            //Don't start the cleanup thread until the cache is actually accessed
            this.cleanupThread.start();
        }
        
        return this.implementsCache;
    }

    @Override
    protected void finalize() throws Throwable {
        this.destroy();
    }

    public void destroy() throws Exception {
        if (this.running.get() && this.running.compareAndSet(true, false)) {
            this.cleanupThread.interrupt();
            try {
                this.cleanupThread.join(1000);
            }
            catch (InterruptedException e) {
                logger.warn("Failed to join the " + this.cleanupThread.getName() + " thread");
            }
        }
    }

    
    /* (non-Javadoc)
     * @see com.googlecode.ehcache.annotations.util.guice.ReflectionHelper#implementsHashCode(java.lang.Object)
     */
    public boolean implementsHashCode(Object element) {
        return this.doesImplement(element.getClass(), ImplementsMethod.HASH_CODE);
    }
    
    /* (non-Javadoc)
     * @see com.googlecode.ehcache.annotations.util.guice.ReflectionHelper#implementsEquals(java.lang.Object)
     */
    public boolean implementsEquals(Object element) {
        return this.doesImplement(element.getClass(), ImplementsMethod.EQUALS);
    }
    
    /* (non-Javadoc)
     * @see com.googlecode.ehcache.annotations.util.guice.ReflectionHelper#implementsToString(java.lang.Object)
     */
    public boolean implementsToString(Object element) {
        return this.doesImplement(element.getClass(), ImplementsMethod.TO_STRING);
    }
    
    public void clearCache() {
        final Map<Class<?>, Set<ImplementsMethod>> cache = this.getCache();
        cache.clear();
    }
    
    /**
     * Scans a class to see if it implements the hashCode, toString and equals methods which are commonly
     * used by key generators
     */
    private boolean doesImplement(final Class<?> elementClass, ImplementsMethod method) {
        final Map<Class<?>, Set<ImplementsMethod>> cache = this.getCache();
        Set<ImplementsMethod> methodCache = cache.get(elementClass);

        if (methodCache == null) {
            methodCache = EnumSet.noneOf(ImplementsMethod.class);
            cache.put(elementClass, methodCache);

            //Create final reference for use by anonymous class
            final Set<ImplementsMethod> implementsSet = methodCache;
            ReflectionUtils.doWithMethods(elementClass, new MethodCallback() {
                public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                    if (implementsSet.size() == 3 || method.getDeclaringClass() == Object.class) {
                        return;
                    }
                    
                    if (ReflectionUtils.isEqualsMethod(method)) {
                        implementsSet.add(ImplementsMethod.EQUALS);
                    }
                    else if (ReflectionUtils.isHashCodeMethod(method)) {
                        implementsSet.add(ImplementsMethod.HASH_CODE);
                    }
                    else if (ReflectionUtils.isToStringMethod(method)) {
                        implementsSet.add(ImplementsMethod.TO_STRING);
                    }
                }
            });
        }
        
        return methodCache.contains(method);
    }
}
