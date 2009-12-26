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

import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainEPackageType;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class DomainEPackageTypeAdapter extends AdapterImpl {

  private DomainEPackageType _domainEPackageType;

  private EStructuralFeature _domainEPackageFeature = DomainPackage.Literals.DOMAIN_EPACKAGE__EPACKAGE;

  private EStructuralFeature _domainTypeEPackageFeature = DomainPackage.Literals.DOMAIN_EPACKAGE_TYPE__EPACKAGE;

  private EStructuralFeature _domainFeature = DomainPackage.Literals.DOMAIN_EPACKAGE_TYPE__VALUE;

  private AdapterImpl _domainEPackageAdapter = new AdapterImpl() {
    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_domainEPackageFeature)) {
        _domainEPackageType.eNotify(new ENotificationImpl((InternalEObject) _domainEPackageType, Notification.SET, _domainTypeEPackageFeature, null, _domainEPackageType.eGet(_domainTypeEPackageFeature, true)));
      } else if (msg.getEventType() == Notification.REMOVING_ADAPTER) {
        _domainEPackageType.eNotify(new ENotificationImpl((InternalEObject) _domainEPackageType, Notification.SET, _domainFeature, null, null));
      }
    }
  };

  public DomainEPackageTypeAdapter(DomainEPackageType domainEPackageType) {
    super();
    _domainEPackageType = domainEPackageType;
    _domainEPackageType.eAdapters().add(this);
  }

  @Override
  public void notifyChanged(Notification notification) {
    if (notification.getFeature() == null || notification.getFeature().equals(_domainFeature)) {
      switch (notification.getEventType()) {
      case Notification.SET:
        DomainEPackage newValue = (DomainEPackage) notification.getNewValue();
        DomainEPackage oldValue = (DomainEPackage) notification.getOldValue();
        if (oldValue != null) {
          oldValue.eAdapters().remove(_domainEPackageAdapter);
        }
        if (newValue != null) {
          newValue.eAdapters().add(_domainEPackageAdapter);
        }
        break;
      default:
        return; // No notification
      }
    }
  }

}
