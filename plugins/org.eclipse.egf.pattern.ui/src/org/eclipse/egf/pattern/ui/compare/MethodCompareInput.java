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

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.model.pattern.PatternMethod;

/**
 * @author Matthieu Helleboid
 */
public class MethodCompareInput extends CompareEditorInput {
	private PatternMethod patternMethod;
	private PatternMethod superPatternMethod;

	public MethodCompareInput(PatternMethod patternMethod,
			PatternMethod superPatternMethod) {
		super(new CompareConfiguration());
		
		this.patternMethod = patternMethod;
		this.superPatternMethod = superPatternMethod;
	}

	protected Object prepareInput(IProgressMonitor pm) {
		MethodCompareItem left = new MethodCompareItem(superPatternMethod); //$NON-NLS-1$
		MethodCompareItem right = new MethodCompareItem(patternMethod); //$NON-NLS-1$

		getCompareConfiguration().setLeftEditable(left.isEditable());
		getCompareConfiguration().setLeftLabel(left.getName());

		getCompareConfiguration().setRightEditable(right.isEditable());
		getCompareConfiguration().setRightLabel(right.getName());

		return new DiffNode(left, right);
	}
}