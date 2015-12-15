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
package org.eclipse.egf.core.test.loader.common;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.loader.IJavaClassLoader;
import org.eclipse.egf.common.loader.JavaClassLoaderFactory;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

public class ContextJavaLoaderCommon extends TestCase {

    private IProject _h3;

    private IProject _h2;

    public static Test suite() {
        return new TestSuite(ContextJavaLoaderCommon.class);
    }

    @Override
    protected void setUp() throws Exception {

        // Setup project
        IProject h3 = ProjectHelper.getProject("org.eclipse.egf.example.task.h3"); //$NON-NLS-1$
        assertNotNull(h3);
        assertTrue(h3.exists());
        assertTrue(h3.isOpen());
        _h3 = h3;

        // Setup project
        IProject h2 = ProjectHelper.getProject("org.eclipse.egf.example.task.h2"); //$NON-NLS-1$
        assertNotNull(h2);
        assertTrue(h2.exists());
        assertTrue(h2.isOpen());
        _h2 = h2;

    }

    public void testLoadClassH3() throws Exception {

        IJavaProject h3Project = null;

        try {

            // Test Project
            h3Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h3.getFullPath().toString()));
            assertNotNull(h3Project);
            assertTrue(h3Project.exists());
            if (h3Project.isOpen() == false) {
                h3Project.open(new NullProgressMonitor());
            }
            assertTrue(h3Project.isOpen());
            assertTrue(h3Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h3Project);
            assertNotNull(loader);
            assertEquals(h3Project, loader.getJavaProject());

            // Test Dependencies
            IJavaProject[] dependencies = loader.getWorkspaceDependencies();
            assertTrue(dependencies != null && dependencies.length == 1);

            // Load Java Project class
            Class<?> clazz = loader.loadClass("org.eclipse.egf.example.task.h3.H3"); //$NON-NLS-1$
            assertNotNull(clazz);

        } finally {

            if (h3Project != null) {
                h3Project.close();
            }

        }

    }

    public void testLoadClassH2() throws Exception {

        IJavaProject h2Project = null;

        try {

            // Test Project
            h2Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h2.getFullPath().toString()));
            assertNotNull(h2Project);
            assertTrue(h2Project.exists());
            if (h2Project.isOpen() == false) {
                h2Project.open(new NullProgressMonitor());
            }
            assertTrue(h2Project.isOpen());
            assertTrue(h2Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h2Project);
            assertNotNull(loader);
            assertEquals(h2Project, loader.getJavaProject());

            // Test Dependencies
            IJavaProject[] dependencies = loader.getWorkspaceDependencies();
            assertTrue(dependencies != null && dependencies.length == 1);

            // Load Java Project class from a dependent Java Project
            Class<?> clazz = null;
            try {
                clazz = loader.loadClass("org.eclipse.egf.example.task.h3.H3"); //$NON-NLS-1$
            } catch (ClassNotFoundException cnfe) {
                // Just Ignore
            }
            assertNull(clazz);

        } finally {

            if (h2Project != null) {
                h2Project.close();
            }

        }

    }

    public void testLoadClassH2WithParentBundle() throws Exception {

        IJavaProject h2Project = null;

        try {

            // Test Project
            h2Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h2.getFullPath().toString()));
            assertNotNull(h2Project);
            assertTrue(h2Project.exists());
            if (h2Project.isOpen() == false) {
                h2Project.open(new NullProgressMonitor());
            }
            assertTrue(h2Project.isOpen());
            assertTrue(h2Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h2Project, getClass().getClassLoader());
            assertNotNull(loader);
            assertEquals(h2Project, loader.getJavaProject());

            // Test Dependencies
            IJavaProject[] dependencies = loader.getWorkspaceDependencies();
            assertTrue(dependencies != null && dependencies.length == 1);

            // Load Java Project class from a dependent Java Project
            Class<?> clazz = null;
            try {
                clazz = loader.loadClass("org.eclipse.egf.example.task.h2.H2"); //$NON-NLS-1$
                clazz = loader.loadClass("org.eclipse.egf.common.ui.EGFCommonUIPlugin"); //$NON-NLS-1$
                clazz = loader.loadClass("junit.framework.Test"); //$NON-NLS-1$
            } catch (ClassNotFoundException e) {
            	fail(e.getLocalizedMessage());
            }

        } finally {

            if (h2Project != null) {
                h2Project.close();
            }

        }

    }

    public void testLoadClassJavaUtil() throws Exception {

        IJavaProject h3Project = null;

        try {

            // Test Project
            h3Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h3.getFullPath().toString()));
            assertNotNull(h3Project);
            assertTrue(h3Project.exists());
            if (h3Project.isOpen() == false) {
                h3Project.open(new NullProgressMonitor());
            }
            assertTrue(h3Project.isOpen());
            assertTrue(h3Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h3Project);
            assertNotNull(loader);

            // Test Dependencies
            IJavaProject[] dependencies = loader.getWorkspaceDependencies();
            assertTrue(dependencies != null && dependencies.length == 1);

            // Class
            Class<?> clazz = loader.loadClass("java.util.ArrayList"); //$NON-NLS-1$
            assertNotNull(clazz);

        } finally {

            if (h3Project != null) {
                h3Project.close();
            }

        }

    }

    public void testLoadResourceH3() throws Exception {

        IJavaProject h3Project = null;

        try {

            // Test Project
            h3Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h3.getFullPath().toString()));
            assertNotNull(h3Project);
            assertTrue(h3Project.exists());
            if (h3Project.isOpen() == false) {
                h3Project.open(new NullProgressMonitor());
            }
            assertTrue(h3Project.isOpen());
            assertTrue(h3Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h3Project);
            assertNotNull(loader);
            assertEquals(h3Project, loader.getJavaProject());

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

        } finally {

            if (h3Project != null) {
                h3Project.close();
            }

        }

    }

    public void testLoadResourceH2() throws Exception {

        IJavaProject h2Project = null;

        try {

            // Test Project
            h2Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h2.getFullPath().toString()));
            assertNotNull(h2Project);
            assertTrue(h2Project.exists());
            if (h2Project.isOpen() == false) {
                h2Project.open(new NullProgressMonitor());
            }
            assertTrue(h2Project.isOpen());
            assertTrue(h2Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h2Project);
            assertNotNull(loader);
            assertEquals(h2Project, loader.getJavaProject());

            // Class
            Class<?> clazz = loader.loadClass("org.eclipse.egf.example.task.h2.H2"); //$NON-NLS-1$
            assertNotNull(clazz);

            // Load resource
            InputStream stream = clazz.getClassLoader().getResourceAsStream("task_h3.fcore"); //$NON-NLS-1$
            assertNull(stream);

            // Load resource            
            stream = clazz.getClassLoader().getResourceAsStream("egf/task_h2.fcore"); //$NON-NLS-1$
            assertNotNull(stream);

            // Load resources from linked projects            
            try {
				Class<?> clazzH3 = loader.loadClass("org.eclipse.egf.example.task.h3.H3"); //$NON-NLS-1$
			} catch (Exception e) {
				fail(e.getLocalizedMessage());
			}
            stream = clazz.getClassLoader().getResourceAsStream("egf/task_h3.fcore"); //$NON-NLS-1$
            assertNotNull(stream);

            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException ioe) {
                // Just ignore
            }

        } finally {

            if (h2Project != null) {
                h2Project.close();
            }

        }

    }
}
