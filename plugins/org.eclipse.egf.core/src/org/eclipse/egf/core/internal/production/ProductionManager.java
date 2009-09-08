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
package org.eclipse.egf.core.internal.production;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.core.task.ITaskFactory;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.egf.model.contract.type.ITypeHolder;
import org.eclipse.egf.model.data.helper.ModelHelper;

/**
 * Provides services to generate a factory component.
 * @author fournier
 */
public class ProductionManager {
  /**
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(ProductionManager.class.getPackage().getName());

  /**
   * Generate identified factory component, reporting using given progress monitor.
   * @param factoryComponentId_p
   * @param progressMonitor_p Null if no reporting is to be done.
   * @return
   */
  public boolean generate(String factoryComponentId_p, IProgressMonitor progressMonitor_p) {
    boolean result = true;
    IProgressMonitor progressMonitor = progressMonitor_p;
    // Just make sure a monitor is being used.
    if (null == progressMonitor) {
      progressMonitor = new NullProgressMonitor();
    }
    // Construct list of tasks to execute.
    List<AbstractTask> tasksList = new ArrayList<AbstractTask>(0);
    // Production context is unknown at this time.
    // As for progress reporting, there is no easy way to assume how much time computation of tasks will take.
    // Since we'd like a linear progress monitor (in terms of number of tasks executed), this part of the generation is
    // ignored.
    generate(factoryComponentId_p, null, tasksList);
    // Do generate by executing these tasks.
    String generationMessage = Messages.ProductionManager_ProgressReporting_Title + factoryComponentId_p;
    try {
      // Convert progress monitor to sub monitor.
      SubMonitor subMonitor = SubMonitor.convert(progressMonitor_p, generationMessage, tasksList.size() * ProgressReporter.TASK_DEFAULT_TICKS_COUNT);
      // Do go for the execution of all tasks.
      // Check for cancellation each time.
      for (Iterator<AbstractTask> tasks = tasksList.iterator(); tasks.hasNext() && !progressMonitor.isCanceled();) {
        result &= tasks.next().execute(subMonitor.newChild(ProgressReporter.TASK_DEFAULT_TICKS_COUNT), ProgressReporter.TASK_DEFAULT_TICKS_COUNT);
      }
    } finally {
      // Whatever happened, always complete the progress monitor.
      progressMonitor.done();
      // Return false if cancellation happened.
      result &= !progressMonitor.isCanceled();
    }
    return result;
  }

