/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.helper;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.osgi.framework.Bundle;

/**
 * This helper provides high-level services to deal with class loading.
 * 
 * @author Xavier Maysonnave
 */
public class BundleHelper {

  /**
   * Instantiate given fully qualified class name using given bundle.
   * 
   * @param fullyQualifiedClassName_p
   *          the class name with its package name (dot separated syntax).
   * @param bundle_p
   *          which can load given class name.
   * @return an instance of given class name
   */
  public static Object instantiate(String fullyQualifiedClassName_p, Bundle bundle_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Object result = null;
    // Precondition.
    if (bundle_p == null) {
      return result;
    }
    // Try loading a class according to the class name.
    Class<?> clazz = loadClass(fullyQualifiedClassName_p, bundle_p);
    // Try instantiating an object of loaded class.
    if (clazz != null) {
      result = clazz.newInstance();
    }
    return result;
  }

  /**
   * Load given fully qualified class name using given bundle.
   * 
   * @param fullyQualifiedClassName_p
   *          the class name with its package name (dot separated syntax).
   * @param bundle_p
   *          bundle which can load given class name.
   * @return loaded Class according to given class name
   */
  public static Class<?> loadClass(String fullyQualifiedClassName_p, Bundle bundle_p) throws ClassNotFoundException {
    Class<?> clazz = null;
    // Precondition.
    if (bundle_p == null) {
      return clazz;
    }
    return bundle_p.loadClass(fullyQualifiedClassName_p);
  }

  /**
   * Unique ID based on bundle symbolic name
   */
  public static String getBundleId(ModelEntry entry) {
    if (entry == null) {
      return null;
    }
    String id = entry.getId();
    if (id == null || id.trim().length() == 0) {
      return null;
    }
    return id.trim();
  }

  /**
   * Unique ID based on bundle symbolic name
   */
  public static String getBundleId(IPluginModelBase model) {
    if (model == null || model.getPluginBase() == null) {
      return null;
    }
    if (model.getUnderlyingResource() != null && model.getUnderlyingResource().getProject() != null) {
      return getBundleId(model.getUnderlyingResource().getProject());
    }
    String id = model.getPluginBase().getId();
    if (id == null || id.trim().length() == 0) {
      return null;
    }
    return id.trim();
  }

  /**
   * Unique ID based on project
   */
  public static String getBundleId(IProject project) {
    if (project == null) {
      return null;
    }
    String id = null;
    IPluginModelBase base = getPluginModelBase(project);
    if (base != null) {
      id = base.getPluginBase().getId();
    }
    if (id == null) {
      id = project.getName();
    }
    if (id == null || id.trim().length() == 0) {
      return null;
    }
    return id.trim();
  }

  /**
   * Unique ID based on resource
   */
  public static String getBundleId(IResource resource) {
    if (resource == null) {
      return null;
    }
    return getBundleId(resource.getProject());
  }

  /**
   * Get the plug-in model base for given project.
   * 
   * @param project_p
   * @return an {@link IPluginModelBase} instance or null if the project is not
   *         a plug-in.
   */
  public static IPluginModelBase getPluginModelBase(IPath path) {
    if (path == null || path.segmentCount() < 2) {
      return null;
    }
    return getPluginModelBase(ProjectHelper.getProject(path.segment(0)));
  }

  /**
   * Get the plug-in model base for given project.
   * 
   * @param project_p
   * @return an {@link IPluginModelBase} instance or null if the project is not
   *         a plug-in.
   */
  public static IPluginModelBase getPluginModelBase(IResource resource) {
    if (resource == null) {
      return null;
    }
    return getPluginModelBase(resource.getProject());
  }

  /**
   * Get the plug-in model base for given project.
   * 
   * @param project_p
   * @return an {@link IPluginModelBase} instance or null if the project is not
   *         a plug-in.
   */
  public static IPluginModelBase getPluginModelBase(IProject project) {
    if (project == null) {
      return null;
    }
    return PluginRegistry.findModel(project);
  }

}