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
package org.eclipse.egf.pde.internal.plugin.command.pp;

/**
 * This command removes an existing extension matching ProductionPlan extension-point
 * @author fournier
 */
public class UnsetProductionPlanExtensionCommand extends AbstractProductionPlanCommand {

  /**
   * Constructor.
   * @param productionPlanId_p
   */
  public UnsetProductionPlanExtensionCommand(String productionPlanId_p) {
    super(productionPlanId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    removeExtension(getProductionPlanId());
  }
  
}
