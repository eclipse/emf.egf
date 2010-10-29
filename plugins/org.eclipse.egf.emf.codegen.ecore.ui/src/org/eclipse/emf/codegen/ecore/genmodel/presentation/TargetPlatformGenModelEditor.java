/**
 * <copyright>
 * 
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * Xavier Maysonnave - Thales Corporate Services S.A.S - Target Platform contribution
 * 
 * </copyright>
 * 
 * $Id: EcoreEditor.java,v 1.60 2008/12/22 14:25:27 emerks Exp $
 */
package org.eclipse.emf.codegen.ecore.genmodel.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

/**
 * This is an example of a target platform Ecore model editor.
 * 
 */
public class TargetPlatformGenModelEditor extends GenModelEditor implements IPluginModelListener {

    /**
     * This is called during startup.
     */
    @Override
    public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
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
                        getSite().getPage().closeEditor(TargetPlatformGenModelEditor.this, false);
                    }
                }

            });
        }
    }

    /**
     * This sets up the editing domain for the model editor.
     */
    @Override
    protected void initializeEditingDomain() {

        adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

        // Create the command stack that will notify this editor as commands are executed.
        //
        BasicCommandStack commandStack = new BasicCommandStack();

        // Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
        //
        commandStack.addCommandStackListener(new CommandStackListener() {

            public void commandStackChanged(final EventObject event) {
                getContainer().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        firePropertyChange(IEditorPart.PROP_DIRTY);

                        // Try to select the affected objects.
                        //
                        Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
                        if (mostRecentCommand != null) {
                            setSelectionToViewer(mostRecentCommand.getAffectedObjects());
                        }

                        if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
                            propertySheetPage.refresh();
                        }
                    }

                });
            }
        });
        // Create the editing domain with a special command stack.
        //
        editingDomain = new TargetPlatformAdapterFactoryEditingDomain(adapterFactory, commandStack) {

            @Override
            public boolean isReadOnly(Resource resource) {
                return super.isReadOnly(resource) || getResourceSet().getResources().indexOf(resource) != 0;
            }

        };
    }

}
