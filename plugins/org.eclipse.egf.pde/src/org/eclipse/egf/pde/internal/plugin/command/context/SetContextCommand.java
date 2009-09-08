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

/**
 * This command updates or creates an extension matching context extension-point.
 * @author fournier
 */
public class SetContextCommand extends AbstractContextCommand {
  /**
   * Constructor.
   * @param contextId_p
   */
  public SetContextCommand(String contextId_p) {
    super(contextId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Create the context object.
    getExtensionElementWithId(getContextId());
  }
}
