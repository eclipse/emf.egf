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
package org.eclipse.egf.model.fcore.commands.resource;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Multi-rooted resources support.
 * This command will a value in the list and notify
 * 
 */
public class ResourceMoveCommand extends MoveCommand {

    private Resource _resource;

    /**
     * This constructs a primitive command to move a particular value to a particular index of the specified extent.
     */
    public ResourceMoveCommand(EditingDomain domain, Resource resource, Object value, int index) {
        super(domain, resource.getContents(), value, index);
        _resource = resource;
    }

    @Override
    public void doExecute() {
        oldIndex = ownerList.indexOf(value);
        ownerList.move(index, value);
        _resource.setModified(true);
        Notification innerNotification = new NotificationImpl(Notification.MOVE, _resource.getContents().indexOf(value), value, index, _resource.getContents().isEmpty() == false) {

            @Override
            public Object getFeature() {
                return value instanceof EObject ? ((EObject) value).eClass() : null;
            }

            @Override
            public Object getNotifier() {
                return _resource;
            }

            @Override
            public int getFeatureID(Class<?> expectedClass) {
                return Resource.RESOURCE__CONTENTS;
            }
        };
        _resource.eNotify(innerNotification);
    }

}
