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
package org.eclipse.egf.pde.internal.ui.wizard.page;

import java.util.Locale;
import java.util.TreeSet;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.pde.internal.ui.IHelpContextIds;
import org.eclipse.egf.pde.ui.wizard.Messages;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.pde.internal.core.util.PDEJavaHelper;
import org.eclipse.pde.internal.core.util.VMUtil;
import org.eclipse.pde.internal.ui.PDEUIMessages;
import org.eclipse.pde.internal.ui.SWTFactory;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.plugin.AbstractFieldData;
import org.eclipse.pde.internal.ui.wizards.plugin.ContentPage;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationPage;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;


/**
 * Define the plug-in content that hosts the factory component.<br>
 * The code was copied from org.eclipse.pde.internal.ui.wizards.plugin.PluginContentPage
 */
public class FactoryComponentContentPage extends ContentPage {
  private final static String S_GENERATE_ACTIVATOR = "generateActivator"; //$NON-NLS-1$
  private final static String S_UI_PLUGIN = "uiPlugin"; //$NON-NLS-1$
  private final static String S_TEMPLATE_BASED_FACTORY_COMPONENT = "templateBasedFactoryComponent"; //$NON-NLS-1$
  protected final static int P_CLASS_GROUP = 2;
  private final static String NO_EXECUTION_ENVIRONMENT = PDEUIMessages.PluginContentPage_noEE;
  private final static String S_API_ANALYSIS = "apiAnalysis"; //$NON-NLS-1$
  protected Text fClassText;
  protected Label fClassLabel;
  protected Button fGenerateClass;
  private Button fUIPlugin;

  private Label _label;
  private Button _yesButton;
  private Button _noButton;

  private Label fEELabel;
  private Combo fEEChoice;
  private Button fExeEnvButton;

  /**
   * Button to enable API analysis for the project during project creation
   */
  private Button fApiAnalysisButton;

  private Group _fcGroup;

  private ModifyListener _classListener = new ModifyListener() {
    @SuppressWarnings("synthetic-access")
    public void modifyText(ModifyEvent e) {
      if (fInitialized)
        fChangedGroups |= P_CLASS_GROUP;
      validatePage();
    }
  };

  public FactoryComponentContentPage(String pageName, IProjectProvider provider, NewProjectCreationPage page, AbstractFieldData data) {
    super(pageName, provider, page, data);
    setTitle(Messages.FactoryComponentContentPage_Title);
    setDescription(Messages.FactoryComponentContentPage_Description);
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.pde.internal.ui.wizards.plugin.ContentPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    container.setLayout(new GridLayout());

    createPluginPropertiesGroup(container);
    createPluginClassGroup(container);
    createFactoryComponentGroup(container);

    Dialog.applyDialogFont(container);
    setControl(container);
    PlatformUI.getWorkbench().getHelpSystem().setHelp(container, IHelpContextIds.NEW_FACTORY_COMPONENT_CONTENT_WIZARD_PAGE);
  }

  private void createPluginPropertiesGroup(Composite container) {
    Group propertiesGroup = SWTFactory.createGroup(container, PDEUIMessages.ContentPage_pGroup, 3, 1, GridData.FILL_HORIZONTAL);

    Label label = new Label(propertiesGroup, SWT.NONE);
    label.setText(PDEUIMessages.ContentPage_pid);
    fIdText = createText(propertiesGroup, propertiesListener, 2);
    fIdText.setEditable(false);

    label = new Label(propertiesGroup, SWT.NONE);
    label.setText(PDEUIMessages.ContentPage_pversion);
    fVersionText = createText(propertiesGroup, propertiesListener, 2);

    label = new Label(propertiesGroup, SWT.NONE);
    label.setText(PDEUIMessages.ContentPage_pname);
    fNameText = createText(propertiesGroup, propertiesListener, 2);

    label = new Label(propertiesGroup, SWT.NONE);
    label.setText(PDEUIMessages.ContentPage_pprovider);
    fProviderText = createText(propertiesGroup, propertiesListener, 2);

    createExecutionEnvironmentControls(propertiesGroup);
  }

