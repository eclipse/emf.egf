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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard;

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizard;
import org.eclipse.jface.wizard.IWizardPage;


/**
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternCodeWizard extends AbstractPatternWizard {
  /**
   * Pattern data.
   */
  private PatternData _patternData;
  /**
   * New pattern code action to fill in given wizard.
   */
  private Couple<String, String> _patternCodeAction;

  /**
   * Constructor.
   * @param patternData_p
   * @param patternCodeAction_p
   */
  public AbstractPatternCodeWizard(PatternData patternData_p, Couple<String, String> patternCodeAction_p) {
    _patternData = patternData_p;
    _patternCodeAction = patternCodeAction_p;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizard#doGetPage(java.lang.String)
   */
  @Override
  protected IWizardPage doGetPage(String pageId_p) {
    IWizardPage result = null;
    if (PatternIdParameterSelectionPage.PAGE_ID.equals(pageId_p)) {
      result = new PatternIdParameterSelectionPage();
    } else if (MethodNameParameterSelectionPage.PAGE_ID.equals(pageId_p)) {
      result = new MethodNameParameterSelectionPage();
    } else if (SuperMethodNameParameterSelectionPage.EXTENDED_PAGE_ID.equals(pageId_p)) {
      result = new SuperMethodNameParameterSelectionPage();
    }
    return result;
  }

  /**
   * Set action type.
   * @param actionType_p
   */
  protected void setActionType(String actionType_p) {
    _patternCodeAction.setKey(actionType_p);
  }

  /**
   * Get action type.
   * @return
   */
  protected String getActionType() {
    return _patternCodeAction.getKey();
  }

  /**
   * Get action parameter.
   * @return
   */
  protected String getActionParameter() {
    return _patternCodeAction.getValue();
  }

  /**
   * Set action parameter.
   * @param actionParameter_p
   */
  protected void setActionParameter(String actionParameter_p) {
    _patternCodeAction.setValue(actionParameter_p);
  }

  /**
   * Get pattern data.
   * @return
   */
  protected PatternData getPatternData() {
    return _patternData;
  }
}
