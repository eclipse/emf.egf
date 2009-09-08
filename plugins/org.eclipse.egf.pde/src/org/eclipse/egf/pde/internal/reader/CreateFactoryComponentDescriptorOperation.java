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
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.FactoryComponentDescriptor;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Operation to read a factory component in a plug-in within the workspace.
 * @author fournier
 */
public class CreateFactoryComponentDescriptorOperation extends CreateDescriptorOperation {
  /**
   * Constructor.
   * @param modelFile_p
   */
  public CreateFactoryComponentDescriptorOperation(IFile modelFile_p) {
    super(modelFile_p);
  }

  /**
   * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  @Override
  protected AbstractDescriptor createDescriptor(IPluginModelBase model_p) {
    FactoryComponentDescriptor descriptor = null;
    IPluginElement[] extensionElements =
                                         getExtensionWithNodeName(model_p, IFactoryComponentConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID,
                                                                  IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_CHILD);
    // If factory component extensions are retrieved.
    if (extensionElements.length > 0) {
      // The factory component creation wizard constraints the end-user to get only one factory component per plug-in.
      // Get the zero-based element is enough.
      IPluginElement pluginElement = extensionElements[0];
      String fcId = getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_ID);
      if (null != fcId) {
        descriptor = new FactoryComponentDescriptor();
        // Set the id.
        descriptor.setId(fcId);
        // Get factory component name.
        String value = getPluginAttributeValue(pluginElement, IFactoryComponentConstants.FACTORY_COMPONENT_ATT_NAME);
        // Set factory component name (if defined).
        if (null != value) {
          descriptor.setName(value);
        }
        // Get the description.
        value = readDescription(pluginElement);
        if (null == value) {
          // Read it directly form the current element (@deprecated, but necessary to ensure compatibility)
          String pluginElementText = pluginElement.getText();
          value = (ICommonConstants.EMPTY_STRING.equals(pluginElementText)) ? null : pluginElementText;
        }
        // Set the description.
        descriptor.setDescription(value);
        // Get the domain path.
        value = getPluginAttributeValue(pluginElement, IFactoryComponentConstants.FACTORY_COMPONENT_ATT_DOMAIN);
        // Set domain path if defined.
        if (null != value) {
          descriptor.setDomainPath(value);
        }
        // Set the contract id (if defined).
        value = getPluginAttributeValue(pluginElement, IFactoryComponentConstants.FACTORY_COMPONENT_ATT_CONTRACT_ID);
        if (null != value) {
          descriptor.setContractId(value);
        }
        // Set the production plan (if defined).
        value = getPluginAttributeValue(pluginElement, IFactoryComponentConstants.FACTORY_COMPONENT_ATT_PRODUCTION_PLAN_ID);
        if (null != value) {
          descriptor.setProductionPlanId(value);
        }
      }
    }
    return descriptor;
  }
}
