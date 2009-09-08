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
package org.eclipse.egf.pde.ui.template;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.IDGeneratorHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.egf.core.extensionpoint.IProductionPlanConstants;
import org.eclipse.egf.pde.internal.FactoryComponentGeneratorHelper;
import org.eclipse.egf.pde.internal.ui.IHelpContextIds;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.internal.ui.templates.PDETemplateSection;
import org.eclipse.pde.ui.templates.PluginReference;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.TemplateOption;


/**
 * Template that creates a plug-in file with the initial structure to define an empty factory component.
 * @author fournier
 */
public class EmptyFactoryComponentTemplate extends PDETemplateSection {
  private static final String FACTORY_COMPONENT_NAME_OPTION_ID = "fcName"; //$NON-NLS-1$
  /**
   * Widget where factory component name is entered by the end-user.
   */
  private TemplateOption _fcNameOption;

  /**
   * Constructor.
   */
  public EmptyFactoryComponentTemplate() {
    setPageCount(1);
    createOptions();
  }

  /**
   * @see org.eclipse.pde.ui.templates.AbstractTemplateSection#addPages(org.eclipse.jface.wizard.Wizard)
   */
  @Override
  public void addPages(Wizard wizard) {
    WizardPage page = createPage(0, IHelpContextIds.NEW_FACTORY_COMPONENT_TEMPLATE_EMPTY_WIZARD_PAGE);
    page.setTitle(Messages.EmptyFactoryComponentTemplate_Title);
    page.setDescription(Messages.EmptyFactoryComponentTemplate_Description);
    wizard.addPage(page);
    markPagesAdded();
  }

  /**
   * Set the field data.
   * @param fieldData_p the fieldData to set
   */
  public void init(IFieldData fieldData_p) {
    _fcNameOption.setValue(fieldData_p.getId());
  }

  private void createOptions() {
    _fcNameOption = addOption(FACTORY_COMPONENT_NAME_OPTION_ID, Messages.EmptyFactoryComponentTemplate_FactoryComponent_Title, ICommonConstants.EMPTY_STRING, 0);
  }

  /**
   * @see org.eclipse.pde.ui.templates.OptionTemplateSection#getSectionId()
   */
  @Override
  public String getSectionId() {
    return "emptyFactoryComponentSectionId"; //$NON-NLS-1$
  }

  /**
   * @see org.eclipse.pde.ui.templates.AbstractTemplateSection#updateModel(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected void updateModel(IProgressMonitor monitor_p) throws CoreException {
    String contractId = IDGeneratorHelper.generatePrefixUID(IContractConstants.CONTRACT_EXTENSION_CHILD);
    String productionPlanId = IDGeneratorHelper.generatePrefixUID(IProductionPlanConstants.PRODUCTION_PLAN_EXTENSION_CHILD);
    // Create factory component extension.
    createFactoryComponentExtension(contractId, productionPlanId);
    // Create contract extension.
    createContractExtension(contractId);
    // Create production plan extension.
    createProductionPlanExtension(productionPlanId);
  }

  /**
   * @see org.eclipse.pde.ui.templates.AbstractTemplateSection#getDependencies(java.lang.String)
   */
  @Override
  public IPluginReference[] getDependencies(String schemaVersion) {
    /*
     * MDSoFa PDE must not depend on Pattern plug-in even if it generates FC that reference the pattern plug-in
     */
    String[] standardDependencies = FactoryComponentGeneratorHelper.getStandardDependencies();
    IPluginReference[] dep = { new PluginReference(standardDependencies[0], null, 0), new PluginReference(standardDependencies[1], null, 0) };
    return dep;
  }

