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

import org.eclipse.egf.model.fcore.*;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FactoryComponentContractContainer;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextConnector;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.fcore.OrchestrationContextContainer;
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
 * @see org.eclipse.egf.model.fcore.FcorePackage
 * @generated
 */
public class FcoreSwitch<T1> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FcorePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T1 doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T1 doSwitch(EClass theEClass, EObject theEObject) {
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
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T1 doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
    case FcorePackage.MODEL_ELEMENT: {
      ModelElement modelElement = (ModelElement) theEObject;
      T1 result = caseModelElement(modelElement);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ACTIVITY: {
      Activity activity = (Activity) theEObject;
      T1 result = caseActivity(activity);
      if (result == null)
        result = caseModelElement(activity);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ACTIVITY_CONTRACT: {
      ActivityContract activityContract = (ActivityContract) theEObject;
      T1 result = caseActivityContract(activityContract);
      if (result == null)
        result = caseModelElement(activityContract);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ACTIVITY_CONTRACT_CONTAINER: {
      ActivityContractContainer activityContractContainer = (ActivityContractContainer) theEObject;
      T1 result = caseActivityContractContainer(activityContractContainer);
      if (result == null)
        result = caseModelElement(activityContractContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.FACTORY_COMPONENT: {
      FactoryComponent factoryComponent = (FactoryComponent) theEObject;
      T1 result = caseFactoryComponent(factoryComponent);
      if (result == null)
        result = caseActivity(factoryComponent);
      if (result == null)
        result = caseModelElement(factoryComponent);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.FACTORY_COMPONENT_CONTRACT: {
      FactoryComponentContract factoryComponentContract = (FactoryComponentContract) theEObject;
      T1 result = caseFactoryComponentContract(factoryComponentContract);
      if (result == null)
        result = caseActivityContract(factoryComponentContract);
      if (result == null)
        result = caseModelElement(factoryComponentContract);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.FACTORY_COMPONENT_CONTRACT_CONTAINER: {
      FactoryComponentContractContainer factoryComponentContractContainer = (FactoryComponentContractContainer) theEObject;
      T1 result = caseFactoryComponentContractContainer(factoryComponentContractContainer);
      if (result == null)
        result = caseActivityContractContainer(factoryComponentContractContainer);
      if (result == null)
        result = caseModelElement(factoryComponentContractContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.VIEWPOINT_CONTAINER: {
      ViewpointContainer viewpointContainer = (ViewpointContainer) theEObject;
      T1 result = caseViewpointContainer(viewpointContainer);
      if (result == null)
        result = caseModelElement(viewpointContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.VIEWPOINT: {
      Viewpoint viewpoint = (Viewpoint) theEObject;
      T1 result = caseViewpoint(viewpoint);
      if (result == null)
        result = caseModelElement(viewpoint);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ORCHESTRATION: {
      Orchestration orchestration = (Orchestration) theEObject;
      T1 result = caseOrchestration(orchestration);
      if (result == null)
        result = caseModelElement(orchestration);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ORCHESTRATION_CONTEXT: {
      OrchestrationContext orchestrationContext = (OrchestrationContext) theEObject;
      T1 result = caseOrchestrationContext(orchestrationContext);
      if (result == null)
        result = caseModelElement(orchestrationContext);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.ORCHESTRATION_CONTEXT_CONTAINER: {
      OrchestrationContextContainer orchestrationContextContainer = (OrchestrationContextContainer) theEObject;
      T1 result = caseOrchestrationContextContainer(orchestrationContextContainer);
      if (result == null)
        result = caseModelElement(orchestrationContextContainer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.INVOCATION: {
      Invocation<?> invocation = (Invocation<?>) theEObject;
      T1 result = caseInvocation(invocation);
      if (result == null)
        result = caseModelElement(invocation);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.INVOCATION_CONTEXT: {
      InvocationContext invocationContext = (InvocationContext) theEObject;
      T1 result = caseInvocationContext(invocationContext);
      if (result == null)
        result = caseModelElement(invocationContext);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.INVOCATION_CONTEXT_CONNECTOR: {
      InvocationContextConnector invocationContextConnector = (InvocationContextConnector) theEObject;
      T1 result = caseInvocationContextConnector(invocationContextConnector);
      if (result == null)
        result = caseModelElement(invocationContextConnector);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case FcorePackage.INVOCATION_CONTEXT_CONTAINER: {
      InvocationContextContainer invocationContextContainer = (InvocationContextContainer) theEObject;
      T1 result = caseInvocationContextContainer(invocationContextContainer);
      if (result == null)
        result = caseModelElement(invocationContextContainer);
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
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseModelElement(ModelElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseActivity(Activity object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity Contract</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseActivityContract(ActivityContract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity Contract Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity Contract Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseActivityContractContainer(ActivityContractContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseFactoryComponent(FactoryComponent object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory Component Contract</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory Component Contract</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseFactoryComponentContract(FactoryComponentContract object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factory Component Contract Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factory Component Contract Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseFactoryComponentContractContainer(FactoryComponentContractContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Viewpoint Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Viewpoint Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseViewpointContainer(ViewpointContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseViewpoint(Viewpoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Orchestration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Orchestration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseOrchestration(Orchestration object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Orchestration Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Orchestration Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseOrchestrationContext(OrchestrationContext object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Orchestration Context Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Orchestration Context Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseOrchestrationContextContainer(OrchestrationContextContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public <T extends Activity> T1 caseInvocation(Invocation<T> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseInvocationContext(InvocationContext object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation Context Connector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation Context Connector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseInvocationContextConnector(InvocationContextConnector object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation Context Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation Context Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T1 caseInvocationContextContainer(InvocationContextContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last
   * case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T1 defaultCase(EObject object) {
    return null;
  }

} // FcoreSwitch
