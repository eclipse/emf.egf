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
 * This command updates or creates a pattern library in an extension matching 'pattern' extension-point.
 * @author Guillaume Brocard
 */
public class SetPatternLibraryCommand extends AbstractPatternElementCommand {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetPatternLibraryCommand.class.getPackage().getName());
  
  /**
   * Reference to the pattern production orchestration.
   */
  private String _libraryProductionOrchestration;
  
  /**
   * Reference to the pattern runtime orchestration.
   */
  private String _libraryRuntimeOrchestration;

  /**
   * Constructor.
   * @param patternLibraryFullId_p
   * @param libraryName_p
   * @param productionOrchestration_p
   * @param runtimeOrchestration_p
   */
  public SetPatternLibraryCommand(String patternLibraryFullId_p, String libraryName_p, String productionOrchestration_p, String runtimeOrchestration_p) {
    super(patternLibraryFullId_p, libraryName_p);
    _libraryProductionOrchestration = productionOrchestration_p;
    _libraryRuntimeOrchestration = runtimeOrchestration_p;
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
    IPluginElement library = null;
    // Check parent library id is different from pattern element full id.
    if (parentLibraryFullId.equals(libraryFullId) == false) {
      IPluginElement parentLibrary = getLibrary(parentLibraryFullId);
      // Get the library (create it if the library does not exist yet).
      library = getPatternElement(
        parentLibrary, 
        getPatternElementId(), 
        IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY, 
        true
      );
    } else {
      // The library to create is a 'root' library.
      library = getLibrary(libraryFullId);
    }
    try {
      // Set its name.
      library.setAttribute(
        ExtensionPointHelper.ATT_NAME, 
        getPatternElementName()
      );
      // Set its production orchestration.
      library.setAttribute(
        IPatternConstants.LIBRARY_PRODUCTION_ORCHESTRATION_ATTRIBUTE_NAME, 
        _libraryProductionOrchestration
      );
      // Set its runtime orchestration.
      library.setAttribute(
        IPatternConstants.LIBRARY_RUNTIME_ORCHESTRATION_ATTRIBUTE_NAME, 
        _libraryRuntimeOrchestration
      );
    } catch (CoreException excetpion_p) {
      StringBuilder loggerMessage = new StringBuilder("SetPatternLibraryCommand.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), excetpion_p);
    }
  }
  
}
