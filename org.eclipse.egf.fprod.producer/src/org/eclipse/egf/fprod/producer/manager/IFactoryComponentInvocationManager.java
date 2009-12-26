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
package org.eclipse.egf.fprod.producer.manager;

import org.eclipse.egf.fprod.producer.context.IFactoryComponentInvocationProductionContext;
import org.eclipse.egf.model.fprod.FactoryComponentInvocation;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IFactoryComponentInvocationManager extends IProductionPlanInvocationManager {

  public FactoryComponentInvocation getElement();

  public IFactoryComponentInvocationProductionContext getProductionContext();

}
