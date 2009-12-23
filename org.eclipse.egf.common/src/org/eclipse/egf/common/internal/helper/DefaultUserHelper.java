/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.internal.helper;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.IUserEnforcedHelper;


/**
 * A default {@link IUserEnforcedHelper} implementation.<br>
 * Leaves files untouched, considering it's always possible to write them.
 * @author Guillaume Brocard
 */
public class DefaultUserHelper implements IUserEnforcedHelper {
  
  /**
   * @see org.eclipse.egf.common.helper.IUserEnforcedHelper#makeFileWritable(org.eclipse.core.resources.IFile)
   */
  public IStatus makeFileWritable(IFile file_p) {
    return Status.OK_STATUS;
  }

  /**
   * @see org.eclipse.egf.common.helper.IUserEnforcedHelper#makeFileWritable(org.eclipse.core.resources.IFile, java.lang.Object)
   */
  public IStatus makeFileWritable(IFile file_p, Object display_p) {
    return Status.OK_STATUS;
  }
  
}