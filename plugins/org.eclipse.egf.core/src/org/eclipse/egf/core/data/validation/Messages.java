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
package org.eclipse.egf.core.data.validation;

import org.eclipse.osgi.util.NLS;

/**
 * I18n validation rules messages
 * @author Guillaume Brocard
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.core.data.validation.messages"; //$NON-NLS-1$
  public static String ModelElementDelegatedValidator_FactoryComponentInvocation_Rule0_Message;
  public static String ModelElementDelegatedValidator_FactoryComponentInvocation_Rule1_Message;
  public static String ModelElementDelegatedValidator_FactoryComponentInvocation_Rule2_Message;
  public static String ModelElementDelegatedValidator_FactoryComponentInvocation_ReferencedFcDiagnostic_Message;

  public static String ModelElementDelegatedValidator_ContractElementReference_MessageHeader;
  public static String ModelElementDelegatedValidator_ContractElementReference_Rule0_Message;
  public static String ModelElementDelegatedValidator_ContractElementReference_Rule1_Message;
  public static String ModelElementDelegatedValidator_ContractElementReference_Rule2_Message;
  public static String ModelElementDelegatedValidator_ContractElementReference_Rule3_Message;
  
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  /**
   * Constructor.
   */
  private Messages() {
    // Do nothing.
  }
}
