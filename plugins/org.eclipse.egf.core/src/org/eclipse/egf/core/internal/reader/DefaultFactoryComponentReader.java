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
package org.eclipse.egf.core.internal.reader;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentInvocationConstants;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.core.extensionpoint.IContextConstants;
import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.egf.core.extensionpoint.IContractReferenceConstants;
import org.eclipse.egf.core.extensionpoint.IMappingConstants;
import org.eclipse.egf.core.extensionpoint.IProductionPlanConstants;
import org.eclipse.egf.core.extensionpoint.ITaskFactoryConstants;
import org.eclipse.egf.core.reader.descriptor.FactoryComponentInvocationDescriptor;
import org.eclipse.egf.core.reader.descriptor.FactoryComponentDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContextDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContextElementDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContractDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContractElementDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContractElementReferenceDescriptor;
import org.eclipse.egf.core.reader.descriptor.MappingDescriptor;
import org.eclipse.egf.core.reader.descriptor.ProductionPlanDescriptor;
import org.eclipse.egf.core.reader.descriptor.TaskFactoryDescriptor;
import org.eclipse.egf.core.task.ITaskFactory;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.contract.type.ITypeHolder;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;


/**
 * Default factory component reader uses the Eclipse platform registry to retrieve data.
 * @author fournier
 */
public class DefaultFactoryComponentReader implements IFactoryComponentReader {
  /**
   * Define the plug-in id value for the plug-in that defines all extension points used into this class.
   */
  public static final String PLUGIN_ID = CoreActivator.getDefault().getPluginID();

  /**
   * Read the description of given configuration element.
   * @param element_p
   * @return null if no description is read.
   */
  private String readDescription(IConfigurationElement element_p) {
    String description = null;
    IConfigurationElement[] descriptions = element_p.getChildren(ExtensionPointHelper.ELEMENT_DESCRIPTION);
    if (descriptions.length > 0) {
      // The description element must be unique (see the extension-point schemas).
      description = descriptions[0].getValue();
    }
    return description;
  }

  /**
   * See extension point : org.eclipse.egf.core.factoryComponent
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponent(java.lang.String)
   */
  public FactoryComponentDescriptor readFactoryComponent(String fcId_p) {
    return readFactoryComponent(
      ExtensionPointHelper.getConfigurationElement(
        PLUGIN_ID, 
        IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_POINT_ID,
        fcId_p
      )
    );
  }