  /**
   * Generate a factory component related to its id.
   * @param factoryComponentId_p factory component identifier
   * @param productionContext_p can be null (for instance at first call)
   * @param resultingTasks_p The list of tasks to execute so as to generate the factory component
   */
  private void generate(String factoryComponentId_p, ProductionContext productionContext_p, final List<AbstractTask> resultingTasks_p) {
    // Get the factory component from factory component registry.
    FactoryComponent fc = CoreActivator.getDefault().getFactoryComponent(factoryComponentId_p);
    // Precondition
    if (null == fc) {
      StringBuffer loggerMessage = new StringBuffer("ProductionManager.generate(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Unable to generate factory component:"); //$NON-NLS-1$
      loggerMessage.append(factoryComponentId_p);
      loggerMessage.append(", factory component not found."); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
      return;
    }
    // Create a new production context from the one given as parameter.
    ProductionContext productionContext = new ProductionContext(productionContext_p);
    // Execute its production plan.
    ProductionPlan productionPlan = ModelHelper.getProductionPlan(fc);
    Context productionPlanContext = productionPlan.getContext();
    // Initialize the production context with context elements from the production plan context.
    List<ContractElement> contractElements = null;
    Contract contract = ModelHelper.getContract(fc);
    if (null != contract) {
      contractElements = contract.getContractElements();
    } else {
      contractElements = Collections.emptyList();
    }
    feedProductionContext(productionContext, productionPlanContext, factoryComponentId_p, contractElements);
    // Execute the production plan means to execute all its contained factory component invocations.
    Iterator<FactoryComponentInvocation> fcInvocations = productionPlan.getFactoryComponentInvocations().iterator();
    // Iterate over all contained factory component invocations.
    while (fcInvocations.hasNext()) {
      FactoryComponentInvocation fcInvocation = fcInvocations.next();
      // Get factory component invocation context.
      Context fcInvocationContext = fcInvocation.getContext();
      // Create a dedicated production context to current factory component invocation.
      ProductionContext fcInvocationProductionContext = new ProductionContext(productionContext);
      // Initialize this dedicated production context with context elements from current factory component invocation context.
      feedProductionContext(fcInvocationProductionContext, fcInvocationContext, fcInvocation.getFactoryComponentId());
      // Get factory component invocation factory.
      // If defined, let's execute the task provided by the factory.
      String taskFactoryId = fcInvocation.getTaskFactoryId();
      if (null != taskFactoryId) {
        // Get the task factory holder.
        TaskFactoryHolder taskFactoryHolder = fcInvocation.getTaskFactory();
        // Get the task factory implementation
        ITaskFactory taskFactory = (ITaskFactory) taskFactoryHolder.getFactory();
        AbstractTask task = taskFactory.createTask();
        task.setFactoryComponentId(factoryComponentId_p);
        task.setProductionContext(fcInvocationProductionContext);
        resultingTasks_p.add(task);
      } else {
        // No factory component factory is defined, let's generate the referenced factory component by the current factory component invocation.
        generate(fcInvocation.getFactoryComponentId(), fcInvocationProductionContext, resultingTasks_p);
      }
    }
  }

  /**
   * Add local context values to a production context (that represents the whole execution context before (inclusive) reaching this factory component).
   * @param productionContext_p the initialized production context.
   * @param context_p the provider of context elements.
   * @param localFactoryComponentId_p The factory component id which the context is being initialized.
   */
  private void feedProductionContext(ProductionContext productionContext_p, Context context_p, String localFactoryComponentId_p) {
    // Preconditions
    if (null == productionContext_p || null == context_p) {
      return;
    }
    Iterator<ContextElement> contextElements = context_p.getContextElements().iterator();
    // Iterate over context elements.
    while (contextElements.hasNext()) {
      ContextElement contextElement = contextElements.next();
      // Get the id of the plug-in that defines this context element.
      String contextElementPluginId = contextElement.getPluginId();
      // Context value.
      Object contextValue = null;
      // Get the name as a key for the current contextElement from its contractReference.
      ContractElementReference contractElementReference = contextElement.getContractElementReference();
      // Use contract reference as a key.
      if (null != contractElementReference) {
        addContractElementReferenceValue(productionContext_p, contractElementReference, contextElement.getReadableValue(), true, contextElementPluginId);
      } else {
        // Or use a name as a key.
        // Type is then provided by the context element directly.
        ITypeHolder typeHolder = (ITypeHolder) contextElement.getContextType().getTypeHolder();
        // Set the id of the plug-in that defines the context element.
        typeHolder.setPluginId(contextElementPluginId);
        contextValue = typeHolder.getValue(contextElement.getReadableValue());
        if (null != contextValue) {
          productionContext_p.addContextElement(contextElement.getKey(), contextValue, localFactoryComponentId_p);
        } else {
          StringBuilder loggerMessage = new StringBuilder("ProductionManager.initializeProductionContext(..) _ "); //$NON-NLS-1$
          loggerMessage.append("Could not interpret ").append(contextElement.getReadableValue()); //$NON-NLS-1$
          loggerMessage.append(" using registered ").append(typeHolder.getClass().getName()).append(" !"); //$NON-NLS-1$ //$NON-NLS-2$
          __logger.error(loggerMessage.toString());
        }
      }
    }
  }

