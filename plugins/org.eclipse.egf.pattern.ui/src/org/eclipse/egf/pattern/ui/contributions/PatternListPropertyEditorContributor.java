/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.contributions;

import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.TypePatternList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternListPropertyEditorContributor extends AbstractPatternListPropertyEditorContributor<PatternElement> {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, PatternPackage.Literals.TYPE_PATTERN_LIST__ELEMENTS) && object instanceof TypePatternList;
    }

    @Override
    protected EList<PatternElement> getElements(Object object) {
        final TypePatternList value = (TypePatternList) object;

        return value.getElements();
    }
}
