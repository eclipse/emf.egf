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
import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.osgi.framework.Bundle;

/**
 * 
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanContext extends ModelElementContext<ProductionPlan> {

  public ProductionPlanContext(ProductionPlan productionPlan) {
    super(productionPlan);
  }

  @Override
  public void init(Bundle bundle) throws InvocationException {
    // Usuals tests
    if (getElement().getInvocations() == null) {
      return;
    }
    // Init Maps
    super.init(bundle);
  }

}
