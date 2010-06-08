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
package org.eclipse.egf.model.fcore.presentation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener.ResourceListener;
import org.eclipse.egf.core.domain.EGFResourceLoadedListener.ResourceUser;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.contributor.EditorListenerContributor;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.adapter.PatternBundleAdapter;
import org.eclipse.egf.model.editor.adapter.TaskBundleAdapter;
import org.eclipse.egf.model.editor.adapter.TypeClassBundleAdapter;
import org.eclipse.egf.model.editor.provider.FcoreContentProvider;
import org.eclipse.egf.model.editor.provider.FcorePropertySheetPage;
import org.eclipse.egf.model.fcore.provider.FcoreCustomItemProviderAdapterFactory;
import org.eclipse.egf.model.fcore.provider.FcoreResourceItemProviderAdapterFactory;
import org.eclipse.egf.model.fprod.provider.FprodCustomItemProviderAdapterFactory;
import org.eclipse.egf.model.pattern.provider.PatternCustomItemProviderAdapterFactory;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider.ViewerRefresh;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * This is an example of a Fcore model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class FcoreEditor extends MultiPageEditorPart implements ResourceUser, ResourceListener, IEditingDomainProvider, ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker {

    /**
     * This keeps track of the editing domain that is used to track all changes
     * to the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected AdapterFactoryEditingDomain editingDomain;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected ObjectUndoContext undoContext;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected Resource resource;

    /**
     * This is the one adapter factory used for providing views of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComposedAdapterFactory adapterFactory;

    /**
     * This is the one adapter factory used for properties.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected ComposedAdapterFactory propertyAdapterFactory;

    /**
     * This is the content outline page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IContentOutlinePage contentOutlinePage;

    /**
     * This is a kludge...
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IStatusLineManager contentOutlineStatusLineManager;

    /**
     * This is the content outline page's viewer.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TreeViewer contentOutlineViewer;

    /**
     * This is the property sheet page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PropertySheetPage propertySheetPage;

    /**
     * This is the viewer that shadows the selection in the content outline.
     * The parent relation must be correctly defined for this to work.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TreeViewer selectionViewer;

    /**
     * This keeps track of the active viewer pane
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ViewerPane currentViewerPane;

    /**
     * This keeps track of the active content viewer, which may be either one of the viewers in the pages or the content outline viewer.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Viewer currentViewer;

    /**
     * This listens to which ever viewer is active.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ISelectionChangedListener selectionChangedListener;

    /**
     * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that
     * are listening to this editor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

    /**
     * This keeps track of the selection of the editor as a whole.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ISelection editorSelection = StructuredSelection.EMPTY;

    /**
     * The MarkerHelper is responsible for creating workspace resource markers
     * presented
     * in Eclipse's Problems View.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MarkerHelper markerHelper = new EditUIMarkerHelper();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected ViewerRefresh viewerRefresh;

    /**
     * This listens for when the outline becomes active
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected IPartListener partListener = new IPartListener() {

        public void partActivated(IWorkbenchPart p) {
            if (p instanceof ContentOutline) {
                if (((ContentOutline) p).getCurrentPage() == contentOutlinePage) {
                    getActionBarContributor().setActiveEditor(FcoreEditor.this);
                    setCurrentViewer(contentOutlineViewer);
                }
            } else if (p instanceof PropertySheet) {
                if (((PropertySheet) p).getCurrentPage() == propertySheetPage) {
                    getActionBarContributor().setActiveEditor(FcoreEditor.this);
                    handleActivate();
                }
            } else if (p == FcoreEditor.this) {
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

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public ObjectUndoContext getUndoContext() {
        return undoContext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    private IOperationHistoryListener historyListener = new IOperationHistoryListener() {

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
                        operation.addContext(getUndoContext());
                        getSite().getShell().getDisplay().asyncExec(new Runnable() {

                            public void run() {
                                firePropertyChange(IEditorPart.PROP_DIRTY);
                                // Try to select the affected objects.
                                if (operation instanceof EMFCommandOperation) {
                                    Command command = ((EMFCommandOperation) operation).getCommand();
                                    if (command != null) {
                                        setSelectionToViewer(command.getAffectedObjects());
                                    }
                                }
                                if (propertySheetPage != null) {
                                    propertySheetPage.refresh();
                                }
                            }
                        });
                    }
                    break;
                case OperationHistoryEvent.UNDONE:
                case OperationHistoryEvent.REDONE:
                    if (affectedResources.contains(getResource())) {
                        final IUndoableOperation operation = event.getOperation();
                        getSite().getShell().getDisplay().asyncExec(new Runnable() {

                            public void run() {
                                firePropertyChange(IEditorPart.PROP_DIRTY);
                                // Try to select the affected objects.
                                if (operation instanceof EMFCommandOperation) {
                                    Command command = ((EMFCommandOperation) operation).getCommand();
                                    if (command != null) {
                                        setSelectionToViewer(command.getAffectedObjects());
                                    }
                                }
                                if (propertySheetPage != null) {
                                    propertySheetPage.refresh();
                                }
                            }
                        });
                    }
                    break;
            }
        }
    };

    /**
     * Whether or not this resource has been removed
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected boolean resourceHasBeenRemoved;

    /**
     * Whether or not this resource has been externally changed
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected boolean resourceHasBeenExternallyChanged;

    /**
     * Whether or not user saved this resource in this editor
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected boolean userHasSavedResource;

    /**
     * Map to store the diagnostic associated with a resource.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Map<URI, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<URI, Diagnostic>();

    /**
     * Controls whether the problem indication should be updated.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected boolean updateProblemIndication = true;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected List<EContentAdapter> egfAdapters = new UniqueEList<EContentAdapter>();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    private boolean tabFolderGuard = false;

    /**
     * Adapter used to update the problem indication when resources are demanded
     * loaded.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected EContentAdapter editorResourceAdapter = new EContentAdapter() {

        @Override
        public void notifyChanged(Notification notification) {
            // Process Resource
            if (notification.getNotifier() instanceof Resource) {
                switch (notification.getFeatureID(Resource.class)) {
                    case Resource.RESOURCE__IS_LOADED:
                    case Resource.RESOURCE__ERRORS:
                    case Resource.RESOURCE__WARNINGS: {
                        // Problem
                        final Resource innerResource = (Resource) notification.getNotifier();
                        if (innerResource == getResource() || ResourceHelper.hasURIProxyReferences(getResource(), innerResource.getURI())) {
                            Diagnostic diagnostic = ResourceHelper.analyzeResourceProblems(innerResource, null, EGFCorePlugin.FCORE_EDITOR_ID);
                            if (diagnostic.getSeverity() != Diagnostic.OK) {
                                resourceToDiagnosticMap.put(innerResource.getURI(), diagnostic);
                            } else {
                                resourceToDiagnosticMap.remove(innerResource.getURI());
                            }
                            // Try to refresh proxy owners
                            if (innerResource != getResource()) {
                                if (selectionViewer != null && selectionViewer.getControl() != null && selectionViewer.getControl().isDisposed() == false && selectionViewer.isBusy() == false) {
                                    final List<EObject> owners = ResourceHelper.getURIProxyReferenceOwners(getResource(), innerResource.getURI());
                                    if (owners != null && owners.isEmpty() == false) {
                                        if (viewerRefresh == null) {
                                            viewerRefresh = new ViewerRefresh(selectionViewer);
                                        }
                                        for (EObject eObject : owners) {
                                            Notification ownerNotification = new ENotificationImpl((InternalEObject) eObject, Notification.RESOLVE, null, eObject, eObject);
                                            viewerRefresh.addNotification(new ViewerNotification(ownerNotification, ownerNotification.getNotifier(), true, true));
                                        }
                                        selectionViewer.getControl().getDisplay().asyncExec(viewerRefresh);
                                    }
                                }
                            }
                            // Display any trouble
                            if (updateProblemIndication) {
                                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                                    public void run() {
                                        updateProblemIndication();
                                    }
                                });
                            }
                        }
                        break;
                    }
                    case Resource.RESOURCE__CONTENTS:
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

    /**
     * Handles activation of the editor or it's associated views.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void handleActivate() {
        setCurrentViewer(selectionViewer);
        // Recompute the read only state.
        if (editingDomain.getResourceToReadOnlyMap() != null) {
            editingDomain.getResourceToReadOnlyMap().clear();
            // Refresh any actions that may become enabled or disabled.
            setSelection(getSelection());
        }
        if (resourceHasBeenRemoved) {
            getSite().getShell().getDisplay().asyncExec(new Runnable() {

                public void run() {
                    if (isDirty() == false || handleDirtyConflict()) {
                        getSite().getPage().closeEditor(FcoreEditor.this, false);
                    }
                }
            });
        } else if (resourceHasBeenExternallyChanged) {
            handleChangedResource();
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void resourceMoved(Resource movedResource, final URI oldURI) {
        if (movedResource == getResource()) {
            resourceHasBeenExternallyChanged = false;
            resourceHasBeenRemoved = false;
            userHasSavedResource = false;
            getSite().getShell().getDisplay().asyncExec(new Runnable() {

                public void run() {
                    if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
                        setSelection(StructuredSelection.EMPTY);
                    }
                    Resource innerResource = getResource();
                    selectionViewer.setSelection(new StructuredSelection(innerResource), true);
                    if (currentViewerPane != null) {
                        currentViewerPane.setTitle(innerResource);
                    }
                    setPartName(innerResource.getURI().lastSegment());
                    setTitleToolTip(innerResource.toString());
                }
            });
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void resourceDeleted(Resource deletedResource) {
        // Handle current resource
        if (deletedResource == getResource()) {
            if (isDirty() == false) {
                // just close now without prompt
                getSite().getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        getSite().getPage().closeEditor(FcoreEditor.this, false);
                    }
                });
                return;
            }
            // Dirty editor with a deleted resource
            resourceHasBeenRemoved = true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void resourceReloaded(Resource reloadedResource) {
        if (reloadedResource == getResource()) {
            resourceHasBeenExternallyChanged = false;
            resourceHasBeenRemoved = false;
            userHasSavedResource = false;
            getSite().getShell().getDisplay().asyncExec(new Runnable() {

                public void run() {
                    if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
                        setSelection(StructuredSelection.EMPTY);
                    }
                    getOperationHistory().dispose(undoContext, true, true, true);
                    selectionViewer.setInput(getResource());
                    selectionViewer.setSelection(new StructuredSelection(getResource()), true);
                    currentViewerPane.setTitle(getResource());
                    updateProblemIndication = true;
                }
            });
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean userHasSavedResource() {
        return userHasSavedResource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean resourceHasBeenExternallyChanged() {
        return resourceHasBeenExternallyChanged;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void externalUpdate(Resource changedResource) {
        if (changedResource == getResource()) {
            resourceHasBeenExternallyChanged = true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void internalUpdate(Resource changedResource) {
        if (changedResource == getResource()) {
            resourceHasBeenExternallyChanged = false;
            resourceHasBeenRemoved = false;
            userHasSavedResource = false;
        }
        getSite().getShell().getDisplay().asyncExec(new Runnable() {

            public void run() {
                firePropertyChange(IEditorPart.PROP_DIRTY);
            }
        });
    }

    /**
     * Handles what to do with changed resource on activation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void handleChangedResource() {
        if (isDirty() == false || handleDirtyConflict()) {
            EGFResourceLoadedListener.getResourceManager().reloadResource(getResource());
        }
    }

    /**
     * Updates the problems indication with the information described in the
     * specified diagnostic.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void updateProblemIndication() {
        if (updateProblemIndication) {
            BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, EGFCorePlugin.FCORE_EDITOR_ID, 0, null, new Object[] {
                getResource()
            });
            for (URI uri : resourceToDiagnosticMap.keySet()) {
                Diagnostic childDiagnostic = resourceToDiagnosticMap.get(uri);
                if (childDiagnostic.getSeverity() != Diagnostic.OK) {
                    diagnostic.add(childDiagnostic);
                }
            }
            int lastEditorPage = getPageCount() - 1;
            if (lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart) {
                ((ProblemEditorPart) getEditor(lastEditorPage)).setDiagnostic(diagnostic);
                if (diagnostic.getSeverity() != Diagnostic.OK) {
                    setActivePage(lastEditorPage);
                } else {
                    removePage(lastEditorPage);
                    setActivePage(0);
                    if (tabFolderGuard == false) {
                        tabFolderGuard = true;
                        hideTabs();
                        tabFolderGuard = false;
                    }
                }
            } else if (diagnostic.getSeverity() != Diagnostic.OK) {
                ProblemEditorPart problemEditorPart = new ProblemEditorPart();
                problemEditorPart.setDiagnostic(diagnostic);
                problemEditorPart.setMarkerHelper(markerHelper);
                try {
                    addPage(++lastEditorPage, problemEditorPart, getEditorInput());
                    setPageText(lastEditorPage, problemEditorPart.getPartName());
                    setActivePage(lastEditorPage);
                    showTabs();
                } catch (PartInitException exception) {
                    EGFModelEditorPlugin.INSTANCE.log(exception);
                }
            }
            if (markerHelper.hasMarkers(getResource())) {
                markerHelper.deleteMarkers(getResource());
                if (diagnostic.getSeverity() != Diagnostic.OK) {
                    try {
                        markerHelper.createMarkers(diagnostic);
                    } catch (CoreException exception) {
                        EGFModelEditorPlugin.INSTANCE.log(exception);
                    }
                }
            }

        }
    }

    /**
     * Shows a dialog that asks if conflicting changes should be discarded.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected boolean handleDirtyConflict() {
        return MessageDialog.openQuestion(getSite().getShell(), getString("_UI_FileConflict_label"), //$NON-NLS-1$
                getString("_WARN_FileConflict")); //$NON-NLS-1$
    }

    /**
     * This creates a model editor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public FcoreEditor() {
        super();
        initializeEditingDomain();
    }

    /**
     * This sets up the editing domain for the model editor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void initializeEditingDomain() {
        // Create an adapter factory that yields item providers.
        adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        adapterFactory.addAdapterFactory(new FcoreResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        // Create an adapter factory that yields item providers for properties.
        propertyAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        propertyAdapterFactory.addAdapterFactory(new FcoreResourceItemProviderAdapterFactory());
        propertyAdapterFactory.addAdapterFactory(new FprodCustomItemProviderAdapterFactory());
        propertyAdapterFactory.addAdapterFactory(new FcoreCustomItemProviderAdapterFactory());
        propertyAdapterFactory.addAdapterFactory(new PatternCustomItemProviderAdapterFactory());
        propertyAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        // Get the registered TransactionalEditingDomain
        editingDomain = (AdapterFactoryEditingDomain) TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
        // Create an UndoContext
        undoContext = new ObjectUndoContext(this, EGFModelEditorPlugin.getPlugin().getString("_UI_FcoreEditor_label")); //$NON-NLS-1$
        // add an history listener
        getOperationHistory().addOperationHistoryListener(historyListener);
    }

    /**
     * This is here for the listener to be able to call it.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void firePropertyChange(int action) {
        super.firePropertyChange(action);
    }

    /**
     * This sets the selection into whichever viewer is active.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void setSelectionToViewer(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        final Collection<EObject> theSelection = new UniqueEList<EObject>(collection.size());
        // Solve EObject against our resource set
        for (Object object : collection) {
            if (object instanceof EObject == false) {
                continue;
            }
            URI uri = null;
            try {
                uri = EcoreUtil.getURI((EObject) object);
                if (uri != null && uri.isEmpty() == false) {
                    EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
                    if (eObject != null) {
                        theSelection.add(eObject);
                    }
                }
            } catch (Throwable t) {
                EGFModelEditorPlugin.getPlugin().logError(object.toString(), t);
            }
        }
        Runnable runnable = new Runnable() {

            public void run() {
                // Try to select the items in the current content viewer of the editor.
                if (currentViewer != null) {
                    currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
                }
            }
        };
        getSite().getShell().getDisplay().asyncExec(runnable);
    }

    /**
     * This returns the editing domain as required by the {@link IEditingDomainProvider} interface.
     * This is important for implementing the static methods of {@link AdapterFactoryEditingDomain} and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public TransactionalEditingDomain getEditingDomain() {
        return (TransactionalEditingDomain) editingDomain;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public class ReverseAdapterFactoryContentProvider extends TransactionalAdapterFactoryContentProvider {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated NOT
         */
        public ReverseAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
            super(getEditingDomain(), adapterFactory);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        public Object[] getElements(Object object) {
            Object parent = super.getParent(object);
            return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        public Object[] getChildren(Object object) {
            Object parent = super.getParent(object);
            return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        public boolean hasChildren(Object object) {
            Object parent = super.getParent(object);
            return parent != null;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        public Object getParent(Object object) {
            return null;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setCurrentViewerPane(ViewerPane viewerPane) {
        if (currentViewerPane != viewerPane) {
            if (currentViewerPane != null) {
                currentViewerPane.showFocus(false);
            }
            currentViewerPane = viewerPane;
        }
        setCurrentViewer(currentViewerPane.getViewer());
    }

    /**
     * This makes sure that one content viewer, either for the current page or
     * the outline view, if it
     * has focus,
     * is the current one.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setCurrentViewer(Viewer viewer) {
        // If it is changing...
        //
        if (currentViewer != viewer) {
            if (selectionChangedListener == null) {
                // Create the listener on demand.
                //
                selectionChangedListener = new ISelectionChangedListener() {

                    // This just notifies those things that are affected by the
                    // section.
                    //
                    public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
                        setSelection(selectionChangedEvent.getSelection());
                    }
                };
            }

            // Stop listening to the old one.
            //
            if (currentViewer != null) {
                currentViewer.removeSelectionChangedListener(selectionChangedListener);
            }

            // Start listening to the new one.
            //
            if (viewer != null) {
                viewer.addSelectionChangedListener(selectionChangedListener);
            }

            // Remember it.
            //
            currentViewer = viewer;

            // Set the editors selection based on the current viewer's
            // selection.
            //
            setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
        }
    }

    /**
     * This returns the viewer as required by the {@link IViewerProvider} interface.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Viewer getViewer() {
        return currentViewer;
    }

    /**
     * This creates a context menu for the viewer and adds a listener as well
     * registering the menu for
     * extension.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void createContextMenuFor(StructuredViewer viewer) {
        MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
        contextMenu.add(new Separator("additions")); //$NON-NLS-1$
        contextMenu.setRemoveAllWhenShown(true);
        contextMenu.addMenuListener(this);
        Menu menu = contextMenu.createContextMenu(viewer.getControl());
        viewer.getControl().setMenu(menu);
        getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

        int dndOperations = DND.DROP_COPY | DND.DROP_MOVE;
        Transfer[] transfers = new Transfer[] {
            LocalTransfer.getInstance()
        };
        viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
        viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(getEditingDomain(), viewer));
    }

    /**
     * This is the method called to load a resource into the editing domain's
     * resource set based on the editor's input.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void createModel() {
        URI uri = EditorHelper.getURI(getEditorInput());
        Exception exception = null;
        resource = null;
        try {
            // Load the resource through the editing domain.
            //
            resource = editingDomain.getResourceSet().getResource(uri, true);
        } catch (Exception e) {
            exception = e;
            resource = editingDomain.getResourceSet().getResource(uri, false);
        }
        resourceHasBeenExternallyChanged = EGFResourceLoadedListener.getResourceManager().resourceHasBeenExternallyChanged(resource);
        Diagnostic diagnostic = ResourceHelper.analyzeResourceProblems(resource, exception, EGFCorePlugin.FCORE_EDITOR_ID);
        if (diagnostic.getSeverity() != Diagnostic.OK) {
            resourceToDiagnosticMap.put(resource.getURI(), diagnostic);
        }
        editingDomain.getResourceSet().eAdapters().add(editorResourceAdapter);
        egfAdapters.add(new PatternBundleAdapter(resource, getSite()));
        egfAdapters.add(new TaskBundleAdapter(resource, getSite()));
        egfAdapters.add(new TypeClassBundleAdapter(resource, getSite()));
        getEditingDomain().getResourceSet().eAdapters().addAll(egfAdapters);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public ResourceListener getListener() {
        return this;
    }

    /**
     * Obtains the single resource that I edit.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * This is the method used by the framework to install your own controls.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void createPages() {

        // Only creates the other pages if there is something that can be edited
        if (getResource() != null) {

            ViewerPane viewerPane = new ViewerPane(getSite().getPage(), FcoreEditor.this) {

                @Override
                public Viewer createViewer(Composite composite) {
                    Tree tree = new Tree(composite, SWT.MULTI);
                    TreeViewer newTreeViewer = new TreeViewer(tree);
                    return newTreeViewer;
                }

                @Override
                public void requestActivation() {
                    super.requestActivation();
                    setCurrentViewerPane(this);
                }
            };
            viewerPane.createControl(getContainer());

            // Create a page for the selection tree view.
            selectionViewer = (TreeViewer) viewerPane.getViewer();

            selectionViewer.setContentProvider(new FcoreContentProvider(getEditingDomain(), adapterFactory));
            selectionViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(getEditingDomain(), adapterFactory));

            selectionViewer.setInput(getResource());
            selectionViewer.setSelection(new StructuredSelection(getResource()), true);
            viewerPane.setTitle(getResource());

            new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

            createContextMenuFor(selectionViewer);
            for (EditorListenerContributor contributor : EGFCoreUIPlugin.getEditorListenerContributors()) {
                contributor.addListener(getEditorSite().getPage(), selectionViewer);
            }
            int pageIndex = addPage(viewerPane.getControl());
            setPageText(pageIndex, getString("_UI_SelectionPage_label")); //$NON-NLS-1$

        }

        // Ensures that this editor will only display the page's tab
        // area if there are more than one page
        getContainer().addControlListener(new ControlAdapter() {

            @Override
            public void controlResized(ControlEvent event) {
                if (tabFolderGuard == false) {
                    tabFolderGuard = true;
                    hideTabs();
                    tabFolderGuard = false;
                }
            }
        });

        getSite().getShell().getDisplay().asyncExec(new Runnable() {

            public void run() {
                updateProblemIndication();
            }
        });

    }

    /**
     * If there is just one page in the multi-page editor part,
     * this hides the single tab at the bottom.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void hideTabs() {
        if (getPageCount() <= 1) {
            setPageText(0, ""); //$NON-NLS-1$
            if (getContainer() instanceof CTabFolder) {
                ((CTabFolder) getContainer()).setTabHeight(1);
                Point point = getContainer().getSize();
                getContainer().setSize(point.x, point.y + 6);
            }
        }
    }

    /**
     * If there is more than one page in the multi-page editor part,
     * this shows the tabs at the bottom.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void showTabs() {
        if (getPageCount() > 1) {
            setPageText(0, getString("_UI_SelectionPage_label")); //$NON-NLS-1$
            if (getContainer() instanceof CTabFolder) {
                ((CTabFolder) getContainer()).setTabHeight(SWT.DEFAULT);
                Point point = getContainer().getSize();
                getContainer().setSize(point.x, point.y - 6);
            }
        }
    }

    /**
     * This is used to track the active viewer.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void pageChange(int pageIndex) {
        super.pageChange(pageIndex);
        if (contentOutlinePage != null) {
            handleContentOutlineSelection(contentOutlinePage.getSelection());
        }
    }

    /**
     * This is how the framework determines which interfaces we implement.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getAdapter(Class key) {
        if (key.equals(IContentOutlinePage.class)) {
            return showOutlineView() ? getContentOutlinePage() : null;
        } else if (key.equals(IPropertySheetPage.class)) {
            return getPropertySheetPage();
        } else if (key.equals(IGotoMarker.class)) {
            return this;
        } else if (key.equals(IUndoContext.class)) {
            return undoContext;
        } else {
            return super.getAdapter(key);
        }
    }

    /**
     * This accesses a cached version of the content outliner.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public IContentOutlinePage getContentOutlinePage() {
        if (contentOutlinePage == null) {
            // The content outline is just a tree.
            class MyContentOutlinePage extends ContentOutlinePage {

                @Override
                public void createControl(Composite parent) {
                    super.createControl(parent);
                    contentOutlineViewer = getTreeViewer();
                    contentOutlineViewer.addSelectionChangedListener(this);

                    // Set up the tree viewer.
                    contentOutlineViewer.setContentProvider(new FcoreContentProvider(getEditingDomain(), adapterFactory));
                    contentOutlineViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(getEditingDomain(), adapterFactory));
                    contentOutlineViewer.setInput(getResource());

                    // Make sure our popups work.
                    createContextMenuFor(contentOutlineViewer);

                    if (editingDomain.getResourceSet().getResources().isEmpty() == false) {
                        // Select the root object in the view.
                        ArrayList<Object> selection = new ArrayList<Object>();
                        selection.add(getResource());
                        contentOutlineViewer.setSelection(new StructuredSelection(selection), true);
                    }
                }

                @Override
                public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
                    super.makeContributions(menuManager, toolBarManager, statusLineManager);
                    contentOutlineStatusLineManager = statusLineManager;
                }

                @Override
                public void setActionBars(IActionBars actionBars) {
                    super.setActionBars(actionBars);
                    getActionBarContributor().shareGlobalActions(this, actionBars);
                }
            }

            contentOutlinePage = new MyContentOutlinePage();

            // Listen to selection so that we can handle it is a special way.
            //
            contentOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {

                // This ensures that we handle selections correctly.
                //
                public void selectionChanged(SelectionChangedEvent event) {
                    handleContentOutlineSelection(event.getSelection());
                }
            });
        }

        return contentOutlinePage;
    }

    /**
     * This accesses a cached version of the property sheet.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public IPropertySheetPage getPropertySheetPage() {
        if (propertySheetPage == null) {
            propertySheetPage = new FcorePropertySheetPage((AdapterFactoryEditingDomain) getEditingDomain()) {

                @Override
                public void setSelectionToViewer(List<?> selection) {
                    FcoreEditor.this.setSelectionToViewer(selection);
                    FcoreEditor.this.setFocus();
                }

                @Override
                public void setActionBars(IActionBars actionBars) {
                    super.setActionBars(actionBars);
                    getActionBarContributor().shareGlobalActions(this, actionBars);
                }

                @Override
                public void dispose() {
                    super.dispose();
                    propertySheetPage = null;
                }
            };
            propertySheetPage.setPropertySourceProvider(new FcoreContentProvider(getEditingDomain(), propertyAdapterFactory));
        }

        return propertySheetPage;
    }

    /**
     * This deals with how we want selection in the outliner to affect the other
     * views.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void handleContentOutlineSelection(ISelection selection) {
        if (selectionViewer != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
            Iterator<?> selectedElements = ((IStructuredSelection) selection).iterator();
            if (selectedElements.hasNext()) {
                // Get the first selected element.
                //
                Object selectedElement = selectedElements.next();

                ArrayList<Object> selectionList = new ArrayList<Object>();
                selectionList.add(selectedElement);
                while (selectedElements.hasNext()) {
                    selectionList.add(selectedElements.next());
                }

                // Set the selection to the widget.
                //
                selectionViewer.setSelection(new StructuredSelection(selectionList));
            }
        }
    }

    /**
     * This is for implementing {@link IEditorPart} and simply tests the command stack.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public boolean isDirty() {
        if (getResource() == null) {
            return false;
        }
        return getResource().isModified();
    }

    /**
     * This is for implementing {@link IEditorPart} and simply saves the model
     * file.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
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
                            Resource resourceToSave = getResource();
                            try {
                                // Save the resource to the file system.
                                long timeStamp = resourceToSave.getTimeStamp();
                                resourceToSave.save(Collections.EMPTY_MAP);
                                if (resourceToSave.getTimeStamp() != timeStamp) {
                                    userHasSavedResource = true;
                                }
                            } catch (Exception exception) {
                                resourceToDiagnosticMap.put(resource.getURI(), ResourceHelper.analyzeResourceProblems(resource, exception, EGFCorePlugin.FCORE_EDITOR_ID));
                            }
                        }
                    });
                } catch (Throwable t) {
                    ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), t);
                }
            }
        };

        updateProblemIndication = false;
        try {
            // This runs the options, and shows progress.
            new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);
            firePropertyChange(IEditorPart.PROP_DIRTY);
        } catch (Throwable t) {
            ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), t);
        }
        updateProblemIndication = true;
        updateProblemIndication();
    }

    /**
     * This returns whether something has been persisted to the URI of the
     * specified resource.
     * The implementation uses the URI converter from the editor's resource set
     * to try to open an
     * input stream.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected boolean isPersisted(Resource innerResource) {
        boolean result = false;
        try {
            InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(innerResource.getURI());
            if (stream != null) {
                result = true;
                stream.close();
            }
        } catch (IOException e) {
            // Ignore
        }
        return result;
    }

    /**
     * This always returns true because it is not currently supported.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

    /**
     * This also changes the editor's input.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void doSaveAs() {
        SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
        saveAsDialog.open();
        IPath path = saveAsDialog.getResult();
        if (path != null) {
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
            if (file != null) {
                doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void doSaveAs(final URI uri, final IEditorInput editorInput) {
        // changing the URI is, conceptually, a write operation. However, it does
        // not affect the abstract state of the model, so we only need exclusive
        // (read) access
        try {
            getEditingDomain().runExclusive(new Runnable() {

                public void run() {
                    getResource().setURI(uri);
                    setInputWithNotify(editorInput);
                    setPartName(editorInput.getName());
                }
            });
        } catch (InterruptedException ie) {
            // just log it
            EGFModelEditorPlugin.getPlugin().logError(ie);
            // don't follow through with the save because we were interrupted while
            // trying to start the transaction, so our URI is not actually changed
            return;
        }

        IProgressMonitor progressMonitor = getActionBars().getStatusLineManager() != null ? getActionBars().getStatusLineManager().getProgressMonitor() : new NullProgressMonitor();
        doSave(progressMonitor);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void gotoMarker(IMarker marker) {
        try {
            if (marker.getType().equals(EValidator.MARKER)) {
                final String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
                if (uriAttribute != null) {
                    try {
                        getEditingDomain().runExclusive(new Runnable() {

                            public void run() {
                                URI uri = URI.createURI(uriAttribute);
                                EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
                                if (eObject != null) {
                                    setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
                                }
                            }
                        });
                    } catch (InterruptedException ie) {
                        // just log it
                        EGFModelEditorPlugin.getPlugin().logError(ie);
                    }
                }
            }
        } catch (CoreException ce) {
            EGFModelEditorPlugin.getPlugin().logError(ce);
        }
    }

    /**
     * This is called during startup.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void init(IEditorSite site, IEditorInput editorInput) {
        setSite(site);
        setInputWithNotify(editorInput);
        setPartName(editorInput.getName());
        site.setSelectionProvider(this);
        site.getPage().addPartListener(partListener);
        createModel();
        EGFResourceLoadedListener.getResourceManager().addObserver(this);
        // populate operation history if applicable
        EGFResourceLoadedListener.getResourceManager().populateUndoContext(getOperationHistory(), undoContext, getResource());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setFocus() {
        selectionViewer.getControl().setFocus();
    }

    /**
     * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        selectionChangedListeners.add(listener);
    }

    /**
     * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        selectionChangedListeners.remove(listener);
    }

    /**
     * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to
     * return this editor's
     * overall selection.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ISelection getSelection() {
        return editorSelection;
    }

    /**
     * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to
     * set this editor's
     * overall selection.
     * Calling this result will notify the listeners.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSelection(ISelection selection) {
        editorSelection = selection;

        for (ISelectionChangedListener listener : selectionChangedListeners) {
            listener.selectionChanged(new SelectionChangedEvent(this, selection));
        }
        setStatusLineManager(selection);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setStatusLineManager(ISelection selection) {
        IStatusLineManager statusLineManager = currentViewer != null && currentViewer == contentOutlineViewer ? contentOutlineStatusLineManager : getActionBars().getStatusLineManager();

        if (statusLineManager != null) {
            if (selection instanceof IStructuredSelection) {
                Collection<?> collection = ((IStructuredSelection) selection).toList();
                switch (collection.size()) {
                    case 0: {
                        statusLineManager.setMessage(getString("_UI_NoObjectSelected")); //$NON-NLS-1$
                        break;
                    }
                    case 1: {
                        String text = new AdapterFactoryItemDelegator(adapterFactory).getText(collection.iterator().next());
                        statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text)); //$NON-NLS-1$
                        break;
                    }
                    default: {
                        statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size()))); //$NON-NLS-1$
                        break;
                    }
                }
            } else {
                statusLineManager.setMessage(""); //$NON-NLS-1$
            }
        }
    }

    /**
     * This looks up a string in the plugin's plugin.properties file.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private static String getString(String key) {
        return EGFModelEditorPlugin.INSTANCE.getString(key);
    }

    /**
     * This looks up a string in plugin.properties, making a substitution.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private static String getString(String key, Object s1) {
        return EGFModelEditorPlugin.INSTANCE.getString(key, new Object[] {
            s1
        });
    }

    /**
     * This implements {@link org.eclipse.jface.action.IMenuListener} to help
     * fill the context menus
     * with contributions from the Edit menu.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void menuAboutToShow(IMenuManager menuManager) {
        ((IMenuListener) getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditingDomainActionBarContributor getActionBarContributor() {
        return (EditingDomainActionBarContributor) getEditorSite().getActionBarContributor();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public IActionBars getActionBars() {
        return getActionBarContributor().getActionBars();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public AdapterFactory getAdapterFactory() {
        return adapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public IOperationHistory getOperationHistory() {
        return ((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void dispose() {

        // No more problem feedback
        updateProblemIndication = false;

        // Remove contribution
        for (EditorListenerContributor contributor : EGFCoreUIPlugin.getEditorListenerContributors()) {
            contributor.removeListener(selectionViewer);
        }

        // We have operation history stuff to clean up
        getOperationHistory().removeOperationHistoryListener(historyListener);
        getOperationHistory().dispose(getUndoContext(), true, true, true);

        // Remove observer
        EGFResourceLoadedListener.getResourceManager().removeObserver(this);

        // Remove our adapters
        editingDomain.getResourceSet().eAdapters().remove(editorResourceAdapter);
        for (EContentAdapter adapter : egfAdapters) {
            editingDomain.getResourceSet().eAdapters().remove(adapter);
        }

        // Remove our listeners
        getSite().getPage().removePartListener(partListener);

        // Dispose
        adapterFactory.dispose();
        if (getActionBarContributor().getActiveEditor() == this) {
            getActionBarContributor().setActiveEditor(null);
        }
        if (propertySheetPage != null) {
            propertySheetPage.dispose();
        }
        if (contentOutlinePage != null) {
            contentOutlinePage.dispose();
        }

        super.dispose();

    }

    /**
     * Returns whether the outline view should be presented to the user.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected boolean showOutlineView() {
        return true;
    }
}
