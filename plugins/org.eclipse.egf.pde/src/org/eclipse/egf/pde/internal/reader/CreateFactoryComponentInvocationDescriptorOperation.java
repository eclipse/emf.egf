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
import org.eclipse.egf.core.extensionpoint.IFactoryComponentInvocationConstants;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.FactoryComponentInvocationDescriptor;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Operation to read a FactoryComponentInvocation in a plug-in within the workspace.
 * @author fournier
 */
public class CreateFactoryComponentInvocationDescriptorOperation extends CreateDescriptorOperation {
  /**
   * Constructor.
   * @param modelFile_p
   * @param readExtensionId_p
   */
  public CreateFactoryComponentInvocationDescriptorOperation(IFile modelFile_p, String readExtensionId_p) {
    super(modelFile_p, readExtensionId_p);
  }

  /**
   * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  @Override
  protected AbstractDescriptor createDescriptor(IPluginModelBase model_p) {
    FactoryComponentInvocationDescriptor descriptor = null;
    IPluginElement pluginElement = getExtensionWithId(model_p, IFactoryComponentInvocationConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, getReadExtensionId());
    if (null != pluginElement) {
      String id = getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_ID);
      if (null != id) {
        descriptor = new FactoryComponentInvocationDescriptor();
        // Set the id.
        descriptor.setId(id);
        // Set the factory component invocation name.
        String value = getPluginAttributeValue(pluginElement, IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_NAME);
        if (null != value) {
          descriptor.setName(value);
        }
        // Set referenced factory component.
        value = getPluginAttributeValue(pluginElement, IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_FC_ID);
        if (null != value) {
          descriptor.setReferencedFactoryComponentId(value);
        }
        // Set the task factory, if defined
        value = getPluginAttributeValue(pluginElement, IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_TASK_FACTORY_ID);
        if (null != value) {
          descriptor.setTaskFactoryId(value);
        }
        // Set the context
        value = getPluginAttributeValue(pluginElement, IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_CONTEXT_ID);
        if (null != value) {
          descriptor.setContextId(value);
        }
      }
    }
    return descriptor;
  }
}
