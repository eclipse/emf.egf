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
package org.eclipse.egf.pde.internal.plugin.command.context;

import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * Base class to implement commands that deal with context element based on a contract element reference in context extension-point.
 * @author fournier
 */
public abstract class AbstractCtxtEltBasedOnContractEltRefCmd extends AbstractContextElementCommand {
  /**
   * Contract element id value.
   */
  private String _contractElementReferenceId;

  /**
   * Constructor.
   * @param contextId_p
   *          id of the context used as parent.
   * @param contextElementId_p
   *          id of the context element.
   * @param contractElementReferenceId_p
   *          id of the contract element reference.
   * @param value_p
   *          value set as stringValue or classValue.
   */
  protected AbstractCtxtEltBasedOnContractEltRefCmd(String contextId_p, String contextElementId_p, String contractElementReferenceId_p, String value_p) {
    super(contextId_p, contextElementId_p, value_p);
    _contractElementReferenceId = contractElementReferenceId_p;
  }

  /**
   * Get the contract element reference id.
   * @return the contractElementReferenceId
   */
  protected String getContractElementReferenceIdAttributeValue() {
    return _contractElementReferenceId;
  }

  /**
   * Get the id attribute for contract element reference.
   * @return
   */
  protected String getContractElementReferenceIdAttribute() {
    return IFactoryComponentConstants.ATT_CONTRACT_ELEMENT_REFERENCE_ID;
  }

  /**
   * Set a contract element reference for given context element according to parameters values.
   * @param contextElement_p
   * @param contractReferenceNodeName_p
   * @param contractReferenceIdAttribute_p
   * @param contractReferenceIdAttributeValue_p
   */
  protected void setContractElementReference(IPluginElement contextElement_p, String contractReferenceNodeName_p, String contractReferenceIdAttribute_p,
      String contractReferenceIdAttributeValue_p) {
    setSingleChild(contextElement_p, contractReferenceNodeName_p, contractReferenceIdAttribute_p, contractReferenceIdAttributeValue_p);
  }
}
