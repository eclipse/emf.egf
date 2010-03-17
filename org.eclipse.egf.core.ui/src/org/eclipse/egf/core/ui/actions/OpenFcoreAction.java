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
package org.eclipse.egf.core.ui.actions;

import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.dialogs.FcoreSelectionDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;

/**
 * Standard action for opening an editor on EGF Fcores.
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 */
public class OpenFcoreAction extends Action implements IWorkbenchWindowActionDelegate {

  private IWorkbenchWindow _window;

  /**
   * Creates a new action for opening an EGF Fcore
   */
  public OpenFcoreAction() {
    setEnabled(true);
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
   */
  public void dispose() {
    _window = null;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
   */
  public void init(IWorkbenchWindow window) {
    this._window = window;
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
   */
  public void run(IAction action) {
    run();
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
   */
  public void selectionChanged(IAction action, ISelection selection) {
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    FcoreSelectionDialog dialog = new FcoreSelectionDialog(_window.getShell(), true);
    dialog.open();
    Object[] objects = dialog.getResult();
    if (objects != null) {
      EditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
      ResourceSet resourceSet = editingDomain.getResourceSet();
      for (Object object : objects) {
        if (object instanceof IPlatformFcore == false) {
          continue;
        }
        IPlatformFcore fcore = (IPlatformFcore) object;
        try {
          URI uri = fcore.getURI();
          if (uri != null) {
            // Try to use a URIConverter to normalize such URI
            // if we have a platform:/plugin/ we need a platform:/resource/ if any
            // to have a chance to use a FileEditorInput rather than an URIEditorInput
            URIConverter converter = resourceSet.getURIConverter();
            if (converter != null) {
              uri = converter.normalize(uri);
            }
            IEditorPart part = EditorHelper.openEditor(uri);
            if (part != null && part instanceof IEditingDomainProvider) {
              EditorHelper.setSelectionToViewer(part, uri);
            }
          }
        } catch (PartInitException pie) {
          EGFCoreUIPlugin.getDefault().logError(pie);
        }
      }
    }
  }
}
