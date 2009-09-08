/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.wizard.page;

import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.CRadioGroupFieldEditor;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.ContextElementWizard;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;


/**
 * Implements the context element first page.
 * @author fournier
 */
public class ContextElementWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Constant used when this context element defines a simple key.
   */
  private static final String CONTEXT_ELEMENT_KEY = String.valueOf(0);
  
  /**
   * Constant used when this context element reference another contract element.
   */
  private static final String CONTEXT_ELEMENT_REFERENCE = String.valueOf(1);

  /**
   * Field editor used to select a simple type or to reference another contract element.
   */
  private CRadioGroupFieldEditor _typeGroup;

  /**
   * Constructor.
   * @param pageName_p
   */
  public ContextElementWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public ContextElementWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create the contract element type group.
    createTypeGroup(parent_p);
    // Finally, layout the page.
    handlePageLayout(parent_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#handlePageLayout(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void handlePageLayout(Composite parent_p) {
    FieldEditorHelper.layoutFieldEditor(parent_p, _typeGroup, 1);
  }

  /**
   * Create the contract element type group : Simple type or a reference to another contract element.
   * @param parent_p
   */
  private void createTypeGroup(Composite parent_p) {
    // Get the context element.
    ContextElement contextElement = (ContextElement) getModelElement();
    // Create a radio group field editor to allow the end-user to select between defining a key or references another contract element.
    String[][] labelAndValues = { 
      { Messages.ContextElementWizardPage_Group_Key, CONTEXT_ELEMENT_KEY },
      { Messages.ContextElementWizardPage_Group_Reference, CONTEXT_ELEMENT_REFERENCE } 
    };
    _typeGroup = FieldEditorHelper.createRadioGroupFieldEditor(
      parent_p, 
      Messages.ContractElementWizardPage_TypeGroup_Title, 
      1, 
      labelAndValues,
      isReadOnly()
    );
    // Check if context element has referenced a contract element ?
    ContractElementReference contractElementReference = contextElement.getContractElementReference();
    boolean hasReferencedContractElement = (null != contractElementReference);
    Object typeGroupSelection = null;
    if (hasReferencedContractElement) {
      typeGroupSelection = CONTEXT_ELEMENT_REFERENCE;
    } else {
      // If no key is defined, set as default the context element reference.
      typeGroupSelection = (null == contextElement.getKey()) ? CONTEXT_ELEMENT_REFERENCE : CONTEXT_ELEMENT_KEY;
    }
    _typeGroup.selectRadioButtonFor(typeGroupSelection);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // We can't finish in this page.
    return false;
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
   */
  @Override
  public boolean canFlipToNextPage() {
    // This first page is only used to select the right second one.
    return true;
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    IWizardPage result = null;
    // Get the checked radio button to open the right second page.
    Object radioButtonValue = _typeGroup.getSelectedRadioButton();
    IWizard wizard = getWizard();
    if (CONTEXT_ELEMENT_KEY.equals(radioButtonValue)) {
      result = wizard.getPage(ContextElementWizard.CONTEXT_ELEMENT_KEY_PAGE);
    } else if (CONTEXT_ELEMENT_REFERENCE.equals(radioButtonValue)) {
      result = wizard.getPage(ContextElementWizard.CONTEXT_ELEMENT_REFERENCE_PAGE);
    }
    return result;
  }

  /**
   * Is the current context element referencing a contract element ?
   * @return <code>true</code> means the context element matches a contract element.
   */
  public boolean isReferencingContractElement() {
    Object radioButtonValue = _typeGroup.getSelectedRadioButton();
    return CONTEXT_ELEMENT_REFERENCE.equals(radioButtonValue);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.ContextElementWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_CONTEXT_ELEMENT_WIZARD_PAGE;
  }
  
}
