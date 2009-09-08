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
package org.eclipse.egf.core.data.helper;

import static org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants.ROOT_FACTORY_COMPONENT_ID;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * Provides useful services based on model elements.
 * @author fournier
 */
public class DataHelper extends ModelHelper {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(DataHelper.class.getPackage().getName());

  /**
   * Get a list of {@link ContractElement} that can be used as referenced contract element for a contract.
   * @param factoryComponent_p
   * @return a not null collection.
   */
  public static Collection<ContractElement> getPossibleReferencedContractElement(FactoryComponent factoryComponent_p) {
    Set<ContractElement> possibleContractElements = new HashSet<ContractElement>(0);
    // Precondition
    if (null == factoryComponent_p) {
      return possibleContractElements;
    }
    // Get the contract of given fc.
    Contract referencedFcContract = ModelHelper.getContract(factoryComponent_p);
    if (null != referencedFcContract) {
      // Append the contract elements to resulting list.
      possibleContractElements.addAll(referencedFcContract.getContractElements());
    }
    return possibleContractElements;
  }

  /**
   * Get the list of referenced factory components by given one.
   * @param factoryComponent_p
   * @return a not null collection of {@link FactoryComponent}.
   */
  public static Collection<FactoryComponent> getReferencedFactoryComponentsBy(FactoryComponent factoryComponent_p) {
    Set<FactoryComponent> referencedFcs = new HashSet<FactoryComponent>(0);
    // Precondition.
    if (null == factoryComponent_p) {
      return referencedFcs;
    }
    ProductionPlan productionPlan = getProductionPlan(factoryComponent_p);
    // RootFc does not have a production plan...
    if (null != productionPlan) {
      // Get all fc configurations.
      List<FactoryComponentInvocation> fcConfigurations = productionPlan.getFactoryComponentInvocations();
      for (FactoryComponentInvocation fcConfiguration : fcConfigurations) {
        // Get the pointed out fc.
        String pointedFcId = fcConfiguration.getFactoryComponentId();
        FactoryComponent pointedFc = CoreActivator.getDefault().getFactoryComponent(pointedFcId);
        referencedFcs.add(pointedFc);
      }
    }
    return referencedFcs;
  }

  /**
   * Get a list of {@link ContractElement} related to referenced contract elements for given one as parameter.
   * @param contractElement_p
   * @return a not null collection.
   */
  public static Collection<ContractElement> getReferencedContractElementsFor(ContractElement contractElement_p) {
    // Precondition.
    if (null == contractElement_p) {
      return Collections.emptyList();
    }
    // Get the contract element references for given contract element.
    List<ContractElementReference> contractElementReferences = contractElement_p.getContractElementReferences();
    // Number of contract element references.
    int contractElementReferenceCount = contractElementReferences.size();
    // Create the resulting list.
    // Create the resulting list.
    Set<ContractElement> referencedContractElements = new HashSet<ContractElement>(contractElementReferenceCount);
    // Loop over contract element references to get all referenced contract element.
    for (ContractElementReference contractElementReference : contractElementReferences) {
      // Resolve the contractElementReference.
      resolveContractElement(contractElementReference);
      // Add in resulting list the referenced contract element.
      referencedContractElements.add(contractElementReference.getReferencedContractElement());
    }
    return referencedContractElements;
  }

  /**
   * Get the referenced contract elements for given contract.
   * @param contract_p
   * @return a not null collection.
   */
  public static Collection<ContractElement> getReferencedContractElementsFor(Contract contract_p) {
    // Precondition.
    if (null == contract_p) {
      return Collections.emptyList();
    }
    Set<ContractElement> referencedContractElements = new HashSet<ContractElement>(0);
    List<ContractElement> contractElements = contract_p.getContractElements();
    // Loop over the contract elements, and get the referenced contract elements (if defined) for the current contract element.
    for (ContractElement currentContractElement : contractElements) {
      // Append to the resulting list the retrieved referenced contract elements.
      referencedContractElements.addAll(getReferencedContractElementsFor(currentContractElement));
    }
    return referencedContractElements;
  }

  /**
   * Get the referenced contract element for given context element.
   * @param contextElement_p
   * @return a {@link ContractElement} instance or null if given context element does not have a reference to a contract element.
   */
  public static ContractElement getReferencedContractElementFor(ContextElement contextElement_p) {
    ContractElement result = null;
    // Precondition.
    if (null == contextElement_p) {
      return result;
    }
    // Get the contract element reference if any.
    ContractElementReference contractElementReference = contextElement_p.getContractElementReference();
    if (null != contractElementReference) {
      // Resolve the contractElementReference.
      resolveContractElement(contractElementReference);
      result = contractElementReference.getReferencedContractElement();
    }
    return result;
  }

