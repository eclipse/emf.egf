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

package org.eclipse.egf.producer.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class ProducerUIMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.producer.ui.l10n.messages"; //$NON-NLS-1$

  private ProducerUIMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, ProducerUIMessages.class);
  }

  public static String GlobalRunActivityAction_description;
  public static String GlobalRunActivityAction_tooltip;
  public static String GlobalRunActivityAction_label;
  public static String GlobalRunActivityAction_dialogTitle;

  public static String ActivityValidationSelectionDialog_Title;
  public static String ActivityValidationSelectionDialog_Select;
  public static String ActivityValidationSelectionDialog_Never_Validate;

  public static String _UI_PreInvokeProblems_message;
  public static String _UI_PostInvokeProblems_message;

}
