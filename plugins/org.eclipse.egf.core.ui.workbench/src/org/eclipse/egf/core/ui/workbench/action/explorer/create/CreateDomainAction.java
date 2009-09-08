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

import org.eclipse.egf.core.ui.wizard.NewDomainWizard;
import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.core.ui.workbench.action.open.OpenDomainAction;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Open a wizard to create an {@link Domain} path.
 * @author fournier
 */
public class CreateDomainAction extends CreateModelElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public CreateDomainAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.CreateDomainAction_Title);
    setToolTipText(Messages.CreateDomainAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_NEW_DOMAIN));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    return new NewDomainWizard(modelElement_p.eContainer(), modelElement_p, isReadOnly());
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateModelElementAction#run()
   */
  @Override
  public void run() {
    super.run();
    Domain domain = (Domain) getModelElement();
    if (ModelHelper.isDomainDefined(domain)) {
      // Open the editor on the created domain.
      OpenDomainAction openDomainAction = new OpenDomainAction(getShell(), getSelectionProvider(), isReadOnly());
      // Set the current selection.
      openDomainAction.setSelectedElement(domain);
      // Execute the 'open' action.
      openDomainAction.run();
    }
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return Domain.class;
  }

  /**
   * @see org.eclipse.jface.action.Action#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    // Default enablement.
    boolean isEnabled = super.isEnabled();
    if (isEnabled) {
      Domain domain = (Domain) getModelElement();
      // If the domain is not defined, allow this action.
      isEnabled = !ModelHelper.isDomainDefined(domain);
    }
    return isEnabled;
  }
}