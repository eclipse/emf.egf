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

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.domain.EGFResourceSet;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.tools.Activator;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;
import org.eclipse.egf.portfolio.genchain.tools.utils.RunActivityHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;

/**
 * 
 * @author Thomas Guiu
 */
public class CreateFcoreAction implements IObjectActionDelegate {

    private static final URI GENERATOR_URI = URI.createURI("platform:/plugin/org.eclipse.egf.portfolio.genchain.tools/egf/Generation_Chain_Producer.fcore#_6qO2EYhGEd-Ii9WHGzCGHg");

    private IStructuredSelection selection;

    public void run(IAction action) {
        if (selection == null || selection.size() != 1)
            return;

        IFile modelFile = (IFile) selection.getFirstElement();
        final URI modelURI = URI.createPlatformPluginURI(modelFile.getFullPath().toString(), false);
        final EGFResourceSet resourceSet = new EGFResourceSet();

        final GenerationChain generationChain = (GenerationChain) resourceSet.getResource(modelURI, true).getContents().get(0);

        final String fcoreRelativePath = "/model/" + generationChain.getName() + ".fcore";
        final String fcoreOutputPath = generationChain.getFactoryComponentName() + fcoreRelativePath;

        final WorkspaceJob buildJob = new WorkspaceJob(Messages.genchain_action_label) {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                try {
                    workAroundforProjectCreation(generationChain.getFactoryComponentName(), fcoreRelativePath);
                    FactoryComponent fc = (FactoryComponent) resourceSet.getEObject(GENERATOR_URI, true);
                    DomainURI domainURI = DomainFactory.eINSTANCE.createDomainURI();
                    domainURI.setUri(modelURI);

                    ((TypePatternSubstitution) (fc.getContract("pattern substitutions").getType())).getSubstitutions().addAll(ExtensionHelper.getAllSubstitutions());
                    ((TypeDomainURI) (fc.getContract("genChain model").getType())).setDomain(domainURI);
                    ((TypeString) (fc.getContract("generation plugin name").getType())).setValue(generationChain.getFactoryComponentName());
                    ((TypeString) (fc.getContract("model name").getType())).setValue(generationChain.getName());
                    ((TypeString) (fc.getContract("fcore output path").getType())).setValue(fcoreOutputPath);
                    RunActivityHelper.run(fc, null);
                } catch (Exception e) {
                    throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
                }
                return Status.OK_STATUS;
            }
        };

        buildJob.schedule();

    }

    private void workAroundforProjectCreation(String projectName, String path) throws CoreException, InvocationTargetException, InterruptedException {
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        if (!project.exists())
            project.create(null);
        project.open(null);
        WorkspaceOperationRunner runner = new WorkspaceOperationRunner();
        runner.setProgressMonitor(null);
        runner.run(true, false, new ConvertProjectOperation(project, true, true));
        IFile file = project.getFile("plugin.xml");
        if (!file.exists()) {
            String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<?eclipse version=\"3.2\"?>\n<plugin>" + "\n\t<extension\n\tpoint=\"org.eclipse.egf.core.fcore\">\n\t\t<fcore id=\"" + path + "\">\n\t" + "</fcore>\n</extension>\n</plugin>";
            file.create(new ByteArrayInputStream(data.getBytes()), true, null);
        }
        file = project.getFile("build.properties");
        String data = "bin.includes = META-INF/,\\\nmodel/,\\\nplugin.xml\n";
        if (file.exists())
            file.setContents(new ByteArrayInputStream(data.getBytes()), true, false, null);
        else
            file.create(new ByteArrayInputStream(data.getBytes()), true, null);

    }

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = (IStructuredSelection) selection;
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    }

}
