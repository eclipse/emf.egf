/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.ui.internal.validators;

import org.eclipse.osgi.util.NLS;

/**
 * I18n translation helper.
 * @author Guillaume Brocard
 */
public class Messages extends NLS {
  
  private static final String BUNDLE_NAME = "org.eclipse.egf.common.ui.internal.validators.messages"; //$NON-NLS-1$
  
  public static String JavaClassValidator_Error_Message_EMPTY_CLASS;
  public static String JavaClassValidator_Error_Message_INSTANCE_OF;
  public static String JavaClassValidator_Error_Message_UNABLE_TO_LOAD;

  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  /**
   * Constructor.
   */
  private Messages() {
    // Do nothing.
  }
  
}