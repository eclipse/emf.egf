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

import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.core.ui.contributor.MenuContributor;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
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
public class URIMenuContributor extends MenuContributor {

  public static final String EDIT_ACTION_ID = "edit-fcore"; //$NON-NLS-1$  

  private final EditURIAction _editAction = new EditURIAction();

  @Override
  public void menuAboutToShow(IMenuManager menuManager) {
    IStructuredSelection selection2 = (IStructuredSelection) selection;
    if (selection2.size() == 1) {
      if (selection2.getFirstElement() instanceof DomainURI || selection2.getFirstElement() instanceof TypeDomainURI) {
        _editAction.setEnabled(_editAction.isEnabled());
        menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, _editAction);
      }
    }
  }

  private class EditURIAction extends Action {

    public EditURIAction() {
      super(ModelEditorMessages.URIMenuContributor_openAction_label);
      setId(EDIT_ACTION_ID);
    }

    @Override
    public boolean isEnabled() {
      URI uri = getURI();
      if (uri == null) {
        return false;
      }
      return true;
    }

    protected URI getURI() {
      if (selection == null) {
        return null;
      }
      IStructuredSelection sselection = (IStructuredSelection) selection;
      if (sselection.size() != 1) {
        return null;
      }
      // Try to locate a URI
      URI uri = null;
      Resource resource = null;
      Object object = sselection.getFirstElement();
      if (object instanceof DomainURI) {
        DomainURI domainURI = (DomainURI) object;
        uri = domainURI.getUri();
        resource = domainURI.eResource();
      } else if (object instanceof TypeDomainURI) {
        TypeDomainURI typeDomainURI = (TypeDomainURI) object;
        uri = typeDomainURI.getValue();
        resource = typeDomainURI.eResource();
      }
      // Try to use a URIConverter to normalize such URI
      // if we have a platform:/plugin/ we need a platform:/resource/ if any
      // to have a chance to use a FileEditorInput rather than a URIEditorInput
      if (uri != null && resource != null && resource.getResourceSet() != null) {
        URIConverter converter = resource.getResourceSet().getURIConverter();
        if (converter != null) {
          uri = converter.normalize(uri);
        }
      }
      return uri;
    }

    @Override
    public void run() {
      try {
        URI uri = getURI();
        if (uri == null) {
          return;
        }
        IEditorPart part = EditorHelper.openEditor(uri);
        if (part != null) {
          if (part instanceof IEditingDomainProvider) {
            EditorHelper.setSelectionToViewer(part, uri);
          }
        }
      } catch (PartInitException pie) {
        EGFModelEditorPlugin.getPlugin().logError(pie);
      }
    }

  }

}
