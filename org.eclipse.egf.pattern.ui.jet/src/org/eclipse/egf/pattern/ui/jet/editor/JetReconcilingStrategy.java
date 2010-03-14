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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.ui.jet.template.JetTemplateEditor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jet.core.parser.ast.JETCompilationUnit;
import org.eclipse.jet.core.parser.ast.Problem;
import org.eclipse.jet.internal.editor.JETEditorHelper;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.annotations.JETProblemAnnotation;
import org.eclipse.jet.internal.editor.configuration.JETReconcilingStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorInput;
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
        JetTextEditor jetTextEditor = null;
        JETCompilationUnit cUnit = jetEditor.requestCompilationUnit();
        List<Problem> cUnitProblems = cUnit.getProblems();
        IEditorInput editorInput = jetEditor.getEditorInput();
        String name = editorInput.getName();
        Map<String, List<Problem>> methodProblems = JetTemplateEditor.getMethodProblems();
        List<Problem> javaContentProblems = new ArrayList<Problem>();
        if (methodProblems != null && !methodProblems.isEmpty()) {
            if (methodProblems.containsKey(name))
                javaContentProblems = methodProblems.get(name);
        }
        List<Problem> evaluateProblems = JETEditorHelper.evaluateProblems(jetEditor, sourceViewer.getDocument());
        Iterator<Problem> iter = evaluateProblems.iterator();
        while (iter.hasNext()) {
            Problem next = iter.next();
            if (!javaContentProblems.contains(next)) {
                javaContentProblems.add(next);
            }
        }

        if (jetEditor instanceof JetTextEditor) {
            jetTextEditor = (JetTextEditor) jetEditor;
        }

        EList<PatternParameter> allParameters = jetTextEditor.getPattern().getAllParameters();
        EList<PatternVariable> allVariables = jetTextEditor.getPattern().getAllVariables();

        javaContentProblems = JetEditorHelper.clearProblemsForParameterAndVariable(allParameters, javaContentProblems);
        javaContentProblems = JetEditorHelper.clearProblemsForParameterAndVariable(allVariables, javaContentProblems);

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
        JetTextEditor jetTextEditor = (JetTextEditor) jetEditor;
        JetEditorHelper.refreshPublicTemplateEditor(jetTextEditor);
        JetEditorHelper.mappingErrorFromTemplateEditor(jetTextEditor);
    }

    public void setProgressMonitor(IProgressMonitor iprogressmonitor) {
    }

}
