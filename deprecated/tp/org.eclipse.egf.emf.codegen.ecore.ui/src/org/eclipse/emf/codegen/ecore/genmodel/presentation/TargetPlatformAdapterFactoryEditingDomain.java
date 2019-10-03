/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.emf.codegen.ecore.genmodel.presentation;

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
public class TargetPlatformAdapterFactoryEditingDomain extends AdapterFactoryEditingDomain {

    /**
     * Create an instance from the adapter factory, and the specialized command stack.
     */
    public TargetPlatformAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack) {
        super(adapterFactory, commandStack);
        resourceSet.setURIConverter(EGFCorePlugin.getTargetPlatformURIConverter());
    }

    /**
     * Create an instance from the adapter factory, the specialized command stack, and the map used to maintain read only state.
     */
    public TargetPlatformAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack, Map<Resource, Boolean> resourceToReadOnlyMap) {
        super(adapterFactory, commandStack, resourceToReadOnlyMap);
        resourceSet.setURIConverter(EGFCorePlugin.getTargetPlatformURIConverter());
    }

}
