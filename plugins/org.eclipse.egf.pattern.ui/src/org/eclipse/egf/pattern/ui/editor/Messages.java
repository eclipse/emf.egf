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
package org.eclipse.egf.pattern.ui.editor;

import org.eclipse.osgi.util.NLS;

/**
 * @author Guillaume Brocard
 *
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.ui.editor.messages"; //$NON-NLS-1$
  public static String PatternEditor_DisplayableName;
  public static String PatternEditor_HelpButtonToolTip;
  public static String PatternEditor_SaveErrorMessage;
  public static String PatternEditor_ValidationErrorMessage;
  public static String PatternEditor_SaveError_PagesMessage;
  public static String PatternEditor_SaveError_PatternModelMessage;
  public static String PatternEditor_SaveErrorTitle;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Static initialization
  }
}
