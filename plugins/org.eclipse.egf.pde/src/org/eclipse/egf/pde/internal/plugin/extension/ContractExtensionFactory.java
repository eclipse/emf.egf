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
package org.eclipse.egf.pde.internal.plugin.extension;

import java.util.List;

import org.eclipse.egf.pde.internal.plugin.command.contract.SetContractElementCommand;
import org.eclipse.egf.pde.internal.plugin.command.contract.SetContractExtensionCommand;
import org.eclipse.egf.pde.internal.plugin.command.contract.UnsetContractElementCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IContractExtensionFactory;


/**
 * This factory creates commands to deal with "Contract" extension-point.
 * @author fournier
 */
public class ContractExtensionFactory implements IContractExtensionFactory {
  /**
   * Unique reference.
   */
  private static ContractExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private ContractExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * @return
   */
  public static ContractExtensionFactory getInstance() {
    if (null == __instance) {
      __instance = new ContractExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContractExtensionFactory#setContract(java.lang.String)
   */
  public IPluginChangesCommand setContract(String contractId_p) {
    return new SetContractExtensionCommand(contractId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContractExtensionFactory#setContractElement(java.lang.String, java.lang.String, java.lang.String,
   *      java.lang.String, java.util.List, java.lang.String)
   */
  public IPluginChangesCommand setContractElement(String contractId_p, String contractElementId_p, String contractElementName_p, String contractElementType_p,
      List<String> contractElementReferenceIds_p, String mandatory_p, String description_p) {
    return new SetContractElementCommand(contractId_p, contractElementId_p, contractElementName_p, contractElementType_p, contractElementReferenceIds_p, mandatory_p, description_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContractExtensionFactory#unsetContractElement(java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand unsetContractElement(String contractId_p, String contractElementId_p) {
    return new UnsetContractElementCommand(contractId_p, contractElementId_p);
  }
}