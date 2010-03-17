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
package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.core.ui.contributor.MenuContributor;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class EObjectMenuContributor extends MenuContributor {

  protected abstract class OpenAction extends Action {

    public OpenAction(String message, String id) {
      super(message);
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

    protected abstract EObject getEObject();

    protected URI getURI(EObject eObject) {
      return EcoreUtil.getURI(eObject);
    }

    @Override
    public void run() {
      try {
        EObject eObject = getEObject();
        if (eObject == null) {
          return;
        }
        URI uri = getURI(eObject);
        Resource resource = eObject.eResource();
        // Try to use a URIConverter to normalize such URI
        // if we have a platform:/plugin/ we need a platform:/resource/ if any
        // to have a chance to use a FileEditorInput rather than a URIEditorInput
        if (uri != null && resource != null && resource.getResourceSet() != null) {
          URIConverter converter = resource.getResourceSet().getURIConverter();
          if (converter != null) {
            uri = converter.normalize(uri);
          }
        }
        // Try to open it if any
        if (uri != null) {
          IEditorPart part = EditorHelper.openEditor(uri);
          if (part != null && part instanceof IEditingDomainProvider) {
            EditorHelper.setSelectionToViewer(part, uri);
          }
        }
      } catch (PartInitException pie) {
        EGFModelEditorPlugin.getPlugin().logError(pie);
      }
    }

  }

}
