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

import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * This command removes a contractElement in an extension matching Contract extension-point.
 * @author fournier
 */
public class UnsetContractElementCommand extends AbstractContractElementCommand {

  /**
   * Constructor.
   * @param contractId_p
   * @param contractElementId_p
   */
  public UnsetContractElementCommand(String contractId_p, String contractElementId_p) {
    super(contractId_p, contractElementId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get the extension where the contract element is stored.
    IPluginElement extension = getFirstExtensionElement();
    // Remove it from the extension.
    removeExtensionElementChild(extension, getIdAttribute(), getIdAttributeValue());
  }
}
