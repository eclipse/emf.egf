/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.core.invocation;

import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.EGFCorePlugin;

/**
 * Defines all constants related to an Invocation into extension point
 * declaration.
 */
public interface IInvocationConstants {

  /**
   * Define a constant for the Invocation extension-point id.
   */
  public static final String INVOCATION_EXTENSION_POINT_ID = "invocation"; //$NON-NLS-1$

  /**
   * Define a constant for the Invocation extension-point id as a fully
   * qualified id.
   */
  public static final String FULLY_QUALIFIED_EXTENSION_POINT_ID = ExtensionPointHelper.getExtensionPointId(EGFCorePlugin.getDefault().getPluginID(), INVOCATION_EXTENSION_POINT_ID);

  /**
   * Define a constant for the Invocation extension-point child.
   */
  static final String INVOCATION_EXTENSION_CHILD = INVOCATION_EXTENSION_POINT_ID;

  /**
   * Define a constant for the 'id' attribute.
   */
  public static final String INVOCATION_ATT_ID = "id"; //$NON-NLS-1$    

  /**
   * Define a constant for the 'class' attribute.
   */
  public static final String INVOCATION_ATT_CLASS = "class"; //$NON-NLS-1$  

}
