/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.editor.wizards;

import java.util.List;

import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.commands.InvokeActivityCommand;
import org.eclipse.egf.model.editor.dialogs.DelegatedWizardDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.UniqueEList;
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
     * This is the activity selection page.
     */
    protected ActivitySelectionPage _activitySelectionPage;

    /**
     * This is the contract selection page.
     * 
     */
    protected ContractSelectionPage _contractSelectionPage;

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
     * re-implement this method if they need to perform any special cancel
     * processing for their wizard.
     */
    @Override
    public boolean performCancel() {
        _isCanceled = true;
        return true;
    }

    public void finishWizardDialog() {
        if (getContainer() instanceof DelegatedWizardDialog) {
            ((DelegatedWizardDialog) getContainer()).finishDialog();
        }
        // DO nothing
        return;
    }

    /**
     * The framework calls this to create the contents of the wizard.
     */
    @Override
    public void addPages() {
        _activitySelectionPage = new ActivitySelectionPage();
        addPage(_activitySelectionPage);
        _contractSelectionPage = new ContractSelectionPage();
        addPage(_contractSelectionPage);
    }

    /**
     * Do the work after everything is specified.
     */
    @Override
    public boolean performFinish() {
        // Activity to import
        Object result = _activitySelectionPage.getFirstSelection();
        if (result instanceof Activity == false) {
            return true;
        }
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
        // Solve Activity against this domain
        Activity activity = (Activity) domain.getResourceSet().getEObject(EcoreUtil.getURI((Activity) result), true);
        // Solve Contracts against this domain
        List<Contract> contracts = new UniqueEList<Contract>();
        if (_contractSelectionPage.getResult() != null) {
            for (Object object : _contractSelectionPage.getResult()) {
                if (object instanceof Contract) {
                    contracts.add((Contract) domain.getResourceSet().getEObject(EcoreUtil.getURI((Contract) object), true));
                }
            }
        }
        final Command[] command = new Command[] {
            new InvokeActivityCommand(domain, productionPlan, activity, contracts)
        };
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
