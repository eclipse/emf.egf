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

import java.util.Collections;
import java.util.List;

import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;


/**
 * This factory creates commands to deal with "Contract" extension-point.
 * @author fournier
 */
public interface IContractExtensionFactory {
  /**
   * Set a new contract extension.
   * @param contractId_p
   * @return
   */
  public IPluginChangesCommand setContract(String contractId_p);

  /**
   * Set a contractElement object in a contract extension.
   * @param contractId_p
   * @param contractElementId_p
   * @param contractElementName_p
   * @param contractElementType_p
   * @param contractElementReferenceId_p if created contract element has no reference, use {@link Collections#EMPTY_LIST}.
   * @param mandatory_p
   * @param description_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand setContractElement(String contractId_p, String contractElementId_p, String contractElementName_p, String contractElementType_p,
      List<String> contractElementReferenceIds_p, String mandatory_p, String description_p);

  /**
   * Unset a contractElement object existing in a contract extension.
   * @param contractId_p
   * @param contractElementId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand unsetContractElement(String contractId_p, String contractElementId_p);
}
