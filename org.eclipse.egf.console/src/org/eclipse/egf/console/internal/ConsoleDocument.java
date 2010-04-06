/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.console.internal;

/**
 * Simple circular buffer that stores a fix number of lines.
 */
public class ConsoleDocument {

  public static final int ERROR = 0; // error received

  public static final int INFO = 1; // message received

  public static final int WARNING = 2; // error received

  public static final int DELIMITER = 3; // delimiter text between runs

  private int[] _lineTypes;

  private String[] _lines;

  private int[] _lineNestings;

  private int _writeIndex = 0;

  private int _readIndex = 0;

  private static final int BUFFER_SIZE = 200;

  public static class ConsoleLine {

    public String _line;

    public int _type;

    public int _nesting;

    ConsoleLine(String line, int type, int nesting) {
      _line = line;
      _type = type;
      _nesting = nesting;
    }

  }

  /**
   * Creates an empty console document.
   */
  public ConsoleDocument() {
    // Nothing to do
  }

  /**
   * Clears the console document.
   */
  public void clear() {
    _lineTypes = null;
    _lines = null;
    _writeIndex = 0;
    _readIndex = 0;
  }

  /**
   * Appends a line of the specified type to the end of the console.
   */
  public void appendConsoleLine(int type, String line, int nesting) {
    if (_lines == null) {
      _lines = new String[BUFFER_SIZE];
      _lineTypes = new int[BUFFER_SIZE];
      _lineNestings = new int[BUFFER_SIZE];
    }
    _lines[_writeIndex] = line;
    _lineTypes[_writeIndex] = type;
    _lineNestings[_writeIndex] = nesting;

    if (++_writeIndex >= BUFFER_SIZE) {
      _writeIndex = 0;
    }
    if (_writeIndex == _readIndex) {
      if (++_readIndex >= BUFFER_SIZE) {
        _readIndex = 0;
      }
    }
  }

  public ConsoleLine[] getLines() {
    if (isEmpty()) {
      return new ConsoleLine[0];
    }
    ConsoleLine[] docLines = new ConsoleLine[_readIndex > _writeIndex ? BUFFER_SIZE : _writeIndex];
    int index = _readIndex;
    for (int i = 0; i < docLines.length; i++) {
      docLines[i] = new ConsoleLine(_lines[index], _lineTypes[index], _lineNestings[index]);
      if (++index >= BUFFER_SIZE) {
        index = 0;
      }
    }
    return docLines;
  }

  public boolean isEmpty() {
    return _writeIndex == _readIndex;
  }

}
