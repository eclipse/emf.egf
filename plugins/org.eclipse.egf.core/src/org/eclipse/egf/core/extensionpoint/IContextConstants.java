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
package org.eclipse.egf.core.extensionpoint;

import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.CoreActivator;


/**
 * Defines all constants related to a context into extension point declaration.
 * @author fournier
 */
public interface IContextConstants {
  /**
   * Define a constant for the context extension-point id.
   */
  static final String CONTEXT_EXTENSION_POINT_ID = "context"; //$NON-NLS-1$

  /**
   * Define a constant for the context extension-point id as a fully qualified id.
   */
  static final String FULLY_QUALIFIED_EXTENSION_POINT_ID =
                                                           ExtensionPointHelper.getExtensionPointId(CoreActivator.getDefault().getPluginID(),
                                                                                                    CONTEXT_EXTENSION_POINT_ID);
  /**
   * Define a constant for the context extension-point child.
   */
  static final String CONTEXT_EXTENSION_CHILD = CONTEXT_EXTENSION_POINT_ID;
  /**
   * Define a constant for the context child.
   */
  static final String CONTEXT_CHILD = "contextElement"; //$NON-NLS-1$
  /**
   * Simple string key for a context element.
   */
  static final String CONTEXT_ELEMENT_KEY_CHILD = "key"; //$NON-NLS-1$
  /**
   * Context value child node.
   */
  static final String CONTEXT_ELEMENT_VALUE_CHILD = "contextValue"; //$NON-NLS-1$
}
