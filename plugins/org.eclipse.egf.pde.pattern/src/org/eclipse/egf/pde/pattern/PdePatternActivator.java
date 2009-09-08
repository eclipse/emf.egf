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
package org.eclipse.egf.pde.pattern;

import org.eclipse.egf.common.activator.AbstractActivator;
import org.osgi.framework.BundleContext;


/**
 * @author Guillaume Brocard
 */
public class PdePatternActivator extends AbstractActivator {
  /**
   * The shared instance
   */
  private static PdePatternActivator __plugin;

  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context_p) throws Exception {
    __plugin = null;
    super.stop(context_p);
  }

  /**
   * Returns the shared instance
   * @return the shared instance
   */
  public static PdePatternActivator getDefault() {
    return __plugin;
  }
}
