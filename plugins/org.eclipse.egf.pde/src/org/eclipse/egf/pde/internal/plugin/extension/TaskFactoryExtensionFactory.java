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
package org.eclipse.egf.pde.internal.plugin.extension;

import org.eclipse.egf.pde.internal.plugin.command.taskfactory.SetTaskFactoryCommand;
import org.eclipse.egf.pde.internal.plugin.command.taskfactory.UnsetTaskFactoryCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.ITaskFactoryExtensionFactory;

/**
 * This factory creates commands to deal with "taskFactory" extension-point.
 * @author fournier
 */
public class TaskFactoryExtensionFactory implements ITaskFactoryExtensionFactory {
  /**
   * Unique reference.
   */
  private static TaskFactoryExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private TaskFactoryExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * @return
   */
  public static TaskFactoryExtensionFactory getInstance() {
    if (null == __instance) {
      __instance = new TaskFactoryExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.ITaskFactoryExtensionFactory#setTaskFactoryExtension(java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setTaskFactoryExtension(String taskFactoryId_p, String implementationClassName_p) {
    return new SetTaskFactoryCommand(taskFactoryId_p, implementationClassName_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.ITaskFactoryExtensionFactory#unsetTaskFactoryExtension(java.lang.String)
   */
  public IPluginChangesCommand unsetTaskFactoryExtension(String taskFactoryId_p) {
    return new UnsetTaskFactoryCommand(taskFactoryId_p);
  }
}