/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.domain.EGFResourceSet;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.tools.Activator;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;
import org.eclipse.egf.portfolio.genchain.tools.utils.RunActivityHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;

/**
 * @author Thomas Guiu
 * 
 */
public class CreateFcoreHelper {
	public static final CreateFcoreHelper INSTANCE = new CreateFcoreHelper();

	private static final URI GENERATOR_URI = URI.createURI("platform:/plugin/org.eclipse.egf.portfolio.genchain.tools/egf/Generation_Chain_Producer.fcore#_6qO2EYhGEd-Ii9WHGzCGHg");

	public WorkspaceJob createJob(final URI fcoreURI) {

		final WorkspaceJob buildJob = new WorkspaceJob(getJobName()) {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					final EGFResourceSet resourceSet = new EGFResourceSet();
					final GenerationChain generationChain = (GenerationChain) resourceSet.getResource(fcoreURI, true).getContents().get(0);
					executeJob(generationChain, monitor);
				} catch (CoreException e) {
					throw e;
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
				}
				return Status.OK_STATUS;
			}

		};
		final WorkspaceJob setupJob = new WorkspaceJob(getJobName()) {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					final EGFResourceSet resourceSet = new EGFResourceSet();
					final GenerationChain generationChain = (GenerationChain) resourceSet.getResource(fcoreURI, true).getContents().get(0);
					setupProject(generationChain.getFactoryComponentName(), computeFcoreRelativePath(generationChain));
					buildJob.schedule(1000);
				} catch (CoreException e) {
					throw e;
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
				}
				return Status.OK_STATUS;
			}

		};
		return setupJob;
	}

	protected void executeJob(GenerationChain generationChain, IProgressMonitor monitor) throws CoreException {
		final String fcoreOutputPath = computeFcoreOutputPath(generationChain);

		createFcore(generationChain, fcoreOutputPath, monitor);
	}

	protected String computeFcoreOutputPath(GenerationChain generationChain) {
		return generationChain.getFactoryComponentName() + computeFcoreRelativePath(generationChain);
	}

	protected String computeFcoreRelativePath(GenerationChain generationChain) {
		return "/model/" + generationChain.getName() + ".fcore";
	}

	public void setupProject(String projectName, String fcorePath) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (!project.exists())
			project.create(null);
		project.open(null);
		WorkspaceOperationRunner runner = new WorkspaceOperationRunner();
		runner.setProgressMonitor(null);
		try {
			runner.run(true, false, new ConvertProjectOperation(project, false, false));
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
		}
	}

	protected void createFcore(final GenerationChain generationChain, final String fcoreOutputPath, IProgressMonitor monitor) throws CoreException {
		FactoryComponent fc = (FactoryComponent) generationChain.eResource().getResourceSet().getEObject(getGeneratorURI(), true);
		DomainURI domainURI = DomainFactory.eINSTANCE.createDomainURI();
		final URI uri = generationChain.eResource().getURI();
		domainURI.setUri(uri);

		((TypePatternSubstitution) (fc.getContract("pattern substitutions").getType())).getSubstitutions().addAll(computeSubstitutions());
		((TypeDomainURI) (fc.getContract("genChain model").getType())).setDomain(domainURI);
		((TypeString) (fc.getContract("generation plugin name").getType())).setValue(generationChain.getFactoryComponentName());
		((TypeString) (fc.getContract("model name").getType())).setValue(generationChain.getName());
		((TypeString) (fc.getContract("fcore output path").getType())).setValue(fcoreOutputPath);
		try {
			RunActivityHelper.run(fc, monitor);
		} catch (InvocationException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
		}
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(generationChain.getFactoryComponentName());
		if (project != null && project.exists()) {
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}

	}

	protected List<Substitution> computeSubstitutions() {
		return ExtensionHelper.getAllSubstitutions();
	}

	protected String getJobName() {
		return Messages.genchain_action_label;
	}

	protected URI getGeneratorURI() {
		return GENERATOR_URI;
	}

}
