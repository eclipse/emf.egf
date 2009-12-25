/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.constant;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IDiagnostic {

  /**
   * The bit mask value <code>0x1</code> for a {@link #getSeverity severity} indicating there is an
   * informational message.
   */
  public static int INFO = 0x0;

  /**
   * The bit mask value <code>0x2</code> for a {@link #getSeverity severity} indicating there is
   * warning message.
   */
  public static int WARNING = 0x1;

  /**
   * The bit mask value <code>0x1</code> for a {@link #getSeverity severity} indicating there is an
   * error message.
   */
  public static int ERROR = 0x2;

  /**
   * Returns an indicator of the severity of the problem.
   */
  public int getSeverity();

  /**
   * Set the header relative to the problem
   */
  public void setHeader(String header);

  /**
   * Returns a header relative to the problem
   */
  public String getHeader();

  /**
   * Returns an indicator of the severity of the problem
   */
  public String getMessage();

}
