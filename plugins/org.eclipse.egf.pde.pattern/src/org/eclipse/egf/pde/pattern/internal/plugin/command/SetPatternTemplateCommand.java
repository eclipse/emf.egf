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
import org.eclipse.egf.common.constant.IPatternTemplateConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates a generatedPattern in an extension matching <code>generatedPattern</code> extension-point.
 * @author Guillaume Brocard
 */
public class SetPatternTemplateCommand extends AbstractPatternTemplateCommand {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetPatternTemplateCommand.class.getPackage().getName());
  
  /**
   * Reference to the generated template class.
   */
  private String _templateClass;
  
  /**
   * Reference to the identifier of the template engine used to produce the pattern.
   */
  private String _templateType;
  
  /**
   * Reference to the identifier of the template path.
   */
  private String _templatePath;  

  /**
   * Constructor.
   * @param patternFullId_p
   * @param patternClass_p
   * @param patternType_p
   * @param patternPath_p  
   */
  public SetPatternTemplateCommand(String patternFullId_p, String templateClass_p, String templateType_p, String templatePath_p) {
    super(patternFullId_p);
    _templateClass = templateClass_p;
    _templateType = templateType_p;
    _templatePath = templatePath_p;    
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get the generated pattern short id.
    String patternFullId = getPatternFullId();
    // Get the generated pattern (create it if the pattern does not exist yet).
    IPluginElement generatedPattern = getExtensionElementFromUniqueExtension(patternFullId);
    try {
      // Set its type.
      generatedPattern.setAttribute(
        IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_TYPE, 
        _templateType
      );
      // Set its path
      generatedPattern.setAttribute(
        IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_PATH, 
        _templatePath
      );      
      // Set its class.
      if (_templateClass != null) {
        generatedPattern.setAttribute(
          IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_CLASS, 
          _templateClass
        );
      }
    } catch (CoreException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("SetPatternLibraryCommand.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }
  
}