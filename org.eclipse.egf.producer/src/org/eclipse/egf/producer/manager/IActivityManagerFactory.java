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
import org.eclipse.egf.model.fcore.Activity;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IActivityManagerFactory<T extends Activity> {

  public IModelProducerManager<T> createProductionManager(T activity) throws InvocationException;

  public IModelProducerManager<T> createProductionManager(Bundle bundle, T activity) throws InvocationException;

  public IModelProducerManager<T> createProductionManager(IModelProducerManager<?> parent, T activity) throws InvocationException;

}
