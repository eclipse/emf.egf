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

import org.eclipse.egf.common.ui.fields.BooleanFieldEditor2;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFModelPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

  private BooleanFieldEditor2 _validateTypes = null;

  public EGFModelPreferencePage() {
    super(GRID);
    setDescription(CoreUIMessages.EGFModelPreferencePage_General);
    setPreferenceStore(EGFCoreUIPlugin.getDefault().getPreferenceStore());
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
   */
  public void init(IWorkbench workbench) {
    // Nothing to do
  }

  @Override
  protected void createFieldEditors() {

    _validateTypes = new BooleanFieldEditor2(IEGFModelConstants.VALIDATE_TYPES, CoreUIMessages.EGFModelPreferencePage_Validate_Types, SWT.NONE, getFieldEditorParent());
    addField(_validateTypes);

    Dialog.applyDialogFont(getFieldEditorParent());
    getPreferenceStore().addPropertyChangeListener(this);

  }

}
