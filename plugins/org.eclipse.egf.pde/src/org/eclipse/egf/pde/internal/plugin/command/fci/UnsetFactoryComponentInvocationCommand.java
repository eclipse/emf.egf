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
package org.eclipse.egf.pde.internal.plugin.command.fci;

/**
 * This command removes an extension matching factoryComponentConfiguration extension-point.
 * @author fournier
 */
public class UnsetFactoryComponentInvocationCommand extends AbstractFactoryComponentInvocationCommand {
  /**
   * Constructor.
   * @param factoryComponentInvocationId_p
   */
  public UnsetFactoryComponentInvocationCommand(String factoryComponentInvocationId_p) {
    super(factoryComponentInvocationId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    removeExtension(getFactoryComponentInvocationId());
  }
}
