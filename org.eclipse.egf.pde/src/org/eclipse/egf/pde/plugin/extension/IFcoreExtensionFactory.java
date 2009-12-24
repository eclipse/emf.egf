/*******************************************************************************
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pde.plugin.extension;

import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.common.util.URI;

/**
 * This factory creates commands to deal with "fcore" extension-point.
 * 
 * @author fournier
 */
public interface IFcoreExtensionFactory {

  /**
   * Set an extension matching "fcore" extension-point for given parameters.
   * 
   * @param uri_p
   * @return an {@link IPluginChangesCommand} instance that performs this
   *         change.
   */
  public IPluginChangesCommand setFcoreExtension(URI uri_p);

  /**
   * Unset an existing extension matching "fcore" extension-point for given
   * parameters.
   * 
   * @param uri_p
   * @return an {@link IPluginChangesCommand} instance that performs this
   *         change.
   */
  public IPluginChangesCommand unsetFcoreExtension(URI uri_p);

}
