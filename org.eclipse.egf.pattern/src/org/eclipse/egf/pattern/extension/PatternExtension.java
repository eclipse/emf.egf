/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.extension;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternRunner;

/**
 * @author Guiu
 *
 */
public abstract class PatternExtension {
	
	public static final String EXTENSION_ID= "org.eclipse.egf.pattern.extension";

	public abstract PatternNature getNature();

	public abstract PatternFactory getFactory();

	public abstract PatternRunner createRunner();

	public boolean matchNature(Pattern pattern) {
		if (pattern == null || pattern.getNature() == null)
			throw new IllegalArgumentException();
		if (getNature() == null)
			throw new IllegalStateException();

		return getNature().eClass().equals(pattern.getNature().eClass());
	}
}
