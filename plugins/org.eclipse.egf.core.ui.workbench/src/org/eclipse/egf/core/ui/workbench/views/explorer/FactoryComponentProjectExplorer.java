/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.views.explorer;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.egf.common.helper.MiscHelper;
import org.eclipse.egf.common.ui.helper.ViewerHelper;
import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSetManager;
import org.eclipse.egf.core.ui.data.listener.IWorkingSetListener;
import org.eclipse.egf.core.ui.workbench.internal.drop.DelegatingCommonDropAdapter;
import org.eclipse.egf.core.ui.workbench.views.fc.AbstractFactoryComponentView;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.internal.data.ModelElement;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.navigator.CommonDragAdapter;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.INavigatorContentService;


/**
 * This class provides the IViewPart for the Factory Component project explorer view in the Eclipse workbench.<br>
 * This view display all factory components under development in the end-user workspace.
 * @author Guillaume Brocard
 */
public class FactoryComponentProjectExplorer extends AbstractFactoryComponentView {
  
  private static final String TAG_ROOT_MODE = "rootMode"; //$NON-NLS-1$
  
  /**
   * Identifier of the factory component project explorer view (declared in related plugin.xml).
   */
  public static final String VIEW_ID = "org.eclipse.egf.core.ui.workbench.views.explorer.assetProjectExplorer"; //$NON-NLS-1$
  
  /**
   * Identifier of the factory component project explorer view content provider (declared in related plugin.xml).
   */
  private static final String CONTENT_PROVIDER_ID = "org.eclipse.egf.core.ui.workbench.views.explorer.assetProjectExplorerContent"; //$NON-NLS-1$
  
  /**
   * Working set listener used to be notified when changes occurs to workspace working sets.
   */
  private IWorkingSetListener _workingSetListener;
  
  /**
   * The factory component working set manager.<br>
   * Only, not null when the working set mode is active at view opening time.
   */
  private FactoryComponentWorkingSetManager _fcWorkingSetManager;
  
  /**
   * Selection listener used to notify the package explorer to select the project that contains the new selection.
   */
  private ISelectionChangedListener _selectionChangedListener;

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#getInitialInput()
   */
  @Override
  protected IAdaptable getInitialInput() {
    return computeInput(isProjectModeSelected());
  }

  /**
   * Compute the common viewer input depending on specified display mode.
   * @return a not null adaptable object.
   */
  protected IAdaptable computeInput(boolean isProjectModeSelected_p) {
    IAdaptable input = null;
    if (isProjectModeSelected_p) {
      // Displays all factory components at the same level.
      input = EgfUiActivator.getDefault().getFactoryComponentInWorkspaceInput();
    } else {
      // Get the factory component working set manager.
      if (null == _fcWorkingSetManager) {
        _fcWorkingSetManager = (FactoryComponentWorkingSetManager) EgfUiActivator.getDefault().getWorkingSetsInput();
      }
      // Initialize listener to monitor JDT working sets.
      initializeWorkingSetListener();
      // Use it as initial input.
      input = _fcWorkingSetManager;
      // Update the factory component working set manager from Package Explorer in an asynchExec way to make sure FactoryComponentWorkingSetManager got its children before the update
      // operation.
      getViewSite().getShell().getDisplay().asyncExec(new Runnable() {
        /**
         * @see java.lang.Runnable#run()
         */
        @SuppressWarnings("synthetic-access")
        public void run() {
          _workingSetListener.workingSetModelChanged(null);
        }
      });
    }
    return input;
  }

