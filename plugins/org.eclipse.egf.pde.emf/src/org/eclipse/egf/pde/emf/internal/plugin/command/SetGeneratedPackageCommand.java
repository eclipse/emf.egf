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
import org.eclipse.egf.common.constant.IEMFConstants;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * Implement a command that sets the <code>org.eclipse.emf.ecore.generated_package</code> extension in plug-ins.
 * @author Guillaume Brocard
 */
public class SetGeneratedPackageCommand extends AbstractGeneratedPackageCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetGeneratedPackageCommand.class.getPackage().getName());
  /**
   * A fully qualified Java class name of the generated package interface
   */
  private String _packageClassName_p;
  /**
   * A plug-in relative URI to the genmodel file for the package
   */
  private String _genModelPath_p;

  /**
   * Constructor.
   * @param uri_p An URI that uniquely identifies an Ecore package.
   * @param packageClassName_p A fully qualified Java class name of the generated package interface.
   * @param genModelPath_p A plug-in relative URI to the genmodel file for the package.
   */
  public SetGeneratedPackageCommand(String uri_p, String packageClassName_p, String genModelPath_p) {
    super(uri_p);
    _packageClassName_p = packageClassName_p;
    _genModelPath_p = genModelPath_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get and create the genPackage extension element.
    IPluginElement generatedPackageElement = getExtensionElementWithId(getUri());
    try {
      // Set the package class name attribute.
      generatedPackageElement.setAttribute(ExtensionPointHelper.ATT_CLASS, _packageClassName_p);
      // Set the genmodel path.
      generatedPackageElement.setAttribute(IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_ATT_GEN_MODEL, _genModelPath_p);
    } catch (CoreException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("SetGeneratedPackageCommand.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}