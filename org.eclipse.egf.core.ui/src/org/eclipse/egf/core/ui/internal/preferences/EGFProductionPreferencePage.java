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
package org.eclipse.egf.core.ui.internal.preferences;

import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Implement the EGF general preference page.
 * 
 * @author Xavier Maysonnave
 */
public class EGFProductionPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

  /**
   * The default constructor
   */
  public EGFProductionPreferencePage() {
    super();
    setPreferenceStore(EGFCoreUIPlugin.getDefault().getPreferenceStore());
    setTitle(CoreUIMessages.EGFProductionPreferencePage_Title);
    setDescription(CoreUIMessages.EGFProductionPreferencePage_Description);
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

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createContents(Composite parent) {

    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));
    composite.setFont(parent.getFont());
    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = 1;
    composite.setLayoutData(gd);

    // save dirty editors
    FieldEditor edit = new RadioGroupFieldEditor(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH, CoreUIMessages.EGFProductionPreferencePage_Validate, 3, new String[][] { { CoreUIMessages.EGFProductionPreferencePage_Validate_Always, MessageDialogWithToggle.ALWAYS }, { CoreUIMessages.EGFProductionPreferencePage_Validate_Never, MessageDialogWithToggle.NEVER }, { CoreUIMessages.EGFProductionPreferencePage_Validate_Prompt, MessageDialogWithToggle.PROMPT } }, composite, true);
    addField(edit);

    initialize();
    checkState();

    return composite;

  }

}