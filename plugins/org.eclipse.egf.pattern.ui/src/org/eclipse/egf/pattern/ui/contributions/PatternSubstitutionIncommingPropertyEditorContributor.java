/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
        return checkFeature(object, descriptor, PatternPackage.Literals.SUBSTITUTION__INCOMING) && object instanceof Substitution;
    }

    @Override
    protected EList<Pattern> getElements(Object object) {
        final Substitution value = (Substitution) object;

        return value.getIncoming();
    }
}