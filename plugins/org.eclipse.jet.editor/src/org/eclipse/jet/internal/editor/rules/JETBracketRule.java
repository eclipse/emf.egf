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
package org.eclipse.jet.internal.editor.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.Token;

/**
 * @author jcheuoua
 * @version $Revision: 1.2 $
 */
public class JETBracketRule extends MultiLineRule {
  protected IToken token;

  /**
   * Constructor for JETBracketRule.
   * 
   * @param token
   *          IToken
   */
  public JETBracketRule(IToken token) {
    super("<%", "%>", token);
    this.token = token;
  }
  
  /**
   * Method evaluate.
   * 
   * @param scanner
   *          ICharacterScanner
   * @return IToken
   * @see org.eclipse.jface.text.rules.IRule#evaluate(ICharacterScanner)
   */
  public IToken evaluate(ICharacterScanner scanner) {
    char c = (char) scanner.read();
    if (c == '%') { // we're reaching the end of the token zone
      c = (char) scanner.read();
      if (c == '>') {
        return token;
      } else {
        scanner.unread();
        scanner.unread();
        return Token.UNDEFINED;
      }
    }
    if (c == '<') { // we're at the beginning of the token zone
      c = (char) scanner.read();
      if (c == '%') {
        c = (char) scanner.read();
        if (c == '!' || c == '@' || c == '=' || c == '-') {
          return token;
        } else {
          scanner.unread();
          return token;
        }
      } else {
        scanner.unread();
        scanner.unread();
        return Token.UNDEFINED;
      }
    } else {
      scanner.unread();
      return Token.UNDEFINED;
    }
  }
}
