/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.workbench.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import org.eclipse.egf.common.progress.IProgressRunnable;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.ui.actions.AbstractUiHandler;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.pde.EgfPdeActivator;


/**
 * Convert a Java project in a Factory Component.<br>
 * This is the handler executed by the UI action.
 * @author Guillaume Brocard
 */
public class ConvertPlugin2FactoryComponentHandler extends AbstractUiHandler {
  
  /**
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  public Object execute(ExecutionEvent executionEvent_p) throws ExecutionException {
    Object result = null;
    // First, this method is called only when core.expressions.definition properties are valid.
    // Get the current selection.
    List<IJavaProject> selection = getSelection(executionEvent_p, IJavaProject.class);
    if (selection.isEmpty()) {
      return result;
    }
    // Loop over the selection to convert all selected plug-in project.
    for (IJavaProject selectedJavaProject : selection) {
      IProject project = selectedJavaProject.getProject();
      // Get its name.
      final String projectName = project.getName();
      // Get its related plug-in id.
      IPluginModelBase pluginModelBase = EgfPdeActivator.getDefault().getPluginModelBase(project);
      String dialogTitle = MessageFormat.format(Messages.ConvertPlugin2FactoryComponent_Title, new Object[] { projectName });
      boolean convertToFC = true;
      if (pluginModelBase == null) {
        // Case the selected project is a simple java project.
        // First, convert this project in a plug-in with PDE convert method.
        convertToFC = EgfPdeActivator.getDefault().convertToPlugin(projectName);
      } else {
        // Case the selected project is a plug-in project.
        String pluginId = pluginModelBase.getPluginBase().getId();
        // Check plug-in id and project name are equals.
        if (projectName.equals(pluginId) == false) {
          String dialogMessage = MessageFormat.format(Messages.ConvertPlugin2FactoryComponent_ErrorDialog_Message, new Object[] { projectName, pluginId });
          MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), dialogTitle, dialogMessage);
          convertToFC = false;
        }
      }
      // Go for FC style !
      if (convertToFC) {
        IProgressRunnable convertToFcRunnable = new IProgressRunnable() {
          public String getReportingTitle() {
            return MessageFormat.format(Messages.ConvertPlugin2FactoryComponent_Title, new Object[] { projectName });
          }
          public boolean run(IProgressMonitor progressMonitor_p) {
            EgfPdeActivator.getDefault().convertToFactoryComponent(projectName);
            return true;
          }
        };
        ProgressReporter.asyncExec(convertToFcRunnable);
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    boolean result = true;
    ISelection selection = getSelection();
    if (selection != null) {
      List<IProject> projects = getProjects(selection);
      if (projects.isEmpty() == false) {
        Iterator<IProject> iter = projects.iterator();
        while (iter.hasNext() && result) {
          result &= canConvert(iter.next());
        }
      } else {
        result = false;
      }
    }
    return result;
  }

  /**
   * Check if given project can be converted into a Factory Component.
   * @param project_p
   * @return
   */
  private boolean canConvert(IProject project_p) {
    // TODO: need to check if current project holds nature and builders
    return EgfPdeActivator.getDefault().getFactoryComponent(project_p) == null;
  }

  /**
   * Get the current selection.
   * @return can be <code>null</code> if no selection.
   */
  private ISelection getSelection() {
    ISelection currentSelection = null;
    IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    if (activeWorkbenchWindow != null) {
      currentSelection = activeWorkbenchWindow.getSelectionService().getSelection();
    }
    return currentSelection;
  }

  /**
   * Get a project from the selection.
   * @param selection_p
   * @return an empty list if given selection does not contain any project.
   */
  @SuppressWarnings("unchecked")
  private List<IProject> getProjects(ISelection selection_p) {
    List<IProject> projects = new ArrayList<IProject>(0);
    if (selection_p == null) {
      return projects;
    }
    IStructuredSelection selection = (IStructuredSelection) selection_p;
    Iterator selectedElements = selection.iterator();
    while (selectedElements.hasNext()) {
      Object selectedElement = selectedElements.next();
      if (selectedElement instanceof IJavaProject) {
        projects.add(((IJavaProject) selectedElement).getProject());
      }
    }
    return projects;
  }
  
}