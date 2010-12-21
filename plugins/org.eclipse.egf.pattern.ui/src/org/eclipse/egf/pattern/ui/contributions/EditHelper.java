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

package org.eclipse.egf.pattern.ui.contributions;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.editors.PatternEditor;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editors.PatternTemplateEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * @author Thomas Guiu
 * 
 */
public class EditHelper {

    public static IEditorPart openPatternEditor(IWorkbenchPage page, Pattern pattern) {
        return openPatternEditor(page, pattern, IWorkbenchPage.MATCH_NONE);
    }

    public static IEditorPart openPatternEditor(IWorkbenchPage page, Pattern pattern, int matchFlags) {
        if (page == null || pattern == null) {
            throw new IllegalArgumentException();
        }
        IEditorPart part = getExistingEditor(page, pattern, PatternEditor.ID);
        if (part != null) {
            return part;
        }
        try {
            return page.openEditor(new PatternEditorInput(pattern.eResource(), pattern.getID()), PatternEditor.ID, true, matchFlags);
        } catch (PartInitException pie) {
            Activator.getDefault().logError(pie);
        }
        return null;
    }

    public static PatternTemplateEditor openTemplateBasicEditor(IWorkbenchPage page, Pattern pattern) {
        return openTemplateBasicEditor(page, pattern, IWorkbenchPage.MATCH_NONE);
    }

    public static PatternTemplateEditor openTemplateBasicEditor(IWorkbenchPage page, Pattern pattern, int matchFlags) {
        if (page == null || pattern == null) {
            throw new IllegalArgumentException();
        }
        PatternTemplateEditor editor = (PatternTemplateEditor) getExistingEditor(page, pattern, PatternTemplateEditor.ID);
        if (editor != null) {
            return editor;
        }
        try {
            return (PatternTemplateEditor) page.openEditor(new PatternEditorInput(pattern.eResource(), pattern.getID()), PatternTemplateEditor.ID, true, matchFlags);
        } catch (PartInitException pie) {
            Activator.getDefault().logError(pie);
        }
        return null;
    }

    private static IEditorPart getExistingEditor(IWorkbenchPage page, Pattern pattern, String editorId) {
        IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench == null) {
            return null;
        }
        for (IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
            for (IWorkbenchPage innerPage : window.getPages()) {
                for (IEditorReference reference : innerPage.getEditorReferences()) {
                    IEditorPart part = reference.getEditor(false);
                    if ((part instanceof PatternEditor && PatternEditor.ID.equals(editorId)) || (part instanceof PatternTemplateEditor && PatternTemplateEditor.ID.equals(editorId))) {
                        PatternEditorInput editorInput = (PatternEditorInput) part.getEditorInput();
                        Pattern currentPattern = editorInput.getPattern();
                        if (pattern.equals(currentPattern)) {
                            window.setActivePage(innerPage);
                            innerPage.activate(part);
                            part.setFocus();
                            return part;
                        }
                    }
                }
            }
        }
        return null;
    }

}
