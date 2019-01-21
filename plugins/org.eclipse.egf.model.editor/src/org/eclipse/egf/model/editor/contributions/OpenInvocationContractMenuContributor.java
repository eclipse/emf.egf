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

import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OpenInvocationContractMenuContributor extends OpenEObjectMenuContributor {

    public static final String OPEN_INVOCATION_CONTRACT_ACTION_ID = "open-invocation-contract"; //$NON-NLS-1$

    private OpenEObjectMenuContributor.OpenAction _openAction;

    protected class InvocationContractOpenAction extends OpenAction {

        public InvocationContractOpenAction() {
            super(OPEN_INVOCATION_CONTRACT_ACTION_ID);
        }

        @Override
        protected EObject getEObject() {
            if (_selection == null || _selection.isEmpty()) {
                return null;
            }
            Object object = ((IStructuredSelection) _selection).getFirstElement();
            if (object instanceof InvocationContract) {
                return ((InvocationContract) object).getInvokedContract();
            }
            return null;
        }

    }

    @Override
    protected String getText() {
        if (getOpenAction().isAlreadyOpenedEditor()) {
            return ModelEditorMessages.ContractMenuContributor_selectAction_label;
        }
        return ModelEditorMessages.ContractMenuContributor_openAction_label;
    }

    @Override
    protected OpenAction getOpenAction() {
        if (_openAction == null) {
            _openAction = new InvocationContractOpenAction();
        }
        return _openAction;
    }

}
