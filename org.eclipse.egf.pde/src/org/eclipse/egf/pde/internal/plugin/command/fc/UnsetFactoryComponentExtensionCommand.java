/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.pde.internal.plugin.command.fc;

import org.eclipse.emf.common.util.URI;

/**
 * This command unsets an existing extension matching factoryComponent extension-point.
 * @author fournier
 */
public class UnsetFactoryComponentExtensionCommand extends AbstractFactoryComponentExtensionCommand {
  
  /**
   * Constructor.
   * @param factoryComponentURI_p
   */
  public UnsetFactoryComponentExtensionCommand(URI factoryComponentURI_p) {
    super(factoryComponentURI_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractUnsetExtensionCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    removeExtension(getFactoryComponentURI());
  }
  
}