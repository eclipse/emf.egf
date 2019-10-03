/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.model.editor.dialogs.DelegatedWizardDialog;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.editor.wizards.InvokeActivityWizard;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Xavier Maysonnave
 * 
 */
public class InvokeActivityMenuContributor extends EditorMenuContributor {

    public static final String INVOKE_ACTIVITY_ACTION_ID = "invoke-activity"; //$NON-NLS-1$  

    private final InvokeActivityAction _invokeActivityAction = new InvokeActivityAction();

    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        IStructuredSelection selection2 = (IStructuredSelection) _selection;
        if (selection2.size() == 1) {
            if (selection2.getFirstElement() instanceof ProductionPlan) {
                _invokeActivityAction.setEnabled(_invokeActivityAction.isEnabled());
                menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, _invokeActivityAction);
            }
        }
    }

    protected class InvokeActivityAction extends Action {

        public InvokeActivityAction() {
            super(ModelEditorMessages.ActivityMenuContributor_invokeAction_label);
            setId(INVOKE_ACTIVITY_ACTION_ID);
        }

        @Override
        public boolean isEnabled() {
            EObject eObject = getProductionPlan();
            if (eObject == null) {
                return false;
            }
            EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
            if (eObject.eResource() == null || domain == null) {
                return false;
            }
            if (domain.isReadOnly(eObject.eResource())) {
                return false;
            }
            return true;
        }

        protected ProductionPlan getProductionPlan() {
            if (_selection == null) {
                return null;
            }
            IStructuredSelection sselection = (IStructuredSelection) _selection;
            if (sselection.size() != 1) {
                return null;
            }
            Object object = sselection.getFirstElement();
            if (object instanceof ProductionPlan) {
                return (ProductionPlan) object;
            }
            return null;
        }

        @Override
        public void run() {
            ProductionPlan productionPlan = getProductionPlan();
            if (productionPlan == null) {
                return;
            }
            // Instantiates and initializes the wizard
            InvokeActivityWizard wizard = new InvokeActivityWizard();
            wizard.init(_activeEditorPart.getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) _selection);
            // Instantiates the wizard container with the wizard and opens it
            DelegatedWizardDialog dialog = new DelegatedWizardDialog(_activeEditorPart.getSite().getShell(), wizard);
            dialog.create();
            dialog.open();
        }

    }

}
