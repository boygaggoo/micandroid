/*
 * =============================================================================
 * Copyright by Benjamin Sempere,
 * All rights reserved.
 * =============================================================================
 * Author  : Benjamin Sempere
 * E-mail  : benjamin@sempere.org
 * Homepage: www.sempere.org
 * =============================================================================
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.sempere.commons.proxy;

import org.junit.*;

import java.lang.reflect.*;

/**
 * Unit tests class for NullCheckerHandler.
 *
 * @author bsempere
 */
public class NullCheckerHandlerTest {

    private NullCheckerHandler<String> handler;

    @Before
    public void before() throws Exception {
        this.handler = new NullStringCheckerHandler("MyString");
    }

    @Test
    public void invokeProxyWhenRealObjectIsNotNullShouldInvokeRealObject() throws Throwable {
        Method method = this.handler.getRealObject().getClass().getMethod("toString", new Class[]{});
        this.handler.invoke(null, method, null);
    }

    @Test(expected = ObjectCannotBeNullException.class)
    public void invokeProxyWhenRealObjectIsNullShouldThrowException() throws Throwable {
        Method method = this.handler.getRealObject().getClass().getMethod("toString", new Class[]{});
        this.handler.setRealObject(null);
        this.handler.invoke(null, method, null);
    }

    // *************************************************************************
    //
    // Test fixtures, stubs, ...
    //
    // *************************************************************************

    private class NullStringCheckerHandler extends NullCheckerHandler<String> {

        public NullStringCheckerHandler(String object) {
            super(object);
        }

        @Override
        public void handleCheckResult(boolean result) {
            if (result) {
                throw new ObjectCannotBeNullException();
            }
        }
    }

    private class ObjectCannotBeNullException extends RuntimeException {

        private static final long serialVersionUID = 4911712009190410190L;

        public ObjectCannotBeNullException() {
            super("Object cannot be null.");
        }
    }
}
