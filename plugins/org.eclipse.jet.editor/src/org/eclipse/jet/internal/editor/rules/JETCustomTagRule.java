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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jet.taglib.TagLibrary;
import org.eclipse.jet.taglib.TagLibraryManager;
import org.eclipse.jface.text.rules.*;

public class JETCustomTagRule extends MultiLineRule {
  private Set tagElementNames;
	public JETCustomTagRule(IToken token) {
		super("<", ">", token, '\\');
    String[] tagLibIds = TagLibraryManager.getInstance().getKnownLibraryIds();
    tagElementNames = new HashSet();
    for (int i = 0; i < tagLibIds.length; i++) {
      String id = tagLibIds[i];
      TagLibrary tagLib = TagLibraryManager.getInstance().getTagLibrary(id, true);
      String[] names = tagLib.getTagNames();
      for (int j = 0; j < names.length; j++) {
        String name = names[j];
        tagElementNames.add(tagLib.getDefaultPrefix() + ":" + name);
      }
    }
	}
  
  public IToken evaluate(ICharacterScanner scanner, boolean resume) {
    // TODO Auto-generated method stub
    return super.evaluate(scanner, resume);
  }
  
	protected boolean sequenceDetected(ICharacterScanner scanner, char[] sequence, boolean eofAllowed) {
		int c = scanner.read();
    int readCount = 1;
		if (sequence[0] == '<') {
      // Cut through obvious cases
      if ((char)c == '%') {
        // processing jet instruction - abort
        scanner.unread();
        return false;
      }
      if ((char)c == '?') {
        // processing instruction - abort
        scanner.unread();
        return false;
      }
      if ((char)c == '!') {
        scanner.unread();
        // comment - abort
        return false;
      }
      StringBuffer name = new StringBuffer();            
      while ((char)c == ' ') {
        c = scanner.read();
        readCount++;
      }
      if (c == ICharacterScanner.EOF) {
        for (int i = 0; i < readCount; i++) scanner.unread();
        return false;
      }
      while ((char)c != ' ' && c != ICharacterScanner.EOF && (char)c != '>') {
        name.append((char)c);
        c = scanner.read();
        readCount++;
      }      
      if (tagElementNames.contains(name.toString())) {
        scanner.unread();
        return true;
      } else {
        for (int i = 0; i < readCount; i++) scanner.unread();
        return false;
      }
		} else if (sequence[0] == '>') {
			scanner.unread();
		}
		return super.sequenceDetected(scanner, sequence, eofAllowed);
	}
}
