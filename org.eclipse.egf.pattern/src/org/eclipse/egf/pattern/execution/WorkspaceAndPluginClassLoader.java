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

package org.eclipse.egf.pattern.execution;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.osgi.framework.Bundle;

/**
 * This classloader will try to load classes from the workspace projects and the
 * runtimetime plugins.
 * 
 * 
 * @author Guiu
 * 
 */
public class WorkspaceAndPluginClassLoader extends ClassLoader {

    private final IPlatformFactoryComponent fc;

    public WorkspaceAndPluginClassLoader(IPlatformFactoryComponent fc) {
        this.fc = fc;

    }

    private Class<?> doLoadClass(IProject project, String name) {
        try {
            return ProjectClassLoaderHelper.getProjectClassLoader(project).loadClass(name);
        } catch (ClassNotFoundException ee) {
            // don't care
        } catch (MalformedURLException e) {
            Activator.getDefault().logError(e);

        } catch (JavaModelException e) {
            Activator.getDefault().logError(e);
        }
        return null;
    }

    private Class<?> doLoadClass(Bundle bundle, String name) {
        try {
            return bundle.loadClass(name);
        } catch (ClassNotFoundException ee) {
            // don't care
        }
        return null;
    }

    public final Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = null;
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        List<URL> urls = new ArrayList<URL>();
        final List<Bundle> bundles = new ArrayList<Bundle>();
        try {
            IProject project = fc.getPlatformPlugin().getProject();
            if (project != null) {
                result = doLoadClass(project, name);
                if (result != null)
                    return result;
            }
            IPluginModelBase model = fc.getPlatformPlugin().getPluginModelBase();
            for (BundleSpecification spec : model.getBundleDescription().getRequiredBundles()) {
                Bundle bundle = Platform.getBundle(spec.getName());
                if (bundle == null) {
                    result = doLoadClass(root.getProject(spec.getName()), name);
                    if (result != null)
                        return result;
                } else {
                    // depends on a RT plugins
                    result = doLoadClass(bundle, name);
                    if (result != null)
                        return result;
                }
            }
        } catch (Exception e) {
            throw new ClassNotFoundException(Messages.bind(Messages.classloader_error1, name), e);
        }
        throw new ClassNotFoundException(Messages.bind(Messages.classloader_error1, name));
    }

}
