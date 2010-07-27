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

import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.task.ui.l10n.EGFTaskUIMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class TaskImplementationOpenAction extends Action {

    private final Task task;

    public TaskImplementationOpenAction(Task task, String id) {
        this.task = task;
    }

    protected Task getTask() {
        return task;
    }

    protected String getKind() {
        Task task = getTask();
        if (task.getKindValue() != null && task.getKindValue().trim().length() != 0) {
            return task.getKindValue().trim();
        }
        return null;
    }

    protected String getImplementation() {
        Task task = getTask();
        if (task.getImplementationValue() != null && task.getImplementationValue().trim().length() != 0) {
            return task.getImplementationValue().trim();
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        if (getTask().eResource() == null) {
            return false;
        }
        if (getKind() == null) {
            return false;
        }
        if (getImplementation() == null || getImplementation().length() == 0) {
            return false;
        }
        return true;
    }

    protected abstract boolean doRun() throws Exception;

    @Override
    public void run() {
        try {
            if (!doRun()) {
                final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
                MessageDialog.openError(shell, EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_title, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_message, getImplementation()));
            }
        } catch (InterruptedException e) {
            return;
        } catch (Throwable t) {
            ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), t);
            return;
        }
    }

}
