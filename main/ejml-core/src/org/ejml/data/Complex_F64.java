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
package org.ejml.data;

import lombok.Data;
import org.ejml.MapPrintFormat;
import org.ejml.MatrixPrintFormat;
import org.ejml.UtilEjml;
import org.ejml.ops.ComplexMath_F64;

/**
 * <p>
 * Represents a complex number using 64-bit floating point numbers. A complex number is composed of
 * real and imaginary components.
 * </p>
 */
@Data
public class Complex_F64 {
    public double real;
    public double imaginary;

    public Complex_F64( double real, double imaginary ) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex_F64() {}

    public double getMagnitude() {
        return Math.sqrt(real*real + imaginary*imaginary);
    }

    public double getMagnitude2() {
        return real*real + imaginary*imaginary;
    }

    public void setTo( double real, double imaginary ) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setTo( Complex_F64 src ) {
        this.real = src.real;
        this.imaginary = src.imaginary;
    }

    public boolean isReal() {
        return imaginary == 0.0;
    }

    public Complex_F64 plus( Complex_F64 a ) {
        Complex_F64 ret = new Complex_F64();
        ComplexMath_F64.plus(this, a, ret);
        return ret;
    }

    public Complex_F64 minus( Complex_F64 a ) {
        Complex_F64 ret = new Complex_F64();
        ComplexMath_F64.minus(this, a, ret);
        return ret;
    }

    public Complex_F64 times( Complex_F64 a ) {
        Complex_F64 ret = new Complex_F64();
        ComplexMath_F64.multiply(this, a, ret);
        return ret;
    }

    public Complex_F64 divide( Complex_F64 a ) {
        Complex_F64 ret = new Complex_F64();
        ComplexMath_F64.divide(this, a, ret);
        return ret;
    }

    public String format( MatrixPrintFormat format ) {
        return format.rowPrefix +
                UtilEjml.fancyString2(real, format.precision, format.decimal) + format.colSeparator +
                UtilEjml.fancyString2(imaginary, format.precision, format.decimal) +
                format.rowSuffix;
    }

    public String format( MapPrintFormat format ) {
        return format.itemPrefix +
                "real" + format.valueSeparator + UtilEjml.fancyString2(real, format.precision, format.decimal) +
                format.pairSeparator +
                "imaginary" + format.valueSeparator + UtilEjml.fancyString2(imaginary, format.precision, format.decimal) +
                format.itemSuffix;
    }

    @Override public String toString() {return format(MapPrintFormat.DEFAULT);}
}
