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
        try {
            TraceHelper createInstance = TraceHelper.createInstance();
            createInstance.apply(root);
        } catch (IOException e) {
            EGFPatternPlugin.getDefault().logError(e);
            // TODO mettre une clausse throws
        }

    }

    public void applyOnLoopResult(Container root) {
    }

    public String getProcessorId() {

        return TraceHelper.DEFAULT_TRACE_PROCESSOR_ID;
    }

}
