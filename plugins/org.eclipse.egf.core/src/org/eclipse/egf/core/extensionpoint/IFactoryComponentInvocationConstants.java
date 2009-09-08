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
 * Defines all constants related to an factory component invocation into extension point declaration.
 * @author fournier
 */
public interface IFactoryComponentInvocationConstants {
  /**
   * Define a constant for the FactoryComponentInvocation extension-point id.
   */
  static final String FACTORY_COMPONENT_INVOCATION_EXTENSION_POINT_ID = "assetConfiguration"; //$NON-NLS-1$
  /**
   * Define a constant for the factory component invocation extension-point id as a fully qualified id.
   */
  static final String FULLY_QUALIFIED_EXTENSION_POINT_ID =
                                                           ExtensionPointHelper.getExtensionPointId(CoreActivator.getDefault().getPluginID(),
                                                                                                    FACTORY_COMPONENT_INVOCATION_EXTENSION_POINT_ID);
  /**
   * Define a constant for the FactoryComponentInvocation extension-point child.
   */
  static final String FACTORY_COMPONENT_INVOCATION_EXTENSION_CHILD = FACTORY_COMPONENT_INVOCATION_EXTENSION_POINT_ID;
  /**
   * Define a constant for the 'name' attribute.
   */
  static final String FACTORY_COMPONENT_INVOCATION_ATT_NAME = "name"; //$NON-NLS-1$
  /**
   * Define a constant for the factory component Id attribute.
   */
  static final String FACTORY_COMPONENT_INVOCATION_ATT_FC_ID = "assetId"; //$NON-NLS-1$
  /**
   * Define a constant for the 'taskFactoryId' attribute.
   */
  static final String FACTORY_COMPONENT_INVOCATION_ATT_TASK_FACTORY_ID = "taskFactoryId"; //$NON-NLS-1$
  /**
   * Define a constant for the 'contextId' attribute.
   */
  static final String FACTORY_COMPONENT_INVOCATION_ATT_CONTEXT_ID = "contextId"; //$NON-NLS-1$
}
