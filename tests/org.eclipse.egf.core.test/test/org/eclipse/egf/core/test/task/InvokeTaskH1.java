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
package org.eclipse.egf.core.test.task;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.manager.IProductionPlanManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.osgi.util.NLS;

public class InvokeTaskH1 extends TestCase {

  public static Test suite() {
    return new TestSuite(InvokeTaskH1.class);
  }

  public void testInvokeH1() throws Exception {

    ResourceSet resourceSet = new ResourceSetImpl();
    URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.task.h1/task_h1.fcore"); //$NON-NLS-1$

    // Load Resource
    Resource resource = ResourceHelper.loadResource(resourceSet, uri);
    assertNotNull(NLS.bind("Unable to load Resource ''{0}''", uri.toString()), resource); //$NON-NLS-1$

    // Fetch Activity
    EObject eObject = resource.getContents().get(0);
    assertTrue(NLS.bind("We Expected to find an ''Activity'' however we found ''{0}''", eObject.eClass().getName()), eObject instanceof Activity); //$NON-NLS-1$

    // Invoke Activity
    Activity activity = (Activity) eObject;

    IProductionContext rootContext = EGFProductionPlanPlugin.getProductionPlanContextFactory().createProductionPlanContext(activity);
    IProductionPlanManager production = EGFProductionPlanPlugin.getProductionPlanActivityFactory().createProductionPlanManager(rootContext, activity);
    try {
      try {
        production.invoke(new NullProgressMonitor());
      } catch (InvocationException ie) {
        fail(ie.getMessage());
      }
    } finally {
      rootContext.dispose();
    }

  }

}
