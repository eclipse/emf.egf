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

import org.eclipse.egf.pde.internal.plugin.command.fci.SetFactoryComponentInvocationCommand;
import org.eclipse.egf.pde.internal.plugin.command.fci.UnsetFactoryComponentInvocationCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentInvocationExtensionFactory;

/**
 * This factory creates commands to deal with "FactoryComponentConfiguration" extension-point.
 * @author fournier
 */
public class FactoryComponentInvocationExtensionFactory implements IFactoryComponentInvocationExtensionFactory {
  /**
   * Unique reference.
   */
  private static FactoryComponentInvocationExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private FactoryComponentInvocationExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * @return
   */
  public static FactoryComponentInvocationExtensionFactory getInstance() {
    if (null == __instance) {
      __instance = new FactoryComponentInvocationExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IFactoryComponentInvocationExtensionFactory#setFactoryComponentInvocationExtension(java.lang.String, java.lang.String,
   *      java.lang.String, java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setFactoryComponentInvocationExtension(String factoryComponentInvocationId_p, String factoryComponentInvocationName_p, String referencedFcId_p,
      String contextId_p, String referencedTaskFactoryId_p) {
    return new SetFactoryComponentInvocationCommand(factoryComponentInvocationId_p, factoryComponentInvocationName_p, referencedFcId_p, contextId_p, referencedTaskFactoryId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IFactoryComponentInvocationExtensionFactory#unsetFactoryComponentInvocationExtension(java.lang.String)
   */
  public IPluginChangesCommand unsetFactoryComponentInvocationExtension(String factoryComponentInvocationId_p) {
    return new UnsetFactoryComponentInvocationCommand(factoryComponentInvocationId_p);
  }

}
