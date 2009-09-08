/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.validation;

import org.eclipse.egf.pattern.Pattern;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.util.Diagnostician;


/**
 * @author Guillaume Brocard
 */
public class PatternValidationHelper {
  /**
   * Validate given pattern.
   * @param pattern_p
   * @param validationHandler_p A validation handler, that allows the creation of a specific parent diagnostic in case of an error.<br>
   * <code>null</code> if returned one is sufficient.<br>
   * Note that this is only required if diagnostic is to be shown in a user dialog, default diagnostic message might then seem too confusing.
   * @return
   */
  public static Diagnostic validatePattern(Pattern pattern_p, IValidationHandler validationHandler_p) {
    // Validate the pattern model as a whole.
    Diagnostician diagnostician = new Diagnostician();
    // Invoke validation.
    Diagnostic diagnostic = diagnostician.validate(pattern_p);
    // If on error, try validation handler.
    boolean validationError = (Diagnostic.ERROR == diagnostic.getSeverity());
    if (validationError && (null != validationHandler_p)) {
      // Create sub-diagnostic dedicated to the model validation.
      DiagnosticChain validationDiagnostic = validationHandler_p.createErrorRootDiagnostic();
      // Then attach all the validation diagnostic children.
      validationDiagnostic.addAll(diagnostic);
    }
    return diagnostic;
  }

  /**
   * Validation handler, that creates expected diagnostic structure for results.
   * @author Guillaume Brocard
   */
  public interface IValidationHandler {
    /**
     * Create a root diagnostic error that contains all the validation error.<br>
     * Allows to choose a different way of 
     * @return
     */
    public abstract DiagnosticChain createErrorRootDiagnostic();
  }
}
