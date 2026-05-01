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

package org.ejml.dense.row.factory;

/// Set of different linear solvers.
public enum LinearSolverType {
	/// Application specific default
	DEFAULT,
	/// Square positive definite. Fast solver.
	CHOLESKY,
	/// Faster variant of Cholesky when dealing with large matrices
	CHOLESKY_BLOCK,
	/// Cholesky, but avoids finding the square root
	LDL,
	/// Rectangular
	QR,
	/// More stable version of QR but not as stable as SVD
	QRP,
	/// Most robust but also slowest.
	SVD,
}
