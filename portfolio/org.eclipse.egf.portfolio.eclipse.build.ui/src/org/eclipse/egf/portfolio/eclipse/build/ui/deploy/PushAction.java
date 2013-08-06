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

package org.eclipse.egf.portfolio.eclipse.build.ui.deploy;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.portfolio.eclipse.build.DeploymentHelper;


/**
 * @author Matthieu Helleboid
 * 
 */
public class PushAction extends DeployAction {

	@Override
	protected void doRun(String serverUrl, String jobName, IFile configFile) throws Exception {
		new DeploymentHelper(serverUrl).pushConfig(configFile.getRawLocation().toFile(), jobName);
	}

	@Override
	protected String getActionName() {
		return "Push"; //$NON-NLS-1$
	}

}
