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
 * Defines all constants related to a task factory into extension point declaration.
 * @author fournier
 */
public interface ITaskFactoryConstants {
  /**
   * Define a constant for the task factory extension-point id.
   */
  static final String TASK_FACTORY_EXTENSION_POINT_ID = "taskFactory"; //$NON-NLS-1$
  /**
   * Define a constant for the task factory extension-point id as a fully qualified id.
   */
  static final String FULLY_QUALIFIED_EXTENSION_POINT_ID =
                                                           ExtensionPointHelper.getExtensionPointId(CoreActivator.getDefault().getPluginID(),
                                                                                                    TASK_FACTORY_EXTENSION_POINT_ID);
  /**
   * Define a constant for the task factory extension-point child.
   */
  static final String TASK_FACTORY_EXTENSION_POINT_CHILD = TASK_FACTORY_EXTENSION_POINT_ID;
}
