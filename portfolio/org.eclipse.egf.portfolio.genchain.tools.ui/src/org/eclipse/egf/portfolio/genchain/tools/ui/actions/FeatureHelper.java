package org.eclipse.egf.portfolio.genchain.tools.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.portfolio.genchain.tools.Activator;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.pde.internal.core.feature.FeaturePlugin;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureChild;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.pde.internal.ui.wizards.feature.CreateFeatureProjectOperation;
import org.eclipse.pde.internal.ui.wizards.feature.FeatureData;

public class FeatureHelper {
	public static final String VERSION = "1.0.0.qualifier";
	// private static final Shell SHELL =
	// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	private static final Path PLUGIN_PATH = new Path("/plugin.xml");
	private static final Path METAFEST_PATH = new Path("/META-INF/MANIFEST.MF");
	private static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace().getRoot();

	@SuppressWarnings("restriction")
	public static IProject createFeatureProject(Collection<String> includedFeatureList, Collection<String> pluginList, String id, String name, final IProgressMonitor monitor) throws CoreException {

		final IPluginBase[] pluginBase = getPluginBase(pluginList);
		final FeatureData featureData = getFeatureData(id, name);
		final IProject projectF = ROOT.getProject(featureData.id);

		CreateFeatureProjectOperation operation = new MyCreateFeatureProjectOperation(projectF, ROOT.getLocation(), featureData, pluginBase, new ArrayList<String>(includedFeatureList));
		try {
			operation.run(monitor);
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), e.getMessage(), e));
		}

		return projectF;
	}

	private static IPluginBase[] getPluginBase(Collection<String> pluginList) {
		if (pluginList != null && pluginList.size() > 0) {
			int size = pluginList.size();
			IPluginBase[] result = new IPluginBase[size];
			size = 0;
			for (String id : pluginList) {
				result[size++] = getPluginBase(id);
			}
			return result;
		}
		return null;

	}

	@SuppressWarnings("restriction")
	private static IPluginBase getPluginBase(String pluginName) {
		IProject project = ROOT.getProject(pluginName);
		IFile manifestFile = project.getFile(METAFEST_PATH);
		IFile pluginFile = project.getFile(PLUGIN_PATH);
		WorkspaceBundlePluginModel model = new WorkspaceBundlePluginModel(manifestFile, pluginFile);
		IPluginBase pluginBase = model.getPluginBase();
		return pluginBase;
	}

	@SuppressWarnings("restriction")
	private static FeatureData getFeatureData(String id, String name) {
		FeatureData featureData = new FeatureData();
		featureData.id = id + ".feature";
		featureData.name = name + " Feature";
		// featureData.provider = "THALESGROUP";
		final IProject fproject = ResourcesPlugin.getWorkspace().getRoot().getProject(id + ".feature");
		featureData.version = getFeatureProjectVersion(fproject);
		return featureData;
	}
	
	@SuppressWarnings("restriction")
	private static String getFeatureProjectVersion(IProject fproject){
		String version = VERSION;
		if (fproject.exists())
		{
			WorkspaceFeatureModel model = null;
			try {
				IFile file = PDEProject.getFeatureXml(fproject);
				file.refreshLocal(IFile.DEPTH_ONE, new NullProgressMonitor());
				model = new WorkspaceFeatureModel(file);
				model.load();
				IFeature feature = model.getFeature();
				version = feature.getVersion();
			} catch (Exception e) {
				// Do nothing and return the default version
			}
			finally {
				if (model!= null)
				{
					model.dispose();
				}
			}
		}
		
		return version;
	}

	@SuppressWarnings("restriction")
	private static class MyCreateFeatureProjectOperation extends CreateFeatureProjectOperation {

		private List<String> includedFeatureList;

		public MyCreateFeatureProjectOperation(IProject project, IPath location, FeatureData featureData, IPluginBase[] plugins, List<String> includedFeatureList) {
			super(project, location, featureData, plugins, null);
			this.includedFeatureList = includedFeatureList;
		}

		@Override
		protected void configureFeature(IFeature feature, WorkspaceFeatureModel model) throws CoreException {
			IFeaturePlugin[] added = new IFeaturePlugin[fPlugins.length];
			for (int i = 0; i < fPlugins.length; i++) {
				IPluginBase plugin = fPlugins[i];
				FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
				fplugin.loadFrom(plugin);
				fplugin.setVersion("0.0.0"); //$NON-NLS-1$
				fplugin.setUnpack(false);
				added[i] = fplugin;
			}
			feature.addPlugins(added);
			IFeatureChild[] features = new IFeatureChild[includedFeatureList.size()];
			for (int i = 0; i < includedFeatureList.size(); i++) {
				IFeatureChild child = model.getFactory().createChild();
				child.setId(includedFeatureList.get(i));
				child.setVersion("0.0.0");
				features[i] = child;
			}
			feature.addIncludedFeatures(features);
		}

		protected void openFeatureEditor(IFile manifestFile) {
			// we don't need such a feature
		}

		protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
			if (fProject.exists())
				fProject.delete(true, monitor);
			super.execute(monitor);
		}

		protected boolean shouldOverwriteFeature() {
			return true;
		}

	}
}
