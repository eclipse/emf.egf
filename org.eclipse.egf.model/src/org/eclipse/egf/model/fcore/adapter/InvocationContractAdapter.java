/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.adapter;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class InvocationContractAdapter extends AdapterImpl {

  private InvocationContract _invocationContract;

  private Contract _contract;

  private EStructuralFeature _nameFeature = FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME;

  private EStructuralFeature _contractModeFeature = FcorePackage.Literals.CONTRACT__MODE;

  private EStructuralFeature _invocationContractInvokedContractFeature = FcorePackage.Literals.INVOCATION_CONTRACT__INVOKED_CONTRACT;

  private AdapterImpl _contractAdapter = new AdapterImpl() {
    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_contractModeFeature)) {
        _invocationContract.eNotify(new ENotificationImpl((InternalEObject) _invocationContract, -1, _invocationContractInvokedContractFeature, null, null) {
          @Override
          public boolean isTouch() {
            return true;
          }
        });
      } else if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_nameFeature)) {
        _invocationContract.eNotify(new ENotificationImpl((InternalEObject) _invocationContract, -1, _invocationContractInvokedContractFeature, null, null) {
          @Override
          public boolean isTouch() {
            return true;
          }
        });
      }
    }
  };

  private AdapterImpl _contractResourceAdapter = new AdapterImpl() {
    @Override
    public void notifyChanged(final Notification notification) {
      // URI update while moving a resource
      if (notification.getEventType() == Notification.SET) {
        switch (notification.getFeatureID(Resource.class)) {
        case Resource.RESOURCE__URI: {
          if (_invocationContract.eResource() != null) {
            final ResourceImpl resource = (ResourceImpl) _invocationContract.eResource();
            IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(resource);
            // target fcore can't be modified, give a chance to read only workspace resource to do something
            if (fcore != null && fcore.getPlatformBundle().isTarget() == false) {
              resource.setModified(true);
              if (resource.eNotificationRequired()) {
                Notification innerNotification = new NotificationImpl(Notification.SET, notification.getOldValue(), notification.getOldValue()) {
                  @Override
                  public Object getFeature() {
                    return notification.getNotifier();
                  }

                  @Override
                  public Object getNotifier() {
                    return resource;
                  }

                  @Override
                  public int getFeatureID(Class<?> expectedClass) {
                    return Resource.RESOURCE__URI;
                  }
                };
                resource.eNotify(innerNotification);
              }
            }
          }
          break;
        }
        }
      }
    }
  };

  public InvocationContractAdapter(InvocationContract invocationContract) {
    super();
    _invocationContract = invocationContract;
    _invocationContract.eAdapters().add(this);
  }

  @Override
  public void notifyChanged(Notification notification) {
    if (notification.getFeature() == null || notification.getFeature().equals(_invocationContractInvokedContractFeature)) {
      switch (notification.getEventType()) {
      case Notification.RESOLVE:
        Contract newValue = (Contract) notification.getNewValue();
        Contract oldValue = (Contract) notification.getOldValue();
        if (oldValue != null) {
          if (oldValue.eResource() != null) {
            oldValue.eResource().eAdapters().remove(_contractResourceAdapter);
          }
          oldValue.eAdapters().remove(_contractAdapter);
        }
        if (newValue != null) {
          if (newValue.eResource() != null && newValue.eResource().eAdapters().contains(_contractResourceAdapter) == false) {
            newValue.eResource().eAdapters().add(_contractResourceAdapter);
          }
          if (newValue.eAdapters().contains(_contractAdapter) == false) {
            newValue.eAdapters().add(_contractAdapter);
          }
        }
        _contract = newValue;
        break;
      case Notification.REMOVING_ADAPTER:
        if (_contract != null) {
          _contract.eAdapters().remove(_contractAdapter);
        }
        break;
      default:
        return; // No notification
      }
    }
  }

}
