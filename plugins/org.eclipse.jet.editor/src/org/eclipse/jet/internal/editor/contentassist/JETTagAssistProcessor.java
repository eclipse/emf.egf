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
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;


public class JETTagAssistProcessor extends AbstractJETAssistProcessor {

  public JETTagAssistProcessor(JETTextEditor editor) {
    super(editor);
    // TODO Auto-generated constructor stub
  }

  public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
    // TODO Auto-generated method stub
    return null;
  }

  public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
    // TODO Auto-generated method stub
    return null;
  }

  public char[] getCompletionProposalAutoActivationCharacters() {
    // TODO Auto-generated method stub
    return null;
  }

  public char[] getContextInformationAutoActivationCharacters() {
    // TODO Auto-generated method stub
    return null;
  }

  public IContextInformationValidator getContextInformationValidator() {
    // TODO Auto-generated method stub
    return null;
  }

  public String getErrorMessage() {
    // TODO Auto-generated method stub
    return null;
  }

}
