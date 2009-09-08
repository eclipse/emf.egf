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
package org.eclipse.egf.core.ui.workbench.action.open;

import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;


/**
 * Base class to implement an action that opens an editor.
 * @author fournier
 */
public abstract class OpenModelElementAction extends AbstractModelElementAction {
  /**
   * The 'open' retargetable action id.
   */
  public static final String OPEN_ACTION_ID = "org.eclipse.ui.navigator.Open"; //$NON-NLS-1$

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public OpenModelElementAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setId(OPEN_ACTION_ID);
    setText(Messages.OpenModelElementAction_Title);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    IEditorInput editorInput = getEditorInput();
    String editorId = getEditorId();
    // To open the related editor, the editor input and the id must be defined.
    if ((null != editorInput) && (null != editorId)) {
      final IEditorPart openEditor = doOpenEditor(editorInput, editorId);
      if (shouldSaveEditorAfterOpening()) {
        // Due to workspace operation conflicts, the save operation is run in a new asyncExec.
        getShell().getDisplay().asyncExec(new Runnable() {
          public void run() {
            WorkbenchHelper.saveEditor(openEditor);
          }
        });
      }
    }
  }

  /**
   * Return whether or not the open editor has to be saved after opening.<br>
   * Default implementation returns <code>false</code>.
   * @return true means save it please.
   */
  protected boolean shouldSaveEditorAfterOpening() {
    return false;
  }

  /**
   * Do open related editor for specified parameters.
   * @param editorInput_p
   * @param editorId_p
   */
  protected IEditorPart doOpenEditor(IEditorInput editorInput_p, String editorId_p) {
    return WorkbenchHelper.openEditor(editorInput_p, editorId_p, getShell());
  }

  /**
   * Return the id of the editor to be opened.
   * @return
   */
  protected abstract String getEditorId();

  /**
   * Return the input used by the open editor.
   * @return
   */
  protected abstract IEditorInput getEditorInput();
}
