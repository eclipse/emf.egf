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
package org.eclipse.egf.producer.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
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

  public static IFactoryComponentManager createProductionManager(FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(factoryComponent);
  }

  public static IFactoryComponentManager createProductionManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(bundle, factoryComponent);
  }

}
