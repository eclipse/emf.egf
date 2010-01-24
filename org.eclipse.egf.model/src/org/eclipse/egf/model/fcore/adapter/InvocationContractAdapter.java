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
package org.eclipse.egf.model.fcore.adapter;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
        _invocationContract.eNotify(new ENotificationImpl((InternalEObject) _invocationContract, Notification.SET, _invocationContractInvokedContractFeature, null, _invocationContract.eGet(_invocationContractInvokedContractFeature, true)));
      } else if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_nameFeature)) {
        _invocationContract.eNotify(new ENotificationImpl((InternalEObject) _invocationContract, Notification.SET, _invocationContractInvokedContractFeature, null, _invocationContract.eGet(_invocationContractInvokedContractFeature, true)));
      } else if (msg.getEventType() == Notification.REMOVING_ADAPTER) {
        _contract = null;
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
          oldValue.eAdapters().remove(_contractAdapter);
        }
        if (newValue != null) {
          newValue.eAdapters().add(_contractAdapter);
        }
        _contract = newValue;
        // Needed when there is an update from workspace and target platform.
        if (_contract != null) {
          _invocationContract.eNotify(new ENotificationImpl((InternalEObject) _invocationContract, Notification.SET, _invocationContractInvokedContractFeature, null, _contract));
        }
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
