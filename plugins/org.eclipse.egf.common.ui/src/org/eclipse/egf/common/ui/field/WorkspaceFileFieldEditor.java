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
import org.eclipse.core.resources.IResource;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.toolkit.fields.StringBrowserFieldEditor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;


/**
 * Implements a field editor that allows the end-user to select an {@link IFile} in the workspace.
 * @author fournier
 */
public class WorkspaceFileFieldEditor extends StringBrowserFieldEditor {
  
  /**
   * Container used as root entry to open the filtered resource selection dialog.
   */
  private IContainer _container;
  
  /**
   * Open resource dialog title.
   */
  private String _openResourceDialogTitle;
  
  /**
   * Filter extension.
   */
  private String _filterExtension;

  /**
   * Constructor.
   * @param title_p label of the text widget.
   * @param openResourceDialogTitle_p label displayed in the open resource dialog.
   * @param parent_p
   * @param container_p container used in open resource dialog.
   * @param filterExtension_p file type filter (ie *.ecore).
   */
  public WorkspaceFileFieldEditor(
    String title_p, 
    String openResourceDialogTitle_p, 
    Composite parent_p, 
    IContainer container_p, 
    String filterExtension_p
  ) {
    super(
      ICommonConstants.EMPTY_STRING, 
      title_p, 
      parent_p, 
      null
    );
    _openResourceDialogTitle = openResourceDialogTitle_p;
    _container = container_p;
    _filterExtension = filterExtension_p;
  }

  /**
   * @see com.thalesgroup.mde.common.ui.toolkit.custom.CStringButtonFieldEditor#changePressed()
   */
  @Override
  protected String changePressed() {
    String fileName = null;
    // Open filtered resource selection dialog.
    FilteredResourcesSelectionDialog dialog = new FilteredResourcesSelectionDialog(getShell(), false, _container, IResource.FILE);
    // Set title.
    dialog.setTitle(_openResourceDialogTitle);
    // Set initial pattern.
    dialog.setInitialPattern(_filterExtension);
    // dialog.setInitialPattern(fileName)
    // Open it.
    int result = dialog.open();
    // If the end-user select something, handle it.
    if (result == IDialogConstants.OK_ID) {
      // Get returned files.
      Object[] files = dialog.getResult();
      if (null != files && files.length > 0) {
        // We are not in multi selection context.
        IFile file = (IFile) files[0];
        fileName = handleFilePath(file);
      }
    }
    return fileName;
  }

  /**
   * Allow to manage the content of the file path returned when the end-user has selected a resource.<br>
   * This implementation returns the full path of given file.
   * @param file_p
   * @return
   */
  protected String handleFilePath(IFile file_p) {
    return file_p.getFullPath().toString();
  }

  /**
   * Checks whether the text input field contains a valid value or not.
   * @param force_p true means force to compute the valid state again.
   * @return <code>true</code> if the field value is valid, and <code>false</code> if invalid.
   */
  public boolean isValid(boolean force_p) {
    if (force_p) {
      refreshValidState();
    }
    return super.isValid();
  }
  
}
