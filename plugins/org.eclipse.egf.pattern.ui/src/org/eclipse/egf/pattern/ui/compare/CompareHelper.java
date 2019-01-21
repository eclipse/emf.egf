/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.compare;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;

/**
 * @author Matthieu Helleboid
 */
public class CompareHelper {
	public static PatternMethod getSuperMethod(PatternMethod patternMethod) {
        Pattern superPattern = patternMethod.getPattern().getSuperPattern();
        if (superPattern != null) 
        	for (PatternMethod  parentPatternMethod : superPattern.getMethods()) 
				if (parentPatternMethod.getName().equals(patternMethod.getName())) 
                    return parentPatternMethod;
        return null;
	}
}