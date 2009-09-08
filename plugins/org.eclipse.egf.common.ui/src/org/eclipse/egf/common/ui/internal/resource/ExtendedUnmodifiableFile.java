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
package org.eclipse.egf.common.ui.internal.resource;

import java.io.InputStream;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.helper.FileHelper;


/**
 * An {@link IFile} implementation that also handles a deployed file (as opposed to the one obtained from the workspace).<br>
 * No modification is allowed for such a file.
 * @author Guillaume Brocard
 */
public class ExtendedUnmodifiableFile extends File {
  /**
   * Constructor.
   * @param path_p
   */
  public ExtendedUnmodifiableFile(IPath path_p) {
    super(path_p, (Workspace) ResourcesPlugin.getWorkspace());
  }

  /**
   * @see org.eclipse.core.internal.resources.File#getContents(boolean)
   */
  @Override
  public InputStream getContents(boolean force_p) throws CoreException {
    return FileHelper.readFileAsStream(getFullPath().toString());
  }

  /**
   * @see org.eclipse.core.internal.resources.Resource#isReadOnly()
   */
  @Override  
  public boolean isReadOnly() {
    return true;
  }
  
}
