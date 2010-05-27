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

package org.eclipse.egf.pattern.ftask.tasks;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.pattern.execution.InternalPatternContext;

/**
 * @author Thomas Guiu
 * 
 */
class StrategyReporter implements PatternExecutionReporter {

    private final PatternExecutionReporter delegate;
    private final StringBuilder buffer = new StringBuilder(1000);

    public StrategyReporter(PatternExecutionReporter delegate) {
        super();
        this.delegate = delegate;
    }

    public void executionFinished(PatternContext context) {
        delegate.executionFinished(((InternalPatternContext) context).getExecutionBuffer().toString(), context);
    }

    public void executionFinished(String output, PatternContext context) {
        throw new IllegalStateException();
    }

    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
        delegate.loopFinished(output, outputWithCallBack, context, parameterValues);
        buffer.append(output);
    }

}
