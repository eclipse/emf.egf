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
package org.eclipse.egf.pde.internal.ui;

import org.eclipse.egf.pde.EgfPdeActivator;

/**
 * Help context ids for the EGF UI.
 * @author Guillaume Brocard
 */
public interface IHelpContextIds {
  /**
   * Help context prefix.
   */
  public static final String PREFIX = EgfPdeActivator.getDefault().getPluginID() + '.';
  // Wizard pages
  public static final String NEW_FACTORY_COMPONENT_PROJECT_STRUCTURE_WIZARD_PAGE = PREFIX + "new_factory_component_project_structure_wizard_page"; //$NON-NLS-1$
  public static final String NEW_FACTORY_COMPONENT_CONTENT_WIZARD_PAGE = PREFIX + "new_factory_component_content_wizard_page"; //$NON-NLS-1$
  public static final String NEW_FACTORY_COMPONENT_TEMPLATES_WIZARD_PAGE = PREFIX + "new_factory_component_templates_wizard_page"; //$NON-NLS-1$
  public static final String NEW_FACTORY_COMPONENT_TEMPLATE_EMPTY_WIZARD_PAGE = PREFIX + "new_factory_component_template_empty_wizard_page"; //$NON-NLS-1$
}
