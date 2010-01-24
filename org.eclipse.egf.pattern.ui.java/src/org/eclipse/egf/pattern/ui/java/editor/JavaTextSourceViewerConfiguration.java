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

package org.eclipse.egf.pattern.ui.java.editor;

import org.eclipse.egf.pattern.ui.java.editor.contentassist.JavaTextEditorContentAssistProcessor;
import org.eclipse.jdt.internal.ui.text.JavaReconciler;
import org.eclipse.jdt.ui.text.IColorManager;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JavaTextSourceViewerConfiguration extends JavaSourceViewerConfiguration {

    private JavaTextEditor editor;

    public JavaTextSourceViewerConfiguration(IColorManager colorManager, IPreferenceStore preferenceStore, JavaTextEditor editor, String partitioning) {
        super(colorManager, preferenceStore, editor, partitioning);
        this.editor = editor;
    }

    /** The viewer's content assistant */
    protected ContentAssistant fContentAssistant;

    public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
        /*
         * Note: This method was made final so that StructuredContentAssist is
         * always used and content assist extension point always works.
         */
        ContentAssistant fContentAssistant = new ContentAssistant();

        fContentAssistant.setContentAssistProcessor(new JavaTextEditorContentAssistProcessor(editor), "__dftl_partition_content_type");
        fContentAssistant.enableAutoActivation(true);
        fContentAssistant.setAutoActivationDelay(500);
        fContentAssistant.setProposalPopupOrientation(IContentAssistant.CONTEXT_INFO_BELOW);
        fContentAssistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_BELOW);
        return fContentAssistant;
    }

    /*
     * (non-Javadoc)
     * add by PanPan Liu for error-management
     * 
     * @see
     * org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration#getReconciler(org
     * .eclipse.jface.text.source.ISourceViewer)
     */
    @Override
    public IReconciler getReconciler(ISourceViewer sourceViewer) {
        final ITextEditor editor = getEditor();
        if (editor != null && editor.isEditable()) {
            JavaTextReconcilingStrategy strategy = new JavaTextReconcilingStrategy(sourceViewer, editor, getConfiguredDocumentPartitioning(sourceViewer));
            JavaReconciler reconciler = new JavaReconciler(editor, strategy, false);
            reconciler.setIsAllowedToModifyDocument(false);
            reconciler.setDelay(500);

            return reconciler;
        }
        return null;
    }

}
