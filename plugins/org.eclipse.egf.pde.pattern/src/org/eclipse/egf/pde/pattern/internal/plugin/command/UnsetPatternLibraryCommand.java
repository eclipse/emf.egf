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
 * This command removes a pattern library in an extension matching 'pattern' extension-point.
 * @author Guillaume Brocard
 */
public class UnsetPatternLibraryCommand extends AbstractPatternElementCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(UnsetPatternLibraryCommand.class.getPackage().getName());

  /**
   * Constructor.
   * @param patternElementFullId_p
   * @param patternElementName_p
   */
  public UnsetPatternLibraryCommand(String patternElementFullId_p) {
    super(patternElementFullId_p, null);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get the library full id.
    String libraryFullId = getPatternElementFullId();
    // Get the parent library.
    String parentLibraryFullId = getParentLibraryId();
    // Check parent library id is different from pattern element full id.
    if (!parentLibraryFullId.equals(libraryFullId)) {
      IPluginElement parentLibrary = getLibrary(parentLibraryFullId);
      // Get the library (create it if the library does not exist yet).
      String libraryId = getPatternElementId();
      IPluginElement library = getPatternElement(parentLibrary, libraryId, IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY, false);
      // If the library is successfully retrieved, remove it.
      try {
        parentLibrary.remove(library);
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("UnsetPatternLibraryCommand.execute(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);

      }
    } else {
      // The library to remove is a 'root' library.
      removeExtension(libraryFullId);
    }
  }
}
