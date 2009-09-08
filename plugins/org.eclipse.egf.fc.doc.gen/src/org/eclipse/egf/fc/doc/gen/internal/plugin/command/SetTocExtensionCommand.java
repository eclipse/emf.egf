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
package org.eclipse.egf.fc.doc.gen.internal.plugin.command;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * Implement a command that sets the <code>org.eclipse.help.toc</code> extension in plug-ins.
 * @author Guillaume Brocard
 */
public class SetTocExtensionCommand extends AbstractExtensionChangesCommand {
  /**
   * Define a constant for the 'primary' attribute.
   */
  private static final String ATT_PRIMARY = "primary"; //$NON-NLS-1$
  /**
   * Define a constant for the 'file' attribute.
   */
  private static final String ATT_FILE = "file"; //$NON-NLS-1$
  /**
   * Fully qualified extension-point id.
   */
  private static final String FULLY_QUALIFIED_EXTENSION_POINT_ID = "org.eclipse.help.toc"; //$NON-NLS-1$
  /**
   * TOC extension child tag.
   */
  private static final String TOC_EXTENSION_CHILD = "toc"; //$NON-NLS-1$
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetTocExtensionCommand.class.getPackage().getName());
  /**
   * Toc file name.
   */
  private String _tocFileName;

  /**
   * Constructor.
   * @param tocfileName_p
   */
  public SetTocExtensionCommand(String tocfileName_p) {
    _tocFileName = tocfileName_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return TOC_EXTENSION_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildIdAttribute()
   */
  @Override
  protected String getExtensionChildIdAttribute() {
    return ATT_FILE;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get and create the toc extension element.
    IPluginElement tocElement = getExtensionElementWithId(_tocFileName);
    try {
      // Set the package class name attribute.
      tocElement.setAttribute(ATT_PRIMARY, Boolean.FALSE.toString());
    } catch (CoreException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("SetTocExtensionCommand.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}