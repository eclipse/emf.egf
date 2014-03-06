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
package org.eclipse.egf.model.ftask.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.egf.model.EGFFtaskPlugin;
import org.eclipse.egf.model.edit.EGFFtaskEditPlugin;
import org.eclipse.egf.model.fcore.provider.IResourceChildCreationExtender;
import org.eclipse.egf.model.fcore.util.FcoreResourceImpl;
import org.eclipse.egf.model.ftask.FtaskFactory;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 * 
 */
/**
 * A child creation extender for the {@link FcoreResourceImpl}.
 */
public class FcoreResourceChildCreationExtender implements IResourceChildCreationExtender {

    protected Collection<EClass> _roots;

    public Collection<EClass> getRoots() {
        if (_roots == null) {
            _roots = new UniqueEList<EClass>();
            _roots.add(FtaskPackage.Literals.TASK);
        }
        return _roots;
    }

    public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
        ArrayList<Object> newChildDescriptors = new ArrayList<Object>();
        for (String kind : EGFFtaskPlugin.getTaskNatureRegistry().getKinds()) {
            Task task = FtaskFactory.eINSTANCE.createTask();
            task.setKind(kind);
            newChildDescriptors.add(createChildParameter(FtaskPackage.Literals.TASK, task));
        }
        return newChildDescriptors;
    }

    protected CommandParameter createChildParameter(Object feature, Object child) {
        return new CommandParameter(null, feature, child);
    }

    public ResourceLocator getResourceLocator() {
        return EGFFtaskEditPlugin.INSTANCE;
    }
}
