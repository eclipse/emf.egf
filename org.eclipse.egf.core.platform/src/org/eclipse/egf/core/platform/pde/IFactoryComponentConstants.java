/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.core.platform.pde;

import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;

/**
 * Defines all constants related to a factory component into extension point declaration.
 */
public interface IFactoryComponentConstants {
  
  /**
   * Define a constant for the Factory Component extension-point id.
   */
  public static final String FACTORY_COMPONENT_EXTENSION_POINT_ID = "factoryComponent"; //$NON-NLS-1$

  /**
   * Define a constant for the Factory Component extension-point id as a fully qualified id.
   */
  public static final String FULLY_QUALIFIED_EXTENSION_POINT_ID = ExtensionPointHelper.getExtensionPointId(
    EGFPlatformPlugin.getDefault().getPluginID(), 
    FACTORY_COMPONENT_EXTENSION_POINT_ID
  );
  
  /**
   * Define a constant for the Factory Component extension-point child.
   */
  static final String FACTORY_COMPONENT_EXTENSION_CHILD = FACTORY_COMPONENT_EXTENSION_POINT_ID;  
  
  /**
   * Define a constant for the 'id' attribute.
   */
  public static final String FACTORY_COMPONENT_ATT_ID = "id"; //$NON-NLS-1$
  
  /**
   * Define a constant for the Factory Component file extension.
   */
  public static final String FACTORY_COMPONENT_FILE_EXTENSION = "fc"; //$NON-NLS-1$  
  
}
