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
package org.eclipse.model.domain.adapter;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class DomainTypeAdapter extends AdapterImpl {

  private DomainType _domainType;

  private Domain _domain;

  private EStructuralFeature _domainEPackageFeature = DomainPackage.Literals.DOMAIN__EPACKAGE;

  private EStructuralFeature _domainTypeEPackageFeature = DomainPackage.Literals.DOMAIN_TYPE__EPACKAGE;

  private EStructuralFeature _domainFeature = DomainPackage.Literals.DOMAIN_TYPE__DOMAIN;

  private AdapterImpl _domainAdapter = new AdapterImpl() {
    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_domainEPackageFeature)) {
        _domainType.eNotify(new ENotificationImpl((InternalEObject) _domainType, Notification.SET, _domainTypeEPackageFeature, null, _domainType.eGet(_domainTypeEPackageFeature, true)));
      } else if (msg.getEventType() == Notification.REMOVING_ADAPTER) {
        _domainType.eNotify(new ENotificationImpl((InternalEObject) _domainType, Notification.SET, _domainFeature, null, null));
        _domain = null;
      }
    }
  };

  public DomainTypeAdapter(DomainType domainType) {
    super();
    _domainType = domainType;
    _domainType.eAdapters().add(this);
  }

  @Override
  public void notifyChanged(Notification notification) {
    if (notification.getFeature() == null || notification.getFeature().equals(_domainFeature)) {
      switch (notification.getEventType()) {
      case Notification.RESOLVE:
        Domain newValue = (Domain) notification.getNewValue();
        Domain oldValue = (Domain) notification.getOldValue();
        if (oldValue != null) {
          oldValue.eAdapters().remove(_domainAdapter);
        }
        if (newValue != null) {
          newValue.eAdapters().add(_domainAdapter);
        }
        _domain = newValue;
        // Needed when there is an update from workspace and target platform.
        if (_domain != null) {
          _domainType.eNotify(new ENotificationImpl((InternalEObject) _domainType, Notification.SET, _domainFeature, null, _domain));
        }
        break;
      case Notification.REMOVING_ADAPTER:
        if (_domain != null) {
          _domain.eAdapters().remove(_domainAdapter);
        }
        break;
      default:
        return; // No notification
      }
    }
  }

}
