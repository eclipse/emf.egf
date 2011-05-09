/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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