  /**
   * Add local context values to a production context (that represents the whole execution context before (inclusive) reaching this factory component).<br>
   * Also try to resolve contract elements values that are referencing other contract elements values.
   * @param productionContext_p the initialized production context.
   * @param context_p the provider of context elements.
   * @param localFactoryComponentId_p The factory component id which the context is being initialized.
   * @param contractElements_p Contract elements of current factory component (local factory component).
   */
  private void feedProductionContext(ProductionContext productionContext_p, Context productionPlanContext_p, String localFactoryComponentId_p,
      List<ContractElement> contractElements_p) {
    // First of all, fill production context with local context.
    feedProductionContext(productionContext_p, productionPlanContext_p, localFactoryComponentId_p);
    // Then try and resolve pending contract elements.
    if (contractElements_p.isEmpty()) { // Nothing to do.
      return;
    }
    // Cycle through contract elements.
    for (ContractElement contractElement : contractElements_p) {
      // Search for an already assigned value in the production context.
      Object value = productionContext_p.getContextElementValue(contractElement.getName(), localFactoryComponentId_p);
      if (null != value) {
        // If so, might need to propagate it to pointed contract elements.
        // Cycle through its references, if any.
        for (ContractElementReference contractElementReference : contractElement.getContractElementReferences()) {
          addContractElementReferenceValue(productionContext_p, contractElementReference, value, false, null);
        }
      }
    }
  }

  /**
   * Add contract element reference value for current step.
   * @param productionContext_p The production context hosting the values.
   * @param reference_p The reference that should be valued.
   * @param value_p The value of the reference. Either directly the typed one, or its readable form (String).
   * @param decodeValue_p Should value be decoded ? <code>true</code> if so (then <code>value_p</code> is to be the readable form, ie a String),
   *          <code>false</code> otherwise (then <code>value_p</code> is to be the expected typed value).
   * @param pluginId_p Plug-in id hosting allowing for decoding, if it is required. <code>null</code> if no decoding should be done (along with
   *          <code>decodeValue_p</code> set to <code>false</code>).
   */
  private void addContractElementReferenceValue(ProductionContext productionContext_p, ContractElementReference reference_p, Object value_p,
      boolean decodeValue_p, String pluginId_p) {
    DataHelper.resolveContractElement(reference_p);
    ContractElement contractElement = reference_p.getReferencedContractElement();
    // Add context value for declared (contract element) name.
    String contractElementName = contractElement.getName();
    String contractElementFcId = contractElement.getFactoryComponentId();
    Object existingValue = productionContext_p.getContextElementValue(contractElementName, contractElementFcId);
    // Precondition.
    // This reference has already been valued, do nothing here.
    if (null != existingValue) {
      return;
    }
    // Value.
    Object value = null;
    // Value should be decoded, it is assumed to be a String then.
    if (decodeValue_p) {
      // Type holder.
      ITypeHolder typeHolder = (ITypeHolder) contractElement.getContractType().getTypeHolder();
      // Set the id of the plug-in that defines the element.
      if (null != pluginId_p) {
        typeHolder.setPluginId(pluginId_p);
      }
      // Decode value.
      value = typeHolder.getValue((String) value_p);
      if (null == value) {
        StringBuffer loggerMessage = new StringBuffer("ProductionManager.addContractElementReferenceValue(..) _ "); //$NON-NLS-1$
        loggerMessage.append("ContractElement "); //$NON-NLS-1$
        loggerMessage.append(contractElementName);
        loggerMessage.append(" and Element are not compatible.").append(ICommonConstants.EOL_CHARACTER); //$NON-NLS-1$
        loggerMessage.append("ContractElement expected type holder :"); //$NON-NLS-1$
        loggerMessage.append(typeHolder.getClass().getName()).append(ICommonConstants.EOL_CHARACTER);
        loggerMessage.append("Element value :"); //$NON-NLS-1$
        loggerMessage.append(decodeValue_p);
        __logger.error(loggerMessage.toString());
      }
    } else {
      // Use provided value, directly.
      value = value_p;
    }
    // Check context value against contract element declared type.
    if (null != value) {
      productionContext_p.addContextElement(contractElementName, value, contractElementFcId);
    }
  }
}
