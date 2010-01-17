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
package org.eclipse.egf.core.pde.plugin;

import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * Define an interface to implement commands that perform plug-in changes.<br>
 * Changes can be an extension adding operation.
 * @author fournier
 */
public interface IPluginChangesCommand {
  
  /**
   * Set the plug-in model that this command is performed against.
   * @param pluginModel_p
   */
  public void setPluginModelBase(IPluginModelBase pluginModel_p);

  /**
   * Performs changes on the underlying plug-in.
   */
  public void execute();
  
}
