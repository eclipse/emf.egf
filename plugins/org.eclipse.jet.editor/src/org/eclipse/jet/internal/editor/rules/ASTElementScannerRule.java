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

import org.eclipse.jet.core.parser.ast.JETASTElement;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.partition.JETDocumentPartitionScanner;
import org.eclipse.jface.text.rules.*;

public abstract class ASTElementScannerRule implements IPredicateRule {
  private JETTextEditor editor;

  private IToken successToken;

  public ASTElementScannerRule(JETTextEditor editor, IToken successToken) {
    this.editor = editor;
    this.successToken = successToken;
  }

  public IToken getSuccessToken() {
    return successToken;
  }

  public IToken evaluate(ICharacterScanner scanner) {
    return evaluate(scanner, false);
  }

  public IToken evaluate(ICharacterScanner scanner, boolean resume) {
    JETDocumentPartitionScanner jetScanner = (JETDocumentPartitionScanner) scanner;
    int offset = jetScanner.getNextCharacterOffset();
    JETASTElement element = editor.getASTElement(offset);
    if (element != null && isAcceptedElement(element)) {
      int length = element.getEnd() - offset;
      for (int i = 0; i < length; i++)
        scanner.read();

      return successToken;
    } else {
      return Token.UNDEFINED;
    }
  }

  protected abstract boolean isAcceptedElement(JETASTElement jet2astelement);
}
