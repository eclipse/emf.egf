/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.model.fprod.provider;

import org.eclipse.emf.common.notify.Adapter;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FprodCustomItemProviderAdapterFactory extends FprodItemProviderAdapterFactory {

  /**
   * This constructs an instance.
   */
  public FprodCustomItemProviderAdapterFactory() {
    super();
  }

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.fprod.ProductionPlanInvocation}.
   */
  @Override
  public Adapter createProductionPlanInvocationAdapter() {
    if (productionPlanInvocationItemProvider == null) {
      productionPlanInvocationItemProvider = new ProductionPlanInvocationCustomItemProvider(this);
    }
    return productionPlanInvocationItemProvider;
  }

}
