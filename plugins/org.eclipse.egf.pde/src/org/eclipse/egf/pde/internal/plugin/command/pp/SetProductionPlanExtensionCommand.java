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

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.extensionpoint.IProductionPlanConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates an extension matching ProductionPlan extension-point.
 * @author fournier
 */
public class SetProductionPlanExtensionCommand extends AbstractProductionPlanCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger _logger = Logger.getLogger(SetProductionPlanExtensionCommand.class.getPackage().getName());
  /**
   * Context id value.
   */
  private String _contextId;

  /**
   * Constructor.
   * @param productionPlanId_p
   * @param contextId_p
   */
  public SetProductionPlanExtensionCommand(String productionPlanId_p, String contextId_p) {
    super(productionPlanId_p);
    _contextId = contextId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Create the production plan object.
    IPluginElement productionPlan = getExtensionElementWithId(getProductionPlanId());
    try {
      // Set the contextId.
      productionPlan.setAttribute(IProductionPlanConstants.PRODUCTION_PLAN_ATT_CONTEXT_ID, _contextId);
    } catch (CoreException exception_p) {
      StringBuffer loggerMessage = new StringBuffer("SetProductionPlanExtensionCommand.execute(..) _ "); //$NON-NLS-1$
      _logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}
