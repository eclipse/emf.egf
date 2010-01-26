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

package org.eclipse.egf.pattern.ui.editors.templateEditor;

import java.io.ByteArrayInputStream;
import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IOpenable;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.PackageFragmentRoot;
import org.eclipse.jdt.internal.ui.util.BusyIndicatorRunnableContext;
import org.eclipse.jdt.internal.ui.util.CoreUtility;
import org.eclipse.jdt.internal.ui.wizards.IStatusChangeListener;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathsBlock;
import org.eclipse.jdt.ui.wizards.JavaCapabilityConfigurationPage;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPage;
import org.eclipse.jface.text.Position;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginLibrary;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.bundle.Bundle;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundleModel;
import org.eclipse.pde.internal.core.ibundle.IBundleModel;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.natures.PluginProject;
import org.eclipse.pde.internal.core.plugin.PluginBase;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public abstract class AbstractTemplateEditor extends MultiPageEditorPart {
    
    private String projectName = ".templateproject";
    
	protected IEditorPart openEditor;
	
    protected Map<String, Position> startPositions = new HashMap<String, Position>();

	// The adapter is for refreshing the editor title while the name of pattern
	// has been changed.
	AdapterImpl refresher = new AdapterImpl() {
		public void notifyChanged(Notification msg) {
			if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg
					.getFeature())) {
				setPartName((String) msg.getNewValue());
			} else if (msg.getFeature() == null) {
				Pattern pattern = getPattern();
				addPatternChangeAdapter(pattern);
			}
		}
	};

    private BuildPathsBlock fBuildPathsBlock;

	public AbstractTemplateEditor() {
		super();
	}

	protected abstract void initProblems();

	protected abstract void divideByMethods();

	public abstract void setActivePage(String methodId);

	public void doSave(IProgressMonitor monitor) {
		for (int i = 0; i < getPageCount(); i++)
			getEditor(i).doSave(monitor);
	}

	public void doSaveAs() {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc) Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
	}

	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
			throws PartInitException {
		if (!(editorInput instanceof PatternEditorInput))
			throw new PartInitException(Messages.Editor_wrong_input);
		super.init(site, editorInput);
	}

	/*
	 * (non-Javadoc) Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return false;
	}

	public Pattern getPattern() {
		PatternEditorInput input = (PatternEditorInput) getEditorInput();
		if (input == null)
			throw new IllegalStateException();
		return input.getPattern();
	}

	public static IEditorPart initEditor(IFile templateFile) throws CoreException {
		try {
		    IWorkbench workbench = PlatformUI.getWorkbench();
		    IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
			WorkbenchPage  templateActivePage = /*new WorkbenchPage(
	                    (WorkbenchWindow) activeWorkbenchWindow, null);*/
			    (WorkbenchPage) activeWorkbenchWindow.getActivePage();
			if ( templateActivePage == null || templateFile == null)
				return null;
			IEditorPart openEditor = IDE.openEditor(templateActivePage, templateFile, false);
			templateActivePage.setEditorAreaVisible(false);
			return openEditor;
		} catch (PartInitException e) {
			Activator.getDefault().logError(e);
		}
        return null;
	}

	protected IFile setPublicTemplateEditor(Pattern pattern,
			EList<PatternMethod> methods, String fileExtention) {
		IFile templateFile = null;
		try {
			Resource eResource = pattern.eResource();
			IPlatformFcore platformFcore = EGFCorePlugin
					.getPlatformFcore(eResource);
			IPlatformBundle platformBundle = platformFcore.getPlatformBundle();
			IPluginBase pluginBase = platformBundle.getPluginBase();
			IPluginLibrary[] libraries = pluginBase.getLibraries();
			IPluginImport[] imports = pluginBase.getImports();
            IProject project = platformBundle.getProject();
                        
            NullProgressMonitor monitor = new NullProgressMonitor();
            
            IProject templateProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
            
            if (!templateProject.exists()) {
                // new one pluginProject.
                PluginProject pluginProject = TemplateEditorUtility.createPluginProject(projectName, monitor);
                templateProject = pluginProject.getProject();

                IBundlePluginModelBase pluginModelBase = (IBundlePluginModelBase) TemplateEditorUtility.getPluginModelBase(templateProject);
                WorkspaceBundleModel bundleModel = (WorkspaceBundleModel) pluginModelBase.getBundleModel();
                bundleModel.setEditable(true);
                IPluginBase templatePluginBase = TemplateEditorUtility.getPluginBase(templateProject);
                String name = project.getName();

                for (IPluginLibrary library : libraries) {
                    templatePluginBase.add(library);
                }
                for (IPluginImport pluginImport : imports) {
                    templatePluginBase.add(pluginImport);
                }
                bundleModel.save();
                bundleModel.setEditable(false);
            }
			
			IFolder src = templateProject.getFolder("src");
			if (!src.exists()) {
			    src.create(true, false, null);
			}
			templateFile = src.getFile(fileExtention);
			if (!templateFile.exists()) {
				templateFile.create(new ByteArrayInputStream(new byte[0]),
						true, null);
			} else {
				templateFile.setContents(new ByteArrayInputStream(new byte[0]),
						true, false, null);
			}
			for (PatternMethod method : methods) {
				IFile file = project
						.getFile(method.getPatternFilePath().path());
				if (!file.exists()) {
					file.create(new ByteArrayInputStream(new byte[0]), true,
							null);
				}
				templateFile.appendContents(file.getContents(), false, false,
						null);
				templateFile.appendContents(new StringBufferInputStream("\n"),
						true, false, null);
				int startPosition = TemplateEditorUtility
						.getStartPosition(startPositions);
				int length = TemplateEditorUtility.getSourceLength(file
						.getContents());
				Position position = new Position(startPosition, length);
				startPositions.put(method.getName(), position);
			}
			openEditor = initEditor(templateFile);
		} catch (Exception e) {
			Activator.getDefault().logError(e);
		}
		return templateFile;
	}
	
    private BuildPathsBlock getBuildPathsBlock() {
        if (fBuildPathsBlock == null) {
            fBuildPathsBlock= new BuildPathsBlock(new BusyIndicatorRunnableContext(), null, 0, true, null);
        }
        return fBuildPathsBlock;
    }
	/**
	 * While the name of the pattern has been changed, refresh the editor title.
	 */
	protected void addPatternChangeAdapter(final Pattern pattern) {
		if (pattern != null && !pattern.eAdapters().contains(refresher)) {
			pattern.eAdapters().add(refresher);
		}
	}

	/**
	 * Remove the Adapter add for refreshing the editor title
	 */
	protected void removePatternChangeAdapter() {
		Pattern pattern = getPattern();
		if (pattern != null && pattern.eAdapters().contains(refresher)) {
			pattern.eAdapters().remove(refresher);
		}
	}

	@Override
	public void dispose() {
		removePatternChangeAdapter();
		super.dispose();
	}
}
