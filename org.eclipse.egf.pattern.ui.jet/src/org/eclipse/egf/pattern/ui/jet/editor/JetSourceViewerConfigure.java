/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui.jet.editor;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.pattern.ui.jet.editor.contentassist.JetJavaExpressionAssistProcessor;
import org.eclipse.egf.pattern.ui.jet.editor.contentassist.JetJavaScriptletAssistProcessor;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.configuration.JETReconcilingStrategy;
import org.eclipse.jet.internal.editor.configuration.JETSourceViewerConfiguration;
import org.eclipse.jet.internal.editor.contentassist.JETJavaExpressionAssistProcessor;
import org.eclipse.jet.internal.editor.contentassist.JETJavaScriptletAssistProcessor;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.source.ISourceViewer;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class JetSourceViewerConfigure extends JETSourceViewerConfiguration {
    private JETTextEditor editor;

    public JetSourceViewerConfigure(JETTextEditor editor) {
        super(editor);
        this.editor = editor;
    }

    public IReconciler getReconciler(ISourceViewer sourceViewer) {
        JETReconcilingStrategy strategy = new JetReconcilingStrategy(sourceViewer, editor);
        MonoReconciler reconciler = new MonoReconciler(strategy, false);
        reconciler.setProgressMonitor(new NullProgressMonitor());
        reconciler.setDelay(500);
        return reconciler;
    }

    public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
        ContentAssistant assistant = new ContentAssistant();
        assistant.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
        String configuredContentTypes[] = getConfiguredContentTypes(sourceViewer);
        for (int i = 0; i < configuredContentTypes.length; i++) {
            String contentType = configuredContentTypes[i];
            org.eclipse.jface.text.contentassist.IContentAssistProcessor processor = editor.getPartitionScanner().getCompletionProcessor(contentType, assistant);
            if (processor != null)
                if (processor instanceof JETJavaScriptletAssistProcessor) {
                    JetJavaScriptletAssistProcessor jetJavaScriptletAssistProcessor = new JetJavaScriptletAssistProcessor((JetTextEditor) editor);
                    assistant.setContentAssistProcessor(jetJavaScriptletAssistProcessor, contentType);
                } else if (processor instanceof JETJavaExpressionAssistProcessor) {
                    JetJavaExpressionAssistProcessor jetJavaExpressionAssistProcessor = new JetJavaExpressionAssistProcessor((JetTextEditor) editor);
                    assistant.setContentAssistProcessor(jetJavaExpressionAssistProcessor, contentType);
                } else {
                    assistant.setContentAssistProcessor(processor, contentType);
                }
        }

        assistant.setContextInformationPopupOrientation(20);
        assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));
        assistant.enableAutoInsert(false);
        assistant.enableAutoActivation(true);
        return assistant;
    }
}
