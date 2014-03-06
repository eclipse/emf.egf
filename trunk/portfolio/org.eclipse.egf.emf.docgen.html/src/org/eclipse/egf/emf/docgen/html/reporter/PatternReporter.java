/**
 * <copyright>
 * 
 * Copyright (c) 2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.docgen.html.reporter;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.emf.docgen.html.util.EmfHtmlDocGenConstants;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * @author Benoit Langlois
 * 
 */

public class PatternReporter implements PatternExecutionReporter {

    private static final String HTML_FILE_EXTENSION = EmfHtmlDocGenConstants.HTML_FILE_EXTENSION;
    private static final String PROJECT_NAME_CONTRACT = "projectName"; //$NON-NLS-1$
    private static final String OUTPUT_FOLDER_CONTRACT = "outputFolder"; //$NON-NLS-1$
    private static final String ELEMENT_PATTERN_PARAMETER = "element"; //$NON-NLS-1$

    public void executionFinished(String output, PatternContext context) {
    }

    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {

        // Get Task parameters
        String projectName = (String) context.getValue(PROJECT_NAME_CONTRACT);
        String outputFolder = (String) context.getValue(OUTPUT_FOLDER_CONTRACT);
        ENamedElement anENamedElement = (ENamedElement) parameterValues.get(ELEMENT_PATTERN_PARAMETER);

        // Write pattern output contents in file for a loop instance (e.g.,
        // EClass, EPackage)
        ByteArrayInputStream outputContent = new ByteArrayInputStream(output.getBytes());
        try {
            IFile file = getFile(anENamedElement, projectName, outputFolder);
            if (file.exists())
                file.setContents(outputContent, true, false, null);
            else
                file.create(outputContent, true, null);
        } catch (CoreException e) {
            e.printStackTrace();
        }

    }

    /*
     * Get file where output contents is written
     */
    public IFile getFile(ENamedElement anENamedElement, String projectName, String outputFolder) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(projectName);

        // build the class resource path
        IPath path = new Path(""); //$NON-NLS-1$

        for (String member : outputFolder.split("\\.|/|\\\\")) { //$NON-NLS-1$
            path = path.append(member);
            IFolder folder = project.getFolder(path);
            if (!folder.exists())
                folder.create(true, true, null);
        }

        path = path.append(anENamedElement.getName() + anENamedElement.eClass().getName());
        path = path.addFileExtension(HTML_FILE_EXTENSION);

        return project.getFile(path);
    }

}
