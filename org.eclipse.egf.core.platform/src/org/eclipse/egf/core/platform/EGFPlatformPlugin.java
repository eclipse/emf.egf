/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Thales Corporate Services S.A.S
 */

package org.eclipse.egf.core.platform;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.platform.internal.pde.PlatformManager;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponentListener;
import org.eclipse.egf.core.platform.pde.IPlatformPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.osgi.framework.BundleContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFPlatformPlugin extends EGFAbstractPlugin {

    private static EGFPlatformPlugin _plugin;

    /**
     * Get the IPlatformFactoryComponent for given EMF Resource.
     * 
     * @param resource_p
     * @return an {@link IPlatformFactoryComponent} instance or null if the
     *         resource is null or not associated with an
     *         IPlatformFactoryComponent
     */
    public static IPlatformFactoryComponent getPlatformFactoryComponent(Resource resource_p) {
        // a URI should be absolute, otherwise we are unable to analyse its
        // first
        // segment
        if (resource_p == null || resource_p.getURI() == null || resource_p.getURI().isRelative()) {
            return null;
        }
        // Project Name
        String firstSegment = resource_p.getURI().segment(1);
        if (firstSegment == null || firstSegment.trim().length() == 0) {
            return null;
        }
        // Retrieve a workspace project if available, its is safe as our
        // implementation always hide a target project if a workspace project is
        // available. The idea here is to locate a bundle based on its name
        // rather
        // on its project name
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(firstSegment.trim());
        IPlatformPlugin platform = null;
        if (project != null)
            platform = getPlatform(project);
        // if no IPlatformPlugin is available, locate an IPlatformPlugin based
        // on
        // firstSegment
        if (platform == null) {
            platform = PlatformManager.getInstance().getPlatformPlugin(firstSegment.trim());
        }
        // Nothing to process
        if (platform == null) {
            return null;
        }
        // Finally try to locate an associated IPlatformFactoryComponent
        for (IPlatformFactoryComponent fc : platform.getPlatformFactoryComponents()) {
            if (fc.getURI().equals(resource_p.getURI())) {
                return fc;
            }
        }
        // Nothing to retrieve
        return null;
    }

    /**
     * Get the IPlatformFactoryComponents for given project.
     * 
     */
    public static IPlatformFactoryComponent[] getPlatformFactoryComponents(IProject project) {
        IPlatformPlugin platform = getPlatform(project);
        if (platform == null)
            return new IPlatformFactoryComponent[0];
        return platform.getPlatformFactoryComponents();
    }

    private static IPlatformPlugin getPlatform(IProject project) {
        IPluginModelBase base = BundleHelper.getPluginModelBase(project);
        String id = BundleHelper.getBundleId(base);
        if (id == null)
            return null;
        return PlatformManager.getInstance().getPlatformPlugin(id);
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
        result.putAll(computePlatformPluginToPlatformResourceMap());
        result.putAll(computePlatformResourceToTargetPluginMap(getDefault().getTargetPluginFactoryComponents()));
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
        for (IPlatformFactoryComponent fc : getDefault().getWorkspacePluginFactoryComponents()) {
            URI platformPluginURI = URI.createPlatformPluginURI(fc.getPlatformPlugin().getBundleId() + "/", false);
            URI platformResourceURI = URI.createPlatformResourceURI(fc.getPlatformPlugin().getProject().getName() + "/", true);
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
     * @param uris
     *            a collections of {@link URI}s.
     * @return a map from platform resource URI to platform plugin URI.
     */
    public static Map<URI, URI> computePlatformResourceToTargetPluginMap(IPlatformFactoryComponent[] fcs) {
        Map<URI, URI> result = new HashMap<URI, URI>();
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        if (root != null) {
            for (IPlatformFactoryComponent fc : fcs) {
                String pluginID = fc.getURI().segment(1);
                for (IProject project : root.getProjects()) {
                    IPluginModelBase base = BundleHelper.getPluginModelBase(project);
                    if (base != null && BundleHelper.getBundleId(base).equals(pluginID) && project.isOpen() == false) {
                        result.put(URI.createPlatformResourceURI(pluginID + "/", false), URI.createPlatformPluginURI(pluginID + "/", false));
                    }
                }
            }
        }
        return result;
    }

    /**
     * The constructor
     */
    public EGFPlatformPlugin() {
        super();
    }

    /**
     * Add a listener to the platform manager
     * 
     * @param listener
     *            the listener to be added
     */
    public void addPlatformFactoryComponentListener(IPlatformFactoryComponentListener listener) {
        PlatformManager.getInstance().addPlatformFactoryComponentListener(listener);
    }

    /**
     * Remove a listener from the platform manager
     * 
     * @param listener
     *            the listener to be removed
     */
    public void removePlatformFactoryComponentListener(IPlatformFactoryComponentListener listener) {
        PlatformManager.getInstance().removePlatformFactoryComponentListener(listener);
    }

    /**
     * Returns a snapshot of known workspace IPlatformPluginFactoryComponent
     * 
     * @return an array of IPlatformPluginFactoryComponent
     */
    public IPlatformFactoryComponent[] getWorkspacePluginFactoryComponents() {
        return PlatformManager.getInstance().getWorkspaceFactoryComponents();
    }

    /**
     * Returns a snapshot of known target IPlatformPluginFactoryComponent
     * 
     * @return an array of IPlatformPluginFactoryComponent
     */
    public IPlatformFactoryComponent[] getTargetPluginFactoryComponents() {
        return PlatformManager.getInstance().getWorkspaceFactoryComponents();
    }

    /**
     * Returns a snapshot of known IPlatformPluginFactoryComponent
     * 
     * @return an array of IPlatformPluginFactoryComponent
     */
    public IPlatformFactoryComponent[] getFactoryComponents() {
        return PlatformManager.getInstance().getFactoryComponents();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        _plugin = this;
        // Start our PlatformManager and force initialization
        getWorkspacePluginFactoryComponents();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        // Stop our PlatformManager
        PlatformManager.getInstance().dispose();
        // Final steps
        _plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static EGFPlatformPlugin getDefault() {
        return _plugin;
    }

}
