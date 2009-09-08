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
package org.eclipse.egf.mapping;

import org.eclipse.egf.common.activator.AbstractActivator;
import org.eclipse.egf.mapping.data.MappingServices;
import org.eclipse.egf.mapping.internal.MappingHelper;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle.
 * @author Guillaume Brocard
 */
public class EgfMappingActivator extends AbstractActivator {
  /**
   * The shared instance
   */
  private static EgfMappingActivator __plugin;

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
  }

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
  public static EgfMappingActivator getDefault() {
    return __plugin;
  }

  /**
   * Returns the mapping services related to given mapping id.<br>
   * The mapping id must be defined within a mapping located in a factory component either in the workspace or in the target platform.
   * @param mappingId_p
   * @return a {@link MappingServices} instance or null if not found.
   */
  public MappingServices getMappingServices(String mappingId_p) {
    return MappingHelper.getMappingServices(mappingId_p);
  }
}