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

package org.eclipse.egf.pattern.ui.editors.templateEditor.computer;

import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public abstract class AbstractProposalComputer {
    /**
     * Compute the proposal of java text editor.
     */
    public abstract List<ICompletionProposal> computeProposal();

    /**
     * Get the display String of type.
     */
    public static String getType(String type) {
        if (type == null || type.length() == 0)
            return "";
        int index = type.lastIndexOf("//");
        if (index != -1) {
            return type.substring(index + 2);
        }
        return type;
    }

}
