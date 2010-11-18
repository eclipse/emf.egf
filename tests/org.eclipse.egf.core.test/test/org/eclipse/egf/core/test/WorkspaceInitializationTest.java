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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.IImportStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.osgi.framework.Bundle;

/**
 * @author Matthieu Helleboid
 * 
 */
public class WorkspaceInitializationTest extends TestCase {

    public List<String> _projectNames = new UniqueEList<String>();

    public static Test suite() {
        return new TestSuite(WorkspaceInitializationTest.class);
    }

    @Override
    protected void setUp() throws Exception {

        // Error
        final Throwable[] error = new Throwable[] {
            null
        };

        // State for thread synchronization
        final boolean[] init = new boolean[] {
            false
        };

        class Import extends ImportOperation {

            public Import(IPath containerPath, Object source, IImportStructureProvider provider, IOverwriteQuery overwriteImplementor, List<?> filesToImport) {
                super(containerPath, source, provider, overwriteImplementor, filesToImport);
            }

            public void process(IProgressMonitor monitor) {
                execute(monitor);
            }

        }

        // Prepare our init job
        class InitJob extends WorkspaceJob implements IOverwriteQuery {

            private Throwable[] _error;

            private boolean[] _init;

            public InitJob(Throwable[] innerError, boolean[] innerInit) {
                super("WorkspaceInitializationTest"); //$NON-NLS-1$
                _error = innerError;
                _init = innerInit;
            }

            public String queryOverwrite(String pathString) {
                return IOverwriteQuery.YES;
            }

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {

                try {

                    IWorkspace workspace = ResourcesPlugin.getWorkspace();
                    IWorkspaceRoot workspaceRoot = workspace.getRoot();

                    // Clean previous workspace
                    for (IProject project : workspaceRoot.getProjects()) {
                        project.delete(true, true, monitor);
                    }

                    try {

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
                            Import operation = new Import(project.getFullPath(), file, FileSystemStructureProvider.INSTANCE, this, filesToImport);
                            operation.setContext(null);
                            operation.setOverwriteResources(true);
                            operation.setCreateContainerStructure(false);
                            operation.process(monitor);
                            // Refresh
                            project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
                            // Store
                            _projectNames.add(projectName);
                        }

                    } catch (Throwable t) {

                        _error[0] = t;

                    }

                    return Status.OK_STATUS;

                } finally {

                    synchronized (_init) {
                        _init[0] = true;
                        _init.notifyAll();
                    }

                }

            }

        }

        // Turn off auto-build
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceDescription description = workspace.getDescription();
        if (description.isAutoBuilding()) {
            description.setAutoBuilding(false);
            workspace.setDescription(description);
        }

        // Lock all the workspace and import resources
        WorkspaceJob initJob = new InitJob(error, init);
        initJob.setRule(workspace.getRuleFactory().buildRule());
        initJob.setPriority(Job.LONG);
        initJob.setUser(true);
        initJob.setSystem(false);
        initJob.schedule();

        // Let the job run
        synchronized (init) {
            while (init[0] == false) {
                try {
                    init.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        // Error checking
        assertNull(error[0]);

        // Build
        workspace.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());

        // Wait for build completion
        Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD, new NullProgressMonitor());

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
