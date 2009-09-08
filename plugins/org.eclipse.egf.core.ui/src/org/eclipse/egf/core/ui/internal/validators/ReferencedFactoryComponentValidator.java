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
package org.eclipse.egf.core.ui.internal.validators;

import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.ui.internal.data.UIDataHelper;
import org.eclipse.egf.core.ui.internal.databinding.ReferencedFactoryComponent;


/**
 * Validator used to validate a {@link ReferencedFactoryComponent}.
 * @author Guillaume Brocard
 */
public abstract class ReferencedFactoryComponentValidator extends NotEmptyStringValidator {
  /**
   * Constructor.
   * @param errorMessage_p
   */
  public ReferencedFactoryComponentValidator(String errorMessage_p) {
    super(errorMessage_p);
  }

  /**
   * Handle a referenced factory component change.
   * @param newReferencedFactoryComponentIdValue_p can be null if no id is retrieved.
   */
  protected abstract void handleReferencedFactoryComponentChange(String newReferencedFactoryComponentIdValue_p);

  /**
   * @see com.thalesgroup.mde.common.ui.toolkit.validators.NotEmptyStringValidator#isValid(java.lang.Object)
   */
  @Override
  public String isValid(Object value_p) {
    // Check given value is not empty first.
    String result = super.isValid(value_p);
    // If not empty, check it is a valid factory component id.
    if (null == result) {
      // Compute the new referenced factory component id.
      String referencedFactoryComponentId = UIDataHelper.getFactoryComponentIdFor((String) value_p);
      handleReferencedFactoryComponentChange(referencedFactoryComponentId);
      // If no referenced factory component id is found, set the error message.
      if (null == referencedFactoryComponentId) {
        result = getErrorMessage();
      }
    }
    return result;
  }
}