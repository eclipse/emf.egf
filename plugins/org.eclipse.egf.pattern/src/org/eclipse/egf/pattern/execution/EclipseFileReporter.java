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

package org.eclipse.egf.pattern.execution;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.emf.common.util.URI;

/**
 * @author Matthieu Helleboid
 * 
 */
public abstract class EclipseFileReporter implements PatternExecutionReporter {

    protected void writeOutput(String output, URI targetDirectoryURI, URI targetFileURI) {
        String targetDirectory = targetDirectoryURI.toString();
        String targetFile = targetFileURI.toString();

        writeOutput(output, targetDirectory, targetFile);
    }

    protected void writeOutput(String output, String targetDirectory, String targetFile) {
        NullProgressMonitor monitor = new NullProgressMonitor();

        try {
            ensureContainerExists(targetDirectory, monitor);

            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(targetFile));
            if (file.exists())
                file.delete(true, monitor);
            file.create(new ByteArrayInputStream(output.getBytes()), true, monitor);
        } catch (Exception exception) {
            EGFPatternPlugin.getDefault().logError(exception);
        }
    }

    /**
     * see AbstractGeneratorAdapter.EclipseHelper
     * 
     * @param monitor
     * @throws CoreException
     */
    protected static boolean ensureContainerExists(String workspacePath, NullProgressMonitor monitor) throws CoreException {
        IPath path = new Path(workspacePath);
        IContainer container = null;

        if (path.isAbsolute()) {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IProject project = workspace.getRoot().getProject(path.segment(0));
            if (!project.exists()) {
                project.create(monitor);
            }

            if (project.exists()) {
                if (!project.isOpen()) {
                    project.open(monitor);
                }

                container = project;
                for (int i = 1, length = path.segmentCount(); i < length; i++) {
                    IFolder folder = container.getFolder(new Path(path.segment(i)));
                    if (!folder.exists()) {
                        folder.create(false, true, monitor);
                    }
                    container = folder;
                }
            }
        }

        return container != null && container.getFullPath().equals(path);
    }

}
