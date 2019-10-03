/**
 * <copyright>
 * 
 * Copyright (c) 2011 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * Anass Radouani (anass.radouani@atos.net) - Allow using workspace projects as output folders
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.task.acceleo3.engine;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.portfolio.task.acceleo3.Activator;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;

/**
 * @author Florian Barbin
 * 
 */

public class Acceleo3ScriptEngine {

	public void executeAcceleo3Task(final String implementation,
			ITaskProductionContext productionContext, SubMonitor monitor)
			throws InvocationException {
		// get arguments
		final URI modelURI = productionContext.getInputValue("modelURI",
				URI.class);
		final String targetUri = productionContext.getInputValue("output",
				String.class);

		// retrieve output folder path
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath targetFolderIPath = root.getLocation().append(targetUri);
		
		final Class<?> generatedClass;
		try {
			final Object instance;
			generatedClass = loadClass(implementation);

			instance = getInstance(modelURI, targetFolderIPath, generatedClass);
			final Method doGenerate = instance.getClass().getMethod(
					"doGenerate", new Class[] { Monitor.class });
			doGenerate.invoke(instance, new Object[] { null });
		} catch (Exception e) {
			Activator.getDefault().logError(e);
		}
	}

	private Object getInstance(final URI modelURI, IPath targetFolderIPath,
			final Class<?> generatedClass) throws NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		final Object instance;
		final Class<?>[] parameterTypes = { URI.class, File.class, List.class };
		final Constructor<?> constructor = generatedClass
				.getConstructor(parameterTypes);

		final Object[] initargs = { modelURI, targetFolderIPath.toFile(),
				Collections.EMPTY_LIST };
		instance = constructor.newInstance(initargs);
		return instance;
	}

	/**
	 * Load the selected class by user.
	 * 
	 * @param implementation
	 * @return the corresponding Class object.
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private Class<?> loadClass(final String implementation)
			throws UnsupportedEncodingException, IOException,
			ClassNotFoundException {
		final Class<?> generatedClass;
		InputStream stream = new ByteArrayInputStream(implementation
				.getBytes("UTF-8"));
		Properties properties = new Properties();
		properties.load(stream);
		String project = properties.getProperty("project");
		String className = properties.getProperty("class");
		if (project != null)

			generatedClass = Platform.getBundle(project).loadClass(className);
		else {
			generatedClass = Class.forName(className);
		}
		return generatedClass;
	}
}
