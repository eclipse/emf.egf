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

package org.eclipse.pattern.jet.ui.editor;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.configuration.JETReconcilingStrategy;
import org.eclipse.jet.internal.editor.configuration.JETSourceViewerConfiguration;
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

}
