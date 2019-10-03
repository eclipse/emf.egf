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
package org.eclipse.egf.producer.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.producer.internal.manager.FactoryComponentManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManagerFactory {

  private FactoryComponentManagerFactory() {
    // Prevent Instantiation
  }

  public static IActivityManager<FactoryComponent> createProductionManager(FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(factoryComponent);
  }

  public static IActivityManager<FactoryComponent> createProductionManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(bundle, factoryComponent);
  }

  public static <T extends Invocation> IActivityManager<FactoryComponent> createProductionManager(IModelElementManager<T, InvocationContract> parent, FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(parent, factoryComponent);
  }

}
