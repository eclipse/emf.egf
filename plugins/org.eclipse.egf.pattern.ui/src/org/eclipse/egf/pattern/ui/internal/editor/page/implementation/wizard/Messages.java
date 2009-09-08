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

import org.eclipse.osgi.util.NLS;

/**
 * @author Guillaume Brocard
 *
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.messages"; //$NON-NLS-1$
  public static String MethodNameParameterSelectionPage_Description;
  public static String MethodNameParameterSelectionPage_Title;
  public static String PatternCodeActionParameterWizard_Title0;
  public static String PatternCodeActionTypeSelectionPage_Call_Label;
  public static String PatternCodeActionTypeSelectionPage_Description;
  public static String PatternCodeActionTypeSelectionPage_Pattern_Label;
  public static String PatternCodeActionTypeSelectionPage_SuperCall_Label;
  public static String PatternCodeActionTypeSelectionPage_Title;
  public static String PatternCodeActionWizard_Title;
  public static String PatternIdParameterSelectionPage_Description;
  public static String PatternIdParameterSelectionPage_Title;
  public static String SuperMethodNameParameterSelectionPage_Title;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }
  private Messages() {
    // Nothing to do here, because of the static initialization.
  }
}
