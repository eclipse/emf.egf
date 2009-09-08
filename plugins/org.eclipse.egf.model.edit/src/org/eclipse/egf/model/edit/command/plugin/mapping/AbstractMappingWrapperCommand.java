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
package org.eclipse.egf.model.edit.command.plugin.mapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.helper.FactoryComponentHelper;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.mapping.MappingPackage;
import org.eclipse.emf.mapping.ecore2ecore.Ecore2EcoreFactory;
import org.eclipse.emf.mapping.ecore2ecore.Ecore2EcoreMappingRoot;


/**
 * Base class to implement commands that wrap mapping modifications in a mapping extension.
 * @author Guillaume Brocard
 */
public abstract class AbstractMappingWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractMappingWrapperCommand.class.getPackage().getName());

  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AbstractMappingWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    // Get handled mapping.
    MappingModel mapping = getMapping();
    String mappingPath = mapping.getPath();
    // Get the hosting project.
    IProject project = ModelHelper.getProject(getModelElement());
    // handle ecore2ecore file.
    String mappingFileFullPath = getMappingPath(mappingPath, project);
    handleMappingFile(mappingFileFullPath);
    // Refresh the project
    ProjectHelper.refreshProject(project, IResource.DEPTH_INFINITE, new NullProgressMonitor());
    // Return an empty list.
    return new ArrayList<IPluginChangesCommand>(0);
  }

  /**
   * Handle the mapping file for given parameters.
   * @param mappingFileFullPath_p relative path to the workspace.
   */
  protected abstract void handleMappingFile(String mappingFileFullPath_p);

  /**
   * Return the full path relative to the workspace for specified mapping parameters.
   * @param mappingFilePath_p
   * @param project_p
   * @return
   */
  protected String getMappingPath(String mappingFilePath_p, IProject project_p) {
    StringBuilder fullPathBuilder = new StringBuilder(project_p.getFullPath().toString());
    fullPathBuilder.append(ICommonConstants.SLASH_CHARACTER).append(mappingFilePath_p);
    return fullPathBuilder.toString();
  }

  /**
   * Initialize the input or output for specified mapping root.
   * @param mappingRoot_p
   * @param resourcePath_p
   * @param containerReference_p
   * @param resourceSet_p
   */
  @SuppressWarnings("unchecked")
  protected void initializeInputOrOutput(Ecore2EcoreMappingRoot mappingRoot_p, String resourcePath_p, EReference containerReference_p, ResourceSet resourceSet_p) {
    // Load given resource.
    Resource resource = getResource(resourcePath_p, resourceSet_p);
    // Add resource content to the mapping file as input or output depending on given containerReference.
    if (null != resource) {
      List<EObject> references = (List<EObject>) mappingRoot_p.eGet(containerReference_p);
      references.addAll(resource.getContents());
    } else {
      StringBuilder loggerMessage = new StringBuilder("AbstractMappingWrapperCommand.initializeInputOrOutput(..) _ "); //$NON-NLS-1$
      loggerMessage
          .append("Domain resource for factory component id#").append(resourcePath_p).append("used as mapping").append(containerReference_p.getName()).append(" not found!!!"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      __logger.error(loggerMessage.toString());
    }
  }

  /**
   * Get the resource for given parameters.
   * @param fcId_p
   * @param resourceSet_p
   * @return null if domain is not found.
   */
  private Resource getResource(String fcId_p, ResourceSet resourceSet_p) {
    Resource result = null;
    // Get the domain URI.
    URI domainURI = FactoryComponentHelper.getDomainURI(fcId_p);
    if (null != domainURI) {
      result = resourceSet_p.getResource(domainURI, true);
    }
    return result;
  }

  /**
   * Create the mapping file for current mapping model element.
   * @param mappingFileFullPath_p
   */
  protected void createMappingFile(String mappingFileFullPath_p) {
    // Create an ecore2ecore element.
    Ecore2EcoreMappingRoot mappingRoot = Ecore2EcoreFactory.eINSTANCE.createEcore2EcoreMappingRoot();
    mappingRoot.setTopToBottom(true);
    // Create a resource set.
    ResourceSet resourceSet = new ResourceSetImpl();
    MappingModel mappingModelElement = getMapping();
    initializeInputOrOutput(mappingRoot, mappingModelElement.getSource(), MappingPackage.Literals.MAPPING__INPUTS, resourceSet);
    initializeInputOrOutput(mappingRoot, mappingModelElement.getTarget(), MappingPackage.Literals.MAPPING__OUTPUTS, resourceSet);
    // Get the mapping file URI.
    URI mappingFileFullURI = FileHelper.getFileFullUri(mappingFileFullPath_p);
    // Create the resource related to this mapping file ie ecore2ecore file.
    Resource mappingFileResource = resourceSet.createResource(mappingFileFullURI);
    // Add it, the mapping as content.
    mappingFileResource.getContents().add(mappingRoot);
    try {
      // Write the mapping file.
      mappingFileResource.save(null);
    } catch (IOException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("AddMappingWrapperCommand.handleMappingFile(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }

  /**
   * Get the mapping model element.
   * @return
   */
  protected abstract MappingModel getMapping();

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    // Do nothing.
    return null;
  }
}