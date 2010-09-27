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
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
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
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OpenJavaTaskImplementationMenuContributor extends TaskMenuContributor {

    public static final String OPEN_TASK_IMPLEMENTATION_ACTION_ID = "open-java-task-implementation"; //$NON-NLS-1$

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
                    IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(uri.toPlatformString(true)));
                    IJavaProject project = JavaCore.create(resource.getProject());
                    _type = project.findType(_fqn, monitor);
                } else {
                    // Target
                    IPlatformFcore fcore = ((IPlatformFcoreProvider) _resource).getIPlatformFcore();
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
                    String id = fcore.getPlatformBundle().getBundleId();
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

    protected static class OpenAction extends TaskImplementationOpenAction {

        public OpenAction(Task task) {
            super(task, OPEN_TASK_IMPLEMENTATION_ACTION_ID);
        }

        @Override
        protected boolean doRun() throws Exception {
            FindOperation operation = new FindOperation(getTask().eResource(), getImplementation());
            PlatformUI.getWorkbench().getProgressService().busyCursorWhile(operation);
            if (operation.getType() == null)
                return false;

            JavaUI.openInEditor(operation.getType());
            return true;
        }
    }

    @Override
    protected String getExpectedKind() {
        return EGFTaskPlugin.KIND_JAVA;
    }

    @Override
    protected TaskImplementationOpenAction createAction(Task task) {
        TaskImplementationOpenAction openAction = new OpenAction(task);
        openAction.setText(EGFTaskUIMessages.TaskImplementationMenuContributor_openAction_label);
        // openAction.setEnabled(openAction.isEnabled());
        return openAction;
    }

}
