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

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a domain modification in factoryComponent extension.<br>
 * This command handles domain ecore file creation.
 * @author fournier
 */
public class SetDomainWrapperCommand extends AbstractDomainWrapperCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetDomainWrapperCommand.class.getPackage().getName());
  /**
   * Root package name in created domain ecore file.
   */
  private String _rootPackage;

  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public SetDomainWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.domain.AbstractDomainWrapperCommand#handleDomainFile(java.lang.String)
   */
  @Override
  protected void handleDomainFile(String workspaceRelativeDomainPath_p) {
    // If the root package is null or empty, the domain was not created but browsed.
    // Hence, it is not necessary to create the .ecore file.
    if ((null != _rootPackage) && (_rootPackage.length() > 0)) {
      // Create the file on disk.
      createDomainEcoreFile(workspaceRelativeDomainPath_p, _rootPackage);
    }
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.domain.AbstractDomainWrapperCommand#getRelativeToProjectDomainPath()
   */
  @Override
  protected String getRelativeToProjectDomainPath() {
    return ((Domain) getModelElement()).getPath();
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    // Do nothing.
    return null;
  }

  /**
   * Set the root package used in created domain ecore file.
   * @param packageName_p
   */
  public void setRootPackageForDomain(String packageName_p) {
    _rootPackage = packageName_p;
  }

  /**
   * Create an empty ecore file for given path and root package name.
   * @param workspaceRelativeFilePath_p
   * @param packageName_p
   */
  private void createDomainEcoreFile(String workspaceRelativeFilePath_p, String packageName_p) {
    // Create package that contains the newly created pattern.
    EPackage container = EcoreFactory.eINSTANCE.createEPackage();
    container.setName(packageName_p);
    container.setNsPrefix(container.getName());
    // Prefix the namespace uri with factory component factory name to prevent from getting 2 meta-models with the same uri.
    // Because at generation time, the namespace uri map is used to retrieve model.
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(getModelElement());
    String prefix = fcContainer.getName().toLowerCase();
    // TODO Stephane : faire une m�thode pour filtrer les caract�res ill�gitimes.
    prefix = prefix.replace(ICommonConstants.WHITE_SPACE_CHARACTER, ICommonConstants.DOT_CHARACTER);
    container.setNsURI(prefix + ICommonConstants.DOT_CHARACTER + container.getNsPrefix());
    // Write empty domain ecore file.
    try {
      // Create resource set.
      ResourceSet resourceSet = new ResourceSetImpl();
      // Write ecore file.
      URI domainEcoreFileUri = FileHelper.getFileFullUri(workspaceRelativeFilePath_p);
      // Create associated resource.
      Resource domainResource = resourceSet.createResource(domainEcoreFileUri);
      domainResource.getContents().add(container);
      domainResource.save(null);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("SetDomainWrapperCommand.createDomainEcoreFile(..) _ "); //$NON-NLS-1$
      __logger.error(loggerMessage.toString(), exception_p);
    }
  }
}
