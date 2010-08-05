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

package org.eclipse.egf.task.ui.contributions;

import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class TaskMenuContributor extends EditorMenuContributor {

    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        final IStructuredSelection selection = (IStructuredSelection) _selection;
        if (selection.size() == 1) {
            if (selection.getFirstElement() instanceof Task) {
                Task task = (Task) selection.getFirstElement();
                if (getExpectedKind().equals(task.getKind())) {
                    menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, createAction(task));
                }
            }
        }
    }

    protected abstract TaskImplementationOpenAction createAction(Task task);

    protected abstract String getExpectedKind();

}
