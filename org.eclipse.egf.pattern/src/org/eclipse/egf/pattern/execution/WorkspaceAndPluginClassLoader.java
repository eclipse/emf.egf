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
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
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

    public final Class<?> loadClass(String name) throws ClassNotFoundException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        List<URL> urls = new ArrayList<URL>();
        final List<Bundle> bundles = new ArrayList<Bundle>();
        try {
            IProject project = fc.getPlatformPlugin().getProject();
            if (project != null)
                urls.add(toURL(project));
            IPluginModelBase model = fc.getPlatformPlugin().getPluginModelBase();
            for (BundleSpecification spec : model.getBundleDescription().getRequiredBundles()) {
                Bundle bundle = Platform.getBundle(spec.getName());
                if (bundle == null) {
                    URL url = toURL(root.getProject(spec.getName()));
                    if (url != null)
                        urls.add(url);
                } else {
                    // depends on a RT plugins
                    bundles.add(bundle);
                }
            }

            URLClassLoader cl = new URLClassLoader((URL[]) urls.toArray(new URL[urls.size()]), new ClassLoader() {

                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    for (Bundle bundle : bundles) {
                        try {
                            return bundle.loadClass(name);
                        } catch (ClassNotFoundException ee) {
                            // don't care
                        }
                    }
                    return super.findClass(name);
                }
            });
            return cl.loadClass(name);
        } catch (Exception e) {
            throw new ClassNotFoundException(Messages.bind(Messages.classloader_error1, name), e);
        }
    }

    private URL toURL(IProject project) throws MalformedURLException {
        IJavaProject javaProject = JavaCore.create(project);

        IPath outputLocation = null;
        try {
            outputLocation = javaProject.getOutputLocation();
        } catch (JavaModelException e) {
            Activator.getDefault().logError(Messages.bind(Messages.classloader_error2, project.getName()), e);
            return null;
        }
        IFolder folder = project.getFolder(outputLocation.removeFirstSegments(1));
        return new URL("file", null, folder.getLocation().toOSString() + CharacterConstants.SLASH_CHARACTER);

    }
}
