/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.eclipse.build;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Matthieu Helleboid
 * 
 */
public class FileReporter implements PatternExecutionReporter {

	public void executionFinished(String output, PatternContext context) {
	}

	public void loopFinished(String output, String outputWithCallBack,
			PatternContext context, Map<String, Object> parameterValues) {
        String fileNameString = (String) context.getValue("fileName");
        String filePathString = (String) context.getValue("filePath");
		String generationPath = (String) context.getValue("generationPath");

		if (fileNameString == null || filePathString == null || generationPath == null)
			return;

		IPath dirPath = new Path(generationPath).append(filePathString);
		IPath filePath = dirPath.append(fileNameString);

		try {
            if (generationPath.startsWith("platform:/resource/")) 
                handleWorkspaceFile(outputWithCallBack, filePath);
            else {
                handleFile(outputWithCallBack, filePath);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to generate file " + filePath, e); //$NON-NLS-1$
        }
	}

    protected void handleFile(String outputWithCallBack, IPath filePath) throws IOException {
        File fileFile = filePath.toFile();

        if (FileHelper.hasContent(fileFile, outputWithCallBack)) 
        	return;

        if (!fileFile.getParentFile().exists())
            fileFile.getParentFile().mkdirs();
        
        FileWriter fileWriter = new FileWriter(fileFile);
        fileWriter.write(outputWithCallBack);
        fileWriter.close();
    }

	protected void handleWorkspaceFile(String outputWithCallBack, IPath filePath) throws CoreException {
        String projectName = filePath.segment(1);
        IPath projectRelativePath = filePath.removeFirstSegments(2).setDevice(null);
        
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        
        IFile file = project.getFile(projectRelativePath);
        if (FileHelper.hasContent(file.getRawLocation().toFile(), outputWithCallBack))
        	return;

        NullProgressMonitor monitor = new NullProgressMonitor();
        
        if (!project.exists()) 
            project.create(monitor);
        
        if (!project.isOpen())
            project.open(monitor);
        
        for(int i = projectRelativePath.segmentCount() - 1 ; i >= 1 ; i--) {
            IFolder folder = project.getFolder(projectRelativePath.removeLastSegments(i));
            if (!folder.exists())
                folder.create(true, true, monitor);
        }
                
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputWithCallBack.getBytes());
        
        if (!file.exists())
            file.create(inputStream, true, monitor);
        else
            file.setContents(inputStream, true, true, monitor);
    }
}
