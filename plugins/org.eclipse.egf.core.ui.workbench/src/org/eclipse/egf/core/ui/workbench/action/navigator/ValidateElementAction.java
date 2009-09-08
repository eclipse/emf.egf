/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.action.navigator;

import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Implement an action to validate the {@link NamedModelElementWithId} selected element.
 * @author Guillaume Brocard
 */
public class ValidateElementAction extends AbstractModelElementAction {
  /**
   * Whether or not the validation is on error.
   */
  private boolean _isValidationOnError;
  /**
   * Should I report to the end-user when validation is successful.
   */
  private boolean _reportSuccessfulValidation;
  /**
   * Error dialog title used when reporting validation errors.
   */
  private String _errorDialogTitle;

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public ValidateElementAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setId("org.eclipse.egf.core.ui.workbench.action.navigator.validate"); //$NON-NLS-1$
    setText(Messages.ValidateElementAction_Title);
    setToolTipText(Messages.ValidateElementAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_VALIDATE));
    _reportSuccessfulValidation = true;
  }

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   * @param reportSuccessfulValidation_p
   */
  public ValidateElementAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p, boolean reportSuccessfulValidation_p) {
    this(shell_p, selectionProvider_p, readOnlyMode_p);
    _reportSuccessfulValidation = reportSuccessfulValidation_p;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId selectedModelElement_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return NamedModelElementWithId.class;
  }

  /**
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    NamedModelElementWithId modelElement = getModelElement();
    Object[] data = new Object[] { modelElement };
    // Format the message according to selected element.
    String elementName = modelElement.getName();
    // If element name is null, use the eClass name instead.
    elementName = (null != elementName) ? elementName : modelElement.eClass().getName();
    String formattedMessage = StringHelper.formatMessage(Messages.ValidateElementAction_Error_Detailed_Message, new String[] { elementName });
    DiagnosticChain diagnosticChain = new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0, formattedMessage, data);
    // Validate the selected model element.
    Diagnostician diagnostician = new Diagnostician();
    // Invoke validation.
    Diagnostic diagnostic = diagnostician.validate(modelElement);
    // If on error, display message.
    _isValidationOnError = (Diagnostic.ERROR == diagnostic.getSeverity());
    if (_isValidationOnError) {
      diagnosticChain.addAll(diagnostic);
      // Format the title according to report errors.
      String formattedTitle = getErrorDialogTitle();
      DiagnosticDialog.open(getShell(), formattedTitle, Messages.ValidateElementAction_Error_Overall_Message, (Diagnostic) diagnosticChain);
    } else {
      if (_reportSuccessfulValidation) {
        // Format the title according to report a successful validation.
        String formattedTitle =
                                StringHelper.formatMessage(Messages.ValidateElementAction_ValidationReportDialog_Title,
                                                           new String[] { Messages.ValidateElementAction_ValidationReportDialog_Title_Info });
        MessageDialog.openInformation(getShell(), formattedTitle, Messages.ValidateElementAction_NoError_Message);
      }
    }
  }

  /**
   * Return the error title to use when reporting validation errors.
   * @return a not null string.
   */
  protected String getErrorDialogTitle() {
    return (null == _errorDialogTitle) ? getDefaultErrorDialogTitle() : _errorDialogTitle;
  }

  /**
   * Return the default error dialog title.<br> {@link #getErrorDialogTitle()}
   * @return
   */
  protected String getDefaultErrorDialogTitle() {
    String formattedTitle =
                            StringHelper.formatMessage(Messages.ValidateElementAction_ValidationReportDialog_Title,
                                                       new String[] { Messages.ValidateElementAction_ValidationReportDialog_Title_Problem });
    return formattedTitle;
  }

  /**
   * Return whether or not the validation is successful.<br>
   * Must be called after {@link #run()} method.
   * @return the isValid
   */
  public boolean isValid() {
    return !_isValidationOnError;
  }

  /**
   * @see org.eclipse.jface.action.Action#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    boolean result = super.isEnabled();
    NamedModelElementWithId modelElement = getModelElement();
    // Pattern models are validated at design time in the Pattern editor.
    if (modelElement instanceof PatternModel) {
      result = false;
    }
    return result;
  }

  /**
   * Set the error dialog title with the specified value.
   * @param errorDialogTitle_p the errorDialogTitle to set
   */
  public void setErrorDialogTitle(String errorDialogTitle_p) {
    _errorDialogTitle = errorDialogTitle_p;
  }
}
