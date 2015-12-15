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

package org.eclipse.egf.portfolio.ant.javadoc;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Matthieu Helleboid
 *
 */
public class GenModelToJavadoc implements ITaskProduction {

	public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
	}

	public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		EMFDomain genmodelDomain = productionContext.getInputValue("genModel", EMFDomain.class); //$NON-NLS-1$
		ResourceSet targetPlatformResourceSet = new EgfResourceSet();
		Resource genModelResource = targetPlatformResourceSet.getResource(genmodelDomain.getUri(), true);
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);

		ArrayList<String> inputFolderPaths = new ArrayList<String>();
		inputFolderPaths.add(genModel.getModelDirectory());
		inputFolderPaths.add(genModel.getEditDirectory());
		inputFolderPaths.add(genModel.getEditorDirectory());
		inputFolderPaths.add(genModel.getTestsDirectory());

		StringBuilder buffer = new StringBuilder();
		for (String inputFolderPath : inputFolderPaths) {
			if (buffer.length() > 0)
				buffer.append(","); //$NON-NLS-1$
			buffer.append(inputFolderPath);
		}

		productionContext.setOutputValue("inputFolderPaths", buffer.toString());
		productionContext.setOutputValue("outputProjectName", genModel.getModelPluginID() + ".doc");
		productionContext.setOutputValue("outputFolderName", "javadoc");
	}

	public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
	}

}
