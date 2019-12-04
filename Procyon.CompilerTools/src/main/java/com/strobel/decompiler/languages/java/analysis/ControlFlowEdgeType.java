/*
 * ControlFlowEdgeType.java
 *
 * Copyright (c) 2013 Mike Strobel
 *
 * This source code is based on Mono.Cecil from Jb Evain, Copyright (c) Jb Evain;
 * and ILSpy/ICSharpCode from SharpDevelop, Copyright (c) AlphaSierraPapa.
 *
 * This source code is subject to terms and conditions of the Apache License, Version 2.0.
 * A copy of the license can be found in the License.html file at the root of this distribution.
 * By using this source code in any fashion, you are agreeing to be bound by the terms of the
 * Apache License, Version 2.0.
 *
 * You must not remove this notice, or any other, from this software.
 */

package com.strobel.decompiler.languages.java.analysis;

public enum ControlFlowEdgeType {
    /**
     * Regular control flow.
     */
    Normal,

    /**
     * Conditional control flow (edge taken if condition is true)
     */
    ConditionTrue,

    /**
     * Conditional control flow (edge taken if condition is false)
     */
    ConditionFalse,

    /**
     * A jump statement (goto, goto case, break or continue)
     */
    Jump
}