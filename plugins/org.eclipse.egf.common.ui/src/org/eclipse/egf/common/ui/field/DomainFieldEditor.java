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
package org.eclipse.egf.common.ui.field;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.widgets.Composite;

/**
 * Implements a field editor that allows the end-user to select an {@link IFile} used as domain.
 * @author fournier
 */
public class DomainFieldEditor extends WorkspaceFileFieldEditor {

  /**
   * Constructor.
   * @param title_p
   * @param openResourceDialogTitle_p
   * @param parent_p
   * @param container_p
   * @param filterExtension_p
   */
  public DomainFieldEditor(
    String title_p, 
    String openResourceDialogTitle_p, 
    Composite parent_p, 
    IContainer container_p, 
    String filterExtension_p
  ) {
    super(
      title_p, 
      openResourceDialogTitle_p, 
      parent_p, 
      container_p, 
      filterExtension_p
    );
  }

  /**
   * @see org.eclipse.egf.common.ui.field.WorkspaceFileFieldEditor#handleFilePath(org.eclipse.core.resources.IFile)
   */
  @Override
  protected String handleFilePath(IFile file_p) {
    // Remove first segment which is the project path.
    IPath result = file_p.getFullPath().removeFirstSegments(1);
    return result.toString();
  }
  
}
