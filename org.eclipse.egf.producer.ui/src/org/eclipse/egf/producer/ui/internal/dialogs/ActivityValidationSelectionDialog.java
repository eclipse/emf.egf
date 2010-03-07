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
package org.eclipse.egf.producer.ui.internal.dialogs;

import java.util.List;

import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.provider.FcoreItemProviderAdapterFactory;
import org.eclipse.egf.model.fprod.provider.FprodItemProviderAdapterFactory;
import org.eclipse.egf.model.resource.ModelResourceItemProviderAdapterFactory;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.egf.producer.ui.l10n.ProducerUIMessages;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class ActivityValidationSelectionDialog extends AbstractCheckboxSelectionDialog {

  private final String SETTINGS_ID = EGFProducerUIPlugin.getDefault().getPluginID() + ".SCOPED_SAVE_SELECTION_DIALOG"; //$NON-NLS-1$

  private Button _savePreferences;

  private List<Activity> _activities;

  private ComposedAdapterFactory _adapterFactory;

  public ActivityValidationSelectionDialog(Shell parentShell, List<Activity> activities) {
    super(parentShell);
    _activities = activities;
    setTitle(ProducerUIMessages.ActivitySelectionDialog_Title);
    setShellStyle(getShellStyle() | SWT.RESIZE);
    setShowSelectAllButtons(true);
    // Create an adapter factory that yields item providers.
    _adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    _adapterFactory.addAdapterFactory(new ModelResourceItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new FprodItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new FcoreItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getContentProvider()
   */
  @Override
  protected IContentProvider getContentProvider() {
    return new AdapterFactoryContentProvider(_adapterFactory);
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getLabelProvider()
   */
  @Override
  protected ILabelProvider getLabelProvider() {
    return new LabelProvider() {
      ILabelProvider _labelProvider = new AdapterFactoryLabelProvider(_adapterFactory);

      @Override
      public String getText(Object object) {
        return _labelProvider.getText(object);
      }

      @Override
      public Image getImage(Object object) {
        return _labelProvider.getImage(object);
      }
    };
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getDialogSettingsId()
   */
  @Override
  protected String getDialogSettingsId() {
    return SETTINGS_ID;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getViewerInput()
   */
  @Override
  protected Object getViewerInput() {
    return new ItemProvider(_adapterFactory, _activities);
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getViewerLabel()
   */
  @Override
  protected String getViewerLabel() {
    return ProducerUIMessages.ActivitySelectionDialog_Select;
  }

  /**
   * Returns the list of initial element selections.
   * 
   * @return List
   */
  @Override
  protected List<?> getInitialElementSelections() {
    return _activities;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog# addCustomFooterControls(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void addCustomFooterControls(Composite parent) {
    super.addCustomFooterControls(parent);
    _savePreferences = new Button(parent, SWT.CHECK);
    _savePreferences.setText(ProducerUIMessages.ActivitySelectionDialog_Never_Validate);
    _savePreferences.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        getCheckBoxTableViewer().setAllChecked(_savePreferences.getSelection());
      }
    });
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#okPressed()
   */
  @Override
  protected void okPressed() {
    IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
    String val = (_savePreferences.getSelection() ? MessageDialogWithToggle.NEVER : MessageDialogWithToggle.PROMPT);
    store.setValue(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH, val);
    super.okPressed();
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog# addViewerListeners(org.eclipse.jface.viewers.StructuredViewer)
   */
  @Override
  protected void addViewerListeners(StructuredViewer viewer) {
    // Override to remove listener that affects the ok button
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#isValid()
   */
  @Override
  protected boolean isValid() {
    return true;
  }

}
