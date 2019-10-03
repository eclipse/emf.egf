/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.application.activity;

import java.util.List;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.application.internal.activator.EGFApplicationPlugin;
import org.eclipse.egf.application.internal.activity.ActivityRunner;
import org.eclipse.egf.application.internal.l10n.ApplicationMessages;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.osgi.util.NLS;

public class ActivityApplication implements IApplication {

	public Object start(IApplicationContext context) throws Exception {
		// Retrieve arguments
		String[] strings = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		// Usual tests
		if (strings == null || strings.length < 2) {
			System.err.println(ApplicationMessages.ActivityApplication_Arguments_Usage);
			return IApplicationConfigurationConstants.EXIT_ERROR;
		}
		// Decode arguments
		boolean hasActivitiesArgument = hasActivitiesArgument(strings);
		if (hasActivitiesArgument == false) {
			System.err.println(ApplicationMessages.ActivityApplication_Arguments_Usage);
			return IApplicationConfigurationConstants.EXIT_ERROR;
		}
		List<URI> uris = getActivityURIs(strings);
		// Nothing to process
		if (uris.isEmpty()) {
			return IApplication.EXIT_OK;
		}

		ResourceSet resourceSet = new EgfResourceSet(isRuntime(strings));

		// Build a list of activities if any
		List<Activity> activities = new UniqueEList<Activity>();
		for (int i = 0; i < uris.size(); i++) {
			URI uri = uris.get(i);
			EObject eObject = null;
			// Load it in our Editing Domain
			try {
				eObject = resourceSet.getEObject(uri, true);
			} catch (Throwable t) {
				EGFApplicationPlugin.getDefault().logError(new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityApplication_EObject_Loading_Error, i, uri), t)));
				return IApplicationConfigurationConstants.EXIT_ERROR;
			}
			// Check if we face an Activity
			if (eObject == null || eObject instanceof Activity == false) {
				EGFApplicationPlugin.getDefault().logError(new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityApplication_Invalid_Activity_Argument, i, uri), null)));
				return IApplicationConfigurationConstants.EXIT_ERROR;
			}
			// to be runned activities
			activities.add((Activity) eObject);
		}
		// Nothing to process
		if (activities.isEmpty()) {
			return IApplication.EXIT_OK;
		}
		// Run
		return runHelper(activities);
	}

	public void stop() {
		// Subclasses may override
	}

	public static Object runHelper(final List<Activity> activities) throws Exception {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		try {
			IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

				public void run(IProgressMonitor monitor) throws CoreException {
					try {
						ActivityRunner runner = new ActivityRunner(activities);
						runner.run(monitor);
					} finally {
						monitor.done();
					}
				}
			};
			workspace.run(runnable, new CodeGenUtil.EclipseUtil.StreamProgressMonitor(System.out));
		} catch (Exception e) {
			EGFApplicationPlugin.getDefault().logError(e);
			return IApplicationConfigurationConstants.EXIT_ERROR;
		} finally {
			try {
				workspace.save(true, new NullProgressMonitor());
			} catch (Exception e) {
				EGFApplicationPlugin.getDefault().logError(e);
				return IApplicationConfigurationConstants.EXIT_ERROR;
			}
		}
		return IApplication.EXIT_OK;
	}

	protected boolean isRuntime(String[] objects) {
		for (String string : objects) {
			if (IApplicationConfigurationConstants.RUNTIME_PROGRAM_ARGUMENTS.equals(string)) {
				return true;
			}
		}
		return false;
	}

	protected boolean hasActivitiesArgument(String[] objects) {
		for (String string : objects) {
			if (IApplicationConfigurationConstants.ACTIVITIES_PROGRAM_ARGUMENTS.equals(string)) {
				return true;
			}
		}
		return false;
	}

	protected List<URI> getActivityURIs(String[] objects) {
		List<URI> uris = new UniqueEList<URI>();
		boolean next = false;
		int position = 0;
		for (String string : objects) {
			if (IApplicationConfigurationConstants.ACTIVITIES_PROGRAM_ARGUMENTS.equals(string)) {
				next = true;
			} else if (IApplicationConfigurationConstants.RUNTIME_PROGRAM_ARGUMENTS.equals(string)) {
				next = false;
			} else if (next) {
				URI uri = null;
				position += 1;
				try {
					// Build a uri
					uri = URI.createURI(string);
				} catch (Throwable t) {
					EGFApplicationPlugin.getDefault().logError(new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityApplication_Invalid_URI_Argument, position, string), t)));
				}
				if (uri != null) {
					uris.add(uri);
				}
			}
		}
		return uris;
	}
}
