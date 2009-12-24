/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.pattern.ecore.EPackageListener;
import org.eclipse.egf.pattern.ecore.RegistryReader;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Guiu
 */
public class Activator extends EGFAbstractPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.egf.pattern";

    // The shared instance
    private static Activator plugin;

    private final EPackageListener resourceListener = new EPackageListener();

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        // set up ecore model registry with workspace models
        new RegistryReader().load();
        ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    public void stop(BundleContext context) throws Exception {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

}
