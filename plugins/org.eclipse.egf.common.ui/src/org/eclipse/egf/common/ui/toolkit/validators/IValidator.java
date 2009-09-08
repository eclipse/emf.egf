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

/**
 * An interface for validating any UI data input.
 * <p>
 * This interface should be implemented by classes that wish to act as UI data input validators.
 * </p>
 * @author fournier
 */
public interface IValidator {
  /**
   * Returns a string indicating whether the given value is valid; <code>null</code> means valid, and non-<code>null</code> means invalid, with the result
   * being the error message to display to the end-user.
   * <p>
   * It is the responsibility of the implementor to fully format the message before returning it.
   * </p>
   * @param value the value to be validated
   * @return the error message, or <code>null</code> indicating that the value is valid.
   */
  public String isValid(Object value);
}
