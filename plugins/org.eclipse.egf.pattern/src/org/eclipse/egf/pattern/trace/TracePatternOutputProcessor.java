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

package org.eclipse.egf.pattern.trace;

import java.io.IOException;

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Node.Container;
import org.eclipse.egf.model.pattern.PatternOutputProcessor;
import org.eclipse.egf.pattern.EGFPatternPlugin;

/**
 * @author Thomas Guiu
 * 
 */
public class TracePatternOutputProcessor implements PatternOutputProcessor {

    public void applyOnExecutionResult(Node.Container root) {
    }

    public void applyOnLoopResult(Container root) {
        try {
            TraceHelper createInstance = TraceHelper.createInstance();
            createInstance.apply(root);
        } catch (IOException e) {
            EGFPatternPlugin.getDefault().logError(e);
            // TODO mettre une clausse throws
        }
    }

    public String getProcessorId() {

        return TraceHelper.DEFAULT_TRACE_PROCESSOR_ID;
    }

    public void applyOnLoopResult(StringBuilder builder) {
    }

    public void applyOnExecutionResult(StringBuilder builder) {
    }

}
