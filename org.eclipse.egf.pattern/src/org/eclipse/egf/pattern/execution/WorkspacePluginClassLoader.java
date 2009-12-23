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
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.WorkspaceModelManager;
import org.osgi.framework.Bundle;

/**
 * This classloader will try to load classes from the given project (and its
 * dependencies) The given projet must a java plugin project
 * 
 * TODO utilisation de PDECore, comment faire autrement ?
 * 
 * @author Guiu
 * 
 */
public class WorkspacePluginClassLoader extends ClassLoader {

	private final IProject project;

	public WorkspacePluginClassLoader(String projectName) {
		super();
		if (projectName == null || "".equals(projectName))
			throw new IllegalArgumentException();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (project == null)
			throw new IllegalStateException("Cannot access Project/Plugin '" + projectName + "'");
		if (!WorkspaceModelManager.isPluginProject(project))
			throw new IllegalStateException("Project '" + projectName + "' must be a plugin project.");

	}

	public final Class<?> loadClass(String name) throws ClassNotFoundException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		List<URL> urls = new ArrayList<URL>();
		final List<Bundle> bundles = new ArrayList<Bundle>();
		try {
			urls.add(toURL(project));
			IPluginModelBase model = PDECore.getDefault().getModelManager().findModel(project);
			for (BundleSpecification spec : model.getBundleDescription().getRequiredBundles()) {
				Bundle bundle = Platform.getBundle(spec.getName());
				if (bundle == null) {
					// depends on a workspace plugins
					urls.add(toURL(root.getProject(spec.getName())));
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
			throw new ClassNotFoundException("Cannot find " + name, e);
		}
	}

	private URL toURL(IProject project) throws MalformedURLException {
		IJavaProject javaProject = JavaCore.create(project);

		IPath outputLocation = null;
		try {
			outputLocation = javaProject.getOutputLocation();
		} catch (JavaModelException e) {
			Activator.getDefault().logError("Cannot get output folder for project " + project.getName(), e);
			outputLocation = new Path(".");
		}
		IFolder folder = project.getFolder(outputLocation.removeFirstSegments(1));
		return new URL("file", null, folder.getLocation().toOSString() + "/");

	}
}
