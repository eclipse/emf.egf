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
package org.eclipse.egf.common.ui.toolkit.adapters;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.IValidator;


/**
 * The boolean field editor adapter. Adapts the existing JFace boolean field editor to reuse it in the UI Toolkit. Using this adapter allows the developper to
 * have access to the hided features of the field editors.
 * @author D. GATIBELZA
 */
public class BooleanFieldEditorAdapter extends BooleanFieldEditor implements IFieldEditor {
  
  // The parent composite.
  private Composite _parent = null;
  
  // The validator.
  private IValidator _validator = null;
  
  // The error message.
  private String _errorMessage = null;
  
  /**
   * @see BooleanFieldEditor#BooleanFieldEditor(String, String, Composite)
   */
  public BooleanFieldEditorAdapter(String name_p, String label_p, Composite parent_p) {
    super(name_p, label_p, parent_p);
    _parent = parent_p;
  }

  /**
   * @see BooleanFieldEditor#BooleanFieldEditor(String, String, int, Composite)
   */
  public BooleanFieldEditorAdapter(String name_p, String labelText_p, int style_p, Composite parent_p) {
    super(name_p, labelText_p, style_p, parent_p);
    _parent = parent_p;
  }  
  
  /**
   * @see IFieldEditor#getLabel()
   */
  public Label getLabel() {
    return getLabelControl();
  }

  /**
   * @see IFieldEditor#getValueControl()
   */
  public Control getValueControl() {
    return getChangeControl(_parent);
  }

  /**
   * Does nothing for this component type.
   * @return <code>null</code> value.
   * @see IFieldEditor#getHelperControl()
   */
  public Control getHelperControl() {
    return null;
  }

  /**
   * @see IFieldEditor#getErrorMessage()
   */
  public String getErrorMessage() {
    return _errorMessage;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#getFieldName()
   */
  public String getFieldName() {
    return getPreferenceName();
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#getFieldPage()
   */
  public DialogPage getFieldPage() {
    return getPage();
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#getValidator()
   */
  public IValidator getValidator() {
    return _validator;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#isFocused()
   */
  public boolean isFocused() {
    Control valueControl = getValueControl();
    Control helperControl = getHelperControl();
    boolean focused = false;
    if (null != valueControl) {
      focused = valueControl.isFocusControl();
    }
    if (null != helperControl) {
      focused |= helperControl.isFocusControl();
    }
    return focused;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#isHelperEnabled()
   */
  public boolean isHelperEnabled() {
    boolean enabled = false;
    Control helperControl = getHelperControl();
    if (null != helperControl) {
      enabled = helperControl.isEnabled();
    }
    return enabled;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#defaultLayout()
   */
  public void defaultLayout() {
    Composite parent = getLabelControl().getParent();
    GridLayout layout = (GridLayout) parent.getLayout();
    fillIntoGrid(parent, layout.numColumns);
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#layout(int)
   */
  public void layout(int numColumns_p) {
    adjustForNumColumns(numColumns_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#setFieldPage(org.eclipse.jface.dialogs.DialogPage)
   */
  public void setFieldPage(DialogPage page_p) {
    setPage(page_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#setValidator(org.eclipse.egf.common.ui.toolkit.validators.IValidator)
   */
  public void setValidator(IValidator validator_p) {
    _validator = validator_p;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#setHelperEnabled(boolean)
   */
  public void setHelperEnabled(boolean enabled_p) {
    Control helperControl = getHelperControl();
    if (null != helperControl) {
      helperControl.setEnabled(enabled_p);
    }
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#isValueEnabled()
   */
  public boolean isValueEnabled() {
    boolean enabled = false;
    Control valueControl = getValueControl();
    if (null != valueControl) {
      enabled = valueControl.isEnabled();
    }
    return enabled;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#setValueEnabled(boolean)
   */
  public void setValueEnabled(boolean enabled_p) {
    Control valueControl = getValueControl();
    if (null != valueControl) {
      valueControl.setEnabled(enabled_p);
    }
  }
  
}