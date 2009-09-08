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
package org.eclipse.egf.pde.internal.plugin.command.fci;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentInvocationConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates an extension matching factoryComponentInvocation extension-point.
 * @author fournier
 */
public class SetFactoryComponentInvocationCommand extends AbstractFactoryComponentInvocationCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger _logger = Logger.getLogger(SetFactoryComponentInvocationCommand.class.getPackage().getName());
  /**
   * FactoryComponent name.
   */
  private String _factoryComponentInvocationName;
  /**
   * Referenced factory component id value.
   */
  private String _referencedFactoryComponentId;
  /**
   * Context id value.
   */
  private String _contextId;
  /**
   * Referenced task factory id value.
   */
  private String _referencedTaskFactoryId;

  /**
   * Constructor.
   * @param factoryComponentInvocationId_p
   * @param referencedFactoryComponentId_p
   * @param contextId_p
   * @param referencedTaskFactoryId_p
   */
  public SetFactoryComponentInvocationCommand(String factoryComponentInvocationId_p, String factoryComponentInvocationName_p, String referencedFactoryComponentId_p, String contextId_p,
      String referencedTaskFactoryId_p) {
    super(factoryComponentInvocationId_p);
    _factoryComponentInvocationName = factoryComponentInvocationName_p;
    _referencedFactoryComponentId = referencedFactoryComponentId_p;
    _contextId = contextId_p;
    _referencedTaskFactoryId = referencedTaskFactoryId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Create the factory component invocation object.
    IPluginElement fcInvocation = getExtensionElementFromUniqueExtension(getFactoryComponentInvocationId());
    try {
      // Set the factory component invocation name.
      fcInvocation.setAttribute(IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_NAME, _factoryComponentInvocationName);
      // Set the referenced factory component.
      fcInvocation.setAttribute(IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_FC_ID, _referencedFactoryComponentId);
      // Set the context id.
      fcInvocation.setAttribute(IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_CONTEXT_ID, _contextId);
      // Set the referenced task factory id.
      fcInvocation.setAttribute(IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_TASK_FACTORY_ID, _referencedTaskFactoryId);
    } catch (CoreException exception_p) {
      StringBuffer loggerMessage = new StringBuffer("SetFactoryComponentInvocationCommand.execute(..) _ "); //$NON-NLS-1$
      _logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}
