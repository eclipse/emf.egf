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
import org.eclipse.egf.model.fcore.Context;
import org.eclipse.egf.model.fcore.ContextValue;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractConnector;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractValue;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.Task;
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
   * Calls <code>caseXXX</code> for each class of the model until one returns a
   * non null result; it yields that result.
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
   * Calls <code>caseXXX</code> for each class of the model until one returns a
   * non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
    if (theEClass.eContainer() == modelPackage) {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    } else {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a
   * non null result; it yields that result.
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
    case FcorePackage.ACTIVITY: {
      Activity activity = (Activity) theEObject;
      T result = caseActivity(activity);
      if (result == null)
        result = caseModelElement(activity);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.TASK: {
      Task task = (Task) theEObject;
      T result = caseTask(task);
      if (result == null)
        result = caseActivity(task);
      if (result == null)
        result = caseModelElement(task);
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
        result = caseModelElement(factoryComponent);
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
    case FcorePackage.INVOCATION: {
      Invocation invocation = (Invocation) theEObject;
      T result = caseInvocation(invocation);
      if (result == null)
        result = caseModelElement(invocation);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.CONTEXT: {
      Context context = (Context) theEObject;
      T result = caseContext(context);
      if (result == null)
        result = caseModelElement(context);
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
    case FcorePackage.CONTRACT: {
      Contract contract = (Contract) theEObject;
      T result = caseContract(contract);
      if (result == null)
        result = caseModelElement(contract);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.CONTEXT_VALUE: {
      ContextValue contextValue = (ContextValue) theEObject;
      T result = caseContextValue(contextValue);
      if (result == null)
        result = caseModelElement(contextValue);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.CONTRACT_VALUE: {
      ContractValue contractValue = (ContractValue) theEObject;
      T result = caseContractValue(contractValue);
      if (result == null)
        result = caseContextValue(contractValue);
      if (result == null)
        result = caseModelElement(contractValue);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.CONTRACT_CONNECTOR: {
      ContractConnector contractConnector = (ContractConnector) theEObject;
      T result = caseContractConnector(contractConnector);
      if (result == null)
        result = caseModelElement(contractConnector);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelElement(ModelElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Activity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Activity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActivity(Activity object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTask(Task object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Factory Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Factory Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFactoryComponent(FactoryComponent object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Viewpoint Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Viewpoint Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewpointContainer(ViewpointContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Viewpoint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Viewpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewpoint(Viewpoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrchestration(Orchestration object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvocation(Invocation object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContext(Context object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Contract Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Contract Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContractContainer(ContractContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Contract</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContract(Contract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Context Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Context Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextValue(ContextValue object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Contract Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Contract Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContractValue(ContractValue object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>Contract Connector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>Contract Connector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContractConnector(ContractConnector object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '
   * <em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last
   * case anyway.
   * <!-- end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '
   *         <em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object) {
    return null;
  }

} // FcoreSwitch
