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
package org.eclipse.jet.internal.editor.rules;

import java.util.Collection;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class WordListDetectorRule implements IRule {
  private IToken success;
  private String[] words; 
  public WordListDetectorRule(IToken token, String[] words) {
    this.success = token;
    this.words = words;
  }
  public WordListDetectorRule(IToken token, Collection words) {
    this.success = token;
    this.words = new String[words.size()];
    this.words = (String[]) words.toArray(this.words);
  }
  public IToken evaluate(ICharacterScanner scanner) {
    char c = (char) scanner.read();
    char initialChar = c;
    for (int i = 0; i < words.length; i++) {
      String keyword = words[i];
      int index = 0;
      while (keyword.length() > index && c == keyword.charAt(index)) {
        c = (char) scanner.read();
        index++;
      }
      if (index == keyword.length()) {// success for this keyword ... we'read until the end
        scanner.unread(); // there is one read in excess at the end
        return success;
      }
      // otherwise, unread and proceed to the next word
      for (int j = 0; j < index; j++) {
        scanner.unread();
      }
      c = initialChar;
    }
    scanner.unread();
    return Token.UNDEFINED;
  }    
}