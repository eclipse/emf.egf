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

import org.eclipse.egf.core.ui.wizard.ContractElementWizard;
import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Open a wizard to create an {@link ContractElement} model element.
 * @author fournier
 */
public class CreateContractElementAction extends CreateModelElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public CreateContractElementAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.CreateContractElementAction_Title);
    setToolTipText(Messages.CreateContractElementAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_NEW_CONTRACT_ELEMENT));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return Contract.class;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    return new ContractElementWizard(modelElement_p, null, isReadOnly());
  }
}