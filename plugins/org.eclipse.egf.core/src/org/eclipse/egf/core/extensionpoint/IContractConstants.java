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
 * Defines all constants related to a contract into extension point declaration.
 * @author fournier
 */
public interface IContractConstants {
  
  /**
   * Define a constant for the contract extension-point id.
   */
  static final String CONTRACT_EXTENSION_POINT_ID = "contract"; //$NON-NLS-1$
  
  /**
   * Define a constant for the contract extension-point id as a fully qualified id.
   */
  static final String FULLY_QUALIFIED_EXTENSION_POINT_ID = ExtensionPointHelper.getExtensionPointId(
    CoreActivator.getDefault().getPluginID(),
    CONTRACT_EXTENSION_POINT_ID
  );
  
  /**
   * Define a constant for the contract extension-point child.
   */
  static final String CONTRACT_EXTENSION_CHILD = CONTRACT_EXTENSION_POINT_ID;
  
  /**
   * Define a constant for the 'id' attribute.
   */
  static final String CONTRACT_ATT_ID = "id"; //$NON-NLS-1$  

  /**
   * Define a constant for the contract child.
   */
  static final String CONTRACT_ELEMENT_CHILD = "contractElement"; //$NON-NLS-1$
  
  /**
   * Define a constant for the 'id' attribute.
   */
  static final String CONTRACT_ELEMENT_ATT_ID = "id"; //$NON-NLS-1$  

  /**
   * Define a constant for the 'name' attribute.
   */
  static final String CONTRACT_ELEMENT_ATT_NAME = "name"; //$NON-NLS-1$

  /**
   * Define a constant for the 'value' attribute.
   */
  static final String CONTRACT_ELEMENT_CHILD_ATT_VALUE = "value"; //$NON-NLS-1$

  /**
   * Define a constant for the 'type' attribute.
   */
  static final String CONTRACT_ELEMENT_ATT_TYPE = "type"; //$NON-NLS-1$
  
  /**
   * Define a constant for the 'mandatory' attribute.
   */
  static final String CONTRACT_ELEMENT_ATT_MANDATORY = "mandatory"; //$NON-NLS-1$
  
  /**
   * Define a constant for the 'description' extension-point child.
   */
  static final String CONTRACT_ELEMENT_EXTENSION_CHILD_DESCRIPTION = "description"; //$NON-NLS-1$  
  
  /**
   * Define a constant for the 'contractElementRef' extension-point child.
   */
  static final String CONTRACT_ELEMENT_EXTENSION_CHILD_CONTRACT_ELEMENT_REFERENCE = "contractElementRef"; //$NON-NLS-1$
  
  /**
   * Define a constant for the 'contractElementReferenceId' attribute.
   */
  static final String CONTRACT_ELEMENT_REFERENCE_ATT_REF_ID = "contractElementReferenceId"; //$NON-NLS-1$  
  
}
