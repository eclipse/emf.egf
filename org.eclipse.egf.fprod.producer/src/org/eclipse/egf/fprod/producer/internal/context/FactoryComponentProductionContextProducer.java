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
package org.eclipse.egf.fprod.producer.internal.context;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.fprod.producer.context.IFactoryComponentInvocationProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.context.IInvocationProductionContext;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentProductionContextProducer extends ActivityProductionContextProducer {

  @Override
  public EClass getActivity() {
    return FcorePackage.Literals.FACTORY_COMPONENT;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Class<FactoryComponentInvocationProductionContext> getParentProductionContext() {
    return FactoryComponentInvocationProductionContext.class;
  }

  @Override
  protected IFactoryComponentProductionContext doCreateActivityProductionContext(IInvocationProductionContext parent, Activity activity, ProjectBundleSession projectBundleSession) throws InvocationException {
    return FprodProducerContextFactory.createContext((IFactoryComponentInvocationProductionContext) parent, (FactoryComponent) activity, projectBundleSession);
  }
}
