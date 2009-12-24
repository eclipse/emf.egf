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
package org.eclipse.egf.common.activator;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.IUserEnforcedHelper;
import org.eclipse.egf.common.internal.helper.DefaultUserHelper;
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
   * Shared instance.
   */
  private static EGFCommonPlugin __plugin;

  /**
   * User enforced helper.
   */
  private IUserEnforcedHelper _userHelper;

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
        Object instantiatedClass = ExtensionPointHelper.createInstance(configurationElements[0], ExtensionPointHelper.ATT_CLASS);
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

}
