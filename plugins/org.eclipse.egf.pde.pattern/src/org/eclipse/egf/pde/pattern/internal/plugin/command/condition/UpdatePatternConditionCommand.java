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
package org.eclipse.egf.pde.pattern.internal.plugin.command.condition;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * @author Guillaume Brocard
 */
public class UpdatePatternConditionCommand extends AbstractPatternConditionCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(UpdatePatternConditionCommand.class.getPackage().getName());
  /**
   * New pattern full id to apply.
   */
  private String _newPatternFullId;

  /**
   * Constructor.
   * @param oldPatternFullId_p
   * @param newPatternFullId_p
   */
  public UpdatePatternConditionCommand(String oldPatternFullId_p, String newPatternFullId_p) {
    super(oldPatternFullId_p);
    _newPatternFullId = newPatternFullId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get old pattern full id.
    String oldPatternFullId = getPatternFullId();
    // Get pattern condition element.
    IPluginElement patternCondition = getExtensionElementFromUniqueExtension(oldPatternFullId, false);
    if (null != patternCondition) {
      // Update the element id.
      try {
        patternCondition.setAttribute(getExtensionChildIdAttribute(), _newPatternFullId);
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("UpdatePatternConditionCommand.execute(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
  }
}
