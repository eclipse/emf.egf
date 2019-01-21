/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * 
 * @author Thomas Guiu
 */
public class BuildFcoreReporter implements PatternExecutionReporter, FcoreBuilderConstants {

    public void executionFinished(String output, PatternContext context) {
        FactoryComponent fc = (FactoryComponent) context.getValue(FcoreBuilderConstants.MAIN_FCORE);
        for (FactoryComponent unusedFC : (Collection<FactoryComponent>) context.getValue(FcoreBuilderConstants.UNUSED_FCORE)) {
            EcoreUtil.delete(unusedFC);
        }

        try {
            fc.eResource().save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            Activator.getDefault().logError(e);
        }
    }

    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {

    }

}
