/**
 * <copyright>
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.templateEditor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class DocumentReader {
    public static final int EOF = -1;

    private IDocument document;

    private int offset;

    /**
     * Constructor for JavaDocumentReader.
     * 
     * @param document
     *            IDocument
     * @param documentOffset
     *            int
     */
    public DocumentReader(IDocument document, int documentOffset) {
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
