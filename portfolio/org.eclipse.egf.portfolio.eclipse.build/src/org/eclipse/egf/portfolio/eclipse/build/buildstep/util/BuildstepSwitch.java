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

package org.eclipse.egf.portfolio.eclipse.build.buildstep.util;

import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Item;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage
 * @generated
 */
public class BuildstepSwitch<T> {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static BuildstepPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildstepSwitch() {
        if (modelPackage == null) {
            modelPackage = BuildstepPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case BuildstepPackage.RESULT_STEP: {
                ResultStep resultStep = (ResultStep)theEObject;
                T result = caseResultStep(resultStep);
                if (result == null) result = caseStep(resultStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.CLEAN_STEP: {
                CleanStep cleanStep = (CleanStep)theEObject;
                T result = caseCleanStep(cleanStep);
                if (result == null) result = caseStep(cleanStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.BUILD_STEP: {
                BuildStep buildStep = (BuildStep)theEObject;
                T result = caseBuildStep(buildStep);
                if (result == null) result = caseStep(buildStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.PUBLISH_STEP: {
                PublishStep publishStep = (PublishStep)theEObject;
                T result = casePublishStep(publishStep);
                if (result == null) result = caseResultStep(publishStep);
                if (result == null) result = caseStep(publishStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.TEST_STEP: {
                TestStep testStep = (TestStep)theEObject;
                T result = caseTestStep(testStep);
                if (result == null) result = caseStep(testStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.ANT_STEP: {
                AntStep antStep = (AntStep)theEObject;
                T result = caseAntStep(antStep);
                if (result == null) result = caseStep(antStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.JAVADOC_STEP: {
                JavadocStep javadocStep = (JavadocStep)theEObject;
                T result = caseJavadocStep(javadocStep);
                if (result == null) result = caseStep(javadocStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.EGF_SYSTEM_PROPERTY: {
                EGFSystemProperty egfSystemProperty = (EGFSystemProperty)theEObject;
                T result = caseEGFSystemProperty(egfSystemProperty);
                if (result == null) result = caseKeyValue(egfSystemProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.EGF_STEP: {
                EgfStep egfStep = (EgfStep)theEObject;
                T result = caseEgfStep(egfStep);
                if (result == null) result = caseStep(egfStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.EGF_ACTIVITY: {
                EgfActivity egfActivity = (EgfActivity)theEObject;
                T result = caseEgfActivity(egfActivity);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.AGGREGATE_STEP: {
                AggregateStep aggregateStep = (AggregateStep)theEObject;
                T result = caseAggregateStep(aggregateStep);
                if (result == null) result = caseResultStep(aggregateStep);
                if (result == null) result = caseStep(aggregateStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.INSTALL_STEP: {
                InstallStep installStep = (InstallStep)theEObject;
                T result = caseInstallStep(installStep);
                if (result == null) result = caseStep(installStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.BUILD_LOCATION: {
                BuildLocation buildLocation = (BuildLocation)theEObject;
                T result = caseBuildLocation(buildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.SOURCE_BUILD_LOCATION: {
                SourceBuildLocation sourceBuildLocation = (SourceBuildLocation)theEObject;
                T result = caseSourceBuildLocation(sourceBuildLocation);
                if (result == null) result = caseBuildLocation(sourceBuildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.BINARY_BUILD_LOCATION: {
                BinaryBuildLocation binaryBuildLocation = (BinaryBuildLocation)theEObject;
                T result = caseBinaryBuildLocation(binaryBuildLocation);
                if (result == null) result = caseBuildLocation(binaryBuildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.LOCAL_BUILD_LOCATION: {
                LocalBuildLocation localBuildLocation = (LocalBuildLocation)theEObject;
                T result = caseLocalBuildLocation(localBuildLocation);
                if (result == null) result = caseSourceBuildLocation(localBuildLocation);
                if (result == null) result = caseBuildLocation(localBuildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.TARGET_PLATFORM_BUILD_LOCATION: {
                TargetPlatformBuildLocation targetPlatformBuildLocation = (TargetPlatformBuildLocation)theEObject;
                T result = caseTargetPlatformBuildLocation(targetPlatformBuildLocation);
                if (result == null) result = caseBinaryBuildLocation(targetPlatformBuildLocation);
                if (result == null) result = caseBuildLocation(targetPlatformBuildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.UPDATE_SITE_BUILD_LOCATION: {
                UpdateSiteBuildLocation updateSiteBuildLocation = (UpdateSiteBuildLocation)theEObject;
                T result = caseUpdateSiteBuildLocation(updateSiteBuildLocation);
                if (result == null) result = caseBinaryBuildLocation(updateSiteBuildLocation);
                if (result == null) result = caseBuildLocation(updateSiteBuildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.RESULT_STEP_BUILD_LOCATION: {
                ResultStepBuildLocation resultStepBuildLocation = (ResultStepBuildLocation)theEObject;
                T result = caseResultStepBuildLocation(resultStepBuildLocation);
                if (result == null) result = caseBinaryBuildLocation(resultStepBuildLocation);
                if (result == null) result = caseBuildLocation(resultStepBuildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.INSTALL_STEP_BUILD_LOCATION: {
                InstallStepBuildLocation installStepBuildLocation = (InstallStepBuildLocation)theEObject;
                T result = caseInstallStepBuildLocation(installStepBuildLocation);
                if (result == null) result = caseBinaryBuildLocation(installStepBuildLocation);
                if (result == null) result = caseBuildLocation(installStepBuildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.RUNNING_PLATFORM_BUILD_LOCATION: {
                RunningPlatformBuildLocation runningPlatformBuildLocation = (RunningPlatformBuildLocation)theEObject;
                T result = caseRunningPlatformBuildLocation(runningPlatformBuildLocation);
                if (result == null) result = caseBinaryBuildLocation(runningPlatformBuildLocation);
                if (result == null) result = caseBuildLocation(runningPlatformBuildLocation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.COMPONENT: {
                Component component = (Component)theEObject;
                T result = caseComponent(component);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.PLUGIN: {
                Plugin plugin = (Plugin)theEObject;
                T result = casePlugin(plugin);
                if (result == null) result = caseComponent(plugin);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildstepPackage.FEATURE: {
                Feature feature = (Feature)theEObject;
                T result = caseFeature(feature);
                if (result == null) result = caseComponent(feature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Result Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Result Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResultStep(ResultStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Clean Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Clean Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCleanStep(CleanStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Build Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Build Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBuildStep(BuildStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Publish Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Publish Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePublishStep(PublishStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Test Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Test Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTestStep(TestStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ant Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ant Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAntStep(AntStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Javadoc Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Javadoc Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJavadocStep(JavadocStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EGF System Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EGF System Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEGFSystemProperty(EGFSystemProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Egf Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Egf Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEgfStep(EgfStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Egf Activity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Egf Activity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEgfActivity(EgfActivity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Aggregate Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Aggregate Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAggregateStep(AggregateStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Install Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Install Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInstallStep(InstallStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBuildLocation(BuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Source Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Source Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSourceBuildLocation(SourceBuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Binary Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Binary Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBinaryBuildLocation(BinaryBuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Local Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Local Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLocalBuildLocation(LocalBuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Target Platform Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Target Platform Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTargetPlatformBuildLocation(TargetPlatformBuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Site Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Site Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUpdateSiteBuildLocation(UpdateSiteBuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Result Step Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Result Step Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResultStepBuildLocation(ResultStepBuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Install Step Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Install Step Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInstallStepBuildLocation(InstallStepBuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Running Platform Build Location</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Running Platform Build Location</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRunningPlatformBuildLocation(RunningPlatformBuildLocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponent(Component object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Plugin</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Plugin</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePlugin(Plugin object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFeature(Feature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStep(Step object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Key Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Key Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKeyValue(KeyValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} //BuildstepSwitch
