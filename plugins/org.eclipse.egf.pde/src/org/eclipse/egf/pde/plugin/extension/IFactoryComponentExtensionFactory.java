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
 * This factory creates commands to deal with "FactoryComponent" extension-point.
 * @author fournier
 */
public interface IFactoryComponentExtensionFactory {
  /**
   * Set an extension matching "FactoryComponent" extension-point for given parameters.
   * @param factoryComponentId_p
   * @param factoryComponentName_p
   * @param contractId_p
   * @param domain_p
   * @param productionPlanId_p
   * @param description_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand setFactoryComponentExtension(String factoryComponentId_p, String factoryComponentName_p, String contractId_p, String domain_p, String productionPlanId_p, String description_p);

  /**
   * Unset an existing extension matching "FactoryComponent" extension-point for given parameters.
   * @param factoryComponentId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand unsetFactoryComponentExtension(String factoryComponentId_p);
}
