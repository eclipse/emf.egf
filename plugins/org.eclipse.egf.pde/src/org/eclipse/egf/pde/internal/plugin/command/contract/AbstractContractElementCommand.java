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
package org.eclipse.egf.pde.internal.plugin.command.contract;

import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * Base class to implement command that deal with Contract extension-point.
 * @author fournier
 */
public abstract class AbstractContractElementCommand extends AbstractContractCommand {
  /**
   * Contract element id.
   */
  private String _contractElementIdValue;

  protected AbstractContractElementCommand(String contractId_p, String contractElementId_p) {
    super(contractId_p);
    _contractElementIdValue = contractElementId_p;
  }

  /**
   * Get the contract element id attribute.
   * @return
   */
  protected String getIdAttribute() {
    return ExtensionPointHelper.ATT_ID;
  }

  /**
   * Get the value of the contract element id attribute.
   * @return
   */
  protected String getIdAttributeValue() {
    return _contractElementIdValue;
  }

  /**
   * Get the contract element.
   * @return
   */
  protected IPluginElement getContractElement() {
    IPluginElement result = null;
    // Get contract object.
    IPluginElement contract = getExtensionElementWithId(getContractId());
    // Retrieve the contract element.
    String idAttribute = getIdAttribute();
    String idAttributeValue = getIdAttributeValue();
    result = getElement(contract, IContractConstants.CONTRACT_ELEMENT_CHILD, idAttribute, idAttributeValue, true);
    return result;
  }
}
