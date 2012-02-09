/**
 * <copyright>
 *
 *  Copyright (c) 2009-2011 Thales Corporate Services S.A.S.
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