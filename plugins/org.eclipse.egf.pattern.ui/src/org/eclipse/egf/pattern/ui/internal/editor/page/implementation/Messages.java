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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation;

import org.eclipse.osgi.util.NLS;

/**
 * @author Guillaume Brocard
 *
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.ui.internal.editor.page.implementation.messages"; //$NON-NLS-1$
  public static String MethodPatternCodeDetailsViewer_ActionPropertiesNameLabel;
  public static String MethodPatternCodeDetailsViewer_ActionPropertiesParameterButtonLabel;
  public static String MethodPatternCodeDetailsViewer_ActionPropertiesParameterLabel;
  public static String MethodPatternCodeDetailsViewer_ActionPropertiesSectionText;
  public static String MethodPatternCodeLabelProvider_PatternCode_CALL_Message;
  public static String MethodPatternCodeLabelProvider_PatternCode_PATTERN_Message;
  public static String MethodPatternCodeLabelProvider_PatternCode_READ_Message;
  public static String MethodPatternCodeLabelProvider_PatternCode_SUPER_CALL_Message;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Nothing to do here.
  }
}
