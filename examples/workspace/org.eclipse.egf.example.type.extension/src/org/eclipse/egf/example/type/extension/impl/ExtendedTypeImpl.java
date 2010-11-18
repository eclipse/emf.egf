/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.egf.example.type.extension.impl;

import java.util.Collection;

import org.eclipse.egf.example.type.extension.ExtendedType;
import org.eclipse.egf.example.type.extension.ExtensionPackage;

import org.eclipse.egf.model.types.Type;

import org.eclipse.egf.model.types.impl.TypeImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.example.type.extension.impl.ExtendedTypeImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendedTypeImpl extends TypeImpl implements ExtendedType {

    /**
     * The cached value of the '{@link #getTypes() <em>Types</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypes()
     * @generated
     * @ordered
     */
    protected EList<Type> types;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExtendedTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExtensionPackage.Literals.EXTENDED_TYPE;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<Type> getTypes() {

        if (types == null) {
            types = new EObjectResolvingEList<Type>(Type.class, this, ExtensionPackage.EXTENDED_TYPE__TYPES);
        }
        return types;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public <T extends Object> Class<T> getType() {
        return (Class<T>) org.eclipse.egf.example.type.extension.ExtendedType.class;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExtensionPackage.EXTENDED_TYPE__TYPES:
                return getTypes();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExtensionPackage.EXTENDED_TYPE__TYPES:
                getTypes().clear();
                getTypes().addAll((Collection<? extends Type>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ExtensionPackage.EXTENDED_TYPE__TYPES:
                getTypes().clear();
                return;
        }
        super.eUnset(featureID);
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ExtensionPackage.EXTENDED_TYPE__TYPES:
                return types != null && !types.isEmpty();
        }
        return super.eIsSet(featureID);
    }



} //ExtendedTypeImpl
