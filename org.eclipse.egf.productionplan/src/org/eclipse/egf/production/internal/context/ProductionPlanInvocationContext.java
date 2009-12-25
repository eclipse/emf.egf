/**
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
 */
package org.eclipse.egf.production.internal.context;

import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.model.fcore.ContextContainer;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;
import org.osgi.framework.Bundle;

/**
 * 
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanInvocationContext<T extends ProductionPlanInvocation<?>> extends ModelElementContext<T> {

  public ProductionPlanInvocationContext(T productionPlanInvocation) {
    super(productionPlanInvocation);
  }

  @Override
  public void init(Bundle bundle) throws InvocationException {
    // Usuals tests
    if (getElement().getContextContainer() == null) {
      return;
    }
    ContextContainer contextContainer = getElement().getContextContainer();
    if (contextContainer.getContexts() == null) {
      return;
    }
    // Init Maps
    super.init(bundle);
  }

}
