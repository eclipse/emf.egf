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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.util.NLS;

/**
 * This ResourceLoader is capable of loading resources from a specific Java
 * project within the workspace. Typical use is when invoking a workflow from
 * within a plugin. It can also load classes of the project's classpath.
 * 
 * 
 * inspired by the OawEclipseProjectResourceAndClassesLoader by
 * 
 * @author PhilippBollbach
 *         inspired by the OawEclipseProjectResourceLoader by
 * @author Axel Terfloth (axel.terfloth@itemis.de)
 * @author Karsten Thoms (karsten.thoms@itemis.de)
 * 
 */
public class URLBundleProjectClassLoader {

  private IProject _project;

  private ClassLoader _bundleClassLoader;

  public URLBundleProjectClassLoader(IProject project) throws CoreException {
    _project = project;
    _bundleClassLoader = initClassLoader();
  }

  public IProject getProject() {
    return _project;
  }

  /***
   * Create an URLClassloader from an IProject
   * 
   * @param project
   * 
   * @return a class loader
   */
  public ClassLoader initClassLoader() throws CoreException {
    IJavaProject javaProject = JavaCore.create(_project);
    List<URL> urls = new UniqueEList<URL>();
    try {
      IPath path = new Path(javaProject.getProject().getLocationURI().toURL().toString()).removeLastSegments(1);
      path = path.append(javaProject.getOutputLocation());
      // current output bin
      urls.add(new URL(path.toString() + "/")); //$NON-NLS-1$
      // classpath analysis
      for (IClasspathEntry classpathEntry : javaProject.getResolvedClasspath(true))
        // referenced project bin folder
        if (classpathEntry.getEntryKind() > IClasspathEntry.CPE_LIBRARY) {
          if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
            urls.add(ResourcesPlugin.getWorkspace().getRoot().getLocation().append(classpathEntry.getPath().append("bin")).toFile().toURI().toURL()); //$NON-NLS-1$
          }
          // source folders
          else if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
            urls.add(ResourcesPlugin.getWorkspace().getRoot().getLocation().append(classpathEntry.getPath()).toFile().toURI().toURL());
          }
        } else {
          // jars
          urls.add(classpathEntry.getPath().toFile().toURI().toURL());
        }
    } catch (Throwable t) {
      throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.URLBundleProjectClassLoader_errorClasspath, _project.getName()), t));
    }

    return new URLClassLoader(urls.toArray(new URL[urls.size()]), Thread.currentThread().getContextClassLoader());
  }

  public URL loadResource(String path) {
    URL url = Thread.currentThread().getContextClassLoader().getResource(path);
    if (url == null) {
      url = _bundleClassLoader.getResource(path);
    }
    return url;
  }

  public InputStream loadResourceAsStream(String path) throws IOException {
    URL url = loadResource(path);
    return url == null ? null : url.openStream();
  }

  public Class<?> loadClass(String clazzName) throws ClassNotFoundException {
    Class<?> clazz = _bundleClassLoader.loadClass(clazzName);
    if (clazz == null) {
      throw new ClassNotFoundException(clazzName);
    }
    return clazz;
  }

}
