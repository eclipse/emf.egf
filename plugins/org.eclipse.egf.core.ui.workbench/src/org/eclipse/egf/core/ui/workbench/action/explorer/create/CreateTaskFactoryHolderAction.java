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
package org.eclipse.egf.core.ui.workbench.action.explorer.create;

import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.core.ui.wizard.TaskFactoryHolderWizard;
import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Open a wizard to create an {@link TaskFactoryHolder} model element.
 * @author fournier
 */
public class CreateTaskFactoryHolderAction extends CreateModelElementAction {

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public CreateTaskFactoryHolderAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.CreateTaskFactoryHolderAction_Title);
    setToolTipText(Messages.CreateTaskFactoryHolderAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_NEW_TASK_FACTORY));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return FactoryComponentInvocation.class;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    // Default condition check.
    boolean isEnabled = super.isEnabled();
    if (isEnabled) {
      FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) getModelElement();
      // Rule 1 : to create a task factory the referenced FC must be different from the BootStrap one.
      if (DataHelper.isBootstrapFactoryComponent(fcInvocation.getFactoryComponentId())) {
        // Rule 2 : If the selected factory component invocation does not already have a task factory, enable the action; disable otherwise.
        TaskFactoryHolder taskFactory = fcInvocation.getTaskFactory();
        isEnabled = (null == taskFactory) ? true : false;
      } else {
        isEnabled = false;
      }
    }
    return isEnabled;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    return new TaskFactoryHolderWizard(modelElement_p, null, isReadOnly());
  }
}
