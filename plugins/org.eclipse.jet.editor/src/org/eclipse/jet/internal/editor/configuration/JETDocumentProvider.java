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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.annotations.JETAnnotationModel;
import org.eclipse.jet.internal.editor.partition.JETDocumentPartitionScanner;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class JETDocumentProvider extends FileDocumentProvider {

	private JETTextEditor editor;

	public JETDocumentProvider(JETTextEditor editor) {
		this.editor = editor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.editors.text.StorageDocumentProvider#createDocument(java
	 * .lang.Object)
	 */
	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		JETDocumentPartitionScanner partitionScanner = editor
				.getPartitionScanner();
		if (document != null) {
			IDocumentPartitioner partitioner = new par(partitionScanner,
					partitionScanner.getContentTypes()) {
				public IRegion documentChanged2(DocumentEvent e) {
					editor.handleDocumentChange(e);
					return super.documentChanged2(e);
				}
			};
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}

	protected IAnnotationModel createAnnotationModel(Object element)
			throws CoreException {
		if (element instanceof IFileEditorInput) {
			IFileEditorInput input = (IFileEditorInput) element;
			return new JETAnnotationModel(input.getFile());
		} else {
			return super.createAnnotationModel(element);
		}
	}

}