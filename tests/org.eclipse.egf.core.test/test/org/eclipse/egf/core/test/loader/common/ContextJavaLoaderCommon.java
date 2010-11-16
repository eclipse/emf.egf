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

    private IProject _h1;

    private IProject _h2;

    public static Test suite() {
        return new TestSuite(ContextJavaLoaderCommon.class);
    }

    @Override
    protected void setUp() throws Exception {

        // Setup project
        IProject h1 = ProjectHelper.getProject("org.eclipse.egf.example.task.h1"); //$NON-NLS-1$
        assertNotNull(h1);
        assertTrue(h1.exists());
        // Open it if necessary
        if (h1.isOpen() == false) {
            h1.open(new NullProgressMonitor());
        }
        assertTrue(h1.isOpen());
        _h1 = h1;
        // Setup project
        IProject h2 = ProjectHelper.getProject("org.eclipse.egf.example.task.h2"); //$NON-NLS-1$
        assertNotNull(h2);
        assertTrue(h2.exists());
        // Open it if necessary
        if (h2.isOpen() == false) {
            h2.open(new NullProgressMonitor());
        }
        assertTrue(h2.isOpen());
        _h2 = h2;

    }

    public void testLoadClassH1() throws Exception {

        IJavaProject h1Project = null;

        try {

            // Test Project
            h1Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h1.getFullPath().toString()));
            assertNotNull(h1Project);
            assertTrue(h1Project.exists());
            if (h1Project.isOpen() == false) {
                h1Project.open(new NullProgressMonitor());
            }
            assertTrue(h1Project.isOpen());
            assertTrue(h1Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h1Project);
            assertNotNull(loader);
            assertEquals(h1Project, loader.getJavaProject());

            // Test Dependencies
            IJavaProject[] dependencies = loader.getWorkspaceDependencies();
            assertTrue(dependencies != null && dependencies.length == 1);

            // Load Java Project class
            Class<?> clazz = loader.loadClass("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
            assertNotNull(clazz);

        } finally {

            if (h1Project != null) {
                h1Project.close();
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
                clazz = loader.loadClass("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
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
                clazz = loader.loadClass("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
            } catch (ClassNotFoundException cnfe) {
                // Just Ignore
            }
            assertNotNull(clazz);

        } finally {

            if (h2Project != null) {
                h2Project.close();
            }

        }

    }

    public void testLoadClassJavaUtil() throws Exception {

        IJavaProject h1Project = null;

        try {

            // Test Project
            h1Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h1.getFullPath().toString()));
            assertNotNull(h1Project);
            assertTrue(h1Project.exists());
            if (h1Project.isOpen() == false) {
                h1Project.open(new NullProgressMonitor());
            }
            assertTrue(h1Project.isOpen());
            assertTrue(h1Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h1Project);
            assertNotNull(loader);

            // Test Dependencies
            IJavaProject[] dependencies = loader.getWorkspaceDependencies();
            assertTrue(dependencies != null && dependencies.length == 1);

            // Class
            Class<?> clazz = loader.loadClass("java.util.ArrayList"); //$NON-NLS-1$
            assertNotNull(clazz);

        } finally {

            if (h1Project != null) {
                h1Project.close();
            }

        }

    }

    public void testLoadResourceH1() throws Exception {

        IJavaProject h1Project = null;

        try {

            // Test Project
            h1Project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot().getProject(_h1.getFullPath().toString()));
            assertNotNull(h1Project);
            assertTrue(h1Project.exists());
            if (h1Project.isOpen() == false) {
                h1Project.open(new NullProgressMonitor());
            }
            assertTrue(h1Project.isOpen());
            assertTrue(h1Project.isConsistent());

            // Test JavaProject
            IJavaClassLoader loader = JavaClassLoaderFactory.getJavaClassLoader(h1Project);
            assertNotNull(loader);
            assertEquals(h1Project, loader.getJavaProject());

            // Class
            Class<?> clazz = loader.loadClass("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
            assertNotNull(clazz);

            // Load resource
            InputStream stream = clazz.getClassLoader().getResourceAsStream("task_h1.fcore"); //$NON-NLS-1$
            assertNull(stream);

            // Load resource            
            stream = clazz.getClassLoader().getResourceAsStream("egf/task_h1.fcore"); //$NON-NLS-1$
            assertNotNull(stream);

            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException ioe) {
                // Just ignore
            }

        } finally {

            if (h1Project != null) {
                h1Project.close();
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
            InputStream stream = clazz.getClassLoader().getResourceAsStream("task_h1.fcore"); //$NON-NLS-1$
            assertNull(stream);

            // Load resource            
            stream = clazz.getClassLoader().getResourceAsStream("egf/task_h1.fcore"); //$NON-NLS-1$
            assertNull(stream);

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
