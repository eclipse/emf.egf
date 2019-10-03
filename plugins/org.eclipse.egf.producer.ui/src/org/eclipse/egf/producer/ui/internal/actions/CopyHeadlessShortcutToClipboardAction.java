/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.producer.ui.internal.actions;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class CopyHeadlessShortcutToClipboardAction implements IObjectActionDelegate {

    private Activity _activity;
	private Shell _shell;

    public void run(IAction action) {
        // Nothing to process
        if (_activity == null) {
            return;
        }

        URI uri = EcoreUtil.getURI(_activity);
        
        StringBuilder builder = new StringBuilder();
        builder.append("eclipse"); //$NON-NLS-1$
        builder.append(" "); //$NON-NLS-1$
        builder.append("-consoleLog"); //$NON-NLS-1$
        builder.append(" "); //$NON-NLS-1$
        builder.append("-data"); //$NON-NLS-1$
        builder.append(" "); //$NON-NLS-1$
        builder.append("egf-headless-workspace"); //$NON-NLS-1$
        builder.append(" "); //$NON-NLS-1$
        builder.append("-application"); //$NON-NLS-1$
        builder.append(" "); //$NON-NLS-1$
        builder.append("org.eclipse.egf.application.activity"); //$NON-NLS-1$
        builder.append(" "); //$NON-NLS-1$
        builder.append("-activities"); //$NON-NLS-1$
        builder.append(" "); //$NON-NLS-1$
        builder.append(uri.toString());
        
        Clipboard cb = new Clipboard(_shell.getDisplay());
        TextTransfer textTransfer = TextTransfer.getInstance();
        cb.setContents(new Object[] { builder.toString() }, new Transfer[] { textTransfer });
        
        return;
    }

    protected Activity getActivitySelection(IStructuredSelection selection) {
        Object selectedObject = selection.getFirstElement();
        if (selectedObject == null) {
            return null;
        }
        if (selectedObject instanceof Activity) {
            return (Activity) selectedObject;
        }
        return null;
    }

    public void selectionChanged(IAction action, ISelection selection) {
        _activity = null;
        if (selection instanceof IStructuredSelection) {
            _activity = getActivitySelection((IStructuredSelection) selection);
        }
    }

    public void setActivePart(IAction action, IWorkbenchPart activePart) {
        _shell = activePart.getSite().getShell();
    }

}
