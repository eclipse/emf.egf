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
package org.eclipse.egf.common.ui.toolkit.fields;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The messages handler.
 * @author D. GATIBELZA
 */
public class Messages {
  // The bundle name.
  private static final String BUNDLE_NAME = "org.eclipse.egf.common.ui.toolkit.fields.messages"; //$NON-NLS-1$
  // The resource bundle.
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

  // Constructs the messages handler.
  private Messages() {
    // Do nothing.
  }

  /**
   * Gets the messages from the specified key.
   * @param key_p The key.
   * @return The corresponding messages.
   */
  public static String getString(String key_p) {
    try {
      return RESOURCE_BUNDLE.getString(key_p);
    } catch (MissingResourceException e) {
      return '!' + key_p + '!';
    }
  }
}
