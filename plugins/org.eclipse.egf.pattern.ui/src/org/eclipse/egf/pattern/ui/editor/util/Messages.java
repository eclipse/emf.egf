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
package org.eclipse.egf.pattern.ui.editor.util;

import org.eclipse.osgi.util.NLS;

/**
 * @author Guillaume Brocard
 *
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.ui.editor.util.messages"; //$NON-NLS-1$
  public static String PatternEditorPageLinkListener_Hyperlink_Page_StatusMessage;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // static initialization.
  }
}
