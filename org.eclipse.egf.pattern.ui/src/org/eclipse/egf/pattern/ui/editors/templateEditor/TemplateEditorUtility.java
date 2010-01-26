/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.pattern.ui.editors.templateEditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class TemplateEditorUtility {
    /**
     * @param startPositions2
     * @return current method's contents start lines in the dummy whole
     *         contents.
     */
    public static int getStartPosition(Map<String, Position> startPositions) {
        int startOffset = 0;
        if (startPositions == null || startPositions.size() == 0) {
            return startOffset;
        } else {
            Collection<Position> starts = (Collection<Position>) startPositions.values();
            Iterator<Position> e = starts.iterator();
            while (e.hasNext()) {
                Position position = e.next();
                startOffset = startOffset + position.length + 1;
            }
        }
        return startOffset;
    }

    public static int getSourceLength(InputStream inputstream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputstream));
        int length = 0;
        while (br.read() != -1) {
            ++length;
        }
        br.close();
        return length;
    }

    /**
     * Get the words which will be used in code completion.
     */
    public static String[] getAllWords(ITextViewer viewer, int offset) {
        IDocument doc = viewer.getDocument();
        DocumentReader reader = new DocumentReader(doc, offset);
        char c = reader.readBackward();

        ArrayList<String> all = new ArrayList<String>(20);
        char currChar = c;
        currChar = trimBlanksBackward(reader, currChar);
        for (boolean done = false; !done;) {
            Stack stack = new Stack();
            for (; currChar != '\uFFFF' && !Character.isWhitespace(currChar); currChar = reader.readBackward())
                stack.push(new Character(currChar));

            String s;
            for (s = new String(); !stack.empty(); s = (new StringBuilder(String.valueOf(s))).append(((Character) stack.pop()).toString()).toString())
                ;
            int jePt = s.indexOf("<%=");
            if (jePt >= 0) {
                s = s.substring(jePt + 3);
                done = true;
            } else {
                int jspPt = s.indexOf("<%");
                if (jspPt >= 0) {
                    s = s.substring(jspPt + 2);
                    done = true;
                }
            }
            all.add(s);
            currChar = trimBlanksBackward(reader, currChar);
            if (currChar == '\uFFFF' || currChar == '@')
                done = true;
        }

        return (String[]) all.toArray(new String[all.size()]);
    }

    public static char trimBlanksBackward(DocumentReader reader, char currChar) {
        for (; currChar != '\uFFFF' && Character.isWhitespace(currChar); currChar = reader.readBackward())
            ;
        return currChar;
    }
}
