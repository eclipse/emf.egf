/**
 * <copyright>
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
 * </copyright>
 */

package org.eclipse.egf.model.ftask.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class EGFFtaskMessages extends NLS {

  private static final String BUNDLE_NAME = "org.eclipse.egf.model.ftask.l10n.messages"; //$NON-NLS-1$

  static {
    NLS.initializeMessages(BUNDLE_NAME, EGFFtaskMessages.class);
  }

  public static String missing_task_message;

  public static String missing_kind_message;

  public static String missing_hook_message;

}
