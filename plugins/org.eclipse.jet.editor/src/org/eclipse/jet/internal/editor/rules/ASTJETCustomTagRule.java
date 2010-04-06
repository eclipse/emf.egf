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
import org.eclipse.jet.core.parser.ast.XMLBodyElementEnd;
import org.eclipse.jet.core.parser.ast.XMLElement;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.rules.IToken;

public class ASTJETCustomTagRule extends ASTElementScannerRule {

  public ASTJETCustomTagRule(JETTextEditor editor, IToken token) {
    super(editor, token);
  }

  protected boolean isAcceptedElement(JETASTElement element) {
    return (element instanceof XMLElement) || (element instanceof XMLBodyElementEnd);
  }
}