/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.core.loader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.osgi.framework.Bundle;

/**
 * This classloader will try to load classes from workspace bundles and the
 * target bundles.
 * 
 * 
 * @author Xavier Maysonnave
 * 
 */
public class BundleProjectClassLoader extends ClassLoader {

  private final IProject _project;

  private Map<String, ClassLoader> classLoaders = new HashMap<String, ClassLoader>();

  public BundleProjectClassLoader(IProject project) {
    Assert.isNotNull(project);
    Assert.isNotNull(PluginRegistry.findModel(project));
    _project = project;
  }

  public ClassLoader getProjectClassLoader(IProject project) throws MalformedURLException, JavaModelException {
    String name = project.getName();
    ClassLoader classLoader = classLoaders.get(name);
    if (classLoader == null) {
      classLoader = new URLClassLoader(new URL[] { asURL(project) }, Thread.currentThread().getContextClassLoader());
      classLoaders.put(name, classLoader);
    }
    return classLoader;
  }

  private URL asURL(IProject project) throws MalformedURLException, JavaModelException {
    IJavaProject javaProject = JavaCore.create(project);
    IPath outputLocation = javaProject.getOutputLocation();
    IFolder folder = project.getFolder(outputLocation.removeFirstSegments(1));
    return new URL("file", null, folder.getLocation().toOSString() + CharacterConstants.SLASH_CHARACTER); //$NON-NLS-1$
  }

  private Class<?> doLoadClass(IProject project, String name) {
    if (project == null) {
      return null;
    }
    try {
      return getProjectClassLoader(project).loadClass(name);
    } catch (ClassNotFoundException ee) {
      // don't care
    } catch (MalformedURLException e) {
      EGFCorePlugin.getDefault().logError(e);
    } catch (JavaModelException e) {
      EGFCorePlugin.getDefault().logError(e);
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

  @Override
  public final Class<?> loadClass(String name) throws ClassNotFoundException {
    Class<?> result = null;
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    try {
      // Try to load class from the current Project
      result = doLoadClass(_project, name);
      if (result != null) {
        return result;
      }
      // Try to load class from its required bundles
      IPluginModelBase model = PluginRegistry.findModel(_project);
      for (BundleSpecification spec : model.getBundleDescription().getRequiredBundles()) {
        Bundle bundle = Platform.getBundle(spec.getName());
        if (bundle == null) {
          // Workspace Bundle
          result = doLoadClass(root.getProject(spec.getName()), name);
          if (result != null) {
            return result;
          }
        } else {
          // Target Bundle
          result = doLoadClass(bundle, name);
          if (result != null) {
            return result;
          }
        }
      }
    } catch (Exception e) {
      throw new ClassNotFoundException(NLS.bind(EGFCoreMessages.classloader_errorFindClass, name), e);
    }
    throw new ClassNotFoundException(NLS.bind(EGFCoreMessages.classloader_errorOuptutFolder, name));
  }

}
