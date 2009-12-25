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

import org.eclipse.egf.common.constant.IDiagnostic;
import org.eclipse.egf.core.production.l10n.CoreProductionMessages;

/**
 * @author Guiu
 * 
 */
public class InvocationException extends Exception implements IDiagnostic {

  /**
   * 
   */
  private static final long serialVersionUID = -9002049838656655457L;

  /**
   * The severity.
   * 
   * @see #getSeverity
   */
  protected int _severity;

  /**
   * The header.
   * 
   * @see #getHeader
   */
  protected String _header;

  /**
   * @param severity
   * @param header
   * @param message
   * @param cause
   */
  public InvocationException(int severity, String header, String message, Throwable cause) {
    super(message, cause);
    _severity = severity;
    _header = header;
    _severity = computeSeverity();
  }

  /**
   * @param severity
   * @param message
   * @param cause
   */
  public InvocationException(int severity, String message, Throwable cause) {
    this(severity, null, message, cause);
  }

  /**
   * @param message
   * @param cause
   */
  public InvocationException(String header, String message, Throwable cause) {
    this(ERROR, header, message, cause);
  }

  /**
   * @param message
   * @param cause
   */
  public InvocationException(String message, Throwable cause) {
    this(ERROR, null, message, cause);
  }

  /**
   * @param severity
   * @param message
   */
  public InvocationException(int severity, String header, String message) {
    this(severity, header, message, null);
  }

  /**
   * @param severity
   * @param message
   */
  public InvocationException(int severity, String message) {
    this(severity, null, message, null);
  }

  /**
   * @param message
   */
  public InvocationException(String header, String message) {
    this(INFO, header, message, null);
  }

  /**
   * @param message
   */
  public InvocationException(String message) {
    this(INFO, null, message, null);
  }

  /**
   * @param severity
   * @param cause
   */
  public InvocationException(int severity, Throwable cause) {
    this(severity, null, null, cause);
  }

  /**
   * @param cause
   */
  public InvocationException(Throwable cause) {
    this(ERROR, null, null, cause);
  }

  /**
   * Set the header relative to the problem.
   */
  public void setHeader(String header) {
    if (header == null || header.trim().length() == 0) {
      _header = null;
    }
    _header = header.trim();
  }

  /**
   * Returns a header relative to the problem.
   */
  public String getHeader() {
    if (_header != null) {
      return _header;
    }
    return CoreProductionMessages.InvocationException_Header_Default;
  }

  /**
   * Returns an indicator of the severity of the problem.
   */
  public int getSeverity() {
    return _severity;
  }

  private int computeSeverity() {
    int severity = getSeverity();
    if (getCause() != null) {
      if (getCause() instanceof InvocationException) {
        int childSeverity = ((InvocationException) getCause()).computeSeverity();
        if (childSeverity > severity) {
          severity = childSeverity;
        }
      }
    }
    return severity;
  }

}
