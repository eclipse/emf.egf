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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
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

    // method adapter
    private final AdapterImpl methodAdapter = new AdapterImpl() {

        @Override
        public void notifyChanged(Notification msg) {
            if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature()) && msg.getNotifier() instanceof PatternMethod) {
                executeMethodEditorRename((PatternMethod) msg.getNotifier());
            }
        }

    };

    // The current pattern adapter
    private final AdapterImpl patternAdapter = new AdapterImpl() {

        @Override
        public void notifyChanged(final Notification msg) {
            if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature()) && msg.getNotifier() instanceof Pattern) {
                // Title update
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        setPartName((String) msg.getNewValue());
                    }

                });

            } else if (PatternPackage.Literals.PATTERN_ELEMENT__CONTAINER.equals(msg.getFeature()) && msg.getNewValue() == null) {
                // Removed Pattern
                // just close now without prompt
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        getSite().getPage().closeEditor(PatternTemplateEditor.this, false);
                    }

                });

            } else if (PatternPackage.Literals.PATTERN__METHODS.equals(msg.getFeature())) {
                refreshTemplateEditor(msg);
            }

        }

    };

    private final Map<String, TextEditor> editors = new HashMap<String, TextEditor>();

    /**
     * Domain resource listener
     */
    private boolean patternInWorkspace = false;

    /**
     * Current pattern
     */
    private Pattern pattern;

    /**
     * Domain resource listener
     */
    private final ResourceListener resourceListener = new ResourceListener() {

        public void resourceMoved(Resource movedResource, final URI oldURI) {
            if (movedResource == getResource()) {
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        setInputWithNotify(new PatternEditorInput(getResource(), ((PatternEditorInput) getEditorInput()).getID()));
                        firePropertyChange(PROP_TITLE);
                    }

                });
            }
        }

        public void resourceDeleted(Resource deletedResource) {
            if ((deletedResource == getResource())) {
                // just close now without prompt
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        getSite().getPage().closeEditor(PatternTemplateEditor.this, false);
                    }

                });
            }
        }

        public void resourceReloaded(Resource reloadedResource) {

            if (reloadedResource == getResource()) {

                // Create a new input
                final PatternEditorInput newEditorInput = new PatternEditorInput(getResource(), ((PatternEditorInput) getEditorInput()).getID());

                // Check whether or not this pattern is still alive
                if (newEditorInput.getPattern() != null) {

                    getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        public void run() {

                            // Do we have something to do
                            if (pattern != newEditorInput.getPattern()) {

                                // Remove previous adapters
                                removePatternChangeAdapter();
                                // Store reloaded pattern
                                pattern = newEditorInput.getPattern();
                                // Add new adapters
                                addPatternChangeAdapter();

                                // Should we update this template editor
                                if ((newEditorInput.getFile() == null && patternInWorkspace) || (newEditorInput.getFile() != null && patternInWorkspace == false)) {
                                    // Remove pages
                                    for (int i = getPageCount() - 1; i != -1; i--) {
                                        removePage(i);
                                    }
                                    // Update
                                    patternInWorkspace = newEditorInput.getFile() != null;
                                    // Create pages
                                    createPages();
                                    // Activate
                                    if (getPageCount() != 0) {
                                        setActivePage(0);
                                    }
                                    // Update editorInput
                                    setInputWithNotify(newEditorInput);
                                } else {
                                    // Pattern method analysis
                                }

                                // Update title
                                firePropertyChange(PROP_TITLE);

                            }
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
                // Wait until we are notified, this couldn't happen though
                // if we are the latest opened editor in our editing domain
                // anyway we don't how to deal with this situation yet
            }
        }

        public void internalUpdate(Resource changedResource) {
            if (changedResource == getResource()) {
                // Nothing to do
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
            for (int i = 0; i < getPageCount(); i++) {
                if (editorPart.equals(getEditor(i))) {
                    setPageText(i, patternMethod.getName());
                }
            }
        }
    }

    private void executeMethodEditorRemove(PatternMethod deleteMethod) {
        getSite().getShell().getDisplay().asyncExec(new Runnable() {

            public void run() {
                for (int i = 0; i < getPageCount(); i++) {
                    IEditorPart editor = getEditor(i);
                    AbstractPatternMethodEditorInput input = (AbstractPatternMethodEditorInput) editor.getEditorInput();
                    PatternMethod patternMethod = input.getPatternMethod();
                    if (patternMethod == null) {
                        removePage(i);
                    }
                }
            }

        });

    }

    protected void executeMethodEditorAdd(final PatternMethod addMethod) {
        getSite().getShell().getDisplay().asyncExec(new Runnable() {

            public void run() {
                createPage(addMethod);
            }

        });
        addMethodChangeAdapter(addMethod);
    }

    /**
     * Add method adapters
     */
    protected void addMethodChangeAdapter(PatternMethod method) {
        if (method != null && method.eAdapters().contains(methodAdapter) == false) {
            method.eAdapters().add(methodAdapter);
        }
    }

    /**
     * Remove method adapters
     */
    protected void removeMethodChangeAdapter(PatternMethod method) {
        if (method != null && method.eAdapters().contains(methodAdapter)) {
            method.eAdapters().remove(methodAdapter);
        }
    }

    /**
     * Add pattern and methods adapters
     */
    private void addPatternChangeAdapter() {
        if (pattern != null && pattern.eAdapters().contains(patternAdapter) == false) {
            pattern.eAdapters().add(patternAdapter);
            EList<PatternMethod> methods = pattern.getMethods();
            for (PatternMethod method : methods) {
                addMethodChangeAdapter(method);
            }
        }
    }

    /**
     * Remove pattern and methods adapters
     */
    protected void removePatternChangeAdapter() {
        if (pattern != null && pattern.eAdapters().contains(patternAdapter)) {
            pattern.eAdapters().remove(patternAdapter);
        }
        EList<PatternMethod> methods = pattern.getMethods();
        for (PatternMethod method : methods) {
            removeMethodChangeAdapter(method);
        }
    }

    void createPage(PatternMethod method) {
        try {
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
        for (PatternMethod method : pattern.getMethods()) {
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
    }

    @Override
    public void doSaveAs() {
        throw new UnsupportedOperationException();
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
        patternInWorkspace = ((PatternEditorInput) getEditorInput()).getFile() != null;
        pattern = ((PatternEditorInput) getEditorInput()).getPattern();
        EGFResourceLoadedListener.getResourceManager().addObserver(this);
        addPatternChangeAdapter();
        setPartName(pattern.getName());
    }

    @Override
    public void dispose() {
        // if init failed, dispose should not called this
        if (getEditorInput() != null && getEditorInput() instanceof PatternEditorInput) {
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

    public void setActiveEditor(String methodId) {
        IEditorPart editorPart = getEditorPart(methodId);
        if (editorPart != null) {
            super.setActiveEditor(editorPart);
        }
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
        return false;
    }

    public boolean resourceHasBeenExternallyChanged() {
        return false;
    }

}
