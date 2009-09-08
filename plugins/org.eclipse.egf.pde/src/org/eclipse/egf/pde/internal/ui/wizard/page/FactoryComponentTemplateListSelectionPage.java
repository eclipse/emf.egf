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

import org.eclipse.egf.pde.internal.ui.IHelpContextIds;
import org.eclipse.egf.pde.ui.wizard.Messages;
import org.eclipse.egf.pde.ui.wizard.NewFactoryComponentProjectWizard;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.pde.internal.ui.elements.ElementList;
import org.eclipse.pde.internal.ui.wizards.WizardElement;
import org.eclipse.pde.internal.ui.wizards.plugin.ContentPage;
import org.eclipse.pde.internal.ui.wizards.plugin.TemplateListSelectionPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;


/**
 * Page where contributed template-based factory components are displayed.
 * @author fournier
 */
public class FactoryComponentTemplateListSelectionPage extends TemplateListSelectionPage {

  /**
   * Constructor.
   * @param wizardElements_p
   * @param page_p
   * @param message_p
   */
  public FactoryComponentTemplateListSelectionPage(ElementList wizardElements_p, ContentPage page_p, String message_p) {
    super(wizardElements_p, page_p, message_p);
    setTitle(Messages.FactoryComponentTemplateListSelectionPage_Title);
    setDescription(Messages.FactoryComponentTemplateListSelectionPage_Description);
  }

  /**
   * @see org.eclipse.pde.internal.ui.wizards.plugin.TemplateListSelectionPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createControl(Composite parent_p) {
    super.createControl(parent_p);
    PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), IHelpContextIds.NEW_FACTORY_COMPONENT_TEMPLATES_WIZARD_PAGE);
  }

  /**
   * @see org.eclipse.pde.internal.ui.wizards.plugin.TemplateListSelectionPage#initializeViewer()
   */
  @Override
  protected void initializeViewer() {
    if (getInitialTemplateId() != null)
      selectInitialTemplate();
  }

  /**
   * Select the initial template.
   */
  private void selectInitialTemplate() {
    WizardElement initialWizardElement = NewFactoryComponentProjectWizard.getWizardElement(wizardElements, getInitialTemplateId());
    if (null != initialWizardElement) {
      wizardSelectionViewer.setSelection(new StructuredSelection(initialWizardElement), true);
      setSelectedNode(createWizardNode(initialWizardElement));
      setDescriptionText(initialWizardElement.getDescription());
    }
  }
}
