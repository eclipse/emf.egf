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
 * Base class to implement type holders that host primitive types : String, int, boolean...
 * @author Guillaume Brocard
 */
public abstract class PrimitiveTypeHolder extends AbstractTypeHolder {
  
  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#isJava()
   */
  public boolean isJava() {
    return false;
  }

  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#setPluginId(java.lang.String)
   */
  public void setPluginId(String pluginId_p) {
    // Do nothing.
  }
  
}
