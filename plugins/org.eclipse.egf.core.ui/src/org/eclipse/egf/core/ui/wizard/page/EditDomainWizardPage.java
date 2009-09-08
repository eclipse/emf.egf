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
package org.eclipse.egf.core.ui.wizard.page;

import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;


/**
 * Implements the domain wizard page.
 * @author fournier
 */
public class EditDomainWizardPage extends AbstractDomainWizardPage {
  
  /**
   * Constructor.
   * @param pageName_p
   */
  public EditDomainWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public EditDomainWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    createDomainFileFieldEditor(parent_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    return isDomainSelectedExist();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.DomainWizardPage_Title;
  }
  
}
