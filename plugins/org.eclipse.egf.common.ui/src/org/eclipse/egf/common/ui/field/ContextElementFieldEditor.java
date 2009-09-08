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

import org.eclipse.egf.common.misc.ISelectionHandler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.SelectionDialog;


/**
 * Implements a field editor that allows the end-user to enter a context element value.
 * @author Guillaume Brocard
 */
public class ContextElementFieldEditor extends JavaClassFieldEditor {
  
  /**
   * Selection handler to use if provided.
   */
  private ISelectionHandler _selectionHandler;

  /**
   * Constructor.
   * @param title_p
   * @param openTypeDialogTitle_p
   * @param parent_p
   * @param classTypeFilter_p
   */
  public ContextElementFieldEditor(
    String title_p, 
    String openTypeDialogTitle_p, 
    Composite parent_p, 
    Class<?> classTypeFilter_p
  ) {
    super(
      title_p, 
      openTypeDialogTitle_p, 
      parent_p, 
      classTypeFilter_p
    );
  }

  /**
   * @see org.eclipse.egf.common.ui.field.JavaClassFieldEditor#handleSelection(java.lang.Object)
   */
  @Override
  protected String handleSelection(Object selectedObject_p) {
    String result = null;
    if (null != _selectionHandler) {
      result = _selectionHandler.handleSelection(selectedObject_p);
    } else {
      result = super.handleSelection(selectedObject_p);
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.common.ui.field.ValidatingStringButtonFieldEditor#setDialogToOpen(org.eclipse.ui.dialogs.SelectionDialog)
   */
  @Override
  public void setDialogToOpen(SelectionDialog dialogToOpen_p) {
    super.setDialogToOpen(dialogToOpen_p);
  }

  /**
   * Set the selection handler to handle selected object from the selection dialog.
   * @param handler_p
   */
  public void setSelectionHandler(ISelectionHandler handler_p) {
    _selectionHandler = handler_p;
  }
  
}
