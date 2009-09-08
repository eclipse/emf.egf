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

import org.eclipse.egf.core.extensionpoint.IContractReferenceConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement commands that deal with ContractElementReferences extension-point.
 * @author fournier
 */
public abstract class AbstractContractElementRefCmd extends AbstractExtensionChangesCommand {

  /**
   * Contract element reference id value.
   */
  private String _contractElementReferenceId;

  /**
   * Constructor.
   * @param contractElementReferenceId_p
   */
  protected AbstractContractElementRefCmd(String contractElementReferenceId_p) {
    _contractElementReferenceId = contractElementReferenceId_p;
  }

  /**
   * Get the contract element reference id value.
   * @return the contractElementReferenceId
   */
  protected String getContractElementReferenceId() {
    return _contractElementReferenceId;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IContractReferenceConstants.CONTRACT_REFERENCE_EXTENSION_POINT_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IContractReferenceConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }
}
