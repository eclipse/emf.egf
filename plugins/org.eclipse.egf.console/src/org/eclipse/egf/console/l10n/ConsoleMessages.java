/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.console.l10n;

import org.eclipse.osgi.util.NLS;

public class ConsoleMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.console.l10n.messages"; //$NON-NLS-1$

  private ConsoleMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, ConsoleMessages.class);
  }

  public static String ConsolePreferencePage_Error;

  public static String ConsolePreferencePage_Warning;

  public static String ConsolePreferencePage_Information;

  public static String ConsolePreferencePage_Debug;

  public static String ConsolePreferencePage_General;

  public static String ConsolePreferencePage_ShowOnMessage;

  public static String ConsolePreferencePage_limitOutput;

  public static String ConsolePreferencePage_highWaterMark;

  public static String ConsolePreferencePage_Wrap_text;

  public static String ConsolePreferencePage_Maximum_Console_width;

  public static String ConsolePreferencePage_Error_Console_width;

  public static String ConsolePreferencePage_Console_buffer_size;

  public static String ConsolePreferencePage_BackgroundColor;

  public static String Console_resultTimeFormat;

  public static String Console_close;

  public static String Console_error;

  public static String Console_info;

  public static String Console_warning;

  public static String Console_see_your_log_file;

  public static String EGF_Console;

}
