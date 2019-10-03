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
import org.eclipse.jet.core.parser.ast.JavaExpression;
import org.eclipse.jet.internal.editor.JETEditorHelper;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class JETJavaExpressionAssistProcessor extends AbstractJETAssistProcessor {
  private char completionProposalAutoActivationCharacters[];

  /**
   * @param editor
   */
  public JETJavaExpressionAssistProcessor(JETTextEditor editor) {
    super(editor);
    completionProposalAutoActivationCharacters = editor.getEditorPreferenceStore().getString(
        "content_assist_autoactivation_triggers_java").toCharArray();
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
   */
  public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
    JETCompilationUnit cu = editor.requestCompilationUnit();
    JavaExpression expression = (JavaExpression) editor.getASTElement(offset);
    
    // locate the java content first offset start in the JET document.
    // a java element is of the form <% {java content} %>
    // in order to have an exact matching between the completion offset in the JET document and the 
    // completion offset of the java content, we should perform the offset matching with the java content start
    // not with the element offset start (the "<%" char offset start)
    int javaContentStart = expression.getJavaStart();
    
    IJavaProject javaProject = editor.getJavaProject();
    if (javaProject != null) {
      // fetch the java content generated for all the AST elements till the current expression
      Map mappingPositions = new HashMap();
      String javaSource = editor.compilationHelper().getJavaCode(cu, mappingPositions);
      int javaStartOffset = ((Position)mappingPositions.get(expression)).offset;
      // check that the positions matches
      JETEditorHelper.checkOffsetPositions(javaSource, viewer.getDocument().get(), javaContentStart, javaStartOffset, expression.getJavaEnd() - javaContentStart);       
      
      // calculate where the cursor would be (offset) within the javaSource...
      int javaCursorOffset = javaStartOffset + (offset - javaContentStart);
      IJavaCompletionProposal javaCompletionProposals[] = JETEditorHelper
          .getJavaCompletionProposal(javaProject, cu, javaSource, viewer, javaCursorOffset);
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