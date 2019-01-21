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

package org.eclipse.egf.pattern.ui.editors;

import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.workspace.ui.actions.RedoActionWrapper;
import org.eclipse.emf.workspace.ui.actions.UndoActionWrapper;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

/**
 * Manages the installation/deinstallation of global actions for multi-page
 * editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors
 * in the multi-page editor.
 * 
 * @author Thomas Guiu
 * 
 */
public class PatternEditorContributor extends EditingDomainActionBarContributor {

    public PatternEditorContributor() {
        super(ADDITIONS_LAST_STYLE);
    }

    /**
     * Extends the inherited method to replace the action handlers for undo
     * and redo with our operation-history-aware implementations.
     */
    @Override
    public void init(IActionBars actionBars) {
        super.init(actionBars);

        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();

        undoAction = new UndoActionWrapper();
        undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
        actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);

        redoAction = new RedoActionWrapper();
        redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
        actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);

        actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), null);

        actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), null);

        actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), null);
    }

}
