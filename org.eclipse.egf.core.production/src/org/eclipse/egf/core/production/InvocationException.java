/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.core.production;

/**
 * @author Guiu
 * 
 */
public class InvocationException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = -9002049838656655457L;

  /**
   * @param message
   * @param cause
   */
  public InvocationException(String message, Throwable cause) {
    super(message, cause);

  }

  /**
   * @param message
   */
  public InvocationException(String message) {
    super(message);

  }

  /**
   * @param cause
   */
  public InvocationException(Throwable cause) {
    super(cause);

  }

}
