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
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OpenActivityMenuContributor extends OpenEObjectMenuContributor {

    public static final String OPEN_ACTIVITY_ACTION_ID = "open-activity"; //$NON-NLS-1$

    private OpenEObjectMenuContributor.OpenAction _openAction;

    protected class ActivityOpenAction extends OpenAction {

        public ActivityOpenAction() {
            super(OPEN_ACTIVITY_ACTION_ID);
        }

        @Override
        protected EObject getEObject() {
            if (_selection == null || _selection.isEmpty()) {
                return null;
            }
            Object object = ((IStructuredSelection) _selection).getFirstElement();
            if (object instanceof Invocation) {
                return ((Invocation) object).getInvokedActivity();
            }
            return null;
        }

    }

    @Override
    protected String getText() {
        if (getOpenAction().isAlreadyOpenedEditor()) {
            return ModelEditorMessages.ActivityMenuContributor_selectAction_label;
        }
        return ModelEditorMessages.ActivityMenuContributor_openAction_label;
    }

    @Override
    protected OpenAction getOpenAction() {
        if (_openAction == null) {
            _openAction = new ActivityOpenAction();
        }
        return _openAction;
    }

}
