/*
 * BootstrapMethodsTableEntry.java
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

package com.strobel.assembler.ir.attributes;

import com.strobel.assembler.metadata.MethodHandle;
import com.strobel.assembler.metadata.MethodReference;
import com.strobel.core.ArrayUtilities;
import com.strobel.core.VerifyArgument;

import java.util.Collections;
import java.util.List;

public final class BootstrapMethodsTableEntry {
    private final MethodHandle _method;
    private final List<Object> _arguments;

    public BootstrapMethodsTableEntry(final MethodHandle method, final List<Object> arguments) {
        this(method, VerifyArgument.notNull(arguments, "arguments").toArray());
    }

    public BootstrapMethodsTableEntry(final MethodHandle method, final Object... arguments) {
        _method = VerifyArgument.notNull(method, "method");

        _arguments = ArrayUtilities.isNullOrEmpty(arguments) ? Collections.emptyList()
                                                             : ArrayUtilities.asUnmodifiableList(arguments);
    }

    public final List<Object> getArguments() {
        return _arguments;
    }

    public final MethodHandle getMethodHandle() {
        return _method;
    }

    public final MethodReference getMethod() {
        return _method.getMethod();
    }
}
