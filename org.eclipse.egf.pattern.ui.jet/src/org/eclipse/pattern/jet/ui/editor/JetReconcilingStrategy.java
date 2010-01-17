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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jet.core.parser.ast.JETCompilationUnit;
import org.eclipse.jet.core.parser.ast.Problem;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.configuration.JETReconcilingStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.MarkerAnnotation;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class JetReconcilingStrategy extends JETReconcilingStrategy {
    private JETTextEditor jetEditor;

    private ISourceViewer sourceViewer;

    /**
     * Main constructor
     * 
     * @param sourceViewer
     * @param jetEditor
     */
    public JetReconcilingStrategy(ISourceViewer sourceViewer, JETTextEditor jetEditor) {
        super(sourceViewer, jetEditor);
        this.jetEditor = jetEditor;
        this.sourceViewer = sourceViewer;
    }

    /**
     * This is the single method that performs the annotation model problems
     * evaluations and update
     */
    private void internalReconcile() {
        JETCompilationUnit cUnit = jetEditor.requestCompilationUnit();
        List cUnitProblems = cUnit.getProblems();
        List javaContentProblems = JetEditorHelper.evaluateProblems(jetEditor, sourceViewer.getDocument());
        IAnnotationModel annotationModelq = sourceViewer.getAnnotationModel();
        JETAnnotationModel annotationModel = (JETAnnotationModel) annotationModelq;
        if (annotationModel != null) {
            // avoid changes to the annotation model to be notified to the
            // viewers until the job is done
            annotationModel.setFireChanges(false);

            // Remove all the previous annotations related to JET problems
            // and related to resource markers
            for (Iterator it = annotationModel.getAnnotationIterator(); it.hasNext();) {
                Annotation annotation = (Annotation) it.next();
                if ((annotation instanceof JETProblemAnnotation) || (annotation instanceof MarkerAnnotation))
                    annotationModel.removeAnnotation(annotation);
            }

            // Problems for JET document structure
            for (Iterator iterator = cUnitProblems.iterator(); iterator.hasNext();) {
                Problem problem = (Problem) iterator.next();
                JETProblemAnnotation annotation = new JETProblemAnnotation(problem);
                Position position = new Position(problem.getStart(), problem.getEnd() - problem.getStart());
                annotationModel.addAnnotation(annotation, position);
            }

            // Problems in java contents of the JET document
            for (Iterator iterator = javaContentProblems.iterator(); iterator.hasNext();) {
                Problem problem = (Problem) iterator.next();
                JETProblemAnnotation annotation = new JETProblemAnnotation(problem);
                Position position = new Position(problem.getStart(), problem.getEnd() - problem.getStart());
                annotationModel.addAnnotation(annotation, position);
            }

            annotationModel.setFireChanges(true);
            annotationModel.fireAnnotationModelChanged();
        }
    }

    public void setDocument(IDocument idocument) {
    }

    public void initialReconcile() {
        internalReconcile();
    }

    public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
        internalReconcile();
    }

    public void reconcile(IRegion partition) {
        internalReconcile();
    }

    public void setProgressMonitor(IProgressMonitor iprogressmonitor) {
    }

}
