/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */

package org.eclipse.egf.task.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.egf.task.ui.EGFTaskUIPlugin;
import org.eclipse.egf.task.ui.preferences.constants.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

    /*
     * (non-Javadoc)
     * 
     * @seeorg.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
     * initializeDefaultPreferences()
     */
    public void initializeDefaultPreferences() {

        IPreferenceStore store = EGFTaskUIPlugin.getDefault().getPreferenceStore();
        store.setDefault(PreferenceConstants.P_BOOLEAN, true);
        store.setDefault(PreferenceConstants.P_RUBY_PATH, ""); //$NON-NLS-1$

    }

}
