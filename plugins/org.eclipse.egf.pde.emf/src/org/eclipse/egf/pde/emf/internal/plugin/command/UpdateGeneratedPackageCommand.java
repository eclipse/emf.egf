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
package org.eclipse.egf.pde.emf.internal.plugin.command;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * @author Guillaume Brocard
 */
public class UpdateGeneratedPackageCommand extends AbstractGeneratedPackageCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(UpdateGeneratedPackageCommand.class.getPackage().getName());
  /**
   * New package URI.
   */
  private String _newPackageUri;

  /**
   * Constructor.
   * @param oldPackageUri_p
   * @param newPackageUri_p
   */
  public UpdateGeneratedPackageCommand(String oldPackageUri_p, String newPackageUri_p) {
    super(oldPackageUri_p);
    _newPackageUri = newPackageUri_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get old package URI.
    String oldPackageUri = getUri();
    // Get the generated_package element.
    IPluginElement generatedPackage = getExtensionElementFromUniqueExtension(oldPackageUri, false);
    if (null != generatedPackage) {
      // Update the id of the retrieved element.
      try {
        generatedPackage.setAttribute(getExtensionChildIdAttribute(), _newPackageUri);
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("UpdateGeneratedPackageCommand.execute(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
  }
}
