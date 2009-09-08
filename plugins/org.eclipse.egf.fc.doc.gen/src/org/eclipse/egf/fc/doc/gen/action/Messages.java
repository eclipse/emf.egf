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
package org.eclipse.egf.fc.doc.gen.action;

import org.eclipse.osgi.util.NLS;

/**
 * I18n translation helper.
 * @author fournier
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.fc.doc.gen.action.messages"; //$NON-NLS-1$


  // I18n messages related to generate documentation for a FC.
  public static String GenerateFcDocAction_Title;
  public static String GenerateFcDocAction_Tooltip;
  
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
