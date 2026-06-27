/*
 * Copyright (c) 2026, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Efficient Java Matrix Library (EJML).
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

package org.ejml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrintFormat extends EjmlStandardJUnit {
    @Test void f_double() {
        var alg = new PrintFormat() {};
        alg.precision = 2;
        assertEquals("1.23", alg.f(1.2345));
    }

    @Test void f_double_array() {
        var alg = new PrintFormat() {};
        alg.precision = 2;
        assertEquals("1.23, 2, 3", alg.f(", ", 1.2345, 2 , 3));
    }

    @Test void f_double_array_builder() {
        var builder = new StringBuilder();
        var alg = new PrintFormat() {};
        alg.precision = 2;
        alg.f(builder,", ", 1.2345, 2 , 3);
        assertEquals("1.23, 2, 3", builder.toString());
    }

    @Test void f_float_array() {
        var alg = new PrintFormat() {};
        alg.precision = 2;
        assertEquals("1.23, 2, 3", alg.f(", ", 1.2345f, 2 , 3));
    }

    @Test void f_float_array_builder() {
        var builder = new StringBuilder();
        var alg = new PrintFormat() {};
        alg.precision = 2;
        alg.f(builder,", ", 1.2345f, 2 , 3);
        assertEquals("1.23, 2, 3", builder.toString());
    }
}