  /**
   * Read a factory component from its related configuration element.
   * @param factoryComponentConfigurationElement_p
   * @return
   */
  public FactoryComponentDescriptor readFactoryComponent(IConfigurationElement factoryComponentConfigurationElement_p) {
    FactoryComponentDescriptor descriptor = null;
    if (null != factoryComponentConfigurationElement_p) {
      descriptor = new FactoryComponentDescriptor(this);
      descriptor.setId(ExtensionPointHelper.getId(factoryComponentConfigurationElement_p));
      // Set name
      String fcName = factoryComponentConfigurationElement_p.getAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_NAME);
      if (null != fcName) {
        descriptor.setName(fcName);
      }
      // Read the description.
      String description = readDescription(factoryComponentConfigurationElement_p);
      if (null == description) {
        // No description found.
        // Read it directly form the current element (@deprecated, but necessary to ensure compatibility)
        description = factoryComponentConfigurationElement_p.getValue();
      }
      // Set the description
      descriptor.setDescription(description);
      // Set domain path.
      String domainPath = factoryComponentConfigurationElement_p.getAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_DOMAIN);
      if (null != domainPath) {
        descriptor.setDomainPath(domainPath);
      }
      // Set the contract id (if defined)
      String contractId = factoryComponentConfigurationElement_p.getAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_CONTRACT_ID);
      if (null != contractId) {
        descriptor.setContractId(contractId);
      }
      // Set the production plan (if defined)
      String productionPlanId = factoryComponentConfigurationElement_p.getAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_PRODUCTION_PLAN_ID);
      if (null != productionPlanId) {
        descriptor.setProductionPlanId(productionPlanId);
      }
    }
    return descriptor;
  }

  /**
   * See extension point : org.eclipse.egf.core.productionPlan
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readProductionPlan(java.lang.String, java.lang.String)
   */
  public ProductionPlanDescriptor readProductionPlan(String productionPlanId_p, String fcId_p) {
    ProductionPlanDescriptor descriptor = null;
    IConfigurationElement productionPlanConfigurationElement =
                                                               ExtensionPointHelper
                                                                   .getConfigurationElement(PLUGIN_ID,
                                                                                            IProductionPlanConstants.PRODUCTION_PLAN_EXTENSION_POINT_ID,
                                                                                            productionPlanId_p);
    if (null != productionPlanConfigurationElement) {
      descriptor = new ProductionPlanDescriptor(this);
      descriptor.setId(productionPlanId_p);
      // Set the context.
      String contextId = productionPlanConfigurationElement.getAttribute(IProductionPlanConstants.PRODUCTION_PLAN_ATT_CONTEXT_ID);
      if (null != contextId) {
        descriptor.setContextId(contextId);
      }
      // Load production plan children.
      IConfigurationElement[] fcInvocationElements = productionPlanConfigurationElement.getChildren(IProductionPlanConstants.PRODUCTION_PLAN_CHILD_ASSET_CONFIGURATION);
      // Set an factory component invocation id for each retrieved configuration element.
      for (int i = 0; i < fcInvocationElements.length; i++) {
        String fcInvocationId = fcInvocationElements[i].getAttribute(ExtensionPointHelper.ATT_ID);
        descriptor.addFactoryComponentInvocationId(fcInvocationId);
      }
    }
    return descriptor;
  }

  /**
   * See extension point : org.eclipse.egf.core.factoryComponentConfiguration
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponentInvocation(java.lang.String, java.lang.String)
   */
  public FactoryComponentInvocationDescriptor readFactoryComponentInvocation(String factoryComponentInvocationId_p, String fcId_p) {
    FactoryComponentInvocationDescriptor descriptor = null;
    IConfigurationElement fcInvocationConfigurationElement =
                                                                   ExtensionPointHelper
                                                                       .getConfigurationElement(
                                                                                                PLUGIN_ID,
                                                                                                IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_EXTENSION_POINT_ID,
                                                                                                factoryComponentInvocationId_p);
    if (null != fcInvocationConfigurationElement) {
      descriptor = new FactoryComponentInvocationDescriptor(this);
      descriptor.setId(factoryComponentInvocationId_p);
      // Set factory component invocation name
      String fcInvocationName = fcInvocationConfigurationElement.getAttribute(IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_NAME);
      descriptor.setName(fcInvocationName);
      // Set referenced factory component.
      String referencedFcId = fcInvocationConfigurationElement.getAttribute(IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_FC_ID);
      if (null != referencedFcId) {
        descriptor.setReferencedFactoryComponentId(referencedFcId);
      }
      // Set the task factory, if defined
      String taskFactoryId = fcInvocationConfigurationElement.getAttribute(IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_TASK_FACTORY_ID);
      if (null != taskFactoryId) {
        descriptor.setTaskFactoryId(taskFactoryId);
      }
      // Set the context
      String contextId = fcInvocationConfigurationElement.getAttribute(IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_ATT_CONTEXT_ID);
      if (null != contextId) {
        descriptor.setContextId(contextId);
      }
    }
    return descriptor;
  }

  /**
   * See extension point : org.eclipse.egf.core.contract
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContract(java.lang.String, java.lang.String)
   */
  public ContractDescriptor readContract(String contractId_p, String fcId_p) {
    ContractDescriptor descriptor = null;
    IConfigurationElement contractConfigurationElement =
                                                         ExtensionPointHelper.getConfigurationElement(PLUGIN_ID,
                                                                                                      IContractConstants.CONTRACT_EXTENSION_POINT_ID,
                                                                                                      contractId_p);
    if (null != contractConfigurationElement) {
      descriptor = new ContractDescriptor(this);
      descriptor.setId(contractId_p);
      // Load contract element children.
      IConfigurationElement[] contractElements = contractConfigurationElement.getChildren(IContractConstants.CONTRACT_ELEMENT_CHILD);
      for (int i = 0; i < contractElements.length; i++) {
        // Load a contract element.
        ContractElementDescriptor contractElementDescriptor = readContractElement(contractElements[i]);
        // Add retrieved contract element in contract.
        if (null != contractElementDescriptor) {
          // Add it to contract.
          descriptor.addContractElementDescriptor(contractElementDescriptor);
        }
      }
    }
    return descriptor;
  }

  /**
   * Read a contract element (see extension point : org.eclipse.egf.core.contract).
   * @param configurationElement_p
   * @return
   */
  private ContractElementDescriptor readContractElement(IConfigurationElement contractElementConfigurationElement_p) {
    ContractElementDescriptor descriptor = new ContractElementDescriptor(this);
    // Set the id.
    descriptor.setId(contractElementConfigurationElement_p.getAttribute(ExtensionPointHelper.ATT_ID));
    String contractElementName = contractElementConfigurationElement_p.getAttribute(IContractConstants.CONTRACT_ELEMENT_ATT_NAME);
    // Set contract element name.
    descriptor.setContractElementName(contractElementName);
    // Load a Type instance through extension mechanism to avoid Eclipse class loader issues.
    ITypeHolder typeHolder =
                             (ITypeHolder) ExtensionPointHelper.createInstance(contractElementConfigurationElement_p,
                                                                               IContractConstants.CONTRACT_ELEMENT_ATT_TYPE);
    // Set type holder where concrete type is stored.
    descriptor.setTypeHolder(typeHolder);
    // Set concrete type name got from the type holder.
    descriptor.setTypeHolderClassName(typeHolder.getClass().getName());
    // Set the mandatory value.
    String mandatory = contractElementConfigurationElement_p.getAttribute(IContractConstants.CONTRACT_ELEMENT_ATT_MANDATORY);
    // If not defined, the contract element is mandatory.
    boolean isMandatory = (null != mandatory) ? Boolean.parseBoolean(mandatory) : true;
    descriptor.setMandatory(isMandatory);
    // Read the description.
    String description = readDescription(contractElementConfigurationElement_p);
    if (null == description) {
      // No description found.
      // Read it directly form the current element (@deprecated, but necessary to ensure compatibility)
      description = contractElementConfigurationElement_p.getValue();
    }
    // Set the description.
    descriptor.setDescription(description);
    // Get contract element references.
    IConfigurationElement[] contractReferences = contractElementConfigurationElement_p.getChildren(IFactoryComponentConstants.CONTRACT_REF_CHILD);
    for (IConfigurationElement contractRef : contractReferences) {
      // Get contract element reference id.
      String contractReferenceId = contractRef.getAttribute(IFactoryComponentConstants.ATT_CONTRACT_ELEMENT_REFERENCE_ID);
      descriptor.addContractReferenceId(contractReferenceId);
    }
    return descriptor;
  }

  /**
   * See extension point : org.eclipse.egf.core.context
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContext(java.lang.String, java.lang.String)
   */
  public ContextDescriptor readContext(String contextId_p, String fcId_p) {
    ContextDescriptor descriptor = null;
    IConfigurationElement contextConfigurationElement =
                                                        ExtensionPointHelper.getConfigurationElement(PLUGIN_ID, IContextConstants.CONTEXT_EXTENSION_POINT_ID,
                                                                                                     contextId_p);
    if (null != contextConfigurationElement) {
      descriptor = new ContextDescriptor(this);
      descriptor.setId(contextId_p);
      // Load context element children.
      IConfigurationElement[] contextElements = contextConfigurationElement.getChildren(IContextConstants.CONTEXT_CHILD);
      for (int i = 0; i < contextElements.length; i++) {
        ContextElementDescriptor contextElementDescriptor = readContextElementDescriptor(contextElements[i]);
        // Add retrieved context element descriptor in context descriptor.
        if (null != contextElementDescriptor) {
          descriptor.addContextElementDescriptor(contextElementDescriptor);
        }
      }
    }
    return descriptor;
  }

  /**
   * See extension point : org.eclipse.egf.core.context<br>
   * Read a context Element descriptor.
   * @param configurationElement_p
   * @return
   */
  private ContextElementDescriptor readContextElementDescriptor(IConfigurationElement contextElementConfigurationElement_p) {
    ContextElementDescriptor descriptor = new ContextElementDescriptor(this);
    // Set the id.
    descriptor.setId(contextElementConfigurationElement_p.getAttribute(ExtensionPointHelper.ATT_ID));
    // Set the id of the plug-in that contributes (ie define this context element) this context element configuration element.
    String pluginId = contextElementConfigurationElement_p.getContributor().getName();
    descriptor.setPluginId(pluginId);
    // Get context key : it is either a string value or a reference to a contract element.
    // Try contract element reference first.
    IConfigurationElement[] keyChild = contextElementConfigurationElement_p.getChildren(IFactoryComponentConstants.CONTRACT_REF_CHILD);
    if (keyChild.length > 0) {
      // Get contract element reference.
      String contractReferenceId = keyChild[0].getAttribute(IFactoryComponentConstants.ATT_CONTRACT_ELEMENT_REFERENCE_ID);
      descriptor.setContractReferenceId(contractReferenceId);
    } else {
      // Then try key name.
      keyChild = contextElementConfigurationElement_p.getChildren(IContextConstants.CONTEXT_ELEMENT_KEY_CHILD);
      if (keyChild.length > 0) {
        // Retrieve key name and set it as key for the context element.
        String key = keyChild[0].getAttribute(ExtensionPointHelper.ATT_NAME);
        descriptor.setKey(key);
      }
    }
    // Get readable context value.
    String readableValue = null;
    IConfigurationElement[] valueChild = contextElementConfigurationElement_p.getChildren(IContextConstants.CONTEXT_ELEMENT_VALUE_CHILD);
    if (valueChild.length > 0) {
      readableValue = valueChild[0].getAttribute(IContractConstants.CONTRACT_ELEMENT_CHILD_ATT_VALUE);
      // Get type.
      String className = valueChild[0].getAttribute(ExtensionPointHelper.ATT_CLASS);
      if (null != className) {
        Object typeHolder = ExtensionPointHelper.createInstance(valueChild[0], ExtensionPointHelper.ATT_CLASS);
        if (null != typeHolder) {
          Type type = ModelFactory.eINSTANCE.createType();
          type.setTypeHolder(typeHolder);
          type.setTypeHolderClassName(typeHolder.getClass().getName());
          descriptor.setType(type);
        }
      }
    }
    // Set readable value
    descriptor.setReadableValue(readableValue);
    return descriptor;
  }

  /**
   * See extension point : org.eclipse.egf.core.taskFactory
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readTaskFactory(java.lang.String, java.lang.String)
   */
  public TaskFactoryDescriptor readTaskFactory(String taskFactoryId_p, String fcId_p) {
    TaskFactoryDescriptor descriptor = null;
    ITaskFactory taskFactory =
                               (ITaskFactory) ExtensionPointHelper.createExecutableExtension(PLUGIN_ID, ITaskFactoryConstants.TASK_FACTORY_EXTENSION_POINT_ID,
                                                                                             taskFactoryId_p);
    if (null != taskFactory) {
      descriptor = new TaskFactoryDescriptor(this);
      // Set task factory id.
      descriptor.setId(taskFactoryId_p);
      // Set task factory implementation.
      descriptor.setTaskFactory(taskFactory);
      // Set task factory class name.
      descriptor.setTaskFactoryClass(taskFactory.getClass().getName());
    }
    return descriptor;
  }

  /**
   * See extension point : org.eclipse.egf.core.contractReferences
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContractElementReference(java.lang.String, java.lang.String)
   */
  @SuppressWarnings("deprecation")
  public ContractElementReferenceDescriptor readContractElementReference(String contractReferenceId_p, String fcId_p) {
    ContractElementReferenceDescriptor descriptor = null;
    IConfigurationElement contractReference =
                                              ExtensionPointHelper.getConfigurationElement(PLUGIN_ID,
                                                                                           IContractReferenceConstants.CONTRACT_REFERENCE_EXTENSION_POINT_ID,
                                                                                           contractReferenceId_p);
    if (null != contractReference) {
      descriptor = new ContractElementReferenceDescriptor(this);
      descriptor.setId(contractReferenceId_p);
      // Get the contract element id.
      String contractElementId = contractReference.getAttribute(IContractReferenceConstants.CONTRACT_REFERENCE_ATT_REFERENCED_CONTRACT_ELEMENT_ID);
      if (null != contractElementId) {
        descriptor.setContractElementId(contractElementId);
      } else {
        // @deprecated way to get the referenced contract element.
        // Read the contract element name to ensure compatibility with existing factory components.
        String contractElementName = contractReference.getAttribute(IContractReferenceConstants.CONTRACT_REFERENCE_ATT_REFERENCED_CONTRACT_ELEMENT_NAME);
        // Set the contract element name.
        descriptor.setContractElementName(contractElementName);
      }
      // Set the reference factory component id
      String referencedFcId = contractReference.getAttribute(IContractReferenceConstants.CONTRACT_REFERENCE_ATT_REFERENCED_FACTORY_COMPONENT_ID);
      descriptor.setReferencedFcId(referencedFcId);
    }
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readPatternLibraries(java.lang.String)
   */
  public IDescriptor readPatternLibraries(String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readMappings(java.lang.String)
   */
  public IDescriptor readMappings(String fcId_p) {
    MappingDescriptor result = new MappingDescriptor();
    // Precondition.
    if (null == fcId_p) {
      return result;
    }
    // Get the core activator instance.
    CoreActivator coreActivator = CoreActivator.getDefault();
    // Get the hosting plug-in id.
    String pluginId = coreActivator.getPluginIdForFactoryComponent(fcId_p);
    IConfigurationElement[] mappingConfigurationElements =
                                                           ExtensionPointHelper
                                                               .getConfigurationElements(PLUGIN_ID, IMappingConstants.MAPPING_EXTENSION_POINT_ID, pluginId);
    // Loop over every configuration element related to a mapping.
    for (IConfigurationElement mappingElement : mappingConfigurationElements) {
      MappingDescriptor currentMappingDescriptor = new MappingDescriptor();
      // Set the id.
      currentMappingDescriptor.setValue(ExtensionPointHelper.ATT_ID, ExtensionPointHelper.getId(mappingElement));
      // Set the name.
      currentMappingDescriptor.setValue(ExtensionPointHelper.ATT_NAME, mappingElement.getAttribute(ExtensionPointHelper.ATT_NAME));
      // Set the path.
      currentMappingDescriptor.setValue(IMappingConstants.MAPPING_ATT_PATH, mappingElement.getAttribute(IMappingConstants.MAPPING_ATT_PATH));
      // Set the source.
      currentMappingDescriptor.setValue(IMappingConstants.MAPPING_ATT_SOURCE, mappingElement.getAttribute(IMappingConstants.MAPPING_ATT_SOURCE));
      // Set the target.
      currentMappingDescriptor.setValue(IMappingConstants.MAPPING_ATT_TARGET, mappingElement.getAttribute(IMappingConstants.MAPPING_ATT_TARGET));
      // Add the created descriptor as a child of the result.
      result.addChild(currentMappingDescriptor);
    }
    return result;
  }
}