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
package org.eclipse.egf.pde.pattern.internal.plugin.command;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates a pattern in an extension matching 'pattern' extension-point.
 * @author Guillaume Brocard
 */
public class SetPatternCommand extends AbstractPatternElementCommand {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetPatternCommand.class.getPackage().getName());
  
  /**
   * Reference to the pattern definition.
   */
  private String _definition;

  /**
   * Constructor.
   * @param patternFullId_p Pattern full id as defined by the pattern plug-in.
   */
  public SetPatternCommand(String patternFullId_p, String patternName_p, String definition_p) {
    super(patternFullId_p, patternName_p);
    _definition = definition_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get the parent library full id.
    String parentLibraryId = getParentLibraryId();
    IPluginElement parentLibrary = getLibrary(parentLibraryId);
    // Get the pattern full id.
    String patternId = getPatternElementId();
    // Get the pattern (create it if the pattern does not exist yet).
    IPluginElement pattern = getPatternElement(parentLibrary, patternId, IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN, true);
    try {
      // Set its name.
      pattern.setAttribute(
        ExtensionPointHelper.ATT_NAME, 
        getPatternElementName()
      );
      // Set its definition.
      pattern.setAttribute(
        IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME, 
        _definition
      );
    } catch (CoreException excetpion_p) {
      StringBuilder loggerMessage = new StringBuilder("SetPatternLibraryCommand.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), excetpion_p);
    }
  }
  
}
