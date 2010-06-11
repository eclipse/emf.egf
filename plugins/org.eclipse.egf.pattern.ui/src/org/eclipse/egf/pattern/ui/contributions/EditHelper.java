/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.contributions;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.PatternEditor;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editors.PatternTemplateEditor;
import org.eclipse.egf.pattern.ui.editors.templateEditor.AbstractTemplateEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * @author Thomas Guiu
 * 
 */
public class EditHelper {
    public static final String PATTERN_EDITOR_ID = "PatternEditor";

    public static final String TEMPLATE_EDITOR_ID = "TemplateEditor";
    public static final String TEMPLATE_BASIC_EDITOR_ID = "org.eclipse.egf.pattern.ui.editors.PatternTemplateEditor";

    public static void openPatternEditor(IWorkbenchPage page, String patternId) {
        Pattern pattern = PatternHelper.TRANSACTIONNAL_COLLECTOR.getPattern(patternId);
        if (pattern == null)
            MessageDialog.openInformation(page.getWorkbenchWindow().getShell(), Messages.ViewpointContributor_missingPattern_title, Messages.ViewpointContributor_missingPattern_message);
        else if (getExistingEditor(page, pattern, PATTERN_EDITOR_ID) == null) {
            PatternEditor.openEditor(page, pattern);
        }
    }

    public static PatternTemplateEditor openTemplateBasicEditor(IWorkbenchPage page, Pattern pattern) {
        PatternEditorInput input = new PatternEditorInput(pattern.eResource(), pattern.getID());
        IEditorPart editor = getExistingEditor(page, pattern, TEMPLATE_BASIC_EDITOR_ID);
        if (editor == null) {
            try {
                return (PatternTemplateEditor) IDE.openEditor(page, input, TEMPLATE_BASIC_EDITOR_ID);
            } catch (PartInitException e) {
                Activator.getDefault().logError(e);
                return null;
            }
        }
        return (PatternTemplateEditor) editor;
    }

    public static void openTemplateEditor(IWorkbenchPage page, Pattern pattern, String editor) {
        PatternEditorInput input = new PatternEditorInput(pattern.eResource(), pattern.getID());
        if (getExistingEditor(page, pattern, TEMPLATE_EDITOR_ID) == null) {
            try {
                IDE.openEditor(page, input, editor);
            } catch (PartInitException e) {
                Activator.getDefault().logError(e);
            }
        }
    }

    private static IEditorPart getExistingEditor(IWorkbenchPage page, Pattern pattern, String editorId) {
        IEditorPart[] editors = page.getEditors();
        for (IEditorPart editor : editors) {
            if ((editor instanceof PatternEditor && PATTERN_EDITOR_ID.equals(editorId)) || (editor instanceof AbstractTemplateEditor && TEMPLATE_EDITOR_ID.equals(editorId)) || (editor instanceof PatternTemplateEditor && TEMPLATE_BASIC_EDITOR_ID.equals(editorId))) {
                PatternEditorInput editorInput = (PatternEditorInput) editor.getEditorInput();
                Pattern currentPattern = editorInput.getPattern();
                if (pattern.equals(currentPattern)) {
                    page.activate(editor);
                    return editor;
                }
            }
        }
        return null;
    }
}
