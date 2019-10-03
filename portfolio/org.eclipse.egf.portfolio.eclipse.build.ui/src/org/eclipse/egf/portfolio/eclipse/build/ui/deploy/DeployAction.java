/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.eclipse.build.ui.deploy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.presentation.BuildCoreEditorPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.PlatformUI;

/**
 * @author Matthieu Helleboid
 * 
 */
public abstract class DeployAction implements IActionDelegate2 {
	private static final String END_COMMENT = "-->";
    private static final String USER_DEPLOY_JOB_NAME = "<!--userDeployJobName=";
    private static final String USER_DEPLOY_SERVER_URL = "<!--userDeployServerUrl=";
    protected Collection<IFile> configFiles = new ArrayList<IFile>();

	public void init(IAction action) {
	}

	public void dispose() {
	    configFiles.clear();
	}

	public void runWithEvent(IAction action, Event event) {
		run();
	}

	public void run(IAction action) {
		run();
	}

	
	
	protected void run() {
		Shell activeShell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		StringBuilder resultBuilder = new StringBuilder();
		for (IFile configFile : configFiles) {
			StringBuilder actionLabelbuilder = new StringBuilder();
			actionLabelbuilder.append(getActionName());
			actionLabelbuilder.append(" ");
			actionLabelbuilder.append(configFile.getFullPath().toString());

			resultBuilder.append(actionLabelbuilder.toString());
			resultBuilder.append(" : ");

			String initialServerUrl = "http://serverUrl:80";
			String initialJobName = configFile.getParent().getName();
			
			try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(configFile.getContents()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    int indexOf = line.indexOf(USER_DEPLOY_SERVER_URL);
                    int indexOf2 = line.indexOf(END_COMMENT);
                    if (indexOf > -1 && indexOf2 > indexOf) {
                        initialServerUrl = line.substring(indexOf + USER_DEPLOY_SERVER_URL.length(), indexOf2);
                    }
                    indexOf = line.indexOf(USER_DEPLOY_JOB_NAME);
                    indexOf2 = line.indexOf(END_COMMENT);
                    if (indexOf > -1 && indexOf2 > indexOf) {
                        initialJobName = line.substring(indexOf + USER_DEPLOY_JOB_NAME.length(), indexOf2);
                    }              
                }
                bufferedReader.close();
            } catch (Exception e1) {
            }
			
			DeployDialog deployDialog = new DeployDialog(activeShell, actionLabelbuilder.toString(), initialServerUrl, initialJobName);
			if (deployDialog.open() == Window.OK) {
				try {
					doRun(deployDialog.getServerUrl(), deployDialog.getJobName(), configFile);
					resultBuilder.append(deployDialog.getJobName());
					resultBuilder.append(" @ ");
					resultBuilder.append(deployDialog.getServerUrl());
				} catch (Exception e) {
					BuildCoreEditorPlugin.INSTANCE.log(e);
					resultBuilder.append(e.getClass().getName());
					resultBuilder.append(" - ");
					resultBuilder.append(e.getMessage());
				}
			} else {
				resultBuilder.append("canceled");
			}

			resultBuilder.append(System.getProperty("line.separator"));
		}
		
		MessageDialog.openInformation(activeShell, "Result", resultBuilder.toString());
	}

	protected abstract String getActionName();

	protected abstract void doRun(String serverUrl, String jobName, IFile configFile) throws Exception;

	public void selectionChanged(IAction action, ISelection selection) {
		configFiles.clear();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			for (Object file : structuredSelection.toArray()) {
				if (file instanceof IFile) {
					configFiles.add((IFile) file);
				}
			}
		}
	}
}
