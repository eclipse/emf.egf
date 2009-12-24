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
package org.eclipse.egf.common.activator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.IUserEnforcedHelper;
import org.eclipse.egf.common.internal.helper.DefaultUserHelper;
import org.eclipse.egf.common.log.IEGFLogger;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.BundleContext;

/**
 * Common plug-in activator.
 * 
 * @author Guillaume Brocard
 */
public class EGFCommonPlugin extends EGFAbstractPlugin {

  /**
   * Extension point "user_helper" short id.
   */
  protected static final String EXTENSION_POINT_SHORT_ID_USER_HELPER = "user_helper"; //$NON-NLS-1$

  /**
   * EGF Registered loggers.
   */
  private static List<IEGFLogger> _egfLoggers;

  /**
   * User enforced helper.
   */
  private IUserEnforcedHelper _userHelper;

  /**
   * Shared instance.
   */
  protected static EGFCommonPlugin __plugin;

  /**
   * Get shared instance.
   * 
   * @return
   */
  public static EGFCommonPlugin getDefault() {
    return __plugin;
  }

  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
  }

  @Override
  public void stop(BundleContext context_p) throws Exception {
    __plugin = null;
    super.stop(context_p);
  }

  /**
   * Get user enforced helper unique implementation.
   * 
   * @return null if none could be found.
   */
  public IUserEnforcedHelper getUserEnforcedHelper() {
    // Lazy loading. Search for the implementation.
    if (_userHelper == null) {
      // Get extensions abiding to user helper extension point.
      IConfigurationElement[] configurationElements = ExtensionPointHelper.getConfigurationElements(getPluginID(), EXTENSION_POINT_SHORT_ID_USER_HELPER);
      if (configurationElements != null && configurationElements.length > 0) {
        // There should be one implementation only !
        // So take the first one, as expected.
        Object instantiatedClass = ExtensionPointHelper.createInstance(configurationElements[0]);
        // Make sure this is the correct resulting type.
        if (instantiatedClass instanceof IUserEnforcedHelper) {
          _userHelper = (IUserEnforcedHelper) instantiatedClass;
        }
      }
      // Could not find any user helper, use default one.
      if (_userHelper == null) {
        _userHelper = new DefaultUserHelper();
      }
    }
    return _userHelper;
  }

  /**
   * Get egf loggers implementations.
   * 
   * @return an empty list if none could be found.
   */
  public static List<IEGFLogger> getEGFLoggers() {
    // Lazy loading. Search for the implementation.
    if (_egfLoggers == null) {
      _egfLoggers = new ArrayList<IEGFLogger>();
      // Get EGF logger extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(EGFCommonPlugin.getDefault().getPluginID(), EXTENSION_POINT_LOGGER)) {
        Object object = ExtensionPointHelper.createInstance(configurationElement);
        // Make sure this is the correct resulting type.
        if (object instanceof IEGFLogger == false) {
          getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName()));
          getDefault().logInfo("This Class should be a sub-type of ''org.eclipse.egf.common.log.IEGFLogger''.", 1);
          getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1);
          getDefault().logInfo(NLS.bind("Extension-point ''{0}''", configurationElement.getName()), 1);
          continue;
        }
        _egfLoggers.add((IEGFLogger) object);
      }
    }
    return _egfLoggers;
  }

}
