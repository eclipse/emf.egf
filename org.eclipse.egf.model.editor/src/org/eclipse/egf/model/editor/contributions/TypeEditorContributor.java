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

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Thomas Guiu
 * 
 */
public class TypeEditorContributor extends AbstractTypeEditorContributor {

  @Override
  public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
    Object feature = descriptor.getFeature(object);
    if (feature.equals(TypesPackage.Literals.TYPE_ABSTRACT_CLASS__VALUE) && object instanceof TypeAbstractClass) {
      TypeAbstractClass typeAbstractClass = (TypeAbstractClass) object;
      return typeAbstractClass.getType() != null;
    }
    return false;
  }

  @Override
  protected Class<Object> getType(Object object) {
    return ((TypeAbstractClass) object).getType();
  }

  @Override
  protected String getCurrentClassname(Object object) {
    return ((TypeAbstractClass) object).getValue();
  }

}
