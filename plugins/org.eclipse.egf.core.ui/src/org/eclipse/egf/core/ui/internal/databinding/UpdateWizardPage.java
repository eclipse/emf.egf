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

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage;


/**
 * Update the wizard page buttons when this listener is called.
 * @author fournier
 */
public class UpdateWizardPage implements IValueChangeListener, IListChangeListener {
  /**
   * Handled wizard page.
   */
  private AbstractModelElementWizardPage _wizardPage;

  /**
   * Constructor.
   */
  public UpdateWizardPage(AbstractModelElementWizardPage wizardPage_p) {
    _wizardPage = wizardPage_p;
  }

  /**
   * @see org.eclipse.core.databinding.observable.value.IValueChangeListener#handleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
   */
  public void handleValueChange(ValueChangeEvent event_p) {
    doUpdateWizardPage();
  }

  /**
   * @see org.eclipse.core.databinding.observable.list.IListChangeListener#handleListChange(org.eclipse.core.databinding.observable.list.ListChangeEvent)
   */
  public void handleListChange(ListChangeEvent event_p) {
    doUpdateWizardPage();
  }

  /**
   * Update the wizard page set through the constructor.
   */
  protected void doUpdateWizardPage() {
    _wizardPage.updateButtons();
  }
}
