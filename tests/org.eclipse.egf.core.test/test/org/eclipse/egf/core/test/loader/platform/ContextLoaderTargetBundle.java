/**
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
 */
package org.eclipse.egf.core.test.loader.platform;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.egf.core.platform.loader.BundleClassLoaderFactory;
import org.eclipse.egf.core.platform.loader.IBundleClassLoader;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

public class ContextLoaderTargetBundle extends TestCase {

    private IPluginModelBase _codegenecore;

    private IPluginModelBase _ecore;

    public static Test suite() {
        return new TestSuite(ContextLoaderTargetBundle.class);
    }

    @Override
    protected void setUp() throws Exception {
        // Find codegenecore pde model
        _codegenecore = PluginRegistry.findModel("org.eclipse.emf.codegen.ecore"); //$NON-NLS-1$
        assertNotNull(_codegenecore);
        // Find ecore pde model
        _ecore = PluginRegistry.findModel("org.eclipse.emf.ecore"); //$NON-NLS-1$
        assertNotNull(_ecore);
    }

    public void testLoadClassEcore() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_ecore);
        assertNotNull(loader);

        // Class
        Class<?> clazz = loader.loadClass("org.eclipse.emf.ecore.plugin.EcorePlugin"); //$NON-NLS-1$
        assertNotNull(clazz);

    }

    public void testInstantiateEcoreEPackage() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_ecore);
        assertNotNull(loader);

        // Class
        Class<?> clazz = loader.loadClass("org.eclipse.emf.ecore.EcorePackage"); //$NON-NLS-1$
        assertNotNull(clazz);

        // Instantiate
        Object result = null;
        try {
            Field field = clazz.getField("eINSTANCE"); //$NON-NLS-1$
            result = field.get(null);
        } catch (Throwable t) {
            // Just ignore
        }
        assertNotNull(result);

    }

    public void testLoadClassCodeGenEcore() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_codegenecore);
        assertNotNull(loader);

        // Class
        Class<?> clazz = loader.loadClass("org.eclipse.emf.ecore.plugin.EcorePlugin"); //$NON-NLS-1$
        assertNotNull(clazz);

    }

    public void testLoadClassJavaUtil() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_codegenecore);
        assertNotNull(loader);

        // Class
        Class<?> clazz = loader.loadClass("java.util.ArrayList"); //$NON-NLS-1$
        assertNotNull(clazz);

    }

    public void testLoadResourceEcore() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_ecore);
        assertNotNull(loader);

        // Class
        Class<?> clazz = loader.loadClass("org.eclipse.emf.ecore.plugin.EcorePlugin"); //$NON-NLS-1$
        assertNotNull(clazz);

        // Load resource
        InputStream stream = clazz.getClassLoader().getResourceAsStream("Ecore.ecore"); //$NON-NLS-1$
        assertNull(stream);

        // Load resource            
        stream = clazz.getClassLoader().getResourceAsStream("model/Ecore.ecore"); //$NON-NLS-1$
        assertNotNull(stream);

        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException ioe) {
            // Just ignore
        }

    }

    public void testLoadResourceCodeGenEcore() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_codegenecore);
        assertNotNull(loader);

        // Class
        Class<?> clazz = loader.loadClass("org.eclipse.emf.ecore.plugin.EcorePlugin"); //$NON-NLS-1$
        assertNotNull(clazz);

        // Load resource
        InputStream stream = clazz.getClassLoader().getResourceAsStream("Ecore.ecore"); //$NON-NLS-1$
        assertNull(stream);

        // Load resource            
        stream = clazz.getClassLoader().getResourceAsStream("model/Ecore.ecore"); //$NON-NLS-1$
        assertNotNull(stream);

        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException ioe) {
            // Just ignore
        }

    }

}
