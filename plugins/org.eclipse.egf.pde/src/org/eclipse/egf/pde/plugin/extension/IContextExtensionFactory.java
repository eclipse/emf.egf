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
 * This factory creates commands to deal with "context" extension-point.
 * @author fournier
 */
public interface IContextExtensionFactory {
  /**
   * Set an extension matching "context" extension-point for given parameters.
   * @param contextId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand setContextExtension(String contextId_p);

  /**
   * Unset an extension matching "context" extension-point for given parameters.
   * @param contextId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand unsetContextExtension(String contextId_p);

  /**
   * Set a context element based on a contract element reference in a context extension for given parameters.
   * @param contextId_p context that the context element is added in.
   * @param contextElementId_p id of the created context element.
   * @param contractElementReferenceId_p reference to a contract element defined in a ContractReferences extension-point.
   * @param value_p string value.
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand setContextElementBasedOnContractElementRef(String contextId_p, String contextElementId_p, String contractElementReferenceId_p,
      String value_p);

  /**
   * Set a context element based on a key in a context extension for given parameters.
   * @param contextId_p context that the context element is added in.
   * @param contextElementId_p id of the created context element.
   * @param keyValue_p key value.
   * @param keyType_p key type.
   * @param value_p the value to set.
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand setContextElementBasedOnKey(String contextId_p, String contextElementId_p, String keyValue_p, String keyType_p, String value_p);

  /**
   * Unset a context element from a context extension for given parameters.
   * @param contextId_p
   * @param contextElementId_p
   * @return
   */
  public IPluginChangesCommand unsetContextElement(String contextId_p, String contextElementId_p);
}
