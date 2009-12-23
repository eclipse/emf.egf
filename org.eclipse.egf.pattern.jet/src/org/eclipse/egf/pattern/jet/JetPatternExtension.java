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

package org.eclipse.egf.pattern.jet;

import org.eclipse.egf.model.jetpattern.JetpatternFactory;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternRunner;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.PatternFactory;

/**
 * @author Guiu
 *
 */
public class JetPatternExtension extends PatternExtension {

	private static final PatternNature NATURE = JetpatternFactory.eINSTANCE.createJetNature();
	private final PatternFactory factory = new JetPatternFactory();

	@Override
	public PatternNature getNature() {
		return NATURE;
	}

	@Override
	public PatternRunner getRunner() {
		return null;
	}

	@Override
	public PatternFactory getFactory() {
		return factory;
	}

}
