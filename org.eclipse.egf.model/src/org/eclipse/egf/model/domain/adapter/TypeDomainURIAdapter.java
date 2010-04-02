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

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeDomainURIAdapter extends AdapterImpl {

  private TransactionalEditingDomain _editingDomain;

  private TypeDomainURI _typeDomainURI;

  private DomainURI _domainURI;

  private EStructuralFeature _domainURIFeature = DomainPackage.Literals.DOMAIN_URI__URI;

  private EStructuralFeature _typeDomainURIFeature = DomainPackage.Literals.TYPE_DOMAIN_URI__VALUE;

  private EStructuralFeature _domainFeature = DomainPackage.Literals.TYPE_DOMAIN_URI__DOMAIN;

  private AdapterImpl _domainURIAdapter = new AdapterImpl() {
    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_domainURIFeature)) {
        _editingDomain.getCommandStack().execute(new RecordingCommand(_editingDomain) {
          @Override
          protected void doExecute() {
            _typeDomainURI.eNotify(new ENotificationImpl((InternalEObject) _typeDomainURI, Notification.SET, _typeDomainURIFeature, null, _typeDomainURI.eGet(_typeDomainURIFeature, true)));
          }
        });
      }
    }
  };

  public TypeDomainURIAdapter(TypeDomainURI typeDomainURI) {
    super();
    _typeDomainURI = typeDomainURI;
    _typeDomainURI.eAdapters().add(this);
    _editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
  }

  @Override
  public void notifyChanged(Notification notification) {
    if (notification.getFeature() == null || notification.getFeature().equals(_domainFeature)) {
      switch (notification.getEventType()) {
      case Notification.SET:
        DomainURI newValue = (DomainURI) notification.getNewValue();
        DomainURI oldValue = (DomainURI) notification.getOldValue();
        if (oldValue != null) {
          oldValue.eAdapters().remove(_domainURIAdapter);
        }
        if (newValue != null && newValue.eAdapters().contains(_domainURIAdapter) == false) {
          newValue.eAdapters().add(_domainURIAdapter);
        }
        _domainURI = newValue;
        break;
      case Notification.REMOVING_ADAPTER:
        if (_domainURI != null) {
          _domainURI.eAdapters().remove(_domainURIAdapter);
        }
        break;
      default:
        return; // No notification
      }
    }
  }

}
