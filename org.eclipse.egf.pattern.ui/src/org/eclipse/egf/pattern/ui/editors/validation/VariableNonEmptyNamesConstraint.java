/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class VariableNonEmptyNamesConstraint extends NonEmptyNamesConstraint {
  private EObject eObj;

  @Override
  public IStatus validate(IValidationContext ctx) {
    eObj = ctx.getTarget();
    if (eObj instanceof PatternVariable) {
      if (checkNameEmpty((PatternVariable) eObj)) {
        return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() });
      }
    }
    return ctx.createSuccessStatus();
  }
}
