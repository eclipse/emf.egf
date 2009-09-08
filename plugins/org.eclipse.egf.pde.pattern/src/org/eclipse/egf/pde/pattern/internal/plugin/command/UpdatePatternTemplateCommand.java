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
import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * This command updates a generatedPattern in an extension matching <code>generatedPattern</code> extension-point.<br>
 * It updates the generated pattern id if the extension exists.
 * @author Guillaume Brocard
 */
public class UpdatePatternTemplateCommand extends AbstractPatternTemplateCommand {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(UpdatePatternTemplateCommand.class.getPackage().getName());
  
  /**
   * Value of the new pattern id.
   */
  private String _newPatternFullId;

  /**
   * Constructor.
   * @param oldPatternFullId_p
   */
  public UpdatePatternTemplateCommand(String oldPatternFullId_p, String newPatternFullId_p) {
    super(oldPatternFullId_p);
    _newPatternFullId = newPatternFullId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get the old generated pattern full id.
    String oldPatternFullId = getPatternFullId();
    // Get the generated pattern.
    IPluginElement generatedPattern = getExtensionElementFromUniqueExtension(oldPatternFullId, false);
    if (generatedPattern != null) {
      // Update the id of the retrieved element.
      try {
        generatedPattern.setAttribute(
          getExtensionChildIdAttribute(), 
          _newPatternFullId
        );
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("UpdateGeneratedPatternIdCommand.execute(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
  }
  
}