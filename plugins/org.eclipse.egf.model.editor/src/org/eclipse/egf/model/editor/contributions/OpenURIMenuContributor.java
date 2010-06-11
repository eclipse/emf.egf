/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.types.TypeURI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OpenURIMenuContributor extends OpenEObjectMenuContributor {

    public static final String OPEN_URI_ACTION_ID = "open-uri"; //$NON-NLS-1$  

    private OpenEObjectMenuContributor.OpenAction _openAction;

    protected class URIOpenAction extends OpenAction {

        public URIOpenAction() {
            super(OPEN_URI_ACTION_ID);
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        protected EObject getEObject() {
            if (_selection == null || _selection.isEmpty()) {
                return null;
            }
            Object object = ((IStructuredSelection) _selection).getFirstElement();
            if (object instanceof DomainURI || object instanceof TypeDomainURI || object instanceof TypeURI) {
                return (EObject) object;
            }
            return null;
        }

        @Override
        protected URI getURI() {
            EObject eObject = getEObject();
            if (eObject == null) {
                return null;
            }
            URI uri = null;
            if (eObject instanceof DomainURI) {
                uri = ((DomainURI) eObject).getUri();
            } else if (eObject instanceof TypeDomainURI) {
                uri = ((TypeDomainURI) eObject).getValue();
            } else if (eObject instanceof TypeURI) {
                uri = ((TypeURI) eObject).getValue();
            }
            return uri;
        }

    }

    @Override
    protected String getText() {
        if (getOpenAction().isAlreadyOpenedEditor()) {
            return ModelEditorMessages.URIMenuContributor_selectAction_label;
        }
        return ModelEditorMessages.URIMenuContributor_openAction_label;
    }

    @Override
    protected OpenAction getOpenAction() {
        if (_openAction == null) {
            _openAction = new URIOpenAction();
        }
        return _openAction;
    }

}
