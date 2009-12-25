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
package org.eclipse.egf.production.internal.context;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.session.BundleSessionHelper;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.context.IProductionPlanManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class AbstractManager<Q extends AbstractManager<?, ?>, T extends ModelElement> implements IProductionPlanManager<Q, T> {

  private Q _parent;

  private T _element;

  private Bundle _bundle;

  private ProjectBundleSession _projectBundleSession;

  protected ModelElementContext<T> _modelElementContext;

  protected IPlatformFcore _platformFcore;

  public AbstractManager(T element) {
    Assert.isNotNull(element);
    _element = element;
  }

  public AbstractManager(Bundle bundle, T element) {
    Assert.isNotNull(bundle);
    Assert.isNotNull(element);
    _bundle = bundle;
    _element = element;
  }

  public AbstractManager(Q parent, T element) {
    Assert.isNotNull(parent);
    Assert.isNotNull(element);
    _parent = parent;
    _element = element;
  }

  public T getElement() {
    return _element;
  }

  public Q getParent() {
    return _parent;
  }

  public String getName() {
    return getElement().getExternalName() != null ? getElement().getExternalName() : "Unknown"; //$NON-NLS-1$
  }

  public Bundle getBundle() throws InvocationException {
    // Platform
    if (_platformFcore != null) {
      try {
        return BundleSessionHelper.getBundle(getProjectBundleSession(), _platformFcore);
      } catch (CoreException ce) {
        throw new InvocationException(ce);
      }
    }
    // Always from parent
    if (getParent() != null) {
      return getParent().getBundle();
    }
    // Parent
    return _bundle;
  }

  protected IProductionContext<?> getParentProductionContext() {
    if (_parent != null) {
      return _parent.getParentProductionContext();
    }
    return null;
  }

  protected ProjectBundleSession getProjectBundleSession() {
    if (getParent() != null) {
      return getParent().getProjectBundleSession();
    }
    if (_projectBundleSession == null) {
      _projectBundleSession = new ProjectBundleSession(EGFProductionPlanPlugin.getDefault().getBundle().getBundleContext());
    }
    return _projectBundleSession;
  }

  protected void dispose() throws CoreException {
    if (_projectBundleSession != null) {
      _projectBundleSession.dispose();
      _projectBundleSession = null;
    }
  }

}
