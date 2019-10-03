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
