/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model;

import org.eclipse.egf.common.activator.EGFEclipsePlugin;
import org.eclipse.egf.model.ftask.internal.registry.TaskNatureRegistry;
import org.eclipse.egf.model.ftask.task.ITaskNatureRegistry;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Ftask model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class EGFFtaskPlugin extends EMFPlugin {

    /**
     * Keep track of the TaskNatureRegistry
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    private static TaskNatureRegistry __taskNatureRegistry;

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EGFFtaskPlugin INSTANCE = new EGFFtaskPlugin();

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EGFFtaskPlugin() {
        super(new ResourceLocator[] {});
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the TaskNatureRegistry
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the singleton instance.
     * @generated NOT
     */
    public static ITaskNatureRegistry getTaskNatureRegistry() {
        if (__taskNatureRegistry == null) {
            __taskNatureRegistry = new TaskNatureRegistry();
        }
        return __taskNatureRegistry;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class Implementation extends EGFEclipsePlugin {

        /**
         * Creates an instance.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Implementation() {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }

        /**
         * Stop the bundle
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated NOT
         */
        @Override
        public void stop(BundleContext context) throws Exception {
            if (__taskNatureRegistry != null) {
                __taskNatureRegistry.dispose();
                __taskNatureRegistry = null;
            }
            super.stop(context);
            plugin = null;
        }

    }

}
