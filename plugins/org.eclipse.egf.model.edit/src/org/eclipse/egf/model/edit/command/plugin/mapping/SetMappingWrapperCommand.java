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

import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.ModelPackage;
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
public class SetMappingWrapperCommand extends AbstractMappingWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public SetMappingWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.mapping.AbstractMappingWrapperCommand#getMapping()
   */
  @Override
  protected MappingModel getMapping() {
    // Get the modified mapping.
    MappingModel mapping = (MappingModel) getModelElement();
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
    if (ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__ID == getFeature()) {
      String previousMappingId = (String) getValue(); // It's weird but getting the new value means get the previous mapping id. Have a look in
      // MappingModelItemProvider.createSetCommand(..) for details.
      commands.add(factory.unsetMappingExtension(previousMappingId));
    }
    // Add the command to execute.
    commands.add(factory.setMappingExtension(mapping.getId(), mapping.getName(), mapping.getPath(), mapping.getSource(), mapping.getTarget()));
    return commands;
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.mapping.AbstractMappingWrapperCommand#handleMappingFile(java.lang.String)
   */
  @Override
  protected void handleMappingFile(String mappingFileFullPath_p) {
    // Remove the previous file if related feature is the mapping name.
    if (ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME == getFeature()) {
      String previousName = (String) getValue(); // It's weird but getting the new value means get the previous mapping name.
      // Have a look in MappingModelItemProvider.createSetCommand(..) for details.
      // Compute the previous name from the new mapping name.
      String mappingFileExtension = FileHelper.getFileExtension(mappingFileFullPath_p);
      String previousFileName = new Path(mappingFileFullPath_p).removeFileExtension().removeLastSegments(1).append(previousName) // Removing the last segment
          // means the file name
          .addFileExtension(mappingFileExtension).toString();
      FileHelper.deleteFile(previousFileName);
    }
    // Finally, override the mapping file with the new content.
    createMappingFile(mappingFileFullPath_p);
  }
}