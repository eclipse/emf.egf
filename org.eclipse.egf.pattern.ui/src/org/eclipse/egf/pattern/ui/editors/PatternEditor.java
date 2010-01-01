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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.PatternConstants;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.domain.ResourceLoadedListener;
import org.eclipse.egf.pattern.ui.editors.domain.ResourceLoadedListener.ResourceListener;
import org.eclipse.egf.pattern.ui.editors.domain.ResourceLoadedListener.ResourceUser;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.ide.IDE;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class PatternEditor extends FormEditor implements ResourceUser, IEditingDomainProvider {

    protected IUndoContext undoContext;
    protected Resource resource;
    private TransactionalEditingDomain editingDomain;
    private IUndoableOperation savedOperation;
    private final ResourceListener resourceListener = new ResourceListener() {

        public void resourceMoved(Resource resource, URI newURI) {
        }

        public void resourceDeleted(Resource resource) {
            if (getResource().equals(resource) && (!isDirty() || handleDirtyConflict()))
                getSite().getPage().closeEditor(PatternEditor.this, false);
        }

        public void resourceChanged(Resource resource) {
            for (PatternEditorPage page : pages)
                page.rebind();
        }
    };
    private final List<PatternEditorPage> pages = new ArrayList<PatternEditorPage>();

    // The adapter is for refreshing the editor title while the name of pattern
    // has been changed.
    AdapterImpl refresher = new AdapterImpl() {
        public void notifyChanged(Notification msg) {
            if (FcorePackage.Literals.MODEL_ELEMENT__NAME.equals(msg.getFeature())) {
                setPartName((String) msg.getNewValue());
            }
        }
    };

    public PatternEditor() {
        initializeEditingDomain();
    }

    public void doSave(IProgressMonitor monitor) {
        try {
            // .CUSTOM: We record the last operation executed when saved.
            savedOperation = getOperationHistory().getUndoOperation(undoContext);
            new ProgressMonitorDialog(getSite().getShell()).run(true, false, ResourceLoadedListener.RESOURCE_MANAGER.createSaveOperation(this, editingDomain));
            firePropertyChange(IEditorPart.PROP_DIRTY);
        } catch (InvocationTargetException exception) {
            Activator.getDefault().logError(exception.getTargetException());
        } catch (Exception exception) {
            Activator.getDefault().logError(exception);
        }
    }

    public void doSaveAs() {
        throw new UnsupportedOperationException();
    }

    protected void initializeEditingDomain() {
        editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(PatternConstants.EDITING_DOMAIN_ID);
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
            throw new PartInitException(Messages.Editor_wrong_input);

        super.init(site, editorInput);
        ResourceLoadedListener.RESOURCE_MANAGER.addObserver(this);
        addPatternChangeAdapter();
    }

    /**
     * While the name of the pattern has been changed, refresh the editor title.
     */
    private void addPatternChangeAdapter() {
        Pattern pattern = getPattern();
        if (pattern != null) {
            pattern.eAdapters().add(refresher);
            setPartName(pattern.getName());
        }
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
        // setPartName(getPattern().getName());
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
        getOperationHistory().removeOperationHistoryListener(historyListener);
        getOperationHistory().dispose(undoContext, true, true, true);

        // getResource().unload();
        // editingDomain.getResourceSet().getResources().remove(getResource());
        ResourceLoadedListener.RESOURCE_MANAGER.removeObserver(this);

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
     * Shows a dialog that asks if conflicting changes should be discarded.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    protected boolean handleDirtyConflict() {
        return MessageDialog.openQuestion(getSite().getShell(), "File Conflict", //$NON-NLS-1$
                "External changes, close the editor ?"); //$NON-NLS-1$
    }

    public ResourceListener getListener() {

        return resourceListener;
    }

    public static void openEditor(IWorkbenchPage page, Pattern pattern) {
        if (page == null)
            throw new IllegalArgumentException();
        if (pattern == null)
            throw new IllegalArgumentException();

        Resource resource = pattern.eResource();
        try {
            PatternEditorInput input = new PatternEditorInput(resource, pattern.getID());
            PatternEditor editor = (PatternEditor) IDE.openEditor(page, input, "org.eclipse.egf.pattern.ui.editors.PatternEditor");
        } catch (PartInitException e) {
            e.printStackTrace();
        }
    }

}
