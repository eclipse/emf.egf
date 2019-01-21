/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.emf.wrapper.l10n;

import org.eclipse.osgi.util.NLS;

public class EMFWrapperMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.emf.wrapper.l10n.messages"; //$NON-NLS-1$

  private EMFWrapperMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, EMFWrapperMessages.class);
  }

  public static String CreateFcoreFileWizard_Create_EMF_Wrapper;

}
