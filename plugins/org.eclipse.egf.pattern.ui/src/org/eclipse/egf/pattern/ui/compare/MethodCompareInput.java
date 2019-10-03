/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.compare;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.compare.structuremergeviewer.Differencer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.model.pattern.PatternMethod;

/**
 * @author Matthieu Helleboid
 */
public class MethodCompareInput extends CompareEditorInput {
	private PatternMethod patternMethod;
	private PatternMethod superPatternMethod;
	private static final MethodCompareLabelProvider labelProvider = new MethodCompareLabelProvider();

	public MethodCompareInput(PatternMethod patternMethod,
			PatternMethod superPatternMethod) {
		this(new CompareConfiguration(), patternMethod, superPatternMethod);
	}

	public MethodCompareInput(CompareConfiguration compareConfiguration,
			PatternMethod patternMethod,
			PatternMethod superPatternMethod) {
		super(compareConfiguration);

		this.patternMethod = patternMethod;
		this.superPatternMethod = superPatternMethod;

	}

	protected Object prepareInput(IProgressMonitor pm) {
		MethodCompareItem left = new MethodCompareItem(superPatternMethod); //$NON-NLS-1$
		MethodCompareItem right = new MethodCompareItem(patternMethod); //$NON-NLS-1$

		PatternMethod superSuperPattern = CompareHelper.getSuperMethod(superPatternMethod);
		DiffNode diffNode;
		if (superSuperPattern != null) {
			MethodCompareItem ancestor = new MethodCompareItem(superSuperPattern);
			diffNode = new DiffNode(Differencer.CONFLICTING, ancestor, left, right);
		} else
			diffNode = new DiffNode(left, right);
		
		getCompareConfiguration().setDefaultLabelProvider(labelProvider);
		return diffNode;
	}
}