  /**
   * @see org.eclipse.pde.internal.ui.templates.PDETemplateSection#generateFiles(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected void generateFiles(IProgressMonitor monitor_p) throws CoreException {
    super.generateFiles(monitor_p);
    // Create the 'generated' source folder.
    FactoryComponentGeneratorHelper.createGeneratedSourceFolder(project);
    // Create the 'templates' folder
    ProjectHelper.createFolder(ICommonConstants.TEMPLATES_FOLDER_PATH, project, new SubProgressMonitor(monitor_p, 1));
    // Create the 'model' folder
    ProjectHelper.createFolder(ICommonConstants.MODEL_FOLDER_PATH, project, new SubProgressMonitor(monitor_p, 1));
  }

  /**
   * @see org.eclipse.pde.internal.ui.templates.PDETemplateSection#getNewFiles()
   */
  @Override
  public String[] getNewFiles() {
    return new String[] { ICommonConstants.MODEL_FOLDER_PATH + ICommonConstants.SLASH_CHARACTER,
                         ICommonConstants.TEMPLATES_FOLDER_PATH + ICommonConstants.SLASH_CHARACTER };
  }

  /**
   * @see org.eclipse.pde.ui.templates.BaseOptionTemplateSection#isDependentOnParentWizard()
   */
  @Override
  public boolean isDependentOnParentWizard() {
    return true;
  }

  /**
   * @see org.eclipse.pde.ui.templates.AbstractTemplateSection#getNumberOfWorkUnits()
   */
  @Override
  public int getNumberOfWorkUnits() {
    return super.getNumberOfWorkUnits() + 1;
  }

  /**
   * @see org.eclipse.pde.ui.templates.ITemplateSection#getUsedExtensionPoint()
   */
  public String getUsedExtensionPoint() {
    return null;
  }

  /**
   * Create the production plan extension with entered data by the end-user.
   * @param productionPlanId_p
   */
  protected void createProductionPlanExtension(String productionPlanId_p) throws CoreException {
    IPluginBase plugin = model.getPluginBase();

    IPluginExtension extension = createExtension(IProductionPlanConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, true);
    IPluginElement element = model.getPluginFactory().createElement(extension);
    element.setName(IProductionPlanConstants.PRODUCTION_PLAN_EXTENSION_CHILD);
    element.setAttribute(ExtensionPointHelper.ATT_ID, productionPlanId_p);
    extension.add(element);
    // Finally add this extension in the plug-in.
    addExtensionInModel(plugin, extension);
  }

  /**
   * Create the contract extension with entered data by the end-user.
   * @param contractId_p
   */
  protected void createContractExtension(String contractId_p) throws CoreException {
    IPluginBase plugin = model.getPluginBase();

    IPluginExtension extension = createExtension(IContractConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, true);
    IPluginElement element = model.getPluginFactory().createElement(extension);
    element.setName(IContractConstants.CONTRACT_EXTENSION_CHILD);
    element.setAttribute(ExtensionPointHelper.ATT_ID, contractId_p);
    extension.add(element);
    // Finally add this extension in the plug-in.
    addExtensionInModel(plugin, extension);
  }

  /**
   * Create the factory component extension with entered data by the end-user.
   * @param contractId_p
   * @param productionPlanId_p
   */
  protected void createFactoryComponentExtension(String contractId_p, String productionPlanId_p) throws CoreException {
    IPluginBase plugin = model.getPluginBase();

    IPluginExtension extension = createExtension(IFactoryComponentConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID, true);
    IPluginElement element = model.getPluginFactory().createElement(extension);
    element.setName(IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_CHILD);
    // FactoryComponent name entered by the end-user.
    String fcNameEnteredByEndUser = getStringOption(FACTORY_COMPONENT_NAME_OPTION_ID);
    // FactoryComponent name is used as ID.
    element.setAttribute(ExtensionPointHelper.ATT_ID, IDGeneratorHelper.generatePrefixUID(IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_CHILD));
    element.setAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_NAME, fcNameEnteredByEndUser);
    element.setAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_CONTRACT_ID, contractId_p);
    element.setAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_PRODUCTION_PLAN_ID, productionPlanId_p);
    extension.add(element);
    // Finally add this extension in the plug-in.
    addExtensionInModel(plugin, extension);
  }

  /**
   * Add the extension in the plug-in model.
   * @param plugin_p
   * @param extension_p
   * @throws CoreException
   */
  protected void addExtensionInModel(IPluginBase plugin_p, IPluginExtension extension_p) throws CoreException {
    if (!extension_p.isInTheModel()) {
      plugin_p.add(extension_p);
    }
  }
}
