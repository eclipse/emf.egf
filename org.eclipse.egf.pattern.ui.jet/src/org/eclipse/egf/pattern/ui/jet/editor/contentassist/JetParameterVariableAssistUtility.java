/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.editors.templateEditor.computer.PatternParameterProposalComputer;
import org.eclipse.egf.pattern.ui.editors.templateEditor.computer.PatternVariableProposalComputer;
import org.eclipse.egf.pattern.ui.jet.editor.JetTextEditor;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JetParameterVariableAssistUtility {

    private JetTextEditor editor;
    private ITextViewer viewer;
    private int offset;

    public JetParameterVariableAssistUtility(JetTextEditor editor, ITextViewer viewer, int offset) {
        this.editor = editor;
        this.viewer = viewer;
        this.offset = offset;
    }

    public List<ICompletionProposal> getParameterVariableAssist() {
        List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

        Pattern pattern = editor.getPattern();
        // Get the pattern parameter proposals.
        PatternParameterProposalComputer parameterProposalComputer = new PatternParameterProposalComputer(viewer, offset, pattern);
        addProposal(proposals, parameterProposalComputer.computeProposal());

        // Get the pattern variable proposals.
        PatternVariableProposalComputer variableProposalComputer = new PatternVariableProposalComputer(viewer, offset, pattern);
        addProposal(proposals, variableProposalComputer.computeProposal());

        return proposals;
    }

    /**
     * Add the find new proposals in to proposals.
     */
    private void addProposal(List proposals, List newProposals) {
        if (newProposals != null && newProposals.size() != 0) {
            proposals.addAll(newProposals);
        }
    }
}
