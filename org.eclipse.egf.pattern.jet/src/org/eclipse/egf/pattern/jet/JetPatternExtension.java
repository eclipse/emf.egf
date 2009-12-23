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

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternRunner;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.egf.pattern.extension.PatternInitializer;

/**
 * @author Guiu
 * 
 */
public class JetPatternExtension extends PatternExtension {

    private static final PatternNature NATURE = org.eclipse.egf.model.jetpattern.JetPatternFactory.eINSTANCE.createJetNature();
    private final PatternFactory factory = new JetPatternFactory();

    @Override
    public PatternNature getNature() {
        return NATURE;
    }

    @Override
    public PatternRunner doCreateRunner(Pattern pattern) {
        return new JetRunner_to_be_moved_to_model1(pattern);
    }

    @Override
    public PatternFactory getFactory() {
        return factory;
    }

    @Override
    protected PatternInitializer doCreateInitializer(IProject project, Pattern pattern) {

        return new JetPatternInitializer(project, pattern);
    }

}
