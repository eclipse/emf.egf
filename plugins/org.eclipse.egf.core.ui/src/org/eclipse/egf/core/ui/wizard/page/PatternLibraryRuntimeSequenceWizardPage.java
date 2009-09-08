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
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.helper.PatternLibrarySequenceHelper;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.resource.ImageDescriptor;


/**
 * Implement the pattern library runtime orchestration wizard page.
 * @author Guillaume Brocard
 */
public class PatternLibraryRuntimeSequenceWizardPage extends AbstractPatternLibrarySequenceWizardPage {
  /**
   * Constructor.
   * @param pageName_p
   */
  public PatternLibraryRuntimeSequenceWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public PatternLibraryRuntimeSequenceWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractPatternLibrarySequenceWizardPage#getOrchestrationValue()
   */
  @Override
  protected String getOrchestrationValue() {
    return getPatternLibrary().getRuntimeOrchestration();
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractPatternLibrarySequenceWizardPage#getPatternElements(java.lang.String)
   */
  @Override
  protected List<Object> getPatternElements(String orchestrationValue_p) {
    List<Object> result = null;
    // Get pattern elements.
    List<String> patternElementAsString = PatternLibrarySequenceHelper.extractSequenceIds(orchestrationValue_p);
    result = new ArrayList<Object>(patternElementAsString.size());
    // Get the pattern library.
    PatternLibrary library = getPatternLibrary();
    // Loop over pattern element full ids contained in runtime orchestration to retrieve related 'pattern element' model element.
    for (String patternElementFullId : patternElementAsString) {
      String patternElementShortId = PatternHelper.deresolveId(patternElementFullId).getValue();
      AbstractPatternElement patternElement = ModelHelper.getPatternElement(patternElementShortId, library);
      if (null != patternElement) {
        result.add(patternElement);
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.PatternLibraryRuntimeSequenceWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.observable.IListViewerObserver#elementUpdated(java.util.List)
   */
  public void elementUpdated(List<Object> elements_p) {
    // Handle the runtime orchestration sequence.
    Iterator<Object> patternElements = elements_p.iterator();
    List<String> orchestrationIds = new ArrayList<String>(elements_p.size());
    // Iterate over the pattern elements to rebuild the sequence.
    while (patternElements.hasNext()) {
      AbstractPatternElement patternElement = (AbstractPatternElement) patternElements.next();
      // Append 'pattern element' full id according to expected runtimeOrchestration field (have a look at 'pattern' extension-point).
      orchestrationIds.add(patternElement.getId());
    }
    // Set the new sequence.
    ((PatternLibrary) getModelElement()).setRuntimeOrchestration(PatternLibrarySequenceHelper.getFullSequence(orchestrationIds));
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_PATTERN_LIBRARY_RUNTIME_WIZARD_PAGE;
  }
}