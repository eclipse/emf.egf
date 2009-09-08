/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model.util;

import java.util.List;

import org.eclipse.egf.model.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model, starting with the actual class of the object and proceeding up the inheritance hierarchy until a
 * non-null result is returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.eclipse.egf.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static ModelPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ModelSwitch() {
    if (modelPackage == null) {
      modelPackage = ModelPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
    if (theEClass.eContainer() == modelPackage) {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID: {
        NamedModelElementWithId namedModelElementWithId = (NamedModelElementWithId)theEObject;
        T result = caseNamedModelElementWithId(namedModelElementWithId);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.FACTORY_COMPONENT: {
        FactoryComponent factoryComponent = (FactoryComponent)theEObject;
        T result = caseFactoryComponent(factoryComponent);
        if (result == null) result = caseNamedModelElementWithId(factoryComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.PRODUCTION_PLAN: {
        ProductionPlan productionPlan = (ProductionPlan)theEObject;
        T result = caseProductionPlan(productionPlan);
        if (result == null) result = caseAbstractFactoryComponentFactory(productionPlan);
        if (result == null) result = caseNamedModelElementWithId(productionPlan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.FACTORY_COMPONENT_INVOCATION: {
        FactoryComponentInvocation factoryComponentInvocation = (FactoryComponentInvocation)theEObject;
        T result = caseFactoryComponentInvocation(factoryComponentInvocation);
        if (result == null) result = caseAbstractFactoryComponentFactory(factoryComponentInvocation);
        if (result == null) result = caseNamedModelElementWithId(factoryComponentInvocation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.DOMAIN: {
        Domain domain = (Domain)theEObject;
        T result = caseDomain(domain);
        if (result == null) result = caseNamedModelElementWithId(domain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.SPECIFICATION: {
        Specification specification = (Specification)theEObject;
        T result = caseSpecification(specification);
        if (result == null) result = caseNamedModelElementWithId(specification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.ABSTRACT_VIEWPOINT: {
        AbstractViewpoint abstractViewpoint = (AbstractViewpoint)theEObject;
        T result = caseAbstractViewpoint(abstractViewpoint);
        if (result == null) result = caseNamedModelElementWithId(abstractViewpoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.CONTRACT: {
        Contract contract = (Contract)theEObject;
        T result = caseContract(contract);
        if (result == null) result = caseAbstractViewpoint(contract);
        if (result == null) result = caseNamedModelElementWithId(contract);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.CONTRACT_ELEMENT: {
        ContractElement contractElement = (ContractElement)theEObject;
        T result = caseContractElement(contractElement);
        if (result == null) result = caseNamedModelElementWithId(contractElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.CONTRACT_ELEMENT_REFERENCE: {
        ContractElementReference contractElementReference = (ContractElementReference)theEObject;
        T result = caseContractElementReference(contractElementReference);
        if (result == null) result = caseNamedModelElementWithId(contractElementReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.TYPE: {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = caseNamedModelElementWithId(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.PATTERN_VIEWPOINT: {
        PatternViewpoint patternViewpoint = (PatternViewpoint)theEObject;
        T result = casePatternViewpoint(patternViewpoint);
        if (result == null) result = caseAbstractViewpoint(patternViewpoint);
        if (result == null) result = caseNamedModelElementWithId(patternViewpoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.ABSTRACT_PATTERN_ELEMENT: {
        AbstractPatternElement abstractPatternElement = (AbstractPatternElement)theEObject;
        T result = caseAbstractPatternElement(abstractPatternElement);
        if (result == null) result = caseNamedModelElementWithId(abstractPatternElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.PATTERN_LIBRARY: {
        PatternLibrary patternLibrary = (PatternLibrary)theEObject;
        T result = casePatternLibrary(patternLibrary);
        if (result == null) result = caseAbstractPatternElement(patternLibrary);
        if (result == null) result = caseNamedModelElementWithId(patternLibrary);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.PATTERN_MODEL: {
        PatternModel patternModel = (PatternModel)theEObject;
        T result = casePatternModel(patternModel);
        if (result == null) result = caseAbstractPatternElement(patternModel);
        if (result == null) result = caseNamedModelElementWithId(patternModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.FACTORY: {
        Factory factory = (Factory)theEObject;
        T result = caseFactory(factory);
        if (result == null) result = caseNamedModelElementWithId(factory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY: {
        AbstractFactoryComponentFactory abstractFactoryComponentFactory = (AbstractFactoryComponentFactory)theEObject;
        T result = caseAbstractFactoryComponentFactory(abstractFactoryComponentFactory);
        if (result == null) result = caseNamedModelElementWithId(abstractFactoryComponentFactory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.CONTEXT: {
        Context context = (Context)theEObject;
        T result = caseContext(context);
        if (result == null) result = caseNamedModelElementWithId(context);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.CONTEXT_ELEMENT: {
        ContextElement contextElement = (ContextElement)theEObject;
        T result = caseContextElement(contextElement);
        if (result == null) result = caseNamedModelElementWithId(contextElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.TASK_FACTORY_HOLDER: {
        TaskFactoryHolder taskFactoryHolder = (TaskFactoryHolder)theEObject;
        T result = caseTaskFactoryHolder(taskFactoryHolder);
        if (result == null) result = caseNamedModelElementWithId(taskFactoryHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.MAPPING_VIEWPOINT: {
        MappingViewpoint mappingViewpoint = (MappingViewpoint)theEObject;
        T result = caseMappingViewpoint(mappingViewpoint);
        if (result == null) result = caseAbstractViewpoint(mappingViewpoint);
        if (result == null) result = caseNamedModelElementWithId(mappingViewpoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.MAPPING_MODEL: {
        MappingModel mappingModel = (MappingModel)theEObject;
        T result = caseMappingModel(mappingModel);
        if (result == null) result = caseNamedModelElementWithId(mappingModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Model Element With Id</em>'.
   * <!-- begin-user-doc --> This implementation returns
   * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Model Element With Id</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedModelElementWithId(NamedModelElementWithId object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory Component</em>'.
   * <!-- begin-user-doc --> This implementation returns null; returning a
   * non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFactoryComponent(FactoryComponent object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
   * <!-- begin-user-doc --> This implementation returns null; returning a
   * non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomain(Domain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecification(Specification object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Viewpoint</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Viewpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractViewpoint(AbstractViewpoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contract</em>'.
   * <!-- begin-user-doc --> This implementation returns null; returning a
   * non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContract(Contract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contract Element</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contract Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContractElement(ContractElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contract Element Reference</em>'.
   * <!-- begin-user-doc --> This implementation returns
   * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contract Element Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContractElementReference(ContractElementReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc --> This implementation returns null; returning a
   * non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Viewpoint</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Viewpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternViewpoint(PatternViewpoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern Element</em>'.
   * <!-- begin-user-doc --> This implementation returns
   * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Pattern Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractPatternElement(AbstractPatternElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Library</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Library</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternLibrary(PatternLibrary object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternModel(PatternModel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory</em>'.
   * <!-- begin-user-doc --> This implementation returns null; returning a
   * non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFactory(Factory object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Factory Component Factory</em>'.
   * <!-- begin-user-doc --> This implementation returns
   * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Factory Component Factory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractFactoryComponentFactory(AbstractFactoryComponentFactory object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Production Plan</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Production Plan</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProductionPlan(ProductionPlan object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
   * <!-- begin-user-doc --> This implementation returns null; returning a
   * non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContext(Context object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Element</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextElement(ContextElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory Component Invocation</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory Component Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFactoryComponentInvocation(FactoryComponentInvocation object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Task Factory Holder</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Task Factory Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaskFactoryHolder(TaskFactoryHolder object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Viewpoint</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Viewpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingViewpoint(MappingViewpoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Model</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingModel(MappingModel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc --> This implementation returns null; returning a
   * non-null result will terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object) {
    return null;
  }

} // ModelSwitch
