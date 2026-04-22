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

import lombok.Getter;
import lombok.Setter;

/// Base class for print formatting
public abstract class PrintFormat {
    /// Number of significant digits it will display when converting a float
    @Getter @Setter public int precision = 6;

    /// Character which indicates a decimal in floating point numbers
    @Getter @Setter public char decimal = '.';

    /// Applies standard formatting to the double
    public String f( double value ) {
        return UtilEjml.fancyString2(value, precision, decimal);
    }
}
