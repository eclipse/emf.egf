/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.execution;

import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternContext;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class DefaultInternalPatternContext extends DefaultPatternContext implements InternalPatternContext {

    protected StringBuffer loopBuffer;
    protected StringBuffer executionBuffer;
    protected Node.Container node;

    private int index;

    public DefaultInternalPatternContext(BundleAccessor accessor) {
        super(accessor);
        loopBuffer = new StringBuffer(2000);
        executionBuffer = new StringBuffer(2000);
        node = new Node.Container(null, "Root node");
    }

    public int getExecutionCurrentIndex() {
        return index;
    }

    public void setExecutionCurrentIndex(int index) {
        this.index = index;
    }

    public DefaultInternalPatternContext(InternalPatternContext parent) {
        this(parent, new Node.Container(parent.getNode(), (String) null));
    }

    protected DefaultInternalPatternContext(InternalPatternContext parent, Node.Container node) {
        super((PatternContext) parent);
        this.node = node;
    }

    public StringBuffer getBuffer() {
        if (parent != null)
            return ((InternalPatternContext) parent).getBuffer();
        if (loopBuffer == null)
            throw new IllegalStateException();
        return loopBuffer;
    }

    public StringBuffer getExecutionBuffer() {
        if (parent != null)
            return ((InternalPatternContext) parent).getExecutionBuffer();
        if (executionBuffer == null)
            throw new IllegalStateException();
        return executionBuffer;
    }

    public void clearBuffer() {
        getBuffer().setLength(0);
    }

    public Node.Container getNode() {
        return node;
    }

    public void setNode(Node.Container node) {
        this.node = node;
    }

}
