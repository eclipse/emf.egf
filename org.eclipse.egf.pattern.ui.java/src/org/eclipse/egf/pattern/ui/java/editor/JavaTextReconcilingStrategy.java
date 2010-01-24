/*******************************************************************************
 * Copyright (c) 2006, 2009 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.ui.java.editor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.egf.pattern.ui.java.template.JavaTemplateEditor;
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
	private boolean reconciled = false;
	
	/**
	 * Creates a new Java reconciling strategy.
	 *
	 * @param viewer the source viewer
	 * @param editor the editor of the strategy's reconciler
	 * @param documentPartitioning the document partitioning this strategy uses for configuration
	 */
	public JavaTextReconcilingStrategy(ISourceViewer viewer, ITextEditor editor,
			String documentPartitioning) {
		super(viewer, editor, documentPartitioning);
		fEditor= editor;
		fJavaStrategy= new JavaReconcilingStrategy(editor);
		setReconcilingStrategies(new IReconcilingStrategy[] {
			fJavaStrategy,
			new JavaSpellingReconcileStrategy(viewer, editor)
		});
	}
	

    /**
     * This is the single method that performs the annotation model problems
     * evaluations and update
     */
    private void internalReconcile() {
		IDocumentProvider p= fEditor.getDocumentProvider();
		if (p == null) {
			p= JavaPlugin.getDefault().getCompilationUnitDocumentProvider();
		}
        IEditorInput editorInput = fEditor.getEditorInput();
		String name = editorInput.getName();
		IAnnotationModel annotationModel= p.getAnnotationModel(fEditor.getEditorInput());
		Iterator iter = annotationModel.getAnnotationIterator();
		while(iter.hasNext()){
			Annotation annotation = (Annotation) iter.next();
			annotationModel.removeAnnotation(annotation);
		}
		Map<String, Map> mETHODJAVAANNOTATIONS = JavaTemplateEditor.getMETHODJAVAANNOTATIONS();
		Map<Annotation,Position> methodAnnotations = new HashMap<Annotation,Position>();
		if(mETHODJAVAANNOTATIONS != null&&!mETHODJAVAANNOTATIONS.isEmpty()){
			methodAnnotations = mETHODJAVAANNOTATIONS.get(name);
		}
        if (annotationModel != null) {
        	for(Annotation annotation:methodAnnotations.keySet()){
        		Position position = methodAnnotations.get(annotation);
        		annotationModel.addAnnotation(annotation, position);
        	}
        }  
    }

	/*
	 * @see org.eclipse.jface.text.reconciler.CompositeReconcilingStrategy#reconcile(org.eclipse.jface.text.reconciler.DirtyRegion, org.eclipse.jface.text.IRegion)
	 */
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		JavaTextEditorHelper.mappingErrorFromTemplateEditor((JavaTextEditor) fEditor);
	}

	/*
	 * @see org.eclipse.jface.text.reconciler.CompositeReconcilingStrategy#reconcile(org.eclipse.jface.text.IRegion)
	 */
	public void reconcile(IRegion partition) {
		JavaTextEditorHelper.mappingErrorFromTemplateEditor((JavaTextEditor) fEditor);
	}

	/**
	 * Tells this strategy whether to inform its listeners.
	 *
	 * @param notify <code>true</code> if listeners should be notified
	 */
	public void notifyListeners(boolean notify) {
		fJavaStrategy.notifyListeners(notify);
	}

	/*
	 * @see org.eclipse.jface.text.reconciler.CompositeReconcilingStrategy#initialReconcile()
	 */
	public void initialReconcile() {
		internalReconcile();
	}

	private void reconciled() {
		fJavaStrategy.reconciled();
	}


	@Override
	public void aboutToBeReconciled() {
		super.aboutToBeReconciled();
	}
	
	

}
