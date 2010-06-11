/*******************************************************************************
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.pde.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;

/**
 * Provides services when creating fcore or converting existing
 * plug-ins in fcore projects.
 * 
 * @author Guillaume Brocard
 */
public class FcoreGeneratorHelper {

    /**
     * Add an entry in the binary entry of the build.properties i.e bin.include.<br>
     * Caller is responsible to save the modified build model.
     * 
     * @param buildModel
     */
    public static void addEntryInBinaryBuild(IBuildModel buildModel, String entry) throws CoreException {
        IBuild build = buildModel.getBuild();
        // Update the bin.includes property
        IBuildEntry binEntry = build.getEntry(IBuildEntry.BIN_INCLUDES);
        if (binEntry != null) {
            if (binEntry.contains(entry) == false) {
                binEntry.addToken(entry);
            }
        }
    }

    /**
     * Get the build model for given project.
     * 
     * @param project
     * @return WorkspaceBuildModel
     */
    public static WorkspaceBuildModel getBuildModel(IProject project) {
        // Precondition.
        if (project == null) {
            return null;
        }
        WorkspaceBuildModel buildModel = null;
        IFile buildFile = project.getFile(ICoreConstants.BUILD_FILENAME_DESCRIPTOR);
        buildModel = new WorkspaceBuildModel(buildFile);
        if (buildFile.exists()) {
            buildModel.load();
        }
        return buildModel;
    }

}
