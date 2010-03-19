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

import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jet.internal.editor.configuration.JETEditorPreferenceConstants;
import org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager;
import org.eclipse.jet.internal.editor.rules.JETBracketRule;
import org.eclipse.jet.internal.editor.rules.WordListDetectorRule;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;

public class JETDirectiveScanner extends RuleBasedScanner {

  public JETDirectiveScanner(JETTokenStyleManager manager, IPreferenceStore preferenceStore) {
    IToken keyword = manager.requestToken("__jet_directive_keyword", 
        JETEditorPreferenceConstants.JET_DIRECTIVE_FG_COLOR, 
        JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR, 
        JETEditorPreferenceConstants.JET_DIRECTIVE_KEYWORD_BOLD, 
        JETEditorPreferenceConstants.JET_DIRECTIVE_ITALIC, 
        null, 
        JETEditorPreferenceConstants.JET_DIRECTIVE_UNDERLINE);
    IToken string = manager.requestToken("__jet_directive_string",
        PreferenceConstants.EDITOR_STRING_COLOR, 
        JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR,
        PreferenceConstants.EDITOR_STRING_BOLD, 
        PreferenceConstants.EDITOR_STRING_ITALIC, 
        null, 
        PreferenceConstants.EDITOR_STRING_UNDERLINE);
    IToken bracket = manager.requestToken("__jet_bracket", 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_COLOR, 
        JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_BOLD, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_ITALIC, 
        null, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_UNDERLINE);
        
		IRule[] rules = new IRule[4];

    // Add rule for brackets
    rules[0] = new JETBracketRule(bracket);
		// Add rule for double quotes
		rules[1] = new SingleLineRule("\"", "\"", string, '\\');
		// Add a rule for single quotes
		rules[2] = new SingleLineRule("'", "'", string, '\\');
		// Add word rule for reserved jet directive words     
    rules[3] = new WordListDetectorRule(keyword, new String[] {"jet", "taglib", "include", "start", "end"});
        
		setRules(rules);
    
    IToken defaultReturnToken = manager.requestToken("__jet_directive", 
        JETEditorPreferenceConstants.JET_DIRECTIVE_FG_COLOR, 
        JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR, 
        JETEditorPreferenceConstants.JET_DIRECTIVE_BOLD, 
        JETEditorPreferenceConstants.JET_DIRECTIVE_ITALIC, 
        null, 
        JETEditorPreferenceConstants.JET_DIRECTIVE_UNDERLINE);
    setDefaultReturnToken(defaultReturnToken);
	}
}
