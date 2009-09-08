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
package org.eclipse.egf.model.data.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.AbstractViewpoint;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.Factory;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.MappingViewpoint;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.PatternViewpoint;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.Specification;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.ViewpointType;
import org.eclipse.egf.model.internal.data.ModelElement;

/**
 * Provides useful services based on model elements.
 * @author fournier
 */
public class ModelHelper {
  
  /**
   * Get the factory component where given model element is a child of.
   * @param modelElement_p
   * @return an {@link FactoryComponent} instance or null if not found.
   */
  public static FactoryComponent getFactoryComponentContainer(NamedModelElementWithId modelElement_p) {
    // Do not search if given element is already an FactoryComponent.
    FactoryComponent result = (modelElement_p instanceof FactoryComponent) ? ((FactoryComponent) modelElement_p) : null;
    boolean isSearching = true;
    // Loop until result is null or searching flag is not set to false.
    while (isSearching && (null == result)) {
      // Get parent of given model element.
      NamedModelElementWithId parent = (NamedModelElementWithId) modelElement_p.eContainer();
      // Is an FactoryComponent ?
      if (parent instanceof FactoryComponent) {
        // Ok, we've found it!
        result = (FactoryComponent) parent;
      } else if (null == parent) {
        // Current element has no parent, stop searching !
        isSearching = false;
      } else {
        // Recurse on retrieved parent which is not an FactoryComponent.
        result = getFactoryComponentContainer(parent);
      }
    }
    return result;
  }

  /**
   * Get the factory component for specified factory component name in given fc collection.
   * @param factoryComponentName_p the 'name' value of a factory component.
   * @return an {@link FactoryComponent} instance or null if not found.
   */
  public static FactoryComponent getFactoryComponentFrom(String factoryComponentName_p, Collection<FactoryComponent> factoryComponents_p) {
    FactoryComponent result = null;
    // Iterate over fcs.
    Iterator<FactoryComponent> fcs = factoryComponents_p.iterator();
    while (fcs.hasNext() && (null == result)) {
      FactoryComponent currentFc = fcs.next();
      if (factoryComponentName_p.equals(currentFc.getName())) {
        // FactoryComponent is found, get it.
        result = currentFc;
      }
    }
    return result;
  }

  /**
   * Add a viewpoint id in the specification of given factory component.
   * @param patternViewpointId_p
   * @param viewpointType_p
   * @param factoryComponent_p
   */
  public static void addViewpointTypeId(String patternViewpointId_p, ViewpointType viewpointType_p, FactoryComponent factoryComponent_p) {
    // Get the specification.
    Specification specification = getSpecification(factoryComponent_p);
    // Get the list of viewpoint id for given viewpoint type.
    EList<String> viewpointIds = getViewpointTypeIds(specification, viewpointType_p);
    // Add given viewpoint id into the related map entry list.
    viewpointIds.add(patternViewpointId_p);
  }

  /**
   * Get the specification for given factory component.<br>
   * @param factoryComponent_p
   * @return a not null specification: if given factory component does not have a specification yet, an empty one is created.
   */
  private static Specification getSpecification(FactoryComponent factoryComponent_p) {
    // Get the specification.
    Specification specification = factoryComponent_p.getSpecification();
    if (null == specification) {
      // Create the specification.
      specification = ModelFactory.eINSTANCE.createSpecification();
      // Add it in given fc.
      factoryComponent_p.setSpecification(specification);
      // Create the map of viewpoint ids.
      specification.setViewpointIds(new HashMap<ViewpointType, EList<String>>(0));
    }
    return specification;
  }

  /**
   * Get the viewpoint ids for given specification and viewpoint type.
   * @param specification_p
   * @param viewpointType_p
   * @return a no null list.
   */
  public static EList<String> getViewpointTypeIds(Specification specification_p, ViewpointType viewpointType_p) {
    // Get the list of viewpoint id.
    Map<ViewpointType, EList<String>> viewpointIds = specification_p.getViewpointIds();
    // Get the viewpoint ids for given viewpoint type.
    EList<String> viewpointTypeIds = viewpointIds.get(viewpointType_p);
    // If no list was defined, let's create a new entry in the map.
    if (null == viewpointTypeIds) {
      viewpointTypeIds = new BasicEList<String>(0);
      viewpointIds.put(viewpointType_p, viewpointTypeIds);
    }
    return viewpointTypeIds;
  }

