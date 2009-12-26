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
package org.eclipse.egf.producer.internal.context;

import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.context.IModelElementProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentProductionContext extends ActivityProductionContext implements IFactoryComponentProductionContext {

  public FactoryComponentProductionContext(FactoryComponent element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public FactoryComponentProductionContext(IModelElementProductionContext<?> parent, FactoryComponent element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public FactoryComponent getElement() {
    return (FactoryComponent) super.getElement();
  }

}
