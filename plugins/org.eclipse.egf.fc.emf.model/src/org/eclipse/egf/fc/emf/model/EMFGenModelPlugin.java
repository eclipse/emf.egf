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
package org.eclipse.egf.fc.emf.model;

import org.osgi.framework.BundleContext;

import org.eclipse.egf.common.ui.activator.AbstractUIActivator;


/**
 * The activator class controls the plug-in life cycle
 */
public class EMFGenModelPlugin extends AbstractUIActivator {

  // The shared instance
  private static EMFGenModelPlugin __plugin;

  /**
   * The constructor
   */
  public EMFGenModelPlugin() {
    // Nothing to do
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  public void stop(BundleContext context) throws Exception {
    __plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static EMFGenModelPlugin getDefault() {
    return __plugin;
  }

}
