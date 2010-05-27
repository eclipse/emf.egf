/*******************************************************************************
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.pde.internal.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * This command updates or creates an extension matching 'fcore'
 * extension-point.
 * 
 * @author Xavier Maysonnave
 */
public class SetFcoreExtensionCommand extends AbstractFcoreExtensionCommand {

  /**
   * Constructor.
   * 
   * @param path
   */
  public SetFcoreExtensionCommand(IPath path) throws CoreException {
    super(path);
  }

  /**
   * @see org.eclipse.egf.core.pde.plugin.AbstractChangesCommand#doExecute()
   */
  @Override
  public void doExecute(IProgressMonitor monitor) throws CoreException {
    createExtensionElement();
  }

}
