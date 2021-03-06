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

/**
 * 
 */
package com.googlecode.ehcache.annotations.integration;

import com.googlecode.ehcache.annotations.TriggersRemove;

/**
 * @author Nicholas Blair
 *
 */
public class TriggersRemoveTestImpl implements TriggersRemoveTestInterface {
    /* (non-Javadoc)
     * @see com.googlecode.ehcache.annotations.TriggersRemoveTestInterface#implMethodTriggersFlush()
     */
    @TriggersRemove(cacheName="triggersRemoveCountingCache")
    public void implMethodTriggersRemove() {
    }

    /* (non-Javadoc)
     * @see com.googlecode.ehcache.annotations.TriggersRemoveTestInterface#methodTriggersFlush()
     */
    public void methodTriggersRemove() {
    }

    /* (non-Javadoc)
     * @see com.googlecode.ehcache.annotations.TriggersRemoveTestInterface#methodTriggersFlushAndRemoveAll()
     */
    public void methodTriggersRemoveAll() {
    }

    /* (non-Javadoc)
     * @see com.googlecode.ehcache.annotations.TriggersRemoveTestInterface#notFlushableMethod()
     */
    public void notTriggersRemoveMethod() {
    }

    public Object simpleCachedMethod() {
        return new Object();
    }

    public void methodMultipleTriggersRemove() {
        
    }

    public void methodMultipleTriggersRemoveAll() {
        
    }

    public Object simpleCachedMethodTwo() {
        return new Object();
    }
}
