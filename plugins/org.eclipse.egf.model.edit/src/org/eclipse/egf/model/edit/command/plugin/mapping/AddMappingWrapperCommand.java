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

import java.util.List;

import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IMappingExtensionFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a mapping modification in a mapping extension.
 * @author Guillaume Brocard
 */
public class AddMappingWrapperCommand extends AbstractMappingWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AddMappingWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.mapping.AbstractMappingWrapperCommand#getMapping()
   */
  @Override
  protected MappingModel getMapping() {
    // Get the added mapping.
    MappingModel mapping = (MappingModel) getValue();
    return mapping;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.mapping.AbstractMappingWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    List<IPluginChangesCommand> commands = super.getExecutablePluginChangeCommand();
    IMappingExtensionFactory factory = EgfPdeActivator.getDefault().getMappingExtensionHelper();
    MappingModel mapping = getMapping();
    // Add the command to execute.
    commands.add(factory.setMappingExtension(mapping.getId(), mapping.getName(), mapping.getPath(), mapping.getSource(), mapping.getTarget()));
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.mapping.AbstractMappingWrapperCommand#handleMappingFile(java.lang.String)
   */
  @Override
  protected void handleMappingFile(String mappingFileFullPath_p) {
    createMappingFile(mappingFileFullPath_p);
  }
}