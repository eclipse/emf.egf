/**
 * <copyright>
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
 * </copyright>
 */
package org.eclipse.egf.portfolio.task.ant.ui.contributions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.platform.uri.TargetPlatformURIConverter;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.portfolio.task.ant.Activator;
import org.eclipse.egf.portfolio.task.ant.ui.Messages;
import org.eclipse.egf.task.ui.contributions.TaskImplementationOpenAction;
import org.eclipse.egf.task.ui.contributions.TaskMenuContributor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * @author xiaoru chen
 * 
 */
public class OpenAntTaskImplementationMenuContributor extends TaskMenuContributor {

    public static final String OPEN_IMPLEMENTATION_ACTION_ID = "open-task-ant-implementation"; //$NON-NLS-1$

    protected static class OpenAction extends TaskImplementationOpenAction {

        public OpenAction(Task task) {
            super(task, OPEN_IMPLEMENTATION_ACTION_ID);
        }

        @Override
        protected boolean doRun() throws Exception {
            IWorkbench workbench = PlatformUI.getWorkbench();
            final String antFile = getImplementation();
            URI uri = URI.createURI(antFile);
            TargetPlatformURIConverter converter = new TargetPlatformURIConverter();
            uri = converter.normalize(uri);
            if (uri.isPlatformResource()) {
                Path path = new Path(uri.toPlatformString(true));
                IResource findMember = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
                if (findMember != null && findMember instanceof IFile) {
                    IEditorDescriptor editorDesc = IDE.getEditorDescriptor((IFile) findMember, true);
                    IDE.openEditor(workbench.getActiveWorkbenchWindow().getActivePage(), (IFile) findMember, editorDesc.getId());
                } else
                    return false;
            } else {
                IDE.openEditor(workbench.getActiveWorkbenchWindow().getActivePage(), new PlatformEditorInput(antFile), "org.eclipse.ui.DefaultTextEditor", false); //$NON-NLS-1$
            }
            return true;
        }

    }

    @Override
    protected TaskImplementationOpenAction createAction(Task task) {
        TaskImplementationOpenAction openAction = new OpenAction(task);
        openAction.setText(Messages.TaskImplementationMenuContributor_openAction_label);
        return openAction;
    }

    @Override
    protected String getExpectedKind() {
        return Activator.KIND_ANT;
    }

}
