/**
 * 
 * Copyright (c) 2002-2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.egf.common.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * @author http://wiki.eclipse.org/EMF/Recipes#Recipe:_Derived_Attribute_Notifier
 * 
 */
public class DerivedAttributeAdapter extends AdapterImpl {

  private final InternalEObject _source;

  private final EStructuralFeature _derivedFeature;

  private List<EStructuralFeature> _localFeatures = new ArrayList<EStructuralFeature>();

  // TODO this lot could be put into a subclass and put in a list to allow for
  // multiple navigated dependencies
  private EStructuralFeature _dependantFeature = null;

  private EStructuralFeature _navigationFeature = null;

  private AdapterImpl dependantAdapter = new AdapterImpl() {

    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_dependantFeature)) {
        notifyDerivedAttributeChange();
      }
    }
  };

  /*
   * Convenience constructor for a local and navigated dependency
   */
  public DerivedAttributeAdapter(EObject source, EStructuralFeature derivedFeature, EStructuralFeature navigationFeature, EStructuralFeature dependantFeature, EStructuralFeature localFeature) {
    this(source, derivedFeature);
    addNavigatedDependency(navigationFeature, dependantFeature);
    addLocalDependency(localFeature);
  }

  /*
   * Convenience constructor for a navigated dependency
   */
  public DerivedAttributeAdapter(EObject source, EStructuralFeature derivedFeature, EStructuralFeature navigationFeature, EStructuralFeature dependantFeature) {
    this(source, derivedFeature);
    addNavigatedDependency(navigationFeature, dependantFeature);
  }

  /*
   * Convenience constructor for a local dependency
   */
  public DerivedAttributeAdapter(EObject source, EStructuralFeature derivedFeature, EStructuralFeature localFeature) {
    this(source, derivedFeature);
    addLocalDependency(localFeature);
  }

  public DerivedAttributeAdapter(EObject source, EStructuralFeature derivedFeature) {
    super();
    _source = (InternalEObject) source;
    _derivedFeature = derivedFeature;
    source.eAdapters().add(this);
  }

  public void addNavigatedDependency(EStructuralFeature navigationFeature, EStructuralFeature dependantFeature) {
    _dependantFeature = dependantFeature;
    _navigationFeature = navigationFeature;
  }

  public void addLocalDependency(EStructuralFeature localFeature) {
    _localFeatures.add(localFeature);
  }

  @Override
  public void notifyChanged(Notification notification) {
    if (notification.getFeature().equals(_navigationFeature)) {
      switch (notification.getEventType()) {
      // TODO support ADD_MANY/REMOVE_MANY?
      case Notification.ADD:
        EObject added = (EObject) notification.getNewValue();
        added.eAdapters().add(dependantAdapter);
        break;
      case Notification.SET:
        EObject newValue = (EObject) notification.getNewValue();
        EObject oldValue = (EObject) notification.getOldValue();
        if (oldValue != null) {
          oldValue.eAdapters().remove(dependantAdapter);
        }
        if (newValue != null) {
          newValue.eAdapters().add(dependantAdapter);
        }
        break;
      case Notification.REMOVE:
        EObject removed = (EObject) notification.getOldValue();
        removed.eAdapters().remove(dependantAdapter);
        break;
      default:
        return; // No notification
      }
      notifyDerivedAttributeChange();
    } else if (_localFeatures.contains(notification.getFeature())) {
      notifyDerivedAttributeChange();
    }
  }

  private void notifyDerivedAttributeChange() {
    if (_source.eNotificationRequired()) {
      _source.eNotify(new ENotificationImpl(_source, Notification.SET, _derivedFeature, null, _source.eGet(_derivedFeature, true, true)));
    }
  }

}
