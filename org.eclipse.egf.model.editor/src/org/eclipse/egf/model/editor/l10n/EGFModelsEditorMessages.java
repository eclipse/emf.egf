/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */

package org.eclipse.egf.model.editor.l10n;

import org.eclipse.osgi.util.NLS;

public class EGFModelsEditorMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.model.editor.l10n.messages"; //$NON-NLS-1$

  private EGFModelsEditorMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, EGFModelsEditorMessages.class);
  }

  public static String GlobalRunActivityAction_description;
  public static String GlobalRunActivityAction_tooltip;
  public static String GlobalRunActivityAction_label;
  public static String GlobalRunActivityAction_dialogMessage;
  public static String GlobalRunActivityAction_dialogTitle;
  public static String GlobalRunActivityAction_errorTitle;
  public static String GlobalRunActivityAction_errorMessage;

}
