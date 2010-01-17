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
package org.eclipse.egf.model.javapattern.impl;

import org.eclipse.egf.model.javapattern.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaPatternFactoryImpl extends EFactoryImpl implements JavaPatternFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static JavaPatternFactory init() {
        try {
            JavaPatternFactory theJavaPatternFactory = (JavaPatternFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/javapattern"); //$NON-NLS-1$ 
            if (theJavaPatternFactory != null) {
                return theJavaPatternFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new JavaPatternFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaPatternFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case JavaPatternPackage.JAVA_NATURE:
            return createJavaNature();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaNature createJavaNature() {
        JavaNatureImpl javaNature = new JavaNatureImpl();
        return javaNature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaPatternPackage getJavaPatternPackage() {
        return (JavaPatternPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static JavaPatternPackage getPackage() {
        return JavaPatternPackage.eINSTANCE;
    }

} //JavaPatternFactoryImpl
