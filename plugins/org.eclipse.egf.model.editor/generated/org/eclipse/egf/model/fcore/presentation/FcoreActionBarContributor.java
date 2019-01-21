/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fcore.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.core.platform.loader.IBundleClassLoader;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.core.ui.contributor.IMenuEditorActionBarContributor;
import org.eclipse.egf.core.ui.diagnostic.EGFDiagnosticDialog;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.actions.FcoreResourcePasteAction;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.workspace.ui.actions.RedoActionWrapper;
import org.eclipse.emf.workspace.ui.actions.UndoActionWrapper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

/**
 * This is the action bar contributor for the Fcore model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class FcoreActionBarContributor extends EditingDomainActionBarContributor implements ISelectionChangedListener, IMenuEditorActionBarContributor {

    /**
     * This keeps track of menu contributions
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    private final List<EditorMenuContributor> menuContributors = new ArrayList<EditorMenuContributor>();

    /**
     * This keeps track of the active editor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IEditorPart activeEditorPart;

    /**
     * This keeps track of the current selection provider.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ISelectionProvider selectionProvider;

    /**
     * This action opens the Properties view.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IAction showPropertiesViewAction = new Action(EGFModelEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) { //$NON-NLS-1$

        @Override
        public void run() {
            try {
                getPage().showView("org.eclipse.ui.views.PropertySheet"); //$NON-NLS-1$
            } catch (PartInitException exception) {
                EGFModelEditorPlugin.INSTANCE.log(exception);
            }
        }

    };

    /**
     * This action refreshes the viewer of the current editor if the editor
     * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IAction refreshViewerAction = new Action(EGFModelEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) { //$NON-NLS-1$ 

        @Override
        public boolean isEnabled() {
            return activeEditorPart instanceof IViewerProvider;
        }

        @Override
        public void run() {
            if (activeEditorPart instanceof IViewerProvider) {
                Viewer viewer = ((IViewerProvider) activeEditorPart).getViewer();
                if (viewer != null) {
                    viewer.refresh();
                }
            }
        }

    };

    /**
     * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to
     * each descriptor
     * generated for the current selection by the item provider.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<IAction> createChildActions;

    /**
     * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding
     * to each descriptor
     * generated for the current selection by the item provider.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<IAction> createSiblingActions;

    /**
     * This creates an instance of the contributor.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public FcoreActionBarContributor() {

        super(ADDITIONS_LAST_STYLE);

        // Create menu contribution
        menuContributors.addAll(EGFCoreUIPlugin.createEditorMenuContributors(this));

        // Create a customized validate action
        validateAction = new ValidateAction() {

            private Resource currentResource;

            /**
             * This simply execute the command.
             */
            @Override
            protected Diagnostic validate(IProgressMonitor progressMonitor) {

                // Nothing to process
                if (selectedObjects == null || selectedObjects.size() == 0) {
                    return Diagnostic.OK_INSTANCE;
                }

                // In our application, only one resource is edited per editor
                // it is safe to get the resource from the first selectedObject
                currentResource = selectedObjects.get(0).eResource();

                int selectionSize = selectedObjects.size();
                int count = selectionSize;
                for (EObject eObject : selectedObjects) {
                    for (Iterator<?> i = eObject.eAllContents(); i.hasNext(); i.next()) {
                        ++count;
                    }
                }

                progressMonitor.beginTask("", count); //$NON-NLS-1$

                AdapterFactory adapterFactory = domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain) domain).getAdapterFactory() : null;
                Diagnostician diagnostician = createDiagnostician(adapterFactory, progressMonitor);

                BasicDiagnostic diagnostic;
                if (selectionSize == 1) {
                    diagnostic = diagnostician.createDefaultDiagnostic(selectedObjects.get(0));
                } else {
                    diagnostic = new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0, EMFEditUIPlugin.INSTANCE.getString("_UI_DiagnosisOfNObjects_message", new String[] { Integer.toString(selectionSize)}), //$NON-NLS-1$
                            selectedObjects.toArray());
                }
                Map<Object, Object> context = diagnostician.createDefaultContext();
                // Preferences
                IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
                if (store.getBoolean(IEGFModelConstants.VALIDATE_TYPES)) {
                    context.put(IEGFModelConstants.VALIDATE_TYPES, Boolean.TRUE);
                } else {
                    context.put(IEGFModelConstants.VALIDATE_TYPES, Boolean.FALSE);
                }
                // Bundle Class Loader Map
                context.put(IBundleClassLoader.BUNDLE_CLASS_LOADER_MAP, new HashMap<IPluginModelBase, IBundleClassLoader>());
                // Validation
                for (EObject eObject : selectedObjects) {
                    progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object[] { diagnostician.getObjectLabel(eObject)})); //$NON-NLS-1$
                    diagnostician.validate(eObject, diagnostic, context);
                }
                return diagnostic;

            }

            @Override
            protected void handleDiagnostic(Diagnostic diagnostic) {
                int severity = diagnostic.getSeverity();
                String title = null;
                String message = null;
                if (severity == Diagnostic.ERROR || severity == Diagnostic.WARNING) {
                    title = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_title"); //$NON-NLS-1$
                    message = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_message"); //$NON-NLS-1$
                } else {
                    title = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationResults_title"); //$NON-NLS-1$
                    message = EMFEditUIPlugin.INSTANCE.getString(severity == Diagnostic.OK ? "_UI_ValidationOK_message" : "_UI_ValidationResults_message"); //$NON-NLS-1$ //$NON-NLS-2$
                }
                // Reset existing Markers
                if (currentResource != null) {
                    eclipseResourcesUtil.deleteMarkers(currentResource);
                }
                // Display that everything is fine
                if (diagnostic.getSeverity() == Diagnostic.OK) {
                    MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), title, message);
                    return;
                }
                // Display Dialog
                int result = 0;
                EGFDiagnosticDialog dialog = new EGFDiagnosticDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), title, message, diagnostic, Diagnostic.OK | Diagnostic.INFO | Diagnostic.WARNING | Diagnostic.ERROR);
                result = dialog.open();
                // Dialog has been canceled
                if (result != Window.OK) {
                    return;
                }
                // Nothing to select
                if (dialog.getSelection() != null && dialog.getSelection().isEmpty() == false) {
                    // Select and reveal
                    Map<Resource, List<EObject>> resources = new HashMap<Resource, List<EObject>>();
                    // Try to select and reveal selected Diagnostics
                    for (Diagnostic innerDiagnostic : dialog.getSelection()) {
                        List<?> data = innerDiagnostic.getData();
                        if (data.isEmpty() == false && data.get(0) instanceof EObject && ((EObject) data.get(0)).eResource() != null) {
                            EObject eObject = (EObject) data.get(0);
                            List<EObject> eObjects = resources.get(eObject.eResource());
                            if (eObjects == null) {
                                eObjects = new UniqueEList<EObject>();
                                resources.put(eObject.eResource(), eObjects);
                            }
                            eObjects.add(eObject);
                        }
                    }
                    // Open and select
                    EditorHelper.openEditorsAndSelect(resources);
                }
                // Display markers
                if (currentResource != null) {
                    for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
                        eclipseResourcesUtil.createMarkers(currentResource, childDiagnostic);
                    }
                }
            }

        };

        // Create a default ControlAction
        controlAction = new ControlAction();

    }

    /**
     * Remove a list of menu contributions
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void removeEditorMenuContributors(List<EditorMenuContributor> menus) {
        if (menus == null || menus.isEmpty()) {
            return;
        }
        for (EditorMenuContributor menu : menus) {
            menuContributors.remove(menu);
        }
    }

    /**
     * This adds Separators for editor additions to the tool bar.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        // Do nothing
    }

    /**
     * This adds to the menu bar a menu and some separators for editor
     * additions,
     * as well as the sub-menus for object creation items.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void contributeToMenu(IMenuManager menuManager) {
        // Do nothing
    }

    /**
     * When the active editor changes, this remembers the change and registers
     * with it as a selection
     * provider.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setActiveEditor(IEditorPart part) {

        super.setActiveEditor(part);

        activeEditorPart = part;

        // Switch to the new selection provider.
        if (selectionProvider != null) {
            selectionProvider.removeSelectionChangedListener(this);
        }
        if (part == null) {
            selectionProvider = null;
        } else {
            selectionProvider = part.getSite().getSelectionProvider();
            selectionProvider.addSelectionChangedListener(this);
            // Fake a selection changed event to update the menus.
            if (selectionProvider.getSelection() != null) {
                selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
            }
        }

        // activate menu contribution
        for (EditorMenuContributor vpc : menuContributors) {
            vpc.setActiveEditor(part);
        }

    }

    /**
     * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
     * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by
     * querying for the children
     * and siblings
     * that can be added to the selected object and updating the menus
     * accordingly.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void selectionChanged(SelectionChangedEvent event) {

        // Query the new selection for appropriate new child/sibling descriptors
        Collection<?> newChildDescriptors = null;
        Collection<?> newSiblingDescriptors = null;

        ISelection selection = event.getSelection();
        if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
            Object object = ((IStructuredSelection) selection).getFirstElement();
            EditingDomain domain = ((IEditingDomainProvider) activeEditorPart).getEditingDomain();
            newChildDescriptors = domain.getNewChildDescriptors(object, null);
            newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
        }

        // Generate actions for selection; populate and redraw the menus.
        createChildActions = generateCreateChildActions(newChildDescriptors, selection);
        createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);

        // Update selection in menu contributions
        for (EditorMenuContributor vpc : menuContributors) {
            vpc.selectionChanged(event);
        }

    }

    /**
     * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>,
     * and returns the collection of these actions.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection) {
        Collection<IAction> actions = new ArrayList<IAction>();
        if (descriptors != null) {
            for (Object descriptor : descriptors) {
                actions.add(new CreateChildAction(activeEditorPart, selection, descriptor));
            }
        }
        return actions;
    }

    /**
     * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each
     * object in <code>descriptors</code>,
     * and returns the collection of these actions.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection) {
        Collection<IAction> actions = new ArrayList<IAction>();
        if (descriptors != null) {
            for (Object descriptor : descriptors) {
                actions.add(new CreateSiblingAction(activeEditorPart, selection, descriptor));
            }
        }
        return actions;
    }

    /**
     * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s
     * based on the {@link org.eclipse.jface.action.IAction}s contained in the
     * <code>actions</code> collection,
     * by inserting them before the specified contribution item
     * <code>contributionID</code>.
     * If <code>contributionID</code> is <code>null</code>, they are simply
     * added.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void populateManager(IContributionManager manager, Collection<? extends IAction> actions, String contributionID) {
        if (actions != null) {
            for (IAction action : actions) {
                if (contributionID != null) {
                    manager.insertBefore(contributionID, action);
                } else {
                    manager.add(action);
                }
            }
        }
    }

    /**
     * This populates the pop-up menu before it appears.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void menuAboutToShow(IMenuManager menuManager) {

        super.menuAboutToShow(menuManager);

        menuManager.add(new Separator("settings")); //$NON-NLS-1$
        menuManager.insertAfter(EGFCommonUIConstants.EDIT_MENU_GROUP, new Separator(EGFCommonUIConstants.OPEN_MENU_GROUP));
        MenuManager submenuManager = null;

        submenuManager = new MenuManager(EGFModelEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"), EGFCommonUIConstants.CREATE_CHILD); //$NON-NLS-1$
        populateManager(submenuManager, createChildActions, null);
        menuManager.insertBefore(EGFCommonUIConstants.EDIT_MENU_GROUP, submenuManager);

        submenuManager = new MenuManager(EGFModelEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"), EGFCommonUIConstants.CREATE_SIBLING); //$NON-NLS-1$
        populateManager(submenuManager, createSiblingActions, null);
        menuManager.insertBefore(EGFCommonUIConstants.EDIT_MENU_GROUP, submenuManager);

        // propagate menuAboutToShow to menu contributors
        for (EditorMenuContributor vpc : menuContributors) {
            vpc.menuAboutToShow(menuManager);
        }

    }

    /**
     * This inserts global actions before the "additions-end" separator.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void addGlobalActions(IMenuManager menuManager) {
        menuManager.insertAfter("additions-end", new Separator("ui-actions")); //$NON-NLS-1$ //$NON-NLS-2$
        menuManager.insertAfter("ui-actions", showPropertiesViewAction); //$NON-NLS-1$

        refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());
        menuManager.insertAfter("ui-actions", refreshViewerAction); //$NON-NLS-1$

        super.addGlobalActions(menuManager);
    }

    /**
     * This ensures that a delete action will clean up all references to deleted
     * objects.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected boolean removeAllReferencesOnDelete() {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void init(IActionBars actionBars) {
        super.init(actionBars);
        // Locate shared images registry
        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
        // override the superclass implementation of these actions
        undoAction = new UndoActionWrapper();
        undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
        actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
        redoAction = new RedoActionWrapper();
        redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
        actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
        pasteAction = new FcoreResourcePasteAction();
        pasteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
        actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), pasteAction);
    }

    /**
     * Dispose menu contributions from the registry
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void dispose() {
        EGFCoreUIPlugin.disposeEditorMenuContributors(this);
    }

}
