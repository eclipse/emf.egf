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

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanInvocationAdapter extends AdapterImpl {

  private ProductionPlanInvocation _productionPlanInvocation;

  private Activity _activity;

  private EStructuralFeature _nameFeature = FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME;

  private EStructuralFeature _invocationInvokedActivityFeature = FcorePackage.Literals.INVOCATION__INVOKED_ACTIVITY;

  private AdapterImpl _activityAdapter = new AdapterImpl() {
    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_nameFeature)) {
        _productionPlanInvocation.eNotify(new ENotificationImpl((InternalEObject) _productionPlanInvocation, Notification.SET, _invocationInvokedActivityFeature, null, _productionPlanInvocation.eGet(_invocationInvokedActivityFeature, true)));
      } else if (msg.getEventType() == Notification.REMOVING_ADAPTER) {
        _activity = null;
      }
    }
  };

  public ProductionPlanInvocationAdapter(ProductionPlanInvocation productionPlanInvocation) {
    super();
    _productionPlanInvocation = productionPlanInvocation;
    _productionPlanInvocation.eAdapters().add(this);
  }

  @Override
  public void notifyChanged(Notification notification) {
    if (notification.getFeature() == null || notification.getFeature().equals(_invocationInvokedActivityFeature)) {
      switch (notification.getEventType()) {
      case Notification.RESOLVE:
        Activity newValue = (Activity) notification.getNewValue();
        Activity oldValue = (Activity) notification.getOldValue();
        if (oldValue != null) {
          oldValue.eAdapters().remove(_activityAdapter);
        }
        if (newValue != null) {
          newValue.eAdapters().add(_activityAdapter);
        }
        _activity = newValue;
        // Needed when there is an update from workspace and target platform.
        if (_activity != null) {
          _productionPlanInvocation.eNotify(new ENotificationImpl((InternalEObject) _productionPlanInvocation, Notification.SET, _invocationInvokedActivityFeature, null, _activity));
        }
        break;
      case Notification.REMOVING_ADAPTER:
        if (_activity != null) {
          _activity.eAdapters().remove(_activityAdapter);
        }
        break;
      default:
        return; // No notification
      }
    }
  }

}
