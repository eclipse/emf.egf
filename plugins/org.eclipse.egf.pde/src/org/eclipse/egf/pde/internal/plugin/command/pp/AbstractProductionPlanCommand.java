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

import org.eclipse.egf.core.extensionpoint.IProductionPlanConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement commands that deal with ProductionPlan extension-point.
 * @author fournier
 */
public class AbstractProductionPlanCommand extends AbstractExtensionChangesCommand {
  
  /**
   * Production plan id value.
   */
  private String _productionPlanId;

  /**
   * Constructor.
   * @param productionPlanId_p
   */
  protected AbstractProductionPlanCommand(String productionPlanId_p) {
    _productionPlanId = productionPlanId_p;
  }

  /**
   * Get the production plan id.
   * @return the productionPlanId
   */
  protected String getProductionPlanId() {
    return _productionPlanId;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IProductionPlanConstants.PRODUCTION_PLAN_EXTENSION_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IProductionPlanConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }
  
}
