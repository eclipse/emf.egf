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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.platform.uri.PlatformURIConverter;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.task.EGFTaskPlugin;
import org.eclipse.egf.task.ui.l10n.EGFTaskUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * @author Thomas Guiu
 * 
 */
public class OpenRubyTaskImplementationMenuContributor extends TaskMenuContributor {

    public static final String OPEN_IMPLEMENTATION_ACTION_ID = "open-task-ruby-implementation"; //$NON-NLS-1$

    protected static class OpenAction extends TaskImplementationOpenAction {

        public OpenAction(Task task) {
            super(task, OPEN_IMPLEMENTATION_ACTION_ID);
        }

        protected boolean doRun() throws Exception {
            IWorkbench workbench = PlatformUI.getWorkbench();
            final String rubyFile = getImplementation();
            URI uri = URI.createURI(rubyFile);
            PlatformURIConverter converter = new PlatformURIConverter();
            uri = converter.normalize(uri);
            if (uri.isPlatformResource()) {
                Path path = new Path(uri.toPlatformString(true));
                IResource findMember = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
                if (findMember != null && findMember instanceof IFile)
                    IDE.openEditor(workbench.getActiveWorkbenchWindow().getActivePage(), (IFile) findMember);
                else
                    return false;
            } else
                IDE.openEditor(workbench.getActiveWorkbenchWindow().getActivePage(), new PlatformEditorInput(rubyFile), "org.eclipse.ui.DefaultTextEditor", false);
            return true;
        }
    }

    @Override
    protected String getExpectedKind() {
        return EGFTaskPlugin.KIND_RUBY;
    }

    @Override
    protected TaskImplementationOpenAction createAction(Task task) {
        TaskImplementationOpenAction openAction = new OpenAction(task);
        openAction.setText(EGFTaskUIMessages.TaskImplementationMenuContributor_openAction_label);
        // openAction.setEnabled(openAction.isEnabled());
        return openAction;
    }

}
