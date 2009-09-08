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
package org.eclipse.egf.tests.pattern;

import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.egf.pattern.execution.IPatternExecutionReporter;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Guillaume Brocard
 */
public class TestExecutionReporter implements IPatternExecutionReporter {
  /**
   * @see org.eclipse.egf.pattern.execution.IPatternExecutionReporter#patternExecutionFinished(java.lang.String, java.lang.String,
   *      org.eclipse.egf.core.context.ProductionContext)
   */
  public void patternExecutionFinished(String output_p, String patternFullId_p, ProductionContext context_p) {
    // Get context values.
    // Id factoryComponent.1233238712534.8 refers to current FC.
    String fcId = "factoryComponent.1233238712534.8"; //$NON-NLS-1$
    String pluginId = (String) context_p.getContextElementValue("pluginId", fcId); //$NON-NLS-1$
    String filePath = (String) context_p.getContextElementValue("filePath", fcId); //$NON-NLS-1$
    // Preconditions.
    Assert.isNotNull(pluginId);
    Assert.isNotNull(filePath);
    // Write file content to workspace.
    FileHelper.writeFile(pluginId + ICommonConstants.SLASH_CHARACTER + filePath, true, output_p);
    // Refresh project.
    ProjectHelper.refreshProject(ProjectHelper.getProject(pluginId), new NullProgressMonitor());
  }

  /**
   * @see org.eclipse.egf.pattern.execution.IPatternExecutionReporter#patternLoopExecutionFinished(java.lang.String, java.lang.String,
   *      org.eclipse.egf.core.context.ProductionContext, java.util.Map)
   */
  public void patternLoopExecutionFinished(String output_p, String patternFullId_p, ProductionContext context_p, Map<String, EObject> tuple_p) {
    // Nothing to do here.
  }
}