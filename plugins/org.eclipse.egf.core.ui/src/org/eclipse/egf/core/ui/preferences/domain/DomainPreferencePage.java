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
package org.eclipse.egf.core.ui.preferences.domain;

import org.eclipse.egf.core.ui.preferences.AbstractPreferencePage;
import org.eclipse.egf.core.ui.preferences.IPreferenceConstants;
import org.eclipse.egf.core.ui.preferences.Messages;
import org.eclipse.jface.preference.RadioGroupFieldEditor;


/**
 * Implements the preference page related to the 'Domain' concept.
 * @author Guillaume Brocard
 */
public class DomainPreferencePage extends AbstractPreferencePage {
  /**
   * @see org.eclipse.egf.core.ui.preferences.AbstractPreferencePage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return Messages.DomainPreferencePage_Description;
  }

  /**
   * @see org.eclipse.egf.core.ui.preferences.AbstractPreferencePage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.DomainPreferencePage_Title;
  }

  /**
   * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
   */
  @Override
  protected void createFieldEditors() {
    // Available Domain editors choice group.
    String[][] availableDomainEditors =
                                        new String[][] { { Messages.DomainPreferencePage_EcoreEditor_Title, IPreferenceConstants.ECORE_EDITOR_ID },
                                                        { Messages.DomainPreferencePage_GraphicalEcoreEditor_Title, IPreferenceConstants.GRAPHICAL_ECORE_EDITOR_ID } };
    RadioGroupFieldEditor positionRadioGroup =
                                               new RadioGroupFieldEditor(IPreferenceConstants.DOMAIN_EDITOR_ID,
                                                                         Messages.DomainPreferencePage_EditorChoice_Title, 2, availableDomainEditors,
                                                                         getFieldEditorParent(), true);
    addField(positionRadioGroup);
  }
}