/**
 * <copyright>
 * 
 * Copyright (c) 2011 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.usecase.pattern.uc3.postprocessing;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Node.Container;
import org.eclipse.egf.model.pattern.Node.DataLeaf;
import org.eclipse.egf.model.pattern.PatternOutputProcessor;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class MyPatternProcessor implements PatternOutputProcessor {

    private final Set<Node> visited = new HashSet<Node>();
    private static final char[] LETTERS = new char[] { 'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y' };

    public void execute(Container root) {

        // Navigation over the tree containing the result of the model-to-text
        // transformation
        // Modifications are realized in the DataLeaf nodes (i.e., leaf nodes of
        // the tree)
        // In this example: starting the DataLeaf text by the '+' character for
        // DataLeaf text starting by a vowel
        for (Node node : root.getChildren()) {
            if (visited.contains(node))
                continue;
            if (node instanceof Container)
                execute((Container) node);
            else {
                if (node instanceof DataLeaf) {
                    DataLeaf leaf = (DataLeaf) node;
                    String data = leaf.getData();
                    if (data != null && data.length() != 0 && isVowel(data.charAt(0)))
                        leaf.setData("+" + data);
                }
                visited.add(node);
            }
        }
        visited.add(root);
    }

    private boolean isVowel(char charAt) {

        for (char c : LETTERS)
            if (c == charAt)
                return true;
        return false;
    }

    public String getProcessorId() {
        return "my.processor.id";
    }

    public void applyOnLoopResult(Container node) {
    }

    public void applyOnLoopResult(StringBuilder builder) {
    }

    public void applyOnExecutionResult(Container node) {
    }

    public void applyOnExecutionResult(StringBuilder builder) {
    }

}
