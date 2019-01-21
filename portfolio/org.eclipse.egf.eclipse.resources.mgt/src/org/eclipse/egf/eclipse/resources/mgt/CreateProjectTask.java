/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CreateProjectTask implements ITaskProduction {

  private IProject project;

  public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    if (!project.exists()) {
      try {
        project.create(monitor);
      } catch (CoreException e) {
        Activator.getDefault().logError(e);
      }
    }
    if (project.exists()) {
      if (!project.isOpen()) {
        try {
          project.open(monitor);
        } catch (CoreException e) {
          Activator.getDefault().logError(e);
        }
      }

      productionContext.setOutputValue("path", project.getLocation().toOSString()); //$NON-NLS-1$
    }
  }

  public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
  }

  public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    String name = productionContext.getInputValue("name", String.class); //$NON-NLS-1$
    project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
  }

}
