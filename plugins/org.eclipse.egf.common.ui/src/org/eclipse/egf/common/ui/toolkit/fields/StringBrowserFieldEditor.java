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
package org.eclipse.egf.common.ui.toolkit.fields;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.toolkit.adapters.StringButtonFieldEditorAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * The string browser field editor. 
 * The string browser field editor is used to select element(s) which are in relation 
 * with the current edited element.
 * @author D. GATIBELZA
 */
public class StringBrowserFieldEditor extends StringButtonFieldEditorAdapter {
  
  // The selected object.
  private Object _selectedObject = null;
  
  // The browser label provider.
  private ILabelProvider _labelProvider;

  /**
   * Constructs the string browser field editor.
   * @param name_p The field name.
   * @param label_p The field label.
   * @param parent_p The parent composite.
   * @param labelProvider_p The browser and text field label provider cannot be <code>null</code>.
   */
  public StringBrowserFieldEditor(
    String name_p, 
    String label_p, 
    Composite parent_p, 
    ILabelProvider labelProvider_p
  ) {
    this(name_p, label_p, parent_p, labelProvider_p, SWT.LEFT, SWT.NONE);
  }

  /**
   * Constructs the string browser field editor.
   * @param name_p The field name.
   * @param label_p The field label.
   * @param parent_p The parent composite.
   * @param labelProvider_p The browser and text field label provider cannot be <code>null</code>.
   * @param labelStyle_p The label control style.
   * @param valueStyle_p The value control style. 
   */
  public StringBrowserFieldEditor(
    String name_p, 
    String label_p, 
    Composite parent_p, 
    ILabelProvider labelProvider_p, 
    int labelStyle_p, 
    int valueStyle_p
  ) {
    super(name_p, label_p, parent_p, labelStyle_p, valueStyle_p);
    // Register browser label provider.
    _labelProvider = labelProvider_p;
  }

  /**
   * @see org.eclipse.jface.preference.StringButtonFieldEditor#getChangeControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Button getChangeControl(Composite parent_p) {
    // Sets the button.
    setChangeButtonText(Messages.getString("StringBrowserFieldEditor.button.label")); //$NON-NLS-1$
    // Calls super implementation.
    return super.getChangeControl(parent_p);
  }

  /**
   * Gets the current selected object.
   * @return The current selection.
   */
  public Object getCurrentSelection() {
    return _selectedObject;
  }

  /**
   * Sets the current selected object. Updates the text field content and the current selection according to the specified object.
   * @param object_p The selected object.
   */
  public void setCurrentSelection(Object object_p) {
    _selectedObject = object_p;
    String label = null;
    if (null != _labelProvider) {
      label = _labelProvider.getText(_selectedObject);
    }
    if (null != label) {
      setStringValue(label);
    }
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.adapters.StringButtonFieldEditorAdapter#changePressed() Default behavior returns an empty string.
   */
  @Override
  protected String changePressed() {
    return ICommonConstants.EMPTY_STRING;
  }
  
}