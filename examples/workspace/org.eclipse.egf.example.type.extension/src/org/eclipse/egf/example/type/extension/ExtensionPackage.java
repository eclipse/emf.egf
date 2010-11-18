/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.egf.example.type.extension;

import org.eclipse.egf.model.types.TypesPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.example.type.extension.ExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface ExtensionPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "extension";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/extension";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "extension";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ExtensionPackage eINSTANCE = org.eclipse.egf.example.type.extension.impl.ExtensionPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.example.type.extension.impl.ExtendedTypeImpl <em>Extended Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.example.type.extension.impl.ExtendedTypeImpl
     * @see org.eclipse.egf.example.type.extension.impl.ExtensionPackageImpl#getExtendedType()
     * @generated
     */
    int EXTENDED_TYPE = 0;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTENDED_TYPE__ID = TypesPackage.TYPE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTENDED_TYPE__DESCRIPTION = TypesPackage.TYPE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTENDED_TYPE__TYPES = TypesPackage.TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Extended Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTENDED_TYPE_FEATURE_COUNT = TypesPackage.TYPE_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.example.type.extension.ExtendedType <em>Extended Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Extended Type</em>'.
     * @see org.eclipse.egf.example.type.extension.ExtendedType
     * @generated
     */
    EClass getExtendedType();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.example.type.extension.ExtendedType#getTypes <em>Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Types</em>'.
     * @see org.eclipse.egf.example.type.extension.ExtendedType#getTypes()
     * @see #getExtendedType()
     * @generated
     */
    EReference getExtendedType_Types();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ExtensionFactory getExtensionFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.egf.example.type.extension.impl.ExtendedTypeImpl <em>Extended Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.example.type.extension.impl.ExtendedTypeImpl
         * @see org.eclipse.egf.example.type.extension.impl.ExtensionPackageImpl#getExtendedType()
         * @generated
         */
        EClass EXTENDED_TYPE = eINSTANCE.getExtendedType();

        /**
         * The meta object literal for the '<em><b>Types</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXTENDED_TYPE__TYPES = eINSTANCE.getExtendedType_Types();

    }

} //ExtensionPackage
