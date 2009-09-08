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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Implements a String field editor that delegated its validation to an {@link IValidator} object if provided.
 * @author fournier
 */
public class ValidatingStringFieldEditor extends CStringFieldEditor {

  /**
   * Creates a validating string field editor of unlimited width which supports style. Use the method <code>setTextLimit</code> to limit the text. By default the style
   * is {@value SWT#SINGLE}|{@value SWT#BORDER}.
   * @param name_p The name of field this field editor works on.
   * @param label_p The label text of the field editor.
   * @param parent_p The parent of the field editor's control.
   */
  public ValidatingStringFieldEditor(String name_p, String label_p, Composite parent_p) {
    super(name_p, label_p, parent_p);
  }

  /**
   * Creates a validating string field editor of unlimited width which supports style. Use the method <code>setTextLimit</code> to limit the text.
   * @param name_p The name of field this field editor works on.
   * @param label_p The label text of the field editor
   * @param parent_p The parent of the field editor's control
   * @param style_p The text style.
   * @see Text#Text(Composite, int)
   */
  public ValidatingStringFieldEditor(String name_p, String label_p, Composite parent_p, int style_p) {
    super(name_p, label_p, parent_p, style_p);
  }

  /**
   * Creates a validating string field editor which supports style. Use the method <code>setTextLimit</code> to limit the text.
   * @param name_p The name of field this field editor works on.
   * @param label_p The label text of the field editor
   * @param width_p The width of the text input field in characters, or <code>UNLIMITED</code> for no limit
   * @param parent_p The parent of the field editor's control
   * @param style_p The text style.
   * @see Text#Text(Composite, int)
   */
  public ValidatingStringFieldEditor(String name_p, String label_p, int width_p, Composite parent_p, int style_p) {
    super(name_p, label_p, width_p, parent_p, style_p);
  }

  /**
   * Creates a validating string field editor which supports style. Use the method <code>setTextLimit</code> to limit the text.
   * @param name_p The name of field this field editor works on.
   * @param label_p The label text of the field editor
   * @param width_p The width of the text input field in characters, or <code>UNLIMITED</code> for no limit
   * @param strategy_p either <code>VALIDATE_ON_KEY_STROKE</code> to perform on the fly checking (the default), or <code>VALIDATE_ON_FOCUS_LOST</code> to
   *          perform validation only after the text has been typed in
   * @param parent_p The parent of the field editor's control
   * @param style_p The text style.
   * @see Text#Text(Composite, int)
   */
  public ValidatingStringFieldEditor(String name_p, String label_p, int width_p, int strategy_p, Composite parent_p, int style_p) {
    super(name_p, label_p, width_p, strategy_p, parent_p, style_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.CStringFieldEditor#doCheckState()
   */
  @Override
  protected boolean doCheckState() {
    // Default behavior executes the super method.
    boolean isValid = super.doCheckState();
    if (null != getValidator()) {
      // Validate the field editor with provided validator.
      String errorMessage = getValidator().isValid(getStringValue());
      // If no error message is returned, the field editor is valid.
      isValid = (null == errorMessage);
      // If not valid, set the error message.
      if (!isValid) {
        setErrorMessage(errorMessage);
      }
    }
    return isValid;
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
