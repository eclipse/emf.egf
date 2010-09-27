/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.processor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.emf.ecore.change.ChangeDescription;

/**
 * @author Xavier Maysonnave
 *
 */
public interface IFcoreProcessor {

    public void processPreUnload(IProgressMonitor monitor, IPlatformFcore fcore, ChangeDescription changeDescription) throws CoreException;

    public void processPostSave(IProgressMonitor monitor, IPlatformFcore fcore, ChangeDescription changeDescription) throws CoreException;

}
