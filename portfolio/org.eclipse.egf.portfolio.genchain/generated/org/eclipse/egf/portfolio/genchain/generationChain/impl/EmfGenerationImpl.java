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

import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Emf Generation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl#isGenerateModel
 * <em>Generate Model</em>}</li>
 * <li>
 * {@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl#isGenerateEdit
 * <em>Generate Edit</em>}</li>
 * <li>
 * {@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl#isGenerateEditor
 * <em>Generate Editor</em>}</li>
 * <li>
 * {@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl#getPluginName
 * <em>Plugin Name</em>}</li>
 * <li>
 * {@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl#getBasePackage
 * <em>Base Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EmfGenerationImpl extends EcoreElementImpl implements EmfGeneration {
    /**
     * The default value of the '{@link #isGenerateModel()
     * <em>Generate Model</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isGenerateModel()
     * @generated
     * @ordered
     */
    protected static final boolean GENERATE_MODEL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isGenerateModel()
     * <em>Generate Model</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isGenerateModel()
     * @generated
     * @ordered
     */
    protected boolean generateModel = GENERATE_MODEL_EDEFAULT;

    /**
     * The default value of the '{@link #isGenerateEdit()
     * <em>Generate Edit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isGenerateEdit()
     * @generated
     * @ordered
     */
    protected static final boolean GENERATE_EDIT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isGenerateEdit() <em>Generate Edit</em>}
     * ' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isGenerateEdit()
     * @generated
     * @ordered
     */
    protected boolean generateEdit = GENERATE_EDIT_EDEFAULT;

    /**
     * The default value of the '{@link #isGenerateEditor()
     * <em>Generate Editor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isGenerateEditor()
     * @generated
     * @ordered
     */
    protected static final boolean GENERATE_EDITOR_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isGenerateEditor()
     * <em>Generate Editor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isGenerateEditor()
     * @generated
     * @ordered
     */
    protected boolean generateEditor = GENERATE_EDITOR_EDEFAULT;

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
     * The default value of the '{@link #getBasePackage() <em>Base Package</em>}
     * ' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBasePackage()
     * @generated
     * @ordered
     */
    protected static final String BASE_PACKAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBasePackage() <em>Base Package</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBasePackage()
     * @generated
     * @ordered
     */
    protected String basePackage = BASE_PACKAGE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EmfGenerationImpl() {
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
        return GenerationChainPackage.Literals.EMF_GENERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isGenerateModel() {
        return generateModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setGenerateModel(boolean newGenerateModel) {
        boolean oldGenerateModel = generateModel;
        generateModel = newGenerateModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.EMF_GENERATION__GENERATE_MODEL, oldGenerateModel, generateModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isGenerateEdit() {
        return generateEdit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setGenerateEdit(boolean newGenerateEdit) {
        boolean oldGenerateEdit = generateEdit;
        generateEdit = newGenerateEdit;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.EMF_GENERATION__GENERATE_EDIT, oldGenerateEdit, generateEdit));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isGenerateEditor() {
        return generateEditor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setGenerateEditor(boolean newGenerateEditor) {
        boolean oldGenerateEditor = generateEditor;
        generateEditor = newGenerateEditor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.EMF_GENERATION__GENERATE_EDITOR, oldGenerateEditor, generateEditor));
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
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.EMF_GENERATION__PLUGIN_NAME, oldPluginName, pluginName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getBasePackage() {
        return basePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setBasePackage(String newBasePackage) {
        String oldBasePackage = basePackage;
        basePackage = newBasePackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenerationChainPackage.EMF_GENERATION__BASE_PACKAGE, oldBasePackage, basePackage));
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
        if (isGenerateEdit())
            result.add(pluginName2 + ".edit");
        if (isGenerateEditor())
            result.add(pluginName2 + ".editor");
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
        case GenerationChainPackage.EMF_GENERATION__GENERATE_MODEL:
            return isGenerateModel();
        case GenerationChainPackage.EMF_GENERATION__GENERATE_EDIT:
            return isGenerateEdit();
        case GenerationChainPackage.EMF_GENERATION__GENERATE_EDITOR:
            return isGenerateEditor();
        case GenerationChainPackage.EMF_GENERATION__PLUGIN_NAME:
            return getPluginName();
        case GenerationChainPackage.EMF_GENERATION__BASE_PACKAGE:
            return getBasePackage();
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
        case GenerationChainPackage.EMF_GENERATION__GENERATE_MODEL:
            setGenerateModel((Boolean) newValue);
            return;
        case GenerationChainPackage.EMF_GENERATION__GENERATE_EDIT:
            setGenerateEdit((Boolean) newValue);
            return;
        case GenerationChainPackage.EMF_GENERATION__GENERATE_EDITOR:
            setGenerateEditor((Boolean) newValue);
            return;
        case GenerationChainPackage.EMF_GENERATION__PLUGIN_NAME:
            setPluginName((String) newValue);
            return;
        case GenerationChainPackage.EMF_GENERATION__BASE_PACKAGE:
            setBasePackage((String) newValue);
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
        case GenerationChainPackage.EMF_GENERATION__GENERATE_MODEL:
            setGenerateModel(GENERATE_MODEL_EDEFAULT);
            return;
        case GenerationChainPackage.EMF_GENERATION__GENERATE_EDIT:
            setGenerateEdit(GENERATE_EDIT_EDEFAULT);
            return;
        case GenerationChainPackage.EMF_GENERATION__GENERATE_EDITOR:
            setGenerateEditor(GENERATE_EDITOR_EDEFAULT);
            return;
        case GenerationChainPackage.EMF_GENERATION__PLUGIN_NAME:
            setPluginName(PLUGIN_NAME_EDEFAULT);
            return;
        case GenerationChainPackage.EMF_GENERATION__BASE_PACKAGE:
            setBasePackage(BASE_PACKAGE_EDEFAULT);
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
        case GenerationChainPackage.EMF_GENERATION__GENERATE_MODEL:
            return generateModel != GENERATE_MODEL_EDEFAULT;
        case GenerationChainPackage.EMF_GENERATION__GENERATE_EDIT:
            return generateEdit != GENERATE_EDIT_EDEFAULT;
        case GenerationChainPackage.EMF_GENERATION__GENERATE_EDITOR:
            return generateEditor != GENERATE_EDITOR_EDEFAULT;
        case GenerationChainPackage.EMF_GENERATION__PLUGIN_NAME:
            return PLUGIN_NAME_EDEFAULT == null ? pluginName != null : !PLUGIN_NAME_EDEFAULT.equals(pluginName);
        case GenerationChainPackage.EMF_GENERATION__BASE_PACKAGE:
            return BASE_PACKAGE_EDEFAULT == null ? basePackage != null : !BASE_PACKAGE_EDEFAULT.equals(basePackage);
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
        result.append(" (generateModel: ");
        result.append(generateModel);
        result.append(", generateEdit: ");
        result.append(generateEdit);
        result.append(", generateEditor: ");
        result.append(generateEditor);
        result.append(", pluginName: ");
        result.append(pluginName);
        result.append(", basePackage: ");
        result.append(basePackage);
        result.append(')');
        return result.toString();
    }

} // EmfGenerationImpl
