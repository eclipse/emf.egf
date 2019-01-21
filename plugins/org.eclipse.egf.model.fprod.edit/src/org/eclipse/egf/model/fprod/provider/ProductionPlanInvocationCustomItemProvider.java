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

import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.emf.common.notify.AdapterFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanInvocationCustomItemProvider extends ProductionPlanInvocationItemProvider {

  /**
   * This constructs an instance from a factory and a notifier.
   */
  public ProductionPlanInvocationCustomItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the label text for the adapted class.
   */
  @Override
  public String getText(Object object) {
    String label = ((ProductionPlanInvocation) object).getName();
    return label == null || label.length() == 0 ? "[" + getString("_UI_ProductionPlanInvocation_type") + "]" : //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        label + " [" + getString("_UI_ProductionPlanInvocation_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  }

}
