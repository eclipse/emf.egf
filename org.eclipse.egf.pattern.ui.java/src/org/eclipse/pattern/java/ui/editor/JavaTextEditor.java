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

package org.eclipse.pattern.java.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitDocumentProvider;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jdt.internal.ui.text.PreferencesAdapter;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.JavaTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class JavaTextEditor extends TextEditor {

    public JavaTextEditor() {

        CompilationUnitDocumentProvider provider = new CompilationUnitDocumentProvider();
        setDocumentProvider(provider);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * 
     * org.eclipse.ui.editors.text.TextEditor#doSetInput(org.eclipse.ui.IEditorInput
     * )
     */
    protected void doSetInput(IEditorInput input) throws CoreException {
        super.doSetInput(input);
        IPreferenceStore store = createCombinedPreferenceStore(input);
        setPreferenceStore(store);

        ISourceViewer sourceViewer = getSourceViewer();
        if (sourceViewer instanceof JavaSourceViewer) {
            ((JavaSourceViewer) sourceViewer).setPreferenceStore(store);
        }
        JavaTextTools textTools = JavaPlugin.getDefault().getJavaTextTools();
        JavaSourceViewerConfiguration configure = new JavaSourceViewerConfiguration(textTools.getColorManager(), store, this, IJavaPartitions.JAVA_PARTITIONING);
        setSourceViewerConfiguration(configure);
    }

    /**
     * @param input
     * @return
     */
    private IPreferenceStore createCombinedPreferenceStore(IEditorInput input) {
        List stores = new ArrayList(3);

        IJavaProject project = EditorUtility.getJavaProject(input);
        if (project != null) {
            stores.add(new EclipsePreferencesAdapter(new ProjectScope(project.getProject()), JavaCore.PLUGIN_ID));
        }

        stores.add(JavaPlugin.getDefault().getPreferenceStore());
        stores.add(new PreferencesAdapter(JavaCore.getPlugin().getPluginPreferences()));
        stores.add(EditorsUI.getPreferenceStore());
        stores.add(PlatformUI.getPreferenceStore());

        return new ChainedPreferenceStore((IPreferenceStore[]) stores.toArray(new IPreferenceStore[stores.size()]));
    }

}
