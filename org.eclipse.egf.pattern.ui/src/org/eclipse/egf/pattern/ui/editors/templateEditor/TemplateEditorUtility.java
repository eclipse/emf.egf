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
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

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
            Collection collection = startPositions.values();
            Iterator e = collection.iterator();
            while (e.hasNext()) {
                Position position = (Position) e.next();
                startOffset = startOffset+position.length+1;
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
}
