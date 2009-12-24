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
package org.eclipse.egf.pattern.ui;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.pattern.ui.builder.FcoreListener;
import org.eclipse.egf.pde.EGFPDEPlugin;
import org.osgi.framework.BundleContext;

/**
 * Common plug-in activator.
 * 
 * @author Xavier Maysonnave
 */
public class EGFPatternUIPlugin extends EGFAbstractPlugin {

  /**
   * Shared instance.
   */
  protected static EGFPatternUIPlugin __plugin;

  /**
   * Get shared instance.
   * 
   * @return
   */
  public static EGFPatternUIPlugin getDefault() {
    return __plugin;
  }

  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
    EGFPDEPlugin.getDefault().addResourceFcoreListener(FcoreListener.INSTANCE);
  }

  @Override
  public void stop(BundleContext context_p) throws Exception {
    __plugin = null;
    EGFPDEPlugin.getDefault().removeResourceFcoreListener(FcoreListener.INSTANCE);
    super.stop(context_p);
  }

}
