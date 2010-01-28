/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java.editor;

import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitDocumentProvider;
import org.eclipse.jdt.internal.ui.javaeditor.JavaDocumentSetupParticipant;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.ForwardingDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JavaDocumentProvider extends CompilationUnitDocumentProvider {

    private JavaTextEditor editor;

    /**
     * Constructor
     * 
     * @param editor
     */
    public JavaDocumentProvider(JavaTextEditor editor) {
        IDocumentProvider provider = new FileDocumentProvider();
        provider = new ForwardingDocumentProvider(IJavaPartitions.JAVA_PARTITIONING, new JavaDocumentSetupParticipant(), provider);
        setParentDocumentProvider(provider);
        this.editor = editor;
    }

    @Override
    public boolean isSynchronized(Object element) {
        boolean isSynchronized = super.isSynchronized(element);
        if (isSynchronized && editor.isDirty()) {
            long modificationStamp = getModificationStamp(element);
            long synchronizationStamp = getSynchronizationStamp(element);
            return isSynchronized && (modificationStamp == synchronizationStamp);
        }
        return isSynchronized;
    }
}
