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
package org.eclipse.egf.pattern.ui.internal.editor.page.specification.wizard;

import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizard;
import org.eclipse.jface.wizard.IWizardPage;


/**
 * Pattern parameter wizard.
 * @author Guillaume Brocard
 */
public class ParameterWizard extends AbstractPatternWizard {
  /**
   * Parameter to fill.
   */
  private ParameterRelation _parameter;

  /**
   * Constructor.
   * @param parameter_p
   */
  public ParameterWizard(ParameterRelation parameter_p) {
    _parameter = parameter_p;
    setWindowTitle(Messages.ParameterWizard_Title);
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#addPages()
   */
  @Override
  public void addPages() {
    // Trigger the get page method on correct id, the page will be added automatically as a result.
    getPage(ParameterTypeSelectionPage.PAGE_ID);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizard#doGetPage(java.lang.String)
   */
  @Override
  protected IWizardPage doGetPage(String pageId_p) {
    IWizardPage result = null;
    if (ParameterTypeSelectionPage.PAGE_ID.equals(pageId_p)) {
      result = new ParameterTypeSelectionPage();
    }
    return result;
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    return (null != _parameter.getType());
  }

  /**
   * Get parameter.
   * @return
   */
  public ParameterRelation getParameter() {
    return _parameter;
  }
}
