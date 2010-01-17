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
package org.eclipse.egf.core.pde.internal.manifest;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModel;

/**
 * Implement a command that adds required plug-ins in the
 * <code>Require-Bundle</code> property of the manifest file.
 * 
 * @author Guillaume Brocard
 */
public class SetRequiredPluginsCommand extends AbstractRequiredPluginsCommand {

  /**
   * Are required plug-ins dependencies optional (true) or mandatory (false) ?
   */
  private boolean _optional;

  /**
   * Are required plug-ins dependencies to be re-exported (true) or not (false)
   * ?
   */
  private boolean _reexport;

  /**
   * Constructor.
   * 
   * @param requiredPlugins_p
   *          Plug-ins dependencies are considered mandatory.
   */
  public SetRequiredPluginsCommand(String[] requiredPlugins_p) {
    this(requiredPlugins_p, false, false);
  }

  /**
   * Constructor.
   * 
   * @param requiredPlugins_p
   * @param optional_p
   *          Are plug-ins dependencies optional (<code>true</code>) or
   *          mandatory (<code>false</code>) ?
   * @param reexport_p
   *          Are plug-ins dependencies to be re-exported (<code>true</code>) or
   *          not (<code>false</code>) ?
   */
  public SetRequiredPluginsCommand(String[] requiredPlugins_p, boolean optional_p, boolean reexport_p) {
    super(requiredPlugins_p);
    _optional = optional_p;
    _reexport = reexport_p;
  }

  /**
   * @see org.eclipse.egf.core.pde.internal.manifest.AbstractRequiredPluginsCommand#handleRequiredPlugin(java.lang.String,
   *      org.eclipse.pde.internal.core.ibundle.IBundlePluginModel,
   *      java.util.List)
   */
  @Override
  public void handleRequiredPlugin(String requiredPlugin_p, IBundlePluginModel bundlePluginModel_p, List<IPluginImport> existingPluginImports_p) {
    // Get the plug-in base.
    IPluginBase pluginBase = bundlePluginModel_p.getPluginBase();
    // Add a new import if not already declared in manifest file.
    IPluginImport pluginImport = pluginImportExists(requiredPlugin_p, existingPluginImports_p);
    if (pluginImport == null) {
      pluginImport = bundlePluginModel_p.createImport();
      try {
        // Set the import id based on required plug-in name.
        pluginImport.setId(requiredPlugin_p);
        // Set the import name based on required plug-in name.
        pluginImport.setName(requiredPlugin_p);
        // Add the newly created import in the manifest.
        pluginBase.add(pluginImport);
      } catch (CoreException ce) {
        EGFPDEPlugin.getDefault().logError(new String("SetRequiredPluginsCommand.execute(..) _ "), ce); //$NON-NLS-1$
      }
    }
    // Set optional and re-exported flags, whether the plug-in import already
    // existed or not.
    try {
      pluginImport.setOptional(_optional);
      pluginImport.setReexported(_reexport);
    } catch (CoreException ce) {
      EGFPDEPlugin.getDefault().logError(new String("SetRequiredPluginsCommand.handleRequiredPlugin(..) _ "), ce); //$NON-NLS-1$
    }
  }
}