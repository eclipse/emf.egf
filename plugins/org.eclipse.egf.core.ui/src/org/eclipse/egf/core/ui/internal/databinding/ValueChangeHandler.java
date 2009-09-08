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
package org.eclipse.egf.core.ui.internal.databinding;

import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage;


/**
 * Compute the referenced factory component id when the end-user has entered a referenced factory component name.
 * @author fournier
 */
public abstract class ValueChangeHandler extends UpdateWizardPage {
  /**
   * @param wizard_p
   */
  public ValueChangeHandler(AbstractModelElementWizardPage wizardPage_p) {
    super(wizardPage_p);
  }

  /**
   * Process the value change event.
   * @param event_p
   */
  protected abstract void doHandleValueChange(ValueChangeEvent event_p);

  /**
   * @see org.eclipse.core.databinding.observable.value.IValueChangeListener#handleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
   */
  @Override
  public final void handleValueChange(ValueChangeEvent event_p) {
    doHandleValueChange(event_p);
    // Finally, call super method to update the wizard page.
    super.handleValueChange(event_p);
  }
}