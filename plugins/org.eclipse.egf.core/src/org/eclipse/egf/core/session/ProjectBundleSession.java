/**
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.session;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.core.EGFCoreDebug;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;
import org.eclipse.osgi.service.resolver.ImportPackageSpecification;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class ProjectBundleSession {

	private static final String EGF_TARGET_BUNDLE_PRIORITY = "egf.target.bundle.priority"; //$NON-NLS-1$

	public static String PROJECT_BUNDLE_SESSION = "org.eclipse.egf.core.project.bundle.session"; //$NON-NLS-1$

	private BundleContext context;

	private Map<String, Bundle> projectBundles = new HashMap<String, Bundle>();

	private List<String> uninstalled = new UniqueEList<String>();

	private Boolean runtimeBundlePriority;

	public static String getLocation(IPluginModelBase model) throws CoreException {
		if (model == null) {
			return null;
		}
		IResource resource = model.getUnderlyingResource();
		if (resource == null) {
			return null;
		}
		String location = null;
		try {
			location = "reference:" //$NON-NLS-1$
					+ URLDecoder.decode(resource.getProject().getLocationURI().toURL().toExternalForm(), System.getProperty("file.encoding")); //$NON-NLS-1$
		} catch (Throwable t) {
			throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_URLFailure, resource.getProject().getName()), t));
		}
		return location;
	}
	public ProjectBundleSession(BundleContext context) {
		Assert.isNotNull(context);
		this.context = context;
	}

	private void installWorkspaceModels(List<Bundle> bundles, List<IPluginModelBase> workspaceModels) throws CoreException {
		if (bundles == null || workspaceModels == null || workspaceModels.size() == 0) {
			return;
		}
		// Install Workspace models
		for (IPluginModelBase workspaceModel : workspaceModels) {
			// Ignore already installed bundle
			if (projectBundles.get(getLocation(workspaceModel)) != null) {
				continue;
			}
			
			// Retrieve base location
			String location = getLocation(workspaceModel);
			// Install the bundle
			Bundle bundle = doInstallBundle(workspaceModel);
			// Store
			bundles.add(bundle);
			projectBundles.put(location, bundle);
		}
	}

	/**
	 * Installs the bundle corresponding to the model.
	 * 
	 * @param model
	 *            Model of the bundle to be installed.
	 */
	private Bundle installBundle(IPluginModelBase model) throws CoreException {

		// We only load workspace model
		if (getLocation(model) == null) {
			return null;
		}

		final String bundleId = BundleHelper.getBundleId(model);
		if (bundleId == null) {
			return null;
		}

		// Gather workspace bundles to install
		final List<IPluginModelBase> workspaceModels = getWorkspaceModelDependencies(model);

		// Check whether or not such workspace models have extension points
		final List<String> registryContributors = new UniqueEList<String>();
		for (IPluginModelBase workspaceModel : workspaceModels) {
			if (workspaceModel.getPluginBase().getExtensions() != null && workspaceModel.getPluginBase().getExtensions().length > 0) {
				String workspaceBundleId = BundleHelper.getBundleId(workspaceModel);
				final String location = getLocation(workspaceModel);
				if (workspaceBundleId != null && !projectBundles.containsKey(location)) {
					registryContributors.add(workspaceBundleId);
				}
			}
		}

		final ObjectHolder<Boolean> loadCompleted = new ObjectHolder<Boolean>();

		// build a listener to wait for asynchronous extensions notifications
		IRegistryEventListener registryListener = null;
		if (!registryContributors.isEmpty()) {

			registryListener = new IRegistryEventListener() {

				public void removed(IExtension[] extensions) {
					// Nothing to do
				}

				public void added(IExtension[] extensions) {
					// Process
					for (IExtension extension : extensions) {
						registryContributors.remove(extension.getContributor().getName());
						if (registryContributors.isEmpty()) {
							loadCompleted.object = Boolean.TRUE;
						}
					}
				}

				public void added(IExtensionPoint[] extensionPoints) {
					// Nothing to do
				}

				public void removed(IExtensionPoint[] extensionPoints) {
					// Nothing to do
				}

			};

			// Register
			RegistryFactory.getRegistry().addListener(registryListener);

		}

		// Install workspace bundles
		final List<Bundle> bundles = new UniqueEList<Bundle>();
		internalInstallBundle(bundles, workspaceModels);

		// Wait for extensions notifications if applicable
		if (registryListener != null) {
			int timeout = 20;
			try {
				while (loadCompleted.object == null && timeout-- > 0)
					Thread.sleep(100);
			} catch (InterruptedException e) {

			} finally {
				// Unregister
				RegistryFactory.getRegistry().removeListener(registryListener);
			}
			if (timeout < 0)
				EGFCorePlugin.getDefault().logWarning("Some bundles (related to " + bundleId + ") may not be fully loaded.");
		}

		// Trace
		if (EGFCoreDebug.isDebugBundleSession()) {
			for (Bundle bundle : bundles) {
				EGFCorePlugin.getDefault().logInfo(NLS.bind("Workspace Bundle ''{0}'' is started.", bundle.getSymbolicName())); //$NON-NLS-1$
			}
		}

		// Return our new bundle
		return Platform.getBundle(bundleId);

	}

	private void internalInstallBundle(List<Bundle> bundles, List<IPluginModelBase> workspaceModels) throws CoreException {

        // Uninstall runtime bundles if any
        uninstallRuntimeBundle(workspaceModels);
		// Install workspace bundles
		installWorkspaceModels(bundles, workspaceModels);
		// Refresh installed workspace bundles if any
		if (!bundles.isEmpty()) {
			refreshPackages(bundles.toArray(new Bundle[bundles.size()]));
		}
		// Start them
		for (Bundle bundle : bundles) {
			try {
				if (bundle.getState() != Bundle.ACTIVE) {
					bundle.start(Bundle.START_TRANSIENT);
				}
			} catch (Throwable t) {
				throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_StartFailure, bundle), t));
			}
		}

	}

	private void uninstallRuntimeBundle(List<IPluginModelBase> workspaceModels) throws CoreException {

		if (workspaceModels == null || workspaceModels.isEmpty()) {
			return;
		}
		List<IPluginModelBase> models = new UniqueEList<IPluginModelBase>();

		// Uninstall Runtime Bundle
		List<Bundle> bundles = new UniqueEList<Bundle>();
		for (IPluginModelBase workspaceModel : workspaceModels) {

			// Ignore already uninstalled bundle
			if (projectBundles.get(getLocation(workspaceModel)) != null) {
				continue;
			}

			// Uninstall Runtime if any
			String bundleId = BundleHelper.getBundleId(workspaceModel);
			if (bundleId == null) {
				continue;
			}
			Bundle bundle = Platform.getBundle(bundleId);
			if (bundle == null) {
				continue;
			}
			if (bundle.getState() == Bundle.INSTALLED || bundle.getState() == Bundle.RESOLVED || bundle.getState() == Bundle.STARTING || bundle.getState() == Bundle.STOPPING || bundle.getState() == Bundle.ACTIVE) {
				uninstallBundle(bundle);
			}

			// Store
			models.add(workspaceModel);
			uninstalled.add(bundle.getLocation());
			bundles.add(bundle);

		}

		// Refresh uninstalled runtime bundles if any
		if (models.isEmpty() == false) {
			refreshPackages(bundles.toArray(new Bundle[bundles.size()]));
			if (EGFCoreDebug.isDebugBundleSession()) {
				for (IPluginModelBase model : models) {
					EGFCorePlugin.getDefault().logInfo(NLS.bind("Runtime Bundle ''{0}'' is uninstalled.", BundleHelper.getBundleId(model))); //$NON-NLS-1$
				}
			}
		}

		return;

	}

	private List<IPluginModelBase> getWorkspaceModelDependencies(IPluginModelBase base) throws CoreException {
		List<IPluginModelBase> dependencies = new UniqueEList<IPluginModelBase>();
		// Store base
		dependencies.add(base);
		// Analyse base
		BundleDescription description = base.getBundleDescription();
		if (description == null) {
			return dependencies;
		}
		for (BundleSpecification requiredBundle : description.getRequiredBundles()) {
			for (IPluginModelBase workspaceModel : PluginRegistry.getWorkspaceModels()) {
				if (requiredBundle.isSatisfiedBy(workspaceModel.getBundleDescription())) {
					dependencies.addAll(getWorkspaceModelDependencies(workspaceModel));
					break;
				}
			}
		}
		for (ImportPackageSpecification importPackage : description.getImportPackages()) {
			for (IPluginModelBase workspaceModel : PluginRegistry.getWorkspaceModels()) {
				for (ExportPackageDescription export : workspaceModel.getBundleDescription().getExportPackages()) {
					if (importPackage.isSatisfiedBy(export)) {
						dependencies.addAll(getWorkspaceModelDependencies(workspaceModel));
						break;
					}
				}
			}
		}
		if (isRuntimeBundlePriority()) {
			for (IPluginModelBase innerBase : new ArrayList<IPluginModelBase>(dependencies)) {
				if (Platform.getBundle(innerBase.getBundleDescription().getSymbolicName()) != null) {
					dependencies.remove(innerBase);
				}
			}
		}
		return dependencies;
	}

	private void addContent(File folder, String path, String zipPath, List<String> outputFolders, ZipOutputStream out) throws IOException {
		int BUFFER = 1024;
		byte data[] = new byte[BUFFER];
		String subdirList[] = folder.list();
		for (String sd : subdirList) {
			File f = new File(folder, sd);
			String subPath = path.equals("") ? sd : path + "/" + sd;
			String subzipPath = zipPath.equals("") ? sd : zipPath + "/" + sd;
			if (f.isDirectory()) {
				if (outputFolders.contains(sd))
					subzipPath = zipPath;
				addContent(f, subPath, subzipPath, outputFolders, out);
			} else 
			{
				BufferedInputStream origin = new BufferedInputStream(new FileInputStream(f));
				ZipEntry entry = new ZipEntry(subzipPath);
				out.putNextEntry(entry);
				int count;
				while ((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				out.closeEntry();
				origin.close();
			}

		}
	}

	/**
	 * Installs the bundle corresponding to the given location. This will fail if the location doesn't point to a valid bundle.
	 * 
	 * @param location
	 *            Location of the bundle to be installed.
	 * @return The installed bundle.
	 * @throws BundleException
	 *             Thrown if the Bundle isn't valid.
	 * @throws IllegalStateException
	 *             Thrown if the bundle couldn't be installed properly.
	 */
	private Bundle doInstallBundle(IPluginModelBase workspaceModel) throws CoreException {
		Bundle bundle = null;
		String location = getLocation(workspaceModel);
		try {
			 ByteArrayOutputStream array = new ByteArrayOutputStream();
			ZipOutputStream out = new ZipOutputStream(array);
			IProject project = workspaceModel.getUnderlyingResource().getProject();
			if (project.hasNature(JavaCore.NATURE_ID))
			{
				IJavaProject jProject = JavaCore.create(project);
				List<String> outputFolders = JavaHelper.getStringOutputFolders(jProject);
				addContent(new File(project.getLocation().toPortableString()), "", "", outputFolders, out);
			out.close();
			array.flush();
			array.close();
			bundle = context.installBundle("ID->" + location, new ByteArrayInputStream(array.toByteArray()));
			}
			else

			bundle = context.installBundle(location);
		} catch (Throwable t) {
			throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_InstallationFailure, location), t));
		}
		// Not sure if it's needed, anyway we are conservative on that one
		if (bundle == null) {
			throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_InstallationFailure, location), null));
		}
		int state = bundle.getState();
		if (state != Bundle.INSTALLED) {
			throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_IllegalBundleState, bundle, state), null));
		}
		return bundle;
	}

    private Bundle installBundle(String location) throws CoreException {
        Bundle bundle = null;
        try {
            bundle = context.installBundle(location);
        } catch (Throwable t) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_InstallationFailure, location), t));
        }
        // Not sure if it's needed, anyway we are conservative on that one
        if (bundle == null) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_InstallationFailure, location), null));
        }
        int state = bundle.getState();
        if (state != Bundle.INSTALLED) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_IllegalBundleState, bundle, state), null));
        }
        return bundle;
    }

	/**
	 * Returns the bundle corresponding to the IProject if any.
	 * 
	 * @param id
	 *            The plug-in ID of the bundle we seek.
	 * @return The bundle corresponding to the given location if any, <code>null</code> otherwise.
	 */
	public Bundle getBundle(String id) throws CoreException {
		if (id == null || id.trim().length() == 0) {
			return null;
		}
		IPluginModelBase model = PluginRegistry.findModel(id.trim());
		if (model == null) {
			return null;
		}
		// Check if we face a non workspace model
		if (model.getUnderlyingResource() == null || isRuntimeBundlePriority()) {
			return Platform.getBundle(id.trim());
		}
		String location = getLocation(model);
		if (location == null) {
			return null;
		}
		// Workspace model
		Bundle bundle = projectBundles.get(location);
		if (bundle == null) {
			return installBundle(model);
		}
		return bundle;
	}

	/**
	 * Returns the bundle corresponding to the IProject if any.
	 * 
	 * @param project
	 *            The IProject of the bundle we seek.
	 * @return The bundle corresponding to the given location if any, <code>null</code> otherwise.
	 */
	public Bundle getBundle(IProject project) throws CoreException {
		if (project == null) {
			return null;
		}
		IPluginModelBase model = PluginRegistry.findModel(project);
		if (model == null) {
			return null;
		}
		if (isRuntimeBundlePriority()) {
			String id = BundleHelper.getBundleId(model);
			if (id != null) {
				Bundle bundle = Platform.getBundle(id);
				if (bundle != null) {
					return bundle;
				}
			}
		}
		String location = getLocation(model);
		if (location == null) {
			return null;
		}
		Bundle bundle = projectBundles.get(location);
		if (bundle == null) {
			bundle = installBundle(model);
		}
		return bundle;
	}

	/**
	 * Refreshes all exported packages of the given bundles. This must be called after installing the bundle.
	 * 
	 * @param bundles
	 *            Bundles which exported packages are to be refreshed.
	 */
	private void refreshPackages(Bundle[] bundles) throws CoreException {

		ServiceReference packageAdminReference = context.getServiceReference(PackageAdmin.class.getName());
		PackageAdmin packageAdmin = null;
		if (packageAdminReference != null) {
			packageAdmin = (PackageAdmin) context.getService(packageAdminReference);
		}

		if (packageAdmin == null) {
			return;
		}

		final ObjectHolder<Throwable> thrown = new ObjectHolder<Throwable>();

		final ObjectHolder<Boolean> loadCompleted = new ObjectHolder<Boolean>();
		// Listener
		FrameworkListener listener = new FrameworkListener() {

			public void frameworkEvent(FrameworkEvent event) {
				if (event.getType() == FrameworkEvent.PACKAGES_REFRESHED || event.getType() == FrameworkEvent.ERROR) {
					if (event.getType() == FrameworkEvent.ERROR) {
						thrown.object = event.getThrowable();
					}
					loadCompleted.object = Boolean.TRUE;
				} else if (event.getType() == FrameworkEvent.WARNING) {
					if (event.getThrowable() != null) {
						EGFCorePlugin.getDefault().logWarning(event.getThrowable());
					}
				}
			}

		};
		context.addFrameworkListener(listener);

		// Refresh packages
		packageAdmin.refreshPackages(bundles);

		int timeout = 20;
		try {
			while (loadCompleted.object == null && timeout-- > 0)
				Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		if (timeout < 0)
			EGFCorePlugin.getDefault().logWarning("Some bundles may not be fully loaded.");

		context.removeFrameworkListener(listener);
		context.ungetService(packageAdminReference);

		// Throw a CoreException
		if (thrown.object != null) {
			throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, EGFCoreMessages.ProjectBundleSession_PackageRefreshFailure, thrown.object));
		}

	}

	/**
	 * This can be used to uninstall all manually loaded bundles from the registry and remove all listeners. It will be called on plugin stopping and is not intended to be called by clients.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void dispose() throws CoreException {

		// shallow copy our bundle collector
		final List<Bundle> uninstalledBundles = new UniqueEList<Bundle>(uninstalled.size());

		// Uninstall workspace bundle
		if (projectBundles.isEmpty() == false || uninstalled.isEmpty() == false) {

			// Trace
			if (EGFCoreDebug.isDebugBundleSession()) {
				if (projectBundles.isEmpty() == false || uninstalled.isEmpty() == false) {
					EGFCorePlugin.getDefault().logInfo("Dispose ProjectBundleSession..."); //$NON-NLS-1$        
				}
			}

			// Uninstall workspace bundle
			if (projectBundles.isEmpty() == false) {
				for (Bundle bundle : projectBundles.values()) {
					uninstallBundle(bundle);
				}
				// Refresh Packages
				refreshPackages(projectBundles.values().toArray(new Bundle[projectBundles.size()]));
				// Tracing
				if (EGFCoreDebug.isDebugBundleSession()) {
					if (projectBundles.isEmpty() == false) {
						for (Bundle bundle : projectBundles.values()) {
							EGFCorePlugin.getDefault().logInfo(NLS.bind("Workspace Bundle ''{0}'' is uninstalled.", bundle.getSymbolicName()), 1); //$NON-NLS-1$
						}
					}
				}
			}

			// Install runtime bundle
			if (uninstalled.isEmpty() == false) {
                for (String location : uninstalled) {
                    uninstalledBundles.add(installBundle(location));
                }
				// Refresh Packages
				refreshPackages(uninstalledBundles.toArray(new Bundle[uninstalledBundles.size()]));
				// Tracing
				if (EGFCoreDebug.isDebugBundleSession()) {
					if (uninstalled.isEmpty() == false) {
						for (Bundle bundle : uninstalledBundles) {
							EGFCorePlugin.getDefault().logInfo(NLS.bind("Runtime Bundle ''{0}'' is installed.", bundle.getSymbolicName()), 1); //$NON-NLS-1$
						}
					}
				}
			}

		}

		// Final
		projectBundles.clear();
		uninstalled.clear();

	}

	/**
	 * Uninstall the given bundle from the context.
	 * 
	 * @param bundle
	 *            The bundle that is to be uninstalled.
	 * @throws CoreException
	 *             Thrown if a lifecycle issue arises.
	 */
	private void uninstallBundle(Bundle bundle) throws CoreException {
		try {
			bundle.uninstall();
		} catch (BundleException be) {
			throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_UninstallationFailure, bundle.getSymbolicName()), be));
		}
	}

	// TODO: not sure if we still need this support while we have now runtime
	// and target platform support
	private boolean isRuntimeBundlePriority() {
		if (runtimeBundlePriority == null) {
			String property = System.getProperty(EGF_TARGET_BUNDLE_PRIORITY);
			runtimeBundlePriority = Boolean.TRUE.toString().equals(property);
		}
		return runtimeBundlePriority;
	}

}
