/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.compare;

import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.compare.structuremergeviewer.Differencer;
import org.eclipse.compare.structuremergeviewer.IDiffElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.egf.pattern.ui.editors.providers.PatternElementLabelProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

/**
 * @author Matthieu Helleboid
 */
public class PatternCompareInput extends CompareEditorInput {
	
	private static final class InputDiffNode extends DiffNode {
		private Object input;

		private InputDiffNode(Object input) {
			super(Differencer.NO_CHANGE);

			this.input = input;
		}

		@Override
		public String getName() {
			return new PatternElementLabelProvider().getText(input);
		}
		
		@Override
		public Image getImage() {
			return new PatternElementLabelProvider().getImage(input);
		}
	}

	private static class InputDiffNodeSwitch extends PatternSwitch<Object> {
		private DiffNode parent;
		private CompareConfiguration compareConfiguration;

		public InputDiffNodeSwitch(CompareConfiguration compareConfiguration, DiffNode parent) {
			super();
			this.compareConfiguration = compareConfiguration;
			this.parent = parent;
		}
		
		public Object casePatternViewpoint(PatternViewpoint patternViewpoint) {
			for (PatternLibrary patternLibrary : patternViewpoint.getLibraries()) {
				DiffNode newNode = new InputDiffNode(patternLibrary);
				parent.add(newNode);
				new InputDiffNodeSwitch(compareConfiguration, newNode).doSwitch(patternLibrary);
			}
			return null;
		};
		
		public Object casePatternLibrary(PatternLibrary patternLibrary) {
			for (Pattern pattern : patternLibrary.getElements()) {
				DiffNode newNode = new InputDiffNode(pattern);
				parent.add(newNode);
				new InputDiffNodeSwitch(compareConfiguration, newNode).doSwitch(pattern);
			}
			return null;
		};
		
		public Object casePattern(Pattern pattern) {
			for (PatternMethod patternMethod : pattern.getMethods()) {
				PatternMethod superMethod = CompareHelper.getSuperMethod(patternMethod);
				if (superMethod != null)
					parent.add((IDiffElement) new MethodCompareInput(compareConfiguration, patternMethod, superMethod).prepareInput(null));
			}
			return null;
		};
	}
	
	private List<Object> inputs;

	public PatternCompareInput(List<Object> inputs) {
		super(new CompareConfiguration());

		this.inputs = inputs;
	}

	protected Object prepareInput(IProgressMonitor pm) {
		DiffNode diffNode = new DiffNode(null, Differencer.NO_CHANGE);
		for (Object input : inputs) 
			new InputDiffNodeSwitch(getCompareConfiguration(), diffNode).doSwitch((EObject) input);
		return diffNode;
	}
}