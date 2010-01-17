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
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.FactoryComponentManagerFactory;
import org.eclipse.egf.producer.manager.IFactoryComponentManager;
import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManagerProducer extends ActivityManagerProducer {

  @Override
  public EClass getActivity() {
    return FcorePackage.Literals.FACTORY_COMPONENT;
  }

  @Override
  protected IFactoryComponentManager doCreateActivityManager(Activity activity) throws InvocationException {
    return FactoryComponentManagerFactory.createProductionManager((FactoryComponent) activity);
  }

  @Override
  protected IFactoryComponentManager doCreateActivityManager(Bundle bundle, Activity activity) throws InvocationException {
    return FactoryComponentManagerFactory.createProductionManager(bundle, (FactoryComponent) activity);
  }

}
