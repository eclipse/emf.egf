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

/**
 * This command removes an existing extension matching ContractElementReferences extension-point.
 * @author fournier
 */
public class UnsetContractElementRefCmd extends AbstractContractElementRefCmd {

  /**
   * Constructor.
   * @param contractElementReferenceId_p
   */
  public UnsetContractElementRefCmd(String contractElementReferenceId_p) {
    super(contractElementReferenceId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    removeExtension(getContractElementReferenceId());
  }
}
