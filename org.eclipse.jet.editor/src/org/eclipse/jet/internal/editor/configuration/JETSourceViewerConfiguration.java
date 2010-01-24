/*******************************************************************************
 * Copyright (c) 2005, 2007 ILOG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Joel Cheuoua - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jet.internal.editor.configuration;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.annotations.JETAnnotationHover;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.source.*;

public class JETSourceViewerConfiguration extends SourceViewerConfiguration {

  private DoubleClickStrategy doubleClickStrategy;
  private JETTextEditor editor;

  public JETSourceViewerConfiguration(JETTextEditor editor) {
    this.editor = editor;
  }

  public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
    return editor.getPartitionScanner().getContentTypes();
  }

  public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
    if (doubleClickStrategy == null)
      doubleClickStrategy = new DoubleClickStrategy();
    return doubleClickStrategy;
  }

  public IReconciler getReconciler(ISourceViewer sourceViewer) {
    JETReconcilingStrategy strategy = new JETReconcilingStrategy(sourceViewer, editor);
    MonoReconciler reconciler = new MonoReconciler(strategy, false);
    reconciler.setProgressMonitor(new NullProgressMonitor());
    reconciler.setDelay(500);
    return reconciler;
  }

  public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
    return new JETAnnotationHover();
  }

  public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
    IAutoEditStrategy strategies[] = editor.getPartitionScanner().getAutoEditStrategies(contentType);
    if (strategies == null)
      strategies = super.getAutoEditStrategies(sourceViewer, contentType);
    return strategies;
  }

  public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
    ContentAssistant assistant = new ContentAssistant();
    assistant.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
    String configuredContentTypes[] = getConfiguredContentTypes(sourceViewer);
    for (int i = 0; i < configuredContentTypes.length; i++) {
      String contentType = configuredContentTypes[i];
      org.eclipse.jface.text.contentassist.IContentAssistProcessor processor = editor.getPartitionScanner()
          .getCompletionProcessor(contentType, assistant);
      if (processor != null)
        assistant.setContentAssistProcessor(processor, contentType);
    }

    assistant.setContextInformationPopupOrientation(20);
    assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));
    assistant.enableAutoInsert(false);
    assistant.enableAutoActivation(true);
    return assistant;
  }

  public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
    MultiPassContentFormatter formatter = new MultiPassContentFormatter(
        getConfiguredDocumentPartitioning(sourceViewer), IDocument.DEFAULT_CONTENT_TYPE);
    String configuredContentTypes[] = getConfiguredContentTypes(sourceViewer);
    for (int i = 0; i < configuredContentTypes.length; i++) {
      String contentType = configuredContentTypes[i];
      org.eclipse.jface.text.formatter.IFormattingStrategy strategy = editor.getPartitionScanner()
          .getFormattingStrategy(contentType);
      if (strategy != null)
        if (IDocument.DEFAULT_CONTENT_TYPE.equals(contentType))
          formatter.setMasterStrategy(strategy);
        else
          formatter.setSlaveStrategy(strategy, contentType);
    }

    return formatter;
  }

  public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
    PresentationReconciler reconciler = new PresentationReconciler();
    String configuredContentTypes[] = getConfiguredContentTypes(sourceViewer);
    for (int i = 0; i < configuredContentTypes.length; i++) {
      String contentType = configuredContentTypes[i];
      org.eclipse.jface.text.presentation.IPresentationDamager damager = editor.getPartitionScanner().getDamager(
          contentType);
      org.eclipse.jface.text.presentation.IPresentationRepairer repairer = editor.getPartitionScanner().getRepairer(
          contentType);
      if (damager != null)
        reconciler.setDamager(damager, contentType);
      if (repairer != null)
        reconciler.setRepairer(repairer, contentType);
    }

    return reconciler;
  }

}