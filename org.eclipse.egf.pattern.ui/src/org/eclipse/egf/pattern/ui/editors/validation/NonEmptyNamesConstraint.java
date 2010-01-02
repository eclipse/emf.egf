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

package org.eclipse.egf.pattern.ui.editors.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class NonEmptyNamesConstraint extends AbstractModelConstraint {

    @Override
    public IStatus validate(IValidationContext ctx) {

        EObject eObj = ctx.getTarget();
        EMFEventType eType = ctx.getEventType();

        // In the case of batch mode.
        if (eType == EMFEventType.NULL) {
            String name = null;
            if (eObj instanceof Pattern) {
                name = ((Pattern) eObj).getName();
            }
            // TODO
            if (name == null || name.length() == 0) {
                return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() });
            }
            // In the case of live mode.
        } else {
            Object newValue = ctx.getFeatureNewValue();

            if (newValue == null || ((String) newValue).length() == 0) {
                return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() });
            }
        }

        return ctx.createSuccessStatus();

    }

}
