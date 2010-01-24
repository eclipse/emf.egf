/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JavaDocumentReader {
    public static final int EOF = -1;

    private IDocument document;

    private int offset;

    /**
     * Constructor for JavaDocumentReader.
     * 
     * @param document
     *          IDocument
     * @param documentOffset
     *          int
     */
    public JavaDocumentReader(IDocument document, int documentOffset) {
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
