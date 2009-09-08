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
package org.eclipse.egf.pde.internal.reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.extensionpoint.IMappingConstants;
import org.eclipse.egf.core.reader.descriptor.MappingDescriptor;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Operation to read mappings in a plug-in in the workspace.
 * @author Guillaume Brocard
 */
public class CreateMappingDescriptorOperation extends CreateDescriptorOperation {

  /**
   * Constructor.
   * @param modelFile_p
   */
  public CreateMappingDescriptorOperation(IFile modelFile_p) {
    super(modelFile_p);
  }

  /**
   * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  @Override
  protected IDescriptor createDescriptor(IPluginModelBase model_p) {
    MappingDescriptor result = new MappingDescriptor();
    IPluginElement[] pluginElements =
                                      getExtensionWithNodeName(model_p, IMappingConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID,
                                                               IMappingConstants.MAPPING_EXTENSION_CHILD);
    // Loop over every plug-in element related to a mapping.
    for (IPluginElement pluginElement : pluginElements) {
      // Create a generic descriptor to store mapping data.
      MappingDescriptor currentMappingDescriptor = new MappingDescriptor();
      // Set the id.
      currentMappingDescriptor.setValue(ExtensionPointHelper.ATT_ID, getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_ID));
      // Set the name.
      currentMappingDescriptor.setValue(ExtensionPointHelper.ATT_NAME, getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_NAME));
      // Set the path.
      currentMappingDescriptor.setValue(IMappingConstants.MAPPING_ATT_PATH, getPluginAttributeValue(pluginElement, IMappingConstants.MAPPING_ATT_PATH));
      // Set the source.
      currentMappingDescriptor.setValue(IMappingConstants.MAPPING_ATT_SOURCE, getPluginAttributeValue(pluginElement, IMappingConstants.MAPPING_ATT_SOURCE));
      // Set the target.
      currentMappingDescriptor.setValue(IMappingConstants.MAPPING_ATT_TARGET, getPluginAttributeValue(pluginElement, IMappingConstants.MAPPING_ATT_TARGET));
      // Add the created descriptor as a child of the result.
      result.addChild(currentMappingDescriptor);
    }
    return result;
  }
}