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
package org.eclipse.egf.core.platform.pde;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.osgi.framework.Bundle;

public interface IPlatformBundle {

    /**
     * Returns the current bundle id associated with IPlatformBundle
     * 
     * @return the current bundle id.
     */
    public String getBundleId();

    /**
     * Returns the initial bundle id associated with IPlatformBundle.
     * useful when the symbolic name has changed in the manifest file.
     * 
     * @return the initial bundle id.
     */
    public String getPreviousBundleId();

    /**
     * Returns an IProject if this IPlatformBundle is a workspace bundle.
     * 
     * @return an IProject if this IPlatformBundle is a workspace project,
     *         or <code>null</code> if this IPlatformBundle is a runtime or a target bundle.
     * 
     */
    public IProject getProject();

    /**
     * Returns a Bundle if this IPlatformBundle is a runtime bundle.
     * 
     * @return a Bundle if this IPlatformBundle is a target bundle,
     *         or <code>null</code> if this IPlatformBundle is a workspace one.
     * 
     */
    public Bundle getBundle();

    /**
     * PDE model associated with IPlatformBundle if any
     * 
     * @return all plug-ins and (possibly) fragments in the workspace as well as
     *         all plug-ins and
     *         (possibly) fragments that are checked on the Target Platform
     *         preference page.
     */
    public IPluginModelBase getPluginModelBase();

    /**
     * Tests if this IPlatformBundle is for the plug-in fragment.
     * 
     * @return <code>true</code> if the model is for the fragment,
     *         <code>false</code> otherwise.
     */
    public boolean isFragment();

    /**
     * Whether or not this IPlatformBundle is a target IPlatformBundle.
     * 
     * @return true if this IPlatformBundle is a target bundle,
     *         false if this IPlatformBundle is a workspace bundle.
     * 
     */
    public boolean isTarget();

    /**
     * Whether or not this IPlatformBundle is a workspace IPlatformBundle.
     * 
     * @return true if this IPlatformBundle is a target bundle,
     * false otherwise
     * 
     */
    public boolean isWorkspace();

    /**
     * Whether or not this IPlatformBundle is a runtime IPlatformBundle.
     * 
     * @return true if this IPlatformBundle is a runtime bundle,
     * false otherwise
     * 
     */
    public boolean isRuntime();

    /**
     * Whether or not this IPlatformBundle has managed extension points
     * 
     * @return true if this IPlatformBundle has managed extension points
     *         false otherwise.
     * 
     */
    public boolean isEmpty();

    /**
     * The install location string for this IPlatformBundle.
     * 
     * @return the install location
     */
    public String getInstallLocation();

    /**
     * The Rooted URI of this IPlatformBundle.
     * 
     * @return URI
     */
    public URI getRootedBase();

    /**
     * The Unrooted URI of this IPlatformBundle.
     * 
     * @return URI
     */
    public URI getUnrootedBase();

    public IPlatformExtensionPoint[] getPlatformExtensionPoints();

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz);

    public boolean hasPlatformExtensionPoint(IPlatformExtensionPoint platformExtensionPoint);

    public boolean hasPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint platformExtensionPoint);

}
