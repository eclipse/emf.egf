/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.execution;

import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Thomas Guiu
 * 
 */
public class ExecutionContext extends DefaultInternalPatternContext {

    private PatternExecutionReporter reporter;

    public ExecutionContext(BundleAccessor accessor) {
        super(accessor);
    }

    public ExecutionContext(InternalPatternContext parent) {
        super(parent);
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

}
