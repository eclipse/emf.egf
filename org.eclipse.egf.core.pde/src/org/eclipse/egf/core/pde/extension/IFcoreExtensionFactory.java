/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.pde.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.core.pde.plugin.IPluginChangesCommand;

/**
 * This factory creates commands to deal with "fcore" extension-point.
 * 
 * @author Xavier Maysonnave
 */
public interface IFcoreExtensionFactory {

  /**
   * Set an extension matching "fcore" extension-point for given parameters.
   * 
   * @param path
   * @return an {@link IPluginChangesCommand} instance that performs this
   *         change.
   */
  public IPluginChangesCommand setFcoreExtension(IPath path) throws CoreException;

  /**
   * Unset an existing extension matching "fcore" extension-point for given
   * parameters.
   * 
   * @param path
   * @return an {@link IPluginChangesCommand} instance that performs this
   *         change.
   */
  public IPluginChangesCommand unsetFcoreExtension(IPath path) throws CoreException;

}
