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
package org.eclipse.egf.model.domain.adapter;

import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.TypeDomainEPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeDomainEPackageAdapter extends AdapterImpl {

  private TypeDomainEPackage _typeDomainEPackage;

  private DomainEPackage _domainEPackage;

  private EStructuralFeature _domainEPackageFeature = DomainPackage.Literals.DOMAIN_EPACKAGE__EPACKAGE;

  private EStructuralFeature _typeDomainEPackageFeature = DomainPackage.Literals.TYPE_DOMAIN_EPACKAGE__VALUE;

  private EStructuralFeature _domainFeature = DomainPackage.Literals.TYPE_DOMAIN_EPACKAGE__DOMAIN;

  private AdapterImpl _domainEPackageAdapter = new AdapterImpl() {
    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_domainEPackageFeature)) {
        _typeDomainEPackage.eNotify(new ENotificationImpl((InternalEObject) _typeDomainEPackage, -1, _typeDomainEPackageFeature, null, null) {
          @Override
          public boolean isTouch() {
            return true;
          }
        });
      }
    }
  };

  public TypeDomainEPackageAdapter(TypeDomainEPackage typeDomainEPackage) {
    super();
    _typeDomainEPackage = typeDomainEPackage;
    _typeDomainEPackage.eAdapters().add(this);
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
        if (newValue != null && newValue.eAdapters().contains(_domainEPackageAdapter) == false) {
          newValue.eAdapters().add(_domainEPackageAdapter);
        }
        _domainEPackage = newValue;
        break;
      case Notification.REMOVING_ADAPTER:
        if (_domainEPackage != null) {
          _domainEPackage.eAdapters().remove(_domainEPackageAdapter);
        }
        break;
      default:
        return; // No notification
      }
    }
  }

}
