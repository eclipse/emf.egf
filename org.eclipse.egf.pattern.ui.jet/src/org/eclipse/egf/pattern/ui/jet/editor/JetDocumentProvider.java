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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.configuration.JETDocumentProvider;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IFileEditorInput;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class JetDocumentProvider extends JETDocumentProvider {

    public JetDocumentProvider(JETTextEditor editor) {
        super(editor);
    }

    protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
        if (element instanceof IFileEditorInput) {
            IFileEditorInput input = (IFileEditorInput) element;
            return new JETAnnotationModel(input.getFile());
        } else {
            return super.createAnnotationModel(element);
        }
    }
}
