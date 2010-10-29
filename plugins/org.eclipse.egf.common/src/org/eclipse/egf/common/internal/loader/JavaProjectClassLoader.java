/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.internal.loader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.loader.IJavaClassLoader;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IJavaProject;

/**
 * @author Xavier Maysonnave
 *
 */
public class JavaProjectClassLoader extends URLClassLoader implements IJavaClassLoader {

    private IJavaProject _project;

    private List<IJavaProject> _dependencies;

    public JavaProjectClassLoader(final IJavaProject project, final URL[] urls, final ClassLoader parent) {
        super(urls, parent);
        _project = project;
        _dependencies = new UniqueEList<IJavaProject>();
    }

    public JavaProjectClassLoader(final IJavaProject project, final List<IJavaProject> dependencies, final URL[] urls, final ClassLoader parent) {
        super(urls, parent);
        _project = project;
        _dependencies = dependencies != null ? dependencies : new UniqueEList<IJavaProject>();
    }

    public IJavaProject getJavaProject() {
        return _project;
    }

    public IProject getProject() {
        return _project.getProject();
    }

    public IJavaProject[] getWorkspaceDependencies() throws CoreException {
        return _dependencies.toArray(new IJavaProject[_dependencies.size()]);
    }

    @Override
    public URL[] getURLs() {
        return super.getURLs();
    }

    @Override
    public URL findResource(String name) {
        if ((name.length() > 1) && (name.charAt(0) == '/')) { /* if name has a leading slash */
            name = name.substring(1); /* remove leading slash before search */
        }
        return super.findResource(name);
    }

    public ClassLoader getParentClassLoader() {
        return getParent();
    }

    @Override
    public synchronized Class<?> findClass(String name) throws ClassNotFoundException {
        // see java.lang.ClassLoader#preDefineClass(String name, ProtectionDomain protectionDomain)
        if ((name != null) && name.startsWith("java.")) { //$NON-NLS-1$
            return Class.forName(name, true, this);
        }
        // First check if we have permission to access the package. This
        // should go away once we've added support for exported packages.
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            int i = name.lastIndexOf('.');
            if (i != -1) {
                sm.checkPackageAccess(name.substring(0, i));
            }
        }
        return super.findClass(name);
    }

}
