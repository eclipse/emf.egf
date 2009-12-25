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

package org.eclipse.egf.pattern.java;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.egf.pattern.extension.PatternInitializer;

/**
 * @author Guiu
 * 
 */
public class JavaPatternExtension extends PatternExtension {

    private static final PatternNature NATURE = org.eclipse.egf.model.javapattern.JavaPatternFactory.eINSTANCE.createJavaNature();
    private final PatternFactory factory = new JavaPatternFactory();

    @Override
    public PatternNature getNature() {
        return NATURE;
    }

    @Override
    public PatternEngine doCreateRunner(Pattern pattern) {
        return new JavaRunner_to_be_moved_to_model1(pattern);
    }

    @Override
    public PatternFactory getFactory() {
        return factory;
    }

    @Override
    public String canTranslate(Pattern pattern) {

        String canTranslate = super.canTranslate(pattern);
        if (canTranslate == null) {
            try {
                JavaNatureHelper.getClassName(pattern);
            } catch (PatternException e) {
                return e.getMessage();
            }
        }
        return canTranslate;
    }

    @Override
    protected PatternInitializer doCreateInitializer(IProject project, Pattern pattern) {

        return new JavaPatternInitializer(project, pattern);
    }

}
