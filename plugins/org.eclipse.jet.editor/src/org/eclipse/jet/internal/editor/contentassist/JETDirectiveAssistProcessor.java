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

import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class JETDirectiveAssistProcessor extends AbstractXMLTagsBasedAssistProcessor {
  private static String rootTags[] = { "jet", "taglib", "include", "start", "end" };
  private static String tagAttributes[][] = { { "jet", "package", "class", "imports", "startTag", "endTag" },
      { "taglib", "id", "prefix" }, { "include", "file" }, { "start", "id" }, { "end", "id" } };

  public JETDirectiveAssistProcessor(JETTextEditor editor) {
    super(editor);
  }

  public String[] getRootTags() {
    return rootTags;
  }

  public String[][] getTagAttributes() {
    return tagAttributes;
  }

  protected char getRootTagPrevChar() {
    return '@';
  }

  public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
    return null;
  }

  public char[] getCompletionProposalAutoActivationCharacters() {
    return null;
  }

  public char[] getContextInformationAutoActivationCharacters() {
    return null;
  }

  public IContextInformationValidator getContextInformationValidator() {
    return null;
  }

}