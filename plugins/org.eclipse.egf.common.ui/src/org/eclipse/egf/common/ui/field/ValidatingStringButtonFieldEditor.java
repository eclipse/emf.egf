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

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.SelectionDialog;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.toolkit.fields.StringBrowserFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.IValidator;


/**
 * Implement a string button field editor that delegated its validation to an {@link IValidator} object if provided.
 * @author Guillaume Brocard
 */
public class ValidatingStringButtonFieldEditor extends StringBrowserFieldEditor {
  
  /**
   * Dialog to open when the button is pressed.
   */
  private SelectionDialog _dialogToOpen;
  
  /**
   * Constructor.
   * @param parent_p
   * @param label_p
   * @param dialogToOpen_p
   */
  public ValidatingStringButtonFieldEditor(
    Composite parent_p, 
    String label_p, 
    SelectionDialog dialogToOpen_p
  ) {
    super(ICommonConstants.EMPTY_STRING, label_p, parent_p, null);
    _dialogToOpen = dialogToOpen_p;
  }
      
  /**
   * Checks whether the class text field contains a valid value or not.
   * @param force_p true means force to compute the valid state again.
   * @return <code>true</code> if the field value is valid, and <code>false</code> if invalid.
   */
  public boolean isValid(boolean force_p) {
    // Force to refresh valid state.
    if (force_p) {
      refreshValidState();
    }
    return isValid();
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.CStringButtonFieldEditor#changePressed()
   */
  @Override
  protected String changePressed() {
    String selectedValue = null;
    SelectionDialog dialogToOpen = getDialogToOpen();
    // If the dialog was not set, try to create it.
    if (null == dialogToOpen) {
      dialogToOpen = createDialog();
    }
    if (null != dialogToOpen) {
      if (IDialogConstants.OK_ID == dialogToOpen.open()) {
        // Get returned types.
        Object[] selection = dialogToOpen.getResult();
        if (null != selection && selection.length > 0) {
          // We are not in multi selection context.
          selectedValue = handleSelection(selection[0]);
        }
      }
    }
    return selectedValue;
  }

  /**
   * Create a specific dialog.<br>
   * Default implementation does nothing.
   * @return null if not implemented.
   */
  protected SelectionDialog createDialog() {
    return null;
  }

  /**
   * Offers a way to convert the end-user object selection into a string representation displayed in the text field editor.<br>
   * This method is called when the end-user pressed "ok" to finish its selection.<br>
   * Default behavior is to cast into a String given object selection.
   * @param selectedObject_p
   * @return a not null String.
   */
  protected String handleSelection(Object selectedObject_p) {
    return (String) selectedObject_p;
  }

  /**
   * Set the dialog to open.
   * @param dialogToOpen_p
   */
  protected void setDialogToOpen(SelectionDialog dialogToOpen_p) {
    _dialogToOpen = dialogToOpen_p;
  }

  /**
   * Return the provided dialog to open when 'Browse' button is pressed.
   * @return null if not set.
   */
  protected SelectionDialog getDialogToOpen() {
    return _dialogToOpen;
  }
  
}
