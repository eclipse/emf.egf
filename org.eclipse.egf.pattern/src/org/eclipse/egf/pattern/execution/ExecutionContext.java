/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Thomas Guiu
 * 
 */
public class ExecutionContext extends DefaultPatternContext implements InternalPatternContext {

    private PatternExecutionReporter reporter;
    private final StringBuilder buffer;

    public ExecutionContext(BundleAccessor accessor) {
        super(accessor);
        buffer = new StringBuilder(1000);
    }

    public ExecutionContext(InternalPatternContext parent) {
        super((PatternContext) parent);
        buffer = null;
    }

    public void setReporter(PatternExecutionReporter reporter) {
        this.reporter = reporter;
    }

    public boolean hasReporter() {
        return reporter != null;
    }

    public boolean useReporter() {
        return parent == null;
    }

    public PatternExecutionReporter getReporter() {
        if (reporter == null) {
            // no need for a chain of command
            // if (parent == null)
            throw new IllegalStateException();
        }
        return reporter;
    }

    public StringBuilder getBuffer() {
        if (parent != null)
            return ((InternalPatternContext) parent).getBuffer();
        if (buffer == null)
            throw new IllegalStateException();
        return buffer;
    }
}
