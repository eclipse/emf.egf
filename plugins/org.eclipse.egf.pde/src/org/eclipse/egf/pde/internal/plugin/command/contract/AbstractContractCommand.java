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

import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement commands that deal with Contract extension-point.
 * @author fournier
 */
public abstract class AbstractContractCommand extends AbstractExtensionChangesCommand {
  /**
   * Contract id value.
   */
  private String _contractId;

  /**
   * Constructor.
   * @param contractId_p
   */
  protected AbstractContractCommand(String contractId_p) {
    _contractId = contractId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IContractConstants.CONTRACT_EXTENSION_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IContractConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }

  /**
   * Get the contract Id.
   * @return the contractId
   */
  protected String getContractId() {
    return _contractId;
  }
}
