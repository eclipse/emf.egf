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
package org.eclipse.jet.internal.editor.configuration.delegates.xml;

import org.eclipse.jdt.ui.text.IColorManager;
import org.eclipse.jet.internal.editor.Activator;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.configuration.delegates.IJETDefaultTextColorerDelegate;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;

public class XMLContentPartitionConfigurationDelegate implements IJETDefaultTextColorerDelegate {
  public static final String XML_COMMENT = "__xml_comment";
  public static final String XML_TAG = "__xml_tag";
  
  private XMLTagScanner tagScanner;
  private XMLScanner scanner;
  private XMLScanner commentScanner;
  private IColorManager colorManager;

  public static interface IXMLColorConstants {
    RGB XML_COMMENT = new RGB(128, 0, 0);
    RGB PROC_INSTR = new RGB(128, 128, 128);
    RGB STRING = new RGB(0, 128, 0);
    RGB DEFAULT = new RGB(0, 0, 0);
    RGB TAG = new RGB(0, 0, 128);
  }

  public class TagRule extends MultiLineRule {

    protected boolean sequenceDetected(ICharacterScanner scanner, char sequence[], boolean eofAllowed) {
      int c = scanner.read();
      if (sequence[0] == '<') {
        if (c == 63) {
          scanner.unread();
          return false;
        }
        if (c == 33) {
          scanner.unread();
          return false;
        }
      } else if (sequence[0] == '>')
        scanner.unread();
      return super.sequenceDetected(scanner, sequence, eofAllowed);
    }

    public TagRule(IToken token) {
      super("<", ">", token);
    }
  }

  public class XMLWhitespaceDetector implements IWhitespaceDetector {
    public boolean isWhitespace(char c) {
      return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    public XMLWhitespaceDetector() {
      super();
    }
  }

  public class XMLScanner extends RuleBasedScanner {

    public XMLScanner(IColorManager manager) {
      super();
      org.eclipse.jface.text.rules.IToken procInstr = new Token(new TextAttribute(manager
          .getColor(IXMLColorConstants.PROC_INSTR)));
      IRule rules[] = new IRule[2];
      rules[0] = new SingleLineRule("<?", "?>", procInstr);
      rules[1] = new WhitespaceRule(new XMLWhitespaceDetector());
      setRules(rules);
    }
  }

  public class XMLTagScanner extends RuleBasedScanner {

    public XMLTagScanner(IColorManager manager) {
      super();
      org.eclipse.jface.text.rules.IToken string = new Token(new TextAttribute(manager
          .getColor(IXMLColorConstants.STRING)));
      IRule rules[] = new IRule[3];
      rules[0] = new SingleLineRule("\"", "\"", string, '\\');
      rules[1] = new SingleLineRule("'", "'", string, '\\');
      rules[2] = new WhitespaceRule(new XMLWhitespaceDetector());
      setRules(rules);
    }
  }

  public XMLContentPartitionConfigurationDelegate(JETTextEditor editor) {
    colorManager = editor.getTokenStyleManager();
  }

  public String getName() {
    return "XML Text Content Colorer";
  }

  public Image getImage() {
    return Activator.getDefault().getWorkbench().getSharedImages().getImage("IMG_OBJ_FILE");
  }

  public IPredicateRule[] getPartitioningRules() {
    org.eclipse.jface.text.rules.IToken xmlComment = new Token(XML_COMMENT);
    org.eclipse.jface.text.rules.IToken tag = new Token(XML_TAG);
    IPredicateRule rules[] = new IPredicateRule[2];
    rules[0] = new MultiLineRule("<!--", "-->", xmlComment);
    rules[1] = new TagRule(tag);
    return rules;
  }

  public ITokenScanner getTokenScanner(String contentType) {
    if (IDocument.DEFAULT_CONTENT_TYPE.equals(contentType))
      return getXMLScanner();
    if (XML_TAG.equals(contentType))
      return getXMLTagScanner();
    if (XML_COMMENT.equals(contentType))
      return getCommentScanner();
    else
      return getXMLScanner();
  }

  protected XMLScanner getCommentScanner() {
    if (commentScanner == null) {
      commentScanner = new XMLScanner(colorManager);
      commentScanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager
          .getColor(IXMLColorConstants.XML_COMMENT))));
    }
    return commentScanner;
  }

  protected XMLScanner getXMLScanner() {
    if (scanner == null) {
      scanner = new XMLScanner(colorManager);
      scanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(IXMLColorConstants.DEFAULT))));
    }
    return scanner;
  }

  protected XMLTagScanner getXMLTagScanner() {
    if (tagScanner == null) {
      tagScanner = new XMLTagScanner(colorManager);
      tagScanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(IXMLColorConstants.TAG))));
    }
    return tagScanner;
  }
}