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

package org.eclipse.egf.pattern.ftask.tasks;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.execution.OutputManager;

/**
 * @author Thomas Guiu
 * 
 */
class StrategyReporter implements PatternExecutionReporter {

    private final PatternExecutionReporter delegate;

    public StrategyReporter(PatternExecutionReporter delegate) {
        super();
        this.delegate = delegate;
    }

    public void executionFinished(PatternContext context) {

        final InternalPatternContext ictx = (InternalPatternContext) context;
        final String flatten = OutputManager.computeExecutionOutput(ictx);
        delegate.executionFinished(flatten, context);
    }

    public void executionFinished(String output, PatternContext context) {
        throw new IllegalStateException();
    }

    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
        delegate.loopFinished(output, outputWithCallBack, context, parameterValues);
    }

}
