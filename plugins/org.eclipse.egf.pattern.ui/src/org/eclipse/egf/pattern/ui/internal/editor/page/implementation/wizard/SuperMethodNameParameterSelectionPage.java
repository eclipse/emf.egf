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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.pattern.Pattern;
import org.eclipse.emf.ecore.EOperation;


/**
 * @author Guillaume Brocard
 */
public class SuperMethodNameParameterSelectionPage extends MethodNameParameterSelectionPage {
  /**
   * Page unique id.
   */
  protected static final String EXTENDED_PAGE_ID = "actionSuperMethodNameParameter"; //$NON-NLS-1$

  /**
   * Constructor.
   */
  public SuperMethodNameParameterSelectionPage() {
    super(EXTENDED_PAGE_ID);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.MethodNameParameterSelectionPage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return Messages.MethodNameParameterSelectionPage_Description;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.MethodNameParameterSelectionPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.SuperMethodNameParameterSelectionPage_Title;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.MethodNameParameterSelectionPage#initializeContent()
   */
  @Override
  protected Object initializeContent() {
    Pattern pattern = getWizard().getPatternData().getPattern();
    // Get all operations, including inherited ones.
    List<EOperation> allOperations = pattern.getEAllOperations();
    // Clone this list.
    List<EOperation> resultingOperations = new ArrayList<EOperation>(allOperations.size());
    resultingOperations.addAll(allOperations);
    // Remove all local operations.
    resultingOperations.removeAll(pattern.getEOperations());
    // Resulting list.
    List<String> result = new ArrayList<String>(resultingOperations.size());
    for (EOperation operation : resultingOperations) {
      if (isPrivatePatternMethod(operation)) {
        result.add(operation.getName());
      }
    }
    return result;
  }
}
