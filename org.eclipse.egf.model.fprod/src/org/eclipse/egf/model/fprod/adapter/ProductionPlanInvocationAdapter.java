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
package org.eclipse.egf.model.fprod.adapter;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanInvocationAdapter extends AdapterImpl {

  private TransactionalEditingDomain _editingDomain;

  private ProductionPlanInvocation _productionPlanInvocation;

  private Activity _activity;

  private EStructuralFeature _nameFeature = FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME;

  private EStructuralFeature _invocationInvokedActivityFeature = FcorePackage.Literals.INVOCATION__INVOKED_ACTIVITY;

  private AdapterImpl _activityAdapter = new AdapterImpl() {
    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_nameFeature)) {
        _editingDomain.getCommandStack().execute(new RecordingCommand(_editingDomain) {
          @Override
          protected void doExecute() {
            _productionPlanInvocation.eNotify(new ENotificationImpl((InternalEObject) _productionPlanInvocation, Notification.SET, _invocationInvokedActivityFeature, null, _activity));
          }
        });
      } else if (msg.getEventType() == Notification.REMOVING_ADAPTER) {
        if (_activity != null) {
          // Reset proxies
          ((InternalEObject) _activity).eSetProxyURI(EcoreUtil.getURI(_activity));
          _activity = null;
        }
      }
    }
  };

  public ProductionPlanInvocationAdapter(ProductionPlanInvocation productionPlanInvocation) {
    super();
    _productionPlanInvocation = productionPlanInvocation;
    _productionPlanInvocation.eAdapters().add(this);
    _editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
  }

  @Override
  public void notifyChanged(Notification notification) {
    if (notification.getFeature() == null || notification.getFeature().equals(_invocationInvokedActivityFeature)) {
      switch (notification.getEventType()) {
      case Notification.RESOLVE:
        final Activity newValue = (Activity) notification.getNewValue();
        final Activity oldValue = (Activity) notification.getOldValue();
        if (oldValue != null) {
          oldValue.eAdapters().remove(_activityAdapter);
        }
        if (newValue != null) {
          newValue.eAdapters().add(_activityAdapter);
        }
        _activity = newValue;
        break;
      case Notification.REMOVING_ADAPTER:
        if (_activity != null) {
          _activity.eAdapters().remove(_activityAdapter);
          // Reset proxies
          ((InternalEObject) _activity).eSetProxyURI(EcoreUtil.getURI(_activity));
        }
        break;
      default:
        return; // No notification
      }
    }
  }
}
