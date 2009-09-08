/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.ui.toolkit.validators;

import org.apache.log4j.Logger;

/**
 * Implements a validator that checks if given value is not an empty string.
 * @author fournier
 */
public class NotEmptyStringValidator extends AbstractValidator {
  
  // Log4j reference logger.
  private static final Logger __logger = Logger.getLogger(NotEmptyStringValidator.class.getPackage().getName());

  /**
   * Constructs the not empty string validator.
   * @param errorMessage_p The message displayed when {@link #isValid(Object)} returned <code>false</code>.
   */
  public NotEmptyStringValidator(String errorMessage_p) {
    super(errorMessage_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.validators.IValidator#isValid(java.lang.Object)
   */
  public String isValid(Object value_p) {
    String result = getErrorMessage();
    try {
      // Value must be a string here.      
      String stringValue = (String) value_p;
      // Test that the string is not empty.
      if (stringValue != null && stringValue.trim().length() > 0) {
        // Returning null indicates that the value is valid.
        result = null;
      }
    } catch (ClassCastException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("NotEmptyStringValidator.isValid(..) _ "); //$NON-NLS-1$
      __logger.error(loggerMessage.toString(), exception_p);
    }
    return result;
  }
  
}
