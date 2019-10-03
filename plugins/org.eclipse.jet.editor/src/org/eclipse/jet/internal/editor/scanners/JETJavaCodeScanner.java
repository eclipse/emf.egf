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
import org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;


/**
 * A Java code scanner for JET-java sections.
 */
public class JETJavaCodeScanner extends BufferedRuleBasedScanner {

  /**
   * Rule to detect java operators.
   */
  private class OperatorRule implements IRule {
    private char[] JAVA_OPERATORS= { ';', '.', '=', '/', '\\', '+', '-', '*', '<', '>', ':', '?', '!', ',', '|', '&', '^', '%', '~'};
    private IToken fToken;

    public OperatorRule(IToken token) {
      fToken= token;
    }

    public boolean isOperator(char character) {
      for (int index= 0; index < JAVA_OPERATORS.length; index++) {
        if (JAVA_OPERATORS[index] == character)
          return true;
      }
      return false;
    }

    /*
     * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
     */
    public IToken evaluate(ICharacterScanner scanner) {
      int character= scanner.read();
      if (isOperator((char) character)) {
        do {
          character= scanner.read();
        } while (isOperator((char) character));
        scanner.unread();
        return fToken;
      } else {
        scanner.unread();
        return Token.UNDEFINED;
      }
    }
  }

  /**
   * Rule to detect java brackets.
   */
  private class BracketRule implements IRule {

    private char[] JAVA_BRACKETS= { '(', ')', '{', '}', '[', ']' };
    private final IToken success;

    public BracketRule(IToken token) {
      success= token;
    }

    public boolean isBracket(char character) {
      for (int index= 0; index < JAVA_BRACKETS.length; index++) {
        if (JAVA_BRACKETS[index] == character)
          return true;
      }
      return false;
    }

    /*
     * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
     */
    public IToken evaluate(ICharacterScanner scanner) {
      int character= scanner.read();
      if (isBracket((char) character)) {
        do {
          character= scanner.read();
        } while (isBracket((char) character));
        scanner.unread();
        return success;
      } else {
        scanner.unread();
        return Token.UNDEFINED;
      }
    }
  }

  private class JavaWordDetector implements IWordDetector {
    /*
     * @see IWordDetector#isWordStart
     */
    public boolean isWordStart(char c) {
      return Character.isJavaIdentifierStart(c);
    }

    /*
     * @see IWordDetector#isWordPart
     */
    public boolean isWordPart(char c) {
      return Character.isJavaIdentifierPart(c);
    }
  }

  private String[] javaKeywords= {
    "abstract", //$NON-NLS-1$
    "break", //$NON-NLS-1$
    "case", "catch", "class", "const", "continue", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
    "default", "do", //$NON-NLS-2$ //$NON-NLS-1$
    "else", "extends", //$NON-NLS-2$ //$NON-NLS-1$
    "final", "finally", "for", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
    "goto", //$NON-NLS-1$
    "if", "implements", "import", "instanceof", "interface", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
    "native", "new", //$NON-NLS-2$ //$NON-NLS-1$
    "package", "private", "protected", "public", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
    "static", "super", "switch", "synchronized", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
    "this", "throw", "throws", "transient", "try", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
    "volatile", //$NON-NLS-1$
    "while", //$NON-NLS-1$
    "assert", //$NON-NLS-1$
    "enum", //$NON-NLS-1$
    "return"  //$NON-NLS-1$    
  };

  private String[] javaTypes= { "class", "interface", "void", "boolean", "char", "byte", "short", "strictfp", "int", "long", "float", "double" }; //$NON-NLS-1$ //$NON-NLS-5$ //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-8$ //$NON-NLS-9$  //$NON-NLS-10$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-2$

  private String[] javaConstants= { "false", "null", "true" }; //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$

  private String defaultBg;
  /**
   * Creates a Java code scanner
   *
   * @param manager the color manager
   * @param store   the preference store
   */
  public JETJavaCodeScanner(JETTokenStyleManager manager, String defaultBg) {
    this.defaultBg = defaultBg;
    List rules = createRules(manager);    
    IRule[] result= new IRule[rules.size()];
    rules.toArray(result);
    setRules(result);
  }


