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
package org.eclipse.jet.internal.editor.configuration.delegates.java;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.configuration.delegates.IJETDefaultTextColorerDelegate;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.*;
import org.eclipse.swt.graphics.Image;

public class JavaContentPartitionConfigurationDelegate implements IJETDefaultTextColorerDelegate {
  private JETJavaSourceViewerConfiguration javaConfiguration;
  
  public JavaContentPartitionConfigurationDelegate(JETTextEditor editor) {
    javaConfiguration = new JETJavaSourceViewerConfiguration(editor);
  }

  public String getName() {
    return "Java Text Content Colorer";
  }

  public Image getImage() {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_CUNIT);
  }

  public IPredicateRule[] getPartitioningRules() {
    org.eclipse.jface.text.rules.IToken string = new Token("__java_string");
    org.eclipse.jface.text.rules.IToken character = new Token("__java_character");
    org.eclipse.jface.text.rules.IToken javaDoc = new Token("__java_javadoc");
    org.eclipse.jface.text.rules.IToken multiLineComment = new Token("__java_multiline_comment");
    org.eclipse.jface.text.rules.IToken singleLineComment = new Token("__java_singleline_comment");
    List rules = new ArrayList();
    rules.add(new EndOfLineRule("//", singleLineComment));
    rules.add(new SingleLineRule("\"", "\"", string, '\\'));
    rules.add(new SingleLineRule("'", "'", character, '\\'));
    EmptyCommentRule wordRule = new EmptyCommentRule(multiLineComment);
    rules.add(wordRule);
    rules.add(new MultiLineRule("/**", "*/", javaDoc));
    rules.add(new MultiLineRule("/*", "*/", multiLineComment));
    IPredicateRule result[] = new IPredicateRule[rules.size()];
    rules.toArray(result);
    return result;
  }

  public ITokenScanner getTokenScanner(String contentType) {
    if (IDocument.DEFAULT_CONTENT_TYPE.equals(contentType))
      return javaConfiguration.getCodeScanner();
    if ("__java_javadoc".equals(contentType))
      return javaConfiguration.getJavaDocScanner();
    if ("__java_multiline_comment".equals(contentType))
      return javaConfiguration.getMultilineCommentScanner();
    if ("__java_singleline_comment".equals(contentType))
      return javaConfiguration.getSinglelineCommentScanner();
    if ("__java_string".equals(contentType))
      return javaConfiguration.getStringScanner();
    if ("__java_character".equals(contentType))
      return javaConfiguration.getStringScanner();
    else
      return javaConfiguration.getCodeScanner();
  }
  
  private class JETJavaSourceViewerConfiguration extends JavaSourceViewerConfiguration {
    public RuleBasedScanner getCodeScanner() {
      return super.getCodeScanner();
    }
    public RuleBasedScanner getMultilineCommentScanner() {
      return super.getMultilineCommentScanner();
    }
    public RuleBasedScanner getSinglelineCommentScanner() {
      return super.getSinglelineCommentScanner();
    }
    public RuleBasedScanner getStringScanner() {
      return super.getStringScanner();
    }
    public RuleBasedScanner getJavaDocScanner() {
      return super.getJavaDocScanner();
    }
    public JETJavaSourceViewerConfiguration(JETTextEditor editor) {
      super(JavaUI.getColorManager(), editor.getEditorPreferenceStore(), editor, null);
    }
  }

  private class EmptyCommentDetector implements IWordDetector {
    public boolean isWordStart(char c) {
      return c == '/';
    }

    public boolean isWordPart(char c) {
      return c == '*' || c == '/';
    }
  }

  private class EmptyCommentRule extends WordRule implements IPredicateRule {
    public IToken evaluate(ICharacterScanner scanner, boolean resume) {
      return evaluate(scanner);
    }

    public IToken getSuccessToken() {
      return fSuccessToken;
    }

    private IToken fSuccessToken;

    public EmptyCommentRule(IToken successToken) {
      super(new EmptyCommentDetector());
      fSuccessToken = successToken;
      addWord("/**/", fSuccessToken);
    }
  }
}