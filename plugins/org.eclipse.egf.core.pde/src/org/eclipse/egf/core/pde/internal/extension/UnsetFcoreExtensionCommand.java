/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.core.pde.internal.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * This command unsets an existing extension matching 'fcore' extension-point.
 * 
 * @author Xavier Maysonnave
 */
public class UnsetFcoreExtensionCommand extends AbstractFcoreExtensionCommand {

    /**
     * Constructor.
     * 
     * @param path
     */
    public UnsetFcoreExtensionCommand(IPath path) throws CoreException {
        super(path);
    }

    @Override
    public void doExecute(IProgressMonitor monitor) throws CoreException {
        removeExtensionElement();
    }

}
