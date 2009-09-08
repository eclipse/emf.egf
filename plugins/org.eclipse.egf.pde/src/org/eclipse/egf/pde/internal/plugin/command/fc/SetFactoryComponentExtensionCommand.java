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
package org.eclipse.egf.pde.internal.plugin.command.fc;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates an extension matching FactoryComponent extension-point.
 * @author fournier
 */
public class SetFactoryComponentExtensionCommand extends AbstractFactoryComponentExtensionCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger _logger = Logger.getLogger(SetFactoryComponentExtensionCommand.class.getPackage().getName());
  /**
   * FactoryComponent name.
   */
  private String _factoryComponentName;
  /**
   * Contract id reference value.
   */
  private String _contractId;
  /**
   * Domain path value.
   */
  private String _domain;
  /**
   * Production plan reference value.
   */
  private String _productionPlanId;
  /**
   * Description value.
   */
  private String _description;

  /**
   * Constructor.
   * @param factoryComponentId_p
   * @param factoryComponentName_p
   * @param contractId_p
   * @param domain_p
   * @param productionPlanId_p
   */
  public SetFactoryComponentExtensionCommand(String factoryComponentId_p, String factoryComponentName_p, String contractId_p, String domain_p, String productionPlanId_p, String description_p) {
    super(factoryComponentId_p);
    _factoryComponentName = factoryComponentName_p;
    _contractId = contractId_p;
    _domain = domain_p;
    _productionPlanId = productionPlanId_p;
    _description = description_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // To ensure description persistence, remove the previous extension first.
    String fcId = getFactoryComponentId();
    removeExtension(fcId);
    // In FactoryComponent extension, we only have one child.
    IPluginElement fc = getExtensionElementWithId(fcId);
    try {
      // Set the description first.
      setDescription(fc, fcId, _description);
      // Set attributes.
      // Set the factory component name
      fc.setAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_NAME, _factoryComponentName);
      // Set the contractId
      fc.setAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_CONTRACT_ID, _contractId);
      // Set the domain either defined or not.
      IPluginAttribute attribute = fc.getAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_DOMAIN);
      if ((null == attribute) && (null != _domain)) {
        fc.setAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_DOMAIN, _domain);
      } else if (null != attribute) {
        fc.setAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_DOMAIN, _domain);
      }
      // Set the production plan.
      fc.setAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_PRODUCTION_PLAN_ID, _productionPlanId);
    } catch (CoreException exception_p) {
      StringBuffer loggerMessage = new StringBuffer("SetFactoryComponentExtensionCommand.execute(..) _ "); //$NON-NLS-1$
      _logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}
