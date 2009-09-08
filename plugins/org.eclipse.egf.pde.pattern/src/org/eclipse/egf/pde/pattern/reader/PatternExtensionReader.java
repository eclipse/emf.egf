/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pde.pattern.reader;

import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentInvocationDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.IContextDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContractDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContractElementReferenceDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IProductionPlanDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.ITaskFactoryDescriptor;


/**
 * This implementation reads EGF elements (only libraries and patterns) coming from the workspace or the target platform.
 * @author Guillaume Brocard
 */
public class PatternExtensionReader implements IFactoryComponentReader {
  
  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readPatternLibraries(java.lang.String)
   */
  public IDescriptor readPatternLibraries(String fcId_p) {
    IDescriptor result = null;
    // Try loading libraries from the workspace.
    result = new WorkspacePatternExtensionReader().getPatternLibraries(fcId_p);
    // If result is null, try loading the libraries from the target platform.
    // The rule is a plug-in located in the workspace has a highest priority than the same in the target platform.
    if (result == null || result.getChildren().isEmpty()) {
      result = new PlatformPatternExtensionReader().getPatternLibraries(fcId_p);
    }
    // Returning the result, it can be null if no library is retrieved from given factory component.
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponent(java.lang.String)
   */
  public IFactoryComponentDescriptor readFactoryComponent(String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponentInvocation(java.lang.String, java.lang.String)
   */
  public IFactoryComponentInvocationDescriptor readFactoryComponentInvocation(String factoryComponentInvocation_p, String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContext(java.lang.String, java.lang.String)
   */
  public IContextDescriptor readContext(String contextId_p, String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContract(java.lang.String, java.lang.String)
   */
  public IContractDescriptor readContract(String contractId_p, String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContractElementReference(java.lang.String, java.lang.String)
   */
  public IContractElementReferenceDescriptor readContractElementReference(String contractReferenceId_p, String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readProductionPlan(java.lang.String, java.lang.String)
   */
  public IProductionPlanDescriptor readProductionPlan(String productionPlanId_p, String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readTaskFactory(java.lang.String, java.lang.String)
   */
  public ITaskFactoryDescriptor readTaskFactory(String taskFactoryId_p, String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readMappings(java.lang.String)
   */
  public IDescriptor readMappings(String fcId_p) {
    // Do nothing.
    return null;
  }
  
}