  /**
   * Creates all of the EE widgets
   * @param container
   */
  @SuppressWarnings("unchecked")
  private void createExecutionEnvironmentControls(Composite container) {
    // Create label
    fEELabel = new Label(container, SWT.NONE);
    fEELabel.setText(PDEUIMessages.NewProjectCreationPage_executionEnvironments_label);

    // Create combo
    fEEChoice = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
    fEEChoice.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    // Gather EEs
    IExecutionEnvironment[] exeEnvs = VMUtil.getExecutionEnvironments();
    TreeSet availableEEs = new TreeSet();
    for (int i = 0; i < exeEnvs.length; i++) {
      availableEEs.add(exeEnvs[i].getId());
    }
    availableEEs.add(NO_EXECUTION_ENVIRONMENT);

    // Set data
    fEEChoice.setItems((String[]) availableEEs.toArray(new String[availableEEs.size() - 1]));
    fEEChoice.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        validatePage();
      }
    });

    // Set default EE based on strict match to default VM
    IVMInstall defaultVM = JavaRuntime.getDefaultVMInstall();
    String[] EEChoices = fEEChoice.getItems();
    for (int i = 0; i < EEChoices.length; i++) {
      if (!EEChoices[i].equals(NO_EXECUTION_ENVIRONMENT)) {
        if (VMUtil.getExecutionEnvironment(EEChoices[i]).isStrictlyCompatible(defaultVM)) {
          fEEChoice.select(i);
          break;
        }
      }
    }

    // Create button
    fExeEnvButton = new Button(container, SWT.PUSH);
    fExeEnvButton.setLayoutData(new GridData());
    fExeEnvButton.setText(PDEUIMessages.NewProjectCreationPage_environmentsButton);
    fExeEnvButton.addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event event) {
        PreferencesUtil.createPreferenceDialogOn(getShell(), "org.eclipse.jdt.debug.ui.jreProfiles", //$NON-NLS-1$
            new String[] { "org.eclipse.jdt.debug.ui.jreProfiles" }, null).open(); //$NON-NLS-1$ 
      }
    });
  }

  private void createPluginClassGroup(Composite container) {
    Group classGroup = SWTFactory.createGroup(container, PDEUIMessages.ContentPage_pClassGroup, 2, 1, GridData.FILL_HORIZONTAL);

    IDialogSettings settings = getDialogSettings();

    fGenerateClass =
        SWTFactory.createCheckButton(classGroup, PDEUIMessages.ContentPage_generate, null, (settings != null) ? !settings.getBoolean(S_GENERATE_ACTIVATOR)
                                                                                                             : true, 2);
    fGenerateClass.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        fClassLabel.setEnabled(fGenerateClass.getSelection());
        fClassText.setEnabled(fGenerateClass.getSelection());
        updateData();
        validatePage();
      }
    });

    fClassLabel = new Label(classGroup, SWT.NONE);
    fClassLabel.setText(PDEUIMessages.ContentPage_classname);
    GridData gd = new GridData();
    gd.horizontalIndent = 20;
    fClassLabel.setLayoutData(gd);
    fClassText = createText(classGroup, _classListener);

    fUIPlugin =
        SWTFactory.createCheckButton(classGroup, PDEUIMessages.ContentPage_uicontribution, null, (settings != null) ? !settings.getBoolean(S_UI_PLUGIN) : true,
            2);
    fUIPlugin.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        updateData();
        validatePage();
      }
    });

    fApiAnalysisButton = SWTFactory.createCheckButton(classGroup, PDEUIMessages.PluginContentPage_enable_api_analysis, null, false, 2);
    fApiAnalysisButton.setSelection((settings != null) ? settings.getBoolean(S_API_ANALYSIS) : false);
    fApiAnalysisButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        updateData();
        validatePage();
      }
    });
  }

  /**
   * @see org.eclipse.pde.internal.ui.wizards.plugin.ContentPage#updateData()
   */
  @Override
  public void updateData() {
    super.updateData();
    PluginFieldData data = (PluginFieldData) fData;
    data.setClassname(fClassText.getText().trim());
    data.setUIPlugin(fUIPlugin.getSelection());
    data.setDoGenerateClass(fGenerateClass.isEnabled() && fGenerateClass.getSelection());
    data.setRCPApplicationPlugin(!fData.isSimple() && !isPureOSGi() && _yesButton.getSelection());
    data.setEnableAPITooling(fApiAnalysisButton.getSelection());
    if (fEEChoice.isEnabled() && !fEEChoice.getText().equals(NO_EXECUTION_ENVIRONMENT)) {
      fData.setExecutionEnvironment(fEEChoice.getText().trim());
    } else {
      fData.setExecutionEnvironment(null);
    }
  }

  private void createFactoryComponentGroup(Composite container) {
    _fcGroup = new Group(container, SWT.NONE);
    _fcGroup.setLayout(new GridLayout(2, false));
    _fcGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    _fcGroup.setText(Messages.FactoryComponentContentPage_FactoryComponentGroup_Title);

    createFactoryComponentQuestion(_fcGroup, 2);
  }

  private void createFactoryComponentQuestion(Composite parent, int horizontalSpan) {
    Composite comp = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout(3, false);
    layout.marginHeight = layout.marginWidth = 0;
    comp.setLayout(layout);
    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = horizontalSpan;
    comp.setLayoutData(gd);

    _label = new Label(comp, SWT.NONE);
    _label.setText(Messages.FactoryComponentContentPage_FactoryComponentModelQuestion_Title);
    _label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    IDialogSettings settings = getDialogSettings();
    boolean templateBasedFc = (settings != null) ? settings.getBoolean(S_TEMPLATE_BASED_FACTORY_COMPONENT) : false;

    _yesButton = new Button(comp, SWT.RADIO);
    _yesButton.setText(PDEUIMessages.PluginContentPage_yes);
    _yesButton.setSelection(templateBasedFc);
    gd = new GridData();
    gd.widthHint = getButtonWidthHint(_yesButton);
    _yesButton.setLayoutData(gd);
    _yesButton.addSelectionListener(new SelectionAdapter() {
      @SuppressWarnings("synthetic-access")
      @Override
      public void widgetSelected(SelectionEvent e) {
        updateData();
        getContainer().updateButtons();
      }
    });

    _noButton = new Button(comp, SWT.RADIO);
    _noButton.setText(PDEUIMessages.PluginContentPage_no);
    _noButton.setSelection(!templateBasedFc);
    gd = new GridData();
    gd.widthHint = getButtonWidthHint(_noButton);
    _noButton.setLayoutData(gd);
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
   */
  @Override
  public boolean canFlipToNextPage() {
    return isTemplateBasedFactoryComponentCreation();
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
   */
  @Override
  public boolean isPageComplete() {
    return super.isPageComplete() && !isTemplateBasedFactoryComponentCreation();
  }

  /**
   * Return true when the end-user has chosen to create its factory component from a template based factory component.
   * @return
   */
  private boolean isTemplateBasedFactoryComponentCreation() {
    PluginFieldData data = (PluginFieldData) fData;
    // Really sorry, it is named like a pig. But this property is set when the end-user has chosen to use template based factory component to create one.
    return data.isRCPApplicationPlugin();
  }

  /**
   * @see org.eclipse.pde.internal.ui.wizards.plugin.ContentPage#setVisible(boolean)
   */
  @Override
  public void setVisible(boolean visible) {
    if (visible) {
      fMainPage.updateData();
      fGenerateClass.setEnabled(!fData.isSimple());
      fClassLabel.setEnabled(!fData.isSimple() && fGenerateClass.getSelection());
      fClassText.setEnabled(!fData.isSimple() && fGenerateClass.getSelection());
      boolean wasUIPluginEnabled = fUIPlugin.isEnabled();
      fUIPlugin.setEnabled(!fData.isSimple() && !isPureOSGi());
      // if fUIPlugin is disabled, set selection to false
      if (!fUIPlugin.isEnabled()) {
        fUIPlugin.setSelection(false);
      }
      // if the fUIPlugin was disabled and is now enabled, then set the selection to true
      else if (!wasUIPluginEnabled) {
        fUIPlugin.setSelection(true);
      }

      // plug-in class group
      if (((fChangedGroups & P_CLASS_GROUP) == 0)) {
        int oldfChanged = fChangedGroups;
        fClassText.setText(computeId().toLowerCase(Locale.ENGLISH) + ".Activator"); //$NON-NLS-1$
        fChangedGroups = oldfChanged;
      }

      boolean allowEESelection = !fData.isSimple() && fData.hasBundleStructure();
      fEELabel.setEnabled(allowEESelection);
      fEEChoice.setEnabled(allowEESelection);
      fExeEnvButton.setEnabled(allowEESelection);

      _fcGroup.setVisible(!fData.isSimple() && !isPureOSGi());
    }
    super.setVisible(visible);
  }

  private boolean isPureOSGi() {
    return ((PluginFieldData) fData).getOSGiFramework() != null;
  }

  /**
   * @see org.eclipse.pde.internal.ui.wizards.plugin.ContentPage#validatePage()
   */
  @Override
  protected void validatePage() {
    String errorMessage = validateProperties();
    if (errorMessage == null && fGenerateClass.isEnabled() && fGenerateClass.getSelection()) {
      IStatus status =
          JavaConventions.validateJavaTypeName(fClassText.getText().trim(), PDEJavaHelper.getJavaSourceLevel(null), PDEJavaHelper.getJavaComplianceLevel(null));
      if (status.getSeverity() == IStatus.ERROR) {
        errorMessage = status.getMessage();
      } else if (status.getSeverity() == IStatus.WARNING) {
        setMessage(status.getMessage(), IMessageProvider.WARNING);
      }
    }
    setErrorMessage(errorMessage);
    setPageComplete(errorMessage == null);
  }

  private static int getButtonWidthHint(Button button) {
    if (button.getFont().equals(JFaceResources.getDefaultFont()))
      button.setFont(JFaceResources.getDialogFont());
    return Math.max(50, button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);
  }
}
