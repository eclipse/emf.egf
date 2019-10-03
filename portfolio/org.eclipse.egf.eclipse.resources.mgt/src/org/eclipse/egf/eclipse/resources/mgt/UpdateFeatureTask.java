/**
 * <copyright>
 * 
 * Copyright (c) 2014 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.eclipse.resources.mgt;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.eclipse.resources.mgt.operation.UpdateFeatureOperation;
import org.eclipse.egf.eclipse.resources.mgt.util.IFeatureConstants;

/** 
 * @author Boubekeur Zendagui
 */

public class UpdateFeatureTask implements ITaskProduction {

	protected final static Object lock = new Object();
	
	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(2, monitor);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
	}
	
	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
	}
	
	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		synchronized (lock) {
			final String featureID = productionContext.getInputValue(IFeatureConstants.CONTRACT_FEATURE_NAME, String.class);
			final String pluginID = productionContext.getInputValue(IFeatureConstants.CONTRACT_PLUGIN_TO_INCLUDE, String.class);
			final String featureToIncludeID = productionContext.getInputValue(IFeatureConstants.CONTRACT_FEATURE_TO_INCLUDE, String.class);

			if (featureID == null || featureID.trim().length() == 0)
				return ;

			WorkspaceJob job = new WorkspaceJob("Adding plugin "+pluginID+" to the feature "+featureID) {
				@Override
				public IStatus runInWorkspace(IProgressMonitor monitor)
				throws CoreException {
					UpdateFeatureOperation operation = new UpdateFeatureOperation(featureID, pluginID, featureToIncludeID) ;
					try {
						operation.run(monitor);
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return Status.OK_STATUS;
				}
			};
			job.setSystem(true);
			job.schedule(2000);
		}
	}

}
