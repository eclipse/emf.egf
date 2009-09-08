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
package org.eclipse.egf.model.data.helper;

import java.util.List;

import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.PatternViewpoint;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;


/**
 * Provides services to load EGF model elements.
 * @author brocard
 */
public interface IFactoryComponentLoadingHelper {
  /**
   * Get a factory component for given id.<br>
   * It is either retrieved from the factory component registry or loaded.
   * @param factoryComponentId_p
   * @return a {@link FactoryComponent} instance if successfully got or null otherwise.
   */
  public FactoryComponent getFactoryComponent(String factoryComponentId_p);

  /**
   * Get a factory component for given descriptor.<br>
   * It is either retrieved from the factory component registry or loaded.
   * @param factoryComponentDescriptor_p
   * @return a {@link FactoryComponent} instance if successfully got or null otherwise.
   */
  public FactoryComponent getFactoryComponent(IFactoryComponentDescriptor factoryComponentDescriptor_p);

  /**
   * Load a contract for given parameters.
   * @param contractId_p
   * @param factoryComponentId_p factory component where the contract is defined.
   * @return a not null list of {@link ContractElement}.
   */
  public List<ContractElement> loadContract(String contractId_p, String factoryComponentId_p);

  /**
   * Load contract element reference for given id.
   * @param factoryComponentId_p factory component where the contract element reference is defined.
   * @param contractReferenceId_p
   */
  public ContractElementReference loadContractElementReference(String contractReferenceId_p, String factoryComponentId_p);

  /**
   * Load a production plan from its description.
   * @param productionPlanId_p
   * @param factoryComponentId_p factory component where the production plan is defined.
   * @return {@link ProductionPlan} instance if successfully loaded or null otherwise.
   */
  public ProductionPlan loadProductionPlan(String productionPlanId_p, String factoryComponentId_p);

  /**
   * Load a factory component invocation from its description.
   * @param factoryComponentInvocationId_p
   * @param factoryComponentId_p factory component where the factory component configuration is defined.
   * @return {@link FactoryComponentInvocation} instance if successfully loaded or null otherwise.
   */
  public FactoryComponentInvocation loadFactoryComponentInvocation(String factoryComponentInvocationId_p, String factoryComponentId_p);

  /**
   * Load a task factory from its description.
   * @param taskFactoryId_p
   * @param factoryComponentId_p factory component where the task factory is defined.
   * @return a {@link TaskFactoryHolder} instance if successfully loaded or null otherwise.
   */
  public TaskFactoryHolder loadTaskFactory(String taskFactoryId_p, String factoryComponentId_p);

  /**
   * Load a context from its description.
   * @param contextId_p
   * @param factoryComponentId_p factory component where the context is defined.
   * @return {@link Context} instance if successfully loaded or null otherwise.
   */
  public Context loadContext(String contextId_p, String factoryComponentId_p);

  /**
   * Load pattern libraries for given factory component id and pattern viewpoint.
   * @param factoryComponentId_p factory component where pattern libraries are defined.
   * @param patternViewpoint_p the pattern libraries container.
   */
  public void loadPatternLibraries(String factoryComponentId_p, PatternViewpoint patternViewpoint_p);

  /**
   * Load mappings for given factory component.
   * @param factoryComponentId_p factory component where the mappings are defined.
   * @return a not null list.
   */
  public List<MappingModel> loadMappings(String factoryComponentId_p);
}
