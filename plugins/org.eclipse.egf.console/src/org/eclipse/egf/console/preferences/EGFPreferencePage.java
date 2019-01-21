/**
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.console.preferences;

import org.eclipse.egf.common.ui.fields.BooleanFieldEditor2;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.console.internal.IEGFConsoleConstants;
import org.eclipse.egf.console.l10n.ConsoleMessages;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class EGFPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

  private BooleanFieldEditor2 _wrapEditor = null;

  private ConsoleIntegerFieldEditor _widthEditor = null;

  private ColorFieldEditor _errorColorEditor;

  private ColorFieldEditor _infoColorEditor;

  private ColorFieldEditor _warningColorEditor;

  private ColorFieldEditor _backgroundColorEditor;

  private BooleanFieldEditor2 _showOnMessage;

  private BooleanFieldEditor2 _restrictOutput;

  private ConsoleIntegerFieldEditor _highWaterMark;

  /**
   * This class exists to provide visibility to the
   * <code>refreshValidState</code> method and to perform more intelligent
   * clearing of the error message.
   */
  protected class ConsoleIntegerFieldEditor extends IntegerFieldEditor {

    public ConsoleIntegerFieldEditor(String name, String labelText, Composite parent) {
      super(name, labelText, parent);
    }

    /**
     * @see org.eclipse.jface.preference.FieldEditor#refreshValidState()
     */
    @Override
    protected void refreshValidState() {
      super.refreshValidState();
    }

    /**
     * Clears the error message from the message line if the error message is
     * the error message from this field editor.
     */
    @Override
    protected void clearErrorMessage() {
      if (canClearErrorMessage()) {
        super.clearErrorMessage();
      }
    }

  }

  public EGFPreferencePage() {
    super(GRID);
    setDescription(ConsoleMessages.ConsolePreferencePage_General);
    setPreferenceStore(EGFConsolePlugin.getDefault().getPreferenceStore());
  }

  protected boolean canClearErrorMessage() {
    if (_widthEditor.isValid() && _highWaterMark.isValid()) {
      return true;
    }
    return false;
  }

  /**
   * Creates a new color field editor.
   */
  private ColorFieldEditor createColorFieldEditor(String preferenceName, String label, Composite parent) {
    ColorFieldEditor editor = new ColorFieldEditor(preferenceName, label, parent);
    editor.setPage(this);
    editor.setPreferenceStore(getPreferenceStore());
    return editor;
  }

  /**
   * Update enablement of width editor based on enablement of 'fixed width'
   * editor.
   */
  protected void updateWidthEditor() {
    Button b = _wrapEditor.getChangeControl(getFieldEditorParent());
    _widthEditor.getTextControl(getFieldEditorParent()).setEnabled(b.getSelection());
    _widthEditor.getLabelControl(getFieldEditorParent()).setEnabled(b.getSelection());
  }

  /**
   * Update enablement of buffer size editor based on enablement of 'limit
   * console output' editor.
   */
  protected void updateBufferSizeEditor() {
    Button b = _restrictOutput.getChangeControl(getFieldEditorParent());
    _highWaterMark.getTextControl(getFieldEditorParent()).setEnabled(b.getSelection());
    _highWaterMark.getLabelControl(getFieldEditorParent()).setEnabled(b.getSelection());
  }

  @Override
  protected void createFieldEditors() {

    _wrapEditor = new BooleanFieldEditor2(IEGFConsoleConstants.CONSOLE_WRAP, ConsoleMessages.ConsolePreferencePage_Wrap_text, SWT.NONE, getFieldEditorParent());
    addField(_wrapEditor);

    _widthEditor = new ConsoleIntegerFieldEditor(IEGFConsoleConstants.CONSOLE_WIDTH, ConsoleMessages.ConsolePreferencePage_Maximum_Console_width, getFieldEditorParent());
    _widthEditor.setValidRange(80, Integer.MAX_VALUE - 1);
    addField(_widthEditor);
    _widthEditor.setErrorMessage(ConsoleMessages.ConsolePreferencePage_Error_Console_width);

    _wrapEditor.getChangeControl(getFieldEditorParent()).addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        updateWidthEditor();
      }
    });

    _restrictOutput = new BooleanFieldEditor2(IEGFConsoleConstants.CONSOLE_LIMIT_OUTPUT, ConsoleMessages.ConsolePreferencePage_limitOutput, SWT.NONE, getFieldEditorParent());
    addField(_restrictOutput);

    _highWaterMark = new ConsoleIntegerFieldEditor(IEGFConsoleConstants.CONSOLE_HIGH_WATER_MARK, ConsoleMessages.ConsolePreferencePage_highWaterMark, getFieldEditorParent());
    addField(_highWaterMark);
    _highWaterMark.setValidRange(1000, Integer.MAX_VALUE - 1);
    _highWaterMark.setErrorMessage(ConsoleMessages.ConsolePreferencePage_Console_buffer_size);

    _restrictOutput.getChangeControl(getFieldEditorParent()).addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        updateBufferSizeEditor();
      }
    });

    _showOnMessage = new BooleanFieldEditor2(IEGFConsoleConstants.CONSOLE_SHOW_ON_MESSAGE, ConsoleMessages.ConsolePreferencePage_ShowOnMessage, SWT.NONE, getFieldEditorParent());
    addField(_showOnMessage);

    _errorColorEditor = createColorFieldEditor(IEGFConsoleConstants.CONSOLE_ERROR_COLOR, ConsoleMessages.ConsolePreferencePage_Error, getFieldEditorParent());
    addField(_errorColorEditor);

    _infoColorEditor = createColorFieldEditor(IEGFConsoleConstants.CONSOLE_INFO_COLOR, ConsoleMessages.ConsolePreferencePage_Information, getFieldEditorParent());
    addField(_infoColorEditor);

    _warningColorEditor = createColorFieldEditor(IEGFConsoleConstants.CONSOLE_WARNING_COLOR, ConsoleMessages.ConsolePreferencePage_Warning, getFieldEditorParent());
    addField(_warningColorEditor);

    _backgroundColorEditor = createColorFieldEditor(IEGFConsoleConstants.CONSOLE_BACKGROUND_COLOR, ConsoleMessages.ConsolePreferencePage_BackgroundColor, getFieldEditorParent());
    addField(_backgroundColorEditor);

    Dialog.applyDialogFont(getFieldEditorParent());
    getPreferenceStore().addPropertyChangeListener(this);

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
   */
  public void init(IWorkbench workbench) {
    // Nothing to do
  }

  /**
   * @see org.eclipse.jface.preference.FieldEditorPreferencePage#initialize()
   */
  @Override
  protected void initialize() {
    super.initialize();
    updateWidthEditor();
    updateBufferSizeEditor();
  }

  /**
   * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
   */
  @Override
  protected void performDefaults() {
    super.performDefaults();
    updateWidthEditor();
    updateBufferSizeEditor();
  }

  /**
   * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
   */
  @Override
  public void propertyChange(PropertyChangeEvent event) {

    if (event.getProperty().equals(FieldEditor.IS_VALID)) {
      boolean newValue = ((Boolean) event.getNewValue()).booleanValue();
      // If the new value is true then we must check all field editors.
      // If it is false, then the page is invalid in any case.
      if (newValue) {
        if (_widthEditor != null && event.getSource() != _widthEditor) {
          _widthEditor.refreshValidState();
        }
        if (_highWaterMark != null && event.getSource() != _highWaterMark) {
          _highWaterMark.refreshValidState();
        }
        checkState();
      } else {
        super.propertyChange(event);
      }

    } else {
      super.propertyChange(event);
    }
  }

}
