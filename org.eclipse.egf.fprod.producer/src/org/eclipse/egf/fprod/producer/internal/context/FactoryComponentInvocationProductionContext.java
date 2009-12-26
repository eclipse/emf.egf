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

import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.fprod.producer.context.IFactoryComponentInvocationProductionContext;
import org.eclipse.egf.model.fprod.FactoryComponentInvocation;
import org.eclipse.egf.producer.context.IModelElementProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentInvocationProductionContext extends ProductionPlanInvocationProductionContext implements IFactoryComponentInvocationProductionContext {

  public FactoryComponentInvocationProductionContext(FactoryComponentInvocation element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public FactoryComponentInvocationProductionContext(IModelElementProductionContext<?> parent, FactoryComponentInvocation element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public FactoryComponentInvocation getElement() {
    return (FactoryComponentInvocation) super.getElement();
  }

}
