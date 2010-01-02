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

  public static String ActivitySelectionDialog_Title;
  public static String ActivitySelectionDialog_Select;
  public static String ActivitySelectionDialog_Always_Validate;

  public static String _UI_CanInvokeProblems_title;
  public static String _UI_CanInvokeProblems_message;

}
