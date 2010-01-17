/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.domain;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Thomas Guiu
 * 
 */
public class ResourceLoadedListener1 extends DemultiplexingListener {

    public ResourceLoadedListener1() {
        super(NotificationFilter.createFeatureFilter(EcorePackage.eINSTANCE.getEResource(), Resource.RESOURCE__IS_LOADED));

    }

    @Override
    protected void handleNotification(TransactionalEditingDomain domain, Notification notification) {
        if (notification.getEventType() == Notification.RESOLVE)
            System.out.println("resolve");
        System.out.println(((Resource) notification.getNotifier()).getURI());
    }

}
