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
package org.eclipse.egf.core.data.validation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.util.ModelSwitch;
import org.eclipse.egf.model.util.ModelValidator;
import org.eclipse.egf.model.validation.IDelegatedValidator;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;


/**
 * Model element validator implementation.
 * @author Guillaume Brocard
 */
public class ModelElementDelegatedValidator implements IDelegatedValidator {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(ModelElementDelegatedValidator.class.getPackage().getName());
  /**
   * Diagnostic container.
   */
  private DiagnosticChain _diagnostics;
  /**
   * The switch delegates to the <code>createXXX</code> methods.
   */
  private ModelSwitch<Boolean> _modelSwitch;

  public ModelElementDelegatedValidator() {
    initializeModelSwitch();
  }

  /**
   * Initialize the model switch that is responsible for model element validation.
   */
  protected void initializeModelSwitch() {
    _modelSwitch = new ModelSwitch<Boolean>() {
      /**
       * @see org.eclipse.egf.model.util.ModelSwitch#caseFactoryComponentInvocation(org.eclipse.egf.model.FactoryComponentInvocation)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      public Boolean caseFactoryComponentInvocation(FactoryComponentInvocation fcInvocation_p) {
        if (__logger.isDebugEnabled()) {
          StringBuilder loggerMessage = new StringBuilder(".caseFactoryComponentInvocation(..) _ "); //$NON-NLS-1$
          __logger.debug(loggerMessage.toString());
        }
        boolean valid = true;
        String referencedFcId = fcInvocation_p.getFactoryComponentId();
        // Rule 0: Check the referenced factory component exists wherever.
        FactoryComponent referencedFc = CoreActivator.getDefault().getFactoryComponent(referencedFcId);
        if (null == referencedFc) {
          valid = false;
          // Error
          getDiagnostics().add(
                               new BasicDiagnostic(Diagnostic.ERROR, ModelValidator.DIAGNOSTIC_SOURCE, 0, StringHelper
                                   .formatMessage(Messages.ModelElementDelegatedValidator_FactoryComponentInvocation_Rule0_Message, new Object[] {
                                                                                                                                          fcInvocation_p
                                                                                                                                              .getName(),
                                                                                                                                          referencedFcId }),
                                                   new Object[] { fcInvocation_p }));
        } else {
          // Rule 1: Check if the referenced factory component is the BootStrap one.
          if (DataHelper.isBootstrapFactoryComponent(referencedFcId)) {
            valid = checkFactoryComponentInvocationReferencingRootFc(fcInvocation_p);
          } else {
            // Rule 2: Check if all mandatory contract elements are filled.
            // Get the referenced factory component.
            valid = checkFactoryComponentInvocationHasAllMandatoryContractFilled(fcInvocation_p, referencedFc);
            // Validate the referenced factory component.
            Diagnostician diagnostician = new Diagnostician();
            // Invoke validation.
            Diagnostic diagnostic = diagnostician.validate(referencedFc);
            // If on error, display message.
            boolean validationError = (Diagnostic.ERROR == diagnostic.getSeverity());
            if (validationError) {
              valid = false;
              // Create sub-diagnostic for the referenced factory component.
              String formattedMessage =
                                        StringHelper.formatMessage(Messages.ModelElementDelegatedValidator_FactoryComponentInvocation_ReferencedFcDiagnostic_Message,
                                                                   new String[] { referencedFc.getName() });
              DiagnosticChain referencedFcDiagnostic =
                                                          new BasicDiagnostic(Diagnostic.ERROR, ModelValidator.DIAGNOSTIC_SOURCE, 0, formattedMessage,
                                                                              new Object[] { referencedFc });
              // Then attach all the validation diagnostic children for the referenced factory component.
              referencedFcDiagnostic.addAll(diagnostic);
              // Add it to root diagnostic.
              getDiagnostics().add((Diagnostic) referencedFcDiagnostic);
            }
          }
        }
        return Boolean.valueOf(valid);
      }

      /**
       * @see org.eclipse.egf.model.util.ModelSwitch#caseContractElementReference(org.eclipse.egf.model.ContractElementReference)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      public Boolean caseContractElementReference(ContractElementReference contractElementReference_p) {
        if (__logger.isDebugEnabled()) {
          StringBuilder loggerMessage = new StringBuilder(".caseContractElementReference(..) _ "); //$NON-NLS-1$
          __logger.debug(loggerMessage.toString());
        }
        boolean valid = true;
        // Rule 0 : check the referenced factory component is the expected one.
        valid = checkContractElementRefPointsExpectedFactoryComponent(contractElementReference_p);
        if (valid) {
          // Rule 1 : check the referenced factory component exists.
          valid = checkContractElementRefPointsExistingFactoryComponent(contractElementReference_p);
        }
        if (valid) {
          // Rule 2 : check that all id match existing data.
          // Get the referenced contract element.
          ContractElement initialReferencedContractElement = contractElementReference_p.getReferencedContractElement();
          try {
            // Force to reload the referenced contract element.
            contractElementReference_p.setReferencedContractElement(null);
            DataHelper.resolveContractElement(contractElementReference_p);
            ContractElement reloadedReferencedContractElement = contractElementReference_p.getReferencedContractElement();
            if (null == reloadedReferencedContractElement) {
              valid = false;
              String referencedContractElementIdentifier = contractElementReference_p.getReferencedContractElementId();
              addErrorForContractElementRef(contractElementReference_p, Messages.ModelElementDelegatedValidator_ContractElementReference_Rule3_Message,
                                            new Object[] { referencedContractElementIdentifier });
            }
          } finally {
            // Set the initial value afterwards.
            contractElementReference_p.setReferencedContractElement(initialReferencedContractElement);
          }
        }
        return Boolean.valueOf(valid);
      }

      /**
       * @see org.eclipse.egf.model.util.ModelSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      public Boolean defaultCase(EObject object_p) {
        if (__logger.isDebugEnabled()) {
          StringBuilder loggerMessage = new StringBuilder(".defaultCase(..) _ "); //$NON-NLS-1$
          loggerMessage.append(object_p.eClass().getName());
          __logger.debug(loggerMessage.toString());
        }
        return Boolean.TRUE;
      }
    };
  }

  /**
   * Add a formated message error in diagnostics for specified parameters.
   * @param contractElementReference_p
   * @param referencedFactoryComponentId
   */
  protected void addErrorForContractElementRef(ContractElementReference contractElementReference_p, String detailedMessage_p, Object[] detailedMessageArgs_p) {
    NamedModelElementWithId contractElementRefContainer = (NamedModelElementWithId) contractElementReference_p.eContainer();
    String bodyMessage =
                         StringHelper.formatMessage(Messages.ModelElementDelegatedValidator_ContractElementReference_MessageHeader, new Object[] { contractElementRefContainer.eClass().getName(),
                                                                                  contractElementRefContainer.getId() });
    String detailedFormatedMessage = StringHelper.formatMessage(detailedMessage_p, detailedMessageArgs_p);
    getDiagnostics().add(
                         new BasicDiagnostic(Diagnostic.ERROR, ModelValidator.DIAGNOSTIC_SOURCE, 0, bodyMessage + detailedFormatedMessage,
                                             new Object[] { contractElementRefContainer }));
  }

  /**
   * Check a factory component invocation that references whatever FC different from the Boot Strap one.
   * @param fcInvocation_p
   * @param referencedFc_p
   * @return
   */
  protected boolean checkFactoryComponentInvocationHasAllMandatoryContractFilled(FactoryComponentInvocation fcInvocation_p, FactoryComponent referencedFc_p) {
    boolean valid = true;
    // Get all mandatory contract elements exposed by this factory component.
    List<ContractElement> mandatoryContractElements = DataHelper.getMandatoryContractElementWithNoDefaultValue(referencedFc_p);
    // Check if our local contract elements reference mandatory ones.
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(fcInvocation_p);
    Contract localContract = ModelHelper.getContract(fcContainer);
    // Get the referenced contract elements for these ones.
    Collection<ContractElement> referencedContractElementsByLocalContract = DataHelper.getReferencedContractElementsFor(localContract);
    // Remove them from the mandatory list.
    mandatoryContractElements.removeAll(referencedContractElementsByLocalContract);
    if (!mandatoryContractElements.isEmpty()) {
      // Check local context elements.
      Context localContext = fcInvocation_p.getContext();
      // Get the referenced contract elements for these ones.
      Collection<ContractElement> referencedContractElementsByLocalContext = DataHelper.getReferencedContractElementsFor(localContext);
      // Remove them from the mandatory list.
      mandatoryContractElements.removeAll(referencedContractElementsByLocalContext);
    }
    if (!mandatoryContractElements.isEmpty()) {
      valid = false;
      Iterator<ContractElement> iter = mandatoryContractElements.iterator();
      while (iter.hasNext()) {
        ContractElement contractElement = iter.next();
        // Error
        getDiagnostics().add(
                             new BasicDiagnostic(Diagnostic.ERROR, ModelValidator.DIAGNOSTIC_SOURCE, 0, StringHelper
                                 .formatMessage(Messages.ModelElementDelegatedValidator_FactoryComponentInvocation_Rule2_Message, new Object[] {
                                                                                                                                        fcInvocation_p
                                                                                                                                            .getName(),
                                                                                                                                        referencedFc_p
                                                                                                                                            .getName(),
                                                                                                                                        contractElement
                                                                                                                                            .getName() }),
                                                 new Object[] { fcInvocation_p }));
      }
    }
    return valid;
  }

  /**
   * Check referenced factory component in specified contract element reference exists.
   * @param contractElementReference_p
   * @return
   */
  protected boolean checkContractElementRefPointsExistingFactoryComponent(ContractElementReference contractElementReference_p) {
    boolean valid = true;
    // Retrieve the factory component.
    String referencedFcId = contractElementReference_p.getReferencedFactoryComponentId();
    FactoryComponent referencedFc = CoreActivator.getDefault().getFactoryComponent(referencedFcId);
    if (null == referencedFc) {
      valid = false;
      // Error
      addErrorForContractElementRef(contractElementReference_p, Messages.ModelElementDelegatedValidator_ContractElementReference_Rule2_Message,
                                    new Object[] { referencedFcId });
    }
    return valid;
  }

  /**
   * Check specified contract element reference points to an "allowed" FC.<br>
   * If this one is owned by a context element, check its factory component invocation references the same FC.<br>
   * Else, this one is owned by a contract, check a factory component invocation references the same FC in the production plan.
   * @param contractElementReference_p
   * @return
   */
  protected boolean checkContractElementRefPointsExpectedFactoryComponent(ContractElementReference contractElementReference_p) {
    boolean valid = true;
    String referencedFcIdByContractElementRef = contractElementReference_p.getReferencedFactoryComponentId();
    EObject owner = contractElementReference_p.eContainer();
    if (owner instanceof ContextElement) {
      owner = owner.eContainer().eContainer();
      // Only one case : context element owned by a factory component invocation, because those contained by the production plan are handled by another rule.
      if (owner instanceof FactoryComponentInvocation) {
        FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) owner;
        String referencedFcId = fcInvocation.getFactoryComponentId();
        if (!referencedFcId.equals(referencedFcIdByContractElementRef)) {
          valid = false;
          // FactoryComponent configuration is referencing a contract element not provided by this later one.
          addErrorForContractElementRef(contractElementReference_p,
                                        Messages.ModelElementDelegatedValidator_ContractElementReference_Rule0_Message,
                                        new Object[] {fcInvocation.getName()});
        }
      }
    } else if (owner instanceof ContractElement) {
      // Get the factory component container.
      FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(contractElementReference_p);
      // Get its production plan.
      ProductionPlan productionPlan = ModelHelper.getProductionPlan(fcContainer);
      boolean found = false;
      // Loop over factory component invocations, to find out the one that matches the referenced factory component id.
      for (Iterator<FactoryComponentInvocation> iter = productionPlan.getFactoryComponentInvocations().iterator(); iter.hasNext() && !found;) {
        FactoryComponentInvocation currentFc = iter.next();
        if (currentFc.getFactoryComponentId().equals(referencedFcIdByContractElementRef)) {
          found = true;
        }
      }
      if (!found) {
        valid = false;
        // Not allowed to depend on such a contract element because no factory component invocation references the referenced factory component id.
        addErrorForContractElementRef(
                                      contractElementReference_p,
                                      Messages.ModelElementDelegatedValidator_ContractElementReference_Rule1_Message,
                                      new Object[] { contractElementReference_p.getReferencedContractElementId(), referencedFcIdByContractElementRef });
      }
    }
    return valid;
  }

  /**
   * Check an factory component invocation that references the root factory component known as Boot Strap FC.
   * @return
   */
  protected boolean checkFactoryComponentInvocationReferencingRootFc(FactoryComponentInvocation fcInvocation_p) {
    boolean valid = true;
    // In this case, check a task factory is provided.
    if (null == fcInvocation_p.getTaskFactory()) {
      // Error
      getDiagnostics().add(
                           new BasicDiagnostic(Diagnostic.ERROR, ModelValidator.DIAGNOSTIC_SOURCE, 0, StringHelper
                               .formatMessage(Messages.ModelElementDelegatedValidator_FactoryComponentInvocation_Rule1_Message, new Object[] { fcInvocation_p
                                   .getName() }), new Object[] { fcInvocation_p }));
    }
    return valid;
  }

  /**
   * @see org.eclipse.egf.model.validation.IDelegatedValidator#validate(org.eclipse.egf.model.NamedModelElementWithId,
   *  org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
   */
  public boolean validate(NamedModelElementWithId modelElement_p, DiagnosticChain diagnostics_p, Map<Object, Object> context_p) {
    boolean valid = false;
    // Precondition.
    if (!(diagnostics_p instanceof Diagnostic)) {
      return valid;
    }
    _diagnostics = diagnostics_p;
    // Get the initial diagnostics count.
    Diagnostic diagnostics = (Diagnostic) diagnostics_p;
    int initialDiagnosticCount = diagnostics.getChildren().size();
    // Validate
    _modelSwitch.doSwitch(modelElement_p);
    // Get diagnostic count after business validation.
    int diagnosticCount = diagnostics.getChildren().size();
    valid = (diagnosticCount > initialDiagnosticCount) ? true : false;
    return valid;
  }

  /**
   * Get the diagnostic container.
   * @return the diagnostics
   */
  protected DiagnosticChain getDiagnostics() {
    return _diagnostics;
  }
}
