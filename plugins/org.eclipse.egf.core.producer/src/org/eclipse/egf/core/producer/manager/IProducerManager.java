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
package org.eclipse.egf.core.producer.manager;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.emf.common.util.Diagnostic;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProducerManager<P extends Object, T extends Object> {

    public P getElement();

    public IProducerManager<?, ?> getParent();

    public Diagnostic canInvoke() throws InvocationException;

    public IProductionContext<P, T> getProductionContext() throws InvocationException;

    public ProjectBundleSession getProjectBundleSession();

    public void setProjectBundleSession(ProjectBundleSession session);

    public Bundle getBundle() throws InvocationException;

    public void initializeContext() throws InvocationException;

    public Diagnostic invoke(IProgressMonitor monitor) throws InvocationException;

    public int getSteps() throws InvocationException;

    public void dispose() throws InvocationException;

}
