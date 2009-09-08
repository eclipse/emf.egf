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
package org.eclipse.egf.core.ui.wizard.page;

import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.ClassLoadingHelper;
import org.eclipse.egf.common.misc.ISelectionHandler;
import org.eclipse.egf.common.ui.field.ContextElementFieldEditor;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.AbstractValidator;
import org.eclipse.egf.common.ui.toolkit.validators.IValidator;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.core.ui.internal.databinding.JavaTypeHolder;
import org.eclipse.egf.core.ui.internal.databinding.ValueChangeHandler;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.contract.type.ClassTypeHolder;
import org.eclipse.egf.model.contract.type.ITypeHolder;


/**
 * Implements the context element value wizard page.
 * @author fournier
 */
public class ContextElementValueWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(ContextElementValueWizardPage.class.getPackage().getName());
  
  /**
   * ContextElement Type remainder.
   */
  private ValidatingStringFieldEditor _contextElementTypeFieldEditor;
  
  /**
   * ContextValue field editor.
   */
  protected ContextElementFieldEditor _contextElementValueFieldEditor;
  
  /**
   * Reference to the object bound to the context element type.
   */
  protected JavaTypeHolder _contextElementType;
  
  /**
   * Type holder that the context element value must be conformed to.
   */
  protected ITypeHolder _typeHolder;
  private SelectionDialog _providedSelectionDialog;

  /**
   * Constructor.
   * @param pageName_p
   */
  public ContextElementValueWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public ContextElementValueWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create a field editor to display the type (remainder to the end-user).
    String typeHolderClassName = createTypeFieldEditor(parent_p);
    // Create a field editor to enter the context element value.
    createValueTypeFieldEditor(parent_p, typeHolderClassName);
    // Finally, layout the page.
    handlePageLayout(parent_p);
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    // No next page.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#handlePageLayout(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void handlePageLayout(Composite parent_p) {
    FieldEditorHelper.layoutFieldEditor(parent_p, _contextElementTypeFieldEditor, 3);
  }

  /**
   * Create the type field editor.
   * @param parent_p
   * @return fully qualified type class name.
   */
  private String createTypeFieldEditor(Composite parent_p) {
    _contextElementTypeFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.ContextElementValueWizardPage_Type_Title,
      Messages.ContextElementValueWizardPage_Type_Tooltip, 
      null, 
      SWT.DEFAULT,
      new NotEmptyStringValidator(null),
      isReadOnly()
    ); // no message needed, a context has always a type holder.
    // Type text.
    Text type = _contextElementTypeFieldEditor.getTextControl();
    // Set context element type widget as a non editable widget.
    type.setEditable(false);
    // Get handled model element.
    ContextElement contextElement = (ContextElement) getModelElement();
    String typeHolderClassName = DataHelper.getContextType(contextElement);
    Type contextType = contextElement.getContextType();
    if (null == contextType) {
      // Get the type from its contract element reference.
      ContractElement referencedContractElement = contextElement.getContractElementReference().getReferencedContractElement();
      contextType = referencedContractElement.getContractType();
    }
    // Create a an object in order to bind it with the type widget.
    _contextElementType = new JavaTypeHolder(typeHolderClassName);
    bindTextToAttribute(type, JavaTypeHolder.PROPERTY_TYPE, _contextElementType, null);
    return typeHolderClassName;
  }

  /**
   * Create the value field editor.
   * @param parent_p
   * @param typeHolderClassName_p
   */
  private void createValueTypeFieldEditor(Composite parent_p, String typeHolderClassName_p) {
    Class<?> classTypeFilter = _typeHolder != null ? getClassTypeFilter(_typeHolder) : null;
    _contextElementValueFieldEditor = FieldEditorHelper.createContextElementFieldEditor(
      parent_p, 
      this, 
      Messages.ContextElementValueWizardPage_Value_Title,
      Messages.ContextElementValueWizardPage_OpenValueTypeDialog_Title,
      getHostingProjectClassLoader(), 
      getHostingBundle(),
      classTypeFilter,
      isReadOnly()
    );
    // Create a validator based on type holder validation.
    IValidator valueValidator = new AbstractValidator(Messages.ContextElementValueWizardPage_ErrorMessage_NotValidValue) {
      public String isValid(Object value_p) {
        String errorMessage = null;
        // If the type holder is not null, ask it to validate the entered value.
        if (_typeHolder != null) {
          // Set the plug-in to be able to instantiate string representation value.
          if (_typeHolder.isJava()) {
            ((ClassTypeHolder) _typeHolder).setClassLoader(getHostingProjectClassLoader());
            // Set an accurate error message for Java type holder.
            setErrorMessage(Messages.ContextElementValueWizardPage_ErrorMessage_NotValidJavaValue);
          } else {
            // Set an accurate error message for NON Java type holder.
            setErrorMessage(Messages.ContextElementValueWizardPage_ErrorMessage_EmtpyValue);
          }
          boolean result = _typeHolder.isValid(_contextElementValueFieldEditor.getStringValue());
          if (result == false) {
            errorMessage = getErrorMessage();
          }
        } else {
          // Set an accurate error message when type holder is null.
          errorMessage = Messages.ContextElementValueWizardPage_ErrorMessage_EmtpyValue;
        }
        return errorMessage;
      }
    };
    // Override the java class validator.
    _contextElementValueFieldEditor.setValidator(valueValidator);
    // Get the text field to bind it with its data.
    Text contextElementValue = _contextElementValueFieldEditor.getTextControl(parent_p);
    // Create the data binding between the text field and the related model element attribute.
    ValueChangeHandler handler = createValueChangeHandler();
    bindTextToAttribute(contextElementValue, ModelPackage.Literals.CONTEXT_ELEMENT__READABLE_VALUE, getModelElement(), handler);
    // Update context element type.
    updateContextElementType(typeHolderClassName_p);
    // Update valid state.
    _contextElementValueFieldEditor.isValid(true);
  }

  /**
   * Create a value change handler.
   * @return
   */
  private ValueChangeHandler createValueChangeHandler() {
    ValueChangeHandler handler = new ValueChangeHandler(this) {
      /**
       * Use to update the initial selection of provided selection dialog.
       * @see org.eclipse.egf.core.ui.internal.databinding.ValueChangeHandler#doHandleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      protected void doHandleValueChange(ValueChangeEvent event_p) {
        String fullId = (String) event_p.diff.getNewValue();
        setInitialSelectionForProvidedSelectionDialog(fullId);
      }
    };
    return handler;
  }

  /**
   * Get a potential provided selection dialog.
   * @param parentShell_p
   * @return null if not found.
   */
  private SelectionDialog getProvidedSelectionDialog(Shell parentShell_p) {
    SelectionDialog result = null;
    // Precondition.
    if (_typeHolder == null) {
      return result;
    }
    // Get the provided selection dialog class name (if any).
    String selectionDialogClassName = _typeHolder.getSelectionDialog();
    if (selectionDialogClassName != null) {
      // A selection dialog is provided, instantiate it.
      Class<?> selectionDialogClass = ClassLoadingHelper.loadClass(selectionDialogClassName, getHostingProjectClassLoader());
      try {
        // Get the constructor for the provided custom field editor.
        Constructor<?> constructor = selectionDialogClass.getConstructor(Shell.class);
        // Instantiate it.
        result = (SelectionDialog) constructor.newInstance(parentShell_p);
      } catch (Exception exception_p) {
        StringBuilder loggerMessage = new StringBuilder("ContextElementValueWizardPage.getProvidedSelectionDialog(..) _ "); //$NON-NLS-1$
        __logger.error(loggerMessage.toString(), exception_p);

      }
    }
    return result;
  }

  /**
   * Get a potential selection handler.
   * @return null if not found.
   */
  private ISelectionHandler getSelectionHandler() {
    ISelectionHandler result = null;
    // Precondition.
    if (null == _typeHolder) {
      return result;
    }
    result = _typeHolder.getSelectionHandler();
    return result;
  }

  /**
   * Return the handled context element.
   * @return
   */
  protected ContextElement getContextElement() {
    return (ContextElement) getModelElement();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { _contextElementValueFieldEditor };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.ContextElementWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_CONTEXT_ELEMENT_VALUE_WIZARD_PAGE;
  }

  /**
   * Update the type holder class name.
   * @param typeHolderClassName_p
   */
  public void updateContextElementType(String typeHolderClassName_p) {
    if (_contextElementType != null) {
      // Whether or not the type holder has changed between given value and the current one.
      boolean typeHolderHasChanged = false;
      // Force to update through the widget because data binding only works when the modification comes from the widget.
      if ( _contextElementTypeFieldEditor != null) {
        Text textControl = _contextElementTypeFieldEditor.getTextControl();
        String currentValue = textControl.getText();
        // Avoid to set the same value.
        if (currentValue.equals(typeHolderClassName_p) == false) {
          textControl.setText(typeHolderClassName_p);
          typeHolderHasChanged = true;
        }
      } else {
        // Set the new type on bound type to forward modification on related widget.
        _contextElementType.setType(typeHolderClassName_p);
        typeHolderHasChanged = true;
      }
      if (typeHolderHasChanged || _typeHolder == null) {
        // Load the type class.
        Object typeInstance = ClassLoadingHelper.instantiate(typeHolderClassName_p, getHostingProjectClassLoader());
        // If successfully instantiated, update the value field editor.
        if (typeInstance != null) {
          _typeHolder = (ITypeHolder) typeInstance;
          _providedSelectionDialog = getProvidedSelectionDialog(getShell());
          boolean selectionDialogProvided = _providedSelectionDialog != null;
          // If the type holder is not a Java type ie (a StringTypeHolder for instance), disable the button and enable text field.
          boolean textIsEditable = false;
          if (_typeHolder.isJava() == false) {
            // Only primitive type holders without selection dialog are editable.
            textIsEditable = selectionDialogProvided == false;
          } else {
            // If it is a complex type, update the class type filter.
            _contextElementValueFieldEditor.setClassTypeFilter(getClassTypeFilter(_typeHolder));
          }
          // Enable or disable the open type button.
          _contextElementValueFieldEditor.getHelperControl().setEnabled(selectionDialogProvided || _typeHolder.isJava());
          _contextElementValueFieldEditor.setDialogToOpen(_providedSelectionDialog);
          // Set the initial selection for provided selection dialog.
          if (selectionDialogProvided) {
            // Each provided selection dialog has to be able to deal with the a string representation of the initial selected object.
            setInitialSelectionForProvidedSelectionDialog(getContextElement().getReadableValue());
          }
          // Update the selection handler.
          ISelectionHandler selectionHandler = getSelectionHandler();
          _contextElementValueFieldEditor.setSelectionHandler(selectionHandler);
          // Set whether the value text field is editable or not.
          Text textValueWidget = (Text) _contextElementValueFieldEditor.getValueControl();
          textValueWidget.setEditable(textIsEditable);
          // Set focus on the right widget depending on whether or not the text is editable
          if(textIsEditable) {
            textValueWidget.setFocus();
          } else {
            // Set the focus on Browse button.
            _contextElementValueFieldEditor.getHelperControl().forceFocus();
          }
          // Reset the value to empty value only (not at initialization time) when type holder has changed.
          if (typeHolderHasChanged) {
            textValueWidget.setText(ICommonConstants.EMPTY_STRING);
          }
        }
      }
    }
  }

  /**
   * Get the expected type for java type holder.
   * @param typeHolder_p
   * @return
   */
  private Class<?> getClassTypeFilter(ITypeHolder typeHolder_p) {
    Class<?> result = null;
    // Get the expected type for given type holder (only for those that do not host primitive java types).
    if (typeHolder_p.isJava()) {
      ClassTypeHolder classTypeHolder = (ClassTypeHolder) typeHolder_p;
      result = classTypeHolder.getExpectedType();
    }
    return result;
  }

  /**
   * Set the initial selection of the provided selection dialog(if any).
   * @param fullId_p
   */
  private void setInitialSelectionForProvidedSelectionDialog(String fullId_p) {
    // Preconditions.
    if ((null == _providedSelectionDialog) || (null == fullId_p)) {
      return;
    }
    Object[] initialSelection = { fullId_p };
    _providedSelectionDialog.setInitialSelections(initialSelection);
  }
  
}
