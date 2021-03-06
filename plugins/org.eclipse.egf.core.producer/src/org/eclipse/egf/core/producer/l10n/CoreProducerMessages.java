/**
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
 */
package org.eclipse.egf.core.producer.l10n;

import org.eclipse.osgi.util.NLS;

public class CoreProducerMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.core.producer.l10n.messages"; //$NON-NLS-1$

  private CoreProducerMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, CoreProducerMessages.class);
  }

  public static String ProductionContext_null_key;

  public static String ProductionContext_null_class;

  public static String ProductionContext_wrong_type;

  public static String ProductionContext_unknown_key;

  public static String ProductionContext_non_unique_key;

}
