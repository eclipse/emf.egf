/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test.task;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.egf.core.test.task.memory.ContextTaskMemory;
import org.eclipse.egf.core.test.task.resource.ContextTaskResource;

public class ContextTask extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite("EGF Core Context Task Test Suite"); //$NON-NLS-1$
        suite.addTest(ContextTaskResource.suite());
        suite.addTest(ContextTaskMemory.suite());
        return suite;
    }

}
