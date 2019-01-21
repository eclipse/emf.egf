/**
 * <copyright>
 *
 *  Copyright (c) 2009-2011 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.model.pattern;

import org.eclipse.egf.model.pattern.Node.Container;

/**
 * @author Matthieu Helleboid
 * 
 */
public class DefaultPatternOutputProcessor implements PatternOutputProcessor {

    public void applyOnLoopResult(Container node) {
    }

    public void applyOnLoopResult(StringBuilder builder) {
    }

    public void applyOnExecutionResult(Container node) {
    }

    public void applyOnExecutionResult(StringBuilder builder) {
    }

    public String getProcessorId() {
        return getClass().getName();
    }

}