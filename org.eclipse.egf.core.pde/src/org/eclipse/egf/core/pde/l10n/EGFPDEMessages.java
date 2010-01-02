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
package org.eclipse.egf.core.pde.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFPDEMessages extends NLS {

  private static final String BUNDLE_NAME = "org.eclipse.egf.core.pde.l10n.messages";//$NON-NLS-1$  

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, EGFPDEMessages.class);
  }

  public static String savedState_jobName;

  public static String PluginModelUpdate_progressMessage;
  public static String PluginModelUpdate_logTitle;

}
