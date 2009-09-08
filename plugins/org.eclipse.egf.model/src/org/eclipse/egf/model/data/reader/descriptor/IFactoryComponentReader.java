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
package org.eclipse.egf.model.data.reader.descriptor;

import org.eclipse.egf.common.descriptor.IDescriptor;

/**
 * Defines services to read EGF model elements depending on implementors.
 * @author fournier
 */
public interface IFactoryComponentReader {

  /**
   * Read a factory component description for given id.
   * @param factoryComponentId_p
   * @return an {@link IFactoryComponentDescriptor} instance or null if data are not found.
   */
  public IFactoryComponentDescriptor readFactoryComponent(String factoryComponentId_p);

  /**
   * Read a production plan description for given ids.
   * @param productionPlanId_p
   * @param factoryComponentId_p
   * @return an {@link IProductionPlanDescriptor} instance or null if data are not found.
   */
  public IProductionPlanDescriptor readProductionPlan(String productionPlanId_p, String factoryComponentId_p);

  /**
   * Read a factory component invocation description for given ids.
   * @param factoryComponentInvocation_p
   * @param factoryComponentId_p
   * @return an {@link IFactoryComponentInvocationDescriptor} instance or null if data are not found.
   */
  public IFactoryComponentInvocationDescriptor readFactoryComponentInvocation(String factoryComponentInvocation_p, String factoryComponentId_p);

  /**
   * Read a contract description for given ids.
   * @param contractId_p
   * @param factoryComponentId_p
   * @return an {@link IContractDescriptor} instance or null if data are not found.
   */
  public IContractDescriptor readContract(String contractId_p, String factoryComponentId_p);

  /**
   * Read a context description for given ids.
   * @param contextId_p
   * @param factoryComponentId_p
   * @return an {@link IContextDescriptor} instance or null if data are not found.
   */
  public IContextDescriptor readContext(String contextId_p, String factoryComponentId_p);

  /**
   * Read a contract element reference for given ids.
   * @param contractReferenceId_p
   * @param factoryComponentId_p
   * @return an {@link IContractElementReferenceDescriptor} instance or null if data are not found.
   */
  public IContractElementReferenceDescriptor readContractElementReference(String contractReferenceId_p, String factoryComponentId_p);

  /**
   * Read a task factory for given ids.
   * @param taskFactoryId_p
   * @param factoryComponentId_p
   * @return an {@link ITaskFactoryDescriptor} instance or null if data are not found.
   */
  public ITaskFactoryDescriptor readTaskFactory(String taskFactoryId_p, String factoryComponentId_p);

  /**
   * Read all pattern libraries for given factory component.
   * @param factoryComponentId_p
   * @return an {@link IDescriptor} instance or null if data are not found.
   */
  public IDescriptor readPatternLibraries(String factoryComponentId_p);

  /**
   * Read all mappings for given factory component.
   * @param factoryComponentId_p
   * @return an {@link IDescriptor} instance or null if data are not found.
   */
  public IDescriptor readMappings(String factoryComponentId_p);
}
