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
package org.eclipse.egf.common.ui.toolkit.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements a validator that checks if given value matches a regular expression.
 * @author D. GATIBELZA
 */
public class RegExpValidator extends AbstractValidator {
  /**
   * The regular expression to match.
   */
  private Pattern _regExpPattern;

  /**
   * Constructs the regular expression validator.
   * @param errorMessage_p the error message displayed when given value do not match the regular expression.
   * @param regularExpression_p the regular expression to match.
   */
  public RegExpValidator(String errorMessage_p, String regularExpression_p) {
    super(errorMessage_p);
    _regExpPattern = Pattern.compile(regularExpression_p);
  }

  /**
   * Return the regular expression to match.
   * @return The regular expression pattern.
   */
  public Pattern getPattern() {
    return _regExpPattern;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.validators.IValidator#isValid(Object)
   */
  public String isValid(Object value_p) {
    boolean isValid = false;
    // Precondition : given object must be a string.
    if (value_p instanceof String) {
      String value = (String) value_p;
      if (value.length() > 0) {
        // Create a matcher for given value.
        Matcher matcher = _regExpPattern.matcher(value);
        // Does it match the regular expression ?
        isValid = matcher.matches();
      }
    }
    // If given value is not valid, returns the error message; otherwise null that means 'valid'.
    return (!isValid) ? getErrorMessage() : null;
  }
}
