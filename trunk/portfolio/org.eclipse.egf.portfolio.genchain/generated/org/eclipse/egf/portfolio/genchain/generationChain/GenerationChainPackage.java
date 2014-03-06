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
package org.eclipse.egf.portfolio.genchain.generationChain;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainFactory
 * @model kind="package"
 * @generated
 */
public interface GenerationChainPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "generationChain";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/generationChain";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "generationChain";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    GenerationChainPackage eINSTANCE = org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationElementImpl <em>Generation Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationElementImpl
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getGenerationElement()
     * @generated
     */
    int GENERATION_ELEMENT = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_ELEMENT__NAME = 0;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_ELEMENT__CONTAINER = 1;

    /**
     * The number of structural features of the '<em>Generation Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_ELEMENT_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainImpl <em>Generation Chain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainImpl
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getGenerationChain()
     * @generated
     */
    int GENERATION_CHAIN = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_CHAIN__NAME = GENERATION_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_CHAIN__CONTAINER = GENERATION_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Factory Component Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_CHAIN__FACTORY_COMPONENT_NAME = GENERATION_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_CHAIN__ELEMENTS = GENERATION_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Generation Chain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERATION_CHAIN_FEATURE_COUNT = GENERATION_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EcoreElementImpl <em>Ecore Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.EcoreElementImpl
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getEcoreElement()
     * @generated
     */
    int ECORE_ELEMENT = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ECORE_ELEMENT__NAME = GENERATION_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ECORE_ELEMENT__CONTAINER = GENERATION_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Model Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ECORE_ELEMENT__MODEL_PATH = GENERATION_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ecore Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ECORE_ELEMENT_FEATURE_COUNT = GENERATION_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl <em>Emf Generation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getEmfGeneration()
     * @generated
     */
    int EMF_GENERATION = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__NAME = ECORE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__CONTAINER = ECORE_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Model Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__MODEL_PATH = ECORE_ELEMENT__MODEL_PATH;

    /**
     * The feature id for the '<em><b>Generate Model</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__GENERATE_MODEL = ECORE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Generate Edit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__GENERATE_EDIT = ECORE_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Generate Editor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__GENERATE_EDITOR = ECORE_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Generate Test</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__GENERATE_TEST = ECORE_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Generate Javadoc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__GENERATE_JAVADOC = ECORE_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Plugin Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__PLUGIN_NAME = ECORE_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Base Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION__BASE_PACKAGE = ECORE_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Emf Generation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_GENERATION_FEATURE_COUNT = ECORE_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.DocumentationGenerationImpl <em>Documentation Generation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.DocumentationGenerationImpl
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getDocumentationGeneration()
     * @generated
     */
    int DOCUMENTATION_GENERATION = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION_GENERATION__NAME = ECORE_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION_GENERATION__CONTAINER = ECORE_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Model Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION_GENERATION__MODEL_PATH = ECORE_ELEMENT__MODEL_PATH;

    /**
     * The feature id for the '<em><b>Plugin Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION_GENERATION__PLUGIN_NAME = ECORE_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Output Directory Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION_GENERATION__OUTPUT_DIRECTORY_PATH = ECORE_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Documentation Generation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION_GENERATION_FEATURE_COUNT = ECORE_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider <em>Plugin Provider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getPluginProvider()
     * @generated
     */
    int PLUGIN_PROVIDER = 5;

    /**
     * The number of structural features of the '<em>Plugin Provider</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLUGIN_PROVIDER_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.PluginAdditionImpl <em>Plugin Addition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.PluginAdditionImpl
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getPluginAddition()
     * @generated
     */
    int PLUGIN_ADDITION = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLUGIN_ADDITION__NAME = GENERATION_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLUGIN_ADDITION__CONTAINER = GENERATION_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Additions</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLUGIN_ADDITION__ADDITIONS = GENERATION_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Plugin Addition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLUGIN_ADDITION_FEATURE_COUNT = GENERATION_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.FeatureAdditionImpl <em>Feature Addition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.FeatureAdditionImpl
     * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getFeatureAddition()
     * @generated
     */
    int FEATURE_ADDITION = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_ADDITION__NAME = GENERATION_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_ADDITION__CONTAINER = GENERATION_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Additions</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_ADDITION__ADDITIONS = GENERATION_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Feature Addition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_ADDITION_FEATURE_COUNT = GENERATION_ELEMENT_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement <em>Generation Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generation Element</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement
     * @generated
     */
    EClass getGenerationElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getName()
     * @see #getGenerationElement()
     * @generated
     */
    EAttribute getGenerationElement_Name();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Container</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement#getContainer()
     * @see #getGenerationElement()
     * @generated
     */
    EReference getGenerationElement_Container();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain <em>Generation Chain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generation Chain</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain
     * @generated
     */
    EClass getGenerationChain();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getFactoryComponentName <em>Factory Component Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Factory Component Name</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getFactoryComponentName()
     * @see #getGenerationChain()
     * @generated
     */
    EAttribute getGenerationChain_FactoryComponentName();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Elements</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain#getElements()
     * @see #getGenerationChain()
     * @generated
     */
    EReference getGenerationChain_Elements();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration <em>Emf Generation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Emf Generation</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration
     * @generated
     */
    EClass getEmfGeneration();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateModel <em>Generate Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generate Model</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateModel()
     * @see #getEmfGeneration()
     * @generated
     */
    EAttribute getEmfGeneration_GenerateModel();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateEdit <em>Generate Edit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generate Edit</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateEdit()
     * @see #getEmfGeneration()
     * @generated
     */
    EAttribute getEmfGeneration_GenerateEdit();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateEditor <em>Generate Editor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generate Editor</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateEditor()
     * @see #getEmfGeneration()
     * @generated
     */
    EAttribute getEmfGeneration_GenerateEditor();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateTest <em>Generate Test</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generate Test</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateTest()
     * @see #getEmfGeneration()
     * @generated
     */
    EAttribute getEmfGeneration_GenerateTest();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateJavadoc <em>Generate Javadoc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generate Javadoc</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#isGenerateJavadoc()
     * @see #getEmfGeneration()
     * @generated
     */
    EAttribute getEmfGeneration_GenerateJavadoc();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#getPluginName <em>Plugin Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Plugin Name</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#getPluginName()
     * @see #getEmfGeneration()
     * @generated
     */
    EAttribute getEmfGeneration_PluginName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#getBasePackage <em>Base Package</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Package</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration#getBasePackage()
     * @see #getEmfGeneration()
     * @generated
     */
    EAttribute getEmfGeneration_BasePackage();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration <em>Documentation Generation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Documentation Generation</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration
     * @generated
     */
    EClass getDocumentationGeneration();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration#getPluginName <em>Plugin Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Plugin Name</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration#getPluginName()
     * @see #getDocumentationGeneration()
     * @generated
     */
    EAttribute getDocumentationGeneration_PluginName();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration#getOutputDirectoryPath <em>Output Directory Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Output Directory Path</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration#getOutputDirectoryPath()
     * @see #getDocumentationGeneration()
     * @generated
     */
    EAttribute getDocumentationGeneration_OutputDirectoryPath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement <em>Ecore Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ecore Element</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement
     * @generated
     */
    EClass getEcoreElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement#getModelPath <em>Model Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Model Path</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement#getModelPath()
     * @see #getEcoreElement()
     * @generated
     */
    EAttribute getEcoreElement_ModelPath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider <em>Plugin Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Plugin Provider</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider
     * @generated
     */
    EClass getPluginProvider();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.generationChain.PluginAddition <em>Plugin Addition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Plugin Addition</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.PluginAddition
     * @generated
     */
    EClass getPluginAddition();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.genchain.generationChain.PluginAddition#getAdditions <em>Additions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Additions</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.PluginAddition#getAdditions()
     * @see #getPluginAddition()
     * @generated
     */
    EAttribute getPluginAddition_Additions();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.genchain.generationChain.FeatureAddition <em>Feature Addition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature Addition</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.FeatureAddition
     * @generated
     */
    EClass getFeatureAddition();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.genchain.generationChain.FeatureAddition#getAdditions <em>Additions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Additions</em>'.
     * @see org.eclipse.egf.portfolio.genchain.generationChain.FeatureAddition#getAdditions()
     * @see #getFeatureAddition()
     * @generated
     */
    EAttribute getFeatureAddition_Additions();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    GenerationChainFactory getGenerationChainFactory();

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
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationElementImpl <em>Generation Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationElementImpl
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getGenerationElement()
         * @generated
         */
        EClass GENERATION_ELEMENT = eINSTANCE.getGenerationElement();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERATION_ELEMENT__NAME = eINSTANCE.getGenerationElement_Name();

        /**
         * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GENERATION_ELEMENT__CONTAINER = eINSTANCE.getGenerationElement_Container();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainImpl <em>Generation Chain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainImpl
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getGenerationChain()
         * @generated
         */
        EClass GENERATION_CHAIN = eINSTANCE.getGenerationChain();

        /**
         * The meta object literal for the '<em><b>Factory Component Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERATION_CHAIN__FACTORY_COMPONENT_NAME = eINSTANCE.getGenerationChain_FactoryComponentName();

        /**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GENERATION_CHAIN__ELEMENTS = eINSTANCE.getGenerationChain_Elements();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl <em>Emf Generation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.EmfGenerationImpl
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getEmfGeneration()
         * @generated
         */
        EClass EMF_GENERATION = eINSTANCE.getEmfGeneration();

        /**
         * The meta object literal for the '<em><b>Generate Model</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMF_GENERATION__GENERATE_MODEL = eINSTANCE.getEmfGeneration_GenerateModel();

        /**
         * The meta object literal for the '<em><b>Generate Edit</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMF_GENERATION__GENERATE_EDIT = eINSTANCE.getEmfGeneration_GenerateEdit();

        /**
         * The meta object literal for the '<em><b>Generate Editor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMF_GENERATION__GENERATE_EDITOR = eINSTANCE.getEmfGeneration_GenerateEditor();

        /**
         * The meta object literal for the '<em><b>Generate Test</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMF_GENERATION__GENERATE_TEST = eINSTANCE.getEmfGeneration_GenerateTest();

        /**
         * The meta object literal for the '<em><b>Generate Javadoc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMF_GENERATION__GENERATE_JAVADOC = eINSTANCE.getEmfGeneration_GenerateJavadoc();

        /**
         * The meta object literal for the '<em><b>Plugin Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMF_GENERATION__PLUGIN_NAME = eINSTANCE.getEmfGeneration_PluginName();

        /**
         * The meta object literal for the '<em><b>Base Package</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMF_GENERATION__BASE_PACKAGE = eINSTANCE.getEmfGeneration_BasePackage();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.DocumentationGenerationImpl <em>Documentation Generation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.DocumentationGenerationImpl
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getDocumentationGeneration()
         * @generated
         */
        EClass DOCUMENTATION_GENERATION = eINSTANCE.getDocumentationGeneration();

        /**
         * The meta object literal for the '<em><b>Plugin Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION_GENERATION__PLUGIN_NAME = eINSTANCE.getDocumentationGeneration_PluginName();

        /**
         * The meta object literal for the '<em><b>Output Directory Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION_GENERATION__OUTPUT_DIRECTORY_PATH = eINSTANCE.getDocumentationGeneration_OutputDirectoryPath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.EcoreElementImpl <em>Ecore Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.EcoreElementImpl
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getEcoreElement()
         * @generated
         */
        EClass ECORE_ELEMENT = eINSTANCE.getEcoreElement();

        /**
         * The meta object literal for the '<em><b>Model Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ECORE_ELEMENT__MODEL_PATH = eINSTANCE.getEcoreElement_ModelPath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider <em>Plugin Provider</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.genchain.generationChain.PluginProvider
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getPluginProvider()
         * @generated
         */
        EClass PLUGIN_PROVIDER = eINSTANCE.getPluginProvider();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.PluginAdditionImpl <em>Plugin Addition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.PluginAdditionImpl
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getPluginAddition()
         * @generated
         */
        EClass PLUGIN_ADDITION = eINSTANCE.getPluginAddition();

        /**
         * The meta object literal for the '<em><b>Additions</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PLUGIN_ADDITION__ADDITIONS = eINSTANCE.getPluginAddition_Additions();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.genchain.generationChain.impl.FeatureAdditionImpl <em>Feature Addition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.FeatureAdditionImpl
         * @see org.eclipse.egf.portfolio.genchain.generationChain.impl.GenerationChainPackageImpl#getFeatureAddition()
         * @generated
         */
        EClass FEATURE_ADDITION = eINSTANCE.getFeatureAddition();

        /**
         * The meta object literal for the '<em><b>Additions</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE_ADDITION__ADDITIONS = eINSTANCE.getFeatureAddition_Additions();

    }

} //GenerationChainPackage
