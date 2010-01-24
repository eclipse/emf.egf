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
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.helper.BundleSessionHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ModelElementManager<P extends ModelElement, T extends ModelElement> implements IModelElementManager<P, T> {

  protected static BasicDiagnostic getDiagnostic(ModelElement element) {
    String message = null;
    if (element instanceof NamedModelElement) {
      NamedModelElement namedElement = (NamedModelElement) element;
      if (namedElement.getName() != null && namedElement.getName().trim().length() != 0) {
        message = NLS.bind(ProducerMessages._UI_CanInvoke_Diagnosis_message, namedElement.getName());
      }
    }
    if (message == null) {
      message = NLS.bind(ProducerMessages._UI_CanInvoke_Diagnosis_message, element.eClass().getName());
    }
    return new BasicDiagnostic(EGFProducerPlugin.getDefault().getPluginID(), 0, message, new Object[] { element });
  }

  private P _element;

  protected IModelElementManager<?, ?> _parent;

  protected IProductionContext<P, T> _productionContext;

  private Bundle _bundle;

  private ProjectBundleSession _projectBundleSession;

  private IPlatformFcore _platformFcore;

  public ModelElementManager(P element) throws InvocationException {
    Assert.isNotNull(element);
    _element = element;
    _platformFcore = EGFCorePlugin.getPlatformFcore(element.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProducerMessages.ActivityManager_fcore_activity, getName()), null)));
    }
  }

  public ModelElementManager(Bundle bundle, P element) {
    Assert.isNotNull(bundle);
    Assert.isNotNull(element);
    _bundle = bundle;
    _element = element;
  }

  public ModelElementManager(IModelElementManager<?, ?> parent, P element) throws InvocationException {
    Assert.isNotNull(parent);
    Assert.isNotNull(element);
    _parent = parent;
    _element = element;
    _platformFcore = EGFCorePlugin.getPlatformFcore(element.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProducerMessages.ActivityManager_fcore_activity, getName()), null)));
    }
  }

  public P getElement() {
    return _element;
  }

  public IProductionContext<P, T> getProductionContext() throws InvocationException {
    return getInternalProductionContext();
  }

  public IModelElementManager<?, ?> getParent() {
    return _parent;
  }

  protected abstract ProductionContext<P, T> getInternalProductionContext() throws InvocationException;

  public String getName() {
    return EMFHelper.getText(getElement());
  }

  public Bundle getBundle() throws InvocationException {
    // Platform
    if (_platformFcore != null) {
      try {
        return BundleSessionHelper.getBundle(getProjectBundleSession(), _platformFcore);
      } catch (Throwable t) {
        throw new InvocationException(t);
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

  @SuppressWarnings("unused")
  protected BasicDiagnostic canInvokeElement() throws InvocationException {
    return getDiagnostic(getElement());
  }

  public Diagnostic canInvoke() throws InvocationException {
    return canInvokeElement();
  }

  public abstract void initializeContext() throws InvocationException;

  public void dispose() throws InvocationException {
    if (_projectBundleSession != null) {
      try {
        _projectBundleSession.dispose();
      } catch (Throwable t) {
        throw new InvocationException(t);
      }
    }
  }

}
