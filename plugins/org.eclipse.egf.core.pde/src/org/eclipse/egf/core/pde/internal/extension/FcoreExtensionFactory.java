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
package org.eclipse.egf.core.pde.internal.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.core.pde.extension.IFcoreExtensionFactory;
import org.eclipse.egf.core.pde.plugin.IPluginChangesCommand;

/**
 * This factory creates commands to deal with "fcore" extension-point.
 * 
 * @author Xavier Maysonnave
 */
public class FcoreExtensionFactory implements IFcoreExtensionFactory {

  /**
   * Unique reference.
   */
  private static FcoreExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private FcoreExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * 
   * @return __instance
   */
  public static FcoreExtensionFactory getInstance() {
    if (__instance == null) {
      __instance = new FcoreExtensionFactory();
    }
    return __instance;
  }

  public IPluginChangesCommand setFcoreExtension(IPath path) throws CoreException {
    return new SetFcoreExtensionCommand(path);
  }

  public IPluginChangesCommand unsetFcoreExtension(IPath path) throws CoreException {
    return new UnsetFcoreExtensionCommand(path);
  }

}
