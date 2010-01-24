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
package org.eclipse.egf.model.fcore.util;

import java.util.List;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.OrchestrationParameterContainer;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.egf.model.fcore.FcorePackage
 * @generated
 */
public class FcoreSwitch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected static FcorePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public FcoreSwitch() {
    if (modelPackage == null) {
      modelPackage = FcorePackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @SuppressWarnings("all")
  protected T doSwitch(EClass theEClass, EObject theEObject) {
    if (theEClass.eContainer() == modelPackage) {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    } else {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
    case FcorePackage.MODEL_ELEMENT: {
      ModelElement modelElement = (ModelElement) theEObject;
      T result = caseModelElement(modelElement);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.NAMED_MODEL_ELEMENT: {
      NamedModelElement namedModelElement = (NamedModelElement) theEObject;
      T result = caseNamedModelElement(namedModelElement);
      if (result == null)
        result = caseModelElement(namedModelElement);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ACTIVITY: {
      Activity activity = (Activity) theEObject;
      T result = caseActivity(activity);
      if (result == null)
        result = caseNamedModelElement(activity);
      if (result == null)
        result = caseModelElement(activity);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.CONTRACT: {
      Contract contract = (Contract) theEObject;
      T result = caseContract(contract);
      if (result == null)
        result = caseNamedModelElement(contract);
      if (result == null)
        result = caseModelElement(contract);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.FACTORY_COMPONENT: {
      FactoryComponent factoryComponent = (FactoryComponent) theEObject;
      T result = caseFactoryComponent(factoryComponent);
      if (result == null)
        result = caseActivity(factoryComponent);
      if (result == null)
        result = caseNamedModelElement(factoryComponent);
      if (result == null)
        result = caseModelElement(factoryComponent);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.CONTRACT_CONTAINER: {
      ContractContainer contractContainer = (ContractContainer) theEObject;
      T result = caseContractContainer(contractContainer);
      if (result == null)
        result = caseModelElement(contractContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.FACTORY_COMPONENT_CONTRACT: {
      FactoryComponentContract factoryComponentContract = (FactoryComponentContract) theEObject;
      T result = caseFactoryComponentContract(factoryComponentContract);
      if (result == null)
        result = caseContract(factoryComponentContract);
      if (result == null)
        result = caseNamedModelElement(factoryComponentContract);
      if (result == null)
        result = caseModelElement(factoryComponentContract);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.VIEWPOINT_CONTAINER: {
      ViewpointContainer viewpointContainer = (ViewpointContainer) theEObject;
      T result = caseViewpointContainer(viewpointContainer);
      if (result == null)
        result = caseModelElement(viewpointContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.VIEWPOINT: {
      Viewpoint viewpoint = (Viewpoint) theEObject;
      T result = caseViewpoint(viewpoint);
      if (result == null)
        result = caseModelElement(viewpoint);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ORCHESTRATION: {
      Orchestration orchestration = (Orchestration) theEObject;
      T result = caseOrchestration(orchestration);
      if (result == null)
        result = caseModelElement(orchestration);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ORCHESTRATION_PARAMETER_CONTAINER: {
      OrchestrationParameterContainer orchestrationParameterContainer = (OrchestrationParameterContainer) theEObject;
      T result = caseOrchestrationParameterContainer(orchestrationParameterContainer);
      if (result == null)
        result = caseModelElement(orchestrationParameterContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ORCHESTRATION_PARAMETER: {
      OrchestrationParameter orchestrationParameter = (OrchestrationParameter) theEObject;
      T result = caseOrchestrationParameter(orchestrationParameter);
      if (result == null)
        result = caseModelElement(orchestrationParameter);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.INVOCATION: {
      Invocation invocation = (Invocation) theEObject;
      T result = caseInvocation(invocation);
      if (result == null)
        result = caseModelElement(invocation);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.INVOCATION_CONTRACT_CONTAINER: {
      InvocationContractContainer invocationContractContainer = (InvocationContractContainer) theEObject;
      T result = caseInvocationContractContainer(invocationContractContainer);
      if (result == null)
        result = caseModelElement(invocationContractContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.INVOCATION_CONTRACT: {
      InvocationContract invocationContract = (InvocationContract) theEObject;
      T result = caseInvocationContract(invocationContract);
      if (result == null)
        result = caseModelElement(invocationContract);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelElement(ModelElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedModelElement(NamedModelElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActivity(Activity object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contract</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContract(Contract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFactoryComponent(FactoryComponent object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contract Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contract Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContractContainer(ContractContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory Component Contract</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory Component Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFactoryComponentContract(FactoryComponentContract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Viewpoint Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Viewpoint Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewpointContainer(ViewpointContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewpoint(Viewpoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrchestration(Orchestration object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Orchestration Parameter Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Orchestration Parameter Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrchestrationParameterContainer(OrchestrationParameterContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Orchestration Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Orchestration Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrchestrationParameter(OrchestrationParameter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvocation(Invocation object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation Contract Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation Contract Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvocationContractContainer(InvocationContractContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation Contract</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvocationContract(InvocationContract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last
   * case anyway.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object) {
    return null;
  }

} // FcoreSwitch