  protected List createRules(JETTokenStyleManager manager) {
    List rules= new ArrayList();

    // Add rule for character constants.
    IToken token= manager.requestToken("__jet_java_string_" + defaultBg, 
        PreferenceConstants.EDITOR_STRING_COLOR, 
        defaultBg, 
        PreferenceConstants.EDITOR_STRING_BOLD, 
        PreferenceConstants.EDITOR_STRING_ITALIC, 
        PreferenceConstants.EDITOR_STRING_STRIKETHROUGH, 
        PreferenceConstants.EDITOR_STRING_UNDERLINE);
    rules.add(new SingleLineRule("'", "'", token, '\\')); //$NON-NLS-2$ //$NON-NLS-1$


    // Add generic whitespace rule.
    //rules.add(new WhitespaceRule(new JETWhitespaceDetector()));

    // Add rule for multiline comments
    token= manager.requestToken("__jet_java_multi_line_comment_" + defaultBg, 
        PreferenceConstants.EDITOR_MULTI_LINE_COMMENT_COLOR, 
        defaultBg, 
        PreferenceConstants.EDITOR_MULTI_LINE_COMMENT_BOLD, 
        PreferenceConstants.EDITOR_MULTI_LINE_COMMENT_ITALIC, 
        PreferenceConstants.EDITOR_MULTI_LINE_COMMENT_STRIKETHROUGH, 
        PreferenceConstants.EDITOR_MULTI_LINE_COMMENT_UNDERLINE);
    MultiLineRule multiLineCommentsRule = new MultiLineRule("/*", "*/", token, '\\');
    rules.add(multiLineCommentsRule);

    //  Add rule for single line comments
    token= manager.requestToken("__jet_java_single_line_comment_" + defaultBg, 
        PreferenceConstants.EDITOR_SINGLE_LINE_COMMENT_COLOR, 
        defaultBg, 
        PreferenceConstants.EDITOR_SINGLE_LINE_COMMENT_BOLD, 
        PreferenceConstants.EDITOR_SINGLE_LINE_COMMENT_ITALIC, 
        PreferenceConstants.EDITOR_SINGLE_LINE_COMMENT_STRIKETHROUGH, 
        PreferenceConstants.EDITOR_SINGLE_LINE_COMMENT_UNDERLINE);
    SingleLineRule singleLineCommentsRule = new SingleLineRule("//", null, token);
    rules.add(singleLineCommentsRule);
    
    // Add word rule for keywords,types and constants
    JavaWordDetector wordDetector= new JavaWordDetector();
    token= manager.requestToken("__jet_java_default_" + defaultBg, 
        PreferenceConstants.EDITOR_JAVA_DEFAULT_COLOR, 
        defaultBg, 
        PreferenceConstants.EDITOR_JAVA_DEFAULT_BOLD, 
        PreferenceConstants.EDITOR_JAVA_DEFAULT_ITALIC, 
        PreferenceConstants.EDITOR_JAVA_DEFAULT_STRIKETHROUGH, 
        PreferenceConstants.EDITOR_JAVA_DEFAULT_UNDERLINE);
    WordRule wordRule= new WordRule(wordDetector, token);
    
    token = manager.requestToken("__jet_java_keyword_" + defaultBg, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_COLOR, 
        defaultBg, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_BOLD, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_ITALIC, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_STRIKETHROUGH, 
        PreferenceConstants.EDITOR_JAVA_KEYWORD_UNDERLINE);
    for (int i=0; i<javaKeywords.length; i++)
      wordRule.addWord(javaKeywords[i], token);
    for (int i=0; i<javaTypes.length; i++)
      wordRule.addWord(javaTypes[i], token);
    for (int i=0; i<javaConstants.length; i++)
      wordRule.addWord(javaConstants[i], token);
    rules.add(wordRule);
    
    // Add rule for operators
    token = manager.requestToken("__jet_java_operator_" + defaultBg, 
        PreferenceConstants.EDITOR_JAVA_OPERATOR_COLOR, 
        defaultBg, 
        PreferenceConstants.EDITOR_JAVA_OPERATOR_BOLD, 
        PreferenceConstants.EDITOR_JAVA_OPERATOR_ITALIC, 
        PreferenceConstants.EDITOR_JAVA_OPERATOR_STRIKETHROUGH, 
        PreferenceConstants.EDITOR_JAVA_OPERATOR_UNDERLINE);;
    rules.add(new OperatorRule(token));

    // Add rule for brackets
    token = manager.requestToken("__jet_java_bracket_" + defaultBg, 
        PreferenceConstants.EDITOR_JAVA_BRACKET_COLOR, 
        defaultBg, 
        PreferenceConstants.EDITOR_JAVA_BRACKET_BOLD, 
        PreferenceConstants.EDITOR_JAVA_BRACKET_ITALIC, 
        PreferenceConstants.EDITOR_JAVA_BRACKET_STRIKETHROUGH, 
        PreferenceConstants.EDITOR_JAVA_BRACKET_UNDERLINE);;
    rules.add(new BracketRule(token));
    return rules;
  }
}
