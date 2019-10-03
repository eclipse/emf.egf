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
package org.eclipse.jet.internal.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

/**
 * @author jcheuoua
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code
 * and Comments
 * @version $Revision: 1.2 $
 */
public class JETDocumentReader {
  public static final int EOF = -1;

  private IDocument document;

  private int offset;

  /**
   * Constructor for JETDocumentReader.
   * 
   * @param document
   *          IDocument
   * @param documentOffset
   *          int
   */
  public JETDocumentReader(IDocument document, int documentOffset) {
    this.document = null;
    offset = -1;
    if (documentOffset > 0)
      offset = documentOffset;
    this.document = document;
  }

  /**
   * Method readForward.
   * 
   * @return char
   */
  public char readForward() {
    try {
      if (document.getChar(offset) == '\uFFFF') {
        return '\uFFFF';
      } else {
        offset++;
        return document.getChar(offset);
      }
    } catch (BadLocationException ex) {
      return '\uFFFF';
    }
  }

  /**
   * Method readBackward.
   * 
   * @return char
   */
  public char readBackward() {
    if (offset <= 0)
      return '\uFFFF';
    try {
      offset--;
      return document.getChar(offset);
    } catch (BadLocationException e) {
      return '\uFFFF';
    }
  }
}