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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


/**
 * @author Guillaume Brocard
 */
public class PatternCodeActionTypeSelectionPage extends AbstractPatternCodeWizardPage {
  /**
   * Page unique id.
   */
  protected static final String PAGE_ID = "actionType"; //$NON-NLS-1$
  /**
   * Code key to displayable message map.
   */
  private static final Map<String, String> CODE_TO_MESSAGE = new HashMap<String, String>();
  // Static initialization.
  static {
    // Call to another method.
    CODE_TO_MESSAGE.put(PatternConstants.PC_TAG_CALL, Messages.PatternCodeActionTypeSelectionPage_Call_Label);
    // Call to another pattern.
    CODE_TO_MESSAGE.put(PatternConstants.PC_TAG_PATTERN, Messages.PatternCodeActionTypeSelectionPage_Pattern_Label);
    // Call to super method.
    CODE_TO_MESSAGE.put(PatternConstants.PC_TAG_SUPER, Messages.PatternCodeActionTypeSelectionPage_SuperCall_Label);
  }

  /**
   * Constructor.
   */
  public PatternCodeActionTypeSelectionPage() {
    super(PAGE_ID);
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    // Get next page based on selected action type.
    String actionType = getWizard().getActionType();
    return getWizard().getPage(getParameterPageId(actionType));
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
   */
  @Override
  public boolean canFlipToNextPage() {
    String actionType = getWizard().getActionType();
    return isPageComplete() && (null != getParameterPageId(actionType));
  }

  /**
   * Get parameter page id for given action type.
   * @param actionType_p
   * @return
   */
  protected static String getParameterPageId(String actionType_p) {
    String pageId = null;
    if (PatternConstants.PC_TAG_PATTERN.equals(actionType_p)) {
      pageId = PatternIdParameterSelectionPage.PAGE_ID;
    } else if (PatternConstants.PC_TAG_CALL.equals(actionType_p)) {
      pageId = MethodNameParameterSelectionPage.PAGE_ID;
    } else if (PatternConstants.PC_TAG_SUPER.equals(actionType_p)) {
      pageId = SuperMethodNameParameterSelectionPage.EXTENDED_PAGE_ID;
    }
    return pageId;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return Messages.PatternCodeActionTypeSelectionPage_Description;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.PatternCodeActionTypeSelectionPage_Title;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.AbstractPatternCodeWizardPage#getWizard()
   */
  @Override
  public PatternCodeActionWizard getWizard() {
    return (PatternCodeActionWizard) super.getWizard();
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.AbstractPatternCodeWizardPage#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer(Composite parent_p) {
    ListViewer result = new ListViewer(parent_p, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
    result.setContentProvider(new AbstractPatternPageContentProvider() {
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

      public Object[] getElements(Object inputElement_p) {
        return getWizard().getAvailableActions().toArray();
      }
    });
    result.setLabelProvider(new LabelProvider() {
      /**
       * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
       */
      @Override
      public String getText(Object element_p) {
        return getActionTypeDisplayableText(element_p);
      }
    });
    // Set input, whatever it might be does not change the hard-coded result.
    result.setInput(getWizard().getAvailableActions());
    return result;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.AbstractPatternCodeWizardPage#delegateSelectionChanged(java.lang.Object)
   */
  @Override
  protected boolean delegateSelectionChanged(Object selectedElement_p) {
    String selectedActionType = (String) selectedElement_p;
    getWizard().setActionType(selectedActionType);
    return (null != selectedActionType);
  }

  /**
   * Get action type text to display from action type.
   * @param actionType_p
   * @return
   */
  public static String getActionTypeDisplayableText(Object actionType_p) {
    return CODE_TO_MESSAGE.get(actionType_p);
  }
}
