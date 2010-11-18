/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.egf.example.type.extension;

import org.eclipse.egf.model.types.Type;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.example.type.extension.ExtendedType#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.example.type.extension.ExtensionPackage#getExtendedType()
 * @model
 * @generated
 */
public interface ExtendedType extends Type {





    /**
     * Returns the value of the '<em><b>Types</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.model.types.Type}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Types</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Types</em>' reference list.
     * @see org.eclipse.egf.example.type.extension.ExtensionPackage#getExtendedType_Types()
     * @model
     * @generated
     */

    EList<Type> getTypes();






    /**

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true" TBounds="org.eclipse.emf.ecore.EJavaObject"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (Class<T>) org.eclipse.egf.example.type.extension.ExtendedType.class;'"
     * @generated
     */

    <T extends Object> Class<T> getType();




} // ExtendedType
