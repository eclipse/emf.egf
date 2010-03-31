/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.ant.taskdefs;

import org.apache.tools.ant.BuildException;

/**
 * @author Xavier Maysonnave
 * 
 */
public class NestedElement {

  /**
   * Throws a <tt>BuildException</tt> if <tt>expression</tt> is false.
   * 
   * @param message
   * @param expression
   * @throws BuildException
   */
  public static void assertTrue(String message, boolean expression) throws BuildException {
    if (expression == false) {
      throw new BuildException(message);
    }
  }

  /**
   * All the attribute checks should be performed in this method.
   * 
   * @throws BuildException
   */
  protected void checkAttributes() throws BuildException {
    // Subclasses may override this method
  }

}
