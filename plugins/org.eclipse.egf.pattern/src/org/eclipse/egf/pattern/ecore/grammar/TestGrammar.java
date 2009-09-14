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
package org.eclipse.egf.pattern.ecore.grammar;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

/**
 * @author brocard
 *
 */
public class TestGrammar {
  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {
    CharStream in = new ANTLRStringStream("READ(/org.eclipse.egf.pattern.helloworld/templates/helloworld/helloWorld.jet);PATTERN(library1.pattern1#helloworld);CALL(helloworld);SUPER();"); //$NON-NLS-1$
    PatternLanguageLexer lexer = new PatternLanguageLexer(in);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    PatternLanguageParser parser = new PatternLanguageParser(tokens);
    CommonTree tree = (CommonTree) parser.call().getTree();
    System.out.println(tree.toStringTree());
    explore(tree, 0);
  }

  /**
   * Explore tree.
   * @param tree_p
   */
  protected static void explore(Tree tree_p, int tabCount_p) {
    if (null == tree_p) {
      return;
    }
    int childCount = tree_p.getChildCount();
    int tabCount = tabCount_p + 2;
    for (int i = 0; i < childCount; i++) {
      Tree childTree = tree_p.getChild(i);
      for (int j = 0; j < tabCount; j++) {
        System.out.print(" "); //$NON-NLS-1$
      }
      System.out.println(childTree.getText());
      explore(childTree, tabCount);
    }
  }
}
