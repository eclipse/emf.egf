/**
 * <copyright>
 * 
 * Copyright (c) 2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.usecase.pattern.uc3.m2treporting.reporter;

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
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Benoit Langlois
 * 
 */

public class OutputInSeveralFilesReporter implements PatternExecutionReporter {

    private static final String PROJECT_NAME = "test"; //$NON-NLS-1$
    private static final String FOLDER_NAME = "Pattern_UC3"; //$NON-NLS-1$
    private static final String FILE_NAME = "hello.txt"; //$NON-NLS-1$


    public void executionFinished(String output, PatternContext context) {
    }

    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
    	EClass patternParameter = (EClass)parameterValues.get("parameter");
    	StringBuffer result = new StringBuffer();
    	
    	result
    		.append(patternParameter.getName())
    		.append (".txt");
    	
        writeContentsInFile(PROJECT_NAME, FOLDER_NAME, result.toString(), output);
    }

	protected void writeContentsInFile(String projectName, String folderName,
			String fileName, String contents) {
		ByteArrayInputStream contentsStream = new ByteArrayInputStream(contents.getBytes());
        try {
            IFile file = getFile(fileName, projectName, folderName);
            if (file.exists())
                file.setContents(contentsStream, true, false, null);
            else
                file.create(contentsStream, true, null);
        } catch (CoreException e) {
            e.printStackTrace();
        }
	}

    /*
     * Get file where output contents is written
     */
    public IFile getFile(String fileName, String projectName, String folderName) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(projectName);

        // build the class resource path
        IPath path = new Path(""); //$NON-NLS-1$

        if (folderName != null && folderName.length()>0) {
	        for (String member : folderName.split("\\.|/|\\\\")) { //$NON-NLS-1$
	            path = path.append(member);
	            IFolder folder = project.getFolder(path);
	            if (!folder.exists())
	                folder.create(true, true, null);
	        }
        }

        path = path.append(fileName);

        return project.getFile(path);
    }

}
