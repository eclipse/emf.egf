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

import org.eclipse.egf.common.ui.toolkit.validators.IValidator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;


/**
 * The field editor. 
 * This implementation of field editor respect the IFieldEditor interface 
 * which opens the old FieldEditor API. 
 * It supports error message management, validator, input behavior and the databinding 
 * (based on the already in place binding system : IPreferenceStore).
 * @author D. GATIBELZA
 */
public abstract class AbstractFieldEditor extends FieldEditor implements IFieldEditor {
  
  // The label control style.
  protected int _labelStyle = SWT.LEFT;
  
  // The value control style.
  protected int _valueStyle = SWT.NONE;
  
  // The validator.
  private IValidator _validator = null;

  // The current error message.
  private String _errorMessage = null;

  /**
   * Constructs the MDE field editor.
   */
  protected AbstractFieldEditor() {
    // Do nothing.
  }

  /**
   * Constructs the MDE field editor with the specified field name and specified label text. Sets the default label control style to {@link SWT#LEFT} and the
   * default value control to {@link SWT#NONE}.
   * @param name_p The field name.
   * @param labelText_p The label text.
   * @param parent_p The parent control.
   */
  protected AbstractFieldEditor(String name_p, String labelText_p, Composite parent_p) {
    this(name_p, labelText_p, parent_p, SWT.LEFT, SWT.NONE);
  }

  /**
   * Constructs the MDE field editor with the specified name, specified text label and applies the specified styles respectively to the label control and the
   * value control. For the label control style unsupported values are filtered : {@link SWT#SEPARATOR}, {@link SWT#WRAP}.
   * @param name_p The field name.
   * @param labelText_p The label text.
   * @param parent_p The parent control.
   * @param labelStyle_p The label control style {@link Label}.
   * @param valueStyle_p The value control style according to the value control type.
   */
  protected AbstractFieldEditor(String name_p, String labelText_p, Composite parent_p, int labelStyle_p, int valueStyle_p) {
    init(name_p, labelText_p, labelStyle_p, valueStyle_p);
    createControl(parent_p);
  }

  /**
   * Initializes the field with the given property name and label.
   * @param name_p The field name.
   * @param text_p The label text of the field.
   * @param labelStyle_p The label style.
   * @param valueStyle_p The value control style.
   */
  protected void init(String name_p, String text_p, int labelStyle_p, int valueStyle_p) {
    Assert.isNotNull(name_p);
    Assert.isNotNull(text_p);    
    // Checks styles.
    _labelStyle = checkLabelStyle(labelStyle_p);
    _valueStyle = checkValueStyle(valueStyle_p);
    // Sets the label text and field name.
    setPreferenceName(name_p);
    setLabelText(text_p);
  }

  // Checks the label style. Does not allow the SEPARATOR style and the WRAP style.
  // In case of SWT.NONE style value, it applies a correction and return the default label style value SWT.LEFT.
  private int checkLabelStyle(int labelStyle_p) {
    int newStyle = labelStyle_p;
    if (0 != (SWT.SEPARATOR & newStyle)) {
      newStyle = newStyle - SWT.SEPARATOR;
    }
    if (0 != (SWT.WRAP & newStyle)) {
      newStyle = newStyle - SWT.WRAP;
    }
    if (SWT.NONE == newStyle) {
      newStyle = SWT.LEFT;
    }
    return newStyle;
  }

  /**
   * Checks the style of the value control and updates it. <br/>
   * <b>WARNING : This default implementation returns the specified style.</b>
   * @param valueStyle_p The value control style.
   * @return The updated value control style.
   */
  protected int checkValueStyle(int valueStyle_p) {
    return valueStyle_p;
  }

  /**
   * <b>Does not remove the horizontal and the vertical margins.</b>
   * @see org.eclipse.jface.preference.FieldEditor#createControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createControl(Composite parent_p) {
    GridLayout layout = new GridLayout();
    layout.numColumns = getNumberOfControls();
    layout.horizontalSpacing = HORIZONTAL_GAP;
    parent_p.setLayout(layout);
    doFillIntoGrid(parent_p, layout.numColumns);
  }

  /**
   * @see org.eclipse.jface.preference.FieldEditor#getLabelControl(org.eclipse.swt.widgets.Composite) TODO DGA : propager dans les constructeurs le style du
   *      label.
   */
  @Override
  public Label getLabelControl(Composite parent_p) {
    Label label = super.getLabelControl(parent_p);
    GridData gd = new GridData();
    gd.horizontalAlignment = SWT.FILL;
    label.setLayoutData(gd);
    int alignement = SWT.RIGHT & _labelStyle;
    if (0 == alignement) {
      alignement = SWT.CENTER & _labelStyle;
    }
    if (0 == alignement) {
      alignement = SWT.LEFT;
    }
    label.setAlignment(alignement);
    return label;
  }

  /**
   * Sets the error message that will be displayed when and if an error occurs.
   * @param message_p The error message.
   */
  public void setErrorMessage(String message_p) {
    _errorMessage = message_p;
  }

  /**
   * @see org.eclipse.jface.preference.FieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite, int)
   */
  @Override
  protected abstract void doFillIntoGrid(Composite parent_p, int numColumns_p);

  /**
   * Gets the value from the specified control.
   * @param control_p The value control.
   * @return The value.
   */
  protected abstract Object getValue(Control control_p);

  // /////////////////////////////////// PUBLIC API ////////////////////////////////////

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#getLabel()
   */
  public Label getLabel() {
    return getLabelControl();
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#getValueControl()
   */
  public abstract Control getValueControl();

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#getHelperControl()
   */
  public abstract Control getHelperControl();

  /**
   * @see IFieldEditor#getErrorMessage()
   */
  public String getErrorMessage() {
    return _errorMessage;
  }

  /**
   * @see IFieldEditor#getValidator()
   */
  public IValidator getValidator() {
    return _validator;
  }

  /**
   * @see IFieldEditor#setValidator(IValidator)
   */
  public void setValidator(IValidator validator_p) {
    _validator = validator_p;
  }

  /**
   * @see org.eclipse.jface.preference.FieldEditor#isValid()
   */
  @Override
  public boolean isValid() {
    boolean isValid = true;
    if (null != _validator) {
      // Validate the field editor with the provided validator.
      Control control = getValueControl();
      Object value = getValue(control);
      String oldMessage = _errorMessage;
      _errorMessage = _validator.isValid(value);
      // If no error message is returned, the field editor is valid.
      isValid = (null == _errorMessage);
      // If no page available, cannot displays the error message.
      if (null != getPage()) {
        // If not valid, set the error message.
        if (!isValid && (null == getPage().getErrorMessage())) {
          showErrorMessage(_errorMessage);
        } else if (isValid && (getPage().getErrorMessage() == oldMessage)) {
          clearErrorMessage();
        }
      }
    }
    return isValid;
  }

  /**
   * Hook for subclasses to do specific state checks.
   * <p>
   * The default implementation of this framework method uses the validator to validate the field value.<br>
   * If no validator is available, the methods returns <code>true</code>.
   * </p>
   * @return <code>true</code> if the field value is valid, and <code>false</code> if invalid
   */
  protected boolean doCheckState() {
    return isValid();
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
   * @see org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor#setFieldPage(org.eclipse.jface.dialogs.DialogPage)
   */
  public void setFieldPage(DialogPage page_p) {
    setPage(page_p);
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

  /**
   * @see org.eclipse.jface.preference.FieldEditor#setFocus()
   */
  @Override
  public void setFocus() {
    Control valueControl = getValueControl();
    if (null != valueControl) {
      valueControl.setFocus();
    }
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
  
}
