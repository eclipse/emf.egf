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
package org.eclipse.egf.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.task.ITask;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCorePlugin extends EGFAbstractPlugin {

  /**
   * Extension point "type".
   * 
   */
  protected static final String EXTENSION_POINT_TASK = "task"; //$NON-NLS-1$  

  /**
   * EGF Registered Tasks.
   * 
   */
  private static Map<String, IConfigurationElement> __tasks;

  /**
   * Plug-in unique instance.
   */
  private static EGFCorePlugin __plugin;

  /**
   * Get activator shared instance.
   * 
   * @return
   */
  public static EGFCorePlugin getDefault() {
    return __plugin;
  }

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
    __tasks = null;
    __plugin = null;
    super.stop(context_p);
  }

  /**
   * Create a task instance.
   * 
   * @return a null object if none could be found.
   */
  public static ITask createTaskInstance(String taskId_p) {
    if (taskId_p == null || taskId_p.trim().length() == 0) {
      return null;
    }
    IConfigurationElement configurationElement = getTasks().get(taskId_p.trim());
    if (configurationElement == null) {
      return null;
    }
    return (ITask) ExtensionPointHelper.createInstance(configurationElement);
  }

  /**
   * Get Tasks.
   * 
   * @return an empty map if none could be found.
   */
  private static Map<String, IConfigurationElement> getTasks() {
    // Lazy loading.
    if (__tasks == null) {
      __tasks = new HashMap<String, IConfigurationElement>();
      // Get EGF logger extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(getDefault().getBundle().getSymbolicName(), EXTENSION_POINT_TASK)) {
        // Id retrieval
        String id = ExtensionPointHelper.getId(configurationElement);
        // Ignore
        if (id == null || id.trim().length() == 0) {
          continue;
        }
        id = id.trim();
        // Check
        if (__tasks.containsKey(id)) {
          getDefault().logError(NLS.bind("Duplicate Id {0}", id));
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1);
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1);
          continue;
        }
        // Check instance
        Object object = ExtensionPointHelper.createInstance(configurationElement);
        if (object instanceof ITask == false) {
          getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName()));
          getDefault().logInfo("Class should be a Sub-Type of ''org.eclipse.egf.core.task.ITask''.", 1);
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1);
          getDefault().logInfo(NLS.bind("Extension-Point ''{0}''", configurationElement.getName()), 1);
          getDefault().logInfo(NLS.bind("Id ''{0}''", id), 1);
          continue;
        }
        __tasks.put(id, configurationElement);
      }
    }
    return __tasks;
  }

}