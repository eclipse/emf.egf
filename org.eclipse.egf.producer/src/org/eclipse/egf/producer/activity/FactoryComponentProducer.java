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
package org.eclipse.egf.producer.activity;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.producer.internal.manager.FactoryComponentManagerFactory;
import org.eclipse.egf.producer.manager.IActivityManagerFactory;
import org.eclipse.egf.producer.manager.IModelProducerManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentProducer extends ActivityProducer<FactoryComponent> {

  private static final FactoryComponent __factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();

  private final IActivityManagerFactory<FactoryComponent> _manager = new FactoryComponentManagerFactory();

  @Override
  public FactoryComponent getActivity() {
    return __factoryComponent;
  }

  @Override
  protected IModelProducerManager<FactoryComponent> doCreateManager(FactoryComponent factoryComponent) throws InvocationException {
    return _manager.createProductionManager(factoryComponent);
  }

  @Override
  protected IModelProducerManager<FactoryComponent> doCreateManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
    return _manager.createProductionManager(bundle, factoryComponent);
  }

  @Override
  protected IModelProducerManager<FactoryComponent> doCreateManager(IModelProducerManager<?> parent, FactoryComponent factoryComponent) throws InvocationException {
    return _manager.createProductionManager(parent, factoryComponent);
  }

}
