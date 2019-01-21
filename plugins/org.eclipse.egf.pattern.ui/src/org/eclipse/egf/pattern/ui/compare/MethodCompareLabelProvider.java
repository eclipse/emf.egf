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

import org.eclipse.compare.ICompareInputLabelProvider;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Matthieu Helleboid
 */
public class MethodCompareLabelProvider extends LabelProvider implements ICompareInputLabelProvider {

	public Image getAncestorImage(Object input) {
		return null;
	}

	public String getAncestorLabel(Object input) {
		if (input == null || ((DiffNode) input).getAncestor() == null)
			return null;
		return ((DiffNode) input).getAncestor().getName();
	}

	public Image getLeftImage(Object input) {
		return null;
	}

	public String getLeftLabel(Object input) {
		if (input == null)
			return null;
		return ((DiffNode) input).getLeft().getName();
	}

	public Image getRightImage(Object input) {
		return null;
	}

	public String getRightLabel(Object input) {
		if (input == null)
			return null;
		return ((DiffNode) input).getRight().getName();
	}
}
