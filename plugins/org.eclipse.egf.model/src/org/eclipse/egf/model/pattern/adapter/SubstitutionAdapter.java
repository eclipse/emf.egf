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
package org.eclipse.egf.model.pattern.adapter;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Xavier Maysonnave
 * 
 */
public class SubstitutionAdapter extends AdapterImpl {

    private EObject _root;

    private Substitution _substitution;

    private EStructuralFeature _nameFeature = FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME;

    private EStructuralFeature _substitutionOutgoingFeature = PatternPackage.Literals.SUBSTITUTION__OUTGOING;

    private AdapterImpl _nameAdapter = new AdapterImpl() {
        @Override
        public void notifyChanged(Notification msg) {
            if (msg.getEventType() == Notification.SET && msg.getFeature().equals(_nameFeature)) {
                _substitution.eNotify(new ENotificationImpl((InternalEObject) _substitution, -1, _substitutionOutgoingFeature, null, null) {
                    @Override
                    public boolean isTouch() {
                        return true;
                    }
                });
            }
        }
    };

    public SubstitutionAdapter(Substitution substitution) {
        super();
        _substitution = substitution;
        _substitution.eAdapters().add(this);
    }

    @Override
    public void notifyChanged(Notification notification) {
        if (notification.getFeature() == null || notification.getFeature().equals(_substitutionOutgoingFeature)) {
            switch (notification.getEventType()) {
            case Notification.SET:
            case Notification.RESOLVE:
                EObject newValue = EcoreUtil.getRootContainer((Pattern) notification.getNewValue(), true);
                EObject oldValue = EcoreUtil.getRootContainer((Pattern) notification.getOldValue(), true);
                if (oldValue != null && oldValue != notification.getOldValue()) {
                    oldValue.eAdapters().remove(_nameAdapter);
                }
                if (newValue != null && newValue != notification.getNewValue() && newValue.eAdapters().contains(_nameAdapter) == false) {
                    newValue.eAdapters().add(_nameAdapter);
                    _root = newValue;
                }
                break;
            case Notification.REMOVING_ADAPTER:
                if (_root != null) {
                    _root.eAdapters().remove(_nameAdapter);
                }
                break;
            default:
                return; // No notification
            }
        }
    }
}
