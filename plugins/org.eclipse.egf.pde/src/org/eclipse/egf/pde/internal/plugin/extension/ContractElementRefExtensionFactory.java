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

import org.eclipse.egf.pde.internal.plugin.command.contract.element.ref.SetContractElementRefCmd;
import org.eclipse.egf.pde.internal.plugin.command.contract.element.ref.UnsetContractElementRefCmd;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IContractElementRefExtensionFactory;

/**
 * This factory creates commands to deal with "ContractElementReferences" extension-point.
 * @author fournier
 */
public class ContractElementRefExtensionFactory implements IContractElementRefExtensionFactory {
  /**
   * Unique reference.
   */
  private static ContractElementRefExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private ContractElementRefExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * @return
   */
  public static ContractElementRefExtensionFactory getInstance() {
    if (null == __instance) {
      __instance = new ContractElementRefExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContractElementRefExtensionFactory#setContractElementReferenceExtension(java.lang.String,
   *      java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setContractElementReferenceExtension(String contractElementReferenceId_p, String referencedContractElementId_p,
      String referencedFcId_p) {
    return new SetContractElementRefCmd(contractElementReferenceId_p, referencedContractElementId_p, referencedFcId_p);
  }

  public IPluginChangesCommand unsetContractElementReferenceExtension(String contractElementReferenceId_p) {
    return new UnsetContractElementRefCmd(contractElementReferenceId_p);
  }
}
