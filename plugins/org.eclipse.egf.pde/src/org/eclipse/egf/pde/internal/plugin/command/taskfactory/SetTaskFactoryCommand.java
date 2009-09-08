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
package org.eclipse.egf.pde.internal.plugin.command.taskfactory;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates an extension matching taskFactory extension-point.
 * @author fournier
 */
public class SetTaskFactoryCommand extends AbstractTaskFactoryCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetTaskFactoryCommand.class.getPackage().getName());
  /**
   * Implementation class name value.
   */
  private String _className;

  /**
   * Constructor.
   * @param taskFactoryId_p
   */
  public SetTaskFactoryCommand(String taskFactoryId_p, String implementationClassName_p) {
    super(taskFactoryId_p);
    _className = implementationClassName_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Create the task factory object.
    IPluginElement taskFactory = getExtensionElementFromUniqueExtension(getTaskFactoryId());
    try {
      // Set the task factory id.
      taskFactory.setAttribute(getExtensionChildIdAttribute(), getTaskFactoryId());
      // Set the class implementation.
      taskFactory.setAttribute(ExtensionPointHelper.ATT_CLASS, _className);
    } catch (CoreException exception_p) {
      StringBuffer loggerMessage = new StringBuffer("SetTaskFactoryCommand.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}