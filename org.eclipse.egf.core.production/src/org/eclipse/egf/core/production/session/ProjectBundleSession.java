/**
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Obeo - initial API and implementation
 * Inspired from
 * org.eclipse.acceleo.common.internal.utils.workspace.AcceleoWorkspaceUtil
 */
package org.eclipse.egf.core.production.session;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.production.EGFCoreProductionPlugin;
import org.eclipse.egf.core.production.l10n.CoreProductionMessages;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.framework.internal.core.AbstractBundle;
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
public class ProjectBundleSession {

  private BundleContext _context;

  private Map<IPluginModelBase, Bundle> _projectBundles = new HashMap<IPluginModelBase, Bundle>();

  private List<Bundle> _uninstalled = new ArrayList<Bundle>();

  public ProjectBundleSession(BundleContext context) {
    Assert.isNotNull(context);
    _context = context;
  }

  public BundleContext getBundleContext() {
    return _context;
  }

  /**
   * Installs the bundle corresponding to the model.
   * 
   * @param model
   *          Model of the bundle to be installed.
   */
  private Bundle installBundle(IPluginModelBase base) throws CoreException {
    List<Bundle> bundles = new ArrayList<Bundle>();
    Bundle uninstalled = checkTargetBundle(base);
    if (uninstalled != null) {
      bundles.add(uninstalled);
    }
    IResource manifest = base.getUnderlyingResource();
    Bundle bundle = null;
    String location = null;
    try {
      location = "reference:" //$NON-NLS-1$
          + URLDecoder.decode(manifest.getProject().getLocationURI().toURL().toExternalForm(), System.getProperty("file.encoding")); //$NON-NLS-1$
      bundle = getBundle(location);
    } catch (Throwable t) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_URLFailure, manifest.getProject().getName()), t));
    }
    // Install the bundle if needed
    if (bundle == null) {
      checkDependencies(base);
      bundle = installBundle(location);
      IProject project = base.getUnderlyingResource().getProject();
      setBundleClasspath(project, bundle);
      _projectBundles.put(base, bundle);
      bundles.add(bundle);
    }
    refreshPackages(bundles.toArray(new Bundle[bundles.size()]));
    if (EGFCoreProductionPlugin.getDefault().isDebugging()) {
      EGFCoreProductionPlugin.getDefault().logInfo(NLS.bind("Workspace Bundle ''{0}'' is installed.", bundle.getSymbolicName())); //$NON-NLS-1$
    }
    return bundle;
  }

  private Bundle checkTargetBundle(IPluginModelBase base) throws CoreException {
    Bundle bundle = Platform.getBundle(BundleHelper.getBundleId(base));
    if (bundle == null) {
      return null;
    }
    if ((bundle.getState() & (Bundle.ACTIVE | Bundle.STARTING)) != 0) {
      try {
        bundle.stop();
      } catch (Throwable t) {
        throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_StoppingFailure, bundle.getSymbolicName()), t));
      }
    }
    if ((bundle.getState() & (Bundle.INSTALLED | Bundle.RESOLVED)) != 0) {
      try {
        bundle.uninstall();
      } catch (Throwable t) {
        throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_UninstallationFailure, bundle.getSymbolicName()), t));
      }
    }
    _uninstalled.add(bundle);
    if (EGFCoreProductionPlugin.getDefault().isDebugging()) {
      EGFCoreProductionPlugin.getDefault().logInfo(NLS.bind("Target Bundle ''{0}'' is uninstalled.", bundle.getSymbolicName())); //$NON-NLS-1$
    }
    return bundle;
  }

  /**
   * This will check through the dependencies of <code>model</code> and install
   * the necessary workspace
   * plugins if they are either required or imported.
   * 
   * @param model
   *          The model we wish the dependencies checked of.
   */
  private void checkDependencies(IPluginModelBase base) throws CoreException {
    final BundleDescription description = base.getBundleDescription();
    if (description == null) {
      return;
    }
    for (BundleSpecification requiredBundle : description.getRequiredBundles()) {
      for (IPluginModelBase workspaceModel : PluginRegistry.getWorkspaceModels()) {
        if (requiredBundle.isSatisfiedBy(workspaceModel.getBundleDescription())) {
          installBundle(workspaceModel);
          break;
        }
      }
    }
    for (ImportPackageSpecification importPackage : description.getImportPackages()) {
      for (IPluginModelBase workspaceModel : PluginRegistry.getWorkspaceModels()) {
        for (ExportPackageDescription export : workspaceModel.getBundleDescription().getExportPackages()) {
          if (importPackage.isSatisfiedBy(export)) {
            installBundle(workspaceModel);
            break;
          }
        }
      }
    }
  }

  /**
   * Installs the bundle corresponding to the given location. This will fail if
   * the location doesn't point
   * to a valid bundle.
   * 
   * @param pluginLocation
   *          Location of the bundle to be installed.
   * @return The installed bundle.
   * @throws BundleException
   *           Thrown if the Bundle isn't valid.
   * @throws IllegalStateException
   *           Thrown if the bundle couldn't be installed properly.
   */
  private Bundle installBundle(String pluginLocation) throws CoreException {
    Bundle target = null;
    try {
      target = _context.installBundle(pluginLocation);
    } catch (Throwable t) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_InstallationFailure, pluginLocation), t));
    }
    // Not sure if it's needed, anyway we are conservative on that one
    if (target == null) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_InstallationFailure, pluginLocation), null));
    }
    int state = target.getState();
    if (state != Bundle.INSTALLED) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_IllegalBundleState, target, state), null));
    }
    return target;
  }

  /**
   * This will install or refresh the given workspace contribution if needed,
   * then search through it for a
   * class corresponding to <code>qualifiedName</code>.
   * 
   * @param project
   *          The project that is to be dynamically installed.
   * @param qualifiedName
   *          The qualified name of the class to load.
   * @return An instance of the class <code>qualifiedName</code> if it could be
   *         found <code>null</code> otherwise.
   */
  public Class<?> getClass(IProject project, String qualifiedName) throws CoreException {
    Bundle bundle = getBundle(project);
    if (bundle != null) {
      try {
        return bundle.loadClass(qualifiedName);
      } catch (ClassNotFoundException cnfe) {
        throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_LoadFailure, qualifiedName, bundle.getSymbolicName()), cnfe));
      }
    }
    return null;
  }

  /**
   * This will set the equinox classpath of <code>bundle</code> to reflect the
   * eclipse classpath of
   * <code>plugin</code>.
   * 
   * @param plugin
   *          The eclipse plugin which classpath is to be set for its
   *          corresponding equinox bundle.
   * @param bundle
   *          The equinox bundle which classpath is to reflect an eclipse
   *          development plugin.
   */
  private void setBundleClasspath(IProject plugin, Bundle bundle) throws CoreException {
    Set<String> classpathEntries = getOutputFolders(plugin);
    BaseData bundleData = (BaseData) ((AbstractBundle) bundle).getBundleData();
    if (classpathEntries.size() == 1) {
      bundleData.setClassPathString(classpathEntries.iterator().next());
    } else {
      StringBuilder classpath = new StringBuilder();
      Iterator<String> entryIterator = classpathEntries.iterator();
      while (entryIterator.hasNext()) {
        classpath.append(entryIterator.next());
        if (entryIterator.hasNext()) {
          classpath.append(',');
        }
      }
      bundleData.setClassPathString(classpath.toString());
    }
  }

  /**
   * This will return the set of output folders name for the given
   * project.
   * <p>
   * For example, if a project has a source folder "src" with its output folder
   * set as "bin" and a source
   * folder "src-gen" with its output folder set as "bin-gen", this will return
   * a LinkedHashSet containing
   * both "bin" and "bin-gen".
   * </p>
   * 
   * @param project
   *          The project we seek the output folders of.
   * @return The set of output folders name for the given (java) project.
   */
  private Set<String> getOutputFolders(IProject project) throws CoreException {
    Set<String> classpathEntries = new LinkedHashSet<String>();
    IJavaProject javaProject = JavaCore.create(project);
    if (javaProject.exists() == false) {
      return classpathEntries;
    }
    try {
      for (IClasspathEntry entry : javaProject.getResolvedClasspath(true)) {
        if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
          IPath output = entry.getOutputLocation();
          if (output != null) {
            classpathEntries.add(output.removeFirstSegments(1).toString());
          }
        }
      }
      classpathEntries.add(javaProject.getOutputLocation().removeFirstSegments(1).toString());
    } catch (Throwable t) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_AnalysingFailure, project.getName()), t));
    }
    return classpathEntries;
  }

  /**
   * Returns the bundle corresponding to the given location if any.
   * 
   * @param pluginLocation
   *          The location of the bundle we seek.
   * @return The bundle corresponding to the given location if any,
   *         <code>null</code> otherwise.
   */
  private Bundle getBundle(String pluginLocation) {
    Bundle[] bundles = _context.getBundles();
    for (int i = 0; i < bundles.length; i++) {
      if (pluginLocation.equals(bundles[i].getLocation())) {
        return bundles[i];
      }
    }
    return null;
  }

  /**
   * Returns the bundle corresponding to the IProject if any.
   * 
   * @param project
   *          The IProject of the bundle we seek.
   * @return The bundle corresponding to the given location if any,
   *         <code>null</code> otherwise.
   */
  public Bundle getBundle(IProject project) throws CoreException {
    IPluginModelBase model = PluginRegistry.findModel(project);
    if (model == null) {
      return null;
    }
    Bundle bundle = _projectBundles.get(model);
    if (bundle == null) {
      return installBundle(model);
    }
    return null;
  }

  /**
   * Refreshes all exported packages of the given bundles. This must be called
   * after installing the bundle.
   * 
   * @param bundles
   *          Bundles which exported packages are to be refreshed.
   */
  public void refreshPackages(Bundle[] bundles) {
    ServiceReference packageAdminReference = _context.getServiceReference(PackageAdmin.class.getName());
    PackageAdmin packageAdmin = null;
    if (packageAdminReference != null) {
      packageAdmin = (PackageAdmin) _context.getService(packageAdminReference);
    }
    if (packageAdmin != null) {
      final boolean[] flag = new boolean[] { false };
      FrameworkListener listener = new FrameworkListener() {
        public void frameworkEvent(FrameworkEvent event) {
          if (event.getType() == FrameworkEvent.PACKAGES_REFRESHED) {
            synchronized (flag) {
              flag[0] = true;
              flag.notifyAll();
            }
          }
        }
      };
      _context.addFrameworkListener(listener);
      packageAdmin.refreshPackages(bundles);
      synchronized (flag) {
        while (flag[0] == false) {
          try {
            flag.wait();
          } catch (InterruptedException e) {
            break;
          }
        }
      }
      _context.removeFrameworkListener(listener);
      _context.ungetService(packageAdminReference);
    }
  }

  /**
   * This can be used to uninstall all manually loaded bundles from the registry
   * and remove all listeners.
   * It will be called on plugin stopping and is not intended to be called by
   * clients.
   * 
   * @noreference This method is not intended to be referenced by clients.
   */
  public void dispose() throws CoreException {
    // Clean workspace bundled
    for (Map.Entry<IPluginModelBase, Bundle> entry : _projectBundles.entrySet()) {
      Bundle bundle = entry.getValue();
      try {
        uninstallBundle(bundle);
        if (EGFCoreProductionPlugin.getDefault().isDebugging()) {
          EGFCoreProductionPlugin.getDefault().logInfo(NLS.bind("Workspace Bundle ''{0}'' is uninstalled.", bundle.getSymbolicName())); //$NON-NLS-1$
        }
      } catch (BundleException be) {
        throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(CoreProductionMessages.ProjectBundleSession_UninstallationFailure, bundle.getSymbolicName()), be));
      }
    }
    // Install uninstalled bundles
    for (Bundle bundle : _uninstalled) {
      Bundle installed = installBundle(bundle.getLocation());
      refreshPackages(new Bundle[] { installed });
      if (EGFCoreProductionPlugin.getDefault().isDebugging()) {
        EGFCoreProductionPlugin.getDefault().logInfo(NLS.bind("Target Bundle ''{0}'' is installed.", installed.getSymbolicName())); //$NON-NLS-1$
      }
    }
    // Final
    _projectBundles.clear();
    _uninstalled.clear();
  }

  /**
   * Uninstalls the given bundle from the context.
   * 
   * @param target
   *          The bundle that is to be uninstalled.
   * @throws BundleException
   *           Thrown if a lifecycle issue arises.
   */
  private void uninstallBundle(Bundle target) throws BundleException {
    target.uninstall();
    refreshPackages(null);
  }

}
