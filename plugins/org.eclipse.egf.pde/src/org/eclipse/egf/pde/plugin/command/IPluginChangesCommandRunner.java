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
package org.eclipse.egf.pde.plugin.command;

import java.util.List;

/**
 * Define a method to perform changes on plug-in files.<br>
 * Changes are implemented through {@link IPluginChangesCommand} objects.<br>
 * If the plug-in file doesn't exist, it will be created; otherwise it will be modified.<br>
 * Plug-in file can be open or not, it doesn't matter.
 * @author fournier
 */
public interface IPluginChangesCommandRunner {
  /**
   * Perform plug-in changes for given bundle id.<br>
   * The plug-in file is either created or modified depending on its existence.
   * @param bundleId_p
   * @param commands_p list of command that make changes.
   */
  public void performChangesOnPlugin(String bundleId_p, final List<IPluginChangesCommand> commands_p);

  /**
   * Perform plug-in manifest changes for given bundle id.<br>
   * The MANISFEST.MF file is modified.
   * @param bundleId_p
   * @param commands_p list of command that make changes.
   */
  public void performChangesOnManifest(String bundleId_p, final List<IPluginChangesCommand> commands_p);
}
