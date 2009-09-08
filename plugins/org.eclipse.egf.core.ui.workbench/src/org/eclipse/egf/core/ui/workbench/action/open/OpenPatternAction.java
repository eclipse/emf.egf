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
package org.eclipse.egf.core.ui.workbench.action.open;

import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.core.ui.workbench.internal.util.ActionPatternEditorHelper;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.pattern.ui.editor.PatternEditor;
import org.eclipse.egf.pattern.ui.editor.PatternEditorHelper;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;


/**
 * Implement an action that opens a pattern editor for selected {@link PatternModel} element.
 * @author Guillaume Brocard
 */
public class OpenPatternAction extends OpenModelElementAction {
  
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public OpenPatternAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.open.OpenModelElementAction#getEditorId()
   */
  @Override
  protected String getEditorId() {
    return PatternEditor.class.getName();
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.open.OpenModelElementAction#getEditorInput()
   */
  @Override
  protected IEditorInput getEditorInput() {
    // Get the editor input for the selected pattern.
    return PatternEditorHelper.getEditorInput(getPatternModel(), isReadOnly() == false);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.open.OpenModelElementAction#run()
   */
  @Override
  public void run() {
    // Open a pattern editor.
    IEditorPart patternEditor = WorkbenchHelper.openEditor(getEditorInput(), getEditorId(), getShell());
    if (patternEditor != null) {
      // Add the open editor in listener that monitors pattern editor closing event.
      ActionPatternEditorHelper.addPatternEditorToListener(patternEditor, getPatternModel());
    }
  }

  /**
   * @see org.eclipse.jface.action.Action#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    // Default enablement.
    boolean isEnabled = super.isEnabled();
    if (isEnabled) {
      PatternModel pattern = getPatternModel();
      // Path must be not null.
      String path = pattern.getPath();
      isEnabled &= path != null ? true : false;
    }
    return isEnabled;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return PatternModel.class;
  }

  /**
   * Get the selected pattern element.
   * @return
   */
  private PatternModel getPatternModel() {
    return (PatternModel) getModelElement();
  }
  
}