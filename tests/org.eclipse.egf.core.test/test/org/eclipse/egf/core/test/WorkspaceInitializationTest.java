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
import java.net.URL;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.osgi.framework.Bundle;

/**
 * @author Matthieu Helleboid
 * 
 */
public class WorkspaceInitializationTest extends TestCase implements IOverwriteQuery {

    public List<String> _projectNames = new UniqueEList<String>();

    @Override
    protected void setUp() throws Exception {

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot workspaceRoot = workspace.getRoot();

        // Clean previous workspace
        NullProgressMonitor monitor = new NullProgressMonitor();
        for (IProject project : workspaceRoot.getProjects()) {
            project.delete(true, true, monitor);
        }

        // Initialize workspace
        Bundle bundle = EGFCoreTestPlugin.getDefault().getBundle();
        URL resourcesURL = FileLocator.find(bundle, new Path("resources"), Collections.EMPTY_MAP); //$NON-NLS-1$
        URL resourcesFileURL = FileLocator.toFileURL(resourcesURL);
        File resourcesFile = new File(resourcesFileURL.getPath());
        for (File file : resourcesFile.listFiles()) {
            if (file.isDirectory() == false) {
                continue;
            }
            if (new File(file, ".project").exists() == false) { //$NON-NLS-1$
                continue;
            }
            String projectName = file.getName();
            IProject project = workspaceRoot.getProject(projectName);
            IProjectDescription description = workspace.newProjectDescription(projectName);
            description.setLocationURI(null);
            project.create(description, monitor);
            project.open(monitor);
            // import project from location copying files
            // use default project location for this workspace
            List<?> filesToImport = FileSystemStructureProvider.INSTANCE.getChildren(file);
            ImportOperation operation = new ImportOperation(project.getFullPath(), file, FileSystemStructureProvider.INSTANCE, this, filesToImport);
            operation.setContext(null);
            operation.setOverwriteResources(true);
            operation.setCreateContainerStructure(false);
            operation.run(monitor);
            // Store
            _projectNames.add(projectName);
        }

    }

    public String queryOverwrite(String pathString) {
        return IOverwriteQuery.YES;
    }

    public void testProjectsExists() {

        for (String projectName : _projectNames) {
            IProject project = ProjectHelper.getProject(projectName);
            assertNotNull(project);
            assertTrue(project.exists());
            assertTrue(project.isOpen());
        }

    }

}
