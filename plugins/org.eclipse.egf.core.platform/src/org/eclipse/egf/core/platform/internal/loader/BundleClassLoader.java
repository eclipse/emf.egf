/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.platform.internal.loader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.core.platform.loader.IBundleClassLoader;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @author Xavier Maysonnave
 *
 */
public class BundleClassLoader extends URLClassLoader implements IBundleClassLoader {

    private IPluginModelBase _model;

    private IProject _project;

    private List<IProject> _dependencies;

    public BundleClassLoader(final IPluginModelBase model, final URL[] urls, final ClassLoader parent) {
        super(urls, parent);
        Assert.isNotNull(urls);
        Assert.isNotNull(model);
        _model = model;
        _dependencies = new UniqueEList<IProject>();
    }

    public BundleClassLoader(final IPluginModelBase model, final List<IProject> dependencies, final URL[] urls, final ClassLoader parent) {
        super(urls, parent);
        Assert.isNotNull(urls);
        Assert.isNotNull(model);
        _model = model;
        _dependencies = dependencies != null ? dependencies : new UniqueEList<IProject>();
    }

    public IPluginModelBase getPluginModelBase() {
        return _model;
    }

    public IProject getProject() {
        if (_project == null && _model.getUnderlyingResource() != null) {
            _project = _model.getUnderlyingResource().getProject();
        }
        return _project;
    }

    public IProject[] getWorkspaceDependencies() {
        return _dependencies.toArray(new IProject[_dependencies.size()]);
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
