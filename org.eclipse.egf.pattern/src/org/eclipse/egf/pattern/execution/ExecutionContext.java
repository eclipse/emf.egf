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

    private PatternCallReporter callReporter;

    public ExecutionContext(BundleAccessor accessor) {
        super(accessor);

    }

    public ExecutionContext(PatternContext parent) {
        super(parent);

    }

    public ExecutionContext(PatternContext parent, PatternCallReporter callReporter) {
        this(parent);
        this.callReporter = callReporter;
    }

    public void setCallReporter(PatternCallReporter reporter) {
        this.callReporter = reporter;
    }

    public boolean hasCallReporter() {
        return callReporter != null;
    }

    public PatternCallReporter getCallReporter() {
        if (callReporter == null) {
            // no need for a chain of command
            // if (parent == null)
            throw new IllegalStateException();
            // return parent.getReporter();
        }
        return callReporter;
    }

    public void setReporter(PatternExecutionReporter reporter) {
        if (reporter instanceof PatternCallReporter)
            setCallReporter((PatternCallReporter) reporter);
        else
            super.setReporter(reporter);
    }

    public boolean hasReporter() {
        return super.hasReporter() || hasCallReporter();
    }

    public PatternExecutionReporter getReporter() {
        if (callReporter != null)
            return callReporter;
        return super.getReporter();
    }

}