  /**
   * Get the contract for given factory component.
   * @param factoryComponent_p
   * @return a {@link Contract} instance or null if not defined.
   */
  public static Contract getContract(FactoryComponent factoryComponent_p) {
    Contract result = (Contract) getViewpoint(ViewpointType.CONTRACT, factoryComponent_p);
    return result;
  }

  /**
   * Return a list of 'mandatory' contract element owned by specified factory component.
   * @param factoryComponent_p
   * @return an empty list if no one found.
   */
  public static List<ContractElement> getMandatoryContractElement(FactoryComponent factoryComponent_p) {
    List<ContractElement> result = new ArrayList<ContractElement>(0);
    // Precondition.
    if (null == factoryComponent_p) {
      return result;
    }
    // Get the contract.
    Contract contract = getContract(factoryComponent_p);
    if (null != contract) {
      // Get contract elements.
      List<ContractElement> contractElements = contract.getContractElements();
      if (!contractElements.isEmpty()) {
        Iterator<ContractElement> iter = contractElements.iterator();
        // Iterate over retrieved ones to only add the ones with the mandatory field set to true.
        while (iter.hasNext()) {
          ContractElement contractElement = iter.next();
          if (contractElement.isMandatory()) {
            result.add(contractElement);
          }
        }
      }
    }
    return result;
  }

  /**
   * Get the pattern viewpoint for given factory component.
   * @param factoryComponent_p
   * @return a {@link PatternViewpoint} instance or null if not defined.
   */
  public static PatternViewpoint getPatternViewpoint(FactoryComponent factoryComponent_p) {
    PatternViewpoint result = (PatternViewpoint) getViewpoint(ViewpointType.PATTERN, factoryComponent_p);
    return result;
  }

  /**
   * Return the first viewpoint matching given parameters.
   * @param viewpointType_p
   * @param factoryComponent_p
   * @return null if not found.
   */
  private static AbstractViewpoint getViewpoint(ViewpointType viewpointType_p, FactoryComponent factoryComponent_p) {
    AbstractViewpoint result = null;
    // Get the specification.
    Specification specification = getSpecification(factoryComponent_p);
    if (null != specification) {
      // Get all declared viewpoint ids.
      Map<ViewpointType, EList<String>> allViewpointIds = specification.getViewpointIds();
      // Get all declared viewpoint ids for given viewpoint type.
      EList<String> viewpointTypeIds = allViewpointIds.get(viewpointType_p);
      if (null != viewpointTypeIds && !viewpointTypeIds.isEmpty()) {
        // Get the id of the first declared viewpoint matching given viewpoint type.
        String searchedViewpointTypeId = viewpointTypeIds.get(0);
        // Get all declared viewpoint elements.
        Iterator<AbstractViewpoint> viewpoints = specification.getViewpoints().iterator();
        // Iterate over these viewpoint elements and look up for the one with the same id.
        while (viewpoints.hasNext() && (null == result)) {
          AbstractViewpoint currentViewpoint = viewpoints.next();
          // Comparison based on id.
          if (searchedViewpointTypeId.equals(currentViewpoint.getId())) {
            result = currentViewpoint;
          }
        }
      }
    }
    return result;
  }

  /**
   * Get the production plan for given factory component.
   * @param factoryComponent_p
   * @return a {@link ProductionPlan} instance or null if not defined.
   */
  public static ProductionPlan getProductionPlan(FactoryComponent factoryComponent_p) {
    ProductionPlan result = null;
    // Get the factory.
    Factory factory = factoryComponent_p.getFactory();
    if (factory != null) {
      result = factory.getProductionPlan();
    }
    return result;
  }

  /**
   * Set the contract type for given type name.
   * @param contractElement_p
   * @param typeName_p
   */
  public static void setContractType(ContractElement contractElement_p, String typeName_p) {
    // Precondition
    if (null == contractElement_p) {
      return;
    }
    // Get its type
    Type contractType = contractElement_p.getContractType();
    if (null == contractType) {
      // Create a new one.
      contractType = ModelFactory.eINSTANCE.createType();
      // Set it on contract element.
      contractElement_p.setContractType(contractType);
    }
    // Set type name.
    contractType.setTypeHolderClassName(typeName_p);
  }

