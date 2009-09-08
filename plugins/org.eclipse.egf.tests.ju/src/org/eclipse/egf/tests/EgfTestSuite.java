/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.tests.factory.FactoryInActionTest;
import org.eclipse.egf.tests.pattern.PatternTest;

/**
 * @author Guillaume Brocard
 */
// @RunWith(Suite.class)
// @Suite.SuiteClasses( { FactoryInActionTest.class, PatternTest.class })
public class EgfTestSuite extends TestSuite {
  // @BeforeClass
  public static void cleanWorkspace() {
    try {
      ResourcesPlugin.getWorkspace().getRoot().delete(true, true, null);
      System.out.println("Workspace cleaned..."); //$NON-NLS-1$
    } catch (CoreException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("EgfTestSuite.cleanWorkspace(..) _ "); //$NON-NLS-1$
      System.out.println(loggerMessage.toString());
      exception_p.printStackTrace();
    }
  }

  /**
   * Returns the suite. This is required to use the JUnit Launcher.
   */
  public static Test suite() {
    return new EgfTestSuite();
  }

  /**
   * Construct the test suite.
   */
  public EgfTestSuite() {
    cleanWorkspace();
    addTest(new FactoryInActionTest());
    addTest(new PatternTest());
  }
}