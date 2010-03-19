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
import org.eclipse.egf.model.pattern.PatternContext;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class DefaultInternalPatternContext extends DefaultPatternContext implements InternalPatternContext {

    protected StringBuffer loopBuffer;
    protected StringBuffer executionBuffer;

    public DefaultInternalPatternContext(BundleAccessor accessor) {
        super(accessor);
        loopBuffer = new StringBuffer(2000);
        executionBuffer = new StringBuffer(2000);
    }

    public DefaultInternalPatternContext(InternalPatternContext parent) {
        super((PatternContext) parent);
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
}
