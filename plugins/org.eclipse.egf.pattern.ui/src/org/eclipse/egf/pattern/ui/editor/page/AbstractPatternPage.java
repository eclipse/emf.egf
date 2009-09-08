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
package org.eclipse.egf.pattern.ui.editor.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.editor.PatternEditor;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * Abstract pattern page.<br>
 * Handles access to pattern data.
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternPage extends FormPage implements IExternalSelectionHandler {
  
  /**
   * Is page dirty ?
   */
  private boolean _isDirty;
  
  /**
   * Message manager.
   */
  private IMessageManager _messageManager;
  
  /**
   * Errors count for current page.
   */
  private Map<Control, Integer> _errorsCount;

  /**
   * Constructor.
   * @param editor_p
   * @param id_p
   * @param title_p
   */
  public AbstractPatternPage(FormEditor editor_p, String id_p, String title_p) {
    super(editor_p, id_p, title_p);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.IExternalSelectionHandler#handleSelection(java.lang.Object, org.eclipse.jface.viewers.IStructuredSelection)
   */
  public void handleSelection(Object firstSelectedObject_p, IStructuredSelection selection_p) {
    // Default implementation does nothing.
    // This is up to a specific implementation to deal with the selection.
  }

  /**
   * Get help context id for current page.<br>
   * Must be prefixed by the page plug-in id.
   * @return
   */
  public abstract String getHelpContextId();

  /**
   * Editor is about to be saved.<br>
   * Data are still valid.<br>
   * The page is giving an opportunity to save its state, or its data.
   */
  public void editorAboutToBeSaved() {
    // Nothing to do here.
  }

  /**
   * Editor saved notification.
   */
  public final void editorSaved() {
    setDirty(false);
    dataSaved();
  }

  /**
   * Set page dirty state.
   */
  public void setDirty(boolean isDirty_p) {
    _isDirty = isDirty_p;
    getEditor().editorDirtyStateChanged();
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormPage#isDirty()
   */
  @Override
  public boolean isDirty() {
    return _isDirty;
  }

  /**
   * Is page editable ?
   * @return
   */
  public boolean isEditable() {
    return getPatternHandler().isEditable();
  }

  /**
   * Data have been saved.<br>
   * Change page internal state accordingly.
   */
  protected void dataSaved() {
    // Default implementation does nothing.
  }

  /**
   * Get available pattern data.<br>
   * Null if it could not be found for containing editor.
   * @return
   */
  public PatternData getPatternData() {
    return getEditor().getPatternData(null);
  }

  /**
   * Get pattern handler.
   * @return
   */
  protected PatternHandler getPatternHandler() {
    return getEditor().getPatternHandler();
  }

  /**
   * Get external selection manager.
   * @return
   */
  protected ExternalSelectionManager getExternalSelectionManager() {
    return (ExternalSelectionManager) getEditor().getAdapter(ExternalSelectionManager.class);
  }

  /**
   * Has current page some errors ?
   * @return
   */
  public boolean hasErrors() {
    return (null != _errorsCount) && (_errorsCount.size() > 0);
  }

  /**
   * Increment error count for given control.
   * @param control_p
   */
  @SuppressWarnings("boxing")
  private void incrementErrorCount(Control control_p) {
    if (_errorsCount == null) {
      _errorsCount = new HashMap<Control, Integer>(0);
    }
    Integer count = _errorsCount.get(control_p);
    if (count == null) {
      count = new Integer(1);
    } else {
      count = count++;
    }
    _errorsCount.put(control_p, count);
  }

  /**
   * Remove error count for given control.
   * @param control_p
   */
  private void removeErrorCount(Control control_p) {
    if (_errorsCount != null) {
      _errorsCount.remove(control_p);
    }
  }

  /**
   * Report an error for given control.
   * @param control_p
   * @param errorText_p
   */
  protected void reportError(Control control_p, String errorText_p, String errorKey_p) {
    if (errorText_p != null && control_p != null && errorKey_p != null) {
      _messageManager.addMessage(errorKey_p, errorText_p, null, IMessageProvider.ERROR, control_p);
      incrementErrorCount(control_p);
    }
  }

  /**
   * Clear all errors for given control.
   * @param control_p
   */
  protected void clearErrors(Control control_p) {
    if (control_p != null) {
      _messageManager.removeMessages(control_p);
      removeErrorCount(control_p);
    }
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormPage#getEditor()
   */
  @Override
  public PatternEditor getEditor() {
    return (PatternEditor) super.getEditor();
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormPage#createFormContent(org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void createFormContent(IManagedForm managedForm_p) {
    // Get toolkit.
    FormToolkit toolkit = managedForm_p.getToolkit();
    // Set managed form layout.
    Composite body = managedForm_p.getForm().getBody();
    // Get message manager.
    _messageManager = managedForm_p.getMessageManager();
    // Get pattern data.
    PatternData patternData = getPatternData();
    // Pattern data is available, go for it !
    if (patternData != null) {
      doCreateFormContent(toolkit, body, patternData, managedForm_p);
    } else { // This page is likely to be useless.
      toolkit.createLabel(body, Messages.AbstractPatternPage_NoPatternDataLabel);
    }
  }

  /**
   * Get a new pattern block implementation, if this page has to use the master/details approach.<br>
   * Returning null here implies overriding the {@link #doCreateFormContent(FormToolkit, Composite, PatternData, IManagedForm)} method entirely.
   * @return
   */
  protected abstract AbstractPatternBlock createPatternBlock();

  /**
   * Do create form content.<br>
   * Should be overridden by page that were not created using a pattern block.
   * @param toolkit_p Managed form toolkit.
   * @param parent_p Managed form composite.
   * @param patternData_p Pattern data for current pattern edition.
   * @param managedForm_p
   */
  protected void doCreateFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p, IManagedForm managedForm_p) {
    // Is there a provided block ?
    AbstractPatternBlock block = createPatternBlock();
    if (block != null) {
      block.setPatternData(patternData_p);
      block.createContent(managedForm_p);
    }
    // Else do nothing.
    // Overriding implementation should implement this method.
  }

  /**
   * Textual control validation class.
   */
  protected abstract class TextValidator implements IValueChangeListener {
    
    /**
     * ERROR KEY : text does not match given regular expression.
     */
    protected static final String ERROR_KEY_REG_EXP = "RegExp"; //$NON-NLS-1$
    
    /**
     * Checked control.
     */
    private Control _control;
    
    /**
     * Expected name pattern.
     */
    private String _regularExpression;
    
    /**
     * List of error keys for current validation.
     */
    private List<String> _errorKeys;

    /**
     * Constructor.
     * @param textControl_p
     */
    protected TextValidator(Control textControl_p) {
      _control = textControl_p;
    }

    /**
     * Get control.
     * @return
     */
    protected Control getControl() {
      return _control;
    }

    /**
     * @see org.eclipse.core.databinding.observable.value.IValueChangeListener#handleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
     */
    public void handleValueChange(ValueChangeEvent event_p) {
      // Empty error keys.
      if (_errorKeys == null) {
        _errorKeys = new ArrayList<String>(0);
      } else {
        _errorKeys.clear();
      }
      // Get new textual value.
      String newValue = (String) event_p.getObservableValue().getValue();
      // Is new value on error ?
      if (onError(newValue)) {
        // If so, report errors for this control.
        for (String errorKey : _errorKeys) {
          reportError(_control, getErrorMessageFor(errorKey, newValue), errorKey);
        }
      } else {
        // Clear all errors for this control.
        clearErrors(_control);
      }
    }

    /**
     * Set regular expression.
     * @param regularExpression_p
     */
    protected void setRegularExpression(String regularExpression_p) {
      _regularExpression = regularExpression_p;
    }

    /**
     * Add new error key.
     * @param errorKey_p
     */
    protected void addErrorKey(String errorKey_p) {
      if (_errorKeys != null) {
        _errorKeys.add(errorKey_p);
      }
    }

    /**
     * On error condition for current textual value.<br>
     * Default implementation is testing the new value against set regular expression.<br>
     * If no regular expression has been set, always returns true.
     * @param text_p the new textual value.
     * @return true if on error, false otherwise.
     */
    protected boolean onError(String text_p) {
      boolean result = _regularExpression != null && text_p.matches(_regularExpression) == false;
      if (result) {
        addErrorKey(ERROR_KEY_REG_EXP);
      }
      return result;
    }

    /**
     * Get error message for given error key and erroneous value.
     * @param errorKey_p
     * @param value_p
     * @return
     */
    protected abstract String getErrorMessageFor(String errorKey_p, String value_p);
    
  }
  
}
