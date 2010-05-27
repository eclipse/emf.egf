/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
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
 * This class is used to test open the editor on a pattern in read only mode
 * 
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class OpenReadOnlyPatternDebugAction implements IObjectActionDelegate {

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
      TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);

      Resource res = editingDomain.getResourceSet().getResource(uri, true);

      FactoryComponent fc = (FactoryComponent) res.getContents().get(0);
      PatternViewpoint pvp = (PatternViewpoint) fc.getViewpointContainer().getViewpoints().get(0);
      PatternLibrary patternLibrary = pvp.getLibraries().get(0);

      Pattern pattern = (Pattern) patternLibrary.getElements().get(0);
      // URI uri2 = EcoreUtil.getURI(pattern);
      PatternEditorInput input = new PatternEditorInput(res, pattern.getID());
      // Set the editor on a pattern in read only mode.
      input.setReadOnly(true);

      targetPart.getSite().getPage().openEditor(input, "org.eclipse.egf.pattern.ui.editors.PatternEditor");
    } catch (PartInitException e) {
      e.printStackTrace();

    }
  }
}
