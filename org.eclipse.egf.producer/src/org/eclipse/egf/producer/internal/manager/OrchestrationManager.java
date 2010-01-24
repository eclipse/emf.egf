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
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class OrchestrationManager<P extends Orchestration> extends ModelElementManager<P, OrchestrationParameter> {

  public OrchestrationManager(IActivityManager<FactoryComponent> parent, P orchestration) throws InvocationException {
    super(parent, orchestration);
  }

  @Override
  public void initializeContext() throws InvocationException {
    // Get Context
    ProductionContext<P, OrchestrationParameter> context = getInternalProductionContext();
    // Clear Context
    context.clear();
    // Set Context
    for (OrchestrationParameter orchestrationParameter : getElement().getOrchestrationParameters()) {
      // Nothing to process
      if (orchestrationParameter.getType() == null) {
        continue;
      }
      // Class
      if (orchestrationParameter.getType() instanceof TypeAbstractClass) {
        try {
          Object object = null;
          // Should we instantiate value
          String fqcn = ((TypeAbstractClass) orchestrationParameter.getType()).getValue();
          if (fqcn != null && fqcn.trim().length() != 0) {
            object = BundleHelper.instantiate(fqcn.trim(), getBundle());
            if (object == null) {
              throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, orchestrationParameter.getType().getValue(), getBundle().getSymbolicName()), null)));
            }
          }
          context.addInputData(orchestrationParameter, orchestrationParameter.getType().getType(), object);
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, orchestrationParameter.getType().getValue()), t)));
        }
      } else {
        context.addInputData(orchestrationParameter, orchestrationParameter.getType().getType(), orchestrationParameter.getType().getValue());
      }
    }
  }

}
