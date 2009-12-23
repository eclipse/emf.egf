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

package org.eclipse.egf.core.internal.natures;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.helper.EclipseBuilderHelper;
import org.eclipse.egf.core.natures.FactoryComponentNatures;

public class FactoryComponentProject extends BaseProject {

    /**
     * FactoryComponentNature constructor comment.
     */
    public FactoryComponentProject() {
        super();
    }

    public void configure() throws CoreException {
        EclipseBuilderHelper.addToBuildSpec(getProject(), FactoryComponentNatures.PATTERN_BUILDER_ID);
    }

    public void deconfigure() throws CoreException {
        EclipseBuilderHelper.removeFromBuildSpec(getProject(), FactoryComponentNatures.PATTERN_BUILDER_ID);
    }

}
