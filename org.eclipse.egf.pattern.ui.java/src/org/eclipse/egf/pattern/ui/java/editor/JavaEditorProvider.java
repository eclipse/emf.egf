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
 *      panpan.liu, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitDocumentProvider;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IFileEditorInput;

/**
 * @author PanPan Liu
 * 
 */
public class JavaEditorProvider extends CompilationUnitDocumentProvider {

    public JavaEditorProvider() {
        super();
    }

    @Override
    public IAnnotationModel getAnnotationModel(Object element) {
        IFileEditorInput input = (IFileEditorInput) element;
        IFile file = input.getFile();
        return new JavaAnnotationModel(file);
    }

    /*
     * @see
     * org.eclipse.ui.texteditor.IDocumentProvider#connect(java.lang.Object)
     * 
     * public void connect(Object element) throws CoreException {
     * super.connect(element);
     * FileInfo info= getFileInfo(element);
     * if (info == null) {
     * info= createFileInfo(element);
     * }
     * }
     */

    @Override
    protected IAnnotationModel createAnnotationModel(IFile file) {
        return new JavaAnnotationModel(file);
    }

    /*
     * @Override
     * protected FileInfo createFileInfo(Object element) throws CoreException {
     * if (!(element instanceof IAdaptable))
     * return null;
     * IAdaptable adaptable= (IAdaptable) element;
     * IFile file = (IFile)adaptable.getAdapter(IFile.class);
     * 
     * FileInfo info = super.createFileInfo(element);
     * if(file!=null){
     * info.fModel= createAnnotationModel(file);
     * }
     * return info;
     * }
     */

}
