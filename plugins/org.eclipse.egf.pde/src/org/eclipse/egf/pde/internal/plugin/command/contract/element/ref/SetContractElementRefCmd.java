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
package org.eclipse.egf.pde.internal.plugin.command.contract.element.ref;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.extensionpoint.IContractReferenceConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates a contractElementReference in an extension matching ContractElementReferences extension-point.
 * @author fournier
 */
public class SetContractElementRefCmd extends AbstractContractElementRefCmd {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetContractElementRefCmd.class.getPackage().getName());
  /**
   * Referenced contract element id value.
   */
  private String _referencedContractElementId;
  /**
   * Referenced factory component id value.
   */
  private String _referencedFcId;

  /**
   * Constructor.
   * @param contractElementReferenceId_p
   * @param referencedContractElementId_p
   * @param referencedAssedId_p
   */
  public SetContractElementRefCmd(String contractElementReferenceId_p, String referencedContractElementId_p, String referencedAssedId_p) {
    super(contractElementReferenceId_p);
    _referencedContractElementId = referencedContractElementId_p;
    _referencedFcId = referencedAssedId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    IPluginElement contractElementReference = getExtensionElementFromUniqueExtension(getContractElementReferenceId());
    try {
      // Set the contract element reference id.
      contractElementReference.setAttribute(getExtensionChildIdAttribute(), getContractElementReferenceId());
      // Set the referenced contract element name
      contractElementReference.setAttribute(IContractReferenceConstants.CONTRACT_REFERENCE_ATT_REFERENCED_CONTRACT_ELEMENT_ID, _referencedContractElementId);
      // Set the referenced factory component id
      contractElementReference.setAttribute(IContractReferenceConstants.CONTRACT_REFERENCE_ATT_REFERENCED_FACTORY_COMPONENT_ID, _referencedFcId);
    } catch (CoreException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("SetContractElementRefCmd.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}
