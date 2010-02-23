/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.core.ui.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelPreferenceInitializer extends AbstractPreferenceInitializer {

  public ModelPreferenceInitializer() {
    super();
  }

  /**
   * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
   */
  @Override
  public void initializeDefaultPreferences() {
    final IPreferenceStore prefs = EGFCoreUIPlugin.getDefault().getPreferenceStore();
    prefs.setDefault(IEGFModelConstants.VALIDATE_TYPES, true);
    prefs.setDefault(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH, MessageDialogWithToggle.PROMPT);
    prefs.setDefault(IEGFModelConstants.EDIT_LOADED_RESOURCES, false);
  }

}
