/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

    protected final OpenAction _openAction = new OpenAction(OPEN_SUPER_TASK_ACTION_ID) {

        @Override
        protected EObject getEObject() {
            if (_selection == null || _selection.isEmpty()) {
                return null;
            }
            Object object = ((IStructuredSelection) _selection).getFirstElement();
            if (object instanceof Task) {
                Task task = (Task) object;
                return task.getSuperTask();
            }
            return null;
        }

    };

    @Override
    protected String getText() {
        if (getOpenAction().isAlreadyOpenedEditor()) {
            return ModelEditorMessages.TaskMenuContributor_selectAction_label;
        }
        return ModelEditorMessages.TaskMenuContributor_openAction_label;
    }

    @Override
    protected OpenAction getOpenAction() {
        return _openAction;
    }

}
