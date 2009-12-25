/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.edit;

import org.eclipse.egf.common.activator.EGFEclipsePlugin;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Fcore edit plugin.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public final class EGFModelsEditPlugin extends EMFPlugin {
    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final EGFModelsEditPlugin INSTANCE = new EGFModelsEditPlugin();

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EGFModelsEditPlugin() {
        super(new ResourceLocator[] { EcoreEditPlugin.INSTANCE, });
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public static class Implementation extends EGFEclipsePlugin {

        /**
         * Creates an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated NOT
         */
        public Implementation() {
            super();
        }

        /**
         * <!-- begin-user-doc -->
         * 
         * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
         *      <!-- end-user-doc -->
         * @generated NOT
         */
        @Override
        public void start(BundleContext context_p) throws Exception {
            super.start(context_p);
            plugin = this;
        }

        /**
         * <!-- begin-user-doc -->
         * 
         * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
         *      <!-- end-user-doc -->
         * @generated NOT
         */
        @Override
        public void stop(BundleContext context_p) throws Exception {
            plugin = null;
            super.stop(context_p);
        }

    }

}
