/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui.contributions;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternSubstitutionIncommingPropertyEditorContributor extends AbstractPatternListPropertyEditorContributor<Pattern> {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, PatternPackage.Literals.SUBSTITUTION__REPLACEMENT) && object instanceof Substitution;
    }

    @Override
    protected EList<Pattern> getElements(Object object) {
        return ((Substitution) object).getReplacement();
    }

}
