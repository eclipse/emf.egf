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
package org.eclipse.egf.common.ui.viewers;

import org.eclipse.osgi.util.NLS;

/**
 * I18n support.
 * @author Guillaume Brocard
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.common.ui.viewers.messages"; //$NON-NLS-1$
  public static String OrderedListViewerWithAddAndRemove_AddButton_Label;
  public static String OrderedListViewerWithAddAndRemove_RemoveButton_Label;
  public static String SortedListViewer_DownButton_Title;
  public static String SortedListViewer_UpButton_Title;

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