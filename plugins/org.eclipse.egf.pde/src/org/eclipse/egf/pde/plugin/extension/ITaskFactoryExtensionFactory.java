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
package org.eclipse.egf.pde.plugin.extension;

import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;

/**
 * This factory creates commands to deal with "taskFactory" extension-point.
 * @author fournier
 */
public interface ITaskFactoryExtensionFactory {

  /**
   * Set an extension matching "taskFactory" extension-point for given parameters.
   * @param taskFactoryId_p
   * @param implementationClassName_p
   * @return
   */
  public IPluginChangesCommand setTaskFactoryExtension(String taskFactoryId_p, String implementationClassName_p);

  /**
   * Unset an extension matching "taskFactory" extension-point for given parameters.
   * @param taskFactoryId_p
   * @return
   */
  public IPluginChangesCommand unsetTaskFactoryExtension(String taskFactoryId_p);
}
