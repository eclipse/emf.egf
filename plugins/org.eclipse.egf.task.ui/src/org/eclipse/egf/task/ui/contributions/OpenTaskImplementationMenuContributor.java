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
package org.eclipse.egf.task.ui.contributions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.task.EGFTaskPlugin;
import org.eclipse.egf.task.ui.EGFTaskUIPlugin;
import org.eclipse.egf.task.ui.l10n.EGFTaskUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OpenTaskImplementationMenuContributor extends EditorMenuContributor {

    public static final String OPEN_TASK_IMPLEMENTATION_ACTION_ID = "open-task-implementation"; //$NON-NLS-1$

    public static class FindOperation implements IRunnableWithProgress {

        private String _fqn;

        private Resource _resource;

        private IType _type;

        public FindOperation(Resource resource, String fqn) {
            _resource = resource;
            _fqn = fqn;
        }

        public IType getType() {
            return _type;
        }

        public URI getURI() {
            Resource resource = _resource;
            if (resource == null) {
                return null;
            }
            URI uri = resource.getURI();
            if (uri != null && resource.getResourceSet() != null) {
                URIConverter converter = resource.getResourceSet().getURIConverter();
                if (converter != null) {
                    uri = converter.normalize(uri);
                }
            }
            return uri;
        }

        public void run(IProgressMonitor monitor) throws InvocationTargetException {
            try {
                URI uri = getURI();
                // Workspace
                if (uri.isPlatformResource()) {
                    String path = uri.toPlatformString(true);
                    IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
                    IJavaProject project = JavaCore.create(resource.getProject());
                    _type = project.findType(_fqn, monitor);
                } else {
                    // Target
                    IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(_resource);
                    Bundle fcoreBundle = fcore.getPlatformBundle().getBundle();
                    if (fcoreBundle == null) {
                        throw new InvocationTargetException(new CoreException(EGFTaskUIPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_unable_to_find_platform_fcore, _resource.getURI()), null)));
                    }
                    // Class
                    Class<?> clazz = fcoreBundle.loadClass(_fqn);
                    if (clazz == null) {
                        throw new InvocationTargetException(new CoreException(EGFTaskUIPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_unable_to_load_class, _fqn), null)));
                    }
                    // Is the current bundle part of Java Search
                    String id = fcore.getPlatformBundle().getPluginBase().getId();
                    if (PDECore.getDefault().getSearchablePluginsManager().isInJavaSearch(id) == false) {
                        PDECore.getDefault().getSearchablePluginsManager().addToJavaSearch(new IPluginModelBase[] {
                            fcore.getPlatformBundle().getPluginModelBase()
                        });
                    }
                    // Java Search
                    TypeSearchRequestor requestor = new TypeSearchRequestor();
                    SearchEngine engine = new SearchEngine((WorkingCopyOwner) null);
                    engine.searchAllTypeNames(clazz.getPackage().getName().toCharArray(), SearchPattern.R_EXACT_MATCH, clazz.getSimpleName().toCharArray(), SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.CLASS_AND_INTERFACE, SearchEngine.createWorkspaceScope(), requestor,
                            IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, monitor);
                    _type = requestor.getMatched();
                }
            } catch (Throwable t) {
                throw new InvocationTargetException(new CoreException(EGFTaskUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_message, t)));
            } finally {
                monitor.done();
            }
        }
    }

    private static class TypeSearchRequestor extends TypeNameMatchRequestor {

        private IType _matched;

        public TypeSearchRequestor() {
            super();
        }

        @Override
        public void acceptTypeNameMatch(TypeNameMatch match) {
            _matched = match.getType();
        }

        public IType getMatched() {
            return _matched;
        }

    }

    protected class TaskImplementationOpenAction extends Action {

        public TaskImplementationOpenAction() {
            setId(OPEN_TASK_IMPLEMENTATION_ACTION_ID);
        }

        protected Task getTask() {
            if (_selection == null || _selection.isEmpty()) {
                return null;
            }
            Object object = ((IStructuredSelection) _selection).getFirstElement();
            if (object instanceof Task) {
                return (Task) object;
            }
            return null;
        }

        protected Resource getResource() {
            Task task = getTask();
            if (task == null) {
                return null;
            }
            return task.eResource();
        }

        protected String getKind() {
            Task task = getTask();
            if (task == null) {
                return null;
            }
            if (task.getKindValue() != null && task.getKindValue().trim().length() != 0) {
                return task.getKindValue().trim();
            }
            return null;
        }

        protected String getImplementation() {
            Task task = getTask();
            if (task == null) {
                return null;
            }
            if (task.getImplementationValue() != null && task.getImplementationValue().trim().length() != 0) {
                return task.getImplementationValue().trim();
            }
            return null;
        }

        @Override
        public boolean isEnabled() {
            if (getTask() == null) {
                return false;
            }
            if (getTask().eResource() == null) {
                return false;
            }
            if (getKind() == null) {
                return false;
            }
            if (getImplementation() == null || getImplementation().length() == 0) {
                return false;
            }
            return true;
        }

        @Override
        public void run() {
            // Find a suitable IType
            FindOperation operation = new FindOperation(getResource(), getImplementation());
            try {
                PlatformUI.getWorkbench().getProgressService().busyCursorWhile(operation);
                if (operation.getType() != null) {
                    JavaUI.openInEditor(operation.getType());
                } else {
                    MessageDialog.openError(_activeEditorPart.getSite().getShell(), EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_title, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_message, getImplementation()));
                }
            } catch (InterruptedException e) {
                return;
            } catch (Throwable t) {
                ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), t);
                return;
            }
        }
    }

    private TaskImplementationOpenAction _openAction;

    public OpenTaskImplementationMenuContributor() {
        _openAction = new TaskImplementationOpenAction();
    }

    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        if (((IStructuredSelection) _selection).size() == 1 && _openAction.getTask() != null && EGFTaskPlugin.KIND_JAVA.equals(_openAction.getKind())) {
            _openAction.setText(getText());
            _openAction.setEnabled(_openAction.isEnabled());
            menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, _openAction);
        }
    }

    protected String getText() {
        return EGFTaskUIMessages.TaskImplementationMenuContributor_openAction_label;
    }

}
