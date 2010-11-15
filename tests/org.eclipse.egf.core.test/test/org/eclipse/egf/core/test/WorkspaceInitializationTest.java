/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.core.test;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

/**
 * @author Matthieu Helleboid
 * 
 */
public class WorkspaceInitializationTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot workspaceRoot = workspace.getRoot();

        NullProgressMonitor monitor = new NullProgressMonitor();
        for (IProject project : workspaceRoot.getProjects())
            project.delete(false, true, monitor);

        Bundle bundle = EGFCoreTestPlugin.getDefault().getBundle();
        URL resourcesURL = FileLocator.find(bundle, new Path("resources"), Collections.EMPTY_MAP); //$NON-NLS-1$
        URL resourcesFileURL = FileLocator.toFileURL(resourcesURL);
        File resourcesFile = new File(resourcesFileURL.getPath());
        for (File file : resourcesFile.listFiles())
            if (new File(file, ".project").exists()) { //$NON-NLS-1$
                IProject project = workspaceRoot.getProject(file.getName());
                IProjectDescription projectDescription = workspace.newProjectDescription(file.getName());
                
                URI uri = new URL(resourcesFileURL, file.getName()).toURI();
                projectDescription.setLocationURI(uri);
                project.create(projectDescription, monitor);
            }
    }

    public void testProjectsExists() {
        assertTrue(ResourcesPlugin.getWorkspace().getRoot().getProjects().length == 3);
    }
}
