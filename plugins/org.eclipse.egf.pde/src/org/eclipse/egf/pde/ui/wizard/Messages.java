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
package org.eclipse.egf.pde.ui.wizard;

import org.eclipse.osgi.util.NLS;

/**
 * I18n translation helper for wizards.
 * @author fournier
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.pde.ui.wizard.messages"; //$NON-NLS-1$

  // New FactoryComponent wizard messages.
  public static String NewFactoryComponentProjectWizard_Title;
  public static String NewFactoryComponentProjectWizardMainPage_Description;
  public static String NewFactoryComponentProjectWizardMainPage_Title;
  public static String FactoryComponentContentPage_Title;
  public static String FactoryComponentContentPage_Description;
  public static String FactoryComponentContentPage_FactoryComponentGroup_Title;
  public static String FactoryComponentContentPage_FactoryComponentModelQuestion_Title;
  public static String FactoryComponentTemplateListSelectionPage_Title;
  public static String FactoryComponentTemplateListSelectionPage_Description;
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
