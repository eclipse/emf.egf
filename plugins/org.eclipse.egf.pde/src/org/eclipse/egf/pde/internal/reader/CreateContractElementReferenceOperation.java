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
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.extensionpoint.IContractReferenceConstants;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContractElementReferenceDescriptor;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Operation to read a contract element reference in a plug-in within the workspace.
 * @author fournier
 */
public class CreateContractElementReferenceOperation extends CreateDescriptorOperation {
  /**
   * Constructor.
   * @param modelFile_p
   * @param readExtensionId_p
   */
  public CreateContractElementReferenceOperation(IFile modelFile_p, String readExtensionId_p) {
    super(modelFile_p, readExtensionId_p);
  }

  /**
   * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  @SuppressWarnings("deprecation")
  @Override
  protected AbstractDescriptor createDescriptor(IPluginModelBase model_p) {
    ContractElementReferenceDescriptor descriptor = null;
    IPluginElement pluginElement = getExtensionWithId(model_p, IContractReferenceConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, getReadExtensionId());
    if (null != pluginElement) {
      descriptor = new ContractElementReferenceDescriptor();
      // Set the id.
      String value = getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_ID);
      descriptor.setId(value);
      String contractElementId = getPluginAttributeValue(pluginElement, IContractReferenceConstants.CONTRACT_REFERENCE_ATT_REFERENCED_CONTRACT_ELEMENT_ID);
      if (null != contractElementId) {
        descriptor.setContractElementId(contractElementId);
      } else {
        // @deprecated way to get the referenced contract element.
        // Read the contract element name to ensure compatibility with existing factory components.
        // Set the contract element name.
        value = getPluginAttributeValue(pluginElement, IContractReferenceConstants.CONTRACT_REFERENCE_ATT_REFERENCED_CONTRACT_ELEMENT_NAME);
        descriptor.setContractElementName(value);
      }
      // Set the reference factory component id
      value = getPluginAttributeValue(pluginElement, IContractReferenceConstants.CONTRACT_REFERENCE_ATT_REFERENCED_FACTORY_COMPONENT_ID);
      descriptor.setReferencedFcId(value);
    }
    return descriptor;
  }
}