  /**
   * Get the referenced contract elements for given context.
   * @param context_p
   * @return a not null collection.
   */
  public static Collection<ContractElement> getReferencedContractElementsFor(Context context_p) {
    // Precondition.
    if (context_p == null) {
      return Collections.emptyList();
    }
    Set<ContractElement> referencedContractElements = new HashSet<ContractElement>(0);
    List<ContextElement> contextElements = context_p.getContextElements();
    // Loop over the context elements, and get the referenced contract element (if defined) for the current context element.
    for (ContextElement currentContextElement : contextElements) {
      ContractElement contractElement = getReferencedContractElementFor(currentContextElement);
      if (contractElement != null) {
        referencedContractElements.add(contractElement);
      }
    }
    return referencedContractElements;
  }

  /**
   * Resolve contract elements from given reference.<br>
   * All contract elements found in the referencing chain are also resolved.
   * @param contractElementReference_p
   */
  @SuppressWarnings("deprecation")
  public static void resolveContractElement(ContractElementReference contractElementReference_p) {
    // Preconditions.
    if (null == contractElementReference_p) {
      return;
    }
    // Reference has already been resolved, return existing content.
    ContractElement contractElement = contractElementReference_p.getReferencedContractElement();
    if (null != contractElement) {
      return;
    }
    // Get referenced contract element.
    // The contract element is retrieved from either the contract element id or contract element name(@deprecated) .
    EStructuralFeature contractElementMatchingFeature = ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__ID;
    String contractElementMatchingValue = contractElementReference_p.getReferencedContractElementId();
    // Whether or not it is useful to update the contract element id. It depends on the way the contract element is resolved.
    boolean updateContractElementIdIsNeeded = false;
    if (null == contractElementMatchingValue) {
      // @deprecated way to get the referenced contract element.
      // Ensure compatibility with existing factory components.
      contractElementMatchingValue = contractElementReference_p.getReferencedContractElementName();
      contractElementMatchingFeature = ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME;
      updateContractElementIdIsNeeded = true;
    }
    contractElement =
                      getReferencedContractElement(contractElementReference_p.getReferencedFactoryComponentId(), contractElementMatchingFeature,
                                                   contractElementMatchingValue);
    // Make sure, it was retrieved...
    if (null != contractElement) {
      contractElementReference_p.setReferencedContractElement(contractElement);
      // Update the contract element id if it was unknown before resolving it.
      if (updateContractElementIdIsNeeded) {
        contractElementReference_p.setReferencedContractElementId(contractElement.getId());
      }
      // Get its references, if any.
      for (Iterator<ContractElementReference> contractElementRefs = contractElement.getContractElementReferences().iterator(); contractElementRefs.hasNext();) {
        ContractElementReference reference = contractElementRefs.next();
        // Resolve references chain.
        resolveContractElement(reference);
      }
    }
  }

  /**
   * Get the label for given context element.
   * @param contextElement_p
   * @return a not null string.
   */
  public static String getLabel(ContextElement contextElement_p) {
    // Label is either the key or coming from the contract element reference.
    String label = contextElement_p.getKey();
    if (null == label) {
      ContractElementReference contractElementReference = contextElement_p.getContractElementReference();
      if (null != contractElementReference) {
        // Resolve the contract element.
        resolveContractElement(contractElementReference);
        // get the label from referenced contract element.
        ContractElement referencedContractElement = contractElementReference.getReferencedContractElement();
        if (null != referencedContractElement) {
          label = referencedContractElement.getName();
        }
      }
    }
    label = (null == label) ? ICommonConstants.EMPTY_STRING : label;
    return label;
  }

  /**
   * Get the description for specified model element.
   * @param element_p
   * @return
   */
  public static String getDescription(NamedModelElementWithId element_p) {
    String description = null;
    // Precondition
    if (null == element_p) {
      return description;
    }
    description = element_p.getDescription();
    // Specific case of the contract element that references another one.
    if (element_p instanceof ContractElement) {
      if ((null == description) || ICommonConstants.EMPTY_STRING.equals(description)) {
        // If contract element description is not defined, try getting it from the referenced contract element if any.
        Collection<ContractElement> referencedContractElements = getReferencedContractElementsFor((ContractElement) element_p);
        // Check only one contract element is referenced.
        if (referencedContractElements.size() == 1) {
          ContractElement referencedContractElement = referencedContractElements.iterator().next();
          description = getDescription(referencedContractElement);
        }
      }
    }
    return description;
  }

