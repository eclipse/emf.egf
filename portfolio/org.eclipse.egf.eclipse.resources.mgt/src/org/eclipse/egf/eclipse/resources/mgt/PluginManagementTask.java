/**
 * <copyright>
 * 
 * Copyright (c) 2016 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.eclipse.resources.mgt;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.ui.util.ModelModification;
import org.eclipse.pde.internal.ui.util.PDEModelUtility;

/**
 * 
 * @author Guillaume Gebhart
 *
 */
public class PluginManagementTask implements ITaskProduction {
	/**
	 * Contract tags used in the FC.
	 */
	private static final String CONTRACT_PLUGIN_ID_TAG = "plugin_id"; //$NON-NLS-1$
	private static final String CONTRACT_PLUGIN_ID_SUFFIX_TAG = "plugin_id_suffix"; //$NON-NLS-1$
	private static final String CONTRACT_PLUGIN_VERSION_TAG = "plugin_version"; //$NON-NLS-1$
	private static final Path METAFEST_PATH = new Path("/META-INF/MANIFEST.MF"); //$NON-NLS-1$

	@SuppressWarnings("restriction")
	public void doExecute(ITaskProductionContext arg0, IProgressMonitor arg1) throws InvocationException {
		String plugin_id = arg0.getInputValue(CONTRACT_PLUGIN_ID_TAG, String.class);
		String plugin_id_suffix = arg0.getInputValue(CONTRACT_PLUGIN_ID_SUFFIX_TAG, String.class);
		final String plugin_version = arg0.getInputValue(CONTRACT_PLUGIN_VERSION_TAG, String.class);

		final String plugin_name = plugin_id + ((plugin_id_suffix != null) ? plugin_id_suffix : ""); //$NON-NLS-1$;

		IProject pdeProject = ResourcesPlugin.getWorkspace().getRoot().getProject(plugin_name);

		if (pdeProject.exists()) 
		{
			IFile manifestFile = pdeProject.getFile(METAFEST_PATH);
			
			PDEModelUtility.modifyModel(new ModelModification(manifestFile) {
				@Override
				protected void modifyModel(IBaseModel model, IProgressMonitor innerMonitor) throws CoreException {
					((IBundlePluginModelBase) model).getPluginBase().setVersion(plugin_version);
				}
			}, arg1);

		}
	}

	public void postExecute(ITaskProductionContext arg0, IProgressMonitor arg1)
			throws InvocationException {

	}

	public void preExecute(ITaskProductionContext arg0, IProgressMonitor arg1)
			throws InvocationException {

	}

}
