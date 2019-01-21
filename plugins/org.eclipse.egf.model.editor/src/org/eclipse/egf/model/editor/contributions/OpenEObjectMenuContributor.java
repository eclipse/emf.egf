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
package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class OpenEObjectMenuContributor extends EditorMenuContributor {

    protected abstract OpenAction getOpenAction();

    protected abstract String getText();

    protected abstract class OpenAction extends Action {

        public OpenAction(String id) {
            setId(id);
        }

        @Override
        public boolean isEnabled() {
            EObject eObject = getEObject();
            if (eObject == null) {
                return false;
            }
            if (eObject instanceof InternalEObject) {
                return ((InternalEObject) eObject).eIsProxy() == false;
            }
            return false;
        }

        public boolean isAlreadyOpenedEditor() {
            return EditorHelper.isAlreadyOpenedEditor(getURI());
        }

        protected abstract EObject getEObject();

        protected URI getURI() {
            EObject eObject = getEObject();
            if (eObject == null) {
                return null;
            }
            return EcoreUtil.getURI(eObject);
        }

        protected URIConverter getURIConverter() {
            EObject eObject = getEObject();
            if (eObject == null) {
                return null;
            }
            if (eObject.eResource() != null && eObject.eResource().getResourceSet() != null && eObject.eResource().getResourceSet().getURIConverter() != null) {
                return eObject.eResource().getResourceSet().getURIConverter();
            }
            return null;
        }

        protected URI normalize(URI uri) {
            if (uri == null || getURIConverter() == null) {
                return uri;
            }
            return getURIConverter().normalize(uri);
        }

        @Override
        public void run() {
            try {
                URI uri = getURI();
                // Try to open it if any
                if (uri != null) {
                    IEditorPart part = EditorHelper.openEditor(normalize(uri));
                    if (part != null && part instanceof IEditingDomainProvider) {
                        EditorHelper.setSelectionToViewer(part, uri);
                    }
                }
            } catch (PartInitException pie) {
                ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), pie);
            }
        }

    }

    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        IStructuredSelection innerSelection = (IStructuredSelection) _selection;
        if (innerSelection.size() == 1 && getOpenAction().getEObject() != null) {
            getOpenAction().setText(getText());
            getOpenAction().setEnabled(getOpenAction().isEnabled());
            menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, getOpenAction());
        }
    }

}
