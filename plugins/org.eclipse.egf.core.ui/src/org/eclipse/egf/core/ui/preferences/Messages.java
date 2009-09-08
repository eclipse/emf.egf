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

package org.eclipse.egf.core.ui.preferences;

import org.eclipse.osgi.util.NLS;

/**
 * I18n translation helper for preference pages.
 * @author Guillaume Brocard
 */
public class Messages extends NLS {
  
  private static final String BUNDLE_NAME = "org.eclipse.egf.core.ui.preferences.messages"; //$NON-NLS-1$
  
  // Common preference page.
  public static String AbstractDefaultPreferencePage_SavingError;
  
  // EGF general preference page.
  public static String EgfGeneralPreferencePage_Title;
  public static String EgfGeneralPreferencePage_Description;
  
  // Domain general preference page.
  public static String DomainPreferencePage_Title;
  public static String DomainPreferencePage_Description;
  public static String DomainPreferencePage_EditorChoice_Title;
  public static String DomainPreferencePage_EcoreEditor_Title;
  public static String DomainPreferencePage_GraphicalEcoreEditor_Title;
  
  // Factory Component preference page.
  public static String FactoryComponentPreferencePage_Description;
  public static String FactoryComponentPreferencePage_Title;
  public static String FactoryComponentPreferencePage_ExecuteWithPreValidation_Title;
  public static String FactoryComponentPage_ExecuteWithoutValidation_Title;
  public static String FactoryComponentPage_FcExecution_Title;
  
  // Pattern preference page.
  public static String PatternPreferencePage_Description;
  public static String PatternPreferencePage_Title;
  public static String PatternPreferencePage_ExecuteWithPreValidation_Title;
  public static String PatternPage_ExecuteWithoutValidation_Title;
  public static String PatternPage_Execution_Title;
  
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
