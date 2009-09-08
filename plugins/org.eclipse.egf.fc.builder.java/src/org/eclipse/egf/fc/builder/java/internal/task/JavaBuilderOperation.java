/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.fc.builder.java.internal.task;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ui.actions.WorkspaceModifyOperation;


/**
 * Java project builder operation.
 * @author brocard
 */
public class JavaBuilderOperation extends WorkspaceModifyOperation {
  
  /**
   * Factory component project name.
   */
  private String _fcProjectName;
  
  /**
   * Execution result.
   */
  private boolean _result;
  
  /**
   * Ticks count.
   */
  private int _ticksCount;

  /**
   * Constructor.
   * @param fcProjectName_p
   */
  public JavaBuilderOperation(String fcProjectName_p) {
    _fcProjectName = fcProjectName_p;
  }

  /**
   * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected void execute(IProgressMonitor monitor_p) throws CoreException, InvocationTargetException, InterruptedException {
    // Retrieve java project from its name.
    monitor_p.subTask(Messages.JavaBuilderOperation_ProgressReporting_GetJavaProject);
    IJavaProject javaProject = ProjectHelper.getJavaProject(_fcProjectName);
    monitor_p.worked((int) (_ticksCount * 0.1f));
    // Get its project, and compile it.
    monitor_p.subTask(Messages.JavaBuilderOperation_ProgressReporting_GetProject);
    IProject project = javaProject.getProject();
    monitor_p.worked((int) (_ticksCount * 0.1f));
    // Launch incremental build.
    monitor_p.subTask(Messages.JavaBuilderOperation_ProgressReporting_BuildProject);
    project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, monitor_p);
    monitor_p.worked((int) (_ticksCount * 0.8f));
    _result = true;
  }

  /**
   * Get execution result.
   * @return true if successfully executed, false otherwise.
   */
  public boolean getResult() {
    return _result;
  }

  /**
   * @param ticksCount_p
   */
  public void setTicksCount(int ticksCount_p) {
    _ticksCount = ticksCount_p;
  }
  
}
