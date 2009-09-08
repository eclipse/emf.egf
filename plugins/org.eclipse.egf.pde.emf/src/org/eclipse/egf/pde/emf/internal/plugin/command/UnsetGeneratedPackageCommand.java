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
package org.eclipse.egf.pde.emf.internal.plugin.command;

/**
 * Unset EMF 'generated_package' for specified URI.
 * @author Guillaume Brocard
 */
public class UnsetGeneratedPackageCommand extends AbstractGeneratedPackageCommand {
  /**
   * Constructor.
   * @param uri_p An URI that uniquely identifies an Ecore package.
   */
  public UnsetGeneratedPackageCommand(String uri_p) {
    super(uri_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    removeExtension(getUri());
  }
}
