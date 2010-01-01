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
package org.eclipse.egf.core.producer.manager;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProducerManager {

  public Object getElement();

  public IProducerManager getParent();

  public IProductionContext<?> getProductionContext();

  public ProjectBundleSession getProjectBundleSession();

  public Bundle getBundle() throws InvocationException;

  public void initializeContext() throws InvocationException;

  public void invoke(IProgressMonitor monitor) throws InvocationException;

  public int getSteps() throws InvocationException;

  public void dispose() throws InvocationException;

}
