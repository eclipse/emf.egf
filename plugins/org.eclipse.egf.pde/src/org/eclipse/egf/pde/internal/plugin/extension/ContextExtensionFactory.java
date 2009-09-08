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

import org.eclipse.egf.pde.internal.plugin.command.context.SetContextCommand;
import org.eclipse.egf.pde.internal.plugin.command.context.SetCtxtEltBasedOnContractEltRefCmd;
import org.eclipse.egf.pde.internal.plugin.command.context.SetCtxtEltBasedOnKeyCmd;
import org.eclipse.egf.pde.internal.plugin.command.context.UnsetContextCommand;
import org.eclipse.egf.pde.internal.plugin.command.context.UnsetContextElementCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory;

/**
 * This factory creates commands to deal with "context" extension-point.
 * @author fournier
 */
public class ContextExtensionFactory implements IContextExtensionFactory {
  /**
   * Unique reference.
   */
  private static ContextExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private ContextExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * @return
   */
  public static ContextExtensionFactory getInstance() {
    if (null == __instance) {
      __instance = new ContextExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory#setContextExtension(java.lang.String)
   */
  public IPluginChangesCommand setContextExtension(String contextId_p) {
    return new SetContextCommand(contextId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory#unsetContextExtension(java.lang.String)
   */
  public IPluginChangesCommand unsetContextExtension(String contextId_p) {
    return new UnsetContextCommand(contextId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory#setContextElementBasedOnContractElementRef(java.lang.String,
   *      java.lang.String, java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setContextElementBasedOnContractElementRef(String contextId_p, String contextElementId_p, String contractElementReferenceId_p,
      String value_p) {
    return new SetCtxtEltBasedOnContractEltRefCmd(contextId_p, contextElementId_p, contractElementReferenceId_p, value_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory#setContextElementBasedOnKey(java.lang.String, java.lang.String,
   *      java.lang.String, java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setContextElementBasedOnKey(String contextId_p, String contextElementId_p, String keyValue_p, String keyType_p, String value_p) {
    return new SetCtxtEltBasedOnKeyCmd(contextId_p, contextElementId_p, keyValue_p, keyType_p, value_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory#unsetContextElement(java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand unsetContextElement(String contextId_p, String contextElementId_p) {
    return new UnsetContextElementCommand(contextId_p, contextElementId_p);
  }
}