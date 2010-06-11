/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.StorageDocumentProvider;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternTemplateEditor extends MultiPageEditorPart {

    private boolean patternInWorkspace;

    private final AdapterImpl refresher = new AdapterImpl() {

        @Override
        public void notifyChanged(Notification msg) {
            if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature()) && msg.getNotifier() instanceof Pattern) {
                setPartName((String) msg.getNewValue());
            }
        }
    };

    private final Map<String, TextEditor> editors = new HashMap<String, TextEditor>();

    public PatternTemplateEditor() {
        super();
    }

    void createPage(PatternMethod method) {
        try {

            TextEditor editor = new TextEditor() {
                {
                    setDocumentProvider(patternInWorkspace ? new FileDocumentProvider() : new StorageDocumentProvider());
                }
            };
            AbstractPatternMethodEditorInput input = null;
            if (patternInWorkspace)
                input = new WorkspacePatternMethodEditorInput(method.eResource(), method.getID());
            else
                input = new RuntimePatternMethodEditorInput(method.eResource(), method.getID());

            int index = addPage(editor, input);
            setPageText(index, method.getName());
            editors.put(method.getID(), editor);
        } catch (PartInitException e) {
            ErrorDialog.openError(getSite().getShell(), "Error creating nested text editor", null, e.getStatus());
            Activator.getDefault().logError(e);
        }
    }

    protected void createPages() {
        for (PatternMethod method : getPattern().getMethods())
            createPage(method);
    }

    public IEditorPart getEditorPart(String methodId) {
        return editors.get(methodId);
    }

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

    private void addPatternChangeAdapter() {
        Display.getDefault().syncExec(new Runnable() {

            public void run() {
                Pattern pattern = getPattern();
                if (pattern != null) {
                    pattern.eAdapters().add(refresher);
                    setPartName(pattern.getName());
                }
            }
        });
    }

    /**
     * Remove the Adapter add for refreshing the editor title
     */
    private void removePatternChangeAdapter() {
        Pattern pattern = getPattern();
        if (pattern != null && pattern.eAdapters().contains(refresher)) {
            pattern.eAdapters().remove(refresher);
        }
    }

    /**
     * The <code>MultiPageEditorExample</code> implementation of this method
     * checks that the input is an instance of <code>IFileEditorInput</code>.
     */
    public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
        if (!(editorInput instanceof PatternEditorInput))
            throw new PartInitException(Messages.Editor_wrong_input);
        super.init(site, editorInput);
        addPatternChangeAdapter();
        IPlatformFcore platformFcore = EGFCorePlugin.getPlatformFcore(((PatternEditorInput) editorInput).getResource());
        patternInWorkspace = platformFcore.getPlatformBundle().getProject() != null;
    }

    public void dispose() {
        // if init failed, dispose should not called this
        if (getEditorInput() != null && getEditorInput() instanceof PatternEditorInput) {
            removePatternChangeAdapter();
        }
        super.dispose();
    }

    /*
     * (non-Javadoc)
     * Method declared on IEditorPart.
     */
    public boolean isSaveAsAllowed() {
        return false;
    }

    private Pattern getPattern() {
        PatternEditorInput input = (PatternEditorInput) getEditorInput();
        if (input == null)
            throw new IllegalStateException();
        return input.getPattern();
    }

    public void setActiveEditor(String methodId) {
        IEditorPart editorPart = getEditorPart(methodId);
        if (editorPart != null) {
            super.setActiveEditor(editorPart);
        }
    }

}
