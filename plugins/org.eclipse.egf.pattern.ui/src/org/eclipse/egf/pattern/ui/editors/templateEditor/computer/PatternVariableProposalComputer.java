/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.templateEditor.computer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.editors.templateEditor.TemplateEditorUtility;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.internal.ui.text.java.JavaCompletionProposal;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class PatternVariableProposalComputer extends AbstractProposalComputer {

    private ITextViewer viewer;

    private int offset;

    private Pattern pattern;

    public PatternVariableProposalComputer(ITextViewer viewer, int offset, Pattern pattern) {
        this.viewer = viewer;
        this.offset = offset;
        this.pattern = pattern;
    }

    @Override
    public List<ICompletionProposal> computeProposal() {
        String allWords[] = TemplateEditorUtility.getAllWords(viewer, offset);
        List<ICompletionProposal> variableProposals = new ArrayList<ICompletionProposal>();
        if (allWords.length > 0) {
            String replacedWord = allWords[0];
            int replacementOffset = offset - replacedWord.length();
            EList<PatternVariable> allVariables = pattern.getAllVariables();
            for (PatternVariable variable : allVariables) {
                String variableName = variable.getName();
                String displayName = variableName + " - " + getType(variable.getType());
                if (!"".equals(replacedWord) && variableName.indexOf(replacedWord) == 0) {
                    JavaCompletionProposal propsal = new JavaCompletionProposal(variableName, replacementOffset, replacedWord.length(), Activator.getDefault().getImage(ImageShop.IMG_VARIABLE_OBJ), displayName, variableName.length());
                    variableProposals.add(propsal);
                }
            }
        }
        return variableProposals;
    }
}
