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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
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

		IPath dirPath = new Path(generationPath);
		dirPath = dirPath.append(filePathString);

		File dirFile = dirPath.toFile();
		if (!dirFile.exists())
			dirFile.mkdirs();

		IPath filePath = dirPath.append(fileNameString);
		
		try {
			FileWriter fileWriter = new FileWriter(filePath.toFile());
			fileWriter.write(outputWithCallBack);
			fileWriter.close();
		} catch (IOException e) {
			throw new RuntimeException("Unable to generate file " + filePath, e); //$NON-NLS-1$
		}
	}

}
