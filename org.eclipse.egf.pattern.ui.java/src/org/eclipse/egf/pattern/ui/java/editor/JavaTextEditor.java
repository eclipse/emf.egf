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

package org.eclipse.egf.pattern.ui.java.editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.model.pattern.Pattern;
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
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
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

	private RefreshUIJob job;

	private Pattern pattern;

	public JavaTextEditor(Pattern pattern) throws CoreException, IOException {
		this.pattern = pattern;
		CompilationUnitDocumentProvider provider = new CompilationUnitDocumentProvider();
		setDocumentProvider(provider);
	}

	public Pattern getPattern() {
		return pattern;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
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
		JavaSourceViewerConfiguration configure = new JavaTextSourceViewerConfiguration(
				textTools.getColorManager(), store, this,
				IJavaPartitions.JAVA_PARTITIONING);
		setSourceViewerConfiguration(configure);
	}

	public void doSave(IProgressMonitor progressMonitor) {
//		refreshErrorManage();
		super.doSave(progressMonitor);
	}

	@Override
	protected void updateStatusField(String category) {
		super.updateStatusField(category);
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		StyledText textWidget = getSourceViewer().getTextWidget();
		textWidget.addModifyListener(new JavaModifyListener());
	}

	class JavaModifyListener implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			if (job == null) {
				job = new RefreshUIJob("RefreshTemplateEditor");
			}
			job.start();
		}
	}

	class RefreshUIJob extends Job {

		private long timestamp = -1;

		private boolean lazy = false;

		public RefreshUIJob(String name) {
			super(name);
		}

		private void start() {
			if (!lazy) {
				schedule(1000);
			} else if (System.currentTimeMillis() - timestamp > 999 && !lazy) {
				lazy = true;
			}
			timestamp = System.currentTimeMillis();
		}

		protected IStatus run(IProgressMonitor monitor) {
			JavaTextEditorHelper
			.refreshPublicTemplateEditor(JavaTextEditor.this);
			if (lazy) {
				schedule();
				lazy = false;
			}
			return Status.OK_STATUS;
		}
	}

	/**
	 * @param input
	 * @return
	 */
	private IPreferenceStore createCombinedPreferenceStore(IEditorInput input) {
		List stores = new ArrayList(3);

		IJavaProject project = EditorUtility.getJavaProject(input);
		if (project != null) {
			stores.add(new EclipsePreferencesAdapter(new ProjectScope(project
					.getProject()), JavaCore.PLUGIN_ID));
		}

		stores.add(JavaPlugin.getDefault().getPreferenceStore());
		stores.add(new PreferencesAdapter(JavaCore.getPlugin()
				.getPluginPreferences()));
		stores.add(EditorsUI.getPreferenceStore());
		stores.add(PlatformUI.getPreferenceStore());

		return new ChainedPreferenceStore((IPreferenceStore[]) stores
				.toArray(new IPreferenceStore[stores.size()]));
	}

	/**
	 * @return the source viewer used by this editor
	 */
	public final ISourceViewer getViewer() {
		return getSourceViewer();
	}

	private JavaTextEditor getEditor() {
		return this;
	}
}
