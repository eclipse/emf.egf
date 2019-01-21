/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.internal.preferences;

import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Implement the EGF general preference page.
 * 
 * @author Xavier Maysonnave
 */
public class EGFGeneralPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

  /**
   * The default constructor
   */
  public EGFGeneralPreferencePage() {
    super();
    setPreferenceStore(EGFCoreUIPlugin.getDefault().getPreferenceStore());
    setTitle(CoreUIMessages.EGFGeneralPreferencePage_Title);
    setDescription(CoreUIMessages.EGFGeneralPreferencePage_Description);
  }

  /**
   * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
   */
  public void init(IWorkbench workbench_p) {
    // Nothing to do.
  }

  @Override
  protected void createFieldEditors() {
    // Nothing to do
  }

}