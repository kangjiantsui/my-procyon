/*
 * InstanceOfExpression.java
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

package com.strobel.decompiler.languages.java.ast;

import com.strobel.decompiler.patterns.INode;
import com.strobel.decompiler.patterns.Match;

public class InstanceOfExpression extends Expression {
    public final static TokenRole INSTANCE_OF_KEYWORD_ROLE = new TokenRole("instanceof", TokenRole.FLAG_KEYWORD | TokenRole.FLAG_OPERATOR);

    public InstanceOfExpression( int offset, final Expression expression, final AstType type) {
        super( offset);
        setExpression(expression);
        setType(type);
    }

    public final AstType getType() {
        return getChildByRole(Roles.TYPE);
    }

    public final void setType(final AstType type) {
        setChildByRole(Roles.TYPE, type);
    }

    public final JavaTokenNode getInstanceOfToken() {
        return getChildByRole(INSTANCE_OF_KEYWORD_ROLE);
    }

    public final Expression getExpression() {
        return getChildByRole(Roles.EXPRESSION);
    }

    public final void setExpression(final Expression value) {
        setChildByRole(Roles.EXPRESSION, value);
    }

    @Override
    public <T, R> R acceptVisitor(final IAstVisitor<? super T, ? extends R> visitor, final T data) {
        return visitor.visitInstanceOfExpression(this, data);
    }

    @Override
    public boolean matches(final INode other, final Match match) {
        if (other instanceof InstanceOfExpression) {
            final InstanceOfExpression otherExpression = (InstanceOfExpression) other;

            return !otherExpression.isNull() &&
                   getExpression().matches(otherExpression.getExpression(), match) &&
                   getType().matches(otherExpression.getType(), match);
        }

        return false;
    }
}
