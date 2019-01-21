/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.eclipse.build.ui.deploy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.portfolio.eclipse.build.DeploymentHelper;

/**
 * @author Matthieu Helleboid
 *
 */
public class PullAction extends DeployAction {

	@Override
	protected void doRun(String serverUrl, String jobName, IFile configFile) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append("config.");
        builder.append(new SimpleDateFormat("yyyyMMdd-HHmm").format(new Date()));
		builder.append(".xml");

		IContainer folder = configFile.getParent();
		IPath folderPath = folder.getRawLocation();
		File newConfigFile = new File(folderPath.toFile(), builder.toString());
		
		new DeploymentHelper(serverUrl).pullConfig(newConfigFile, jobName);
		folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
	}

	@Override
	protected String getActionName() {
		return "Pull"; //$NON-NLS-1$
	}
}
