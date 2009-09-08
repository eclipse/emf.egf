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
import org.eclipse.egf.core.extensionpoint.IProductionPlanConstants;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.ProductionPlanDescriptor;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Operation to read a production plan in a plug-in within the workspace.
 * @author fournier
 */
public class CreateProductionPlanDescriptorOperation extends CreateDescriptorOperation {
  /**
   * Constructor.
   * @param modelFile_p
   * @param readExtensionId_p
   */
  public CreateProductionPlanDescriptorOperation(IFile modelFile_p, String readExtensionId_p) {
    super(modelFile_p, readExtensionId_p);
  }

  /**
   * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  @Override
  protected AbstractDescriptor createDescriptor(IPluginModelBase model_p) {
    ProductionPlanDescriptor descriptor = null;
    IPluginElement pluginElement = getExtensionWithId(model_p, IProductionPlanConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, getReadExtensionId());
    if (null != pluginElement) {
      String id = getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_ID);
      if (null != id) {
        descriptor = new ProductionPlanDescriptor();
        // Set the id.
        descriptor.setId(id);
        // Set the context
        String value = getPluginAttributeValue(pluginElement, IProductionPlanConstants.PRODUCTION_PLAN_ATT_CONTEXT_ID);
        if (null != value) {
          descriptor.setContextId(value);
        }
        // Get all defined factory component invocation references.
        IPluginElement[] children = getChildren(pluginElement, IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_EXTENSION_CHILD);
        String childId = null;
        for (IPluginElement child : children) {
          // Get the attribute.
          childId = getPluginAttributeValue(child, ExtensionPointHelper.ATT_ID);
          // Add the factory component invocation read if not null.
          if (null != childId) {
            descriptor.addFactoryComponentInvocationId(childId);
          }
        }
      }
    }
    return descriptor;
  }
}
