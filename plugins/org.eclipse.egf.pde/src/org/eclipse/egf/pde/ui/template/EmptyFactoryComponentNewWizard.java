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
package org.eclipse.egf.pde.ui.template;

import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.ITemplateSection;
import org.eclipse.pde.ui.templates.NewPluginTemplateWizard;

/**
 * Wizard that creates an empty FactoryComponent project.
 * @author fournier
 */
public class EmptyFactoryComponentNewWizard extends NewPluginTemplateWizard {
  private EmptyFactoryComponentTemplate _template;

  /**
   * @see org.eclipse.pde.ui.templates.AbstractNewPluginTemplateWizard#init(org.eclipse.pde.ui.IFieldData)
   */
  @Override
  public void init(IFieldData data_p) {
    super.init(data_p);
    // Initialize the created template.
    _template.init(data_p);
    setWindowTitle(Messages.EmptyFactoryComponentNewWizard_Title);
  }

  /**
   * @see org.eclipse.pde.ui.templates.NewPluginTemplateWizard#createTemplateSections()
   */
  @Override
  public ITemplateSection[] createTemplateSections() {
    // Keep a reference on instantiated template.
    _template = new EmptyFactoryComponentTemplate();
    return new ITemplateSection[] { _template };
  }
}
