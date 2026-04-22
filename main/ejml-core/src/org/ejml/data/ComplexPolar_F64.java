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
 * {@link Complex_F64} number in polar notation.<br>
 * z = r*(cos(&theta;) + i*sin(&theta;))<br>
 * where r and &theta; are polar coordinate parameters
 * </p>
 *
 * @author Peter Abeles
 */
@Data
public class ComplexPolar_F64 {
    public double r;
    public double theta;

    public ComplexPolar_F64( double r, double theta ) {
        this.r = r;
        this.theta = theta;
    }

    public ComplexPolar_F64( Complex_F64 n ) {
        ComplexMath_F64.convert(n, this);
    }

    public ComplexPolar_F64() {}

    public Complex_F64 toStandard() {
        Complex_F64 ret = new Complex_F64();
        ComplexMath_F64.convert(this, ret);
        return ret;
    }

    public void setTo( double r, double theta ) {
        this.r = r;
        this.theta = theta;
    }

    public void setTo( ComplexPolar_F64 src ) {
        this.r = src.r;
        this.theta = src.theta;
    }

    public String format( MatrixPrintFormat format ) {
        return format.rowPrefix +
                UtilEjml.fancyString2(r, format.precision, format.decimal) + format.colSeparator +
                UtilEjml.fancyString2(theta, format.precision, format.decimal) +
                format.rowSuffix;
    }

    public String format( MapPrintFormat format ) {
        return format.itemPrefix +
                "r" + format.valueSeparator + UtilEjml.fancyString2(r, format.precision, format.decimal) +
                format.pairSeparator +
                "theta" + format.valueSeparator + UtilEjml.fancyString2(theta, format.precision, format.decimal) +
                format.itemSuffix;
    }

    @Override public String toString() {return format(MapPrintFormat.DEFAULT);}
}