  /**
   * Whether or not the view should present the FC directly or beneath working sets.
   * @return <code>true</code> means FCs are presented directly without working sets.
   */
  private boolean isProjectModeSelected() {
    IDialogSettings dialogSettingsSection = JavaPlugin.getDefault().getDialogSettingsSection(PackageExplorerPart.class.getName());
    return (PackageExplorerPart.PROJECTS_AS_ROOTS == dialogSettingsSection.getInt(TAG_ROOT_MODE));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.views.fc.AbstractFactoryComponentView#getContentProviderId()
   */
  @Override
  protected String getContentProviderId() {
    return CONTENT_PROVIDER_ID;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.views.fc.AbstractFactoryComponentView#getEditingDomain()
   */
  @Override
  protected AdapterFactoryEditingDomain getEditingDomain() {
    return EgfUiActivator.getDefault().getEditingDomain();
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.views.fc.AbstractFactoryComponentView#handleAffectedObjects(java.util.Collection)
   */
  @Override
  protected void handleAffectedObjects(Collection<?> affectedObjects_p) {
    super.handleAffectedObjects(affectedObjects_p);
    // Force a viewer refresh for modification on ContractElement model element.
    // Indeed, context elements can reference a contract element that the name is changed.
    // Context elements matching a contract element use the contract element name as label.
    // Hence, force a refresh to update context element.
    boolean forceRefresh = false;
    for (Iterator<?> iterator = affectedObjects_p.iterator(); iterator.hasNext() && !forceRefresh;) {
      Object affectedObject = iterator.next();
      if ((affectedObject instanceof ContractElement) || (affectedObject instanceof FactoryComponent)) {
        forceRefresh = true;
      }
    }
    if (forceRefresh) {
      ViewerHelper.refresh(getCommonViewer());
    }
    // update Undo & Redo actions state.
    getNavigatorActionService().updateActionBars();
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#createCommonViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected CommonViewer createCommonViewer(Composite parent_p) {
    // To workaround DND feedbacks issues(bug #150688), we override the common viewer.
    CommonViewer viewer = new CommonViewer(getViewSite().getId(), parent_p, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL) {
      /**
       * @see org.eclipse.ui.navigator.CommonViewer#initDragAndDrop()
       */
      @Override
      protected void initDragAndDrop() {
        /* Handle Drag and Drop */
        int operations = DND.DROP_COPY | DND.DROP_MOVE;
        INavigatorContentService contentService = getNavigatorContentService();
        CommonDragAdapter dragAdapter = new CommonDragAdapter(contentService, this);
        addDragSupport(operations, dragAdapter.getSupportedDragTransfers(), dragAdapter);

        DelegatingCommonDropAdapter dropAdapter = new DelegatingCommonDropAdapter(contentService, this);
        addDropSupport(operations, dropAdapter.getSupportedDropTransfers(), dropAdapter);
      }
    };
    initListeners(viewer);
    viewer.getNavigatorContentService().restoreState(getMemento());
    return viewer;
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#initListeners(org.eclipse.jface.viewers.TreeViewer)
   */
  @Override
  protected void initListeners(TreeViewer viewer_p) {
    super.initListeners(viewer_p);
    _selectionChangedListener = new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        // Preconditions
        if ((null == event_p) || !isLinkingEnabled()) {
          return;
        }
        // Get the selection from event.
        ISelection selection = event_p.getSelection();
        // Ensure something is selected.
        if (!selection.isEmpty()) {
          IStructuredSelection structuredSelection = (IStructuredSelection) selection;
          // Get the first selected element.
          Object element = structuredSelection.getFirstElement();
          // If it is a model element, let's continue.
          if (element instanceof NamedModelElementWithId) {
            NamedModelElementWithId namedModelElement = (NamedModelElementWithId) element;
            // Get its factory component container.
            FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(namedModelElement);
            // Get the hosting project.
            IProject hostingProject = (IProject) ((ModelElement) fcContainer).getAdapter(IProject.class);
            if (null != hostingProject) {
              PackageExplorerPart packageExplorerView = WorkbenchHelper.getPackageExplorerView();
              // Ask the package explorer to select and reveal hosting project.
              if (null != packageExplorerView) {
                packageExplorerView.selectAndReveal(hostingProject);
              }
            }
          }
        }
      }
    };
    viewer_p.addPostSelectionChangedListener(_selectionChangedListener);
    // Add a property change listener to be notified when isLinkingEnabled property changes.
    addPropertyListener(new IPropertyListener() {
      /**
       * @see org.eclipse.ui.IPropertyListener#propertyChanged(java.lang.Object, int)
       */
      @SuppressWarnings("synthetic-access")
      public void propertyChanged(Object source_p, int propId_p) {
        switch (propId_p) {
          case CommonNavigator.IS_LINKING_ENABLED_PROPERTY:
            CommonViewer commonViewer = getCommonViewer();
            // Ensure common viewer is created.
            if (null != commonViewer) {
              Control tree = commonViewer.getControl();
              // Ensure tree is not disposed.
              if ((null != tree) && !tree.isDisposed()) {
                _selectionChangedListener.selectionChanged(new SelectionChangedEvent(commonViewer, commonViewer.getSelection()));
              }
            }
        }
      }
    });
  }

  /**
   * Initialize and register listeners to monitor working set.
   */
  protected void initializeWorkingSetListener() {
    if (null == _workingSetListener) {
      _workingSetListener = new IWorkingSetListener() {
        /**
         * @see org.eclipse.egf.core.ui.data.listener.IWorkingSetListener#workingSetAdded(org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet,
         *      org.eclipse.jface.util.PropertyChangeEvent)
         */
        public void workingSetAdded(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p) {
          if (null != workingSet_p) {
            getCommonViewer().add(null, workingSet_p);
          }
        }

        /**
         * @see org.eclipse.egf.core.ui.data.listener.IWorkingSetListener#workingSetContentChanged(org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet,
         *      org.eclipse.jface.util.PropertyChangeEvent)
         */
        public void workingSetContentChanged(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p) {
          if (null != workingSet_p) {
            // Refresh due to structural changes.
            ViewerHelper.refresh(getCommonViewer());
          }
        }

        /**
         * @see org.eclipse.egf.core.ui.data.listener.IWorkingSetListener#workingSetLabelChanged(org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet,
         *      org.eclipse.jface.util.PropertyChangeEvent)
         */
        public void workingSetLabelChanged(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p) {
          if (null != workingSet_p) {
            // Update element's presentation.
            getCommonViewer().update(workingSet_p, null);
          }
        }

        /**
         * @see org.eclipse.egf.core.ui.data.listener.IWorkingSetListener#workingSetNameChanged(org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet,
         *      org.eclipse.jface.util.PropertyChangeEvent)
         */
        public void workingSetNameChanged(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p) {
          workingSetLabelChanged(workingSet_p, event_p);
        }

        /**
         * @see org.eclipse.egf.core.ui.data.listener.IWorkingSetListener#workingSetRemoved(org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet,
         *      org.eclipse.jface.util.PropertyChangeEvent)
         */
        public void workingSetRemoved(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p) {
          // A working set is removed, the contained projects are now handled by another one, hence refresh the tree viewer from the root.
          ViewerHelper.refresh(getCommonViewer());
        }

        /**
         * @see org.eclipse.egf.core.ui.data.listener.IWorkingSetListener#workingSetModelChanged(org.eclipse.jface.util.PropertyChangeEvent)
         */
        @SuppressWarnings("synthetic-access")
        public void workingSetModelChanged(PropertyChangeEvent event_p) {
          List<IWorkingSet> packageExplorerWorkingSets = getPackageExplorerWorkingSets();
          if (!packageExplorerWorkingSets.isEmpty()) {
            // Update the factory component working set manager.
            _fcWorkingSetManager.updatePublicWorkingSetsOrder(packageExplorerWorkingSets);
            // Refresh the viewer.
            ViewerHelper.refresh(getCommonViewer());
          }
        }
      };
      // Register the creates listener.
      getFactoryComponentWorkingSetManager().addWorkingSetListener(_workingSetListener);
    }
  }

  /**
   * Return the active working sets from the Package Explorer.
   * @return Empty list if the Package Explorer is unreachable.
   */
  protected List<IWorkingSet> getPackageExplorerWorkingSets() {
    List<IWorkingSet> activeWorkingSets = Collections.emptyList();
    PackageExplorerPart packageExplorerView = WorkbenchHelper.getPackageExplorerView();
    // Ask the package explorer the new active working sets order.
    if (null != packageExplorerView) {
      IWorkingSet[] activeWorkingSetArray = packageExplorerView.getWorkingSetModel().getActiveWorkingSets();
      activeWorkingSets = MiscHelper.asList(activeWorkingSetArray);
    }
    return activeWorkingSets;
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#dispose()
   */
  @Override
  public void dispose() {
    super.dispose();
    if (null != _workingSetListener) {
      // Remove from the working set manager as listener.
      _fcWorkingSetManager.removeWorkingSetListener(_workingSetListener);
      // Dispose references.
      _workingSetListener = null;
      _fcWorkingSetManager = null;
    }
  }

  /**
   * Get the factory component working set manager.
   * @return <code>null</code> if the viewer displays directly the FCs.
   */
  protected FactoryComponentWorkingSetManager getFactoryComponentWorkingSetManager() {
    return _fcWorkingSetManager;
  }

  /**
   * Ask this view to refresh its content input.
   */
  public void updateInput(boolean isProjectModeSelected_p) {
    // Compute the new input. Do not use the getInitial method because it is based on a property that is not already set when we are called.
    Object newInput = computeInput(isProjectModeSelected_p);
    // Set it.
    getCommonViewer().setInput(newInput);
  }
}