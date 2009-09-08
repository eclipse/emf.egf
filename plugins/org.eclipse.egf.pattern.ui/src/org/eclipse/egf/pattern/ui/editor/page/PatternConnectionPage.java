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
package org.eclipse.egf.pattern.ui.editor.page;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * @author Guillaume Brocard
 */
public class PatternConnectionPage extends AbstractPatternPage {
  
  /**
   * Page id.
   */
  protected static final String ID = "egf_pattern_connection_page"; //$NON-NLS-1$
  
  /**
   * Help context id.
   */
  protected static final String HELP_CONTEXT_ID = PatternUiActivator.getDefault().getPluginID() + ICommonConstants.DOT_CHARACTER + ID;

  /**
   * Constructor.
   * @param editor_p
   */
  public PatternConnectionPage(FormEditor editor_p) {
    super(editor_p, ID, Messages.PatternConnectionPage_Title);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#doCreateFormContent(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void doCreateFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p, IManagedForm managedForm_p) {
    // To be implemented.    
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#createPatternBlock()
   */
  @Override
  protected AbstractPatternBlock createPatternBlock() {
    return null;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#getHelpContextId()
   */
  @Override
  public String getHelpContextId() {
    return HELP_CONTEXT_ID;
  }
  
}