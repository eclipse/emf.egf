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

import org.eclipse.egf.common.ui.fields.BooleanFieldEditor2;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFEditorsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

  private BooleanFieldEditor2 _editLoadedResource = null;

  public EGFEditorsPreferencePage() {
    setTitle(CoreUIMessages.EGFEditorsPreferencePage_Title);
    setDescription(CoreUIMessages.EGFEditorsPreferencePage_Description);
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

  /**
   * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
   */
  @Override
  protected void createFieldEditors() {
    // do nothing we overload the create contents method
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

    Group group = new Group(composite, SWT.NONE);
    group.setLayout(new GridLayout(1, false));
    group.setText(CoreUIMessages.EGFEditorsPreferencePage_Loading);
    group.setFont(parent.getFont());
    gd = new GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = 1;
    group.setLayoutData(gd);

    _editLoadedResource = new BooleanFieldEditor2(IEGFModelConstants.EDIT_LOADED_RESOURCES, CoreUIMessages.EGFEditorsPreferencePage_Loading_Resources, SWT.NONE, group);
    _editLoadedResource.setPreferenceStore(EGFCoreUIPlugin.getDefault().getPreferenceStore());
    addField(_editLoadedResource);

    initialize();
    checkState();

    return composite;

  }

}
