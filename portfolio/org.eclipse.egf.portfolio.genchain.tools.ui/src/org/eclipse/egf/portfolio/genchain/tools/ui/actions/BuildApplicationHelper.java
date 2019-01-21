/**
 * <copyright>
 *
 *  Copyright (c) 2014, 2017 Thales Corporate Services S.A.S.
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.util.DomainSwitch;
import org.eclipse.egf.portfolio.genchain.generationChain.FeatureAddition;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.util.GenerationChainSwitch;
import org.eclipse.egf.portfolio.genchain.tools.ui.Activator;
import org.eclipse.egf.portfolio.genchain.tools.utils.QualifierReplacer;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.pde.internal.core.FeatureModelManager;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.exports.FeatureExportInfo;
import org.eclipse.pde.internal.core.exports.FeatureExportOperation;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;

/**
 * @author Thomas Guiu
 * 
 */
public class BuildApplicationHelper extends CreateFcoreHelper {
	private static final String ORG_ECLIPSE_PDE_PLUGIN_NATURE = "org.eclipse.pde.PluginNature";
	public static final BuildApplicationHelper INSTANCE = new BuildApplicationHelper();
	private static final String OS_NAME = "os.name";
	private static final String WINDOWS = "Windows";

	protected GenerationChain generationChain;

	public void build(URI uri) {
		createJob(uri, true).schedule();
	}

	@Override
	public WorkspaceJob createJob(GenerationChain generationChain, boolean run) {
		this.generationChain = generationChain;
		return super.createJob(generationChain, run);
	}

	public WorkspaceJob createAfterJob() {
		final WorkspaceJob buildJob = new WorkspaceJob("Building Models") {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					buildApplication();
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
				}
				return Status.OK_STATUS;
			}

		};

		return new WorkspaceJob("Build application") {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					generateFeaturePlugin(generationChain.eResource().getResourceSet(), generationChain, monitor);
					buildJob.schedule(1000);
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
				}
				return Status.OK_STATUS;
			}

		};
	}

	private void buildApplication() throws CoreException {
		final String pluginName = generationChain.getFactoryComponentName();
		final String name = generationChain.getName();
		final List<IProject> featureProjects = new ArrayList<IProject>();
		featureProjects.add(ResourcesPlugin.getWorkspace().getRoot().getProject(pluginName + ".feature"));
		collectAdditionalFeatures(featureProjects);
		final FeatureExportInfo exportInfo = createFeatureExportInfo(name, featureProjects);

		new FeatureExportOperation(exportInfo, "Build application") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IStatus run = super.run(monitor);
				createEclipseExtensionFile(pluginName, name, exportInfo);
				if (run.isOK() && !monitor.isCanceled()) {
					String osName = System.getProperty(OS_NAME);
					if (osName.contains(WINDOWS)) {
						try {
							Runtime.getRuntime().exec("explorer.exe " + new File(exportInfo.destinationDirectory).getParentFile().getParent());
						} catch (IOException e) {
							// don't care
						}
					}
				}
				return run;
			}
		}.schedule(500);
	}

	private void collectAdditionalFeatures(final List<IProject> featureProjects) {
		// parcourir le noeud genChain et ajouter les features
		//
		new GenerationChainSwitch<Object>() {
			@Override
			public Object caseGenerationChain(GenerationChain object) {
				for (EObject obj : object.getElements())
					doSwitch(obj);
				return this;
			}

			@Override
			public Object caseFeatureAddition(FeatureAddition addition) {
				for (String projectName : addition.getAdditions()) {
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
					featureProjects.add(project);
				}
				return this;
			}

		}.doSwitch(generationChain);
	}

	private void createEclipseExtensionFile(String pluginName, String name, final FeatureExportInfo exportInfo) {
		File eclipseExtensionFile = new File(exportInfo.destinationDirectory, ".eclipseextension");
		FileWriter fileWriter = null;
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("name=");
			stringBuilder.append(name);
			stringBuilder.append("\n");
			stringBuilder.append("id=");
			stringBuilder.append(pluginName);
			stringBuilder.append("\n");
			stringBuilder.append("version=");
			stringBuilder.append(FeatureHelper.VERSION);
			stringBuilder.append("\n");
			fileWriter = new FileWriter(eclipseExtensionFile);
			fileWriter.append(stringBuilder.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private FeatureExportInfo createFeatureExportInfo(String name, List<IProject> featureProjects) throws CoreException {
		FeatureExportInfo f = new FeatureExportInfo();

		FeatureModelManager manager = PDECore.getDefault().getFeatureModelManager();
		List<IFeatureModel> featureModels = new ArrayList<IFeatureModel>();
		for (IProject feature : featureProjects) {
			IFeatureModel featureModel = manager.getFeatureModel(feature);
			if (featureModel == null)
				throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), "Cannot get project for feature '" + feature.getName() + "'", null));
			featureModels.add(featureModel);

		}
		f.qualifier = QualifierReplacer.getDate();
		File tempFile;
		try {
			tempFile = File.createTempFile("" + System.currentTimeMillis(), "");
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
		}

		String separator = System.getProperty("file.separator");
		f.destinationDirectory = tempFile.getParent() + separator + f.qualifier + separator + name + "_" + f.qualifier + separator + "eclipse";
		f.items = featureModels.toArray();
		f.exportSource = false;
		f.toDirectory = true;
		f.useJarFormat = false;
		f.allowBinaryCycles = true;
		return f;
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

}
