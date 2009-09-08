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
package org.eclipse.egf.core.ui.workbench.action.explorer.create;

import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.core.ui.wizard.PatternWizard;
import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.core.ui.workbench.internal.util.ActionPatternEditorHelper;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.pattern.ui.editor.PatternEditor;
import org.eclipse.egf.pattern.ui.editor.PatternEditorHelper;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;


/**
 * Open a wizard to create a {@link PatternModel} model element.
 * @author Guillaume Brocard
 */
public class CreatePatternAction extends CreateModelElementAction {
  
  /**
   * Wizard used to create a {@link PatternModel} element.
   */
  private PatternWizard _patternWizard;

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public CreatePatternAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.CreatePatternAction_Title);
    setToolTipText(Messages.CreatePatternAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_NEW_PATTERN_MODEL));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    _patternWizard = new PatternWizard(modelElement_p, null, isReadOnly());
    return _patternWizard;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return PatternLibrary.class;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateModelElementAction#run()
   */
  @Override
  public void run() {
    // Open the pattern creation wizard.
    super.run();
    // Open Pattern editor on created pattern.
    // Get the created pattern.
    PatternModel createdPattern = (PatternModel) _patternWizard.getModelElement();
    // Created pattern can be null if the end-user canceled the creation operation.
    if (createdPattern != null) {
      // Create an editor input regarding the created pattern.
      IEditorInput editorInput = PatternEditorHelper.getEditorInput(createdPattern, isReadOnly() == false);
      // Open the editor for created pattern.
      IEditorPart patternEditor = WorkbenchHelper.openEditor(editorInput, PatternEditor.class.getName(), getShell());
      if (patternEditor != null) {
        // Add the open editor in listener that monitors pattern editor closing event.
        ActionPatternEditorHelper.addPatternEditorToListener(patternEditor, createdPattern);
      }
    }
  }
  
}