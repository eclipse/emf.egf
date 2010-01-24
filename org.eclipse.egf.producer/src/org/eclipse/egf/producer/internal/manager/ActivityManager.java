/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.internal.manager;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.helper.ActivityCycleFinder;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityManager<P extends Activity> extends ModelElementManager<P, Contract> implements IActivityManager<P> {

  public ActivityManager(P activity) throws InvocationException {
    super(activity);
    // Diagnose Cycle
    ActivityCycleFinder finder = new ActivityCycleFinder(activity);
    ModelElement element = finder.getFirstRepetition();
    if (element != null) {
      throw new InvocationException(NLS.bind("Activity cycle detected in ''{0}''", EMFHelper.getText(element))); //$NON-NLS-1$
    }
  }

  public ActivityManager(Bundle bundle, P activity) throws InvocationException {
    super(bundle, activity);
    // Diagnose Cycle
    ActivityCycleFinder finder = new ActivityCycleFinder(activity);
    ModelElement element = finder.getFirstRepetition();
    if (element != null) {
      throw new InvocationException(NLS.bind("Activity cycle detected in ''{0}''", EMFHelper.getText(element))); //$NON-NLS-1$
    }
  }

  public <M extends Invocation> ActivityManager(IModelElementManager<M, InvocationContract> parent, P activity) throws InvocationException {
    super(parent, activity);
  }

  @Override
  protected BasicDiagnostic canInvokeElement() throws InvocationException {
    BasicDiagnostic diagnostic = getDiagnostic(getElement());
    BasicDiagnostic containerDiagnostic = null;
    // Diagnose Mandatory In Contract
    for (Contract contract : getElement().getContracts(ContractMode.IN)) {
      if (contract.isMandatory()) {
        // Check Mandatory Value
        Object value = null;
        try {
          value = getInternalProductionContext().getInputValue(contract.getName(), contract.getType().getType());
        } catch (InvocationException ie) {
          if (ie.getCause() != null) {
            throw ie;
          }
        }
        if (value == null) {
          if (containerDiagnostic == null) {
            containerDiagnostic = getDiagnostic(contract.getContractContainer());
          }
          containerDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, EGFProducerPlugin.getDefault().getPluginID(), 0, NLS.bind("ActivityContract is mandatory for ''{0}''", EMFHelper.getText(contract)), //$NON-NLS-1$
              new Object[] { contract }));
        }
      }
    }
    // containerDiagnostic should be added at the end otherwise, the severity code is not propagated
    // to the parent.
    if (containerDiagnostic != null) {
      diagnostic.add(containerDiagnostic);
    }
    return diagnostic;
  }

  @Override
  public void initializeContext() throws InvocationException {
    // Get Context
    ProductionContext<P, Contract> context = getInternalProductionContext();
    // Clear Context
    context.clear();
    // Set Context
    for (Contract contract : getElement().getContracts()) {
      // Should not happen, anyway ignore
      if (contract.getType() == null) {
        continue;
      }
      // Class
      if (contract.getType() instanceof TypeAbstractClass) {
        try {
          Object object = null;
          // Should we instantiate value
          String fqcn = ((TypeAbstractClass) contract.getType()).getValue();
          if (fqcn != null && fqcn.trim().length() != 0) {
            object = BundleHelper.instantiate(fqcn.trim(), getBundle());
            if (object == null) {
              throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue(), getBundle().getSymbolicName()), null)));
            }
          }
          if (contract.getMode() == ContractMode.IN) {
            context.addInputData(contract, contract.getType().getType(), object);
          } else if (contract.getMode() == ContractMode.OUT) {
            context.addOutputData(contract, contract.getType().getType(), null);
          } else if (contract.getMode() == ContractMode.IN_OUT) {
            context.addInputData(contract, contract.getType().getType(), object);
            context.addOutputData(contract, contract.getType().getType(), object);
          }
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue()), t)));
        }
      } else {
        if (contract.getMode() == ContractMode.IN) {
          context.addInputData(contract, contract.getType().getType(), contract.getType().getValue());
        } else if (contract.getMode() == ContractMode.OUT) {
          context.addOutputData(contract, contract.getType().getType(), null);
        } else if (contract.getMode() == ContractMode.IN_OUT) {
          context.addInputData(contract, contract.getType().getType(), contract.getType().getValue());
          context.addOutputData(contract, contract.getType().getType(), contract.getType().getValue());
        }
      }
    }
  }

}
