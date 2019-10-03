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
package org.eclipse.egf.producer.internal.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.FactoryComponentManagerFactory;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManagerProducer extends ActivityManagerProducer<FactoryComponent> {

    @Override
    public EClass getActivity() {
        return FcorePackage.Literals.FACTORY_COMPONENT;
    }

    @Override
    protected IActivityManager<FactoryComponent> doCreateActivityManager(FactoryComponent factoryComponent) throws InvocationException {
        return FactoryComponentManagerFactory.createProductionManager(factoryComponent);
    }

    @Override
    protected IActivityManager<FactoryComponent> doCreateActivityManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
        return FactoryComponentManagerFactory.createProductionManager(bundle, factoryComponent);
    }

    @Override
    protected <T extends Invocation> IActivityManager<FactoryComponent> doCreateActivityManager(IModelElementManager<T, InvocationContract> parent, FactoryComponent factoryComponent) throws InvocationException {
        return FactoryComponentManagerFactory.createProductionManager(parent, factoryComponent);
    }

}
