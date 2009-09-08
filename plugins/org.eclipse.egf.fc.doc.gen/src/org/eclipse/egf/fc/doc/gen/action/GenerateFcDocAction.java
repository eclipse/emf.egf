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
package org.eclipse.egf.fc.doc.gen.action;

import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction;
import org.eclipse.egf.fc.doc.gen.FcDocGeneratorActivator;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

/**
 * Implement an action to generate documentation integrated in EGF Help for selected factory component.
 * @author Guillaume Brocard
 */
public class GenerateFcDocAction extends AbstractModelElementAction {
  /**
   * Generate Doc image id.
   */
  public final static String IMG_GENERATE_DOCUMENTATION = "obj16/toc.gif"; //$NON-NLS-1$

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public GenerateFcDocAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.GenerateFcDocAction_Title);
    setToolTipText(Messages.GenerateFcDocAction_Tooltip);
    setImageDescriptor(FcDocGeneratorActivator.getDefault().getImageDescriptor(IMG_GENERATE_DOCUMENTATION));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId selectedModelElement_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return FactoryComponent.class;
  }

  /**
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    // // Generate documentation for selected factory component.
    // FcDocGeneratorActivator.getDefault().generateDocumentation((FactoryComponent) getModelElement());
  }
}
