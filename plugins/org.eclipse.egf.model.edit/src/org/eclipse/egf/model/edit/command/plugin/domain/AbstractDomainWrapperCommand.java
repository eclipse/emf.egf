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
package org.eclipse.egf.model.edit.command.plugin.domain;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.fc.SetFactoryComponentWrapperCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Base class to implement command that wrap a domain modification in factoryComponent extension.
 * @author fournier
 */
public abstract class AbstractDomainWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AbstractDomainWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * Handle domain file for instance : either create or delete the file.
   * @param workspaceRelativeDomainPath_p
   */
  protected abstract void handleDomainFile(String workspaceRelativeDomainPath_p);

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    // Get the hosting project.
    IProject project = ModelHelper.getProject(getModelElement());
    // Create or replace existing domain file.
    String domainPath = getDomainPath(project);
    // Handle domain file.
    handleDomainFile(domainPath);
    // Refresh the project
    ProjectHelper.refreshProject(project, IResource.DEPTH_INFINITE, new NullProgressMonitor());
    // Modify factoryComponent extension.
    Domain domain_l = (Domain) getModelElement();
    FactoryComponent fc = ModelHelper.getFactoryComponentContainer(domain_l);
    SetFactoryComponentWrapperCommand fcWrapperCmd = new SetFactoryComponentWrapperCommand(getDomain(), fc, ModelPackage.Literals.FACTORY_COMPONENT__DOMAIN, domain_l);
    return fcWrapperCmd.getExecutablePluginChangeCommand();
  }

  /**
   * Get the domain relative domain path to the workspace.
   * @return
   */
  protected String getDomainPath(IProject project_p) {
    // Build with the project path.
    StringBuilder workspaceRelativeDomainPath = new StringBuilder(project_p.getFullPath().toString());
    // Append the domain path.
    workspaceRelativeDomainPath.append(ICommonConstants.SLASH_CHARACTER).append(getRelativeToProjectDomainPath());
    return workspaceRelativeDomainPath.toString();
  }

  /**
   * Return the relative path to project for managed domain.
   * @return
   */
  protected abstract String getRelativeToProjectDomainPath();
}
