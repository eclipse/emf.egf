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

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public class SuperOrchestrationContext implements InternalPatternContext {

    private final InternalPatternContext delegate;
    protected Node.Container node;

    public SuperOrchestrationContext(InternalPatternContext delegate) {
        super();
        this.delegate = delegate;
        if (delegate == null)
            throw new IllegalArgumentException();
        node = new Node.Container(delegate.getNode(), "super");
    }

    public int getExecutionCurrentIndex() {
        return delegate.getExecutionCurrentIndex();
    }

    public void setExecutionCurrentIndex(int index) {
        delegate.setExecutionCurrentIndex(index);
    }

    public StringBuffer getBuffer() {
        return delegate.getBuffer();
    }

    public Bundle getBundle(String id) throws PatternException {
        return delegate.getBundle(id);
    }

    public PatternExecutionReporter getReporter() {
        return delegate.getReporter();
    }

    public Object getValue(String name) {
        return delegate.getValue(name);
    }

    public boolean hasReporter() {
        return delegate.hasReporter();
    }

    public void setReporter(PatternExecutionReporter reporter) {
        delegate.setReporter(reporter);
    }

    public void setValue(String name, Object value) {
        delegate.setValue(name, value);
    }

    public boolean useReporter() {
        return false;
    }

    public void clearBuffer() {
        delegate.clearBuffer();
    }

    public StringBuffer getExecutionBuffer() {
        return delegate.getExecutionBuffer();
    }

    public Node.Container getNode() {
        return node;
    }

    public void setNode(Node.Container node) {
        this.node = node;
    }

}
