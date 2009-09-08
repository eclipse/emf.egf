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
package org.eclipse.egf.pde.internal.plugin.command.taskfactory;

import org.eclipse.egf.core.extensionpoint.ITaskFactoryConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement commands that deal with taskFactory extension-point.
 * @author fournier
 */
public abstract class AbstractTaskFactoryCommand extends AbstractExtensionChangesCommand {
  /**
   * Task factory id value.
   */
  private String _taskFactoryId;

  public AbstractTaskFactoryCommand(String taskFactoryId_p) {
    _taskFactoryId = taskFactoryId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return ITaskFactoryConstants.TASK_FACTORY_EXTENSION_POINT_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return ITaskFactoryConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }

  /**
   * Get the task factory id value.
   * @return the taskFactoryId
   */
  protected String getTaskFactoryId() {
    return _taskFactoryId;
  }
}