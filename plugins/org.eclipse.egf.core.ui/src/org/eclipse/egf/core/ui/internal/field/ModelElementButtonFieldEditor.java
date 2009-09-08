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
package org.eclipse.egf.core.ui.internal.field;

import org.eclipse.egf.common.ui.field.ValidatingStringButtonFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.IValidator;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;


/**
 * Implement a string button field editor for {@link NamedModelElementWithId} objects.<br>
 * When the "Browse" button is pressed, the end-user can select a {@link NamedModelElementWithId} in the open dialog.<br>
 * The text field editor is displayed the result of {@link NamedModelElementWithId#getName()} method call.
 * @author Guillaume Brocard
 */
public class ModelElementButtonFieldEditor extends ValidatingStringButtonFieldEditor {

  /**
   * Constructor.
   * @param parent_p
   * @param label_p
   * @param dialogToOpen_p
   */
  public ModelElementButtonFieldEditor(
    Composite parent_p, 
    String label_p, 
    ElementListSelectionDialog dialogToOpen_p
  ) {
    super(parent_p, label_p, dialogToOpen_p);
    // Register additional listeners.
    addListeners();
  }

  /**
   * @see org.eclipse.egf.common.ui.field.ValidatingStringButtonFieldEditor#handleSelection(java.lang.Object)
   */
  @Override
  protected String handleSelection(Object selectedObject_p) {
    NamedModelElementWithId modelElement = (NamedModelElementWithId) selectedObject_p;
    return modelElement.getName();
  }

  /**
   * Create a string button field editor to select a {@link NamedModelElementWithId} object.
   * @param parent_p
   * @param page_p the page where the created field editor is displayed.
   * @param fieldEditorLabel_p
   * @param dialogToOpen_p dialog open when the button is pressed.
   * @param fieldEditorValidator_p
   * @return
   */
  public static ModelElementButtonFieldEditor createModelElementButtonFieldEditor(
    Composite parent_p, 
    DialogPage page_p, 
    String fieldEditorLabel_p,
    String fieldEditorTooltip_p, 
    ElementListSelectionDialog dialogToOpen_p, 
    IValidator fieldEditorValidator_p,
    final boolean readOnly_p
  ) {
    ModelElementButtonFieldEditor fieldEditor = new ModelElementButtonFieldEditor(
      parent_p, 
      fieldEditorLabel_p, 
      dialogToOpen_p
    ) {
      @Override
      protected void doFillIntoGrid(Composite parent__p, int numColumns_p) {
        super.doFillIntoGrid(parent__p, numColumns_p);
        getChangeControl(parent__p).setEnabled(readOnly_p == false);        
      }
    }; 
    // Set the tooltip text.
    fieldEditor.getValueControl().setToolTipText(fieldEditorTooltip_p);
    // Set the owner page.
    fieldEditor.setPage(page_p);
    // Set the validator.
    fieldEditor.setValidator(fieldEditorValidator_p);
    // Set the text field as a non editable one.
    fieldEditor.getTextControl().setEditable(false);
    return fieldEditor;
  }

  /**
   * Add listeners on widgets contained by this field editor.
   */
  protected void addListeners() {
    // Add a listener to be notified as soon as possible the text field (before the data bind is notified) value is modified.
    getTextControl().addModifyListener(new ModifyListener() {
      /**
       * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
       */
      @SuppressWarnings("synthetic-access")
      public void modifyText(ModifyEvent e_p) {
        refreshValidState();
      }
    });
  }
}
