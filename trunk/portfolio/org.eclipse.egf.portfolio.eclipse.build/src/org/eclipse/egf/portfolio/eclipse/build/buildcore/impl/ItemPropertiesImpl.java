/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore.impl;

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Property;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyPackage;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemPropertiesImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemPropertiesImpl#getPropertyPackages <em>Property Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ItemPropertiesImpl extends ItemImpl implements ItemProperties {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<Property> properties;



    /**
     * The cached value of the '{@link #getPropertyPackages() <em>Property Packages</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPropertyPackages()
     * @generated
     * @ordered
     */
    protected EList<PropertyPackage> propertyPackages;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemPropertiesImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildcorePackage.Literals.ITEM_PROPERTIES;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<Property> getProperties() {

        if (properties == null) {
            properties = new EObjectContainmentEList<Property>(Property.class, this, BuildcorePackage.ITEM_PROPERTIES__PROPERTIES);
        }
        return properties;
    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<PropertyPackage> getPropertyPackages() {

        if (propertyPackages == null) {
            propertyPackages = new EObjectContainmentEList.Resolving<PropertyPackage>(PropertyPackage.class, this, BuildcorePackage.ITEM_PROPERTIES__PROPERTY_PACKAGES);
        }
        return propertyPackages;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTIES:
                return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTY_PACKAGES:
                return ((InternalEList<?>)getPropertyPackages()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTIES:
                return getProperties();
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTY_PACKAGES:
                return getPropertyPackages();
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
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends Property>)newValue);
                return;
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTY_PACKAGES:
                getPropertyPackages().clear();
                getPropertyPackages().addAll((Collection<? extends PropertyPackage>)newValue);
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
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTIES:
                getProperties().clear();
                return;
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTY_PACKAGES:
                getPropertyPackages().clear();
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
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTIES:
                return properties != null && !properties.isEmpty();
            case BuildcorePackage.ITEM_PROPERTIES__PROPERTY_PACKAGES:
                return propertyPackages != null && !propertyPackages.isEmpty();
        }
        return super.eIsSet(featureID);
    }



} //ItemPropertiesImpl
