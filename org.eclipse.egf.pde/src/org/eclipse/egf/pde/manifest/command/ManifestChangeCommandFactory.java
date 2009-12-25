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
package org.eclipse.egf.pde.manifest.command;

import org.eclipse.egf.pde.internal.manifest.command.SetExportedPackagesCommand;
import org.eclipse.egf.pde.internal.manifest.command.SetRequiredPluginsCommand;
import org.eclipse.egf.pde.internal.manifest.command.UnsetExportedPackagesCommand;
import org.eclipse.egf.pde.internal.manifest.command.UnsetRequiredPluginsCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;

/**
 * Implement a factory to create command that change the plug-in manifest file.
 * @author Guillaume Brocard
 */
public class ManifestChangeCommandFactory {
  /**
   * Create set required plug-ins command for given ones.
   * @param requiredPlugins_p the required plug-ins to add.
   * @return
   */
  public static IPluginChangesCommand setRequiredPlugins(String[] requiredPlugins_p) {
    return new SetRequiredPluginsCommand(requiredPlugins_p);
  }

  /**
   * Create set required plug-ins command for given ones.
   * @param requiredPlugins_p the plug-ins dependencies to add.
   * @param optional_p Are plug-ins dependencies optional (<code>true</code>) or mandatory (<code>false</code>) ?
   * @return
   */
  public static IPluginChangesCommand setRequiredPlugins(String[] requiredPlugins_p, boolean optional_p) {
    return new SetRequiredPluginsCommand(requiredPlugins_p, optional_p, false);
  }

  /**
   * Create set required plug-ins command for given ones.
   * @param requiredPlugins_p the plug-ins dependencies to add.
   * @param optional_p Are plug-ins dependencies optional (<code>true</code>) or mandatory (<code>false</code>) ?
   * @param reexport_p Are plug-ins dependencies to be re-exported (<code>true</code>) or not (<code>false</code>) ?
   * @return
   */
  public static IPluginChangesCommand setRequiredPlugins(String[] requiredPlugins_p, boolean optional_p, boolean reexport_p) {
    return new SetRequiredPluginsCommand(requiredPlugins_p, optional_p, reexport_p);
  }

  /**
   * Create unset required plug-ins command for given ones.
   * @param requiredPlugins_p the required plug-ins to remove.
   * @return
   */
  public static IPluginChangesCommand unsetRequiredPlugins(String[] requiredPlugins_p) {
    return new UnsetRequiredPluginsCommand(requiredPlugins_p);
  }

  /**
   * Create set exported packages command for given ones.
   * @param exportedPackages_p the exported packages to add.
   * @return
   */
  public static IPluginChangesCommand setExportedPackages(String[] exportedPackages_p) {
    return new SetExportedPackagesCommand(exportedPackages_p);
  }

  /**
   * Create unset exported packages command for given ones.
   * @param exportedPackages_p the exported packages to remove.
   * @return
   */
  public static IPluginChangesCommand unsetExportedPackages(String[] exportedPackages_p) {
    return new UnsetExportedPackagesCommand(exportedPackages_p);
  }
  
}
