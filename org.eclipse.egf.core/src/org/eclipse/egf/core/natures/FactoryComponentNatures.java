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
 * 
 */

package org.eclipse.egf.core.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.EGFCorePlugin;

public class FactoryComponentNatures {

    public static final String FACTORY_COMPONENT_NATURE = "org.eclipse.egf.core.FactoryComponentNature"; //$NON-NLS-1$

    public static final String PATTERN_BUILDER_ID = "org.eclipse.egf.pattern.PatternBuilder"; //$NON-NLS-1$

    public static boolean hasFactoryComponentNature(IProject project) {
        try {
            return project.hasNature(FACTORY_COMPONENT_NATURE);
        } catch (CoreException e) {
            EGFCorePlugin.getDefault().log(e);
            return false;
        }
    }

}
