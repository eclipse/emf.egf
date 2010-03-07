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
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editors.PatternMethodEditorInput;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.Position;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.ui.editor.plugin.ManifestEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public abstract class AbstractTemplateEditor extends MultiPageEditorPart {

    private String projectName = "___templateproject";

    protected IEditorPart openEditor;

    protected Map<String, Position> startPositions = new HashMap<String, Position>();

    protected WorkbenchPage templateActivePage;

    protected Map<String, TextEditor> editorMap = new HashMap<String, TextEditor>();

    protected List<TextEditor> editorList = new ArrayList<TextEditor>();

    private static final String JET_TRANSFORM_POINT_ID = "org.eclipse.jet.transform";

    private static final String PLUGIN_EDITOR_ID = "org.eclipse.pde.ui.manifestEditor";

    // The adapter is for refreshing the editor title while the name of pattern
    // has been changed.
    AdapterImpl patternAdapter = new AdapterImpl() {
        public void notifyChanged(Notification msg) {
            if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature())) {
                setPartName((String) msg.getNewValue());
            } else if (msg.getFeature() instanceof EReference) {
                EReference ref = (EReference) msg.getFeature();
                if ("methods".equals(ref.getName())) {
                    refreshTemplateEditor(msg);
                }
            }
        }
    };

    AdapterImpl methodAdapter = new AdapterImpl() {
        public void notifyChanged(Notification msg) {
            if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature())) {
                executeMethodEditorRename();
            }
        }
    };

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
    public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
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

    public IEditorPart initEditor(IFile templateFile) throws CoreException {
        try {
            IWorkbench workbench = PlatformUI.getWorkbench();
            IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
            templateActivePage = new WorkbenchPage((WorkbenchWindow) activeWorkbenchWindow, null);
            if (templateActivePage == null || templateFile == null)
                return null;
            IEditorPart openEditor = IDE.openEditor(templateActivePage, templateFile, false);
            return openEditor;
        } catch (PartInitException e) {
            Activator.getDefault().logError(e);
        }
        return null;
    }

    protected IFile setPublicTemplateEditor(Pattern pattern, EList<PatternMethod> methods, String fileExtention) {
        IFile templateFile = null;
        try {
            Resource eResource = pattern.eResource();
            IPlatformFcore platformFcore = EGFCorePlugin.getPlatformFcore(eResource);
            IPlatformBundle platformBundle = platformFcore.getPlatformBundle();
            IProject project = platformBundle.getProject();

            NullProgressMonitor monitor = new NullProgressMonitor();
            String tempProjectName = "." + project.getName() + projectName;
            IProject templateProject = ResourcesPlugin.getWorkspace().getRoot().getProject(tempProjectName);

            if (!templateProject.exists()) {
                // Delete project content in disk.
                getTemplateProject(templateProject, tempProjectName, monitor);
                templateProject.delete(true, true, monitor);
                // Create new template project.
                getTemplateProject(templateProject, tempProjectName, monitor);
                ConvertPluginProjectOperation convert = new ConvertPluginProjectOperation(templateProject, platformBundle);
                convert.execute(monitor);
            }
            IFolder src = templateProject.getFolder("src");
            if (!src.exists()) {
                src.create(true, false, null);
            }
            // Filter the template project extensions.
            filterUselessExtension(templateProject, monitor);
            templateFile = src.getFile(fileExtention);
            if (!templateFile.exists()) {
                templateFile.create(new ByteArrayInputStream(new byte[0]), true, null);
            } else {
                templateFile.setContents(new ByteArrayInputStream(new byte[0]), true, false, null);
            }
            PatternMethod footMethod = null;
            for (PatternMethod method : methods) {
                if (method.equals(pattern.getFooterMethod())) {
                    footMethod = method;
                    continue;
                }
                visitMethod(project, method, templateFile, true);
            }
            visitMethod(project, footMethod, templateFile, false);
            openEditor = initEditor(templateFile);
        } catch (Exception e) {
            // Ignore
        }
        return templateFile;
    }

    private void visitMethod(IProject project, PatternMethod method, IFile templateFile, boolean seprator) throws CoreException, IOException {
        IFile file = project.getFile(method.getPatternFilePath().path());
        if (!file.exists()) {
            file.create(new ByteArrayInputStream(new byte[0]), true, null);
        }
        templateFile.appendContents(file.getContents(), false, false, null);
        if (seprator) {
            templateFile.appendContents(new StringBufferInputStream("\n"), true, false, null);
        }
        int startPosition = TemplateEditorUtility.getStartPosition(startPositions);
        int length = TemplateEditorUtility.getSourceLength(file.getContents());
        Position position = new Position(startPosition, length);
        startPositions.put(method.getName(), position);
    }

    /**
     * While pattern has been changed, refresh the editor title.
     */
    protected void addPatternChangeAdapter(final Pattern pattern) {
        if (pattern != null && !pattern.eAdapters().contains(patternAdapter)) {
            pattern.eAdapters().add(patternAdapter);
            EList<PatternMethod> methods = pattern.getMethods();
            for (PatternMethod method : methods) {
                addMethodChangeAdapter(method);
            }
        }
    }

    /**
     * While method has been changed, refresh the editor title.
     */
    protected void addMethodChangeAdapter(PatternMethod method) {
        if (method != null && !method.eAdapters().contains(methodAdapter)) {
            method.eAdapters().add(methodAdapter);
        }
    }

    /**
     * Remove the Adapter add for refreshing the editor title
     */
    protected void removePatternChangeAdapter() {
        Pattern pattern = getPattern();
        if (pattern != null && pattern.eAdapters().contains(patternAdapter)) {
            pattern.eAdapters().remove(patternAdapter);
        }
        if (pattern != null) {
            EList<PatternMethod> methods = pattern.getMethods();
            for (PatternMethod method : methods) {
                removeMethodChangeAdapter(method);
            }
        }
    }

    /**
     * Remove the Adapter add for refreshing the editor title
     */
    protected void removeMethodChangeAdapter(PatternMethod method) {
        if (method != null && method.eAdapters().contains(methodAdapter)) {
            method.eAdapters().remove(methodAdapter);
        }
    }

    public WorkbenchPage getTemplateActivePage() {
        return templateActivePage;
    }

    /**
     * Refresh the template editor while user change the content of pattern's
     * methods.
     */
    private void refreshTemplateEditor(Notification msg) {
        Object newValue = msg.getNewValue();
        Object oldValue = msg.getOldValue();
        int eventType = msg.getEventType();
        if ((newValue != null && newValue instanceof PatternMethod) || (newValue == null && oldValue instanceof PatternMethod)) {
            switch (eventType) {
            case Notification.ADD:
                executeMethodEditorAdd((PatternMethod) newValue);
                break;
            case Notification.REMOVE:
                executeMethodEditorRemove((PatternMethod) oldValue);
                break;
            case Notification.MOVE:
                executeMethodEditorsReorder((PatternMethod) newValue, oldValue);
                break;
            default:
                return;
            }
        }
    }

    private void executeMethodEditorRename() {
        for (TextEditor editor : editorList) {
            PatternMethod patternMethod = ((PatternMethodEditorInput) editor.getEditorInput()).getPatternMethod();
            if (patternMethod != null) {
                int index = getIndexOfMethodEditor(editor);
                if (index != -1)
                    setPageText(index, patternMethod.getName());
            }
        }
    }

    private void executeMethodEditorRemove(PatternMethod deleteMethod) {
        for (int i = 0; i < this.getPageCount(); i++) {
            IEditorPart currentEditor = this.getEditor(i);
            IEditorInput editorInput = currentEditor.getEditorInput();
            if (editorInput instanceof PatternMethodEditorInput) {
                PatternMethod patternMethod = ((PatternMethodEditorInput) editorInput).getPatternMethod();
                if (patternMethod == null) {
                    removePage(i);
                    removeEditor(currentEditor);
                }
            }
        }
    }

    private void removeEditor(IEditorPart editor) {
        editorList.remove(editor);
        Set<Entry<String, TextEditor>> entrySet = editorMap.entrySet();
        for (Entry<String, TextEditor> entry : entrySet) {
            if (entry.getValue().equals(editor)) {
                editorMap.remove(entry.getKey());
                return;
            }
        }
    }

    protected void executeMethodEditorAdd(PatternMethod addMethod) {
        addMethodChangeAdapter(addMethod);
    }

    protected void addEditor(TextEditor editor, PatternMethod method) {
        try {
            PatternMethodEditorInput input = new PatternMethodEditorInput(method.eResource(), method.getID());
            int index = addPage(editor, input);
            setPageText(index, method.getName());
            editorMap.put(method.getID(), editor);
            editorList.add(editor);
        } catch (PartInitException e) {
            Activator.getDefault().logError(e);
        }
    }

    protected void setPatternFilePath(PatternMethod addMethod) {
        URI computeFileURI = PatternHelper.Filename.computeFileURI(addMethod);
        addMethod.setPatternFilePath(computeFileURI);
    }

    protected void executeMethodEditorsReorder(PatternMethod moveMethod, Object oldValue) {
        int newIndex = getPattern().getMethods().indexOf(moveMethod);
        if (oldValue instanceof Integer) {
            int oldIndex = (Integer) oldValue;
            String id = moveMethod.getID();
            TextEditor textEditor = editorMap.get(id);
            if (textEditor.isDirty()) {
                textEditor.doSave(null);
            }
            removePage(oldIndex);
            editorMap.remove(id);
            editorList.remove(textEditor);
            try {
                TextEditor newEditor = createNewEditor();
                PatternMethodEditorInput input = new PatternMethodEditorInput(moveMethod.eResource(), id);
                addPage(newIndex, newEditor, input);
                editorMap.put(id, newEditor);
                editorList.add(newIndex, newEditor);
            } catch (PartInitException e) {
                Activator.getDefault().logError(e);
            }
            setPageText(newIndex, moveMethod.getName());
        }
    }

    protected int getIndexOfMethodEditor(TextEditor editor) {
        int index = -1;
        for (int i = 0; i < this.getPageCount(); i++) {
            IEditorPart currentEditor = this.getEditor(i);
            if (editor.equals(currentEditor)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void filterUselessExtension(IProject project, NullProgressMonitor monitor) {
        IFile plugInFile = project.getFile(ConvertPluginProjectOperation.F_PLUGIN);
        if (plugInFile.exists()) {
            IWorkbench workbench = PlatformUI.getWorkbench();
            IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
            try {
                WorkbenchPage templateActivePage = new WorkbenchPage((WorkbenchWindow) activeWorkbenchWindow, null);
                IEditorPart part = IDE.openEditor(templateActivePage, plugInFile, PLUGIN_EDITOR_ID);
                if (part instanceof ManifestEditor) {
                    ManifestEditor editor = (ManifestEditor) part;
                    IBaseModel base = editor.getAggregateModel();
                    if (base instanceof IBundlePluginModelBase) {
                        IBundlePluginModelBase bundlePluginModel = (IBundlePluginModelBase) base;
                        IPluginBase pluginBase = bundlePluginModel.getPluginBase();
                        IPluginModelBase pluginModel = pluginBase.getPluginModel();
                        IPluginExtension[] extensions = pluginModel.getPluginBase().getExtensions();
                        for (IPluginExtension currentExtension : extensions) {
                            String point = currentExtension.getPoint();
                            if (!JET_TRANSFORM_POINT_ID.equals(point)) {
                                try {
                                    pluginModel.getPluginBase().remove(currentExtension);
                                } catch (CoreException e) {
                                    Activator.getDefault().logError(e);
                                }
                            }
                        }
                        part.doSave(monitor);
                        part.dispose();
                    }
                }
            } catch (WorkbenchException e) {
                Activator.getDefault().logError(e);
            }
        }
    }

    public Map<String, TextEditor> getEditorMap() {
        return editorMap;
    }

    public List<TextEditor> getEditorList() {
        return editorList;
    }

    protected abstract TextEditor createNewEditor();

    private void getTemplateProject(IProject templateProject, String tempProjectName, NullProgressMonitor monitor) {
        IJavaProject javaProject = TemplateEditorUtility.createJavaProject(tempProjectName, monitor);
        templateProject = javaProject.getProject();
    }

    @Override
    public void dispose() {
        removePatternChangeAdapter();
        super.dispose();
    }
}
