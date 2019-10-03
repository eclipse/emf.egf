/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
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

    protected Node.Container node;

    public DefaultInternalPatternContext(BundleAccessor accessor) {
        super(accessor);
        node = new Node.Container(null, "Root node");
    }

    public DefaultInternalPatternContext(InternalPatternContext parent) {
        this(parent, new Node.Container(parent.getNode(), (String) null));
    }

    protected DefaultInternalPatternContext(InternalPatternContext parent, Node.Container node) {
        super((PatternContext) parent);
        this.node = node;
    }

    public Node.Container getNode() {
        return node;
    }

    public void setNode(Node.Container node) {
        this.node = node;
    }

    public StringBuffer getBuffer() {
        return null;
    }

    public StringBuffer getExecutionBuffer() {
        return null;
    }

    public int getExecutionCurrentIndex() {
        return 0;
    }

    public void setExecutionCurrentIndex(int index) {
    }

    public void clearBuffer() {
    }

}
