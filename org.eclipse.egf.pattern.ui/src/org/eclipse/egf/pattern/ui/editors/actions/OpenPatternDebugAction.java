/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.common.uri.URIHelper;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

/**
 * 
 * @author Thomas Guiu
 * 
 */

public class OpenPatternDebugAction implements IObjectActionDelegate {

    static String FC_NAME = "/pipo.fc";

    protected IStructuredSelection selection;

    private IWorkbenchPart targetPart;

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = (IStructuredSelection) selection;
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        this.targetPart = targetPart;

    }

    public void run(IAction action) {
        try {
            IFile file = (IFile) selection.getFirstElement();
            URI uri = URIHelper.getPlatformURI(file.getFullPath());
            ResourceSetImpl set = new ResourceSetImpl();
            TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.eclipse.egf.pattern.ui.editors.PatternEditingDomain");

            // editingDomain.getResourceSet().getURIConverter().getURIMap().clear();
            // editingDomain.getResourceSet().getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());

            Resource res = editingDomain.getResourceSet().getResource(uri, true);
            // Resource res1 = ResourceHelper.loadResource(set, uri);

            FactoryComponent fc = (FactoryComponent) res.getContents().get(0);
            PatternViewpoint pvp = (PatternViewpoint) fc.getViewpointContainer().getViewpoints().get(0);
            PatternLibrary patternLibrary = pvp.getLibraries().get(0);

            Pattern pattern = (Pattern) patternLibrary.getElements().get(0);
            URI uri2 = EcoreUtil.getURI(pattern);
            PatternEditorInput input = new PatternEditorInput(res, uri2.fragment());

            targetPart.getSite().getPage().openEditor(input, "org.eclipse.egf.pattern.ui.editors.PatternEditor");
        } catch (PartInitException e) {
            e.printStackTrace();

        }
    }
}
