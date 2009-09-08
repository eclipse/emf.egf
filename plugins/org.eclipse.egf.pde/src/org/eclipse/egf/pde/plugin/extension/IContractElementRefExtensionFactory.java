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
package org.eclipse.egf.pde.plugin.extension;

import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;

/**
 * This factory creates commands to deal with "ContractElementReferences" extension-point.
 * @author fournier
 */
public interface IContractElementRefExtensionFactory {

  /**
   * Set an extension matching "ContractElementReferences" extension-point for given parameters.
   * @param contractElementReferenceId_p
   * @param referencedContractElementId_p
   * @param referencedFcId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand setContractElementReferenceExtension(String contractElementReferenceId_p, String referencedContractElementId_p,
      String referencedFcId_p);

  /**
   * Unset an extension matching "ContractElementReferences" extension-point for given parameters.
   * @param contractElementReferenceId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand unsetContractElementReferenceExtension(String contractElementReferenceId_p);
}
