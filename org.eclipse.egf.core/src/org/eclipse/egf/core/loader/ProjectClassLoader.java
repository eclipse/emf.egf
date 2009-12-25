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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.util.NLS;
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
public class ProjectClassLoader extends ClassLoader {

  private final IPlatformBundle _platformBundle;

  private final ProjectClassLoaderRegistry _registry = new ProjectClassLoaderRegistry();

  public ProjectClassLoader(IPlatformBundle platformBundle) {
    _platformBundle = platformBundle;
  }

  private Class<?> doLoadClass(IProject project, String name) {
    if (project != null) {
      try {
        return _registry.getProjectClassLoader(project).loadClass(name);
      } catch (ClassNotFoundException ee) {
        // don't care
      } catch (MalformedURLException e) {
        EGFCorePlugin.getDefault().logError(e);
      } catch (JavaModelException e) {
        EGFCorePlugin.getDefault().logError(e);
      }
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
      // Workspace Bundle
      IProject project = _platformBundle.getProject();
      if (project != null) {
        result = doLoadClass(project, name);
        if (result != null) {
          return result;
        }
      }
      // Deep Bundle analysis
      IPluginModelBase model = _platformBundle.getPluginModelBase();
      for (BundleSpecification spec : model.getBundleDescription().getRequiredBundles()) {
        Bundle bundle = Platform.getBundle(spec.getName());
        if (bundle == null) {
          // Workspace Bundle
          result = doLoadClass(root.getProject(spec.getName()), name);
          if (result != null) {
            return result;
          }
        } else {
          // depends on a RT plugins
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
