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
package org.eclipse.egf.core.ui.workbench.action.fc;

import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.preferences.IPreferenceConstants;
import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction;
import org.eclipse.egf.core.ui.workbench.action.navigator.ValidateElementAction;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Base class to implement an UI action that runs a FC.
 * @author Guillaume Brocard
 */
public abstract class AbstractFactoryExecutionAction extends AbstractModelElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public AbstractFactoryExecutionAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.ExecuteFactoryAction_Title);
    setToolTipText(Messages.ExecuteFactoryAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_EXECUTE));
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
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    // Should I run the FC ?
    boolean readyToExecute = true;
    // Should I validate the FC before run it.
    // Get it from the preference store.
    IPreferenceStore preferenceStore = EgfUiActivator.getDefault().getPreferenceStore();
    boolean validationRequested = preferenceStore.getBoolean(IPreferenceConstants.FC_EXECUTION_MODE);
    if (validationRequested) {
      ValidateElementAction validateAction = new ValidateElementAction(getShell(), getSelectionProvider(), isReadOnly(), false);
      validateAction.setErrorDialogTitle(Messages.ExecuteFactoryAction_ValidationErrorDialog_Title);
      validateAction.setSelectedElement(getModelElement());
      validateAction.run();
      readyToExecute = validateAction.isValid();
    }
    // If ready, run it.
    if (readyToExecute) {
      // Get the id of the factory component that contains this factory.
      String fcId = ModelHelper.getFactoryComponentContainer(getModelElement()).getId();
      // Execute the factory means generate the related factory component.
      CoreActivator.getDefault().generateFactoryComponent(fcId, null, true);
    }
  }
}
