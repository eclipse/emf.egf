/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      PanPan Liu, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java.editor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.editors.PatternMethodEditorInput;
import org.eclipse.egf.pattern.ui.java.template.JavaTemplateEditor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.text.JavaCompositeReconcilingStrategy;
import org.eclipse.jdt.internal.ui.text.java.JavaReconcilingStrategy;
import org.eclipse.jdt.internal.ui.text.spelling.JavaSpellingReconcileStrategy;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author panpan.liu@soyatec.com
 */
public class JavaTextReconcilingStrategy extends JavaCompositeReconcilingStrategy {

    private ITextEditor fEditor;
    private JavaReconcilingStrategy fJavaStrategy;
    private RefreshUIJob job;

    /**
     * Creates a new Java reconciling strategy.
     * 
     * @param viewer
     *            the source viewer
     * @param editor
     *            the editor of the strategy's reconciler
     * @param documentPartitioning
     *            the document partitioning this strategy uses for configuration
     */
    public JavaTextReconcilingStrategy(ISourceViewer viewer, ITextEditor editor, String documentPartitioning) {
        super(viewer, editor, documentPartitioning);
        fEditor = editor;
        fJavaStrategy = new JavaReconcilingStrategy(editor);
        setReconcilingStrategies(new IReconcilingStrategy[] { fJavaStrategy, new JavaSpellingReconcileStrategy(viewer, editor) });
    }

    /**
     * This is the single method that performs the annotation model problems
     * evaluations and update
     */
    private void internalReconcile() {
        IDocumentProvider p = fEditor.getDocumentProvider();
        if (p == null) {
            p = JavaPlugin.getDefault().getCompilationUnitDocumentProvider();
        }
        IEditorInput editorInput = fEditor.getEditorInput();
        String name = editorInput.getName();
        IAnnotationModel annotationModel = p.getAnnotationModel(fEditor.getEditorInput());
        Iterator<Annotation> iter = annotationModel.getAnnotationIterator();
        while (iter.hasNext()) {
            Annotation annotation = iter.next();
            // org.eclipse.jdt.ui.error
            annotationModel.removeAnnotation(annotation);
        }
        Map<String, Map<Annotation, Position>> methodJavaAnnotations = JavaTemplateEditor.getMethodJavaAnnotations();
        Map<Annotation, Position> methodAnnotations = new HashMap<Annotation, Position>();
        if (methodJavaAnnotations != null && !methodJavaAnnotations.isEmpty()) {
            methodAnnotations = methodJavaAnnotations.get(name);
        }
        if (annotationModel != null) {
            for (Annotation annotation : methodAnnotations.keySet()) {
                Position position = methodAnnotations.get(annotation);
                annotationModel.addAnnotation(annotation, position);
            }
        }
    }

    /*
     * @see
     * org.eclipse.jface.text.reconciler.CompositeReconcilingStrategy#reconcile
     * (org.eclipse.jface.text.reconciler.DirtyRegion,
     * org.eclipse.jface.text.IRegion)
     */
    public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
        JavaTextEditorHelper.mappingErrorFromTemplateEditor((JavaTextEditor) fEditor);
    }

    /*
     * @see
     * org.eclipse.jface.text.reconciler.CompositeReconcilingStrategy#reconcile
     * (org.eclipse.jface.text.IRegion)
     */
    public void reconcile(IRegion partition) {
        if (JavaTextEditor.refreshJob) {
//            JavaTextEditorHelper.mappingErrorFromTemplateEditor((JavaTextEditor) fEditor);
            if (job == null) {
                job = new RefreshUIJob("RefreshTemplateEditor");
            }
            job.start();
            JavaTextEditor.refreshJob = false;
        }
    }

    /**
     * Tells this strategy whether to inform its listeners.
     * 
     * @param notify
     *            <code>true</code> if listeners should be notified
     */
    public void notifyListeners(boolean notify) {
        fJavaStrategy.notifyListeners(notify);
    }

    /*
     * @seeorg.eclipse.jface.text.reconciler.CompositeReconcilingStrategy#
     * initialReconcile()
     */
    public void initialReconcile() {
        // internalReconcile();
        initialMapping();
    }

    private void initialMapping() {
        JavaTextEditor javaTextEditor = (JavaTextEditor) fEditor;
        EList<PatternMethod> methods = javaTextEditor.getPattern().getMethods();
        int size = methods.size();
        PatternMethod patternMethod = methods.get(size - 1);
        IEditorInput editorInput = javaTextEditor.getEditorInput();
        if (editorInput instanceof PatternMethodEditorInput) {
            PatternMethodEditorInput input = (PatternMethodEditorInput) editorInput;
            PatternMethod inputPatternMethod = input.getPatternMethod();
            if (patternMethod.equals(inputPatternMethod)) {
                JavaTextEditorHelper.mappingErrorFromTemplateEditor((JavaTextEditor) fEditor);
            }
        }
    }

    private void reconciled() {
        fJavaStrategy.reconciled();
    }

    @Override
    public void aboutToBeReconciled() {
        super.aboutToBeReconciled();
    }
    
    class RefreshUIJob extends Job {

        private long timestamp = -1;

        private boolean lazy = false;

        public RefreshUIJob(String name) {
            super(name);
        }

        private void start() {
            if (!lazy) {
                schedule(500);
            } else if (System.currentTimeMillis() - timestamp > 499 && !lazy) {
                lazy = true;
            }
            timestamp = System.currentTimeMillis();
        }

        protected IStatus run(IProgressMonitor monitor) {
            JavaTextEditorHelper.mappingErrorFromTemplateEditor((JavaTextEditor) fEditor);
            if (lazy) {
                schedule();
                lazy = false;
            }
            return Status.OK_STATUS;
        }
    }

}
