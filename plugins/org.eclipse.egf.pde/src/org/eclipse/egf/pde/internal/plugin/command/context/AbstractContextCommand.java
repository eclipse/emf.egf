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

import org.eclipse.egf.core.extensionpoint.IContextConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement commands that deal with context extension-point.
 * @author fournier
 */
public abstract class AbstractContextCommand extends AbstractExtensionChangesCommand {

  /**
   * Context id value.
   */
  private String _contextId;

  /**
   * Constructor.
   * @param contextId_p id of the context used as parent.
   */
  protected AbstractContextCommand(String contextId_p) {
    _contextId = contextId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IContextConstants.CONTEXT_EXTENSION_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IContextConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }

  /**
   * Get the context id value.
   * @return the contextId
   */
  protected String getContextId() {
    return _contextId;
  }
}