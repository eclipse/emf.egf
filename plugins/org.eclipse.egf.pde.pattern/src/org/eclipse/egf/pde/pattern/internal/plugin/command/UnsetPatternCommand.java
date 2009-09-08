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
package org.eclipse.egf.pde.pattern.internal.plugin.command;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command removes a pattern in an extension matching 'pattern' extension-point.
 * @author Guillaume Brocard
 */
public class UnsetPatternCommand extends AbstractPatternElementCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(UnsetPatternCommand.class.getPackage().getName());

  /**
   * @param patternElementFullId_p
   * @param patternElementName_p
   */
  public UnsetPatternCommand(String patternElementFullId_p) {
    super(patternElementFullId_p, null);
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
    // Get the pattern.
    IPluginElement pattern = getPatternElement(parentLibrary, patternId, IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN, false);
    // If the pattern plug-in element is successfully retrieved, delete it.
    if (null != pattern) {
      try {
        parentLibrary.remove(pattern);
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("UnsetPatternCommand.execute(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
  }
}
