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
package org.eclipse.egf.producer.internal.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.producer.manager.IActivityManagerFactory;
import org.eclipse.egf.producer.manager.IModelProducerManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManagerFactory implements IActivityManagerFactory<FactoryComponent> {

  public IModelProducerManager<FactoryComponent> createProductionManager(FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(factoryComponent);
  }

  public IModelProducerManager<FactoryComponent> createProductionManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(bundle, factoryComponent);
  }

  public IModelProducerManager<FactoryComponent> createProductionManager(IModelProducerManager<?> parent, FactoryComponent factoryComponent) throws InvocationException {
    return new FactoryComponentManager(parent, factoryComponent);
  }

}