  /**
   * Set the context type for given type name.
   * @param contextElement_p
   * @param typeName_p
   */
  public static void setContextType(ContextElement contextElement_p, String typeName_p) {
    // Precondition
    if (null == contextElement_p) {
      return;
    }
    // Get its type
    Type contextType = contextElement_p.getContextType();
    if (null == contextType) {
      // Create a new one.
      contextType = ModelFactory.eINSTANCE.createType();
      // Set it on contract element.
      contextElement_p.setContextType(contextType);
    }
    // Set type name.
    contextType.setTypeHolderClassName(typeName_p);
  }

  /**
   * Create a new contract element reference based on given contract element.
   * @param contractElement_p
   * @return a {@link ContractElementReference} instance or null if given contract element is null.
   */
  public static ContractElementReference createContractElementReferenceBasedOn(ContractElement contractElement_p) {
    ContractElementReference contractElementReference = null;
    // Precondition.
    if (null == contractElement_p) {
      return contractElementReference;
    }
    // Build a ContractElementReference
    contractElementReference = ModelFactory.eINSTANCE.createContractElementReference();
    // Set the referenced fc id.
    contractElementReference.setReferencedFactoryComponentId(contractElement_p.getFactoryComponentId());
    // Set the contract element name
    contractElementReference.setReferencedContractElementId(contractElement_p.getId());
    // Set the contract element itself.
    contractElementReference.setReferencedContractElement(contractElement_p);
    return contractElementReference;
  }

  /**
   * Get a library for specified id in given pattern viewpoint.
   * @param libraryId_p
   * @param patternViewpoint_p
   * @return null if not found.
   */
  public static PatternLibrary getLibrary(String libraryId_p, PatternViewpoint patternViewpoint_p) {
    PatternLibrary result = null;
    // Get all libraries existing in given pattern viewpoint.
    Iterator<PatternLibrary> libraries = patternViewpoint_p.getLibraries().iterator();
    // Iterate over libraries to find the one according to given library id.
    while (libraries.hasNext() && (null == result)) {
      PatternLibrary currentLibrary = libraries.next();
      // Is it the searched one ?
      String currentLibraryId = currentLibrary.getId();
      if (libraryId_p.equals(currentLibraryId)) {
        result = currentLibrary;
      } else {
        // Search in its children libraries.
        result = getLibrary(libraryId_p, currentLibrary);
      }
    }
    return result;
  }

  /**
   * Get a library for specified id in given library children.
   * @param libraryId_p
   * @param parentLibrary_p
   * @return null if not found.
   */
  public static PatternLibrary getLibrary(String libraryId_p, PatternLibrary parentLibrary_p) {
    PatternLibrary result = null;
    // Get the children of given library as parent for the search.
    Iterator<AbstractPatternElement> patternElements = parentLibrary_p.getPatternElements().iterator();
    // Iterate over children to find the the library according to given library id.
    while (patternElements.hasNext() && (null == result)) {
      // Get the current child.
      AbstractPatternElement currentPatternElement = patternElements.next();
      // Is it a library ?
      if (currentPatternElement instanceof PatternLibrary) {
        PatternLibrary currentLibrary = (PatternLibrary) currentPatternElement;
        // Is it the searched library ?
        if (libraryId_p.equals(currentPatternElement.getId())) {
          result = currentLibrary;
        } else {
          // Recurse on sub-libraries ie the children of the current one.
          result = getLibrary(libraryId_p, currentLibrary);
        }
      }
    }
    return result;
  }

  /**
   * Return the short id of specified pattern element.<br>
   * Given pattern element is either a {@link PatternLibrary} or a {@link PatternModel} element.<br>
   * In case of a pattern library (as a child of another one) or a pattern model, return string is the final part after the trailing '/' character.<br>
   * In case of a 'root' library, return string is the same as the full id. {@link IPatternConstants#LIBRARY_PATTERN_ID_SEPARATOR}
   * @param patternElement_p
   * @return the short id
   * @see IPatternExtensionConstants#LIBRARY_PATTERN_ID_SEPARATOR.
   */
  public static String getPatternElementShortId(AbstractPatternElement patternElement_p) {
    // Extract the parent id and the local id.
    Couple<String, String> ids = getDeresolvedIds(patternElement_p);
    return ids.getValue();
  }

