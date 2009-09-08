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
package org.eclipse.egf.fc.generator.java.contract.type;

import org.eclipse.egf.model.contract.type.PrimitiveTypeHolder;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;


/**
 * Provides an implementation to host the {@link GenResourceKind} enumeration.
 * @author Guillaume Brocard
 */
public class ResourceTypeHolder extends PrimitiveTypeHolder {

  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#getValue(java.lang.String)
   */
  public Object getValue(String value_p) {
    return GenResourceKind.get(value_p);
  }

  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#isValid(java.lang.String)
   */
  public boolean isValid(String value_p) {
    return GenResourceKind.get(value_p) != null;
  }
  
}
