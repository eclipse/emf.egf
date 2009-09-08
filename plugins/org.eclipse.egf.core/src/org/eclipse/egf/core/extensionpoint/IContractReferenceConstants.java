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
 * Defines all constants related to a contract reference into extension point declaration.
 * @author fournier
 */
public interface IContractReferenceConstants {
  /**
   * Define a constant for the contract reference extension-point id.
   */
  static final String CONTRACT_REFERENCE_EXTENSION_POINT_ID = "contractReferences"; //$NON-NLS-1$
  /**
   * Define a constant for the contract reference extension-point id as a fully qualified id.
   */
  static final String FULLY_QUALIFIED_EXTENSION_POINT_ID =
                                                           ExtensionPointHelper.getExtensionPointId(CoreActivator.getDefault().getPluginID(),
                                                                                                    CONTRACT_REFERENCE_EXTENSION_POINT_ID);
  /**
   * Define a constant for the contract reference extension-point child.
   */
  static final String CONTRACT_REFERENCE_EXTENSION_POINT_CHILD = "contractElementReference"; //$NON-NLS-1$
  /**
   * Define a constant for the 'referencedContractElementName' attribute.
   * @deprecated
   */
  static final String CONTRACT_REFERENCE_ATT_REFERENCED_CONTRACT_ELEMENT_NAME = "referencedContractElementName"; //$NON-NLS-1$
  /**
   * Define a constant for the 'referencedContractElementName' attribute.
   */
  static final String CONTRACT_REFERENCE_ATT_REFERENCED_CONTRACT_ELEMENT_ID = "referencedContractElementId"; //$NON-NLS-1$
  /**
   * Define a constant for the referenced factory component Id attribute.
   */
  static final String CONTRACT_REFERENCE_ATT_REFERENCED_FACTORY_COMPONENT_ID = "referencedAssetId"; //$NON-NLS-1$
}
