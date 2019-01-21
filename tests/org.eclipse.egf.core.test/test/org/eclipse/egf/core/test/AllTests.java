/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test;

import org.eclipse.egf.core.test.factorycomponent.ContextFactoryComponent;
import org.eclipse.egf.core.test.loader.ContextLoader;
import org.eclipse.egf.core.test.model.validation.ModelValidation;
import org.eclipse.egf.core.test.resourceset.ResourceSetTests;
import org.eclipse.egf.core.test.task.ContextTask;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Xavier Maysonnave
 * 
 */
public class AllTests {

	public static Test suite() {

		TestSuite suite = new TestSuite("EGF Core Test Suite"); //$NON-NLS-1$

		TestSuite init = new TestSuite("EGF Core Test Initialization"); //$NON-NLS-1$
		init.addTest(WorkspaceInitializationTest.suite());
		suite.addTest(init);

		new ModelTestHelper().addModelTest(suite);

		suite.addTest(ModelValidation.suite());
		suite.addTest(ContextFactoryComponent.suite());
		suite.addTest(ContextTask.suite());
		suite.addTest(ContextLoader.suite());

		suite.addTest(ResourceSetTests.suite());
		return suite;

	}

}
