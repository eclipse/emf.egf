/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.platform.l10n;

import org.eclipse.osgi.util.NLS;

public class CorePlatformMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.core.platform.l10n.messages"; //$NON-NLS-1$

  private CorePlatformMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, CorePlatformMessages.class);
  }

  public static String PlatformManager_outOfSync;

}