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
package org.eclipse.egf.core.test;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.domain.EGFResourceSet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import test.EGFTestCase;
import test.TestSuite;
import test.util.TestSwitch;

/**
 * @author Matthieu Helleboid
 * 
 */
public class ModelTestHelper {

    private static final String MODEL_PATH = "modelPath"; //$NON-NLS-1$

    private static final String PLATFORM_PLUGIN = "platform:/plugin/"; //$NON-NLS-1$

    private final static String TEST_EXTENSION_NAME = "org.eclipse.egf.core.test"; //$NON-NLS-1$

    public void addModelTest(junit.framework.TestSuite junitSuite) {

        IConfigurationElement[] configurationElementsFor = Platform.getExtensionRegistry().getConfigurationElementsFor(TEST_EXTENSION_NAME);
        for (IConfigurationElement iConfigurationElement : configurationElementsFor) {
            String contributorName = iConfigurationElement.getContributor().getName();
            String modelPath = iConfigurationElement.getAttribute(MODEL_PATH);
            Resource resource = getResource(contributorName, modelPath);
            EObject rootElement = resource.getContents().get(0);
            junitSuite.addTest(new JUnitSwitch().doSwitch(rootElement));
        }
    }

    public static Resource getResource(String contributorName, String modelPath) {
        URI uri = URI.createURI(PLATFORM_PLUGIN + contributorName + "/" + modelPath); //$NON-NLS-1$
        Resource resource = new EGFResourceSet().getResource(uri, true);
        return resource;
    }

    private static class JUnitSwitch extends TestSwitch<junit.framework.Test> {

        @Override
        public junit.framework.TestSuite caseTestSuite(TestSuite object) {
            junit.framework.TestSuite testSuite = new junit.framework.TestSuite(object.getName());
            for (EObject eObject : object.eContents())
                testSuite.addTest(doSwitch(eObject));

            return testSuite;
        }

        @Override
        public junit.framework.TestCase caseEGFTestCase(EGFTestCase object) {
            return new ModelTestCase(object);
        }

    }
}
