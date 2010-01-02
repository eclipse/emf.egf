/**
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
 */
package org.eclipse.egf.model.fcore.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.contributor.ViewpointContributor;
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

/**
 * This is the action bar contributor for the Fcore model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class FcoreActionBarContributor extends EditingDomainActionBarContributor implements ISelectionChangedListener {

  private final List<ViewpointContributor> viewpointContributors = new ArrayList<ViewpointContributor>();

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
  protected IAction showPropertiesViewAction = new Action(EGFModelsEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) //$NON-NLS-1$
  {
    @Override
    public void run() {
      try {
        getPage().showView("org.eclipse.ui.views.PropertySheet"); //$NON-NLS-1$
      } catch (PartInitException exception) {
        EGFModelsEditorPlugin.INSTANCE.log(exception);
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
  protected IAction refreshViewerAction = new Action(EGFModelsEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) //$NON-NLS-1$
  {
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
   * This is the menu manager into which menu contribution items should be
   * added for CreateChild
   * actions.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected IMenuManager createChildMenuManager;

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
   * This is the menu manager into which menu contribution items should be
   * added for CreateSibling
   * actions.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected IMenuManager createSiblingMenuManager;

  /**
   * This creates an instance of the contributor.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public FcoreActionBarContributor() {
    super(ADDITIONS_LAST_STYLE);
    for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(ViewpointContributor.EXTENSION_ID)) {
      try {
        ViewpointContributor contributor = (ViewpointContributor) element.createExecutableExtension("class"); //$NON-NLS-1$
        contributor.setParentContributor(this);
        viewpointContributors.add(contributor);
      } catch (CoreException e) {
        EGFCoreUIPlugin.getDefault().logError(e);
      }
    }

    validateAction = new ValidateAction() {
      /**
       * This simply execute the command.
       */
      @Override
      protected Diagnostic validate(IProgressMonitor progressMonitor) {
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
          diagnostic = new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0, EMFEditUIPlugin.INSTANCE.getString("_UI_DiagnosisOfNObjects_message", new String[] { Integer.toString(selectionSize) }), //$NON-NLS-1$
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
        // Bundle Session
        ProjectBundleSession session = new ProjectBundleSession(EGFModelsEditorPlugin.getPlugin().getBundle().getBundleContext());
        context.put(ProjectBundleSession.PROJECT_BUNDLE_SESSION, session);
        // Validation
        for (EObject eObject : selectedObjects) {
          progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object[] { diagnostician.getObjectLabel(eObject) })); //$NON-NLS-1$
          diagnostician.validate(eObject, diagnostic, context);
        }
        // Dispose Session
        try {
          session.dispose();
        } catch (CoreException ce) {
          EGFModelsEditorPlugin.getPlugin().logError(ce);
        }
        return diagnostic;
      }
    };
    controlAction = new ControlAction();
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
    toolBarManager.add(new Separator("fcore-settings")); //$NON-NLS-1$
    toolBarManager.add(new Separator("fcore-additions")); //$NON-NLS-1$
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
    super.contributeToMenu(menuManager);

    IMenuManager submenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_FcoreEditor_menu"), "org.eclipse.egf.model.fcoreMenuID"); //$NON-NLS-1$ //$NON-NLS-2$
    menuManager.insertAfter("additions", submenuManager); //$NON-NLS-1$
    submenuManager.add(new Separator("settings")); //$NON-NLS-1$
    submenuManager.add(new Separator("actions")); //$NON-NLS-1$
    submenuManager.add(new Separator("additions")); //$NON-NLS-1$
    submenuManager.add(new Separator("additions-end")); //$NON-NLS-1$

    // Prepare for CreateChild item addition or removal.
    //
    createChildMenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"), EGFCommonUIConstants.CREATE_CHILD); //$NON-NLS-1$
    submenuManager.insertBefore("additions", createChildMenuManager); //$NON-NLS-1$

    // Prepare for CreateSibling item addition or removal.
    //
    createSiblingMenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"), EGFCommonUIConstants.CREATE_SIBLING); //$NON-NLS-1$
    submenuManager.insertBefore("additions", createSiblingMenuManager); //$NON-NLS-1$

    // Force an update because Eclipse hides empty menus now.
    //
    submenuManager.addMenuListener(new IMenuListener() {
      public void menuAboutToShow(IMenuManager menuManager) {
        menuManager.updateAll(true);
      }
    });

    addGlobalActions(submenuManager);
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
    //
    if (selectionProvider != null) {
      selectionProvider.removeSelectionChangedListener(this);
    }
    if (part == null) {
      selectionProvider = null;
    } else {
      selectionProvider = part.getSite().getSelectionProvider();
      selectionProvider.addSelectionChangedListener(this);

      // Fake a selection changed event to update the menus.
      //
      if (selectionProvider.getSelection() != null) {
        selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
      }
    }
    for (ViewpointContributor vpc : viewpointContributors)
      vpc.setActiveEditor(part);

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

    // Remove any menu items for old selection.
    //
    if (createChildMenuManager != null) {
      depopulateManager(createChildMenuManager, createChildActions);
    }
    if (createSiblingMenuManager != null) {
      depopulateManager(createSiblingMenuManager, createSiblingActions);
    }

    // Query the new selection for appropriate new child/sibling descriptors
    //
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
    //
    createChildActions = generateCreateChildActions(newChildDescriptors, selection);
    createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);

    if (createChildMenuManager != null) {
      populateManager(createChildMenuManager, createChildActions, null);
      createChildMenuManager.update(true);
    }
    if (createSiblingMenuManager != null) {
      populateManager(createSiblingMenuManager, createSiblingActions, null);
      createSiblingMenuManager.update(true);
    }

    for (ViewpointContributor vpc : viewpointContributors) {
      vpc.selectionChanged(event);
    }

  }

  /**
   * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in
   * <code>descriptors</code>,
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
   * This populates the specified <code>manager</code> with
   * {@link org.eclipse.jface.action.ActionContributionItem}s
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
   * This removes from the specified <code>manager</code> all
   * {@link org.eclipse.jface.action.ActionContributionItem}s
   * based on the {@link org.eclipse.jface.action.IAction}s contained in the
   * <code>actions</code> collection.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void depopulateManager(IContributionManager manager, Collection<? extends IAction> actions) {
    if (actions != null) {
      IContributionItem[] items = manager.getItems();
      for (int i = 0; i < items.length; i++) {
        // Look into SubContributionItems
        //
        IContributionItem contributionItem = items[i];
        while (contributionItem instanceof SubContributionItem) {
          contributionItem = ((SubContributionItem) contributionItem).getInnerItem();
        }

        // Delete the ActionContributionItems with matching action.
        //
        if (contributionItem instanceof ActionContributionItem) {
          IAction action = ((ActionContributionItem) contributionItem).getAction();
          if (actions.contains(action)) {
            manager.remove(contributionItem);
          }
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
    MenuManager submenuManager = null;

    submenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"), EGFCommonUIConstants.CREATE_CHILD); //$NON-NLS-1$
    populateManager(submenuManager, createChildActions, null);
    menuManager.insertBefore("edit", submenuManager); //$NON-NLS-1$

    submenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"), EGFCommonUIConstants.CREATE_SIBLING); //$NON-NLS-1$
    populateManager(submenuManager, createSiblingActions, null);
    menuManager.insertBefore("edit", submenuManager); //$NON-NLS-1$

    for (ViewpointContributor vpc : viewpointContributors) {
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

}