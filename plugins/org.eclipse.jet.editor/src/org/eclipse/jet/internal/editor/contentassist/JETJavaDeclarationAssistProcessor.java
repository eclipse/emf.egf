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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;
import org.eclipse.jet.core.parser.ast.JETCompilationUnit;
import org.eclipse.jet.core.parser.ast.JavaDeclaration;
import org.eclipse.jet.internal.editor.JETEditorHelper;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class JETJavaDeclarationAssistProcessor extends AbstractJETAssistProcessor {
  private char completionProposalAutoActivationCharacters[];

  public JETJavaDeclarationAssistProcessor(JETTextEditor editor) {
    super(editor);
    completionProposalAutoActivationCharacters = editor.getEditorPreferenceStore().getString(
        "content_assist_autoactivation_triggers_java").toCharArray();
  }

  public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
    JETCompilationUnit cu = editor.requestCompilationUnit();
    JavaDeclaration declaration = (JavaDeclaration) editor.getASTElement(offset);
    
    // locate the java content first offset start in the JET document.
    // a java element is of the form <% {java content} %>
    // in order to have an exact matching between the completion offset in the JET document and the 
    // completion offset of the java content, we should perform the offset matching with the java content start
    // not with the element offset start (the "<%" char offset start)
    int javaContentStart = declaration.getJavaStart();

    IJavaProject javaProject = editor.getJavaProject();
    if (javaProject != null) {
      Map mappingPositions = new HashMap();
      String javaSource = editor.compilationHelper().getJavaCode(cu, mappingPositions);
      int javaStartOffset = ((Position)mappingPositions.get(declaration)).offset;
      int javaOffset = javaStartOffset + (offset - javaContentStart);
      
      // check that the positions matches
      JETEditorHelper.checkOffsetPositions(javaSource, viewer.getDocument().get(), javaContentStart, javaStartOffset, declaration.getJavaEnd() - javaContentStart); 
      
      IJavaCompletionProposal javaCompletionProposals[] = JETEditorHelper
          .getJavaCompletionProposal(javaProject, cu, javaSource, viewer, javaOffset);
      JETEditorHelper.adjustResults(javaCompletionProposals, offset);
      return javaCompletionProposals;
    } else {
      return null;
    }
  }

  public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
    return null;
  }

  public char[] getCompletionProposalAutoActivationCharacters() {
    return completionProposalAutoActivationCharacters;
  }

  public char[] getContextInformationAutoActivationCharacters() {
    return null;
  }

  public IContextInformationValidator getContextInformationValidator() {
    return null;
  }

  public String getErrorMessage() {
    return null;
  }
}