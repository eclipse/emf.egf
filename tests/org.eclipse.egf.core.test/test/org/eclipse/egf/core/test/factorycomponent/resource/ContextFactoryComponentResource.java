/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test.factorycomponent.resource;

import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.core.test.EGFCoreTestPlugin;
import org.eclipse.egf.core.test.WorkspaceHelper;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.FactoryComponentManagerFactory;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.osgi.util.NLS;

public class ContextFactoryComponentResource extends TestCase {

    public static Test suite() {
        return new TestSuite(ContextFactoryComponentResource.class);
    }

    @Override
    protected void setUp() throws Exception {
        WorkspaceHelper.closeWorkspaceProjects();
    }

    @Override
    protected void tearDown() throws Exception {
        WorkspaceHelper.openWorkspaceProjects();
    }

    public void testInvokeFC1() throws Exception {

        ResourceSet resourceSet = new TargetPlatformResourceSet();
        URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.fcs/egf/fc1.fcore"); //$NON-NLS-1$

        // Load Resource
        Resource resource = resourceSet.getResource(uri, true);
        assertNotNull(NLS.bind("Unable to load Resource ''{0}''", uri.toString()), resource); //$NON-NLS-1$

        // Fetch Activity
        EObject eObject = resource.getContents().get(0);
        assertTrue(NLS.bind("We Expected to find a ''FactoryComponent'' however we found ''{0}''", eObject.eClass().getName()), eObject instanceof Activity); //$NON-NLS-1$

        Activity activity = (Activity) eObject;

        // Invoke Activity        
        ActivityManagerProducer<Activity> producer = EGFProducerPlugin.getActivityManagerProducer(activity);
        IActivityManager<Activity> manager = producer.createActivityManager(activity);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

    }

    public void testDefaultContractFC1() throws Exception {

        ResourceSet resourceSet = new TargetPlatformResourceSet();
        URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.fcs/egf/fc1.fcore"); //$NON-NLS-1$

        // Load Resource
        Resource resource = resourceSet.getResource(uri, true);
        assertNotNull(NLS.bind("Unable to load Resource ''{0}''", uri.toString()), resource); //$NON-NLS-1$

        // Fetch FactoryComponent
        EObject eObject = resource.getContents().get(0);
        assertTrue(NLS.bind("We Expected to find a ''FactoryComponent'' however we found ''{0}''", eObject.eClass().getName()), eObject instanceof FactoryComponent); //$NON-NLS-1$

        FactoryComponent fc = (FactoryComponent) eObject;

        // Invoke FactoryComponent        
        IActivityManager<FactoryComponent> manager = FactoryComponentManagerFactory.createProductionManager(fc);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        Float amount = manager.getProductionContext().getOutputValue("amount", Float.class); //$NON-NLS-1$

        assertEquals(new Float("110"), amount); //$NON-NLS-1$

    }

    public void testContractFC1() throws Exception {

        ResourceSet resourceSet = new TargetPlatformResourceSet();
        URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.fcs/egf/fc1.fcore"); //$NON-NLS-1$

        // Load Resource
        Resource resource = resourceSet.getResource(uri, true);
        assertNotNull(NLS.bind("Unable to load Resource ''{0}''", uri.toString()), resource); //$NON-NLS-1$

        // Fetch FactoryComponent
        EObject eObject = resource.getContents().get(0);
        assertTrue(NLS.bind("We Expected to find a ''FactoryComponent'' however we found ''{0}''", eObject.eClass().getName()), eObject instanceof FactoryComponent); //$NON-NLS-1$

        FactoryComponent fc = (FactoryComponent) eObject;

        // Set price contract
        Contract contract = fc.getContract("price"); //$NON-NLS-1$
        // One should know the effective contract type
        ((TypeFloat) contract.getType()).setValue(new Float(22.0));

        // Invoke FactoryComponent        
        IActivityManager<FactoryComponent> manager = FactoryComponentManagerFactory.createProductionManager(fc);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        Float amount = manager.getProductionContext().getOutputValue("amount", Float.class); //$NON-NLS-1$

        assertEquals(new Float("220"), amount); //$NON-NLS-1$

    }

    @SuppressWarnings("unchecked")
    public void testContractList() throws Exception {

        ResourceSet resourceSet = new TargetPlatformResourceSet();
        URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.fcs/egf/fc1.fcore"); //$NON-NLS-1$

        // Load Resource
        Resource resource = resourceSet.getResource(uri, true);
        assertNotNull(NLS.bind("Unable to load Resource ''{0}''", uri.toString()), resource); //$NON-NLS-1$

        // Fetch FactoryComponent
        EObject eObject = resource.getContents().get(0);
        assertTrue(NLS.bind("We Expected to find a ''FactoryComponent'' however we found ''{0}''", eObject.eClass().getName()), eObject instanceof FactoryComponent); //$NON-NLS-1$

        FactoryComponent fc = (FactoryComponent) eObject;

        // Invoke FactoryComponent        
        IActivityManager<FactoryComponent> manager = FactoryComponentManagerFactory.createProductionManager(fc);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        Collection<String> parameters = manager.getProductionContext().getOutputValue("parameters", Collection.class); //$NON-NLS-1$

        assertEquals(2, parameters.size());

    }

}
