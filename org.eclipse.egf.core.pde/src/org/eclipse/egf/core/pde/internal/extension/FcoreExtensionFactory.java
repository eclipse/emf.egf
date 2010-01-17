/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.pde.internal.extension;

import org.eclipse.egf.core.pde.extension.IFcoreExtensionFactory;
import org.eclipse.egf.core.pde.plugin.IPluginChangesCommand;
import org.eclipse.emf.common.util.URI;

/**
 * This factory creates commands to deal with "fcore" extension-point.
 * 
 * @author fournier
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
   * @return
   */
  public static FcoreExtensionFactory getInstance() {
    if (__instance == null) {
      __instance = new FcoreExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.core.pde.extension.IFcoreExtensionFactory#setFcoreExtension(org.eclipse.emf.common.util.URI)
   */
  public IPluginChangesCommand setFcoreExtension(URI fcURI_p) {
    return new SetFcoreExtensionCommand(fcURI_p);
  }

  /**
   * @see org.eclipse.egf.core.pde.extension.IFcoreExtensionFactory#unsetFcoreExtension(org.eclipse.emf.common.util.URI)
   */
  public IPluginChangesCommand unsetFcoreExtension(URI fcURI_p) {
    return new UnsetFcoreExtensionCommand(fcURI_p);
  }

}