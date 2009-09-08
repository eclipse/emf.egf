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
package org.eclipse.egf.core.ui.internal.help;

import org.eclipse.egf.core.ui.EgfUiActivator;

/**
 * Help context ids for the EGF UI.
 * @author Guillaume Brocard
 */
public interface IHelpContextIds {
  /**
   * Help context prefix.
   */
  public static final String PREFIX = EgfUiActivator.getDefault().getPluginID() + '.';

  // Help context ids for wizard pages
  public static final String NEW_DOMAIN_WIZARD_PAGE = PREFIX + "new_domain_wizard_page"; //$NON-NLS-1$
  public static final String NEW_CONTRACT_ELEMENT_WIZARD_PAGE = PREFIX + "new_contract_element_wizard_page"; //$NON-NLS-1$
  public static final String NEW_CONTRACT_ELEMENT_TYPE_WIZARD_PAGE = PREFIX + "new_contract_element_type_wizard_page"; //$NON-NLS-1$
  public static final String NEW_CONTRACT_ELEMENT_REFERENCE_WIZARD_PAGE = PREFIX + "new_contract_element_reference_wizard_page"; //$NON-NLS-1$
  public static final String NEW_PATTERN_LIBRARY_WIZARD_PAGE = PREFIX + "new_pattern_library_wizard_page"; //$NON-NLS-1$
  public static final String NEW_PATTERN_LIBRARY_PRODUCTION_WIZARD_PAGE = PREFIX + "new_pattern_library_production_wizard_page"; //$NON-NLS-1$
  public static final String NEW_PATTERN_LIBRARY_RUNTIME_WIZARD_PAGE = PREFIX + "new_pattern_library_runtime_wizard_page"; //$NON-NLS-1$
  public static final String NEW_PATTERN_WIZARD_PAGE = PREFIX + "new_pattern_wizard_page"; //$NON-NLS-1$
  public static final String NEW_MAPPING_WIZARD_PAGE = PREFIX + "new_mapping_wizard_page"; //$NON-NLS-1$
  public static final String NEW_FC_CONFIGURATION_WIZARD_PAGE = PREFIX + "new_factory_component_invocation_wizard_page"; //$NON-NLS-1$
  public static final String EDIT_FC_WIZARD_PAGE = PREFIX + "edit_factory_component_wizard_page"; //$NON-NLS-1$
  public static final String NEW_TASK_FACTORY_PAGE = PREFIX + "new_task_factory_wizard_page"; //$NON-NLS-1$
  public static final String NEW_CONTEXT_ELEMENT_WIZARD_PAGE = PREFIX + "new_context_element_wizard_page"; //$NON-NLS-1$
  public static final String NEW_CONTEXT_ELEMENT_TYPE_WIZARD_PAGE = PREFIX + "new_context_element_type_wizard_page"; //$NON-NLS-1$
  public static final String NEW_CONTEXT_ELEMENT_REFERENCE_WIZARD_PAGE = PREFIX + "new_context_element_reference_wizard_page"; //$NON-NLS-1$
  public static final String NEW_CONTEXT_ELEMENT_VALUE_WIZARD_PAGE = PREFIX + "new_context_element_value_wizard_page"; //$NON-NLS-1$
}
