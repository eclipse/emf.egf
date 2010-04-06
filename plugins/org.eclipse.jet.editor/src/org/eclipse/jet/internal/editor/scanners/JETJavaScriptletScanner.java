/*******************************************************************************
 * Copyright (c) 2005, 2007 ILOG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Joel Cheuoua - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jet.internal.editor.scanners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jet.internal.editor.configuration.JETEditorPreferenceConstants;
import org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager;
import org.eclipse.jet.internal.editor.rules.JETBracketRule;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IToken;

public class JETJavaScriptletScanner extends JETJavaCodeScanner {

  public JETJavaScriptletScanner(JETTokenStyleManager manager, IPreferenceStore preferenceStore) {
    super(manager, JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR);
    setDefaultReturnToken(manager.requestDefaultToken());    
  }
  
  protected List createRules(JETTokenStyleManager manager) {
    List rules = new ArrayList();
    List parentRules = super.createRules(manager);
    IToken bracket = manager.requestToken("__jet_bracket", 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_COLOR, 
        JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_BOLD, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_ITALIC, 
        null, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_UNDERLINE);
    // Add rule for brackets
    rules.add(new JETBracketRule(bracket));
    rules.addAll(parentRules);
    return rules;
  }  
}
