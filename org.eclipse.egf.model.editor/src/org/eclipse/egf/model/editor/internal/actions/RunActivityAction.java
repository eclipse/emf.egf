/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model.editor.internal.actions;

import org.eclipse.egf.editor.internal.ui.EGFModelsEditorImages;
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.egf.model.editor.internal.dialogs.FcoreSelectionDialog;
import org.eclipse.egf.model.editor.l10n.EGFModelsEditorMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class RunActivityAction extends Action implements IWorkbenchWindowActionDelegate, IActionDelegate2 {

  public RunActivityAction() {
    super();
    setText(EGFModelsEditorMessages.RunActivityAction_label);
    setDescription(EGFModelsEditorMessages.RunActivityAction_description);
    setToolTipText(EGFModelsEditorMessages.RunActivityAction_tooltip);
    setImageDescriptor(EGFModelsEditorImages.EGF_RUN_ACTIVITY);
  }

  @Override
  public void run() {
    runWithEvent(null);
  }

  @Override
  public void runWithEvent(Event e) {

    FcoreSelectionDialog dialog = new FcoreSelectionDialog(EGFModelsEditorPlugin.getActiveWorkbenchShell(), false);
    dialog.setTitle(EGFModelsEditorMessages.RunActivityAction_dialogTitle);
    dialog.setMessage(EGFModelsEditorMessages.RunActivityAction_dialogMessage);

    int result = dialog.open();
    if (result != IDialogConstants.OK_ID) {
      return;
    }

    Object[] fcores = dialog.getResult();
    if (fcores == null || fcores.length == 0) {
      return;
    }

    // if (fcores.length == 1) {
    // try {
    // // Run
    // } catch (CoreException ce) {
    // ExceptionHandler.handle(ce,
    // EGFModelsEditorMessages.RunActivityAction_errorTitle,
    // EGFModelsEditorMessages.RunActivityAction_errorMessage);
    // }
    // return;
    // }

  }

  // ---- IWorkbenchWindowActionDelegate
  // ------------------------------------------------

  public void run(IAction action) {
    run();
  }

  public void dispose() {
    // do nothing.
  }

  public void init(IWorkbenchWindow window) {
    // do nothing.
  }

  public void selectionChanged(IAction action, ISelection selection) {
    // do nothing. Action doesn't depend on selection.
  }

  // ---- IActionDelegate2
  // ------------------------------------------------

  public void runWithEvent(IAction action, Event event) {
    runWithEvent(event);
  }

  public void init(IAction action) {
    // do nothing.
  }

}
