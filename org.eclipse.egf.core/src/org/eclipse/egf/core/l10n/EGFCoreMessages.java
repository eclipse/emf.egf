/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.core.l10n;

import org.eclipse.osgi.util.NLS;

public class EGFCoreMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.core.l10n.messages"; //$NON-NLS-1$

  private EGFCoreMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, EGFCoreMessages.class);
  }

  public static String Production_Invoke;
  public static String Production_Dispose;
  public static String Production_Instantiate;

  public static String AbstractTask_postExecute;
  public static String AbstractTask_doExecute;
  public static String AbstractTask_preExecute;
  public static String AbstractTask_errorTaskInstance;

  public static String classloader_errorFindClass;
  public static String classloader_errorOuptutFolder;

  public static String URLBundleProjectClassLoader_errorClasspath;

  public static String ProjectBundleSession_IllegalBundleState;
  public static String ProjectBundleSession_InstallationFailure;
  public static String ProjectBundleSession_BundleClassInstantiationFailure;
  public static String ProjectBundleSession_UninstallationFailure;
  public static String ProjectBundleSession_PackageRefreshFailure;
  public static String ProjectBundleSession_LoadFailure;
  public static String ProjectBundleSession_URLFailure;
  public static String ProjectBundleSession_StoppingFailure;

  public static String Production_Unknown_Bundle;

  public static String ConvertProjectOperation_converter;
  public static String ConvertProjectOperation_setupClasspath;
  public static String ConvertProjectOperation_organizeExport;
  public static String ConvertProjectOperation_setupBuildfile;
  public static String ConvertProjectOperation_setupManifestfile;

  public static String EclipseBuilderHelper_addBuilder;
  public static String EclipseBuilderHelper_addNature;
  public static String EclipseBuilderHelper_getBuilder;
  public static String EclipseBuilderHelper_removeBuilder;
  public static String EclipseBuilderHelper_setBuilder;

  public static String synchJobName;

  public static String _UI_CreateModelError_message;

  public static String saveContextLabel;

}
