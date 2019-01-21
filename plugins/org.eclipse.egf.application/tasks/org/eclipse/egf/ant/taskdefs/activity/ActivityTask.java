/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * 
 * </copyright>
 * 
 * $Id: JETTask.java,v 1.1 2007/01/12 20:52:48 marcelop Exp $
 */
package org.eclipse.egf.ant.taskdefs.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.ant.taskdefs.EGFTask;
import org.eclipse.egf.application.internal.activator.EGFApplicationPlugin;
import org.eclipse.egf.application.internal.activity.ActivityRunner;
import org.eclipse.egf.application.internal.l10n.ApplicationMessages;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.osgi.util.NLS;

/**
 * <i>eclipseDir</i>/eclipse
 * -noSplash
 * -data <i>worspaceDir</i>
 * -application org.eclipse.ant.core.antRunner
 * -buildfile <i>antScript</i>
 * </p>
 * <p>In Windows you should execute <i>eclipsec</i> instead of <i>eclipse</i> in order to have
 * access to the Ant build script console output.</p>
 * <p>You can also use the Eclipse UI to execute an Ant script containing this task by right-clicking the script and selecting
 * <i>Run As &gt; Ant Build... &gt; JRE &gt; "Run in the same JRE as the workspace&quot;</i>.</p>
 * 
 * <p>
 * 
 * @since 0.2.4
 */
public class ActivityTask extends EGFTask {

	protected List<NestedActivity> _nestedActivities;

	public void addConfiguredActivity(NestedActivity activity) {
		if (_nestedActivities == null) {
			_nestedActivities = new ArrayList<NestedActivity>();
		}
		_nestedActivities.add(activity);
	}

	@Override
	protected void checkAttributes() throws BuildException {
		assertTrue("Nested 'activity' must be specified.", _nestedActivities != null); //$NON-NLS-1$
		for (NestedActivity activity : _nestedActivities) {
			activity.checkAttributes();
		}
	}

	@Override
	protected void doExecute() throws Exception {
		// Build a list of activities if any
		List<Activity> activities = new UniqueEList<Activity>();
		for (NestedActivity activity : _nestedActivities) {
			ResourceSet resourceSet = new EgfResourceSet(activity.isRuntime());

			EObject eObject = null;
			// Load it in our resource set
			try {
				eObject = resourceSet.getEObject(resourceSet.getURIConverter().normalize(activity.getUri()), true);
			} catch (Throwable t) {
				EGFApplicationPlugin.getDefault().logError(new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.NestedActivity_EObject_Loading_Error, activity.getUri().toString()), t)));
				continue;
			}
			// Verify if we face an Activity
			if (eObject == null || eObject instanceof Activity == false) {
				EGFApplicationPlugin.getDefault().logError(new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.NestedActivity_Invalid_Activity_Argument, activity.getUri().toString()), null)));
				continue;
			}
			// to be runned activities
			activities.add((Activity) eObject);
		}
		if (activities.isEmpty()) {
			return;
		}
		runHelper(activities);
	}

	public void runHelper(final List<Activity> activities) throws Exception {
		try {
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
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
			workspace.run(runnable, getProgressMonitor());
		} catch (Exception e) {
			throw e;
		}
	}

}
