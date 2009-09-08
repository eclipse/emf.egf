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
package org.eclipse.egf.tests.pattern;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.data.helper.ModelHelper;

/**
 * @author Guillaume Brocard
 */
public class PatternTest extends TestCase {
  /**
   * Constructor.
   */
  public PatternTest() {
    super("testPattern"); //$NON-NLS-1$
  }

  //  @Test
  public void testPattern() {
    String contributorId = "org.eclipse.egf.tests.pattern"; //$NON-NLS-1$
    String pluginId = contributorId + ".running.host"; //$NON-NLS-1$
    // Check project existence.
    Assert.assertFalse(ProjectHelper.getProject(pluginId).exists());
    // Create a new dynamic factory component that invokes the existing test FC.
    FactoryComponent dynamicTestFc = ModelHelper.createEmptyMinimalFC(PatternTest.class.getName());
    // Id factoryComponent.1233238712534.8 refers to org.eclipse.egf.tests.pattern FC.
    String referencedFcId = "factoryComponent.1233238712534.8"; //$NON-NLS-1$
    FactoryComponentInvocation factoryComponentInvocation = ModelHelper.addFactoryComponentInvocation(dynamicTestFc, referencedFcId);
    // Add a default context.
    Context context = ModelFactory.eINSTANCE.createContext();
    factoryComponentInvocation.setContext(context);
    // Add context values.
    // Id contractElement.1233764647125.8 refers to filePath contract element.
    String filePath = "testResult.txt"; //$NON-NLS-1$
    ModelHelper.addReferencingContractContextElement(context, referencedFcId, "contractElement.1233764647125.8", filePath, contributorId); //$NON-NLS-1$
    // Id contractElement.1233764721009.9 refers to pluginId contract element.
    ModelHelper.addReferencingContractContextElement(context, referencedFcId, "contractElement.1233764721009.9", pluginId, contributorId); //$NON-NLS-1$

    // Execute it.
    CoreActivator.getDefault().generateFactoryComponentSynchronously(dynamicTestFc);

    // Read resulting file content, and compare it with expected result (i.e the initial input).
    String resultingFileContent = FileHelper.readFile(pluginId + ICommonConstants.SLASH_CHARACTER + filePath);

    // Test condition.
    Assert.assertEquals("HelloWorld !", resultingFileContent); //$NON-NLS-1$
  }
}