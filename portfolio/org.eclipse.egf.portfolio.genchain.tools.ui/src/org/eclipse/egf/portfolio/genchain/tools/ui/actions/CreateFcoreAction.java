/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.tools.ui.Activator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * 
 * @author Thomas Guiu
 */
public class CreateFcoreAction implements IObjectActionDelegate {

    private IStructuredSelection selection;
    private IWorkbenchPart targetPart;

    private final static String RESOURCE_CREATE_ID="org.eclipse.egf.portfolio.genchain.tools.contribution.action.generationchain.resource.createFC"; //$NON-NLS-1$
    private final static String RESOURCE_CREATE_RUN_ID="org.eclipse.egf.portfolio.genchain.tools.contribution.action.generationchain.resource.createrunFC"; //$NON-NLS-1$
    private final static String OBJECT_CREATE_ID="org.eclipse.egf.portfolio.genchain.tools.contribution.action.generationchain.object.createFC"; //$NON-NLS-1$
    private final static String OBJECT_CREATE_RUN_ID="org.eclipse.egf.portfolio.genchain.tools.contribution.action.generationchain.object.createrunFC"; //$NON-NLS-1$

    public void run(IAction action) {
        if (RESOURCE_CREATE_ID.equals(action.getId())) 
            createResource(false);
        else if (RESOURCE_CREATE_RUN_ID.equals(action.getId()))
            createResource(true);
        else if (OBJECT_CREATE_ID.equals(action.getId()))
            createObject(false);
        else if (OBJECT_CREATE_RUN_ID.equals(action.getId()))
            createObject(true);
    }

    protected void createObject(boolean run) {
        GenerationChain generationChain = (GenerationChain) selection.getFirstElement();
        URI modelResourceURI = generationChain.eResource().getURI();
        IFile modelResourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modelResourceURI.toPlatformString(true)));
        convertProject(modelResourceFile.getProject());
        CreateFcoreHelper.INSTANCE.createJob(generationChain, run).schedule();
    }

    protected void createResource(boolean run) {
        IFile modelFile = (IFile) selection.getFirstElement();
        URI modelURI = URI.createPlatformPluginURI(modelFile.getFullPath().toString(), false);
        convertProject(modelFile.getProject());
        CreateFcoreHelper.INSTANCE.createJob(modelURI, run).schedule();
    }

    protected void convertProject(IProject project) {
        // Convert project to plugin (genchain is loaded in an EGFResourset with a platform:/plugin/ uri)
        // is this behavior necessary?
        WorkspaceModifyOperation convertOperation = new ConvertProjectOperation(project, false, false);
        try {
            new ProgressMonitorDialog(targetPart.getSite().getShell()).run(false, false, convertOperation);
        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = (IStructuredSelection) selection;
        
        if (this.selection == null || this.selection.size() != 1) {
            action.setEnabled(false);
            return;
        }

        if (OBJECT_CREATE_ID.equals(action.getId()) || OBJECT_CREATE_RUN_ID.equals(action.getId())) {
            GenerationChain generationChain = (GenerationChain) this.selection.getFirstElement();
            action.setEnabled(generationChain.getContainer() == null);
        }
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        this.targetPart = targetPart;
    }

}
