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
package org.eclipse.egf.core.ui;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.egf.core.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;


/**
 * EGF preferences initializer.
 * @author Guillaume Brocard
 */
public class EgfPreferencesInitializer extends AbstractPreferenceInitializer {
  /**
   * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
   */
  @Override
  public void initializeDefaultPreferences() {
    IPreferenceStore preferenceStore = EgfUiActivator.getDefault().getPreferenceStore();
    // Set the default domain editor.
    preferenceStore.setDefault(IPreferenceConstants.DOMAIN_EDITOR_ID, IPreferenceConstants.GRAPHICAL_ECORE_EDITOR_ID);
    // Set the default FC execution mode.
    preferenceStore.setDefault(IPreferenceConstants.FC_EXECUTION_MODE, IPreferenceConstants.EXECUTION_WITH_PRE_VALIDATION);
    // Set the default Pattern execution mode.
    preferenceStore.setDefault(IPreferenceConstants.PATTERN_EXECUTION_MODE, IPreferenceConstants.EXECUTION_WITH_PRE_VALIDATION);
  }
}