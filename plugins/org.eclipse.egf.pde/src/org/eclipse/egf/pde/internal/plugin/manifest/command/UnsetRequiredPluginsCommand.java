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
package org.eclipse.egf.pde.internal.plugin.manifest.command;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModel;

/**
 * Implement a command that removes required plug-ins from the <code>Require-Bundle</code> property of the manifest file.
 * @author Guillaume Brocard
 */
public class UnsetRequiredPluginsCommand extends AbstractRequiredPluginsCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(UnsetRequiredPluginsCommand.class.getPackage().getName());

  /**
   * Constructor.
   * @param requiredPlugins_p
   */
  public UnsetRequiredPluginsCommand(String[] requiredPlugins_p) {
    super(requiredPlugins_p);
  }

  /**
   * @see org.eclipse.egf.pde.internal.plugin.manifest.command.AbstractRequiredPluginsCommand#handleRequiredPlugin(java.lang.String,
   *      org.eclipse.pde.internal.core.ibundle.IBundlePluginModel, java.util.List)
   */
  @Override
  protected void handleRequiredPlugin(String requiredPlugin_p, IBundlePluginModel bundlePluginModel_p, List<IPluginImport> existingPluginImports_p) {
    // Get the plug-in base.
    IPluginBase pluginBase = bundlePluginModel_p.getPluginBase();
    // Get the required plug-in in existing ones.
    IPluginImport removedPluginImport = pluginImportExists(requiredPlugin_p, existingPluginImports_p);
    // If found, remove it from the plug-in base.
    if (null != removedPluginImport) {
      try {
        // Remove the import in the manifest.
        pluginBase.remove(removedPluginImport);
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("UnsetRequiredPluginsCommand.execute(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
  }
}