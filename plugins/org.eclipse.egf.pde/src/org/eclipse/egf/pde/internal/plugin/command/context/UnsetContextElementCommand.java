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
package org.eclipse.egf.pde.internal.plugin.command.context;

import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * @author fournier
 */
public class UnsetContextElementCommand extends AbstractContextElementCommand {

  /**
   * Constructor.
   * @param contextId_p
   * @param contextElementId_p
   */
  public UnsetContextElementCommand(String contextId_p, String contextElementId_p) {
    super(contextId_p, contextElementId_p, null); // the last parameter is not significant here.
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Get the extension where the context element is stored.
    IPluginElement extension = getExtensionElementWithId(getContextId());
    // Remove it from the extension.
    removeExtensionElementChild(extension, getContextElementIdAttribute(), getContextElementIdAttributeValue());
  }
}
