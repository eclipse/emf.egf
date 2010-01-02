package org.eclipse.egf.pattern.ui.editors.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;

public class ParameterNonEmptyNamesConstraint extends NonEmptyNamesConstraint {
    private EObject eObj;

    @Override
    public IStatus validate(IValidationContext ctx) {
        eObj = ctx.getTarget();
        if (eObj instanceof PatternParameter) {
            if (checkNameEmpty((ModelElement) eObj)) {
                return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() });
            }
        }
        return ctx.createSuccessStatus();
    }
}
