/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.portfolio.genchain.generationChain.impl;

import org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Documentation Generation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.egf.portfolio.genchain.generationChain.impl.DocumentationGenerationImpl#getPluginName
 * <em>Plugin Name</em>}</li>
 * <li>
 * {@link org.eclipse.egf.portfolio.genchain.generationChain.impl.DocumentationGenerationImpl#getOutputDirectoryPath
 * <em>Output Directory Path</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DocumentationGenerationImpl extends EcoreElementImpl implements DocumentationGeneration {
    /**
     * The default value of the '{@link #getPluginName() <em>Plugin Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPluginName()
     * @generated
     * @ordered
     */
    protected static final String PLUGIN_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPluginName() <em>Plugin Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPluginName()
     * @generated
     * @ordered
     */
    protected String pluginName = PLUGIN_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getOutputDirectoryPath()
     * <em>Output Directory Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOutputDirectoryPath()
     * @generated
     * @ordered
     */
    protected static final String OUTPUT_DIRECTORY_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOutputDirectoryPath()
     * <em>Output Directory Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOutputDirectoryPath()
     * @generated
     * @ordered
     */
    protected String outputDirectoryPath = OUTPUT_DIRECTORY_PATH_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DocumentationGenerationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return GenerationChainPackage.Literals.DOCUMENTATION_GENERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getPluginName() {
        return pluginName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPluginName(String newPluginName) {
        String oldPluginName = pluginName;
        pluginName = newPluginName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.DOCUMENTATION_GENERATION__PLUGIN_NAME, oldPluginName, pluginName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getOutputDirectoryPath() {
        return outputDirectoryPath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setOutputDirectoryPath(String newOutputDirectoryPath) {
        String oldOutputDirectoryPath = outputDirectoryPath;
        outputDirectoryPath = newOutputDirectoryPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.DOCUMENTATION_GENERATION__OUTPUT_DIRECTORY_PATH, oldOutputDirectoryPath, outputDirectoryPath));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<String> getPluginNames() {
        EList<String> result = new BasicEList<String>();
        final String pluginName2 = getPluginName();
        result.add(pluginName2);
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case GenerationChainPackage.DOCUMENTATION_GENERATION__PLUGIN_NAME:
            return getPluginName();
        case GenerationChainPackage.DOCUMENTATION_GENERATION__OUTPUT_DIRECTORY_PATH:
            return getOutputDirectoryPath();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case GenerationChainPackage.DOCUMENTATION_GENERATION__PLUGIN_NAME:
            setPluginName((String) newValue);
            return;
        case GenerationChainPackage.DOCUMENTATION_GENERATION__OUTPUT_DIRECTORY_PATH:
            setOutputDirectoryPath((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case GenerationChainPackage.DOCUMENTATION_GENERATION__PLUGIN_NAME:
            setPluginName(PLUGIN_NAME_EDEFAULT);
            return;
        case GenerationChainPackage.DOCUMENTATION_GENERATION__OUTPUT_DIRECTORY_PATH:
            setOutputDirectoryPath(OUTPUT_DIRECTORY_PATH_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case GenerationChainPackage.DOCUMENTATION_GENERATION__PLUGIN_NAME:
            return PLUGIN_NAME_EDEFAULT == null ? pluginName != null : !PLUGIN_NAME_EDEFAULT.equals(pluginName);
        case GenerationChainPackage.DOCUMENTATION_GENERATION__OUTPUT_DIRECTORY_PATH:
            return OUTPUT_DIRECTORY_PATH_EDEFAULT == null ? outputDirectoryPath != null : !OUTPUT_DIRECTORY_PATH_EDEFAULT.equals(outputDirectoryPath);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (pluginName: ");
        result.append(pluginName);
        result.append(", outputDirectoryPath: ");
        result.append(outputDirectoryPath);
        result.append(')');
        return result.toString();
    }

} // DocumentationGenerationImpl
