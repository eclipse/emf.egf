/**
 *  Copyright (c) 2007, 2009 La Carotte Et Le Baton.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      La Carotte Et Le Baton - initial API and implementation
 */
package org.eclipse.egf.core.ui.preferences;

import java.io.IOException;

import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Base class to implement preference pages.
 * 
 * @author Guillaume Brocard
 */
public abstract class AbstractPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
  /**
   * Constructor.
   */
  public AbstractPreferencePage() {
    super(GRID);
    IPreferenceStore preferenceStore = EGFCoreUIPlugin.getDefault().getPreferenceStore();
    setPreferenceStore(preferenceStore);
    setTitle(getPageTitle());
    setDescription(getPageDescription());
  }

  /**
   * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
   */
  public void init(IWorkbench workbench_p) {
    // Nothing to do.
  }

  /**
   * Get the title of this preference page.
   * 
   * @return
   */
  protected abstract String getPageTitle();

  /**
   * Get the description of this preference page.
   * 
   * @return
   */
  protected abstract String getPageDescription();

  /**
   * @see org.eclipse.jface.preference.FieldEditorPreferencePage#performOk()
   */
  @Override
  public boolean performOk() {
    boolean ok = super.performOk();
    IPreferenceStore store = getPreferenceStore();
    if (store instanceof IPersistentPreferenceStore) {
      try {
        ((IPersistentPreferenceStore) store).save();
      } catch (IOException ioe) {
        String msg = new String("AbstractPreferencePage.performOk(..) _"); //$NON-NLS-1$
        EGFCoreUIPlugin.getDefault().log(msg, ioe);
        if (EGFCoreUIPlugin.getDefault().isDebugging()) {
          EGFConsolePlugin.getConsole().logThrowable(msg, ioe);
        }
        return false;
      }
    }
    return ok;
  }

}