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
package org.eclipse.egf.pattern.ui.internal.editor.page.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

/**
 * Abstract pattern wizard.
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternWizard extends Wizard {
  
  /**
   * @see org.eclipse.jface.wizard.Wizard#getPage(java.lang.String)
   */
  @Override
  public IWizardPage getPage(String name_p) {
    // First of all, try and get it from parent registry.
    IWizardPage result = super.getPage(name_p);
    // Page is already registered, return it.
    if (null != result) {
      return result;
    }
    // Else do get page from name.
    result = doGetPage(name_p);
    // A new page has been created, add it to wizard.
    if (null != result) {
      addPage(result);
    }
    return result;
  }

  /**
   * Do get page from its id (as a convention, page name at construction time is its id).
   * @param pageId_p
   * @return
   */
  protected abstract IWizardPage doGetPage(String pageId_p);
  
}
