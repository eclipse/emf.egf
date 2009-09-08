/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.core.ui.dialogs;

import org.eclipse.osgi.util.NLS;

/**
 * I18n messages.
 * @author Xavier Maysonnave
 */
public class Messages extends NLS {
  
  private static final String BUNDLE_NAME = "org.eclipse.egf.core.ui.dialogs.messages"; //$NON-NLS-1$
  
  public static String _UI_SelectGenModel_message;
    
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Do nothing.
  }
  
}
