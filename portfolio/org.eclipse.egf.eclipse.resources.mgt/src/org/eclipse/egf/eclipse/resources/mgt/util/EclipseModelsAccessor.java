/**
 * <copyright>
 * 
 * Copyright (c) 2014 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.eclipse.resources.mgt.util;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;

/**
 * This class allows to get Eclipse Feature and plugin models by using their name.
 * @author Boubekeur Zendagui
 */

@SuppressWarnings("restriction")
public class EclipseModelsAccessor {

	private static final String _DEFAULT_VERSION = "0.0.0";
	
	/**
	 * @param featureID the name of the feature project
	 * @return an {@link IFeature} object of the feature with name is equals to featureID 
	 */
	public static IFeature getFeature(String featureID) {
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(2, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		for (IFeatureModel iFeatureModel : PDECore.getDefault().getFeatureModelManager().getModels()) 
			if (iFeatureModel.getFeature().getId().equals(featureID))
				return iFeatureModel.getFeature() ;

		return null;
	}
	
	/**
	 * @param featureID the name of the feature project
	 * @return the feature version
	 */
	public static String getFeatureVersion(String featureID){
		IFeature feature;
			feature = getFeature(featureID);
		if (feature != null)
			return feature.getVersion();
		else
			return _DEFAULT_VERSION;
	}
	
	/**
	 * @param pluginID the name of the plugin project
	 * @return an {@link IPluginModelBase} object of the plugin with name is equals to pluginID
	 */
	public static IPluginModelBase getPluginModelBase(String pluginID){
		Assert.isNotNull(pluginID, "Plugin ID must be not null");
		Assert.isTrue(!(pluginID != null && pluginID.trim().length() == 0), "Plugin ID must be not empty");
		IPluginModelBase pluginModelBase = PluginRegistry.findModel(pluginID);
		if ( pluginModelBase != null)
			return pluginModelBase;
		
		/**
		 * Wait for one second; Maybe the project is in the workspace and :
		 * 	1- is under conversion to plug-in
		 * 	2- is not yet registered in the PluginRegistry
		 */
		int i=0;
		while (pluginModelBase == null){
			pluginModelBase = PluginRegistry.findModel(pluginID);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			i++;
			if (i > 10)
				break;
		}
		
		if (pluginModelBase != null)
			return pluginModelBase;
		else
			throw new RuntimeException("Plugin with ID " + pluginID + "was not fount in the workspace and platform");
		
	}
	
	/**
	 * @param pluginID the name of the plugin project
	 * @return the plugin version
	 */
	public static String getPluginVersion(String pluginID){
		IPluginModelBase model = getPluginModelBase(pluginID);
		if (model != null)
			return model.getPluginBase().getVersion();
		else
			return _DEFAULT_VERSION;
	}
	
}
