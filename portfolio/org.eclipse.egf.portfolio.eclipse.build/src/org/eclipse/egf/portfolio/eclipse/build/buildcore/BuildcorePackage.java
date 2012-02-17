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

package org.eclipse.egf.portfolio.eclipse.build.buildcore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcoreFactory
 * @model kind="package"
 * @generated
 */
public interface BuildcorePackage extends EPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "buildcore";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.1/buildcore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "buildcore";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BuildcorePackage eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getItem()
     * @generated
     */
    int ITEM = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__NAME = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__DESCRIPTION = 1;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__ENABLED = 2;

    /**
     * The number of structural features of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemPropertiesImpl <em>Item Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemPropertiesImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getItemProperties()
     * @generated
     */
    int ITEM_PROPERTIES = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_PROPERTIES__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_PROPERTIES__DESCRIPTION = ITEM__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_PROPERTIES__ENABLED = ITEM__ENABLED;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_PROPERTIES__PROPERTIES = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Item Properties</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_PROPERTIES_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.KeyValueImpl <em>Key Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.KeyValueImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getKeyValue()
     * @generated
     */
    int KEY_VALUE = 2;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_VALUE__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_VALUE__VALUE = 1;

    /**
     * The number of structural features of the '<em>Key Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_VALUE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl <em>Chain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getChain()
     * @generated
     */
    int CHAIN = 4;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl <em>Job</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getJob()
     * @generated
     */
    int JOB = 7;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl <em>Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStep()
     * @generated
     */
    int STEP = 6;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl <em>SCM</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getSCM()
     * @generated
     */
    int SCM = 9;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getProperty()
     * @generated
     */
    int PROPERTY = 3;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__KEY = KEY_VALUE__KEY;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__VALUE = KEY_VALUE__VALUE;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__TYPE = KEY_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_FEATURE_COUNT = KEY_VALUE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__NAME = ITEM_PROPERTIES__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__DESCRIPTION = ITEM_PROPERTIES__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__ENABLED = ITEM_PROPERTIES__ENABLED;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__PROPERTIES = ITEM_PROPERTIES__PROPERTIES;

    /**
     * The feature id for the '<em><b>Jobs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__JOBS = ITEM_PROPERTIES_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Chain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN_FEATURE_COUNT = ITEM_PROPERTIES_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.AbstractStepContainerImpl <em>Abstract Step Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.AbstractStepContainerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getAbstractStepContainer()
     * @generated
     */
    int ABSTRACT_STEP_CONTAINER = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STEP_CONTAINER__NAME = ITEM_PROPERTIES__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STEP_CONTAINER__DESCRIPTION = ITEM_PROPERTIES__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STEP_CONTAINER__ENABLED = ITEM_PROPERTIES__ENABLED;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STEP_CONTAINER__PROPERTIES = ITEM_PROPERTIES__PROPERTIES;

    /**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STEP_CONTAINER__STEPS = ITEM_PROPERTIES_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Abstract Step Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STEP_CONTAINER_FEATURE_COUNT = ITEM_PROPERTIES_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP__DESCRIPTION = ITEM__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP__ENABLED = ITEM__ENABLED;

    /**
     * The number of structural features of the '<em>Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_FEATURE_COUNT = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__NAME = ABSTRACT_STEP_CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__DESCRIPTION = ABSTRACT_STEP_CONTAINER__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__ENABLED = ABSTRACT_STEP_CONTAINER__ENABLED;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__PROPERTIES = ABSTRACT_STEP_CONTAINER__PROPERTIES;

    /**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__STEPS = ABSTRACT_STEP_CONTAINER__STEPS;

    /**
     * The feature id for the '<em><b>Scms</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__SCMS = ABSTRACT_STEP_CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__TRIGGERS = ABSTRACT_STEP_CONTAINER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Job</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB_FEATURE_COUNT = ABSTRACT_STEP_CONTAINER_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepContainerImpl <em>Step Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepContainerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStepContainer()
     * @generated
     */
    int STEP_CONTAINER = 8;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER__NAME = ABSTRACT_STEP_CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER__DESCRIPTION = ABSTRACT_STEP_CONTAINER__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER__ENABLED = ABSTRACT_STEP_CONTAINER__ENABLED;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER__PROPERTIES = ABSTRACT_STEP_CONTAINER__PROPERTIES;

    /**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER__STEPS = ABSTRACT_STEP_CONTAINER__STEPS;

    /**
     * The number of structural features of the '<em>Step Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER_FEATURE_COUNT = ABSTRACT_STEP_CONTAINER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>SCM</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCM_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getTrigger()
     * @generated
     */
    int TRIGGER = 10;

    /**
     * The number of structural features of the '<em>Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_FEATURE_COUNT = 0;


    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ReuseStepImpl <em>Reuse Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ReuseStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getReuseStep()
     * @generated
     */
    int REUSE_STEP = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REUSE_STEP__NAME = STEP__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REUSE_STEP__DESCRIPTION = STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REUSE_STEP__ENABLED = STEP__ENABLED;

    /**
     * The feature id for the '<em><b>Reused Step</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REUSE_STEP__REUSED_STEP = STEP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Reuse Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REUSE_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyType <em>Property Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyType
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getPropertyType()
     * @generated
     */
    int PROPERTY_TYPE = 12;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item
     * @generated
     */
    EClass getItem();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getName()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Name();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getDescription()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Description();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#isEnabled <em>Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enabled</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#isEnabled()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Enabled();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties <em>Item Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Properties</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties
     * @generated
     */
    EClass getItemProperties();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties#getProperties()
     * @see #getItemProperties()
     * @generated
     */
    EReference getItemProperties_Properties();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue <em>Key Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Key Value</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue
     * @generated
     */
    EClass getKeyValue();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue#getKey()
     * @see #getKeyValue()
     * @generated
     */
    EAttribute getKeyValue_Key();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue#getValue()
     * @see #getKeyValue()
     * @generated
     */
    EAttribute getKeyValue_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain <em>Chain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Chain</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain
     * @generated
     */
    EClass getChain();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain#getJobs <em>Jobs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Jobs</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain#getJobs()
     * @see #getChain()
     * @generated
     */
    EReference getChain_Jobs();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer <em>Abstract Step Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Step Container</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer
     * @generated
     */
    EClass getAbstractStepContainer();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer#getSteps <em>Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Steps</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer#getSteps()
     * @see #getAbstractStepContainer()
     * @generated
     */
    EReference getAbstractStepContainer_Steps();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job <em>Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Job</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job
     * @generated
     */
    EClass getJob();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getScms <em>Scms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Scms</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getScms()
     * @see #getJob()
     * @generated
     */
    EReference getJob_Scms();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getTriggers <em>Triggers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Triggers</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getTriggers()
     * @see #getJob()
     * @generated
     */
    EReference getJob_Triggers();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step <em>Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Step
     * @generated
     */
    EClass getStep();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.StepContainer <em>Step Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Step Container</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.StepContainer
     * @generated
     */
    EClass getStepContainer();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM <em>SCM</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SCM</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM
     * @generated
     */
    EClass getSCM();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Property <em>Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Property
     * @generated
     */
    EClass getProperty();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Property#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Property#getType()
     * @see #getProperty()
     * @generated
     */
    EAttribute getProperty_Type();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger
     * @generated
     */
    EClass getTrigger();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.ReuseStep <em>Reuse Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reuse Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.ReuseStep
     * @generated
     */
    EClass getReuseStep();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.ReuseStep#getReusedStep <em>Reused Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reused Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.ReuseStep#getReusedStep()
     * @see #getReuseStep()
     * @generated
     */
    EReference getReuseStep_ReusedStep();

    /**
     * Returns the meta object for enum '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyType <em>Property Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Property Type</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyType
     * @generated
     */
    EEnum getPropertyType();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BuildcoreFactory getBuildcoreFactory();

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
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl <em>Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getItem()
         * @generated
         */
        EClass ITEM = eINSTANCE.getItem();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__NAME = eINSTANCE.getItem_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__DESCRIPTION = eINSTANCE.getItem_Description();

        /**
         * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__ENABLED = eINSTANCE.getItem_Enabled();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemPropertiesImpl <em>Item Properties</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemPropertiesImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getItemProperties()
         * @generated
         */
        EClass ITEM_PROPERTIES = eINSTANCE.getItemProperties();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM_PROPERTIES__PROPERTIES = eINSTANCE.getItemProperties_Properties();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.KeyValueImpl <em>Key Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.KeyValueImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getKeyValue()
         * @generated
         */
        EClass KEY_VALUE = eINSTANCE.getKeyValue();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KEY_VALUE__KEY = eINSTANCE.getKeyValue_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl <em>Chain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getChain()
         * @generated
         */
        EClass CHAIN = eINSTANCE.getChain();

        /**
         * The meta object literal for the '<em><b>Jobs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHAIN__JOBS = eINSTANCE.getChain_Jobs();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.AbstractStepContainerImpl <em>Abstract Step Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.AbstractStepContainerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getAbstractStepContainer()
         * @generated
         */
        EClass ABSTRACT_STEP_CONTAINER = eINSTANCE.getAbstractStepContainer();

        /**
         * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_STEP_CONTAINER__STEPS = eINSTANCE.getAbstractStepContainer_Steps();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl <em>Job</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getJob()
         * @generated
         */
        EClass JOB = eINSTANCE.getJob();

        /**
         * The meta object literal for the '<em><b>Scms</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOB__SCMS = eINSTANCE.getJob_Scms();

        /**
         * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOB__TRIGGERS = eINSTANCE.getJob_Triggers();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl <em>Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStep()
         * @generated
         */
        EClass STEP = eINSTANCE.getStep();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepContainerImpl <em>Step Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepContainerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStepContainer()
         * @generated
         */
        EClass STEP_CONTAINER = eINSTANCE.getStepContainer();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl <em>SCM</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getSCM()
         * @generated
         */
        EClass SCM = eINSTANCE.getSCM();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl <em>Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getProperty()
         * @generated
         */
        EClass PROPERTY = eINSTANCE.getProperty();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY__TYPE = eINSTANCE.getProperty_Type();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl <em>Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getTrigger()
         * @generated
         */
        EClass TRIGGER = eINSTANCE.getTrigger();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ReuseStepImpl <em>Reuse Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ReuseStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getReuseStep()
         * @generated
         */
        EClass REUSE_STEP = eINSTANCE.getReuseStep();

        /**
         * The meta object literal for the '<em><b>Reused Step</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REUSE_STEP__REUSED_STEP = eINSTANCE.getReuseStep_ReusedStep();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyType <em>Property Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyType
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getPropertyType()
         * @generated
         */
        EEnum PROPERTY_TYPE = eINSTANCE.getPropertyType();

    }

} //BuildcorePackage
