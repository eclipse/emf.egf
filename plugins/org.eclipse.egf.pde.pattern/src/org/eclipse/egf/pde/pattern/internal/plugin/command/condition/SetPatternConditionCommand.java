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
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * @author Guillaume Brocard
 */
public class SetPatternConditionCommand extends AbstractPatternConditionCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetPatternConditionCommand.class.getPackage().getName());
  /**
   * Java pattern condition class fully qualified name.
   */
  private String _patternConditionClassFullyQualifiedName;

  /**
   * Constructor.
   * @param patternFullId_p The pattern full id as defined by the pattern plug-in.
   * @param patternConditionClassFullyQualifiedName_p A java fully qualified class name.
   */
  public SetPatternConditionCommand(String patternFullId_p, String patternConditionClassFullyQualifiedName_p) {
    super(patternFullId_p);
    _patternConditionClassFullyQualifiedName = patternConditionClassFullyQualifiedName_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    IPluginElement patternCondition = getExtensionElementWithId(getPatternFullId());
    try {
      patternCondition.setAttribute(ExtensionPointHelper.ATT_CLASS, _patternConditionClassFullyQualifiedName);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("SetPatternConditionCommand.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}
