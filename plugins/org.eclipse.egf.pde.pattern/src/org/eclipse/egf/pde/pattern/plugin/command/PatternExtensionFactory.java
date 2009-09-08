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

import org.eclipse.egf.pde.pattern.internal.plugin.command.SetPatternCommand;
import org.eclipse.egf.pde.pattern.internal.plugin.command.SetPatternLibraryCommand;
import org.eclipse.egf.pde.pattern.internal.plugin.command.UnsetPatternCommand;
import org.eclipse.egf.pde.pattern.internal.plugin.command.UnsetPatternLibraryCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;


/**
 * Pattern commands factory.<br>
 * Created commands perform plug-in changes in the extension section.
 * @author Guillaume Brocard
 */
public class PatternExtensionFactory {
  
  /**
   * Create a set pattern extension command for given parameters.
   * @param patternShortId_p Pattern full id as defined by the pattern plug-in.
   * @param patternName_p
   * @param definition_p the relative path in the workspace to the ecore file that defines the pattern.
   * @return
   */
  public static IPluginChangesCommand setPatternExtension(
    String patternShortId_p, 
    String patternName_p, 
    String definition_p
  ) {
    return new SetPatternCommand(patternShortId_p, patternName_p, definition_p);
  }

  /**
   * Create an unset pattern extension command for given parameters.
   * @param patternShortId_p Pattern full id as defined by the pattern plug-in.
   * @return
   */
  public static IPluginChangesCommand unsetPatternExtension(String patternShortId_p) {
    return new UnsetPatternCommand(patternShortId_p);
  }

  /**
   * Create a set pattern library extension command for given parameters.
   * @param patternLibraryFullId_p Pattern library full id as defined by the pattern plug-in.
   * @param libraryName_p
   * @param productionOrchestration_p
   * @param runtimeOrchestration_p
   * @return
   */
  public static IPluginChangesCommand setPatternLibraryExtension(
    String patternLibraryFullId_p, 
    String libraryName_p, 
    String productionOrchestration_p,
    String runtimeOrchestration_p
  ) {
    return new SetPatternLibraryCommand(
      patternLibraryFullId_p, 
      libraryName_p, 
      productionOrchestration_p, 
      runtimeOrchestration_p
    );
  }

  /**
   * Create an unset pattern library extension command for given parameters.
   * @param patternLibraryFullId_p Pattern library full id as defined by the pattern plug-in.
   * @return
   */
  public static IPluginChangesCommand unsetPatternLibraryExtension(String patternLibraryFullId_p) {
    return new UnsetPatternLibraryCommand(patternLibraryFullId_p);
  }
  
}