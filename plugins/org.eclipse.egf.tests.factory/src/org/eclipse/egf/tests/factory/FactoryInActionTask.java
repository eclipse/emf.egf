/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.tests.factory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.task.AbstractTask;

/**
 * @author Guillaume Brocard
 */
public class FactoryInActionTask extends AbstractTask {
  /**
   * @see org.eclipse.egf.core.task.AbstractTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    // Get context values.
    String pluginId = getPluginId();
    String filePath = getFilePath();
    String fileContent = getFileContent();
    // Preconditions.
    Assert.isNotNull(pluginId);
    Assert.isNotNull(filePath);
    Assert.isNotNull(fileContent);
    // Write file content to workspace.
    FileHelper.writeFile(pluginId + ICommonConstants.SLASH_CHARACTER + filePath, true, fileContent);
    // Refresh project.
    ProjectHelper.refreshProject(ProjectHelper.getProject(pluginId), progressMonitor_p);
    return true;
  }

  /**
   * Get plug-in id.
   * @return
   */
  private String getPluginId() {
    return (String) getContextElementValue("pluginId"); //$NON-NLS-1$
  }

  /**
   * Get file path relative to plug-in.
   * @return
   */
  private String getFilePath() {
    return (String) getContextElementValue("filePath"); //$NON-NLS-1$
  }

  /**
   * Get file content.
   * @return
   */
  private String getFileContent() {
    return (String) getContextElementValue("fileContent"); //$NON-NLS-1$
  }
}