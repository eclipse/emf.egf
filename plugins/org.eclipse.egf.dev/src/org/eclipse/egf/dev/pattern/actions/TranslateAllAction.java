/**
 * <copyright>
 * 
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
 * 
 * </copyright>
 */

package org.eclipse.egf.dev.pattern.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.dev.Activator;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.engine.TranslationHelper;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * @author Thomas Guiu
 */
public class TranslateAllAction implements IWorkbenchWindowActionDelegate {

	public TranslateAllAction() {
		// Nothing to do
	}

	public void run(IAction action) {

		final List<Pattern> patterns = new ArrayList<Pattern>(200);
		final IPlatformFcore[] platformFcores = EGFCorePlugin.getPlatformFcores();
		final ResourceSet resourceSet = new EgfResourceSet();
		List<IProject> projects = new UniqueEList<IProject>();

		// Collect Patterns
		try {
			for (IPlatformFcore platformFcore : platformFcores) {
				Resource resource = resourceSet.getResource(platformFcore.getURI(), true);
				PatternCollector.INSTANCE.collect(resource.getContents(), patterns, PatternCollector.EMPTY_ID_SET);
				if (platformFcore.getPlatformBundle().getProject() != null) {
					projects.add(platformFcore.getPlatformBundle().getProject());
				}
			}
		} catch (Throwable t) {
			ThrowableHandler.handleThrowable(Activator.getDefault().getPluginID(), t);
			return;
		}

		// Translate Job
		WorkspaceJob job = new WorkspaceJob(EGFPatternMessages.patterns_translations_job_label) {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				MultiStatus statii = new MultiStatus(Activator.getDefault().getPluginID(), IStatus.ERROR, EGFPatternMessages.PatternTranslation_exception, null);
				try {
					TranslationHelper.translate(monitor, patterns);
				} catch (OperationCanceledException oce) {
					throw oce;
				} catch (Throwable t) {
					if (t instanceof CoreException) {
						statii.add(((CoreException) t).getStatus());
					} else {
						statii.add(Activator.getDefault().newStatus(Status.ERROR, EGFPatternMessages.PatternTranslation_exception, t));
					}
				} finally {
					monitor.done();
				}
				return statii.getChildren().length != 0 ? statii : Status.OK_STATUS;

			}

		};

		job.setRule(ProjectHelper.getRule(projects));
		job.schedule();

	}

	/**
	 * Selection in the workbench has been changed. We
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after
	 * the delegate has been created.
	 * 
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// Nothing to do
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * 
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
		// Nothing to do
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * 
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		// Nothing to do
	}

}
