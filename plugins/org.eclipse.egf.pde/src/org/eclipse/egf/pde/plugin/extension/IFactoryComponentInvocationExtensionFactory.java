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
 * This factory creates commands to deal with "FactoryComponentConfiguration" extension-point.
 * @author fournier
 */
public interface IFactoryComponentInvocationExtensionFactory {
  /**
   * Set an extension matching "FactoryComponentConfiguration" extension-point for given parameters.
   * @param factoryComponentInvocationId_p
   * @param factoryComponentInvocationName_p
   * @param referencedFactoryComponentId_p
   * @param contextId_p
   * @param referencedTaskFactoryId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand setFactoryComponentInvocationExtension(String factoryComponentInvocationId_p, String factoryComponentInvocationName_p, String referencedFactoryComponentId_p,
      String contextId_p, String referencedTaskFactoryId_p);

  /**
   * Unset an extension matching "FactoryComponentConfiguration" extension-point for given parameters.
   * @param factoryComponentInvocationId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand unsetFactoryComponentInvocationExtension(String factoryComponentInvocationId_p);
}