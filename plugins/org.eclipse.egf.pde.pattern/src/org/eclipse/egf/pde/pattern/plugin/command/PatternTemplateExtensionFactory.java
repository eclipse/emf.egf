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
package org.eclipse.egf.pde.pattern.plugin.command;

import org.eclipse.egf.pde.pattern.internal.plugin.command.SetPatternTemplateCommand;
import org.eclipse.egf.pde.pattern.internal.plugin.command.UnsetPatternTemplateCommand;
import org.eclipse.egf.pde.pattern.internal.plugin.command.UpdatePatternTemplateCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;


/**
 * Pattern commands factory.<br>
 * Created commands perform plug-in changes in the extension section.
 * @author Xavier Maysonnave
 */
public class PatternTemplateExtensionFactory {
  
  /**
   * Create a set generated pattern extension command for given parameters.
   * @param patternFullId_p Pattern full id as defined by the pattern plug-in.
   * @param templateClass_p a string that represents the generated pattern code.
   * @param templateType_p the identifier of the template type used to produce the pattern.
   * @param templatePath_p a string that represents the template code.
   * @return
   */
  public static IPluginChangesCommand setPatternTemplateExtension(
    String patternFullId_p, 
    String templateClass_p, 
    String templateType_p,
    String templatePath_p
  ) {
    return new SetPatternTemplateCommand(patternFullId_p, templateClass_p, templateType_p, templatePath_p);
  }

  /**
   * Create an unset generated pattern extension command for given parameters.
   * @param patternFullId_p Pattern full id as defined by the pattern plug-in.
   * @return
   */
  public static IPluginChangesCommand unsetPatternTemplateExtension(String patternFullId_p) {
    return new UnsetPatternTemplateCommand(patternFullId_p);
  }

  /**
   * Create an update generated pattern id extension command.<br>
   * It only updates the extension id with the new given pattern full id.<br>
   * If the extension is not found, nothing is performed.
   * @param oldPatternFullId_p The previous pattern full id.
   * @param newPatternFullId_p Pattern full id as defined by the pattern plug-in.
   * @return
   */
  public static IPluginChangesCommand updatePatternTemplateExtension(
    String oldPatternFullId_p, 
    String newPatternFullId_p
  ) {
    return new UpdatePatternTemplateCommand(oldPatternFullId_p, newPatternFullId_p);
  }
  
}