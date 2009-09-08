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
import org.eclipse.egf.core.ui.wizard.ContextElementWizard;
import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.AbstractFactoryComponentFactory;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Create a model element {@link Context} as a child of its parent.
 * @author fournier
 */
public class CreateContextAction extends CreateModelElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public CreateContextAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.CreateContextAction_Title);
    setToolTipText(Messages.CreateContextAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_NEW_CONTEXT));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    // Do nothing, creation of a context is not performed through a Wizard.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    // Default condition check.
    boolean isEnabled = super.isEnabled();
    if (isEnabled) {
      AbstractFactoryComponentFactory fcFactory = (AbstractFactoryComponentFactory) getModelElement();
      if (fcFactory instanceof FactoryComponentInvocation) {
        // Rule 1 : to create a context the referenced FC must be different from the BootStrap one.
        if (DataHelper.isBootstrapFactoryComponent(((FactoryComponentInvocation) fcFactory).getFactoryComponentId())) {
          isEnabled = false;
        }
      }
      if (isEnabled) {
        // If the selected factory component factory does not already have a context, enable the action; disable otherwise.
        Context context = fcFactory.getContext();
        isEnabled = (null == context) ? true : false;
      }
    }
    return isEnabled;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateModelElementAction#run()
   */
  @Override
  public void run() {
    AdapterFactoryEditingDomain editingDomain = getEditingDomain();
    // Get the model element used as parent : either a ProductionPlan or an FactoryComponentInvocation.
    NamedModelElementWithId parent = getModelElement();
    // Create a new context element.
    Context context = ModelFactory.eINSTANCE.createContext();
    // Create the add command.
    Command command = AddCommand.create(editingDomain, parent, ModelPackage.Literals.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT, context);
    // Finally, execute the command.
    executeCommand(editingDomain, command);
    // Launch the context element creation wizard.
    openWizardDialog(new ContextElementWizard(context, null, isReadOnly()));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return AbstractFactoryComponentFactory.class;
  }
}