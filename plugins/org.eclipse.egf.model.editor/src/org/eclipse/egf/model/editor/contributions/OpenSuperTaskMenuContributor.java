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
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OpenSuperTaskMenuContributor extends OpenEObjectMenuContributor {

    public static final String OPEN_SUPER_TASK_ACTION_ID = "open-super-task"; //$NON-NLS-1$

    private OpenEObjectMenuContributor.OpenAction _openAction;

    protected class SuperTaskOpenAction extends OpenAction {

        public SuperTaskOpenAction() {
            super(OPEN_SUPER_TASK_ACTION_ID);
        }

        @Override
        protected EObject getEObject() {
            if (_selection == null || _selection.isEmpty()) {
                return null;
            }
            Object object = ((IStructuredSelection) _selection).getFirstElement();
            if (object instanceof Task) {
                return ((Task) object).getSuperTask();
            }
            return null;
        }

    }

    @Override
    protected String getText() {
        if (getOpenAction().isAlreadyOpenedEditor()) {
            return ModelEditorMessages.TaskMenuContributor_selectAction_label;
        }
        return ModelEditorMessages.TaskMenuContributor_openAction_label;
    }

    @Override
    protected OpenAction getOpenAction() {
        if (_openAction == null) {
            _openAction = new SuperTaskOpenAction();
        }
        return _openAction;
    }

}
