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
import org.eclipse.egf.core.extensionpoint.ITaskFactoryConstants;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.TaskFactoryDescriptor;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Operation to read a task factory in a plug-in within the workspace.
 * @author fournier
 */
public class CreateTaskFactoryDescriptorOperation extends CreateDescriptorOperation {
  /**
   * Constructor.
   * @param modelFile_p
   * @param readElementId_p
   */
  public CreateTaskFactoryDescriptorOperation(IFile modelFile_p, String readElementId_p) {
    super(modelFile_p, readElementId_p);
  }

  /**
   * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  @Override
  protected AbstractDescriptor createDescriptor(IPluginModelBase model_p) {
    TaskFactoryDescriptor descriptor = null;
    IPluginElement pluginElement = getExtensionWithId(model_p, ITaskFactoryConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, getReadExtensionId());
    if (null != pluginElement) {
      String taskFactoryId = getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_ID);
      if (null != taskFactoryId) {
        descriptor = new TaskFactoryDescriptor();
        // Set the id.
        descriptor.setId(taskFactoryId);
        // Set the task factory class name.
        String taskFactoryClass = getPluginAttributeValue(pluginElement, ExtensionPointHelper.ATT_CLASS);
        descriptor.setTaskFactoryClass(taskFactoryClass);
      }
    }
    return descriptor;
  }
}
