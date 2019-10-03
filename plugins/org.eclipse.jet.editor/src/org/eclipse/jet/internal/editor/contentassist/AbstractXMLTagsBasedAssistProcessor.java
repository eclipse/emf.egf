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
package org.eclipse.jet.internal.editor.contentassist;

import java.util.*;

import org.eclipse.jet.internal.editor.JETDocumentReader;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public abstract class AbstractXMLTagsBasedAssistProcessor extends AbstractJETAssistProcessor {

  private TreeSet keywordSet;
  private TreeSet innerKeywordSet;
  private TreeMap innerMap;

  public AbstractXMLTagsBasedAssistProcessor(JETTextEditor editor) {
    super(editor);
    keywordSet = new TreeSet();
    innerKeywordSet = new TreeSet();
    innerMap = new TreeMap();
    String tagAttrs[][] = getTagAttributes();
    for (int i = 0; i < tagAttrs.length; i++)
      keywordSet.add(tagAttrs[i][0]);

    for (int i = 0; i < tagAttrs.length; i++) {
      TreeSet innerSet = new TreeSet();
      for (int j = 1; j < tagAttrs[i].length; j++) {
        innerSet.add(tagAttrs[i][j]);
        innerKeywordSet.add(tagAttrs[i][j]);
      }

      innerMap.put(tagAttrs[i][0], innerSet);
    }

  }

  public abstract String[] getRootTags();

  public abstract String[][] getTagAttributes();

  public String[] getAllKeywords() {
    return (String[]) keywordSet.toArray(new String[keywordSet.size()]);
  }

  public String[] getAllInnerKeywords() {
    return (String[]) innerKeywordSet.toArray(new String[innerKeywordSet.size()]);
  }

  public String[] getInnerKeywordsFor(String key) {
    TreeSet set = (TreeSet) (TreeSet) innerMap.get(key);
    if (set == null && key.length() == 0)
      return getRootTags();
    else if (set != null)
      return (String[]) set.toArray(new String[set.size()]);
    return new String[0];
  }

  private boolean prefixMatches(String prefix, String word) {
    prefix = prefix.toLowerCase();
    return word.startsWith(prefix);
  }

  public String[] getAllWordsWithPrefix(String prefix) {
    String all[] = getAllKeywords();
    return getMatched(prefix, all);
  }

  private String[] getMatched(String prefix, String all[]) {
    ArrayList matched = new ArrayList(10);
    for (int i = 0; i < all.length; i++)
      if (prefixMatches(prefix, all[i]))
        matched.add(all[i]);

    return (String[]) matched.toArray(new String[matched.size()]);
  }

  public String[] getTagsWithPrefix(String prefix) {
    return getMatched(prefix, getRootTags());
  }

  public String[] getNonTagsKeywordsWithPrefix(String key, String prefix) {
    return getMatched(prefix, getInnerKeywordsFor(key));
  }

  protected String[] getAllWords(char c, JETDocumentReader reader) {
    ArrayList all = new ArrayList(20);
    char currChar = c;
    currChar = trimBlanksBackward(reader, currChar);
    for (boolean done = false; !done;) {
      Stack stack = new Stack();
      for (; currChar != '\uFFFF' && !Character.isWhitespace(currChar); currChar = reader.readBackward())
        stack.push(new Character(currChar));

      String s;
      for (s = new String(); !stack.empty(); s = (new StringBuilder(String.valueOf(s))).append(
          ((Character) stack.pop()).toString()).toString())
        ;
      int jspPt = s.indexOf("<%@");
      if (jspPt >= 0) {
        s = s.substring(jspPt + 3);
        done = true;
      }
      all.add(s);
      currChar = trimBlanksBackward(reader, currChar);
      if (currChar == '\uFFFF' || currChar == '@')
        done = true;
    }

    return (String[]) all.toArray(new String[all.size()]);
  }

  private char trimBlanksBackward(JETDocumentReader reader, char currChar) {
    for (; currChar != '\uFFFF' && Character.isWhitespace(currChar); currChar = reader.readBackward())
      ;
    return currChar;
  }

  protected abstract char getRootTagPrevChar();

  public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
    org.eclipse.jface.text.IDocument doc = viewer.getDocument();
    JETDocumentReader reader = new JETDocumentReader(doc, offset);
    char c = reader.readBackward();
    ICompletionProposal result[] = (ICompletionProposal[]) null;
    String allWords[] = getAllWords(c, reader);
    if (Character.isSpaceChar(c)) {
      String nonTagWords[] = getInnerKeywordsFor(allWords[allWords.length - 1]);
      result = new ICompletionProposal[nonTagWords.length];
      for (int i = 0; i < nonTagWords.length; i++)
        result[i] = new CompletionProposal(nonTagWords[i], offset, 0, nonTagWords[i].length());

    } else if (c == getRootTagPrevChar()) {
      String words[] = getRootTags();
      result = new ICompletionProposal[words.length];
      for (int i = 0; i < words.length; i++)
        result[i] = new CompletionProposal(words[i].substring(allWords[0].length()), offset, 0, words[i].length()
            - allWords[0].length(), null, words[i], null, null);

    } else if (Character.isLetter(c)) {
      String words[];
      if (allWords.length > 1)
        words = getNonTagsKeywordsWithPrefix(allWords[allWords.length - 1], allWords[0]);
      else
        words = getTagsWithPrefix(allWords[0]);
      result = new ICompletionProposal[words.length];
      for (int i = 0; i < words.length; i++)
        result[i] = new CompletionProposal(words[i].substring(allWords[0].length()), offset, 0, words[i].length()
            - allWords[0].length(), null, words[i], null, null);

    }
    return result;
  }

}