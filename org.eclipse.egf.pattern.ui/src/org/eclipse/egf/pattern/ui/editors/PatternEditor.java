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
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.editors.pages.ImplementationPage;
import org.eclipse.egf.pattern.ui.editors.pages.OverviewPage;
import org.eclipse.egf.pattern.ui.editors.pages.SpecificationPage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.forms.editor.FormEditor;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class PatternEditor extends FormEditor {

    protected IUndoContext undoContext;
    protected Resource resource;
    private TransactionalEditingDomain editingDomain;
    private IUndoableOperation savedOperation;

    public PatternEditor() {
        initializeEditingDomain();
    }

    public void doSave(IProgressMonitor monitor) {
        // Save only resources that have actually changed.
        //
        final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
        saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

        // Do the work within an operation because this is a long running
        // activity
        // that modifies the workbench. Moreover, we must do this in a read-only
        // transaction in the editing domain, to ensure exclusive read access
        //
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
            // This is the method that gets invoked when the operation runs.
            //
            @Override
            public void execute(IProgressMonitor monitor) {
                try {
                    // .CUSTOM: Save in a read-only transaction
                    editingDomain.runExclusive(new Runnable() {
                        public void run() {
                            try {
                                Resource savedResource = getPattern().eResource();
                                savedResource.save(saveOptions);
                            } catch (Exception exception) {
                                Activator.getDefault().logError(exception);
                            }
                        }
                    });
                } catch (Exception exception) {
                    Activator.getDefault().logError(exception);
                }
            }
        };

        try {
            new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

            // Refresh the necessary state.
            //
            // .CUSTOM: We record the last operation executed when saved.
            savedOperation = getOperationHistory().getUndoOperation(undoContext);
            firePropertyChange(IEditorPart.PROP_DIRTY);
        } catch (Exception exception) {
            Activator.getDefault().logError(exception);
        }
    }

    public void doSaveAs() {
        throw new UnsupportedOperationException();
    }

    protected void initializeEditingDomain() {
        editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.eclipse.egf.pattern.ui.editors.PatternEditingDomain"); //$NON-NLS-1$
        undoContext = new ObjectUndoContext(this, "undoContext label"); //$NON-NLS-1$
        getOperationHistory().addOperationHistoryListener(historyListener);
    }

    private IOperationHistory getOperationHistory() {
        return ((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory();
    }

    /**
     * The <code>MultiPageEditorExample</code> implementation of this method
     * checks that the input is an instance of <code>IFileEditorInput</code>.
     */
    public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
        if (!(editorInput instanceof PatternEditorInput))
            throw new PartInitException("Invalid Input: Must be PatternEditorInput");

        super.init(site, editorInput);
    }

    @Override
    public Object getAdapter(Class key) {
        if (key.equals(IUndoContext.class)) {
            return undoContext;
        }

        return super.getAdapter(key);
    }

    public boolean isSaveAsAllowed() {
        return false;
    }

    public boolean isDirty() {
        // We track the last operation executed before save was
        // performed
        IUndoableOperation op = getOperationHistory().getUndoOperation(undoContext);
        return op != savedOperation;
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

    public TransactionalEditingDomain getEditingDomain() {
        return editingDomain;
    }

    @Override
    public void dispose() {
        getOperationHistory().removeOperationHistoryListener(historyListener);
        getOperationHistory().dispose(undoContext, true, true, true);

        // TODO verifier si c'est une bonne idees: unload et remove
        // NPE: donc non mais il faut gerer l'affaire
        Resource eResource = getPattern().eResource();
        eResource.unload();
        editingDomain.getResourceSet().getResources().remove(eResource);

        super.dispose();
    }

    private final IOperationHistoryListener historyListener = new IOperationHistoryListener() {
        public void historyNotification(final OperationHistoryEvent event) {
            Set<Resource> affectedResources = ResourceUndoContext.getAffectedResources(event.getOperation());
            switch (event.getEventType()) {
            case OperationHistoryEvent.DONE:

                if (affectedResources.contains(getPattern().eResource())) {
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
                if (affectedResources.contains(getPattern().eResource())) {

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

}
