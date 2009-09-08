/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.fc.generator.java.internal.test.ui.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;


/**
 * Our ModelApiGenerationAction action implements workbench action delegate. The action proxy will be created by the workbench and shown in the UI. When the
 * user tries to use the action, this delegate will be created and execution will be delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class ModelApiGenerationAction implements IWorkbenchWindowActionDelegate {
  // Selected model file
  private IFile _selectedModelFile;
  // Window where this action is located.
  //private IWorkbenchWindow _window;

  /**
   * The action has been activated. The argument of the method represents the 'real' action sitting in the workbench UI.
   * @see IWorkbenchWindowActionDelegate#run
   */
  public void run(IAction action_p) {
    // Check Preconditions.
    if (null == _selectedModelFile) {
      return;
    }
//    // Get input from selected ecore model.
//    String modelName = getModelName(_selectedModelFile);
//    IProject project = getProject(_selectedModelFile);
//    String modelProjectName = project.getFullPath().toString().substring(1); // get rid of first character ie '/'
//
//    IModelApiGenerator modelApiGenerator = JavaGeneratorActivator.getDefault().getModelApiGenerator();
//    boolean cr = modelApiGenerator.generate(modelProjectName, modelName, "com.thalesgroup.mde", new NullProgressMonitor()); //$NON-NLS-1$
//    String report = (cr) ? "OK" : "KO"; //$NON-NLS-1$ //$NON-NLS-2$
//    String message = MessageFormatHelper.formatMessage("The Java API generation is {0}", new Object[] { report }); //$NON-NLS-1$
//    MessageDialog.openInformation(_window.getShell(), "Model API Report", message); //$NON-NLS-1$
  }

//  /**
//   * Get the model name
//   * @param file_p
//   * @return the model name as a string.
//   */
//  private String getModelName(IFile file_p) {
//    return file_p.getName();
//  }
//
//  /**
//   * Get the project for given file.
//   * @param file_p
//   * @return
//   */
//  private IProject getProject(IFile file_p) {
//    return file_p.getProject();
//  }

  /**
   * Selection in the workbench has been changed. We can change the state of the 'real' action here if we want, but this can only happen after the delegate has
   * been created.
   * @see IWorkbenchWindowActionDelegate#selectionChanged
   */
  public void selectionChanged(IAction action_p, ISelection selection_p) {
    // Check Preconditions
    if (!(selection_p instanceof IStructuredSelection)) {
      return;
    }
    IStructuredSelection selection = (IStructuredSelection) selection_p;
    Object firstObject = selection.getFirstElement();
    if (firstObject instanceof IFile) {
      IFile file = (IFile) firstObject;
      if (ICommonConstants.ECORE_FILE_EXTENSION.equals(file.getFileExtension())) {
        _selectedModelFile = file;
      }
    }
  }

  /**
   * We can use this method to dispose of any system resources we previously allocated.
   * @see IWorkbenchWindowActionDelegate#dispose
   */
  public void dispose() {
    // do nothing.
  }

  /**
   * @see IWorkbenchWindowActionDelegate#init
   */
  public void init(IWorkbenchWindow window_p) {
    //_window = window_p;
  }
}