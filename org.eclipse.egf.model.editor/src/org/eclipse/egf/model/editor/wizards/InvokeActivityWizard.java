/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.editor.wizards;

import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.commands.InvokeActivityCommand;
import org.eclipse.egf.model.editor.dialogs.EGFWizardDialog;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author Xavier Maysonnave
 * 
 */
public class InvokeActivityWizard extends Wizard implements INewWizard {

  /**
   * Remember the selection during initialization for populating the default
   * container.
   */
  protected IStructuredSelection _selection;

  /**
   * Remember the workbench during initialization.
   */
  protected IWorkbench _workbench;

  /**
   * This is the file creation page.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ActivitySelectionWizardPage _activitySelectionWizardPage;

  public boolean _isCanceled;

  protected ProductionPlan getProductionPlan() {
    if (_selection == null || _selection.size() != 1) {
      return null;
    }
    Object object = _selection.getFirstElement();
    if (object instanceof ProductionPlan) {
      return (ProductionPlan) object;
    }
    return null;
  }

  /**
   * This just records the information.
   */
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    _workbench = workbench;
    _selection = selection;
    setWindowTitle(EGFModelEditorPlugin.INSTANCE.getString("_UI_Wizard_Invoke_Activity_label")); //$NON-NLS-1$
    setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(EGFModelEditorPlugin.INSTANCE.getImage("full/wizban/NewFcore"))); //$NON-NLS-1$
    setNeedsProgressMonitor(true);
  }

  /**
   * The <code>Wizard</code> implementation of this <code>IWizard</code>
   * method does nothing and returns <code>true</code>. Subclasses should
   * reimplement this method if they need to perform any special cancel
   * processing for their wizard.
   */
  @Override
  public boolean performCancel() {
    _isCanceled = true;
    return true;
  }

  public void finishWizardDialog() {
    if (getContainer() instanceof EGFWizardDialog) {
      ((EGFWizardDialog) getContainer()).finishDialog();
    }
    // DO nothing
    return;
  }

  /**
   * The framework calls this to create the contents of the wizard.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void addPages() {
    _activitySelectionWizardPage = new ActivitySelectionWizardPage() {
      @Override
      protected String getHeaderMessage() {
        return ModelEditorMessages.FilteredItemsSelectionDialog_patternLabel;
      }
    };
    _activitySelectionWizardPage.setTitle(ModelEditorMessages.InvokeActivityWizard_Activity_title);
    _activitySelectionWizardPage.setDescription(ModelEditorMessages.InvokeActivityWizard_Activity_description);
    addPage(_activitySelectionWizardPage);
  }

  /**
   * Do the work after everything is specified.
   */
  @Override
  public boolean performFinish() {
    // Activity to import
    Object[] result = _activitySelectionWizardPage.getResult();
    if (result == null || result.length == 0) {
      return true;
    }
    Activity activity = (Activity) result[0];
    // Target
    ProductionPlan productionPlan = getProductionPlan();
    if (productionPlan == null) {
      return true;
    }
    // Current Editing Domain
    EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(productionPlan);
    if (domain == null) {
      return false;
    }
    final Command[] command = new Command[] { new InvokeActivityCommand(domain, productionPlan, (Activity) domain.getResourceSet().getEObject(EcoreUtil.getURI(activity), true)) };
    // Are we facing a TransactionalEditingDomain ?
    if (domain instanceof TransactionalEditingDomain) {
      domain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain) domain) {
        @Override
        protected void doExecute() {
          // Nothing to do
        }
      }.chain(command[0]));
    } else {
      domain.getCommandStack().execute(command[0]);
    }
    return true;
  }
}