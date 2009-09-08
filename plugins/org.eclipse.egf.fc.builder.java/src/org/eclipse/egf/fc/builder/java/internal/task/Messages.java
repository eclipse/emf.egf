/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.fc.builder.java.internal.task;

import org.eclipse.osgi.util.NLS;

/**
 * @author brocard
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.fc.builder.java.internal.task.messages"; //$NON-NLS-1$
  public static String JavaBuilderOperation_ProgressReporting_BuildProject;
  public static String JavaBuilderOperation_ProgressReporting_GetJavaProject;
  public static String JavaBuilderOperation_ProgressReporting_GetProject;
  static {
// initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Static intialization
  }
}
