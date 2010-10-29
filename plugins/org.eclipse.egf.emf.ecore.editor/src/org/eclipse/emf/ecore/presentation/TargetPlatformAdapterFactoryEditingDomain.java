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
package org.eclipse.emf.ecore.presentation;

import java.util.Map;

import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TargetPlatformAdapterFactoryEditingDomain extends AdapterFactoryEditingDomain {

    protected class EGFAdapterFactoryEditingDomainResourceSet extends TargetPlatformResourceSet implements IEditingDomainProvider {

        public EGFAdapterFactoryEditingDomainResourceSet() {
            super();
            // setResourceFactoryRegister(new ExtensibleContextResourceFactoryRegister());
            //EATM setResourceFactoryRegister(new ContextResourceFactoryRegister());
        }

        public EditingDomain getEditingDomain() {
            return TargetPlatformAdapterFactoryEditingDomain.this;
        }

    }

    /**
     * Create an instance from the adapter factory, and the specialized command stack.
     */
    public TargetPlatformAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack) {
        super(adapterFactory, commandStack);
        resourceSet = new EGFAdapterFactoryEditingDomainResourceSet();
    }

    /**
     * Create an instance from the adapter factory, the specialized command stack, and the map used to maintain read only state.
     */
    public TargetPlatformAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack, Map<Resource, Boolean> resourceToReadOnlyMap) {
        super(adapterFactory, commandStack, resourceToReadOnlyMap);
        resourceSet = new EGFAdapterFactoryEditingDomainResourceSet();
    }

}
