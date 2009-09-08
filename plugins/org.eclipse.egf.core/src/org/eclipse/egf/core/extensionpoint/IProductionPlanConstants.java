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
 * Defines all constants related to a production plan into extension point declaration.
 * @author fournier
 */
public interface IProductionPlanConstants {
  
  /**
   * Define a constant for the production plan extension-point id.
   */
  static final String PRODUCTION_PLAN_EXTENSION_POINT_ID = "productionPlan"; //$NON-NLS-1$
  
  /**
   * Define a constant for the production plan extension-point id as a fully qualified id.
   */
  static final String FULLY_QUALIFIED_EXTENSION_POINT_ID = ExtensionPointHelper.getExtensionPointId(
    CoreActivator.getDefault().getPluginID(),
    PRODUCTION_PLAN_EXTENSION_POINT_ID
  );
  
  /**
   * Define a constant for the production plan extension-point child.
   */
  static final String PRODUCTION_PLAN_EXTENSION_CHILD = PRODUCTION_PLAN_EXTENSION_POINT_ID;
  
  /**
   * Define a constant for the 'id' attribute.
   */
  static final String PRODUCTION_PLAN_ATT_ID = "id"; //$NON-NLS-1$  
  
  /**
   * Define a constant for the 'contextId' attribute.
   */
  static final String PRODUCTION_PLAN_ATT_CONTEXT_ID = "contextId"; //$NON-NLS-1$
  
  /**
   * Define a constant for the production plan child.
   */
  static final String PRODUCTION_PLAN_CHILD_ASSET_CONFIGURATION = "assetConfiguration"; //$NON-NLS-1$
  
  /**
   * Define a constant for the 'id' attribute.
   */
  static final String ASSET_CONFIGURATION_ATT_ID = "id"; //$NON-NLS-1$  
  
}
