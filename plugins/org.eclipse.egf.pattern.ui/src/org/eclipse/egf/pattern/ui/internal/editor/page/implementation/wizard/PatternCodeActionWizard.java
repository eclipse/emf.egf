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

import java.util.List;

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.jface.wizard.IWizardPage;


/**
 * Pattern code action creation wizard.<br>
 * Does handle the selection of the action type, and the selection of the action parameter, depending on selected type.
 * @author Guillaume Brocard
 */
public class PatternCodeActionWizard extends AbstractPatternCodeWizard {
  /**
   * Get available actions for construction.
   */
  private List<String> _availableActions;

  /**
   * Constructor.
   * @param patternData_p
   * @param newPatternCodeAction_p
   * @param availableActions_p
   * @param allowNextAndBack_p
   */
  public PatternCodeActionWizard(PatternData patternData_p, Couple<String, String> newPatternCodeAction_p, List<String> availableActions_p, boolean allowNextAndBack_p) {
    super(patternData_p, newPatternCodeAction_p);
    _availableActions = availableActions_p;
    // Force to have the next and previous button
    setForcePreviousAndNextButtons(allowNextAndBack_p);
    // Set title.
    setWindowTitle(Messages.PatternCodeActionWizard_Title);
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#canFinish()
   */
  @Override
  public boolean canFinish() {
    IWizardPage currentPage = getContainer().getCurrentPage();
    boolean result = currentPage.isPageComplete();
    if (result && (currentPage == getPage(PatternCodeActionTypeSelectionPage.PAGE_ID))) {
      result = PatternConstants.PC_TAG_SUPER.equals(getActionType());
    }
    return result;
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#addPages()
   */
  @Override
  public void addPages() {
    addPage(new PatternCodeActionTypeSelectionPage());
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    return (null != getActionType());
  }

  /**
   * Get available actions.
   * @return
   */
  protected List<String> getAvailableActions() {
    return _availableActions;
  }
}
