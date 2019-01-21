/**
 * <copyright>
 * 
 * Copyright (c) 2011 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	private static final char[] LETTERS = new char[] { 'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y' };


	private boolean isVowel(char charAt) {

		for (char c : LETTERS)
			if (c == charAt)
				return true;
				return false;
	}

	public String getProcessorId() {
		return "my.processor.id";
	}

	/*
	 * Post-Processing on each pattern, for each model instance
	 */
	public void applyOnLoopResult(Container node) {
		// Navigation over the tree containing the result of the model-to-text transformation
		// Modifications are realized in the DataLeaf nodes (i.e., leaf nodes of the tree)
		// In this example: starting the DataLeaf text by the '+' character for each DataLeaf text starting by a vowel  
		for (Node childNode : node.getChildren()) {
			if (childNode instanceof Container)
				applyOnLoopResult((Container) childNode);
			else {
				if (childNode instanceof DataLeaf) {
					DataLeaf leaf = (DataLeaf) childNode;
					String data = leaf.getData();
					if (data != null && data.length() != 0 && isVowel(data.charAt(0)))
						leaf.setData("+" + data);
				}
			}
		}
	}

	public void applyOnLoopResult(StringBuilder builder) {
	}

	/*
	 * Post-Processing at the end of the generation, just before being flattened and reduced as a string
	 */
	public void applyOnExecutionResult(Container node) {
		// Navigation over the report tree - Cf. applyOnLoopResult
		for (Node childNode : node.getChildren()) {
			if (childNode instanceof Container)
				applyOnExecutionResult((Container) childNode);
			else {
				if (childNode instanceof DataLeaf) {
					DataLeaf leaf = (DataLeaf) childNode;
					String data = leaf.getData();
					if (data != null && data.length() != 0) {

						// Modification when Class
						if (childNode.getPatternClass() == "org.eclipse.egf.usecase.pattern.uc3.m2treporting.postprocessing.myClassPattern") {
							data = data.replaceFirst("Class", "[Class");
							data = data + "]: ";
							leaf.setData(data);
						}

						// Modification when Attribute
						if (childNode.getPatternClass() == "org.eclipse.egf.usecase.pattern.uc3.m2treporting.postprocessing.myAttributePattern") {
							leaf.setData("{" + data + "}");
						}
					}
				}
			}
		}
	}

	/*
	 * Post-Processing at the end of the generation, just before the reporting step
	 */
	public void applyOnExecutionResult(StringBuilder builder) {
		// In this example, adding a header and footer to the built string
		String line = new String ("-----------------------------------------------------\n");
		StringBuilder header = new StringBuilder();
		StringBuilder footer = new StringBuilder();

		header
		.append (line)
		.append ("Header\n")
		.append (line);

		footer
		.append ("\n\n")
		.append (line)
		.append ("Footer\n")
		.append (line);

		builder.insert(0, header);
		builder.append (footer);
	}

}
