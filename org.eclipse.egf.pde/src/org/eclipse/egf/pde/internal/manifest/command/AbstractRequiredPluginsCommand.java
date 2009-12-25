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
package org.eclipse.egf.pde.internal.manifest.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.common.helper.MiscHelper;
import org.eclipse.egf.pde.plugin.command.AbstractManifestChangesCommand;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModel;


/**
 * Implement a command that deals with required plug-ins in the <code>Require-Bundle</code> property of the manifest file.
 * @author Guillaume Brocard
 */
public abstract class AbstractRequiredPluginsCommand extends AbstractManifestChangesCommand {
  /**
   * List of required plug-ins to add in the dependencies part of the manifest file.
   */
  private String[] _requiredPlugins;

  /**
   * Constructor.
   * @param requiredPlugins_p
   */
  public AbstractRequiredPluginsCommand(String[] requiredPlugins_p) {
    _requiredPlugins = requiredPlugins_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.IPluginChangesCommand#execute()
   */
  @Override
  public void execute() {
    // Preconditions.
    super.execute();
    // Get the bundle model.
    IBundlePluginModel bundlePluginModel = getBundlePluginModel();
    // Get existing plug-in imports.
    List<IPluginImport> existingPluginImports = getExistingImports();
    // Loop over given required plug-ins to add them in the manifest (if they are not already declared).
    for (String requiredPlugin : getRequiredPlugins()) {
      handleRequiredPlugin(requiredPlugin, bundlePluginModel, existingPluginImports);
    }
  }

  /**
   * Handle a required plug-in contained in the array provided in the constructor.
   * @param requiredPlugin_p
   * @param bundlePluginModel_p
   * @param existingPluginImports_p
   */
  protected abstract void handleRequiredPlugin(String requiredPlugin_p, IBundlePluginModel bundlePluginModel_p, List<IPluginImport> existingPluginImports_p);

  /**
   * Whether or not a plug-in import exists for specified id in given list of plug-in import.
   * @param pluginImportId_p
   * @param existingPluginImports_p
   * @return not <code>null</code> means found.
   */
  protected IPluginImport pluginImportExists(String pluginImportId_p, List<IPluginImport> existingPluginImports_p) {
    IPluginImport result = null;
    Iterator<IPluginImport> imports = existingPluginImports_p.iterator();
    // Iterate over existing plug-in imports to find out one matching given id.
    while (imports.hasNext() && (null == result)) {
      IPluginImport currentPluginImport = imports.next();
      // Are ids equals ?
      if (currentPluginImport.getId().equals(pluginImportId_p)) {
        result = currentPluginImport;
      }
    }
    return result;
  }

  /**
   * Return the existing imports.
   * @return a not null list.
   */
  protected List<IPluginImport> getExistingImports() {
    List<IPluginImport> result = new ArrayList<IPluginImport>(0);
    // Get the plug-in base.
    IPluginBase pluginBase = getPluginModelBase().getPluginBase();
    // Get existing imports.
    result.addAll(MiscHelper.asList(pluginBase.getImports()));
    return result;
  }

  /**
   * Get the required plug-ins.
   * @return the requiredPlugins
   */
  protected String[] getRequiredPlugins() {
    return _requiredPlugins;
  }
}
