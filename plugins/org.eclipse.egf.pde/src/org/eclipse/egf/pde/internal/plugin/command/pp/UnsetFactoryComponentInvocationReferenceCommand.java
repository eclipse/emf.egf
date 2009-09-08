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

import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * This command removes an FactoryComponentInvocation in an extension matching ProductionPlan extension-point.
 * @author fournier
 */
public class UnsetFactoryComponentInvocationReferenceCommand extends AbstractFactoryComponentInvocationReferenceCommand {
  /**
   * Constructor.
   * @param productionPlanId_p
   */
  public UnsetFactoryComponentInvocationReferenceCommand(String productionPlanId_p, String factoryComponentInvocationId_p) {
    super(productionPlanId_p, factoryComponentInvocationId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get the extension where the production plan is stored.
    IPluginElement extension = getFirstExtensionElement();
    // Remove the factory component invocation reference from the extension.
    removeExtensionElementChild(extension, getIdAttribute(), getIdAttributeValue());
  }
}
