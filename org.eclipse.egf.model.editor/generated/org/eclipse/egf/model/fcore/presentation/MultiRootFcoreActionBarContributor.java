/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.model.fcore.presentation;

import java.util.Collection;

import org.eclipse.egf.model.fcore.presentation.actions.MultiRootFactoryComponentCreateAction;
import org.eclipse.egf.model.fcore.presentation.actions.MultiRootFcoreCutAction;
import org.eclipse.egf.model.fcore.presentation.actions.MultiRootFcoreDeleteAction;
import org.eclipse.egf.model.fcore.presentation.actions.MultiRootFcorePasteAction;
import org.eclipse.egf.model.fcore.presentation.actions.MultiRootTaskJavaCreateAction;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

/**
 * Extension to the generated action bar contributor to handle creation of
 * multi-rooted resources.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class MultiRootFcoreActionBarContributor extends FcoreActionBarContributor {

  /**
   * Constructor
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public MultiRootFcoreActionBarContributor() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection) {
    Collection<IAction> actions = super.generateCreateChildActions(descriptors, selection);
    if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
      Object object = ((IStructuredSelection) selection).getFirstElement();
      // Object should be a Resource
      if (object instanceof Resource) {
        actions.add(new MultiRootFactoryComponentCreateAction(activeEditorPart, new StructuredSelection(object)));
        actions.add(new MultiRootTaskJavaCreateAction(activeEditorPart, new StructuredSelection(object)));
      }
    }
    return actions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection) {
    Collection<IAction> actions = super.generateCreateSiblingActions(descriptors, selection);
    if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
      Object object = ((IStructuredSelection) selection).getFirstElement();
      // Object should be a resource
      EditingDomain domain = ((IEditingDomainProvider) activeEditorPart).getEditingDomain();
      if (domain.getParent(object) instanceof Resource) {
        actions.add(new MultiRootFactoryComponentCreateAction(activeEditorPart, new StructuredSelection(domain.getParent(object))));
        actions.add(new MultiRootTaskJavaCreateAction(activeEditorPart, new StructuredSelection(domain.getParent(object))));
      }
    }
    return actions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void init(IActionBars actionBars) {
    super.init(actionBars);
    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
    // Override deleteAction
    //		
    deleteAction = new MultiRootFcoreDeleteAction(removeAllReferencesOnDelete());
    deleteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
    actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
    // Override cutAction
    //		
    cutAction = new MultiRootFcoreCutAction();
    cutAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
    actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cutAction);
    // Override pasteAction
    //		
    pasteAction = new MultiRootFcorePasteAction();
    pasteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
    actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), pasteAction);
  }

}