  /**
   * Return the id of the parent library id for specified pattern element.
   * @param patternElement_p
   * @return null if given pattern element is a 'root' library ie, this kind of library do not have a parent.<br>
   *         A 'root' pattern library is a library which has a pattern viewpoint as parent.
   */
  public static String getParentLibraryId(AbstractPatternElement patternElement_p) {
    // Extract the parent id and the local id.
    Couple<String, String> ids = getDeresolvedIds(patternElement_p);
    String parentId = ids.getKey();
    // Check, the parent id is different from the given pattern element id.
    // It means no separator was found, we don't have a parent. Case of a root library for instance.
    if (patternElement_p.getId().equals(parentId)) {
      // Set to null means no parent.
      parentId = null;
    }
    return parentId;
  }

  /**
   * Get a first level child as {@link AbstractPatternElement} from given short pattern element id.<br>
   * @param shortPatternElementId_p
   * @param parentLibrary_p
   * @return <code>null</code> if not found or an {@link AbstractPatternElement} element.
   */
  public static AbstractPatternElement getPatternElement(String shortPatternElementId_p, PatternLibrary parentLibrary_p) {
    AbstractPatternElement result = null;
    // Get the children of given library as parent for the search.
    Iterator<AbstractPatternElement> patternElements = parentLibrary_p.getPatternElements().iterator();
    // Iterate over children to find the the pattern element according to given pattern element id.
    while (patternElements.hasNext() && (null == result)) {
      // Get the current child.
      AbstractPatternElement currentPatternElement = patternElements.next();
      // Get the current child short id.
      String currentChildShortId = getPatternElementShortId(currentPatternElement);
      if (shortPatternElementId_p.equals(currentChildShortId)) {
        // Find it !!!
        result = currentPatternElement;
      }
    }
    return result;
  }

  /**
   * Get the couple of parent and local ids for given pattern element.
   * @param patternElement_p
   * @return
   */
  private static Couple<String, String> getDeresolvedIds(AbstractPatternElement patternElement_p) {
    // Get the full id for given pattern element.
    String patternFullId = patternElement_p.getId();
    // Extract the parent id and the local id.
    Couple<String, String> ids = PatternHelper.deresolveId(patternFullId);
    return ids;
  }

  /**
   * Is given domain defined ?
   * @param domain_p
   * @return true if the given domain has a path.
   */
  public static boolean isDomainDefined(Domain domain_p) {
    return ((null != domain_p) && (null != domain_p.getPath()));
  }

  /**
   * Get all mappings contained in given factory component.
   * @param factoryComponent_p
   * @return a not null list.
   */
  public static List<MappingModel> getMappings(FactoryComponent factoryComponent_p) {
    MappingViewpoint mappingViewpoint = getMappingViewpoint(factoryComponent_p);
    return new ArrayList<MappingModel>(mappingViewpoint.getMappings());
  }

  /**
   * Get mapping viewpoint for given factory component.
   * @param factoryComponent_p
   * @return
   */
  public static MappingViewpoint getMappingViewpoint(FactoryComponent factoryComponent_p) {
    return (MappingViewpoint) getViewpoint(ViewpointType.MAPPING, factoryComponent_p);
  }

  /**
   * Create a new Factory Component empty skeleton.<br>
   * It is made of a factory component, a factory and a default production plan.
   * @param factoryComponentName_p
   * @return The Factory Component new instance (known as an {@link FactoryComponent} at the model level).
   */
  public static FactoryComponent createEmptyMinimalFC(String factoryComponentName_p) {
    // Create an fc dynamically.
    FactoryComponent fc = ModelFactory.eINSTANCE.createFactoryComponent();
    fc.setName(factoryComponentName_p);
    // Set the factory.
    Factory factory = ModelFactory.eINSTANCE.createFactory();
    fc.setFactory(factory);
    // Add a production plan.
    ProductionPlan productionPlan = ModelFactory.eINSTANCE.createProductionPlan();
    factory.setProductionPlan(productionPlan);
    return fc;
  }

