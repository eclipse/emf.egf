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

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.platform.loader.BundleClassLoaderFactory;
import org.eclipse.egf.core.platform.loader.IBundleClassLoader;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

public class ContextLoaderWorkspaceBundle extends TestCase {

    private IPluginModelBase _h3;

    private IPluginModelBase _h2;

    public static Test suite() {
        return new TestSuite(ContextLoaderWorkspaceBundle.class);
    }

    @Override
    protected void setUp() throws Exception {

        // Setup project
        IProject h3 = ProjectHelper.getProject("org.eclipse.egf.example.task.h3"); //$NON-NLS-1$
        assertNotNull(h3);
        assertTrue(h3.exists());
        assertTrue(h3.isOpen());
        // Find model
        _h3 = PluginRegistry.findModel(h3);
        assertNotNull(_h3);

        // Setup project
        IProject h2 = ProjectHelper.getProject("org.eclipse.egf.example.task.h2"); //$NON-NLS-1$
        assertNotNull(h2);
        assertTrue(h2.exists());
        assertTrue(h2.isOpen());
        // Find model
        _h2 = PluginRegistry.findModel(h2);
        assertNotNull(_h2);

    }

    public void testLoadClassH3() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_h3);
        assertNotNull(loader);
        assertEquals(_h3.getUnderlyingResource().getProject(), loader.getProject());

        // Test Dependencies
        IProject[] dependencies = loader.getWorkspaceDependencies();
        assertTrue(dependencies != null && dependencies.length == 1);

        // Class
        Class<?> clazz = loader.loadClass("org.eclipse.egf.example.task.h3.H3"); //$NON-NLS-1$
        assertNotNull(clazz);

    }

    public void testLoadClassH2() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_h2);
        assertNotNull(loader);
        assertEquals(_h2.getUnderlyingResource().getProject(), loader.getProject());

        // Test Dependencies
        IProject[] dependencies = loader.getWorkspaceDependencies();
        assertTrue(dependencies != null && dependencies.length == 2);

        // Class
        Class<?> clazz = null;
        try {
            clazz = loader.loadClass("org.eclipse.egf.example.task.h3.H3"); //$NON-NLS-1$
        } catch (ClassNotFoundException cnfe) {
            // Just Ignore
        }
        assertNotNull(clazz);

    }

    public void testInstantiateEcoreEPackage() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_h3);
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

    public void testLoadClassJavaUtil() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_h3);
        assertNotNull(loader);

        // Class
        Class<?> clazz = loader.loadClass("java.util.ArrayList"); //$NON-NLS-1$
        assertNotNull(clazz);

    }

    public void testLoadResourceH3() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_h3);
        assertNotNull(loader);
        assertEquals(_h3.getUnderlyingResource().getProject(), loader.getProject());

        // Class
        Class<?> clazz = loader.loadClass("org.eclipse.egf.example.task.h3.H3"); //$NON-NLS-1$
        assertNotNull(clazz);

        // Load resource
        InputStream stream = clazz.getClassLoader().getResourceAsStream("task_h3.fcore"); //$NON-NLS-1$
        assertNull(stream);

        // Load resource            
        stream = clazz.getClassLoader().getResourceAsStream("egf/task_h3.fcore"); //$NON-NLS-1$
        assertNotNull(stream);

        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException ioe) {
            // Just ignore
        }

    }

    public void testLoadResourceH2() throws Exception {

        // Loader
        IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(_h2);
        assertNotNull(loader);
        assertEquals(_h2.getUnderlyingResource().getProject(), loader.getProject());

        // Class
        Class<?> clazz = loader.loadClass("org.eclipse.egf.example.task.h3.H3"); //$NON-NLS-1$
        assertNotNull(clazz);

        // Load resource from dependent h3
        InputStream stream = clazz.getClassLoader().getResourceAsStream("task_h3.fcore"); //$NON-NLS-1$
        assertNull(stream);

        // Load resource from dependent h3            
        stream = clazz.getClassLoader().getResourceAsStream("egf/task_h3.fcore"); //$NON-NLS-1$
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
