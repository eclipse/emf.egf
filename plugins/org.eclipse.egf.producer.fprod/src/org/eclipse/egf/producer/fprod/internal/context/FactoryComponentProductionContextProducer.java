/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.fprod.internal.context;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentProductionContextProducer extends ActivityProductionContextProducer<FactoryComponent> {

  @Override
  public EClass getActivity() {
    return FcorePackage.Literals.FACTORY_COMPONENT;
  }

  @Override
  protected IFactoryComponentProductionContext doCreateActivityProductionContext(ProjectBundleSession projectBundleSession, Activity element) throws InvocationException {
    return ProducerFprodContextFactory.createContext(projectBundleSession, (FactoryComponent) element);
  }

  @Override
  protected IFactoryComponentProductionContext doCreateActivityProductionContext(IProductionContext<Invocation, InvocationContract> parent, ProjectBundleSession projectBundleSession, Activity element) throws InvocationException {
    return ProducerFprodContextFactory.createContext(parent, projectBundleSession, (FactoryComponent) element);
  }

}
