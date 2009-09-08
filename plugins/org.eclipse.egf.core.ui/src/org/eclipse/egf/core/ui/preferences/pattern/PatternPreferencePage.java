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
package org.eclipse.egf.core.ui.preferences.pattern;

import org.eclipse.egf.core.ui.preferences.AbstractPreferencePage;
import org.eclipse.egf.core.ui.preferences.IPreferenceConstants;
import org.eclipse.egf.core.ui.preferences.Messages;
import org.eclipse.jface.preference.RadioGroupFieldEditor;


/**
 * Implements the preference page related to the 'Factory Component' concept.
 * @author Guillaume Brocard
 */
public class PatternPreferencePage extends AbstractPreferencePage {
  /**
   * @see org.eclipse.egf.core.ui.preferences.AbstractPreferencePage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return Messages.PatternPreferencePage_Description;
  }

  /**
   * @see org.eclipse.egf.core.ui.preferences.AbstractPreferencePage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.PatternPreferencePage_Title;
  }

  /**
   * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
   */
  @Override
  protected void createFieldEditors() {
    // Available choices.
    String[][] choices =
                         new String[][] {
                                         { Messages.PatternPreferencePage_ExecuteWithPreValidation_Title, IPreferenceConstants.EXECUTION_WITH_PRE_VALIDATION },
                                         { Messages.PatternPage_ExecuteWithoutValidation_Title, IPreferenceConstants.EXECUTION_WITHOUT_VALIDATION } };
    RadioGroupFieldEditor positionRadioGroup =
                                               new RadioGroupFieldEditor(IPreferenceConstants.PATTERN_EXECUTION_MODE, Messages.PatternPage_Execution_Title,
                                                                         2, choices, getFieldEditorParent(), true);
    addField(positionRadioGroup);
  }
}