  /**
   * Add a new factory component invocation to given FC.<br>
   * The new configuration is empty and referencing identified FC.<br>
   * It does not have a context or a task factory.<br>
   * Note the the new configuration is inserted at the end of production plan.
   * @param owningFC_p The FC that is declaring the new factory component invocation, ie using it in its factory.
   * @param referencedFCId_p The FC pointed by the factory component invocation, ie implied in the execute of owner one.
   * @return
   */
  public static FactoryComponentInvocation addFactoryComponentInvocation(FactoryComponent owningFC_p, String referencedFCId_p) {
    // Resulting configuration.
    FactoryComponentInvocation result = null;
    // Preconditions.
    if ((null == owningFC_p) || (null == referencedFCId_p)) {
      return result;
    }
    // Get production plan.
    ProductionPlan productionPlan = ModelHelper.getProductionPlan(owningFC_p);
    // Create a fc configuration.
    result = ModelFactory.eINSTANCE.createFactoryComponentInvocation();
    // Add fc configuration to production plan.
    productionPlan.getFactoryComponentInvocations().add(result);
    // Set referenced fc id.
    result.setFactoryComponentId(referencedFCId_p);
    // Return configuration.
    return result;
  }

  /**
   * Add a new context element (to given context) that references a contract element from another factory component.<br>
   * @param context_p The context being filled up.
   * @param referencedFactoryComponentId_p The factory component declaring the contract.
   * @param referencedContractElementId_p A contract element from this 'remote' contract.
   * @param value_p The context element value according to the contract element. No check is done here, so there may be a runtime error if the value does not
   *          conform to the contract element declared type.
   * @param contributorId_p The plug-in id that contributes the context.
   */
  public static void addReferencingContractContextElement(Context context_p, String referencedFactoryComponentId_p, String referencedContractElementId_p, String value_p,
      String contributorId_p) {
    // Create empty context element and add it to given context.
    ContextElement contextElement = ModelFactory.eINSTANCE.createContextElement();
    context_p.getContextElements().add(contextElement);
    // Create contract element reference and fill it.
    ContractElementReference contractElementRef = ModelFactory.eINSTANCE.createContractElementReference();
    contractElementRef.setReferencedFactoryComponentId(referencedFactoryComponentId_p);
    contractElementRef.setReferencedContractElementId(referencedContractElementId_p);
    // Set context element reference.
    contextElement.setContractElementReference(contractElementRef);
    // Set context element value.
    contextElement.setReadableValue(value_p);
    // Set contributor id.
    contextElement.setPluginId(contributorId_p);
  }

  /**
   * Create a new mapping model with given parameters.
   * @param mappingRelativePath_p
   * @param sourceFactoryComponentId_p
   * @param targetFactoryComponentId_p
   * @param mappingId_p
   * @return null if relative path is null.
   */
  public static MappingModel createMappingModel(String mappingRelativePath_p, String sourceFactoryComponentId_p, String targetFactoryComponentId_p, String mappingId_p) {
    MappingModel newModel = null;
    // Precondition.
    if (null == mappingRelativePath_p) {
      return newModel;
    }
    newModel = ModelFactory.eINSTANCE.createMappingModel();
    newModel.setPath(mappingRelativePath_p);
    newModel.setName(new Path(mappingRelativePath_p).removeFileExtension().lastSegment());
    newModel.setSource(sourceFactoryComponentId_p);
    newModel.setTarget(targetFactoryComponentId_p);
    newModel.setId(mappingId_p);
    return newModel;
  }

  /**
   * Get a mapping model in given list for specified mapping id.
   * @param mappingId_p
   * @param mappings_p
   * @return a {@link MappingModel} instance or null if not found.
   */
  public static MappingModel getMapping(String mappingId_p, List<MappingModel> mappings_p) {
    MappingModel result = null;
    // Iterate over mapping models contained in given list.
    for (Iterator<MappingModel> iter = mappings_p.iterator(); iter.hasNext() && (null == result);) {
      MappingModel currentMapping = iter.next();
      // Check current id with given one.
      if (mappingId_p.equals(currentMapping.getId())) {
        result = currentMapping;
      }
    }
    return result;
  }

  /**
   * Get the hosting project for given model element.<br>
   * It means the project where the factory component container of given model element is defined.
   * @param modelElement_p
   * @return an {@link IProject} instance if given model element is contained by a factory component located in the workspace; null otherwise.
   */
  public static IProject getProject(NamedModelElementWithId modelElement_p) {
    IProject project = null;
    // Get the fc container for given model element
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(modelElement_p);
    if (null != fcContainer) {
      // Get the hosting project.
      project = (IProject) ((ModelElement) fcContainer).getAdapter(IProject.class);
    }
    return project;
  }
    
}