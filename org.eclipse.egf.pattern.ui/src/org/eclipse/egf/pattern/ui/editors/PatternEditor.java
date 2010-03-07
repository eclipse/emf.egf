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
import org.eclipse.egf.core.ui.domain.EGFResourceLoadedListener;
import org.eclipse.egf.core.ui.domain.EGFResourceLoadedListener.ResourceListener;
import org.eclipse.egf.core.ui.domain.EGFResourceLoadedListener.ResourceUser;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
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
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.ide.IDE;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class PatternEditor extends FormEditor implements ResourceUser, IEditingDomainProvider {

  private String initialPatternName;

  protected ObjectUndoContext undoContext;

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

  private final ResourceListener resourceListener = new ResourceListener() {

    public void resourceMoved(Resource movedResource, final URI newURI) {
      if (movedResource == getResource()) {
        resourceHasBeenExternallyChanged = false;
        resourceHasBeenRemoved = false;
        userHasSavedResource = false;
        for (PatternEditorPage page : pages) {
          page.rebind();
        }
        addPatternChangeAdapter();
        getSite().getShell().getDisplay().asyncExec(new Runnable() {
          public void run() {
            getOperationHistory().dispose(undoContext, true, true, true);
            getResource().setURI(newURI);
            firePropertyChange(IEditorPart.PROP_DIRTY);
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

    public void resourceReloaded(Resource reloadedResource, Exception exception) {
      if (reloadedResource == getResource()) {
        resourceHasBeenExternallyChanged = false;
        resourceHasBeenRemoved = false;
        userHasSavedResource = false;
        for (PatternEditorPage page : pages) {
          page.rebind();
        }
        addPatternChangeAdapter();
        getSite().getShell().getDisplay().asyncExec(new Runnable() {
          public void run() {
            getOperationHistory().dispose(undoContext, true, true, true);
            firePropertyChange(IEditorPart.PROP_DIRTY);
          }
        });
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
            String name = getPattern().getName();
            if (initialPatternName != null && !initialPatternName.equals(name)) {
              try {
                ExtensionHelper.getExtension(getPattern().getNature()).getRefactoringManager().renamePattern(getPattern(), initialPatternName, name);
              } catch (Exception e) {
                Activator.getDefault().logError(e);
              }
              initialPatternName = name;
            }
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

  // The adapter is for refreshing the editor title while the name of pattern
  // has been changed.
  AdapterImpl refresher = new AdapterImpl() {
    @Override
    public void notifyChanged(Notification msg) {
      if (FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME.equals(msg.getFeature())) {
        setPartName((String) msg.getNewValue());
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
      EGFResourceLoadedListener.RESOURCE_MANAGER.reloadResource(getResource());
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

  protected void initializeEditingDomain() {
    editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
    undoContext = new ObjectUndoContext(this, "undoContext label"); //$NON-NLS-1$
    getOperationHistory().addOperationHistoryListener(historyListener);
  }

  public IOperationHistory getOperationHistory() {
    return ((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory();
  }

  public ObjectUndoContext getUndoContext() {
    return undoContext;
  }

  /**
   * The <code>MultiPageEditorExample</code> implementation of this method
   * checks that the input is an instance of <code>IFileEditorInput</code>.
   */
  @Override
  public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
    if (!(editorInput instanceof PatternEditorInput))
      throw new PartInitException(Messages.Editor_wrong_input);

    super.init(site, editorInput);
    initialPatternName = getPattern().getName();
    site.getPage().addPartListener(partListener);
    resourceHasBeenExternallyChanged = EGFResourceLoadedListener.RESOURCE_MANAGER.resourceHasBeenExternallyChanged(getResource());
    EGFResourceLoadedListener.RESOURCE_MANAGER.addObserver(this);
    // populate operation history if applicable
    EGFResourceLoadedListener.RESOURCE_MANAGER.populateUndoContext(getOperationHistory(), undoContext, getResource());
    addPatternChangeAdapter();
  }

  /**
   * While the name of the pattern has been changed, refresh the editor title.
   */
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

  private Pattern getPattern() {
    PatternEditorInput input = (PatternEditorInput) getEditorInput();
    if (input == null)
      throw new IllegalStateException();
    return input.getPattern();
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

  @Override
  public void dispose() {
    EGFResourceLoadedListener.RESOURCE_MANAGER.removeObserver(this);
    getSite().getPage().removePartListener(partListener);
    getOperationHistory().removeOperationHistoryListener(historyListener);
    getOperationHistory().dispose(undoContext, true, true, true);

    removePatternChangeAdapter();

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

  public static void openEditor(IWorkbenchPage page, Pattern pattern) {
    if (page == null || pattern == null)
      throw new IllegalArgumentException();
    Resource resource = pattern.eResource();
    try {
      IDE.openEditor(page, new PatternEditorInput(resource, pattern.getID()), "org.eclipse.egf.pattern.ui.editors.PatternEditor"); //$NON-NLS-1$
    } catch (PartInitException e) {
      Activator.getDefault().logError(e);
    }
  }

}
