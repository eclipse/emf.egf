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
import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContractDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContractElementDescriptor;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Operation to read a contract in a plug-in within the workspace.
 * @author fournier
 */
public class CreateContractDescriptorOperation extends CreateDescriptorOperation {
  /**
   * Constructor.
   * @param modelFile_p
   * @param readExtensionId_p
   */
  public CreateContractDescriptorOperation(IFile modelFile_p, String readExtensionId_p) {
    super(modelFile_p, readExtensionId_p);
  }

  /**
   * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  @Override
  protected AbstractDescriptor createDescriptor(IPluginModelBase model_p) {
    ContractDescriptor descriptor = null;
    IPluginElement pluginElement = getExtensionWithId(model_p, IContractConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, getReadExtensionId());
    if (null != pluginElement) {
      String contractId = getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_ID);
      if (null != contractId) {
        descriptor = new ContractDescriptor();
        // Set the id.
        descriptor.setId(contractId);
        // Get all contract elements.
        IPluginElement[] children = getChildren(pluginElement, IContractConstants.CONTRACT_ELEMENT_CHILD);
        for (IPluginElement child : children) {
          // Try reading a contract element descriptor.
          ContractElementDescriptor contractElementDescriptor = readContractElementDescriptor(child);
          // if correctly read, add it.
          if (null != contractElementDescriptor) {
            descriptor.addContractElementDescriptor(contractElementDescriptor);
          }
        }
      }
    }
    return descriptor;
  }

  /**
   * Read a contract element descriptor.
   * @param child_p
   * @return
   */
  private ContractElementDescriptor readContractElementDescriptor(IPluginElement child_p) {
    ContractElementDescriptor descriptor = new ContractElementDescriptor();
    // Set the contract element id.
    String contractElementId = getPluginAttributeValue(child_p, ExtensionPointHelper.ATT_ID);
    descriptor.setId(contractElementId);
    // Set the contract element name
    String contractElementName = getPluginAttributeValue(child_p, IContractConstants.CONTRACT_ELEMENT_ATT_NAME);
    descriptor.setContractElementName(contractElementName);
    // Set the type class name.
    String typeClass = getPluginAttributeValue(child_p, IContractConstants.CONTRACT_ELEMENT_ATT_TYPE);
    descriptor.setTypeHolderClassName(typeClass);
    // Set the mandatory value.
    String mandatory = getPluginAttributeValue(child_p, IContractConstants.CONTRACT_ELEMENT_ATT_MANDATORY);
    // If not defined, the contract element is mandatory.
    boolean isMandatory = (null != mandatory) ? Boolean.parseBoolean(mandatory) : true;
    descriptor.setMandatory(isMandatory);
    // Get the description.
    String description = readDescription(child_p);
    if (null == description) {
      // Read it directly form the current element (@deprecated, but necessary to ensure compatibility)
      String childText = child_p.getText();
      description = (ICommonConstants.EMPTY_STRING.equals(childText)) ? null : childText;
    }
    // Set the description.
    descriptor.setDescription(description);
    // Get all contract element reference children.
    IPluginElement[] contractElementReferences = getChildren(child_p, IFactoryComponentConstants.CONTRACT_REF_CHILD);
    for (IPluginElement contractElementRef : contractElementReferences) {
      // Get the contract element reference id.
      String contractReferenceId = getPluginAttributeValue(contractElementRef, IFactoryComponentConstants.ATT_CONTRACT_ELEMENT_REFERENCE_ID);
      // if existing, add it.
      if (null != contractReferenceId) {
        descriptor.addContractReferenceId(contractReferenceId);
      }
    }
    return descriptor;
  }
}
