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

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates a contractElement in an extension matching Contract extension-point.
 * @author fournier
 */
public class SetContractElementCommand extends AbstractContractElementCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger _logger = Logger.getLogger(SetContractElementCommand.class.getPackage().getName());
  /**
   * Contract element name.
   */
  private String _contractElementName;
  /**
   * Contract element type.
   */
  private String _contractElementType;
  /**
   * Contract element reference id value (if defined)
   */
  private List<String> _contractElementReferenceIds;
  /**
   * Contract element mandatory attribute.
   */
  private String _mandatory;
  /**
   * Description attribute.
   */
  private String _description;

  /**
   * Constructor.
   * @param contractId_p
   * @param contractElementName_p
   * @param contractElementType_p
   * @param contractElementReferenceIds_p if created contract element has no reference, use {@link Collections#EMPTY_LIST}
   * @param mandatory_p
   */
  public SetContractElementCommand(String contractId_p, String contractElementId_p, String contractElementName_p, String contractElementType_p,
      List<String> contractElementReferenceIds_p, String mandatory_p, String description_p) {
    super(contractId_p, contractElementId_p);
    _contractElementName = contractElementName_p;
    _contractElementType = contractElementType_p;
    _contractElementReferenceIds = contractElementReferenceIds_p;
    _mandatory = mandatory_p;
    _description = description_p;
  }

  /**
   * @see org.eclipse.egf.internal.pde.plugin.command.contract.SetContractExtensionCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Look up for a contractElement related to contractElement name.
    IPluginElement contractChild = getContractElement();
    try {
      // Set the description first.
      setDescription(contractChild, getIdAttributeValue(), _description);
      // Set attributes.
      contractChild.setAttribute(IContractConstants.CONTRACT_ELEMENT_ATT_NAME, _contractElementName);
      contractChild.setAttribute(IContractConstants.CONTRACT_ELEMENT_ATT_TYPE, _contractElementType);
      contractChild.setAttribute(IContractConstants.CONTRACT_ELEMENT_ATT_MANDATORY, _mandatory);
    } catch (CoreException exception_p) {
      StringBuffer loggerMessage = new StringBuffer("SetContractElementCommand.execute(..) _ "); //$NON-NLS-1$
      _logger.warn(loggerMessage.toString(), exception_p);
    }
    // Set the contractElementReference if defined.
    for (String contractElementReferenceId : _contractElementReferenceIds) {
      setSingleChild(contractChild, IFactoryComponentConstants.CONTRACT_REF_CHILD, IFactoryComponentConstants.ATT_CONTRACT_ELEMENT_REFERENCE_ID, contractElementReferenceId);
    }
  }
}
