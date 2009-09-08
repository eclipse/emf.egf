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
package org.eclipse.egf.model.contract.type;

/**
 * Provides an implementation to host the primitive type boolean.
 * @author Guillaume Brocard
 */
public class BooleanTypeHolder extends PrimitiveTypeHolder {
  
  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#getValue(java.lang.String)
   */
  public Object getValue(String value_p) {
    return Boolean.valueOf(value_p);
  }

  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#isValid(java.lang.String)
   */
  public boolean isValid(String value_p) {
    return (Boolean.TRUE.toString().equalsIgnoreCase(value_p) || Boolean.FALSE.toString().equalsIgnoreCase(value_p));
  }
  
}
