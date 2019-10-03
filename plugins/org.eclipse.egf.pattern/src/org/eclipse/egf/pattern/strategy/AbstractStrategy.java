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

package org.eclipse.egf.pattern.strategy;

import java.util.List;

import org.eclipse.egf.model.pattern.PatternElement;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AbstractStrategy implements Strategy {

    protected PatternElement[] patternElements;

    public void setPatternElements(List<PatternElement> patterns) {
        this.patternElements = patterns.toArray(new PatternElement[patterns.size()]);
    }

}
