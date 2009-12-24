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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * This helper manages a classloader per project in the workspace.
 * 
 * @author Thomas Guiu
 * 
 */
public class ProjectClassLoaderHelper {
    private final static Map<String, ClassLoader> classLoaders = new HashMap<String, ClassLoader>();

    public static ClassLoader getProjectClassLoader(IProject project) throws MalformedURLException, JavaModelException {
        String name = project.getName();
        ClassLoader classLoader = classLoaders.get(name);
        if (classLoader == null) {
            classLoader = new URLClassLoader(new URL[] { asURL(project) }, ProjectClassLoaderHelper.class.getClassLoader());
            classLoaders.put(name, classLoader);
        }
        return classLoader;
    }

    private static URL asURL(IProject project) throws MalformedURLException, JavaModelException {
        IJavaProject javaProject = JavaCore.create(project);

        IPath outputLocation = javaProject.getOutputLocation();
        IFolder folder = project.getFolder(outputLocation.removeFirstSegments(1));
        return new URL("file", null, folder.getLocation().toOSString() + CharacterConstants.SLASH_CHARACTER);
    }

    private ProjectClassLoaderHelper() {
        super();

    }

}