  /**
   * Return the TypeHolder class name for given context element.
   * @param contextElement_p
   * @return a fully qualified class name or an empty string {@link ICommonConstants#EMPTY_STRING} if not found.
   */
  public static String getContextType(ContextElement contextElement_p) {
    String result = ICommonConstants.EMPTY_STRING;
    // Get its type
    Type contextType = contextElement_p.getContextType();
    // Check if the context element has its own type.
    if (null != contextType) {
      result = contextType.getTypeHolderClassName();
    } else {
      // Get the type from its contract element reference.
      ContractElementReference contractElementReference = contextElement_p.getContractElementReference();
      if (null != contractElementReference) {
        // First, resolve the contract element reference.
        DataHelper.resolveContractElement(contractElementReference);
        ContractElement referencedContractElement = contractElementReference.getReferencedContractElement();
        if (null != referencedContractElement) {
          result = referencedContractElement.getContractType().getTypeHolderClassName();
        }
      }
    }
    if (null == result) {
      StringBuilder loggerMessage = new StringBuilder("DataHelper.getContextType(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Context element:"); //$NON-NLS-1$
      loggerMessage.append(contextElement_p.getId()).append(" does not have a Type!!!"); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString());
    }
    return result;
  }

  /**
   * Return a list of 'mandatory' contract element owned by specified factory component with no default value.
   * @param factoryComponent_p
   * @return an empty list if no one found.
   */
  public static List<ContractElement> getMandatoryContractElementWithNoDefaultValue(FactoryComponent factoryComponent_p) {
    List<ContractElement> result = new ArrayList<ContractElement>(0);
    // Precondition.
    if (factoryComponent_p == null) {
      return result;
    }
    // Get the production plan.
    ProductionPlan productionPlan = getProductionPlan(factoryComponent_p);
    if (productionPlan == null) {
      return result;
    }
    // Get its context.
    Context productionPlanContext = productionPlan.getContext();
    if (productionPlanContext == null) {
      return result;
    }    
    // Get the referenced contract elements for these ones.
    Collection<ContractElement> referencedContractElementsByProductionPlanContext = getReferencedContractElementsFor(productionPlanContext);
    // Get all mandatory contract elements.
    result = getMandatoryContractElement(factoryComponent_p);    
    // Retain only these ones with no default value.
    result.removeAll(referencedContractElementsByProductionPlanContext);
    return result;
  }

  /**
   * Whether or not given factory component id points to the boot strap factory component.
   * @param factoryComponentId_p
   * @return
   */
  public static boolean isBootstrapFactoryComponent(String factoryComponentId_p) {
    return ROOT_FACTORY_COMPONENT_ID.equals(factoryComponentId_p);
  }

  /**
   * Get referenced contract element from its containing factory component id and its targeting id.
   * @param factoryComponentId_p
   * @param contractElementMatchingFeature_p
   * @param contractElementMatchingValue_p
   * @return
   */
  private static ContractElement getReferencedContractElement(String factoryComponentId_p, EStructuralFeature contractElementMatchingFeature_p,
      String contractElementMatchingValue_p) {
    ContractElement result = null;
    FactoryComponent fc = CoreActivator.getDefault().getFactoryComponent(factoryComponentId_p);
    if (null != fc) {
      Contract contract = ModelHelper.getContract(fc);
      for (Iterator<ContractElement> contractElements = contract.getContractElements().iterator(); contractElements.hasNext() && (null == result);) {
        ContractElement contractElement = contractElements.next();
        if (contractElementMatchingValue_p.equals(contractElement.eGet(contractElementMatchingFeature_p))) {
          result = contractElement;
        }
      }
    } else {
      StringBuffer loggerMessage = new StringBuffer("DataHelper.getReferencedContractElement(..) _ "); //$NON-NLS-1$
      loggerMessage.append("could not find factory component "); //$NON-NLS-1$
      loggerMessage.append(factoryComponentId_p);
      loggerMessage.append(" , while searching for contract element "); //$NON-NLS-1$
      loggerMessage.append(contractElementMatchingValue_p);
      loggerMessage.append(" !"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
    }
    return result;
  }
}
