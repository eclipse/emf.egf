/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.task.ant.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author xiaoru chen
 * 
 */
public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("EGF Ant Task Test Suite"); //$NON-NLS-1$

        suite.addTest(AntTestCase.suite());

        return suite;
    }
}