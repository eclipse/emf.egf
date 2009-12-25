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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.helper.BundleSessionHelper;
import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.IModelProducerManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class AbstractManager<T extends ModelElement> implements IModelProducerManager<T> {

  private IModelProducerManager<?> _parent;

  private T _element;

  private Bundle _bundle;

  private ProjectBundleSession _projectBundleSession;

  protected IProductionContext<T> _productionContext;

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

  public AbstractManager(IModelProducerManager<?> parent, T element) {
    Assert.isNotNull(parent);
    Assert.isNotNull(element);
    _parent = parent;
    _element = element;
  }

  public T getElement() {
    return _element;
  }

  public IModelProducerManager<?> getParent() {
    return _parent;
  }

  public String getName() {
    return EObjectHelper.getText(getElement());
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

  public ProjectBundleSession getProjectBundleSession() {
    if (getParent() != null) {
      return getParent().getProjectBundleSession();
    }
    if (_projectBundleSession == null) {
      _projectBundleSession = new ProjectBundleSession(EGFProducerPlugin.getDefault().getBundle().getBundleContext());
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
