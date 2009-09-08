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
 * Defines all constants related to a factory component into extension point declaration.
 * @author fournier
 */
public interface IFactoryComponentConstants {
  
  /**
   * Define a constant for the factoryComponent extension-point id.
   */
  static final String FACTORY_COMPONENT_EXTENSION_POINT_ID = "factoryComponent"; //$NON-NLS-1$

  /**
   * Define a constant for the factoryComponent extension-point id as a fully qualified id.
   */
  static final String FULLY_QUALIFIED_EXTENSION_POINT_ID = ExtensionPointHelper.getExtensionPointId(
    CoreActivator.getDefault().getPluginID(), 
    FACTORY_COMPONENT_EXTENSION_POINT_ID
  );
  
  /**
   * Define a constant for the factoryComponent extension-point child.
   */
  static final String FACTORY_COMPONENT_EXTENSION_CHILD = FACTORY_COMPONENT_EXTENSION_POINT_ID;
  
  /**
   * Define a constant for the description extension-point child.
   */
  static final String FACTORY_COMPONENT_EXTENSION_CHILD_DESCRIPTION = "description"; //$NON-NLS-1$  
  
  /**
   * Define a constant for the 'id' attribute.
   */
  static final String FACTORY_COMPONENT_ATT_ID = "id"; //$NON-NLS-1$  
  
  /**
   * Define a constant for the 'name' attribute.
   */
  static final String FACTORY_COMPONENT_ATT_NAME = "name"; //$NON-NLS-1$
  
  /**
   * Define a constant for the 'domain' attribute.
   */
  static final String FACTORY_COMPONENT_ATT_DOMAIN = "domain"; //$NON-NLS-1$

  /**
   * Define a constant for the 'contractId' attribute.
   */
  static final String FACTORY_COMPONENT_ATT_CONTRACT_ID = "contractId"; //$NON-NLS-1$

  /**
   * Define a constant for the 'productionPlanId' attribute.
   */
  static final String FACTORY_COMPONENT_ATT_PRODUCTION_PLAN_ID = "productionPlanId"; //$NON-NLS-1$
  
  /**
   * Define the factory component id for the bootstrap factoryComponent.
   */
  static final String ROOT_FACTORY_COMPONENT_ID = "rootAsset"; //$NON-NLS-1$
  
  /**
   * Define a constant for the contract reference id attribute.
   */
  static final String ATT_CONTRACT_ELEMENT_REFERENCE_ID = "contractElementReferenceId"; //$NON-NLS-1$
  
  /**
   * Contract reference key for a context element.
   */
  static final String CONTRACT_REF_CHILD = "contractElementRef"; //$NON-NLS-1$
  
}
