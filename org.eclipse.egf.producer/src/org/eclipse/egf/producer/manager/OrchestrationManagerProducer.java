/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.producer.manager;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class OrchestrationManagerProducer<T extends Orchestration> {

  public abstract EClass getOrchestration();

  protected abstract IModelElementManager<T, OrchestrationParameter> doCreateOrchestrationManager(IActivityManager<FactoryComponent> parent, T orchestration) throws InvocationException;

  public IModelElementManager<T, OrchestrationParameter> createOrchestrationManager(IActivityManager<FactoryComponent> parent, T orchestration) throws InvocationException {
    if (matchNature(orchestration) == false) {
      throw new InvocationException(NLS.bind(ProducerMessages.OrchestrationManagerProducer_type_error, getOrchestration().eClass().getName(), orchestration.eClass().getName()));
    }
    return doCreateOrchestrationManager(parent, orchestration);
  }

  public boolean matchNature(Orchestration orchestration) {
    Assert.isNotNull(orchestration);
    Assert.isNotNull(getOrchestration());
    return getOrchestration() == EMFHelper.solveAgainstStaticPackage(orchestration.eClass());
  }

}
