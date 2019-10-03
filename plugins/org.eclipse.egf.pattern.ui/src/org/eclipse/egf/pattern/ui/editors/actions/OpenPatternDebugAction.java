/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.pattern.ui.editors.PatternEditor;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

/**
 * @author Thomas Guiu
 */

public class OpenPatternDebugAction implements IObjectActionDelegate {

    protected IStructuredSelection _selection;

    private IWorkbenchPart _targetPart;

    public void selectionChanged(IAction action, ISelection selection) {
        _selection = (IStructuredSelection) selection;
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        _targetPart = targetPart;
    }

    public void run(IAction action) {
        try {
            IFile file = (IFile) _selection.getFirstElement();
            URI uri = URIHelper.getPlatformPluginURI(file.getFullPath());
            TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);

            Resource res = editingDomain.getResourceSet().getResource(uri, true);

            FactoryComponent fc = (FactoryComponent) res.getContents().get(0);
            PatternViewpoint pvp = (PatternViewpoint) fc.getViewpointContainer().getViewpoints().get(0);
            PatternLibrary patternLibrary = pvp.getLibraries().get(0);

            Pattern pattern = patternLibrary.getElements().get(0);
            // URI uri2 = EcoreUtil.getURI(pattern);
            PatternEditorInput input = new PatternEditorInput(res, pattern.getID());

            _targetPart.getSite().getPage().openEditor(input, PatternEditor.ID);
        } catch (PartInitException e) {
            e.printStackTrace();

        }
    }
}
