/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.preferences;

/**
 * Implement the EGF general preference page.
 * 
 * @author Guillaume Brocard
 */
public class EGFGeneralPreferencePage extends AbstractPreferencePage {

  /**
   * @see org.eclipse.egf.core.preferences.AbstractPreferencePage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return Messages.EgfGeneralPreferencePage_Description;
  }

  /**
   * @see org.eclipse.egf.core.preferences.AbstractPreferencePage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.EgfGeneralPreferencePage_Title;
  }

  /**
   * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
   */
  @Override
  protected void createFieldEditors() {
    // Do nothing.
  }

}