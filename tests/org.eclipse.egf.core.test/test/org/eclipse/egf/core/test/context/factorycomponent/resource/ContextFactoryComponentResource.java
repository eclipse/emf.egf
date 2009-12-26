/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test.context.factorycomponent.resource;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.activity.ActivityProducer;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.osgi.util.NLS;

public class ContextFactoryComponentResource extends TestCase {

  public static Test suite() {
    return new TestSuite(ContextFactoryComponentResource.class);
  }

  public void testInvokeFC1() throws Exception {

    ResourceSet resourceSet = new ResourceSetImpl();
    URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.fcs/fc/fc1.fcore"); //$NON-NLS-1$

    // Load Resource
    Resource resource = ResourceHelper.loadResource(resourceSet, uri);
    assertNotNull(NLS.bind("Unable to load Resource ''{0}''", uri.toString()), resource); //$NON-NLS-1$

    // Fetch FactoryComponent
    EObject eObject = resource.getContents().get(0);
    assertTrue(NLS.bind("We Expected to find an ''FactoryComponent'' however we found ''{0}''", eObject.eClass().getName()), eObject instanceof FactoryComponent); //$NON-NLS-1$

    // Invoke FactoryComponent
    FactoryComponent fc = (FactoryComponent) eObject;

    ActivityProducer producer = EGFProducerPlugin.getActivityProducer(fc);

    IModelElementProducerManager<ActivityContract> production = producer.createManager(fc);

    try {
      production.invoke(new NullProgressMonitor());
    } catch (InvocationException ie) {
      fail(ie.getMessage());
    }

  }

  public void testContractFC1() throws Exception {

    ResourceSet resourceSet = new ResourceSetImpl();
    URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.fcs/fc/fc1.fcore"); //$NON-NLS-1$

    // Load Resource
    Resource resource = ResourceHelper.loadResource(resourceSet, uri);
    assertNotNull(NLS.bind("Unable to load Resource ''{0}''", uri.toString()), resource); //$NON-NLS-1$

    // Fetch FactoryComponent
    EObject eObject = resource.getContents().get(0);
    assertTrue(NLS.bind("We Expected to find an ''FactoryComponent'' however we found ''{0}''", eObject.eClass().getName()), eObject instanceof FactoryComponent); //$NON-NLS-1$

    // Invoke FactoryComponent
    FactoryComponent fc = (FactoryComponent) eObject;

    ActivityProducer producer = EGFProducerPlugin.getActivityProducer(fc);

    IModelElementProducerManager<ActivityContract> production = producer.createManager(fc);
    try {
      production.invoke(new NullProgressMonitor());
    } catch (InvocationException ie) {
      fail(ie.getMessage());
    }

    Float amount = production.getProductionContext().getOutputValue("amount", Float.class); //$NON-NLS-1$

    assertEquals(new Float("110"), amount); //$NON-NLS-1$

  }

}
