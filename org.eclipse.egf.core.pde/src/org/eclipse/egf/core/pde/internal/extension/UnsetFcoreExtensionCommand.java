/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.core.pde.internal.extension;

import org.eclipse.emf.common.util.URI;

/**
 * This command unsets an existing extension matching 'fcore' extension-point.
 * 
 * @author fournier
 */
public class UnsetFcoreExtensionCommand extends AbstractFcoreExtensionCommand {

  /**
   * Constructor.
   * 
   * @param uri_p
   */
  public UnsetFcoreExtensionCommand(URI uri_p) {
    super(uri_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractUnsetExtensionCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    removeExtension(getURI());
  }

}