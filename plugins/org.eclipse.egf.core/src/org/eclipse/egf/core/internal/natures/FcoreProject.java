/**
 * <copyright>
 * 
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
 * 
 * </copyright>
 * 
 */

package org.eclipse.egf.core.internal.natures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.helper.EclipseBuilderHelper;
import org.eclipse.egf.core.helper.ProjectHelper;
import org.eclipse.egf.core.natures.EGFNatures;

public class FcoreProject extends BaseProject {

    /**
     * FcoreNature constructor comment.
     */
    public FcoreProject() {
        super();
    }

    public void configure() throws CoreException {
        IProjectDescription description = getProject().getDescription();
        List<String> builders = new ArrayList<String>();
        builders.add(EGFNatures.PATTERN_BUILDER_ID);
        ProjectHelper.addBuilders(description, builders, new NullProgressMonitor());
    }

    public void deconfigure() throws CoreException {
        IProjectDescription description = getProject().getDescription();
        EclipseBuilderHelper.removeFromBuildSpec(description, EGFNatures.PATTERN_BUILDER_ID, new NullProgressMonitor());
        getProject().setDescription(description, new NullProgressMonitor());
    }

}
