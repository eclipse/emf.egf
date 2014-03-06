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

import org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Item;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage
 * @generated
 */
public class BuildstepAdapterFactory extends AdapterFactoryImpl {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static BuildstepPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildstepAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = BuildstepPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildstepSwitch<Adapter> modelSwitch =
        new BuildstepSwitch<Adapter>() {
            @Override
            public Adapter caseResultStep(ResultStep object) {
                return createResultStepAdapter();
            }
            @Override
            public Adapter caseCleanStep(CleanStep object) {
                return createCleanStepAdapter();
            }
            @Override
            public Adapter caseBuildStep(BuildStep object) {
                return createBuildStepAdapter();
            }
            @Override
            public Adapter casePublishStep(PublishStep object) {
                return createPublishStepAdapter();
            }
            @Override
            public Adapter caseTestStep(TestStep object) {
                return createTestStepAdapter();
            }
            @Override
            public Adapter caseAntStep(AntStep object) {
                return createAntStepAdapter();
            }
            @Override
            public Adapter caseJavadocStep(JavadocStep object) {
                return createJavadocStepAdapter();
            }
            @Override
            public Adapter caseEGFSystemProperty(EGFSystemProperty object) {
                return createEGFSystemPropertyAdapter();
            }
            @Override
            public Adapter caseEgfStep(EgfStep object) {
                return createEgfStepAdapter();
            }
            @Override
            public Adapter caseEgfActivity(EgfActivity object) {
                return createEgfActivityAdapter();
            }
            @Override
            public Adapter caseAggregateStep(AggregateStep object) {
                return createAggregateStepAdapter();
            }
            @Override
            public Adapter caseInstallStep(InstallStep object) {
                return createInstallStepAdapter();
            }
            @Override
            public Adapter caseAbstractBuildLocation(AbstractBuildLocation object) {
                return createAbstractBuildLocationAdapter();
            }
            @Override
            public Adapter casePatternBuildLocation(PatternBuildLocation object) {
                return createPatternBuildLocationAdapter();
            }
            @Override
            public Adapter caseAbstractBuildLocationContainer(AbstractBuildLocationContainer object) {
                return createAbstractBuildLocationContainerAdapter();
            }
            @Override
            public Adapter caseBuildLocationContainer(BuildLocationContainer object) {
                return createBuildLocationContainerAdapter();
            }
            @Override
            public Adapter caseSourceBuildLocation(SourceBuildLocation object) {
                return createSourceBuildLocationAdapter();
            }
            @Override
            public Adapter caseBinaryBuildLocation(BinaryBuildLocation object) {
                return createBinaryBuildLocationAdapter();
            }
            @Override
            public Adapter caseLocalBuildLocation(LocalBuildLocation object) {
                return createLocalBuildLocationAdapter();
            }
            @Override
            public Adapter caseTargetPlatformBuildLocation(TargetPlatformBuildLocation object) {
                return createTargetPlatformBuildLocationAdapter();
            }
            @Override
            public Adapter caseUpdateSiteBuildLocation(UpdateSiteBuildLocation object) {
                return createUpdateSiteBuildLocationAdapter();
            }
            @Override
            public Adapter caseResultStepBuildLocation(ResultStepBuildLocation object) {
                return createResultStepBuildLocationAdapter();
            }
            @Override
            public Adapter caseInstallStepBuildLocation(InstallStepBuildLocation object) {
                return createInstallStepBuildLocationAdapter();
            }
            @Override
            public Adapter caseRunningPlatformBuildLocation(RunningPlatformBuildLocation object) {
                return createRunningPlatformBuildLocationAdapter();
            }
            @Override
            public Adapter caseComponent(Component object) {
                return createComponentAdapter();
            }
            @Override
            public Adapter casePlugin(Plugin object) {
                return createPluginAdapter();
            }
            @Override
            public Adapter caseFeature(Feature object) {
                return createFeatureAdapter();
            }
            @Override
            public Adapter caseItem(Item object) {
                return createItemAdapter();
            }
            @Override
            public Adapter caseStep(Step object) {
                return createStepAdapter();
            }
            @Override
            public Adapter caseKeyValue(KeyValue object) {
                return createKeyValueAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep <em>Result Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep
     * @generated
     */
    public Adapter createResultStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep <em>Clean Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep
     * @generated
     */
    public Adapter createCleanStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep <em>Build Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep
     * @generated
     */
    public Adapter createBuildStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep <em>Publish Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep
     * @generated
     */
    public Adapter createPublishStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep <em>Test Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep
     * @generated
     */
    public Adapter createTestStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep <em>Ant Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep
     * @generated
     */
    public Adapter createAntStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep <em>Javadoc Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep
     * @generated
     */
    public Adapter createJavadocStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EGFSystemProperty <em>EGF System Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EGFSystemProperty
     * @generated
     */
    public Adapter createEGFSystemPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep <em>Egf Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep
     * @generated
     */
    public Adapter createEgfStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity <em>Egf Activity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity
     * @generated
     */
    public Adapter createEgfActivityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep <em>Aggregate Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep
     * @generated
     */
    public Adapter createAggregateStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep <em>Install Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep
     * @generated
     */
    public Adapter createInstallStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AbstractBuildLocation <em>Abstract Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AbstractBuildLocation
     * @generated
     */
    public Adapter createAbstractBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PatternBuildLocation <em>Pattern Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.PatternBuildLocation
     * @generated
     */
    public Adapter createPatternBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.AbstractBuildLocationContainer <em>Abstract Build Location Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.AbstractBuildLocationContainer
     * @generated
     */
    public Adapter createAbstractBuildLocationContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocationContainer <em>Build Location Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocationContainer
     * @generated
     */
    public Adapter createBuildLocationContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation <em>Source Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation
     * @generated
     */
    public Adapter createSourceBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BinaryBuildLocation <em>Binary Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BinaryBuildLocation
     * @generated
     */
    public Adapter createBinaryBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation <em>Local Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation
     * @generated
     */
    public Adapter createLocalBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation <em>Target Platform Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.TargetPlatformBuildLocation
     * @generated
     */
    public Adapter createTargetPlatformBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation <em>Update Site Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation
     * @generated
     */
    public Adapter createUpdateSiteBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation <em>Result Step Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation
     * @generated
     */
    public Adapter createResultStepBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation <em>Install Step Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation
     * @generated
     */
    public Adapter createInstallStepBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation <em>Running Platform Build Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation
     * @generated
     */
    public Adapter createRunningPlatformBuildLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Component
     * @generated
     */
    public Adapter createComponentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin <em>Plugin</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin
     * @generated
     */
    public Adapter createPluginAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature <em>Feature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature
     * @generated
     */
    public Adapter createFeatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item
     * @generated
     */
    public Adapter createItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step <em>Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Step
     * @generated
     */
    public Adapter createStepAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue <em>Key Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue
     * @generated
     */
    public Adapter createKeyValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //BuildstepAdapterFactory
