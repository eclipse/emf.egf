/**
 * <copyright>
 * 
 * Copyright (c) 2014 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.eclipse.resources.mgt.operation;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.feature.FeatureChild;
import org.eclipse.pde.internal.core.feature.FeaturePlugin;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureChild;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.pde.internal.core.util.CoreUtility;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.egf.eclipse.resources.mgt.util.EclipseModelsAccessor;

/**
 * @author Boubekeur Zendagui
 */

@SuppressWarnings("restriction")
public class UpdateFeatureOperation extends WorkspaceModifyOperation{

	private String _featureID; 
	private String _pluginID; 
	private String _featureToIncludeID;
	private final String DEFAULT_VERSION = "0.0.0"; //$NON-NLS-1$
	
	public UpdateFeatureOperation(String featureID, String pluginID, String featureToIncludeID) {
		super();
		_featureID = featureID; 
		_pluginID = pluginID; 
		_featureToIncludeID = featureToIncludeID;
	}
	
	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		Assert.isNotNull(_featureID, "Feature ID must be not null");
		Assert.isTrue(!( _featureID != null && _featureID.trim().length() == 0) , "Feature ID must be not empty");
		
		IProject fProject = ResourcesPlugin.getWorkspace().getRoot().getProject(_featureID);
		fProject.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
		IFile file = PDEProject.getFeatureXml(fProject);
		WorkspaceFeatureModel model = new WorkspaceFeatureModel(file);
		model.load();
		// check if the feature model is ok
		IFeature feature = model.getFeature();
		if (feature == null)
			return;

		if (_pluginID != null && _pluginID.length() != 0)
			addPlugin(feature, _pluginID);

		if (_featureToIncludeID != null && _featureToIncludeID.length() != 0)
			addFeature(feature, _featureToIncludeID);

		model.save();
		model.dispose();
	}
	
	private void addPlugin(IFeature feature, String pName) {
		try {
			IPluginModelBase[] pluginList = { EclipseModelsAccessor.getPluginModelBase(pName) };
			addPlugins(feature, pluginList);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	private void addPlugins(IFeature feature, IPluginModelBase[] candidates) throws CoreException{
		IFeatureModel model = feature.getModel();
		IFeaturePlugin[] candidate_plugin = new IFeaturePlugin[candidates.length];
		for (int i = 0; i < candidates.length; i++) {
			IPluginModelBase candidate = candidates[i];		
			FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
			fplugin.loadFrom(candidate.getPluginBase());
//			fplugin.setVersion(candidate.getPluginBase().getVersion()); //$NON-NLS-1$
			fplugin.setVersion(DEFAULT_VERSION);
			fplugin.setUnpack(CoreUtility.guessUnpack(candidate.getBundleDescription()));
			candidate_plugin[i] = fplugin;
		}
		
		// Merge of plug-in [New]
		IFeaturePlugin[] plugin_to_add = {};
		IFeaturePlugin[] existing_plugin = feature.getPlugins();
		
		for (int i = 0; i < candidate_plugin.length; i++) 
		{
			boolean add = true;
			for (IFeaturePlugin iFeaturePlugin : existing_plugin) 
			{
				if (iFeaturePlugin.getId().equals(candidate_plugin[i].getId()))
				{
					add = false;
					break;
				}
			}
			if (add)
			{
				IFeaturePlugin[] temp_plugin_to_add = new IFeaturePlugin[plugin_to_add.length+1];
				System.arraycopy(plugin_to_add, 0, temp_plugin_to_add, 0, plugin_to_add.length);
				temp_plugin_to_add[plugin_to_add.length] = candidate_plugin[i];
				plugin_to_add = new IFeaturePlugin[temp_plugin_to_add.length];
				System.arraycopy(temp_plugin_to_add, 0, plugin_to_add, 0, plugin_to_add.length);
			}
		}
		feature.addPlugins(plugin_to_add);
	}
	
	private void addFeature(IFeature feature, String fname){
		try {
			IFeature[] featureToAdd = { EclipseModelsAccessor.getFeature(fname)};
			addFeatures(feature, featureToAdd);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	private void addFeatures(IFeature feature, IFeature[] candidates) throws CoreException{
		IFeatureModel model = feature.getModel();
		IFeatureChild[] added = new IFeatureChild[candidates.length];
		for (int i = 0; i < candidates.length; i++) {
			IFeature candidate = candidates[i];
			FeatureChild featureChild = (FeatureChild)model.getFactory().createChild();
			featureChild.loadFrom(candidate);
//			featureChild.setVersion(candidate.getVersion()); //$NON-NLS-1$
			featureChild.setVersion(DEFAULT_VERSION);
			added[i] = featureChild;
		}
		feature.addIncludedFeatures(added);
	}

}
