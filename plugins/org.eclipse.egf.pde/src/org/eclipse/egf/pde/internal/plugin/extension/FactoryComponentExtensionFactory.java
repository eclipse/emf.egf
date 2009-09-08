/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pde.internal.plugin.extension;

import org.eclipse.egf.pde.internal.plugin.command.fc.SetFactoryComponentExtensionCommand;
import org.eclipse.egf.pde.internal.plugin.command.fc.UnsetFactoryComponentExtensionCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentExtensionFactory;

/**
 * This factory creates commands to deal with "FactoryComponent" extension-point.
 * @author fournier
 */
public class FactoryComponentExtensionFactory implements IFactoryComponentExtensionFactory {
  
  /**
   * Unique reference.
   */
  private static FactoryComponentExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private FactoryComponentExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * @return
   */
  public static FactoryComponentExtensionFactory getInstance() {
    if (__instance == null) {
      __instance = new FactoryComponentExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IFactoryComponentExtensionFactory#setFactoryComponentExtension(java.lang.String, java.lang.String, java.lang.String,
   *      java.lang.String, java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setFactoryComponentExtension(
    String fcId_p, 
    String fcName_p, 
    String contractId_p, 
    String domain_p, 
    String productionPlanId_p,
    String description_p
  ) {
    return new SetFactoryComponentExtensionCommand(
      fcId_p, 
      fcName_p, 
      contractId_p,
      domain_p, 
      productionPlanId_p, 
      description_p
    );
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IFactoryComponentExtensionFactory#unsetFactoryComponentExtension(java.lang.String)
   */
  public IPluginChangesCommand unsetFactoryComponentExtension(String fcId_p) {
    return new UnsetFactoryComponentExtensionCommand(fcId_p);
  }
  
}