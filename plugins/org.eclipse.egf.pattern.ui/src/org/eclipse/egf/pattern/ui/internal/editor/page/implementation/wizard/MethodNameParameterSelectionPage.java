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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.AnnotationHandler;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


/**
 * @author Guillaume Brocard
 */
public class MethodNameParameterSelectionPage extends AbstractPatternCodeWizardPage {
  
  /**
   * Page unique id.
   */
  protected static final String PAGE_ID = "actionMethodNameParameter"; //$NON-NLS-1$

  /**
   * Constructor.
   */
  public MethodNameParameterSelectionPage() {
    super(PAGE_ID);
  }

  /**
   * Constructor.
   * @param pageId_p
   */
  public MethodNameParameterSelectionPage(String pageId_p) {
    super(pageId_p);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.AbstractPatternCodeWizardPage#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer(Composite parent_p) {
    ListViewer result = new ListViewer(parent_p, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
    result.setContentProvider(
      new AbstractPatternPageContentProvider() {
        @Override
        protected void doDispose() {
          // Nothing to do.
        }
  
        @Override
        protected void doHandleElementUpdated(Object oldInput_p, Object newInput_p) {
          // Nothing to do.
        }
  
        @Override
        protected void doHandleElementsAdded(Object addedElements_p) {
          // Nothing to do.
        }
  
        @Override
        protected void doHandleElementsRemoved(Object removedElements_p) {
          // Nothing to do.
        }
  
        @SuppressWarnings("unchecked")
        public Object[] getElements(Object inputElement_p) {
          return ((List<String>) inputElement_p).toArray();
        }
      }
    );
    result.setLabelProvider(new LabelProvider());
    // Set initial input.
    result.setInput(initializeContent());
    // Set initial selection.
    String methodName = getWizard().getActionParameter();
    if (null != methodName) {
      result.setSelection(new StructuredSelection(methodName));
    }
    return result;
  }

  /**
   * Get view initial input content.
   * @return
   */
  protected Object initializeContent() {
    // Get pattern.
    Pattern pattern = getWizard().getPatternData().getPattern();
    // Get local methods.
    List<EOperation> operations = pattern.getEOperations();
    // Retain private methods only.
    List<String> methodNames = new ArrayList<String>(0);
    for (EOperation operation : operations) {
      if (isPrivatePatternMethod(operation)) {
        methodNames.add(operation.getName());
      }
    }
    return methodNames;
  }

  /**
   * Is given method a pattern private one, that should be taken into account.
   * @param operation_p
   * @return
   */
  protected boolean isPrivatePatternMethod(EOperation operation_p) {
    String operationName = operation_p.getName();
    // First of all, try and get rid of general pattern method.
    boolean result =
    !(
         PatternConstants.GENERATE_FOOTER_METHOD_NAME.equals(operationName) 
      || PatternConstants.GENERATE_HEADER_METHOD_NAME.equals(operationName)
      || PatternConstants.GENERATE_METHOD_NAME.equals(operationName)
      || PatternConstants.GENERATE_POST_MATCHING_METHOD_NAME.equals(operationName) 
      || PatternConstants.GENERATE_PRE_MATCHING_METHOD_NAME.equals(operationName)
    );
    // Then remove all methods that are not tagged with pattern code annotations.
    if (result) {
      EAnnotation patternCode = operation_p.getEAnnotation(AnnotationHandler.PATTERN_CODE_ANNOTATION_SOURCE);
      result = (null != patternCode);
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.AbstractPatternCodeWizardPage#delegateSelectionChanged(java.lang.Object)
   */
  @Override
  protected boolean delegateSelectionChanged(Object selectedElement_p) {
    String methodName = (String) selectedElement_p;
    getWizard().setActionParameter(methodName);
    return (null != methodName);
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return Messages.MethodNameParameterSelectionPage_Description;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.MethodNameParameterSelectionPage_Title;
  }
  
}
