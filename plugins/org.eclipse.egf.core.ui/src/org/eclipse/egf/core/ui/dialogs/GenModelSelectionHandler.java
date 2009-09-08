/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */
package org.eclipse.egf.core.ui.dialogs;

import org.eclipse.core.resources.IFile;

import org.eclipse.emf.common.util.URI;

import org.eclipse.egf.common.misc.ISelectionHandler;


/**
 * @author Xavier Maysonnave
 */
public class GenModelSelectionHandler implements ISelectionHandler {
  
  /**
   * @see org.eclipse.egf.common.misc.ISelectionHandler#handleSelection(java.lang.Object)
   */
  public String handleSelection(Object selectedObject) {
    if (selectedObject instanceof IFile) {
      return URI.createPlatformResourceURI(((IFile) selectedObject).getFullPath().toString(), true).toString();
    }
    return null;
  }  

}
