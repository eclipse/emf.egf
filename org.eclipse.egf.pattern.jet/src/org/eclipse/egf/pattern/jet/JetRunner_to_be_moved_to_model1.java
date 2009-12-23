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

package org.eclipse.egf.pattern.jet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternUnit;
import org.eclipse.egf.pattern.FileHelper_to_be_upgraded;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.Registry_to_be_upgraded;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jet.JETSkeleton;

/**
 * @author Guiu
 *
 *	Temp class ...
 */
public class JetRunner_to_be_moved_to_model1 extends Runner_to_be_moved_to_model{

	public void run() {
		if (getPattern() == null)
			throw new IllegalStateException();
	}

	public void translate() {
		if (getPattern() == null)
			throw new IllegalStateException();
		
		//**************************************************************************
		// 1 - put together all pt files
		PatternHelper helper = new JetPatternHelper(getPattern());
		String templatecontent = helper.visit();
		// 2 - compile the result
		String templateURI = "uri_test";
		try {
			JETCompiler compiler = new JETCompiler(templateURI, new ByteArrayInputStream(templatecontent.getBytes()), JetPreferences.getEncoding());
			compiler.parse();
		    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		    compiler.generate(outStream);
		    IPath outputPath = getClassFilePath(compiler.getSkeleton());
		    FileHelper_to_be_upgraded.setContent(Registry_to_be_upgraded.getProjectName(getPattern()), outputPath, new ByteArrayInputStream(outStream.toByteArray()));

		} catch (CoreException e) {
			Activator.getDefault().logError(e);
			
		} catch (JETException e) {
			Activator.getDefault().logError(e);
			
		}
		//**************************************************************************
	}

	private IPath getClassFilePath(JETSkeleton skeleton) {
		IPath result = new Path(JetPreferences.getGenerationFolderName());
		String packageName = skeleton.getPackageName();
		if (packageName != null && !"".equals(packageName))
		{
			String[] names = packageName.split("\\.");
			for( String name: names)
			{
				result = result.append(name);
			}
		}
		result = result.append(skeleton.getClassName()).addFileExtension("java");
		return result;
	}



}
