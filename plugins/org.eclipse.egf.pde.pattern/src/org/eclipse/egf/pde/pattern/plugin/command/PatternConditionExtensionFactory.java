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
package org.eclipse.egf.pde.pattern.plugin.command;

import org.eclipse.egf.pde.pattern.internal.plugin.command.condition.SetPatternConditionCommand;
import org.eclipse.egf.pde.pattern.internal.plugin.command.condition.UnsetPatternConditionCommand;
import org.eclipse.egf.pde.pattern.internal.plugin.command.condition.UpdatePatternConditionCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;


/**
 * Pattern condition commands factory.
 * @author Guillaume Brocard
 */
public class PatternConditionExtensionFactory {
  /**
   * Create set pattern condition extension command for given parameters.
   * @param patternFullId_p Pattern full id as defined by the pattern plug-in.
   * @param conditionFullyQualifiedName_p Condition Java class fully qualified name.
   * @return
   */
  public static IPluginChangesCommand setPatternConditionExtension(String patternFullId_p, String conditionFullyQualifiedName_p) {
    return new SetPatternConditionCommand(patternFullId_p, conditionFullyQualifiedName_p);
  }

  /**
   * Create unset pattern condition extension command for identified pattern.
   * @param patternFullId_p Pattern full id as defined by the pattern plug-in.
   * @return
   */
  public static IPluginChangesCommand unsetPatternConditionExtension(String patternFullId_p) {
    return new UnsetPatternConditionCommand(patternFullId_p);
  }

  /**
   * Create update pattern condition extension command.
   * @param oldPatternFullId_p The previous pattern full id.
   * @param newPatternFullId_p The new one.
   * @return
   */
  public static IPluginChangesCommand updatePatternConditionExtension(String oldPatternFullId_p, String newPatternFullId_p) {
    return new UpdatePatternConditionCommand(oldPatternFullId_p, newPatternFullId_p);
  }
}
