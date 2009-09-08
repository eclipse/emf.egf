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
package org.eclipse.egf.core.ui.internal.databinding;

/**
 * Lightweight structure to maintain a java type involved in data binding mechanism.
 * @author fournier
 */
public class JavaTypeHolder extends AbstractDataBindingType {
  /**
   * Fully qualified class name.
   */
  private String _type;

  public static final String PROPERTY_TYPE = "type"; //$NON-NLS-1$

  /**
   * Constructor.
   * @param type_p
   */
  public JavaTypeHolder(String type_p) {
    _type = type_p;
  }

  /**
   * Get type.
   * @return the type
   */
  public String getType() {
    return _type;
  }

  /**
   * Set given type.
   * @param type_p the type to set
   */
  public void setType(String type_p) {
    _type = type_p;
  }
}
