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


/**
 * Pattern code action parameter selection wizard.<br>
 * Does only handle the selection of the action parameter value, with the type already known.
 * @author Guillaume Brocard
 */
public class PatternCodeActionParameterWizard extends AbstractPatternCodeWizard {
  /**
   * Constructor.
   * @param patternData_p
   * @param patternCodeAction_p
   */
  public PatternCodeActionParameterWizard(PatternData patternData_p, Couple<String, String> patternCodeAction_p) {
    super(patternData_p, patternCodeAction_p);
    setWindowTitle(Messages.PatternCodeActionParameterWizard_Title0);
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#addPages()
   */
  @Override
  public void addPages() {
    // Trigger the get page method on correct id, the page will be added automatically as a result.
    getPage(PatternCodeActionTypeSelectionPage.getParameterPageId(getActionType()));
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    return (null != getActionParameter());
  }
}
