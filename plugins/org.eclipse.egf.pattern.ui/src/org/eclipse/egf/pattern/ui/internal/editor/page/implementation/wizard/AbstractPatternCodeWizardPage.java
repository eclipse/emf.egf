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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.egf.pattern.ui.editor.page.PatternImplementationPage;
import org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizardPage;

/**
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternCodeWizardPage extends AbstractPatternWizardPage {
  
  /**
   * Constructor.
   * @param pageId_p
   */
  public AbstractPatternCodeWizardPage(String pageId_p) {
    super(pageId_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return PatternUiActivator.getDefault().getPluginID() + ICommonConstants.DOT_CHARACTER + PatternImplementationPage.ID;
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getWizard()
   */
  @Override
  public AbstractPatternCodeWizard getWizard() {
    return (AbstractPatternCodeWizard) super.getWizard();
  }
  
}
