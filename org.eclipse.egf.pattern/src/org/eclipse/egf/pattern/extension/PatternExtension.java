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

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternRunner;
import org.eclipse.egf.pattern.Messages;

/**
 * @author Guiu
 * 
 */
public abstract class PatternExtension {

    public static final String EXTENSION_ID = "org.eclipse.egf.pattern.extension";

    public abstract PatternNature getNature();

    public abstract PatternFactory getFactory();

    protected abstract PatternRunner doCreateRunner(Pattern pattern);

    public PatternRunner createRunner(Pattern pattern) throws PatternException {
        if (!matchNature(pattern))
            throw new PatternException(Messages.bind(Messages.extension_error2, getNature().eClass().getName(), pattern.getNature().eClass().getName()));
        return doCreateRunner(pattern);
    }

    protected abstract PatternInitializer doCreateInitializer(IProject project, Pattern pattern);

    public PatternInitializer createInitializer(IProject project, Pattern pattern) throws PatternException {
        if (!matchNature(pattern))
            throw new PatternException(Messages.bind(Messages.extension_error2, getNature().eClass().getName(), pattern.getNature().eClass().getName()));
        return doCreateInitializer(project, pattern);
    }

    public boolean matchNature(Pattern pattern) {
        if (pattern == null || pattern.getNature() == null)
            throw new IllegalArgumentException();
        if (getNature() == null)
            throw new IllegalStateException();

        return getNature().eClass().equals(pattern.getNature().eClass());
    }
}
