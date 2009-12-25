/*******************************************************************************
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.context.IProductionContextFactory;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.internal.context.ProductionContextFactory;
import org.eclipse.egf.core.internal.task.TaskRunnerFactory;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.task.IPlatformTask;
import org.eclipse.egf.core.task.ITaskRunnerFactory;
import org.eclipse.egf.core.type.IPlatformType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCorePlugin extends EGFAbstractPlugin {

  /**
   * Plug-in unique instance.
   */
  private static EGFCorePlugin __plugin;

  /**
   * IProductionContextFactory singleton.
   */
  private static final IProductionContextFactory __productionContextFactory = new ProductionContextFactory();

  /**
   * ITaskRunnerFactory singleton.
   */
  private static final ITaskRunnerFactory __taskRunnerFactory = new TaskRunnerFactory();

  /**
   * Constant identifying the job family identifier for a background build job.
   * All clients
   * that schedule background jobs for performing builds should include this job
   * family in their implementation of <code>belongsTo</code>.
   * 
   * @see IJobManager#join(Object, IProgressMonitor)
   * @see Job#belongsTo(Object)
   * @since 3.0
   */
  public static final Object FAMILY_MANUAL_BUILD = new Object();

  /**
   * Get activator shared instance.
   * 
   * @return
   */
  public static EGFCorePlugin getDefault() {
    return __plugin;
  }

  /**
   * Returns the singleton instance of the IProductionContextFactory.
   * 
   * @return the singleton production context factory.
   */
  public static IProductionContextFactory getProductionContextFactory() {
    return __productionContextFactory;
  }

  /**
   * Returns the singleton instance of the ITaskRunnerFactory.
   * 
   * @return the singleton task runner factory.
   */
  public static ITaskRunnerFactory getTaskRunnerFactory() {
    return __taskRunnerFactory;
  }

  /**
   * Computes a map so that plugins in the workspace will override those in
   * the environment and so that plugins with Ecore and GenModels will look
   * like projects in the workspace. It's implemented like this:
   * 
   * <pre>
   * Map result = new HashMap();
   * result.putAll(computePlatformPluginToPlatformResourceMap());
   * result.putAll(computePlatformResourceToPlatformPluginMap(new HashSet(EcorePlugin.getEPackageNsURIToGenModelLocationMap().values())));
   * return result;
   *</pre>
   * 
   * @return computes a map so that plugins in the workspace will override
   *         those in the environment and so that plugins with Ecore and
   *         GenModels will look like projects in the workspace.
   * @see org.eclipse.emf.ecore.resource.URIConverter#getURIMap()
   * @see URI
   * @see #computePlatformPluginToPlatformResourceMap()
   * @see #computePlatformResourceToPlatformPluginMap(Collection)
   */
  public static Map<URI, URI> computePlatformURIMap() {
    Map<URI, URI> result = new HashMap<URI, URI>();
    result.putAll(EcorePlugin.computePlatformURIMap());
    result.putAll(computePlatformPluginToPlatformResourceMap());
    result.putAll(computePlatformResourceToTargetPluginMap(getTargetPlatformFcores()));
    return result;
  }

  /**
   * Computes a map from <code>platform:/plugin/&lt;plugin-id>/</code>
   * {@link URI} to <code>platform:/resource/&lt;plugin-location>/</code> URI
   * for each plugin project in the workspace. This allows each plugin from
   * the runtime to be
   * {@link org.eclipse.emf.ecore.resource.URIConverter#getURIMap()
   * redirected} to its active version in the workspace.
   * 
   * @return a map from plugin URIs to resource URIs.
   * @see org.eclipse.emf.ecore.resource.URIConverter#getURIMap()
   * @see URI
   */
  public static Map<URI, URI> computePlatformPluginToPlatformResourceMap() {
    Map<URI, URI> result = new HashMap<URI, URI>();
    for (IPlatformFcore fc : getWorkspacePlatformFcores()) {
      URI platformPluginURI = URI.createPlatformPluginURI(fc.getPlatformBundle().getBundleId() + "/", false); //$NON-NLS-1$
      URI platformResourceURI = URI.createPlatformResourceURI(fc.getPlatformBundle().getProject().getName() + "/", true); //$NON-NLS-1$
      result.put(platformPluginURI, platformResourceURI);
    }
    return result;
  }

  /**
   * Computes a map from <code>platform:/resource/&lt;plugin-location>/</code>
   * {@link URI} to <code>platform:/plugin/&lt;plugin-id>/</code> URI for each
   * URI in the collection of the form
   * <code>platform:/plugin/&lt;plugin-id>/...</code>. This allows each plugin
   * to be {@link org.eclipse.emf.ecore.resource.URIConverter#getURIMap()
   * treated} as if it were a project in the workspace. If the workspace
   * already contains a project for the plugin location, no mapping is
   * produced.
   * 
   * @param fcores
   *          a collections of {@link IPlatformFcore}s.
   * @return a map from platform resource URI to platform plugin URI.
   */
  public static Map<URI, URI> computePlatformResourceToTargetPluginMap(IPlatformFcore[] fcores) {
    Map<URI, URI> result = new HashMap<URI, URI>();
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    if (root != null) {
      for (IPlatformFcore fc : fcores) {
        String pluginID = fc.getURI().segment(1);
        for (IProject project : root.getProjects()) {
          IPluginModelBase base = BundleHelper.getPluginModelBase(project);
          if (base != null && BundleHelper.getBundleId(base).equals(pluginID) && project.isOpen() == false) {
            result.put(URI.createPlatformResourceURI(pluginID + "/", false), URI.createPlatformPluginURI(pluginID + "/", false)); //$NON-NLS-1$ //$NON-NLS-2$
          }
        }
      }
    }
    return result;
  }

  /**
   * Get the IPlatformFcore for given EMF Resource.
   * 
   * @param resource_
   * @return an {@link IPlatformFcore} instance or null if the
   *         resource is null or not associated with an
   *         IPlatformFcore
   */
  public static IPlatformFcore getPlatformFcore(Resource resource_) {
    // a URI should be absolute, otherwise we are unable to analyse its
    // first segment
    if (resource_ == null || resource_.getURI() == null || resource_.getURI().isRelative()) {
      return null;
    }
    // Project Name
    String firstSegment = resource_.getURI().segment(1);
    if (firstSegment == null || firstSegment.trim().length() == 0) {
      return null;
    }
    firstSegment = firstSegment.trim();
    // locate and return the first associated IPlatformFcore
    for (IPlatformFcore fcore : EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(firstSegment, IPlatformFcore.class)) {
      if (fcore.getURI().equals(resource_.getURI())) {
        return fcore;
      }
    }
    // Nothing to retrieve
    return null;
  }

  /**
   * Get the IPlatformFcore[] for given project.
   * 
   */
  public static IPlatformFcore[] getPlatformFcores(IProject project) {
    return EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(project, IPlatformFcore.class);
  }

  /**
   * Returns a snapshot of known workspace IPlatformFcore
   * 
   * @return an array of IPlatformFcore
   */
  public static IPlatformFcore[] getWorkspacePlatformFcores() {
    return EGFPlatformPlugin.getPlatformManager().getWorkspacePlatformExtensionPoints(IPlatformFcore.class);
  }

  /**
   * Returns a snapshot of known target IPlatformFcore
   * 
   * @return an array of IPlatformFcore
   */
  public static IPlatformFcore[] getTargetPlatformFcores() {
    return EGFPlatformPlugin.getPlatformManager().getTargetPlatformExtensionPoints(IPlatformFcore.class);
  }

  /**
   * Returns a snapshot of known IPlatformFcore
   * 
   * @return an array of IPlatformFcore
   */
  public static IPlatformFcore[] getPlatformFcores() {
    return EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(IPlatformFcore.class);
  }

  /**
   * Get the IPlatformTask for given EMF Resource.
   * 
   * @param uri
   * @return an {@link IPlatformTask} instance or null if the
   *         uri is null or not associated with an
   *         IPlatformFcore
   */
  public static IPlatformTask getPlatformTask(String id) {
    if (id == null || id.trim().length() == 0) {
      return null;
    }
    // locate and return the first associated IPlatformTask
    for (IPlatformTask task : EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(IPlatformTask.class)) {
      if (task.getId().equals(id)) {
        return task;
      }
    }
    // Nothing to retrieve
    return null;
  }

  /**
   * Returns a snapshot of known IPlatformTask
   * 
   * @return an array of IPlatformTask
   */
  public static IPlatformTask[] getPlatformTasks() {
    return EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(IPlatformTask.class);
  }

  /**
   * Returns a snapshot of known IPlatformType
   * 
   * @return an array of IPlatformType
   */
  public static IPlatformType[] getPlatformTypes() {
    return EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(IPlatformType.class);
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    __plugin = null;
    super.stop(context);
  }

}