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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
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

    protected IEditorPart openEditor;

    protected Map<String, Position> startPositions = new HashMap<String, Position>();

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
     * (non-Javadoc)
     * Method declared on IEditorPart
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
     * (non-Javadoc)
     * Method declared on IEditorPart.
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

    protected void initEditor(IFile templateFile) throws CoreException {
        try {
            IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
//            IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
             IWorkbenchPage activePage = new WorkbenchPage((WorkbenchWindow)activeWorkbenchWindow, null);
            if (activePage == null || templateFile == null)
                return;
            openEditor = IDE.openEditor(activePage, templateFile, false);
            activePage.setEditorAreaVisible(true);
        } catch (PartInitException e) {
            e.printStackTrace();
        }
    }

    protected IFile setPublicTemplateEditor(Pattern pattern, EList<PatternMethod> methods, String fileExtention) {
        IFile templateFile = null;
        try {
            Resource eResource = pattern.eResource();
            IPlatformFcore platformFcore = EGFCorePlugin.getPlatformFcore(eResource);
            IProject project = platformFcore.getPlatformBundle().getProject();
            IFolder folder = project.getFolder("src");
            if (!folder.exists()) {
                folder.create(true, false, null);
            }
            templateFile = folder.getFile(fileExtention);
            if (!templateFile.exists()) {
                templateFile.create(new ByteArrayInputStream(new byte[0]), true, null);
            } else {
                templateFile.setContents(new ByteArrayInputStream(new byte[0]), true, false, null);
            }
            for (PatternMethod method : methods) {
                IFile file = project.getFile(method.getPatternFilePath().path());
                if (!file.exists()) {
                    file.create(new ByteArrayInputStream(new byte[0]), true, null);
                }
                templateFile.appendContents(file.getContents(), false, false, null);
                templateFile.appendContents(new StringBufferInputStream("\n"), true, false, null);
                int startPosition = TemplateEditorUtility.getStartPosition(startPositions);
                int length = TemplateEditorUtility.getSourceLength(file.getContents());
                Position position = new Position(startPosition, length);
                startPositions.put(method.getName(), position);
            }
            initEditor(templateFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return templateFile;
    }

}
