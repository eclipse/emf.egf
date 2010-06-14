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

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFAdapterFactoryEditingDomain extends AdapterFactoryEditingDomain {

    /**
     * Create an instance from the adapter factory, and the specialized command stack.
     */
    public EGFAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack) {
        super(adapterFactory, commandStack);
        resourceSet.setURIConverter(EGFCorePlugin.getPlatformURIConverter());
    }

    /**
     * Create an instance from the adapter factory, the specialized command stack, and the map used to maintain read only state.
     */
    public EGFAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack, Map<Resource, Boolean> resourceToReadOnlyMap) {
        super(adapterFactory, commandStack, resourceToReadOnlyMap);
        resourceSet.setURIConverter(EGFCorePlugin.getPlatformURIConverter());
    }

}
