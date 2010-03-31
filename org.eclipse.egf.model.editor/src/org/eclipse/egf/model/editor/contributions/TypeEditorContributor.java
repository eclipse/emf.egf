/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Thomas Guiu
 * 
 */
public class TypeEditorContributor extends AbstractTypeEditorContributor {

  public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
    if (checkFeature(object, descriptor, TypesPackage.Literals.TYPE_ABSTRACT_CLASS__VALUE) && object instanceof TypeAbstractClass) {
      // TypeClass has its own contributor see TypeClassEditorContributor
      if (object instanceof TypeClass && ((TypeClass) object).eContainer() instanceof Contract) {
        return false;
      }
      // TypeAbstractClass bound to an InvocationContract
      if (((TypeAbstractClass) object).eContainer() instanceof InvocationContract) {
        InvocationContract contract = (InvocationContract) ((TypeAbstractClass) object).eContainer();
        if (contract.getInvokedContract() == null || contract.getInvokedContract().getType() == null || contract.getInvokedContract().getType().getType() == null) {
          return false;
        }
      }
      // TypeAbstractContract bound to a Contract
      return (((TypeAbstractClass) object)).getType() != null;
    }
    return false;
  }

  @Override
  protected Class<Object> getType(Object object) {
    // TypeAbstractClass bound to an InvocationContract
    if (((TypeAbstractClass) object).eContainer() instanceof InvocationContract) {
      return ((InvocationContract) ((TypeAbstractClass) object).eContainer()).getType().getType();
    }
    // TypeAbstractContract bound to a Contract
    return (((TypeAbstractClass) object)).getType();
  }

  @Override
  protected String getValue(Object object) {
    return ((TypeAbstractClass) object).getValue();
  }

}
