/*
 * Copyright (c) 2023, Peter Abeles. All Rights Reserved.
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

package org.ejml.dense.row.mult;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.RandomMatrices_DDRM;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Compare concurrent vs non-concurrent functions in CommonOps
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
@State(Scope.Benchmark)
@Fork(value = 2)
public class BenchmarkMatrixMultProduct_MT_DDRM {
    //    @Param({"100", "500", "1000", "5000", "10000"})
    @Param({"1000"})
    public int size;

    public DMatrixRMaj S1 = new DMatrixRMaj(1, 1);
    public DMatrixRMaj S2 = new DMatrixRMaj(1, 1);


    @Setup
    public void setup() {
        Random rand = new Random(234);

        S1.reshape(size, size);
        S2.reshape(size, size);

        RandomMatrices_DDRM.fillUniform(S1, -1, 1, rand);
    }

    // @formatter:off
    @Benchmark public void outer() { MatrixMultProduct_MT_DDRM.outer(S1, S2); }
    @Benchmark public void inner_reorder() { MatrixMultProduct_MT_DDRM.inner_reorder(S1, S2); }
    @Benchmark public void inner_reorder_upper() { MatrixMultProduct_MT_DDRM.inner_reorder_upper(S1, S2); }
    @Benchmark public void inner_reorder_lower() { MatrixMultProduct_MT_DDRM.inner_reorder_lower(S1, S2); }
    // @formatter:on

    public static void main( String[] args ) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkMatrixMultProduct_MT_DDRM.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
