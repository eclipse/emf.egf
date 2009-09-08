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
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.core.extensionpoint.IContextConstants;
import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContextDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContextElementDescriptor;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;


/**
 * Operation to read a context in a plug-in within the workspace.
 * @author fournier
 */
public class CreateContextDescriptorOperation extends CreateDescriptorOperation {
  /**
   * Constructor.
   * @param modelFile_p
   * @param readExtensionId_p
   */
  public CreateContextDescriptorOperation(IFile modelFile_p, String readExtensionId_p) {
    super(modelFile_p, readExtensionId_p);
  }

  /**
   * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  @Override
  protected AbstractDescriptor createDescriptor(IPluginModelBase model_p) {
    ContextDescriptor descriptor = null;
    IPluginElement pluginElement = getExtensionWithId(model_p, IContextConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, getReadExtensionId());
    if (null != pluginElement) {
      descriptor = new ContextDescriptor();
      // Set the id.
      String value = getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_ID);
      descriptor.setId(value);
      // Get all context elements.
      IPluginElement[] children = getChildren(pluginElement, IContextConstants.CONTEXT_CHILD);
      for (IPluginElement child : children) {
        // Try reading a context element descriptor.
        ContextElementDescriptor contextElementDescriptor = readContextElementDescriptor(child);
        // if correctly read, add it.
        if (null != contextElementDescriptor) {
          descriptor.addContextElementDescriptor(contextElementDescriptor);
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
  private ContextElementDescriptor readContextElementDescriptor(IPluginElement child_p) {
    ContextElementDescriptor descriptor = new ContextElementDescriptor();
    // Set context element id.
    String value = getPluginAttributeValue(child_p, ExtensionPointHelper.ATT_ID);
    descriptor.setId(value);
    // Get all children : stringValue, classValue, contractElementRef or key
    IPluginObject[] children = child_p.getChildren();
    // Loop over every child.
    for (int i = 0; i < children.length; i++) {
      IPluginObject object = children[i];
      // Interesting in IPluginElement only.
      if (object instanceof IPluginElement) {
        IPluginElement element = (IPluginElement) object;
        // If child name is equals to contractElementRef
        if (IFactoryComponentConstants.CONTRACT_REF_CHILD.equals(element.getName())) {
          // Set the contract element reference id.
          value = getPluginAttributeValue(element, IFactoryComponentConstants.ATT_CONTRACT_ELEMENT_REFERENCE_ID);
          descriptor.setContractReferenceId(value);
        } else if (IContextConstants.CONTEXT_ELEMENT_KEY_CHILD.equals(element.getName())) {
          // Set the key name.
          value = getPluginAttributeValue(element, ExtensionPointHelper.ATT_NAME);
          descriptor.setKey(value);
        } else if (IContextConstants.CONTEXT_ELEMENT_VALUE_CHILD.equals(element.getName())) {
          // Set the value as a readable value.
          value = getPluginAttributeValue(element, IContractConstants.CONTRACT_ELEMENT_CHILD_ATT_VALUE);
          descriptor.setReadableValue(value);
          // Set type.
          value = getPluginAttributeValue(element, ExtensionPointHelper.ATT_CLASS);
          if (null != value) {
            Type type = ModelFactory.eINSTANCE.createType();
            type.setTypeHolderClassName(value);
            descriptor.setType(type);
          }
        }
      }
    }
    return descriptor;
  }
}
