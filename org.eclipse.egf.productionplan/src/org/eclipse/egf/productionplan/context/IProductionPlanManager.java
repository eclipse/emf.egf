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
package org.eclipse.egf.productionplan.context;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.fcore.ModelElement;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProductionPlanManager<Q extends IProductionPlanManager<?, ?>, T extends ModelElement> {

  public String getName();

  public void init() throws InvocationException;

  public int getSteps() throws InvocationException;

  public T getElement();

  public Q getParent();

  public IProductionContext<T> getProductionContext() throws InvocationException;

  public Bundle getBundle() throws InvocationException;

  public void invoke(IProgressMonitor monitor) throws InvocationException;

}
