/*******************************************************************************
 * Copyright (c) 2009 Thales Corporate Services S.A.S. All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html Contributors: Thales
 * Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.internal.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.data.FactoryComponentRegistry;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.core.extensionpoint.IMappingConstants;
import org.eclipse.egf.core.internal.reader.FactoryComponentReaderChain;
import org.eclipse.egf.core.reader.descriptor.FactoryComponentDescriptor;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.Factory;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.PatternViewpoint;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.ViewpointType;
import org.eclipse.egf.model.contract.type.ITypeHolder;
import org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentInvocationDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContextDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContextElementDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContractDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContractElementDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContractElementReferenceDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IProductionPlanDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.ITaskFactoryDescriptor;
import org.eclipse.egf.model.internal.data.ModelElement;

/**
 * This class provides services to load elements from extensions declared in a plug-in.
 * @author fournier
 */
public class FactoryComponentLoadingHelper implements IFactoryComponentLoadingHelper {
  /**
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(FactoryComponentLoadingHelper.class.getPackage().getName());
  /**
   * Reference to factory component registry.
   */
  private FactoryComponentRegistry _factoryComponentRegistry;

  /**
   * Constructor.
   */
  public FactoryComponentLoadingHelper() {
    // Get the factory component registry.
    _factoryComponentRegistry = FactoryComponentRegistry.getInstance();
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#getFactoryComponent(java.lang.String)
   */
  public FactoryComponent getFactoryComponent(final String factoryComponentId_p) {
    FactoryComponent factoryComponent = null;
    // Precondition.
    if (null == factoryComponentId_p) {
      return factoryComponent;
    }
    // Get the factory component from loaded factory components.
    factoryComponent = getFactoryComponentFromRegistry(factoryComponentId_p);
    // If not found, load it.
    if (null == factoryComponent) {
      factoryComponent = loadFactoryComponent(factoryComponentId_p);
      // Store it in the factory component registry.
      _factoryComponentRegistry.addFactoryComponent(factoryComponentId_p, factoryComponent);
    }
    return factoryComponent;
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#getFactoryComponent(org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor)
   */
  public FactoryComponent getFactoryComponent(final IFactoryComponentDescriptor factoryComponentDescriptor_p) {
    FactoryComponent factoryComponent = null;
    // Precondition.
    if (null == factoryComponentDescriptor_p) {
      return factoryComponent;
    }
    // Get the factory component id from the registry.
    String factoryComponentId = factoryComponentDescriptor_p.getId();
    // Get the factory component from loaded factory components.
    factoryComponent = getFactoryComponentFromRegistry(factoryComponentId);
    // If not found, load it.
    if (null == factoryComponent) {
      factoryComponent = createFactoryComponent(factoryComponentDescriptor_p);
      // Store it in the factory component registry.
      _factoryComponentRegistry.addFactoryComponent(factoryComponentId, factoryComponent);
    }
    return factoryComponent;
  }

  /**
   * Get a factory component from the factory component registry for given id.
   * @param factoryComponentId_p
   * @return
   */
  private FactoryComponent getFactoryComponentFromRegistry(String factoryComponentId_p) {
    return _factoryComponentRegistry.getFactoryComponent(factoryComponentId_p);
  }

  /**
   * Create a factory component from an {@link FactoryComponentDescriptor} instance.
   * @param fcDescriptor_p
   * @return a {@link FactoryComponent} instance if successfully created or null otherwise.
   */
  protected FactoryComponent createFactoryComponent(IFactoryComponentDescriptor fcDescriptor_p) {
    FactoryComponent factoryComponent = null;
    if (null != fcDescriptor_p) {
      factoryComponent = ModelFactory.eINSTANCE.createFactoryComponent();
      // Set the reader
      ((ModelElement) factoryComponent).setFactoryComponentReader(fcDescriptor_p.getFactoryComponentReader());
      // Set factory component id.
      String fcId = fcDescriptor_p.getId();
      factoryComponent.setId(fcId);
      // Set factory component name.
      factoryComponent.setName(fcDescriptor_p.getName());
      // Set description
      factoryComponent.setDescription(fcDescriptor_p.getDescription());
      // Set domain path.
      Domain domain = ModelFactory.eINSTANCE.createDomain();
      factoryComponent.setDomain(domain);
      String domainPath = fcDescriptor_p.getDomainPath();
      if ((null != domainPath) && (!ICommonConstants.EMPTY_STRING.equals(domainPath))) {
        domain.setPath(domainPath);
      }
      // Set the contract id (if defined)
      String contractId = fcDescriptor_p.getContractId();
      if ((null != contractId) && (!ICommonConstants.EMPTY_STRING.equals(contractId))) {
        // Add the pattern viewpoint id in viewpoint id list.
        ModelHelper.addViewpointTypeId(contractId, ViewpointType.CONTRACT, factoryComponent);
      }
      // Add a default pattern viewpoint id in viewpoint id list to force pattern libraries loading...
      ModelHelper.addViewpointTypeId(ModelFactory.eINSTANCE.createPatternViewpoint().getId(), ViewpointType.PATTERN, factoryComponent);
      // Add a default mapping viewpoint id in viewpoint id list to force mapping loading...
      ModelHelper.addViewpointTypeId(ModelFactory.eINSTANCE.createMappingViewpoint().getId(), ViewpointType.MAPPING, factoryComponent);
      // Set the production plan (if defined)
      String productionPlanId = fcDescriptor_p.getProductionPlanId();
      // Create the factory component factory.
      Factory factory = ModelFactory.eINSTANCE.createFactory();
      // Set the created factory in newly created factory component.
      factoryComponent.setFactory(factory);
      if ((null != productionPlanId) && (!ICommonConstants.EMPTY_STRING.equals(productionPlanId))) {
        // Set the production plan id.
        factory.setProductionPlanId(productionPlanId);
      } else if (!DataHelper.isBootstrapFactoryComponent(fcId)) {
        // Output an error into logs only if current factory component is not the root factory component (root factory component is only the one without a
        // production plan).
        StringBuffer loggerMessage = new StringBuffer("FactoryComponentLoadingHelper.createFactoryComponent(..) _ "); //$NON-NLS-1$
        loggerMessage.append("No production plan defined for factory component "); //$NON-NLS-1$
        loggerMessage.append(fcId);
        __logger.error(loggerMessage.toString());
      }
    }
    return factoryComponent;
  }

  /**
   * Load a factory component from its id.
   * @param factoryComponentId_p
   * @return a {@link FactoryComponent} instance if successfully loaded or null otherwise.
   */
  protected FactoryComponent loadFactoryComponent(String factoryComponentId_p) {
    // Get the factory component descriptor from the factory component reader chain.
    IFactoryComponentDescriptor descriptor = FactoryComponentReaderChain.getInstance().readFactoryComponent(factoryComponentId_p);
    return createFactoryComponent(descriptor);
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#loadContract(java.lang.String, java.lang.String)
   */
  public List<ContractElement> loadContract(String contractId_p, String factoryComponentId_p) {
    List<ContractElement> result = new ArrayList<ContractElement>(0);
    // Precondition
    if ((null == contractId_p) || (null == factoryComponentId_p)) {
      return result;
    }
    // Get the contract descriptor from the factory component reader chain.
    IContractDescriptor descriptor = FactoryComponentReaderChain.getInstance().readContract(contractId_p, factoryComponentId_p);
    if (null != descriptor) {
      // Load contract element children.
      Iterator<IContractElementDescriptor> contractElementDescriptors = descriptor.getContractElementDescriptors().iterator();
      while (contractElementDescriptors.hasNext()) {
        IContractElementDescriptor contractElementDescriptor = contractElementDescriptors.next();
        // Load a contract element.
        ContractElement contractElement = loadContractElement(contractElementDescriptor);
        // Set contract element factory component id.
        contractElement.setFactoryComponentId(factoryComponentId_p);
        // Add it to the resulting list.
        result.add(contractElement);
      }
    }
    return result;
  }

  /**
   * Load a contract element from its description.
   * @param contractElementConfigurationElement_p
   * @return a {@link ContractElement} instance if successfully loaded.
   */
  private ContractElement loadContractElement(IContractElementDescriptor contractElementDescriptor_p) {
    ContractElement contractElement = ModelFactory.eINSTANCE.createContractElement();
    // Set the id.
    contractElement.setId(contractElementDescriptor_p.getId());
    String contractElementName = contractElementDescriptor_p.getContractElementName();
    // Set contract element name.
    contractElement.setName(contractElementName);
    // Set the concrete type class name.
    ModelHelper.setContractType(contractElement, contractElementDescriptor_p.getTypeHolderClassName());
    // Set type holder where concrete type is stored.
    ITypeHolder typeHolder = contractElementDescriptor_p.getTypeHolder();
    // Could be null, if this piece of data is retrieved from a factory component located within the workspace.
    if (null != typeHolder) {
      contractElement.getContractType().setTypeHolder(typeHolder);
    }
    // Set the mandatory value.
    contractElement.setMandatory(contractElementDescriptor_p.isMandatory());
    // Set the description
    contractElement.setDescription(contractElementDescriptor_p.getDescription());
    // Get contract element references.
    contractElement.getContractReferenceIds().addAll(contractElementDescriptor_p.getContractReferenceIds());
    return contractElement;
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#loadContractElementReference(java.lang.String, java.lang.String)
   */
  @SuppressWarnings("deprecation")
  public ContractElementReference loadContractElementReference(String contractReferenceId_p, String factoryComponentId_p) {
    ContractElementReference referenceToContractElement = null;
    // Precondition
    if (null == contractReferenceId_p) {
      return referenceToContractElement;
    }
    // Get the contract element reference descriptor from the factory component reader chain.
    IContractElementReferenceDescriptor descriptor =
        FactoryComponentReaderChain.getInstance().readContractElementReference(contractReferenceId_p, factoryComponentId_p);
    if (null != descriptor) {
      // Retrieve contract element reference attribute values.
      referenceToContractElement = ModelFactory.eINSTANCE.createContractElementReference();
      // Set its id.
      referenceToContractElement.setId(contractReferenceId_p);
      // Get the referenced contract element id.
      String contractElementId = descriptor.getContractElementId();
      if ((null != contractElementId) && (!ICommonConstants.EMPTY_STRING.equals(contractElementId))) {
        referenceToContractElement.setReferencedContractElementId(contractElementId);
      } else {
        // @deprecated way to get the referenced contract element.
        // Ensure compatibility with existing factory components.
        // Set the contract element name.
        referenceToContractElement.setReferencedContractElementName(descriptor.getContractElementName());
      }
      // Set the reference factory component id.
      String referencedFcId = descriptor.getReferencedFcId();
      if ((null != referencedFcId) && (!ICommonConstants.EMPTY_STRING.equals(referencedFcId))) {
        referenceToContractElement.setReferencedFactoryComponentId(referencedFcId);
      }
    }
    return referenceToContractElement;
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#loadProductionPlan(java.lang.String, java.lang.String)
   */
  public ProductionPlan loadProductionPlan(String productionPlanId_p, String factoryComponentId_p) {
    ProductionPlan productionPlan = null;
    // Precondition
    if (null == productionPlanId_p) {
      return productionPlan;
    }
    // Get the production plan descriptor from the factory component reader chain.
    IProductionPlanDescriptor descriptor = FactoryComponentReaderChain.getInstance().readProductionPlan(productionPlanId_p, factoryComponentId_p);
    if (null != descriptor) {
      productionPlan = ModelFactory.eINSTANCE.createProductionPlan();
      // Set production plan id.
      productionPlan.setId(productionPlanId_p);
      // Set the context
      String contextId = descriptor.getContextId();
      if ((null != contextId) && (!ICommonConstants.EMPTY_STRING.equals(contextId))) {
        productionPlan.setContextId(contextId);
      }
      // Load production plan children.
      List<String> fcInvocationIds = descriptor.getFactoryComponentInvocationIds();
      productionPlan.getFactoryComponentInvocationIds().addAll(fcInvocationIds);
    } else {
      StringBuffer loggerMessage = new StringBuffer("FactoryComponentLoadingHelper.loadProductionPlan(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Production plan "); //$NON-NLS-1$
      loggerMessage.append(productionPlanId_p);
      loggerMessage.append(" is not found !"); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString());
    }
    return productionPlan;
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#loadFactoryComponentInvocation(java.lang.String, java.lang.String)
   */
  public FactoryComponentInvocation loadFactoryComponentInvocation(String factoryComponentInvocationId_p, String factoryComponentId_p) {
    FactoryComponentInvocation fcInvocation = null;
    // Precondition
    if (null == factoryComponentInvocationId_p) {
      return fcInvocation;
    }
    // Get the factory component invocation descriptor from the factory component reader chain.
    IFactoryComponentInvocationDescriptor descriptor =
        FactoryComponentReaderChain.getInstance().readFactoryComponentInvocation(factoryComponentInvocationId_p, factoryComponentId_p);
    if (null != descriptor) {
      fcInvocation = ModelFactory.eINSTANCE.createFactoryComponentInvocation();
      // Set factory component invocation id.
      fcInvocation.setId(factoryComponentInvocationId_p);
      // Set factory component invocation name.
      fcInvocation.setName(descriptor.getName());
      // Set referenced factory component.
      String referencedFcId = descriptor.getReferencedFactoryComponentId();
      if ((null != referencedFcId) && (!ICommonConstants.EMPTY_STRING.equals(referencedFcId))) {
        fcInvocation.setFactoryComponentId(referencedFcId);
      }
      // Set the task factory, if defined
      String taskFactoryId = descriptor.getTaskFactoryId();
      if ((null != taskFactoryId) && (!ICommonConstants.EMPTY_STRING.equals(taskFactoryId))) {
        fcInvocation.setTaskFactoryId(taskFactoryId);
      }
      // Set the context
      String contextId = descriptor.getContextId();
      if ((null != contextId) && (!ICommonConstants.EMPTY_STRING.equals(contextId))) {
        fcInvocation.setContextId(contextId);
      }
    }
    return fcInvocation;
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#loadTaskFactory(java.lang.String, java.lang.String)
   */
  public TaskFactoryHolder loadTaskFactory(String taskFactoryId_p, String factoryComponentId_p) {
    TaskFactoryHolder taskFactoryHolder = null;
    // Precondition
    if (null == taskFactoryId_p) {
      return taskFactoryHolder;
    }
    // Get the context descriptor from the factory component reader chain.
    ITaskFactoryDescriptor descriptor = FactoryComponentReaderChain.getInstance().readTaskFactory(taskFactoryId_p, factoryComponentId_p);
    if (null != descriptor) {
      taskFactoryHolder = ModelFactory.eINSTANCE.createTaskFactoryHolder();
      // Set task factory id.
      taskFactoryHolder.setId(taskFactoryId_p);
      // Set task factory class name
      taskFactoryHolder.setFactoryClass(descriptor.getTaskFactoryClass());
      // Set task factory implementation.
      Object taskFactory = descriptor.getTaskFactory();
      // Could be null, if this piece of data is retrieved from a factory component located within the workspace.
      if (null != taskFactory) {
        taskFactoryHolder.setFactory(taskFactory);
      }
    }
    return taskFactoryHolder;
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#loadContext(java.lang.String, java.lang.String)
   */
  public Context loadContext(String contextId_p, String factoryComponentId_p) {
    Context context = null;
    // Precondition
    if (null == contextId_p) {
      return context;
    }
    // Get the context descriptor from the factory component reader chain.
    IContextDescriptor descriptor = FactoryComponentReaderChain.getInstance().readContext(contextId_p, factoryComponentId_p);
    // Set context elements.
    if (null != descriptor) {
      context = ModelFactory.eINSTANCE.createContext();
      // Set context id.
      context.setId(contextId_p);
      // Load context element children.
      Iterator<IContextElementDescriptor> contextElementDescriptors = descriptor.getContextElementDescriptors().iterator();
      while (contextElementDescriptors.hasNext()) {
        IContextElementDescriptor contextElementDescriptor = contextElementDescriptors.next();
        ContextElement contextElement = loadContextElement(contextElementDescriptor);
        if (null != contextElement) {
          context.getContextElements().add(contextElement);
        }
      }
    }
    return context;
  }

  /**
   * Load a context element from its descriptor.
   * @param contextElementDescriptor_p
   * @return {@link ContextElement} instance if successfully loaded.
   */
  private ContextElement loadContextElement(IContextElementDescriptor contextElementDescriptor_p) {
    ContextElement contextElement = ModelFactory.eINSTANCE.createContextElement();
    // Set context element id
    String contextElementId = contextElementDescriptor_p.getId();
    contextElement.setId(contextElementId);
    // Set the id of the plug-in that defines this context element.
    contextElement.setPluginId(contextElementDescriptor_p.getPluginId());
    // Get context key : it is either a string or a reference to a contract element.
    // Try contract element reference first.
    // Get contract element reference.
    String contractRefIdOrKeyValue = contextElementDescriptor_p.getContractReferenceId();
    if (null != contractRefIdOrKeyValue) {
      contextElement.setContractReferenceId(contractRefIdOrKeyValue);
    } else {
      // Then try key name.
      contractRefIdOrKeyValue = contextElementDescriptor_p.getKey();
      if (null != contractRefIdOrKeyValue) {
        // Retrieve key name and set it as key for the context element.
        contextElement.setKey(contractRefIdOrKeyValue);
      }
    }
    // Get the readable value.
    String readableValue = contextElementDescriptor_p.getReadableValue();
    if (null == readableValue) {
      StringBuffer loggerMessage = new StringBuffer("FactoryComponentLoadingHelper.loadContextElement(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Context element readable value must be set!"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
    } else {
      contextElement.setReadableValue(readableValue);
    }
    // Get type.
    Type type = contextElementDescriptor_p.getType();
    if (null != type) {
      contextElement.setContextType(type);
    } else if (null == contextElement.getContractReferenceId()) {
      StringBuilder loggerMessage = new StringBuilder("FactoryComponentLoadingHelper.loadContextElement(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Could not instanciate type holder for ").append(contextElement.getId()).append(" !").append(ICommonConstants.EOL_CHARACTER); //$NON-NLS-1$ //$NON-NLS-2$
      loggerMessage.append("No reference to a contract element could be found either !").append(ICommonConstants.EOL_CHARACTER); //$NON-NLS-1$
      loggerMessage.append("It is likely this context element will be useless."); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
    }
    return contextElement;
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#loadPatternLibraries(java.lang.String)
   */
  public void loadPatternLibraries(String factoryComponentId_p, PatternViewpoint patternViewpoint_p) {
    // Preconditions.
    if ((null == factoryComponentId_p) || (null == patternViewpoint_p)) {
      return;
    }
    // Get the pattern library descriptor from the factory component reader chain.
    IDescriptor libraryDescriptors = FactoryComponentReaderChain.getInstance().readPatternLibraries(factoryComponentId_p);
    // Create an handler to fill in the pattern viewpoint with libraries and patterns read from descriptors.
    PatternDescriptorHandler handler = new PatternDescriptorHandler(patternViewpoint_p);
    // Create a pattern strategy to execute the handler against library descriptors.
    PatternDescriptorStrategy patternStrategy = new PatternDescriptorStrategy();
    // 
    patternStrategy.iterateThroughPatternExtensionDescriptor(handler, libraryDescriptors);
  }

  /**
   * @see org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper#loadMappings(java.lang.String)
   */
  public List<MappingModel> loadMappings(String factoryComponentId_p) {
    List<MappingModel> result = new ArrayList<MappingModel>(0);
    // Precondition.
    if (null == factoryComponentId_p) {
      return result;
    }
    // Get the mappings descriptor from the factory component reader chain.
    IDescriptor mappingDescriptors = FactoryComponentReaderChain.getInstance().readMappings(factoryComponentId_p);
    Iterator<IDescriptor> mappings = mappingDescriptors.getChildren().iterator();
    while (mappings.hasNext()) {
      IDescriptor currentMappingDescriptor = mappings.next();
      MappingModel mapping = ModelFactory.eINSTANCE.createMappingModel();
      // Set the mapping id.
      mapping.setId((String) currentMappingDescriptor.getValue(ExtensionPointHelper.ATT_ID));
      // Set the mapping name.
      mapping.setName((String) currentMappingDescriptor.getValue(ExtensionPointHelper.ATT_NAME));
      // Set the path.
      mapping.setPath((String) currentMappingDescriptor.getValue(IMappingConstants.MAPPING_ATT_PATH));
      // Set the source.
      mapping.setSource((String) currentMappingDescriptor.getValue(IMappingConstants.MAPPING_ATT_SOURCE));
      // Set the target.
      mapping.setTarget((String) currentMappingDescriptor.getValue(IMappingConstants.MAPPING_ATT_TARGET));
      // Add it to the mappings in the mapping viewpoints.
      result.add(mapping);
    }
    return result;
  }

  /**
   * This handler handles the library descriptors parsing to retrieve the libraries with patterns as children.
   * @author Guillaume Brocard
   */
  class PatternDescriptorHandler implements IPatternDescriptorHandler {
    private PatternViewpoint _patternViewpoint;

    /**
     * Constructor.
     * @param patternViewpoint_p
     */
    public PatternDescriptorHandler(PatternViewpoint patternViewpoint_p) {
      _patternViewpoint = patternViewpoint_p;
    }

    /**
     * @see org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler#handleDescriptor(org.eclipse.egf.common.descriptor.IDescriptor)
     */
    public void handleDescriptor(IDescriptor descriptor_p) {
      // Do nothing.
    }

    /**
     * @see org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler#handleLibraryDescriptor(org.eclipse.egf.common.descriptor.IDescriptor,
     *      java.lang.String)
     */
    public void handleLibraryDescriptor(IDescriptor descriptor_p, String libraryFullId_p) {
      // Create a library for given descriptor.
      PatternLibrary newPatternLibrary = ModelFactory.eINSTANCE.createPatternLibrary();
      // Set the library id.
      newPatternLibrary.setId(libraryFullId_p);
      // Set the library name.
      newPatternLibrary.setName((String) descriptor_p.getValue(ExtensionPointHelper.ATT_NAME));
      // Set the library production orchestration.
      newPatternLibrary.setProductionOrchestration((String) descriptor_p.getValue(IPatternConstants.LIBRARY_PRODUCTION_ORCHESTRATION_ATTRIBUTE_NAME));
      // Set the library runtime orchestration.
      newPatternLibrary.setRuntimeOrchestration((String) descriptor_p.getValue(IPatternConstants.LIBRARY_RUNTIME_ORCHESTRATION_ATTRIBUTE_NAME));
      // Get the parent library of the created library.
      PatternLibrary parentLibrary = getParentLibrary(newPatternLibrary);
      // If the parent library exists, add the newly created one to it.
      if (null != parentLibrary) {
        parentLibrary.getPatternElements().add(newPatternLibrary);
      } else {
        // The newly created library is a root library, add it to the pattern viewpoint directly.
        _patternViewpoint.getLibraries().add(newPatternLibrary);
      }
    }

    /**
     * @see org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler#handlePatternDescriptor(org.eclipse.egf.common.descriptor.IDescriptor,
     *      java.lang.String)
     */
    public void handlePatternDescriptor(IDescriptor descriptor_p, String patternFullId_p) {
      // Create a pattern model for given descriptor.
      PatternModel newPatternModel = ModelFactory.eINSTANCE.createPatternModel();
      // Set the pattern id.
      newPatternModel.setId(patternFullId_p);
      // Set the pattern name.
      newPatternModel.setName((String) descriptor_p.getValue(ExtensionPointHelper.ATT_NAME));
      // Set the pattern path (ie pattern definition).
      newPatternModel.setPath((String) descriptor_p.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME));
      // Get the parent library of the created pattern.
      PatternLibrary parentLibrary = getParentLibrary(newPatternModel);
      // If the parent library exists, add the newly created one to it.
      if (null != parentLibrary) {
        parentLibrary.getPatternElements().add(newPatternModel);
      } else {
        // Pattern must have a parent library.
        StringBuilder loggerMessage = new StringBuilder("PatternDescriptorHandler.handlePatternDescriptor(..) _ "); //$NON-NLS-1$
        loggerMessage.append("Pattern model id:").append(patternFullId_p).append(" must have a parent library!"); //$NON-NLS-1$ //$NON-NLS-2$
        __logger.error(loggerMessage.toString());
      }
    }

    /**
     * Return the parent library for specified child id.<br>
     * A child is either or library or a pattern.
     * @param childId_p
     * @return null if given library id represent a root library.
     */
    private PatternLibrary getParentLibrary(AbstractPatternElement patternElement_p) {
      PatternLibrary parentLibrary = null;
      // Search the last libraries/patterns separator in child id.
      String parentLibraryId = ModelHelper.getParentLibraryId(patternElement_p);
      // Check, the parent id is different from the child id.
      if (null != parentLibraryId) {
        parentLibrary = ModelHelper.getLibrary(parentLibraryId, _patternViewpoint);
      }
      return parentLibrary;
    }
  }
}