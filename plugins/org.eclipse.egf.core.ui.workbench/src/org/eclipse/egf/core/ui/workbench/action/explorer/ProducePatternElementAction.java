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
package org.eclipse.egf.core.ui.workbench.action.explorer;

import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Implement an action to produce the {@link AbstractPatternElement} selected element.
 * @author Guillaume Brocard
 */
public class ProducePatternElementAction extends AbstractModelElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public ProducePatternElementAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.ProducePatternElementAction_Title);
    setToolTipText(Messages.ProducePatternElementAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_EXECUTE));
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
    return AbstractPatternElement.class;
  }

  /**
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    // Get the pattern element id.
    String patternElementId = getModelElement().getId();
    // Produce the pattern element.
    PatternActivator.getDefault().producePatterns(patternElementId, true, null);
  }
  
}