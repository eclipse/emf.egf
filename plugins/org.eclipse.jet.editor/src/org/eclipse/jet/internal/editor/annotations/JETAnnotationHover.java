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
package org.eclipse.jet.internal.editor.annotations;

import java.util.*;
import org.eclipse.jface.text.*;
import org.eclipse.jface.text.source.*;

public class JETAnnotationHover implements IAnnotationHover {

  /**
   * Returns the distance to the ruler line.
   * @param position Position
   * @param document IDocument
   * @param line int
   * @return int
   */
  protected int compareRulerLine(Position position, IDocument document, int line) {
    if (position.getOffset() > -1 && position.getLength() > -1) {
      try {
        int javaAnnotationLine = document.getLineOfOffset(position.getOffset());
        if (line == javaAnnotationLine)
          return 1;
        if (javaAnnotationLine <= line
            && line <= document.getLineOfOffset(position.getOffset() + position.getLength()))
          return 2;
      } catch (BadLocationException x) {
      }
    }
    return 0;
  }
  /**
   * Selects a set of markers from the two lists. By default, it just returns the set of exact
   * matches.
   * @param exactMatch List
   * @param including List
   * @return List
   */
  protected List select(List exactMatch, List including) {
    return exactMatch;
  }
  /**
   * Returns one marker which includes the ruler's line of activity.
   * @param viewer ISourceViewer
   * @param line int
   * @return List
   */
  protected List getAnnotationsForLine(ISourceViewer viewer, int line) {
    IDocument document = viewer.getDocument();
    IAnnotationModel model = viewer.getAnnotationModel();
    if (model == null)
      return null;
    List exact = new ArrayList();
    List including = new ArrayList();
    Iterator e = model.getAnnotationIterator();
    HashMap messagesAtPosition = new HashMap();
    while (e.hasNext()) {
      Object o = e.next();
      if (o instanceof JETProblemAnnotation) {
        JETProblemAnnotation a = (JETProblemAnnotation) o;
        Position position = model.getPosition(a);
        if (position != null && !isDuplicateAnnotation(messagesAtPosition, position, a.getText()))
          switch (compareRulerLine(position, document, line)) {
          case 1: // '\001'
            exact.add(a);
            break;

          case 2: // '\002'
            including.add(a);
            break;
          }
      }
    }
    return select(exact, including);
  }
  /**
   * Method isDuplicateAnnotation.
   * @param messagesAtPosition Map
   * @param position Position
   * @param message String
   * @return boolean
   */
  private boolean isDuplicateAnnotation(Map messagesAtPosition, Position position, String message) {
    if (messagesAtPosition.containsKey(position)) {
      Object value = messagesAtPosition.get(position);
      if (message.equals(value))
        return true;
      if (value instanceof List) {
        List messages = (List) value;
        if (messages.contains(message))
          return true;
        messages.add(message);
      } else {
        ArrayList messages = new ArrayList();
        messages.add(value);
        messages.add(message);
        messagesAtPosition.put(position, messages);
      }
    } else {
      messagesAtPosition.put(position, message);
    }
    return false;
  }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.text.source.IAnnotationHover#getHoverInfo(org.eclipse
     * .jface.text.source.ISourceViewer, int)
     */
    public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {
        List annotations = getAnnotationsForLine(sourceViewer, lineNumber);
        if (annotations != null) {
            int size = annotations.size();
            if (size == 1) {
                JETProblemAnnotation annotation = (JETProblemAnnotation) annotations.get(0);
                String message = annotation.getText();
                if (message != null && message.trim().length() > 0)
                    return message;
            } else {
                List messages = new ArrayList();
                for (int i = 0; i < size; i++) {
                    JETProblemAnnotation javaAnnotation = (JETProblemAnnotation) annotations.get(i);
                    String message = javaAnnotation.getText();
                    if (message != null && message.trim().length() > 0) {
                        messages.add(message.trim());
                    }
                }

                if (messages.size() == 1)
                    return (String) messages.get(0);
                if (messages.size() > 1){
                    String result = "Multiple markers at this line"+"\n";
                    for(int j = 0;j<messages.size();j++){
                        result = result + "    - "+messages.get(j);
                        if(j!=messages.size()-1){
                            result = result +"\n";
                        }
                    }
                    return result; 
                }
            }
        }
        return "";
    }
}