/**
 * <copyright>
 * 
 * Copyright (c) 2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.usecase.emf.uc3;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.portfolio.file.resources.EGFFileResourcesActivator;
import org.eclipse.egf.portfolio.file.resources.FileUtil;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;

/**
 * @author Benoit Langlois
 * 
 */

public class CreateEmfInfoFileTask  implements ITaskProduction {

	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		// TODO Auto-generated method stub

	}

	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {

		StringBuffer result = new StringBuffer();

		EMFDomain domain = (EMFDomain) productionContext.getInputValue("domain", EMFDomain.class); //$NON-NLS-1$
		String APIType = productionContext.getInputValue("APIType", String.class).toLowerCase(); //$NON-NLS-1$
		String contents = productionContext.getInputValue("contents", String.class); //$NON-NLS-1$
		String folder = productionContext.getInputValue("folder", String.class); //$NON-NLS-1$
		String fileName = productionContext.getInputValue("fileName", String.class); //$NON-NLS-1$

		GenModel genmodel = (GenModel) domain.getContent().get(0);
		String projectName = getPluginId (genmodel, APIType);

		result
		.append(contents)
		.append("\n")
		.append(getEmfInfo (genmodel, APIType));

		writeInFile(monitor, result, folder, fileName, projectName);
	}

	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		// TODO Auto-generated method stub

	}

	private String getEmfInfo (GenModel genmodel, String APIType) {

		StringBuffer result = new StringBuffer();

		result
		.append("Model name: ")
		.append(genmodel.getModelName())
		.append("\n\n")
		.append("Compliance level: ")
		.append(genmodel.getComplianceLevel().toString())
		.append("\n")
		.append("Runtime platform: ")
//		.append(genmodel.getRuntimePlatform())
//		.append("\n")
		.append("Runtime version: ")
		.append(genmodel.getRuntimeVersion())
		.append("\n\n");

		if ("model".equals(APIType)) {
			result
			.append("Model directory: ")
			.append(genmodel.getModelDirectory())
			.append("\n")
			.append("Root extends class: ")
			.append(genmodel.getRootExtendsClass())
			.append("\n")
			.append("Root extends interface: ")
			.append(genmodel.getRootExtendsInterface())
			.append("\n");
		}
		if ("edit".equals(APIType)) {
			result
			.append("Edit directory: ")
			.append(genmodel.getEditDirectory())
			.append("\n");
		}

		if ("editor".equals(APIType)) {
			result
			.append("Editor directory: ")
			.append(genmodel.getEditorDirectory())
			.append("\n");
		}
		
		return result.toString();
	}

	private String getPluginId (GenModel genmodel, String APIType) {

		if ("model".equals(APIType)) {
			return genmodel.getModelPluginID();
		}
		if ("edit".equals(APIType)) {
			return genmodel.getEditPluginID();
		}

		if ("editor".equals(APIType)) {
			return genmodel.getEditorPluginID();
		}
		return genmodel.getModelPluginID();
	}

	private void writeInFile(IProgressMonitor monitor, StringBuffer result,
			String folder, String fileName, String projectName)
			throws InvocationException {
		ByteArrayInputStream fileContents = new ByteArrayInputStream(result.toString().getBytes());
		try {
			IFile file = FileUtil.getNewFile(projectName, folder, fileName);
			if (file.exists()) {
				file.setContents(fileContents, true, false, monitor);
			} else {
				FileHelper.createContainers(monitor, file);
				file.create(fileContents, true, monitor);
			}
		} catch (Throwable t) {
			if (t instanceof CoreException) {
				throw new InvocationException(t);
			}
			throw new InvocationException(new CoreException(EGFFileResourcesActivator.getDefault().newStatus(IStatus.ERROR, "Unexpected Exception", t))); //$NON-NLS-1$
		}
	}

}
