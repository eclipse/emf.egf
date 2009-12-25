/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.production.l10n;

import org.eclipse.osgi.util.NLS;

public class CoreProductionMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.core.production.l10n.messages"; //$NON-NLS-1$

  private CoreProductionMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, CoreProductionMessages.class);
  }

  public static String ProjectBundleSession_IllegalBundleState;
  public static String ProjectBundleSession_InstallationFailure;
  public static String ProjectBundleSession_BundleClassInstantiationFailure;
  public static String ProjectBundleSession_UninstallationFailure;
  public static String ProjectBundleSession_LoadFailure;
  public static String ProjectBundleSession_AnalysingFailure;
  public static String ProjectBundleSession_URLFailure;
  public static String ProjectBundleSession_StoppingFailure;

  public static String InvocationException_Header_Default;

}
