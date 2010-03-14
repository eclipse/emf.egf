/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.editor.l10n;

import org.eclipse.osgi.util.NLS;

public class ModelEditorMessages {

  private static final String BUNDLE_NAME = "org.eclipse.egf.model.editor.l10n.messages"; //$NON-NLS-1$

  private ModelEditorMessages() {
    // Do not instantiate
  }

  static {
    // load message values from bundle file
    NLS.initializeMessages(BUNDLE_NAME, ModelEditorMessages.class);
  }

  public static String _UI_ActivitySelectionDialog_dialogTitle;
  public static String _UI_ActivitySelectionDialog_dialogMessage;

  public static String FcoreMenuContributor_Activity_editAction_label;

}
