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
package org.eclipse.egf.core.ui.wizard.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.common.helper.PatternLibrarySequenceHelper;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.AbstractPatternLibraryWizard;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;


/**
 * Implement the pattern library production orchestration wizard page.
 * @author Guillaume Brocard
 */
public class PatternLibraryProductionSequenceWizardPage extends AbstractPatternLibrarySequenceWizardPage {
  /**
   * List of current pattern elements involved the production orchestration.
   */
  private List<Object> _productionContent;

  /**
   * Constructor.
   * @param pageName_p
   */
  public PatternLibraryProductionSequenceWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public PatternLibraryProductionSequenceWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    return getWizard().getPage(AbstractPatternLibraryWizard.PATTERN_LIBRARY_RUNTIME_SEQUENCE_PAGE);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractPatternLibrarySequenceWizardPage#getOrchestrationValue()
   */
  @Override
  protected String getOrchestrationValue() {
    return getPatternLibrary().getProductionOrchestration();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractPatternLibrarySequenceWizardPage#getPatternElements(java.lang.String)
   */
  @Override
  protected List<Object> getPatternElements(String orchestrationValue_p) {
    // Get pattern elements.
    List<String> patternElementAsString = PatternLibrarySequenceHelper.extractSequenceIds(orchestrationValue_p);
    _productionContent = new ArrayList<Object>(patternElementAsString.size());
    // Get the pattern library.
    PatternLibrary library = getPatternLibrary();
    // Loop over pattern short ids contained in production orchestration to retrieve related pattern element model element.
    for (String patternElementShortId : patternElementAsString) {
      AbstractPatternElement patternElement = ModelHelper.getPatternElement(patternElementShortId, library);
      if (null != patternElement) {
        _productionContent.add(patternElement);
      }
    }
    return _productionContent;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractPatternLibrarySequenceWizardPage#getFilteredPatternElements()
   */
  @Override
  protected List<Object> getFilteredPatternElements() {
    List<Object> result = null;
    result = (null == _productionContent) ? Collections.emptyList() : _productionContent;
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.PatternLibraryProductionSequenceWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.observable.IListViewerObserver#elementUpdated(java.util.List)
   */
  public void elementUpdated(List<Object> elements_p) {
    // Handle the production orchestration sequence.
    Iterator<Object> patternElements = elements_p.iterator();
    List<String> orchestrationIds = new ArrayList<String>(elements_p.size());
    // Iterate over the pattern elements to rebuild the sequence.
    while (patternElements.hasNext()) {
      AbstractPatternElement patternElement = (AbstractPatternElement) patternElements.next();
      // Append 'pattern element' short id according to expected productionOrchestration field (have a look at 'pattern' extension-point).
      orchestrationIds.add(ModelHelper.getPatternElementShortId(patternElement));
    }
    // Set the new sequence.
    ((PatternLibrary) getModelElement()).setProductionOrchestration(PatternLibrarySequenceHelper.getFullSequence(orchestrationIds));
    // Update the production content field accordingly.
    _productionContent = elements_p;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_PATTERN_LIBRARY_PRODUCTION_WIZARD_PAGE;
  }
}