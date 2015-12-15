/**
 * Copyright (c) 2015 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.platform.uri;

import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;

/**
 * @author Thomas Guiu
 */
public class EgfURIConverter extends ExtensibleURIConverterImpl {

	public EgfURIConverter() {
		initURIMap();
		PDECore.getDefault().getModelManager().addPluginModelListener(new IPluginModelListener() {

			public void modelsChanged(PluginModelDelta delta) {
				getURIMap().clear();
				initURIMap();
			}
		});
	}

	private void initURIMap() {

		for (IPluginModelBase workspaceModel : PluginRegistry.getWorkspaceModels()) {
			String bundleId = BundleHelper.getBundleId(workspaceModel);
			if (bundleId == null)
				continue;

			if (workspaceModel.getUnderlyingResource() != null) {
				getURIMap().put(URI.createPlatformPluginURI(bundleId + "/", false), URI.createPlatformResourceURI(bundleId + "/", false));
			}
		}

	}

}
