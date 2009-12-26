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
package org.eclipse.egf.fprod.producer.activity;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.fprod.producer.internal.context.FactoryComponentInvocationProductionContext;
import org.eclipse.egf.fprod.producer.internal.context.FprodProducerContextFactory;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.producer.activity.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IModelElementProductionContext;
import org.eclipse.egf.producer.internal.context.FactoryComponentProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentProductionContextProducer extends ActivityProductionContextProducer<FactoryComponentProductionContext> {

  private static final FactoryComponent __factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();

  @Override
  public FactoryComponent getActivity() {
    return __factoryComponent;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Class<FactoryComponentInvocationProductionContext> getParentProductionContext() {
    return FactoryComponentInvocationProductionContext.class;
  }

  @Override
  protected FactoryComponentProductionContext doCreateActivityProductionContext(IModelElementProductionContext<?> parent, Activity activity, ProjectBundleSession projectBundleSession) throws InvocationException {
    return FprodProducerContextFactory.createContext(parent, (FactoryComponent) activity, projectBundleSession);
  }
}
