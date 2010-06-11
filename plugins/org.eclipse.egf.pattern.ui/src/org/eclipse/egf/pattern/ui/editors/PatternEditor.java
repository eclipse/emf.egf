/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.ui.editors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener.ResourceListener;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener.ResourceUser;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.pages.ImplementationPage;
import org.eclipse.egf.pattern.ui.editors.pages.OverviewPage;
import org.eclipse.egf.pattern.ui.editors.pages.PatternEditorPage;
import org.eclipse.egf.pattern.ui.editors.pages.SpecificationPage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class PatternEditor extends FormEditor implements ResourceUser, IEditingDomainProvider {

    public static final String ID = "org.eclipse.egf.pattern.ui.pattern.editor.id"; //$NON-NLS-1$

    /**
     * UndoContext
     */
    protected ObjectUndoContext undoContext;

    /**
     * TransactionalEditingDomain
     */
    private TransactionalEditingDomain editingDomain;

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
     * Current pattern
     */
    private Pattern pattern;

    /**
     * Current title
     */
    private String partName;

    private final ResourceListener resourceListener = new ResourceListener() {

        public void resourceMoved(Resource movedResource, final URI oldURI) {
            // TODO: partially implemented, we do need to handle .pt
            if (movedResource == getResource()) {
                resourceHasBeenExternallyChanged = false;
                resourceHasBeenRemoved = false;
                userHasSavedResource = false;
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
                if (isDirty() == false) {
                    // just close now without prompt
                    getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        public void run() {
                            getSite().getPage().closeEditor(PatternEditor.this, false);
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

                                getOperationHistory().dispose(undoContext, true, true, true);
                                firePropertyChange(IEditorPart.PROP_DIRTY);
                                setInputWithNotify(newEditorInput);
                                for (PatternEditorPage page : pages) {
                                    page.rebind(newEditorInput);
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
                            getSite().getPage().closeEditor(PatternEditor.this, false);
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

                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        firePropertyChange(IEditorPart.PROP_DIRTY);
                    }

                });

            }

        }

    };

    /**
     * This listens for when the outline becomes active
     */
    protected IPartListener partListener = new IPartListener() {

        public void partActivated(IWorkbenchPart p) {
            if (p == PatternEditor.this) {
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

    private final List<PatternEditorPage> pages = new ArrayList<PatternEditorPage>();

    /**
     * Adapter used to update the problem indication when resources are demanded
     * loaded.
     */
    protected EContentAdapter editorResourceAdapter = new EContentAdapter() {

        @Override
        public void notifyChanged(Notification notification) {
            // Process Resource who belongs to a resource set
            if (notification.getNotifier() instanceof Resource) {
                switch (notification.getFeatureID(Resource.class)) {
                    case Resource.RESOURCE__URI: {
                        getSite().getShell().getDisplay().asyncExec(new Runnable() {

                            public void run() {
                                firePropertyChange(IEditorPart.PROP_DIRTY);
                            }

                        });
                        break;
                    }
                }
            } else {
                super.notifyChanged(notification);
            }
        }

        @Override
        protected void setTarget(Resource innerTarget) {
            basicSetTarget(innerTarget);
        }

        @Override
        protected void unsetTarget(Resource innerTarget) {
            basicUnsetTarget(innerTarget);
        }

    };

    // The current pattern adapter
    AdapterImpl patternAdapter = new AdapterImpl() {

        @Override
        public void notifyChanged(final Notification msg) {
            if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature())) {
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        // Title update and generated class refactoring if necessary
                        if (partName != null && partName.equals(msg.getNewValue()) == false) {
                            try {
                                ExtensionHelper.getExtension(pattern.getNature()).getRefactoringManager().renamePattern(pattern, partName, (String) msg.getNewValue());
                            } catch (Exception e) {
                                Activator.getDefault().logError(e);
                            }
                            partName = (String) msg.getNewValue();
                            setPartName(partName);
                        }
                    }

                });
            } else if (PatternPackage.Literals.PATTERN_ELEMENT__CONTAINER.equals(msg.getFeature()) && msg.getNewValue() == null) {
                // Removed Pattern
                // just close now without prompt
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        getSite().getPage().closeEditor(PatternEditor.this, false);
                    }

                });

            }
        }

    };

    public PatternEditor() {
        initializeEditingDomain();
    }

    public boolean userHasSavedResource() {
        return userHasSavedResource;
    }

    public boolean resourceHasBeenExternallyChanged() {
        return resourceHasBeenExternallyChanged;
    }

    /**
     * Handles activation of the editor or it's associated views.
     */
    protected void handleActivate() {
        if (resourceHasBeenRemoved) {
            if (handleDirtyConflict()) {
                getSite().getPage().closeEditor(PatternEditor.this, false);
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
     * This is for implementing {@link IEditorPart} and simply saves the model
     * file.
     */
    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        // Do the work within an operation because this is a long running
        // activity that modifies the
        // workbench.
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

            // This is the method that gets invoked when the operation runs.
            @Override
            public void execute(IProgressMonitor monitor) {
                try {
                    getEditingDomain().runExclusive(new Runnable() {

                        public void run() {
                            try {
                                Resource resourceToSave = getResource();
                                // Save the resource to the file system.
                                long timeStamp = resourceToSave.getTimeStamp();
                                resourceToSave.save(Collections.EMPTY_MAP);
                                if (resourceToSave.getTimeStamp() != timeStamp) {
                                    userHasSavedResource = true;
                                }
                            } catch (IOException ioe) {
                                ThrowableHandler.handleThrowable(Activator.getDefault().getPluginID(), ioe);
                            }
                        }

                    });
                } catch (Throwable t) {
                    ThrowableHandler.handleThrowable(Activator.getDefault().getPluginID(), t);
                }
            }

        };

        try {
            // This runs the options, and shows progress.
            new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);
            firePropertyChange(IEditorPart.PROP_DIRTY);
        } catch (Throwable t) {
            ThrowableHandler.handleThrowable(Activator.getDefault().getPluginID(), t);
        }
    }

    @Override
    public void doSaveAs() {
        throw new UnsupportedOperationException();
    }

    public IOperationHistory getOperationHistory() {
        return ((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory();
    }

    public ObjectUndoContext getUndoContext() {
        return undoContext;
    }

    /**
     * Add the Adapter add for refreshing the editor title
     */
    private void addPatternChangeAdapter() {
        if (pattern != null && pattern.eAdapters().contains(patternAdapter) == false) {
            pattern.eAdapters().add(patternAdapter);
        }
    }

    /**
     * Remove the Adapter add for refreshing the editor title
     */
    private void removePatternChangeAdapter() {
        if (pattern != null && pattern.eAdapters().contains(patternAdapter)) {
            pattern.eAdapters().remove(patternAdapter);
        }
    }

    /**
     * Gets the title tool tip text of this part.
     * 
     * @return the tool tip text
     * 
     */
    @Override
    public String getTitleToolTip() {
        if (getEditorInput() == null) {
            return super.getTitleToolTip();
        }
        return EGFCorePlugin.getPlatformURIConverter().normalize(getResource().getURI()).toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object getAdapter(Class key) {
        if (key.equals(IUndoContext.class)) {
            return undoContext;
        }
        return super.getAdapter(key);
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public boolean isDirty() {
        if (getResource() == null) {
            return false;
        }
        return getResource().isModified();
    }

    @Override
    protected void addPages() {
        try {
            addPage(new OverviewPage(this));
            addPage(new SpecificationPage(this));
            addPage(new ImplementationPage(this));
        } catch (PartInitException e) {
            Activator.getDefault().logError(e);
        }
    }

    public Resource getResource() {
        PatternEditorInput input = (PatternEditorInput) getEditorInput();
        if (input == null)
            throw new IllegalStateException();
        return input.getResource();
    }

    public TransactionalEditingDomain getEditingDomain() {
        return editingDomain;
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
        setSite(site);
        setInputWithNotify(editorInput);
        site.getPage().addPartListener(partListener);
        pattern = ((PatternEditorInput) getEditorInput()).getPattern();
        partName = pattern.getName();
        resourceHasBeenExternallyChanged = EGFResourceLoadedListener.getResourceManager().resourceHasBeenExternallyChanged(getResource());
        EGFResourceLoadedListener.getResourceManager().addObserver(this);
        // populate operation history if applicable
        EGFResourceLoadedListener.getResourceManager().populateUndoContext(getOperationHistory(), undoContext, getResource());
        addPatternChangeAdapter();
        setPartName(pattern.getName());
    }

    protected void initializeEditingDomain() {
        editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
        undoContext = new ObjectUndoContext(this, "undoContext label"); //$NON-NLS-1$
        getOperationHistory().addOperationHistoryListener(historyListener);
        editingDomain.getResourceSet().eAdapters().add(editorResourceAdapter);
    }

    @Override
    public void dispose() {
        // if init failed, dispose should not called this
        if (getEditorInput() != null && getEditorInput() instanceof PatternEditorInput) {
            getSite().getPage().removePartListener(partListener);
            removePatternChangeAdapter();
        }
        // Initialized in initializeEditingDomain, if init failed, this must be disposed
        EGFResourceLoadedListener.getResourceManager().removeObserver(this);
        getOperationHistory().removeOperationHistoryListener(historyListener);
        getOperationHistory().dispose(undoContext, true, true, true);
        editingDomain.getResourceSet().eAdapters().remove(editorResourceAdapter);
        super.dispose();
    }

    private final IOperationHistoryListener historyListener = new IOperationHistoryListener() {

        public void historyNotification(final OperationHistoryEvent event) {
            Set<Resource> affectedResources = ResourceUndoContext.getAffectedResources(event.getOperation());
            switch (event.getEventType()) {
                case OperationHistoryEvent.DONE:
                    if (affectedResources.contains(getResource())) {
                        final IUndoableOperation operation = event.getOperation();
                        // remove the default undo context so that we can have
                        // independent undo/redo of independent resource changes
                        operation.removeContext(((IWorkspaceCommandStack) getEditingDomain().getCommandStack()).getDefaultUndoContext());
                        // add our undo context to populate our undo menu
                        operation.addContext(undoContext);
                        getSite().getShell().getDisplay().asyncExec(new Runnable() {

                            public void run() {
                                firePropertyChange(IEditorPart.PROP_DIRTY);
                            }
                        });
                    }
                    break;
                case OperationHistoryEvent.UNDONE:
                case OperationHistoryEvent.REDONE:
                    if (affectedResources.contains(getResource())) {
                        getSite().getShell().getDisplay().asyncExec(new Runnable() {

                            public void run() {
                                firePropertyChange(IEditorPart.PROP_DIRTY);
                            }
                        });
                    }
                    break;
            }
        }

    };

    public void addPage(PatternEditorPage page) throws PartInitException {
        pages.add(page);
        addPage((IFormPage) page);
    }

    /**
     * Shows a dialog that asks if conflicting changes should be discarded.
     */
    protected boolean handleDirtyConflict() {
        return MessageDialog.openQuestion(getSite().getShell(), "File Conflict", //$NON-NLS-1$
                "External changes, close the editor ?"); //$NON-NLS-1$
    }

    public ResourceListener getListener() {
        return resourceListener;
    }

}
