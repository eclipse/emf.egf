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
package org.eclipse.egf.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.uri.PlatformURIConverter;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCorePlugin extends EGFAbstractPlugin {

  public static String EDITING_DOMAIN_ID = "org.eclipse.egf.core.editing.domain"; //$NON-NLS-1$  

  public static String FCORE_EDITOR_ID = "org.eclipse.egf.model.fcore.tree.editor"; //$NON-NLS-1$

  /**
   * Plug-in unique instance.
   */
  private static EGFCorePlugin __plugin;

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
   * @return __plugin
   */
  public static EGFCorePlugin getDefault() {
    return __plugin;
  }

  /**
   * Returns a snapshot of known IPlatformFcore
   * 
   * @return an array of IPlatformFcore
   */
  public static PlatformURIConverter getPlatformURIConverter() {
    return PlatformURIConverter.getInstance();
  }

  /**
   * Get the IPlatformFcore for given EMF Resource.
   * 
   * @param resource
   * @return an {@link IPlatformFcore} instance or null if the
   *         resource is null or not associated with an
   *         IPlatformFcore
   */
  public static IPlatformFcore getPlatformFcore(Resource resource) {
    // a URI should be absolute, otherwise we are unable to analyse its
    // first segment
    if (resource == null || resource.getURI() == null || resource.getURI().isRelative()) {
      return null;
    }
    // Project Name
    String firstSegment = resource.getURI().segment(1);
    if (firstSegment == null || firstSegment.trim().length() == 0) {
      return null;
    }
    firstSegment = firstSegment.trim();
    // locate and return the first associated IPlatformFcore
    for (IPlatformFcore fcore : EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(firstSegment, IPlatformFcore.class)) {
      if (fcore.getURI().equals(resource.getURI())) {
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
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
    // The platform URI Converter should be initialized after the platform manager
    EGFPlatformPlugin.getPlatformManager();
    PlatformURIConverter.getInstance();
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    PlatformURIConverter.getInstance().dispose();
    __plugin = null;
    super.stop(context);
  }

}
