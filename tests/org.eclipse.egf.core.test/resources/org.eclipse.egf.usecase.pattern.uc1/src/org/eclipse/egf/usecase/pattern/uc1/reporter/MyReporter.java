/**
 * <copyright>
 * 
 * Copyright (c) 2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.usecase.pattern.uc1.reporter;

import java.util.Map;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Benoit Langlois
 * 
 */

public class MyReporter implements PatternExecutionReporter {

    public void executionFinished(String output, PatternContext context) {
        String message = new String("--------------\nResult of pattern:\n" + output); //$NON-NLS-1$

        // Message on the default console
        System.out.println(message);

        // Message on the EGF console
        EGFCorePlugin.getDefault().logInfo(message);
    }

    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
        // TODO Auto-generated method stub
    }

}
