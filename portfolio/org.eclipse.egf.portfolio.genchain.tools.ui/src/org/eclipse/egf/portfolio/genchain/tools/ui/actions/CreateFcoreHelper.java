/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.ui.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.domain.IDomainHelper;
import org.eclipse.egf.domain.emf.EMFDomainHelper;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.domain.util.DomainSwitch;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.generationChain.FeatureAddition;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider;
import org.eclipse.egf.portfolio.genchain.generationChain.util.GenerationChainSwitch;
import org.eclipse.egf.portfolio.genchain.tools.Activator;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;
import org.eclipse.egf.portfolio.genchain.tools.utils.RunActivityHelper;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;

/**
 * @author Thomas Guiu
 * 
 */
public class CreateFcoreHelper {
	private static final String ORG_ECLIPSE_PDE_PLUGIN_NATURE = "org.eclipse.pde.PluginNature";
	public static final CreateFcoreHelper INSTANCE = new CreateFcoreHelper();

	private static final URI GENERATOR_URI = URI.createURI("platform:/plugin/org.eclipse.egf.portfolio.genchain.tools/egf/Generation_Chain_Producer.fcore#_6qO2EYhGEd-Ii9WHGzCGHg");

	public WorkspaceJob createJob(final GenerationChain generationChain, final boolean run) {
		final String fcoreOutputPath = computeFcoreOutputPath(generationChain);

		final WorkspaceJob beforeJob = createBeforeJob();
		final WorkspaceJob afterJob = createAfterJob();

		final WorkspaceJob runJob = new WorkspaceJob(Messages.genchain_run_action_label) {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					ResourceSet set = new EgfResourceSet();
					runFcore(set, generationChain, fcoreOutputPath, monitor);
					generateFeaturePlugin(set, generationChain, monitor);
					if (afterJob != null) {
						afterJob.schedule(1000);
						// afterJob.join();
					}
				} catch (CoreException e) {
					throw e;
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
				}
				return Status.OK_STATUS;
			}
		};

		final WorkspaceJob buildJob = new WorkspaceJob(Messages.genchain_generate_action_label) {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					createFcore(generationChain, fcoreOutputPath, monitor);
					if (run) {
						runJob.schedule(1000);
						// runJob.join();
					}
				} catch (CoreException e) {
					throw e;
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
				}
				return Status.OK_STATUS;
			}
		};

		final WorkspaceJob setupJob = new WorkspaceJob(Messages.genchain_generate_action_label) {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					if (beforeJob != null) {
						beforeJob.schedule();
						beforeJob.join();
					}
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

	public WorkspaceJob createBeforeJob() {
		return null;
	}

	public WorkspaceJob createAfterJob() {
		return null;
	}

	public WorkspaceJob createJob(URI fcoreURI, boolean run) {
		final ResourceSet resourceSet = new EgfResourceSet();
		final GenerationChain generationChain = (GenerationChain) resourceSet.getResource(fcoreURI, true).getContents().get(0);

		return createJob(generationChain, run);
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
		FactoryComponent fc = (FactoryComponent) new EgfResourceSet().getEObject(getGeneratorURI(), true);
		EMFDomain domain = DomainFactory.eINSTANCE.createEMFDomain();
		final URI uri = generationChain.eResource().getURI();
		domain.setUri(uri);

		((TypePatternSubstitution) (fc.getContract("pattern substitutions").getType())).getSubstitutions().addAll(computeSubstitutions());
		((TypeDomain) (fc.getContract("genChain model").getType())).setDomain(domain);
		((TypeString) (fc.getContract("generation plugin name").getType())).setValue(generationChain.getFactoryComponentName());
		((TypeString) (fc.getContract("model name").getType())).setValue(generationChain.getName());
		((TypeString) (fc.getContract("fcore output path").getType())).setValue(fcoreOutputPath);
		IDomainHelper helper = new EMFDomainHelper();
		try {
			try {
				if (helper.loadDomain(domain))
					RunActivityHelper.run(fc, monitor);
			} finally {
				helper.unLoadDomain(domain);
			}
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
		}
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(generationChain.getFactoryComponentName());
		if (project != null && project.exists()) {
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}

	}

	protected void runFcore(ResourceSet resourceSet, GenerationChain generationChain, String fcoreOutputPath, IProgressMonitor monitor) throws CoreException {
		URI uri = URI.createPlatformPluginURI(fcoreOutputPath, false);
		EObject eObject = resourceSet.getResource(uri, true).getContents().get(0);
		try {
			RunActivityHelper.run((Activity) eObject, monitor);
		} catch (InvocationException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
		}
	}

	protected void generateFeaturePlugin(ResourceSet resourceSet, final GenerationChain generationChain, IProgressMonitor monitor) throws CoreException {
		final Set<String> pluginList = new HashSet<String>();
		final Set<String> includedFeatureList = new HashSet<String>();
		String fcPath = computeFcoreOutputPath(generationChain);
		// final Map<String, GenModel> genModels = collectGenModels(generationChain.eResource().getResourceSet(), fcPath);
		final EList<EObject> collectDomains = collectDomains(resourceSet, fcPath);
		String pluginName = generationChain.getFactoryComponentName();
		// We don't include anymore the fcore file
		// pluginList.add(pluginName);

		// add plugin who contains the chain model
		URI uri = generationChain.eResource().getURI();
		pluginList.add(uri.segment(1));

		new GenerationChainSwitch<Object>() {
			// we want to walk throught all parents EClass
			@Override
			protected Object doSwitch(EClass theEClass, EObject theEObject) {
				if (theEClass.eContainer() == modelPackage) {
					return doSwitch(theEClass.getClassifierID(), theEObject);
				} else {
					List<EClass> eSuperTypes = theEClass.getESuperTypes();
					if (eSuperTypes.isEmpty())
						return defaultCase(theEObject);
					for (EClass superType : eSuperTypes) {
						Object doSwitch = doSwitch(superType, theEObject);
						if (doSwitch != null)
							return doSwitch;
					}
					return null;
				}
			}

			@Override
			public Object caseGenerationChain(GenerationChain object) {
				for (EObject obj : object.getElements())
					doSwitch(obj);
				return this;
			}

			@Override
			public Object casePluginProvider(PluginProvider object) {
				pluginList.addAll(object.getPluginNames(collectDomains));
				return this;
			}

			public Object caseFeatureAddition(FeatureAddition addition) {
				for (String projectName : addition.getAdditions()) {
					includedFeatureList.add(projectName);
				}
				return this;
			}

		}.doSwitch(generationChain);

		for (String pluginNameString : pluginList) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginNameString);
			if (project.exists() && !project.hasNature(ORG_ECLIPSE_PDE_PLUGIN_NATURE)) {
				WorkspaceOperationRunner runner = new WorkspaceOperationRunner();
				runner.setProgressMonitor(null);
				try {
					runner.run(true, false, new ConvertProjectOperation(project, false, false));
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
				}
			}

		}

		IProject projectF = FeatureHelper.createFeatureProject(includedFeatureList, pluginList, pluginName, generationChain.getName(), monitor);
		if (projectF != null && projectF.exists()) {
			projectF.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}

	}

	private EList<EObject> collectDomains(final ResourceSet resourceSet, String fcPath) {
		final EList<EObject> result = new BasicEList<EObject>();
		DomainSwitch<Object> _switch = new DomainSwitch<Object>() {

			@Override
			public Object caseEMFDomain(EMFDomain object) {
				result.add(resourceSet.getResource(object.getUri(), true).getContents().get(0));
				return this;
			}

			@Override
			public Object defaultCase(EObject object) {
				for (EObject obj : object.eContents())
					doSwitch(obj);
				return null;
			}
		};
		for (EObject obj : resourceSet.getResource(URI.createPlatformPluginURI(fcPath, false), true).getContents()) {
			_switch.doSwitch(obj);
		}
		return result;
	}

	protected List<Substitution> computeSubstitutions() {
		return ExtensionHelper.getAllSubstitutions();
	}

	protected URI getGeneratorURI() {
		return GENERATOR_URI;
	}

}