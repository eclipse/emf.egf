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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.helper.BundleSessionHelper;
import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.IModelElementProductionContext;
import org.eclipse.egf.producer.internal.context.ModelElementProductionContext;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ModelElementManager implements IModelElementManager {

  private ModelElement _element;

  protected IModelElementManager _parent;

  protected IModelElementProductionContext<?> _productionContext;

  private Bundle _bundle;

  private ProjectBundleSession _projectBundleSession;

  private IPlatformFcore _platformFcore;

  public ModelElementManager(ModelElement element) throws InvocationException {
    Assert.isNotNull(element);
    _element = element;
    _platformFcore = EGFCorePlugin.getPlatformFcore(element.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProducerMessages.ActivityManager_fcore_activity, getName()), null)));
    }
    prepare();
  }

  public ModelElementManager(Bundle bundle, ModelElement element) throws InvocationException {
    Assert.isNotNull(bundle);
    Assert.isNotNull(element);
    _bundle = bundle;
    _element = element;
    prepare();
  }

  public ModelElementManager(IModelElementManager parent, ModelElement element) throws InvocationException {
    Assert.isNotNull(parent);
    Assert.isNotNull(element);
    _parent = parent;
    _element = element;
    _platformFcore = EGFCorePlugin.getPlatformFcore(element.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProducerMessages.ActivityManager_fcore_activity, getName()), null)));
    }
    prepare();
  }

  public ModelElement getElement() {
    return _element;
  }

  public IModelElementProductionContext<?> getProductionContext() {
    return _productionContext;
  }

  public IModelElementManager getParent() {
    return _parent;
  }

  protected abstract ModelElementProductionContext<?> getInternalProductionContext() throws InvocationException;

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

  public void prepare() throws InvocationException {
    getProductionContext().clear();
  }

  protected void dispose() throws CoreException {
    if (_projectBundleSession != null) {
      _projectBundleSession.dispose();
      _projectBundleSession = null;
    }
  }

}
