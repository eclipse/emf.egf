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
package org.eclipse.egf.core.test.factorycomponent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.egf.core.test.factorycomponent.memory.ContextFactoryComponentMemory;
import org.eclipse.egf.core.test.factorycomponent.resource.ContextFactoryComponentResource;

public class ContextFactoryComponent extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite("EGF Core Context FactoryComponent Test Suite"); //$NON-NLS-1$
        suite.addTest(ContextFactoryComponentMemory.suite());
        suite.addTest(ContextFactoryComponentResource.suite());
        return suite;
    }

}
