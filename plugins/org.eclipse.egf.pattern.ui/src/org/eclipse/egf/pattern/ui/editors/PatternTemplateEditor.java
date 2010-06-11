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

package org.eclipse.egf.pattern.ui.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener.ResourceListener;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener.ResourceUser;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.StorageDocumentProvider;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternTemplateEditor extends MultiPageEditorPart implements ResourceUser {

    public static final String ID = "org.eclipse.egf.pattern.ui.pattern.template.editor.id"; //$NON-NLS-1$

    private final AdapterImpl methodAdapter = new AdapterImpl() {

        @Override
        public void notifyChanged(Notification msg) {
            if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature()) && msg.getNotifier() instanceof PatternMethod) {
                executeMethodEditorRename((PatternMethod) msg.getNotifier());
            }
        }

    };

    private final AdapterImpl refresher = new AdapterImpl() {

        @Override
        public void notifyChanged(Notification msg) {
            if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature()) && msg.getNotifier() instanceof Pattern) {
                setPartName((String) msg.getNewValue());
            } else if (PatternPackage.Literals.PATTERN__METHODS.equals(msg.getFeature())) {
                refreshTemplateEditor(msg);
            }

        }

    };

    /**
     * This listens for when the outline becomes active
     */
    protected IPartListener partListener = new IPartListener() {

        public void partActivated(IWorkbenchPart p) {
            if (p == PatternTemplateEditor.this) {
                handleActivate();
            }
        }

        public void partBroughtToTop(IWorkbenchPart p) {
            // Nothing to do
        }

        public void partClosed(IWorkbenchPart p) {
            // Nothing to do
        }

        public void partDeactivated(IWorkbenchPart p) {
            // Nothing to do
        }

        public void partOpened(IWorkbenchPart p) {
            // Nothing to do
        }

    };

    private final Map<String, TextEditor> editors = new HashMap<String, TextEditor>();

    /**
     * Whether or not user saved this resource in this editor
     */
    protected boolean userHasSavedResource;

    /**
     * Whether or not this resource has been externally changed
     */
    protected boolean resourceHasBeenExternallyChanged;

    /**
     * Whether or not this resource has been removed
     */
    protected boolean resourceHasBeenRemoved;

    /**
     * Domain resource listener
     */
    private final ResourceListener resourceListener = new ResourceListener() {

        public void resourceMoved(Resource movedResource, final URI oldURI) {
            if (movedResource == getResource()) {
                resourceHasBeenExternallyChanged = false;
                resourceHasBeenRemoved = false;
                userHasSavedResource = false;
            }
        }

        public void resourceDeleted(Resource deletedResource) {
            if ((deletedResource == getResource())) {
                if (isDirty() == false) {
                    // just close now without prompt
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        public void run() {
                            getSite().getPage().closeEditor(PatternTemplateEditor.this, false);
                        }

                    });
                } else {
                    resourceHasBeenRemoved = true;
                }
            }
        }

        public void resourceReloaded(Resource reloadedResource) {
            if (reloadedResource == getResource()) {
                resourceHasBeenExternallyChanged = false;
                resourceHasBeenRemoved = false;
                userHasSavedResource = false;
                // Remove previous adapter
                removePatternChangeAdapter();
                // Check whether or not this pattern is still alive
                if (getPattern() != null) {
                    addPatternChangeAdapter();
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        public void run() {
                            // Remove pages
                            for (int i = getPageCount() - 1; i != -1; i--) {
                                removePage(i);
                            }
                            setInputWithNotify(new PatternEditorInput(getResource(), getPattern().getID()));
                            // Create pages
                            createPages();
                            // Activate
                            if (getPageCount() != 0) {
                                setActivePage(0);
                            }
                            firePropertyChange(PROP_TITLE);
                        }

                    });
                } else {
                    // just close now without prompt
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        public void run() {
                            getSite().getPage().closeEditor(PatternTemplateEditor.this, false);
                        }

                    });
                }
            }

        }

        public void externalUpdate(Resource changedResource) {
            if (changedResource == getResource()) {
                resourceHasBeenExternallyChanged = true;
            }
        }

        public void internalUpdate(Resource changedResource) {
            if (changedResource == getResource()) {
                resourceHasBeenExternallyChanged = false;
                resourceHasBeenRemoved = false;
                userHasSavedResource = false;
                // Check whether or not this pattern is still alive
                if (getPattern() == null) {
                    // just close now without prompt
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        public void run() {
                            getSite().getPage().closeEditor(PatternTemplateEditor.this, false);
                        }

                    });
                }
            }
        }

    };

    public PatternTemplateEditor() {
        super();
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
                // case Notification.MOVE:
                // executeMethodEditorsReorder((PatternMethod) newValue, oldValue);
                // break;
                default:
                    return;
            }
        }
    }

    private void executeMethodEditorRename(PatternMethod patternMethod) {
        IEditorPart editorPart = getEditorPart(patternMethod.getID());
        if (editorPart != null) {
            for (int i = 0; i < getPageCount(); i++)
                if (editorPart.equals(getEditor(i)))
                    setPageText(i, patternMethod.getName());

        }
    }

    private void executeMethodEditorRemove(PatternMethod deleteMethod) {
        for (int i = 0; i < getPageCount(); i++) {
            IEditorPart editor = getEditor(i);
            AbstractPatternMethodEditorInput input = (AbstractPatternMethodEditorInput) editor.getEditorInput();
            PatternMethod patternMethod = input.getPatternMethod();
            if (patternMethod == null)
                removePage(i);
        }
    }

    protected void executeMethodEditorAdd(final PatternMethod addMethod) {
        getActiveEditor().getSite().getShell().getDisplay().asyncExec(new Runnable() {

            public void run() {
                createPage(addMethod);
            }

        });
        addMethodChangeAdapter(addMethod);
    }

    /**
     * While pattern has been changed, refresh the editor title.
     */
    protected void addPatternChangeAdapter(final Pattern pattern) {
        if (pattern != null && !pattern.eAdapters().contains(refresher)) {
            pattern.eAdapters().add(refresher);
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
        if (pattern == null) {
            return;
        }
        if (pattern.eAdapters().contains(refresher)) {
            pattern.eAdapters().remove(refresher);
        }
        EList<PatternMethod> methods = pattern.getMethods();
        for (PatternMethod method : methods) {
            removeMethodChangeAdapter(method);
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

    void createPage(PatternMethod method) {
        try {
            final boolean patternInWorkspace = ((PatternEditorInput) getEditorInput()).getFile() != null;
            TextEditor editor = new TextEditor() {

                {
                    setDocumentProvider(patternInWorkspace ? new FileDocumentProvider() : new StorageDocumentProvider());
                }

            };
            AbstractPatternMethodEditorInput input = null;
            if (patternInWorkspace) {
                input = new WorkspacePatternMethodEditorInput(method.eResource(), method.getID());
            } else {
                input = new RuntimePatternMethodEditorInput(method.eResource(), method.getID());
            }
            int index = addPage(editor, input);
            setPageText(index, method.getName());
            editors.put(method.getID(), editor);
        } catch (PartInitException e) {
            ErrorDialog.openError(getSite().getShell(), "Error creating nested text editor", null, e.getStatus()); //$NON-NLS-1$
            Activator.getDefault().logError(e);
        }
    }

    @Override
    protected void createPages() {
        for (PatternMethod method : getPattern().getMethods()) {
            createPage(method);
        }
    }

    public IEditorPart getEditorPart(String methodId) {
        return editors.get(methodId);
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        for (int i = 0; i < getPageCount(); i++) {
            getEditor(i).doSave(monitor);
        }
        userHasSavedResource = true;
    }

    @Override
    public void doSaveAs() {
        throw new UnsupportedOperationException();
    }

    private void addPatternChangeAdapter() {
        Display.getDefault().asyncExec(new Runnable() {

            public void run() {
                Pattern pattern = getPattern();
                if (pattern != null) {
                    addPatternChangeAdapter(pattern);
                    setPartName(pattern.getName());
                }
            }

        });
    }

    /**
     * The <code>MultiPageEditorExample</code> implementation of this method
     * checks that the input is an instance of <code>IFileEditorInput</code>.
     */
    @Override
    public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
        if (editorInput instanceof PatternEditorInput == false) {
            throw new PartInitException(Messages.Editor_wrong_input);
        }
        super.init(site, editorInput);
        site.getPage().addPartListener(partListener);
        resourceHasBeenExternallyChanged = EGFResourceLoadedListener.getResourceManager().resourceHasBeenExternallyChanged(getResource());
        EGFResourceLoadedListener.getResourceManager().addObserver(this);
        addPatternChangeAdapter();
    }

    @Override
    public void dispose() {
        // if init failed, dispose should not called this
        if (getEditorInput() != null && getEditorInput() instanceof PatternEditorInput) {
            getSite().getPage().removePartListener(partListener);
            removePatternChangeAdapter();
        }
        EGFResourceLoadedListener.getResourceManager().removeObserver(this);
        super.dispose();
    }

    /*
     * (non-Javadoc)
     * Method declared on IEditorPart.
     */
    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    public Resource getResource() {
        PatternEditorInput input = (PatternEditorInput) getEditorInput();
        if (input == null)
            throw new IllegalStateException();
        return input.getResource();
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

    /**
     * Handles activation of the editor or it's associated views.
     */
    protected void handleActivate() {
        if (resourceHasBeenRemoved) {
            if (handleDirtyConflict()) {
                getSite().getPage().closeEditor(PatternTemplateEditor.this, false);
            }
        } else if (resourceHasBeenExternallyChanged) {
            handleChangedResource();
        }
    }

    /**
     * Handles what to do with changed resource on activation.
     */
    protected void handleChangedResource() {
        if (isDirty() == false || handleDirtyConflict()) {
            EGFResourceLoadedListener.getResourceManager().reloadResource(getResource());
        }
    }

    /**
     * Shows a dialog that asks if conflicting changes should be discarded. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     */
    protected boolean handleDirtyConflict() {
        return MessageDialog.openQuestion(getSite().getShell(), "File Conflict", //$NON-NLS-1$
                "External changes, close the editor ?"); //$NON-NLS-1$
    }

    public ResourceListener getListener() {
        return resourceListener;
    }

    public IOperationHistory getOperationHistory() {
        return null;
    }

    public ObjectUndoContext getUndoContext() {
        return null;
    }

    public boolean userHasSavedResource() {
        return userHasSavedResource;
    }

    public boolean resourceHasBeenExternallyChanged() {
        return resourceHasBeenExternallyChanged;
    }

}
