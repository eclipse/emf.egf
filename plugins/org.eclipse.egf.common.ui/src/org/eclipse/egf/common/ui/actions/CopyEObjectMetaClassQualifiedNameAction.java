/**
 * Copyright (c) 2007-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.ui.actions;

import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.egf.common.ui.ICommonUIImages;
import org.eclipse.egf.common.ui.l10n.EGFCommonUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Xavier Maysonnave
 * 
 */
public class CopyEObjectMetaClassQualifiedNameAction extends CopyQualifiedNameAction {

    private EObject _eObject;

    public CopyEObjectMetaClassQualifiedNameAction() {
        super(EGFCommonUIMessages.CopyEObjectMetaClassQualifiedName_name, EGFCommonUIPlugin.getDefault().getImageDescriptor(ICommonUIImages.ECORE_IMAGE_PATH));
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        _eObject = null;
        if (selection instanceof IStructuredSelection) {
            _eObject = getSelection((IStructuredSelection) selection);
        }
    }

    @Override
    public URI getURI() {
        if (_eObject == null) {
            return null;
        }
        Resource resource = _eObject.eResource();
        if (resource == null) {
            return null;
        }
        URI uri = EcoreUtil.getURI(_eObject instanceof EClassifier ? _eObject : _eObject.eClass());
        if (uri != null && resource.getResourceSet() != null) {
            URIConverter converter = resource.getResourceSet().getURIConverter();
            if (converter != null) {
                uri = converter.normalize(uri);
            }
        }
        return uri;
    }

}
