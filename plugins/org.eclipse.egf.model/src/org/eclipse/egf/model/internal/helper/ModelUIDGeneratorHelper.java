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
package org.eclipse.egf.model.internal.helper;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.IDGeneratorHelper;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.Specification;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.egf.model.util.ModelSwitch;
import org.eclipse.emf.ecore.EObject;


/**
 * Helper to generate id for model elements.
 * @author fournier
 */
public class ModelUIDGeneratorHelper {
  
  /**
   * Singleton instance.
   */
  private static ModelUIDGeneratorHelper __instance;

  /**
   * The switch delegates to the <code>createXXX</code> methods.
   */
  private ModelSwitch<String> _modelSwitch;

  private ModelUIDGeneratorHelper() {
    initialize();
  }

  /**
   * Creates an unique id for given model element.
   * @param modelElement_p the object that an identifier is created for.
   * @return a not null string.
   */
  public String createUID(EObject modelElement_p) {
    return _modelSwitch.doSwitch(modelElement_p);
  }

  /**
   * Get the unique instance.
   * @return a not null instance.
   */
  public static ModelUIDGeneratorHelper getInstance() {
    if (null == __instance) {
      __instance = new ModelUIDGeneratorHelper();
    }
    return __instance;
  }

  /**
   * Initialize the id generator.
   */
  private void initialize() {
    _modelSwitch = new ModelSwitch<String>() {
      @Override
      public String caseFactoryComponent(FactoryComponent fc_p) {
        return IDGeneratorHelper.generatePrefixUID("FactoryComponent"); //$NON-NLS-1$
      }
      @Override
      public String caseSpecification(Specification specification_p) {
        return IDGeneratorHelper.generatePrefixUID("Specification"); //$NON-NLS-1$
      }
      @Override
      public String caseTaskFactoryHolder(TaskFactoryHolder taskFactoryHolder_p) {
        return IDGeneratorHelper.generatePrefixUID("TaskFactory"); //$NON-NLS-1$
      }
      @Override
      public String caseContractElement(ContractElement contractElement_p) {
        return IDGeneratorHelper.generatePrefixUID("ContractElement"); //$NON-NLS-1$
      }
      @Override
      public String caseContract(Contract contract_p) {
        return IDGeneratorHelper.generatePrefixUID("Contract"); //$NON-NLS-1$
      }
      @Override
      public String caseProductionPlan(ProductionPlan productionPlan_p) {
        return IDGeneratorHelper.generatePrefixUID("ProductionPlan"); //$NON-NLS-1$
      }
      @Override
      public String caseFactoryComponentInvocation(FactoryComponentInvocation factoryComponentInvocation_p) {
        return IDGeneratorHelper.generatePrefixUID("FactoryComponentInvocation"); //$NON-NLS-1$
      }
      @Override
      public String caseContext(Context context_p) {
        return IDGeneratorHelper.generatePrefixUID("Context"); //$NON-NLS-1$
      }
      @Override
      public String caseContextElement(ContextElement contextElement_p) {
        return IDGeneratorHelper.generatePrefixUID("ContextElement"); //$NON-NLS-1$
      }
      @Override
      public String caseContractElementReference(ContractElementReference contractElementReference_p) {
        return IDGeneratorHelper.generatePrefixUID("ContractElementReference"); //$NON-NLS-1$
      }
      @Override
      public String caseDomain(Domain domain_p) {
        return IDGeneratorHelper.generatePrefixUID("Domain"); //$NON-NLS-1$
      }
      @Override
      public String casePatternLibrary(PatternLibrary object_p) {
        return IDGeneratorHelper.generatePrefixUID("PatternLibrary"); //$NON-NLS-1$
      }
      @Override
      public String caseMappingModel(MappingModel object_p) {
        // The mapping model id is entered by the end-user.
        return ICommonConstants.EMPTY_STRING;
      }
      @Override
      public String defaultCase(EObject object_p) {
        return IDGeneratorHelper.generateUID(object_p);
      }
    };
  }
  
}
