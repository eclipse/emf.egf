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

package org.eclipse.egf.model.editor.contributor;

import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.core.ui.contributor.MenuContributor;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
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
public class ActivityMenuContributor extends MenuContributor {

  public static final String EDIT_ACTION_ID = "edit-fcore"; //$NON-NLS-1$  

  private final EditActivityAction _editAction = new EditActivityAction();

  @Override
  public void menuAboutToShow(IMenuManager menuManager) {
    IStructuredSelection selection2 = (IStructuredSelection) selection;
    if (selection2.size() == 1) {
      if (selection2.getFirstElement() instanceof Invocation || selection2.getFirstElement() instanceof InvocationContract) {
        _editAction.setEnabled(_editAction.isEnabled());
        menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, _editAction);
      }
    }
  }

  private class EditActivityAction extends Action {

    public EditActivityAction() {
      super(ModelEditorMessages.ActivityMenuContributor_openAction_label);
      setId(EDIT_ACTION_ID);
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

    protected EObject getEObject() {
      if (selection == null) {
        return null;
      }
      IStructuredSelection sselection = (IStructuredSelection) selection;
      if (sselection.size() != 1) {
        return null;
      }
      Object object = sselection.getFirstElement();
      if (object instanceof Invocation) {
        Invocation invocation = (Invocation) object;
        return invocation.getInvokedActivity();
      } else if (object instanceof InvocationContract) {
        InvocationContract invocationContract = (InvocationContract) object;
        return invocationContract.getInvokedContract();
      }
      return null;
    }

    @Override
    public void run() {
      try {
        EObject eObject = getEObject();
        if (eObject == null) {
          return;
        }
        URI uri = EcoreUtil.getURI(eObject);
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
