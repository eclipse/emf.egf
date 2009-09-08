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
package org.eclipse.egf.pde.internal.plugin.command.pp;

import org.eclipse.egf.core.extensionpoint.IProductionPlanConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates an FactoryComponentInvocation in an extension matching ProductionPlan extension-point.
 * @author fournier
 */
public class SetFactoryComponentInvocationReferenceCommand extends AbstractFactoryComponentInvocationReferenceCommand {
  /**
   * Constructor.
   * @param productionPlanId_p
   * @param factoryComponentInvocationId_p
   */
  public SetFactoryComponentInvocationReferenceCommand(String productionPlanId_p, String factoryComponentInvocationId_p) {
    super(productionPlanId_p, factoryComponentInvocationId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    // Get the extension where the production plan is stored.
    IPluginElement extension = getFirstExtensionElement();
    // Add a factory component invocation reference in the extension.
    createExtensionElementChild(extension, IProductionPlanConstants.PRODUCTION_PLAN_CHILD_ASSET_CONFIGURATION, getIdAttribute(), getIdAttributeValue());
  }
}
