/*******************************************************************************
 * Copyright (c) 2005 - 2006 Joel Cheuoua & others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Joel Cheuoua - initial API and implementation
 *******************************************************************************/
package org.eclipse.jet.internal.editor.configuration;

import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;

/**
 * Preference Constants used for the IRL Editor
 * @author lmirguet
 * @version $Revision: 1.1 $
 */
public class JETEditorPreferenceConstants {
  public static final String JET_CUSTOM_TAG_FG_COLOR = "jet_custom_tag_foreground";
  public static final String JET_CUSTOM_TAG_BOLD = "jet_custom_tag_bold";
  public static final String JET_CUSTOM_TAG_ITALIC = "jet_custom_tag_italic";
  public static final String JET_CUSTOM_TAG_UNDERLINE = "jet_custom_tag_underline";
  
  public static final String JET_COMMENT_FG_COLOR = "jet_comment_foreground";
  public static final String JET_COMMENT_BOLD = "jet_comment_bold";
  public static final String JET_COMMENT_ITALIC = "jet_comment_italic";
  public static final String JET_COMMENT_UNDERLINE = "jet_comment_underline";
  
  public static final String JET_EXPRESSION_FG_COLOR = "jet_expression_foreground";
  public static final String JET_EXPRESSION_BOLD = "jet_expression_bold";
  public static final String JET_EXPRESSION_ITALIC = "jet_expression_italic";
  public static final String JET_EXPRESSION_UNDERLINE = "jet_expression_underline";

  public static final String JET_SCRIPTLET_FG_COLOR = "jet_scriptlet_foreground";
  public static final String JET_SCRIPTLET_BOLD = "jet_scriptlet_bold";
  public static final String JET_SCRIPTLET_ITALIC = "jet_scriptlet_italic";
  public static final String JET_SCRIPTLET_UNDERLINE = "jet_scriptlet_underline";
  
  public static final String JET_DIRECTIVE_FG_COLOR = "jet_directive_foreground";  
  public static final String JET_DIRECTIVE_BOLD = "jet_directive_bold";
  public static final String JET_DIRECTIVE_ITALIC = "jet_directive_italic";
  public static final String JET_DIRECTIVE_UNDERLINE = "jet_directive_underline";

  public static final String JET_DIRECTIVE_KEYWORD_BOLD = "jet_directive_keyword_bold";
  public static final String JET_EXPRESSION_BG_COLOR = "jet_expression_background";
  public static final String JET_DEFAULT_BG_COLOR = "jet_default_background";

  public static final String AUTO_COMPLETE_ENABLED = "autoCompleteEnable";
  public static final String AUTO_COMPLETE_DELAY = "autoCompleteDelay";
  
  /**
   * Should not be instanciated.
   *
   */
  private JETEditorPreferenceConstants() {
  }

  /**
   * Initialize with the default values.
   * @param store IPreferenceStore
   */
  public static void initializeDefaultValues(IPreferenceStore store) {

    PreferenceConstants.initializeDefaultValues(store);
    AbstractDecoratedTextEditorPreferenceConstants.initializeDefaultValues(store);
    
    PreferenceConverter.setDefault(store, JET_COMMENT_FG_COLOR, IJETColorConstants.JET_COMMENT_FG);
    store.setDefault(JET_COMMENT_BOLD, false);
    store.setDefault(JET_COMMENT_ITALIC, true);
    store.setDefault(JET_COMMENT_UNDERLINE, false);
    
    PreferenceConverter.setDefault(store, JET_CUSTOM_TAG_FG_COLOR, IJETColorConstants.JET_CUSTOM_TAG_FG);
    store.setDefault(JET_CUSTOM_TAG_BOLD, false);
    store.setDefault(JET_CUSTOM_TAG_ITALIC, false);
    store.setDefault(JET_CUSTOM_TAG_UNDERLINE, true);
    
    PreferenceConverter.setDefault(store, JET_EXPRESSION_FG_COLOR, IJETColorConstants.JET_EXPRESSION_FG);
    store.setDefault(JET_EXPRESSION_BOLD, false);
    store.setDefault(JET_EXPRESSION_ITALIC, false);
    store.setDefault(JET_EXPRESSION_UNDERLINE, false);
    
    PreferenceConverter.setDefault(store, JET_DIRECTIVE_FG_COLOR, IJETColorConstants.JET_DIRECTIVE_FG);
    store.setDefault(JET_DIRECTIVE_BOLD, false);
    store.setDefault(JET_DIRECTIVE_KEYWORD_BOLD, true);
    store.setDefault(JET_DIRECTIVE_ITALIC, false);
    store.setDefault(JET_DIRECTIVE_UNDERLINE, false);

    PreferenceConverter.setDefault(store, JET_SCRIPTLET_FG_COLOR, IJETColorConstants.JET_SCRIPTLET_FG);
    store.setDefault(JET_SCRIPTLET_BOLD, false);
    store.setDefault(JET_SCRIPTLET_ITALIC, true);
    store.setDefault(JET_SCRIPTLET_UNDERLINE, false);
    
    PreferenceConverter.setDefault(store, JET_DEFAULT_BG_COLOR, IJETColorConstants.JET_DEFAULT_BG);
    PreferenceConverter.setDefault(store, JET_EXPRESSION_BG_COLOR, IJETColorConstants.JET_EXPRESSION_BG);
    
    store.setDefault(AUTO_COMPLETE_ENABLED, store.getDefaultBoolean(PreferenceConstants.CODEASSIST_AUTOACTIVATION));
    store.setDefault(AUTO_COMPLETE_DELAY, store.getDefaultInt(PreferenceConstants.CODEASSIST_AUTOACTIVATION_DELAY));    
  }

}
