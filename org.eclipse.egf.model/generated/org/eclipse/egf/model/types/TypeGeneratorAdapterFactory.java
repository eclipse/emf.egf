/**
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
 */
package org.eclipse.egf.model.types;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Generator Adapter Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.model.types.TypesPackage#getTypeGeneratorAdapterFactory()
 * @model superTypes="org.eclipse.egf.model.types.TypeAbstractClass<org.eclipse.egf.model.types.EGeneratorAdapterFactory>"
 * @generated
 */
public interface TypeGeneratorAdapterFactory extends TypeAbstractClass<GeneratorAdapterFactory> {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.class;'"
   * @generated
   */
  Class<GeneratorAdapterFactory> getType();

} // TypeGeneratorAdapterFactory
