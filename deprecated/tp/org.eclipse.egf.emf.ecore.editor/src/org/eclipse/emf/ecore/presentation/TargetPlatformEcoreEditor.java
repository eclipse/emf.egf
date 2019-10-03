/**
 * <copyright>
 * 
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * Xavier Maysonnave - Thales Corporate Services S.A.S - Target Platform contribution
 * 
 * </copyright>
 * 
 * $Id: EcoreEditor.java,v 1.60 2008/12/22 14:25:27 emerks Exp $
 */
package org.eclipse.emf.ecore.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

/**
 * This is an example of a target platform Ecore model editor.
 * 
 */
public class TargetPlatformEcoreEditor extends EcoreEditor implements IPluginModelListener {

    /**
     * This is called during startup.
     */
    @Override
    public void init(IEditorSite site, IEditorInput editorInput) {
        super.init(site, editorInput);
        PDECore.getDefault().getModelManager().addPluginModelListener(this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void dispose() {
        PDECore.getDefault().getModelManager().removePluginModelListener(this);
        super.dispose();
    }

    public void modelsChanged(PluginModelDelta event) {
        // Process Removed ModelEntry
        if ((event.getKind() & PluginModelDelta.REMOVED) != 0) {
            // Process removed entries
            for (ModelEntry entry : event.getRemovedEntries()) {
                String id = entry.getId();
                // Ignore Model with unknown id
                if (id == null) {
                    continue;
                }
                // Process only target models
                if (entry.getModel().getUnderlyingResource() == null) {
                    handleRemove(entry.getModel());
                }
            }
        }
    }

    private void handleRemove(IPluginModelBase base) {
        final Collection<Resource> innerRemovedResources = new ArrayList<Resource>();
        String model = URI.createPlatformPluginURI(base.getPluginBase().getId() + "/", false).toString(); //$NON-NLS-1$
        // Analyse the resourceSet to handle removed target resources if any
        for (Resource resource : editingDomain.getResourceSet().getResources()) {
            if (resource.getURI().toString().startsWith(model)) {
                innerRemovedResources.add(resource);
            }
        }
        // Process if any
        if (innerRemovedResources.isEmpty() == false) {
            getSite().getShell().getDisplay().asyncExec(new Runnable() {

                public void run() {
                    removedResources.addAll(innerRemovedResources);
                    if (isDirty() == false) {
                        getSite().getPage().closeEditor(TargetPlatformEcoreEditor.this, false);
                    }
                }

            });
        }
    }

    @Override
    public void createModel() {

        createModelGen();

        if (editingDomain.getResourceSet().getResources().isEmpty() == false) {
            for (Iterator<EObject> i = editingDomain.getResourceSet().getResources().get(0).getAllContents(); i.hasNext();) {
                EObject eObject = i.next();
                if (eObject instanceof ETypeParameter || eObject instanceof EGenericType && ((EGenericType) eObject).getETypeArguments().isEmpty() == false) {
                    ((TargetPlatformEcoreActionBarContributor) getActionBarContributor()).showGenerics(true);
                    break;
                }
            }
        }

    }

    /**
     * This sets up the editing domain for the model editor.
     */
    @Override
    protected void initializeEditingDomain() {
        super.initializeEditingDomain();
        // Create the editing domain with a special command stack.
        //
        editingDomain = new TargetPlatformAdapterFactoryEditingDomain(editingDomain.getAdapterFactory(), editingDomain.getCommandStack(), new HashMap<Resource, Boolean>());
    }

}
