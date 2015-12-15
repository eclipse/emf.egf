/**
 * Copyright (c) 2015 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test.resourceset;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.core.test.EGFCoreTestPlugin;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Thomas Guiu
 */
public class ResourceSetTests extends TestCase {

	public static Test suite() {
		return new TestSuite(ResourceSetTests.class);
	}

	public void testRuntime() throws Exception {
		{
			ResourceSet resourceSet = new RuntimePlatformResourceSet();
			URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.task.h4/egf/task_h4.fcore#1Zvd4LdCEd6AWpPtW_wFiQ"); //$NON-NLS-1$
			Activity activity = (Activity) resourceSet.getEObject(uri, true);
			ActivityManagerProducer<Activity> producer = EGFProducerPlugin.getActivityManagerProducer(activity);
			IActivityManager<Activity> manager = producer.createActivityManager(activity);
			try {
				manager.initializeContext();
				manager.invoke(new NullProgressMonitor());
			} catch (Exception e) {
				EGFCoreTestPlugin.getDefault().logError(e);
				fail(e.getMessage());
			}
			String outputValue = manager.getProductionContext().getOutputValue("result", String.class);
			assertEquals("Hello from runtime", outputValue);
		}
		{
			ResourceSet resourceSet = new TargetPlatformResourceSet();
			URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.example.task.h4/egf/task_h4.fcore#1Zvd4LdCEd6AWpPtW_wFiQ"); //$NON-NLS-1$
			Activity activity = (Activity) resourceSet.getEObject(uri, true);
			ActivityManagerProducer<Activity> producer = EGFProducerPlugin.getActivityManagerProducer(activity);
			IActivityManager<Activity> manager = producer.createActivityManager(activity);
			try {
				manager.initializeContext();
				manager.invoke(new NullProgressMonitor());
			} catch (Exception e) {
				EGFCoreTestPlugin.getDefault().logError(e);
				fail(e.getMessage());
			}
			String outputValue = manager.getProductionContext().getOutputValue("result", String.class);
			assertEquals("Hello from workspace", outputValue);

		}
	}

}
