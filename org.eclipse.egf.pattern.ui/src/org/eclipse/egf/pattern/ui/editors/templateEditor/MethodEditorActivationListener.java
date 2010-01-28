/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.templateEditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.pattern.ui.editors.PatternMethodEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.MultiPageEditorSite;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public abstract class MethodEditorActivationListener implements IPartListener, IWindowListener {

    /**
     * The part service.
     * 
     * @since 3.1
     */
    private IPartService fPartService;

    private TextEditor textEditor;

    /**
     * Creates this activation listener.
     * 
     * @param partService
     *            the part service on which to add the part listener
     * @since 3.1
     */
    public MethodEditorActivationListener(IPartService partService, TextEditor editor) {
        textEditor = editor;
        fPartService = partService;
        fPartService.addPartListener(this);
        PlatformUI.getWorkbench().addWindowListener(this);
    }

    public void partActivated(IWorkbenchPart part) {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
        IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
        IEditorPart activeEditor = activePage.getActiveEditor();
        if (activeEditor == getMultiPageEditor()) {
            gotoCheck();
        }
    }

    public void partBroughtToTop(IWorkbenchPart part) {
    }

    public void partClosed(IWorkbenchPart part) {
    }

    public void partDeactivated(IWorkbenchPart part) {
    }

    public void partOpened(IWorkbenchPart part) {
    }

    public void windowActivated(IWorkbenchWindow window) {
        IEditorSite editorSite = textEditor.getEditorSite();
        // The active eidtor.
        IWorkbenchPage activePage = window.getActivePage();
        IEditorPart activeEditor = activePage.getActiveEditor();

        if (window == editorSite.getWorkbenchWindow() && getMultiPageEditor() == activeEditor) {
            window.getShell().getDisplay().asyncExec(new Runnable() {
                public void run() {
                    gotoCheck();
                }
            });
        }
    }

    public void windowClosed(IWorkbenchWindow window) {
    }

    public void windowDeactivated(IWorkbenchWindow window) {
    }

    public void windowOpened(IWorkbenchWindow window) {
    }

    /**
     * Disposes this activation listener.
     * 
     * @since 3.1
     */
    public void dispose() {
        fPartService.removePartListener(this);
        PlatformUI.getWorkbench().removeWindowListener(this);
        fPartService = null;
    }

    private IEditorPart getMultiPageEditor() {
        IEditorSite editorSite = textEditor.getEditorSite();
        IEditorPart editor = ((MultiPageEditorSite) editorSite).getMultiPageEditor();
        return editor;
    }

    private void gotoCheck() {
        IEditorInput editorInput = textEditor.getEditorInput();
        IFile file = ((PatternMethodEditorInput) editorInput).getFile();
        if (file != null) {
            handleActivation();
        }
    }

    /**
     * Handles the activation triggering a element state check in the
     * editor.
     */
    protected abstract void handleActivation();

}
