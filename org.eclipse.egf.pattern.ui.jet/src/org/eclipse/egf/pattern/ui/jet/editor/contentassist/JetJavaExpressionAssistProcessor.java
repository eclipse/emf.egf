/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.jet.editor.contentassist;

import java.util.List;

import org.eclipse.egf.pattern.ui.editors.templateEditor.TemplateEditorUtility;
import org.eclipse.egf.pattern.ui.jet.editor.JetEditorHelper;
import org.eclipse.egf.pattern.ui.jet.editor.JetTextEditor;
import org.eclipse.jet.internal.editor.contentassist.JETJavaExpressionAssistProcessor;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JetJavaExpressionAssistProcessor extends JETJavaExpressionAssistProcessor {

    private JetTextEditor editor;

    public JetJavaExpressionAssistProcessor(JetTextEditor editor) {
        super(editor);
        this.editor = editor;
    }

    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {

        ICompletionProposal[] computeCompletionProposals = TemplateEditorUtility.filterJavaMethodProposals(super.computeCompletionProposals(viewer, offset));

        JetParameterVariableAssistUtility utility = new JetParameterVariableAssistUtility(editor, viewer, offset);
        List<ICompletionProposal> proposals = utility.getParameterVariableAssist();

        return JetEditorHelper.getAssistResult(computeCompletionProposals, proposals);
    }
}
