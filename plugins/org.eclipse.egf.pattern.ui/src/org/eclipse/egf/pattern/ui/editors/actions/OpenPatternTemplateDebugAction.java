/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editors.templateEditor.TemplateExtensionRegistry;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * @author Thomas Guiu
 */

public class OpenPatternTemplateDebugAction implements IObjectActionDelegate {

    protected IStructuredSelection _selection;

    private IWorkbenchPart _targetPart;

    public void selectionChanged(IAction action, ISelection selection) {
        _selection = (IStructuredSelection) selection;
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        _targetPart = targetPart;
    }

    public void run(IAction action) {
        Object firstElement = _selection.getFirstElement();
        TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
        IFile file = (IFile) firstElement;
        URI uri = URIHelper.getPlatformPluginURI(file.getFullPath());
        Resource res = editingDomain.getResourceSet().getResource(uri, true);
        FactoryComponent fc = (FactoryComponent) res.getContents().get(0);
        PatternViewpoint pvp = (PatternViewpoint) fc.getViewpointContainer().getViewpoints().get(0);
        PatternLibrary patternLibrary = pvp.getLibraries().get(0);
        Pattern pattern = patternLibrary.getElements().get(0);
        String editor = TemplateExtensionRegistry.getEditor(pattern);
        if (editor != null) {
            try {
                PatternEditorInput input = new PatternEditorInput(pattern.eResource(), pattern.getID());
                IDE.openEditor(_targetPart.getSite().getPage(), input, editor);
            } catch (PartInitException e) {
                Activator.getDefault().logError(e);
            }
        }
    }

}
