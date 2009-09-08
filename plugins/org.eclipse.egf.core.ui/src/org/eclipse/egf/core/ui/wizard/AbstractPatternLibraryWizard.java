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
package org.eclipse.egf.core.ui.wizard;

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.IImageKeys;
import org.eclipse.egf.core.ui.wizard.page.PatternLibraryProductionSequenceWizardPage;
import org.eclipse.egf.core.ui.wizard.page.PatternLibraryRuntimeSequenceWizardPage;
import org.eclipse.egf.core.ui.wizard.page.PatternLibraryWizardPage;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.library.SetPatternLibraryWrapperCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;


/**
 * Base class to implement a wizard to create a pattern library.
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternLibraryWizard extends AbstractModelElementWizard {
  /**
   * Constant used to identify the production orchestration wizard page.
   */
  public static final String PATTERN_LIBRARY_PRODUCTION_SEQUENCE_PAGE = "patternLibraryProductionSequenceWizardPage"; //$NON-NLS-1$
  /**
   * Constant used to identify the runtime orchestration wizard page.
   */
  public static final String PATTERN_LIBRARY_RUNTIME_SEQUENCE_PAGE = "patternLibraryRuntimeSequenceWizardPage"; //$NON-NLS-1$
  /**
   * Is this wizard open to create a new pattern library or edit an existing one ?
   */
  private boolean _creationMode;

  /**
   * Constructor.
   * @param parent_p
   * @param modelElement_p
   * @param readOnlyMode_p
   * @param creationMode_p true means this wizard is used to create a new pattern library.
   */
  public AbstractPatternLibraryWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p, boolean creationMode_p) {
    super(parent_p, modelElement_p, readOnlyMode_p);
    _creationMode = creationMode_p;
    // Force to have the next and previous button
    setForcePreviousAndNextButtons(true);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#addPages()
   */
  @Override
  public void addPages() {
    super.addPages();
    // Add the pattern library page.
    addPage(new PatternLibraryWizardPage("patternLibraryWizardPage"));//$NON-NLS-1$
    // Other pages are lazy loaded because there are optional.
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#getPage(java.lang.String)
   */
  @Override
  public IWizardPage getPage(String name) {
    IWizardPage page = super.getPage(name);
    // Precondition : it is useless to go further, the requested page is found.
    if (null != page) {
      return page;
    }
    // The page is not created, let's do it.
    if (PATTERN_LIBRARY_PRODUCTION_SEQUENCE_PAGE.equals(name)) {
      // Create the page.
      page = new PatternLibraryProductionSequenceWizardPage(PATTERN_LIBRARY_PRODUCTION_SEQUENCE_PAGE);
    } else if (PATTERN_LIBRARY_RUNTIME_SEQUENCE_PAGE.equals(name)) {
      // Create the page.
      page = new PatternLibraryRuntimeSequenceWizardPage(PATTERN_LIBRARY_RUNTIME_SEQUENCE_PAGE);
    }
    // Finally, add the page.
    addPage(page);
    return page;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#doCreateModelElement()
   */
  @Override
  protected NamedModelElementWithId doCreateModelElement() {
    return ModelFactory.eINSTANCE.createPatternLibrary();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getPluginChangeCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getPluginChangeCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p,
      Object value_p) {
    return new SetPatternLibraryWrapperCommand(editingDomain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getCreationDescription()
   */
  @Override
  protected String getCreationDescription() {
    return Messages.PatternLibraryWizard_CreateDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getEditDescription()
   */
  @Override
  protected String getEditDescription() {
    return Messages.PatternLibraryWizard_EditDescription_Message;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getTitle()
   */
  @Override
  protected String getTitle() {
    return Messages.PatternLibraryWizard_Title;
  }

  /**
   * Is this wizard open to create a new pattern library or edit an existing one ?
   * @return
   */
  public boolean isInCreationMode() {
    return _creationMode;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getWizardDefaultPageImageDescriptor()
   */
  @Override
  protected ImageDescriptor getWizardDefaultPageImageDescriptor() {
    return EgfUiActivator.getDefault().getImageDescriptor(IImageKeys.IMG_WIZARD_PATTERN_LIBARY);
  }
}