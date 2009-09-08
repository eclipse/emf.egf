/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.action.explorer.delete;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.core.ui.preferences.IPreferenceConstants;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.command.SetModelElementCommand;
import org.eclipse.egf.model.edit.command.plugin.domain.RemoveDomainWrapperCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;


/**
 * Implements an action to delete a domain.
 * @author fournier
 */
public class DeleteDomainAction extends DeleteModelElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public DeleteDomainAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#getConfirmDeleteMessage()
   */
  @Override
  protected String[] getConfirmDeleteMessage() {
    Domain domain = (Domain) getModelElement();
    String[] message = { Messages.DeleteDomainAction_Message, domain.getPath() };
    return message;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return Domain.class;
  }

  /**
   * @see org.eclipse.jface.action.Action#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    // Default enablement.
    boolean isEnabled = super.isEnabled();
    if (isEnabled) {
      Domain domain = (Domain) getModelElement();
      // If the domain is defined, allow this action.
      isEnabled = ModelHelper.isDomainDefined(domain);
    }
    return isEnabled;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#closeEditor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected boolean closeEditor(NamedModelElementWithId modelElement_p) {
    // Get the hosting project for given model element.
    IProject hostingProject = ModelHelper.getProject(modelElement_p);
    // Get the domain file.
    String domainAsEcore = ((Domain) modelElement_p).getPath();
    IFile domainFile = hostingProject.getFile(domainAsEcore);
    // Close the potential open Ecore editor on the domain as ecore file.
    boolean result = closeFileEditor(domainFile, IPreferenceConstants.ECORE_EDITOR_ID);
    // Close the potential open Topcased editor on the domain as ecore diagram file.
    IPath domainDiagramPath = new Path(domainAsEcore).removeFileExtension().addFileExtension(ICommonConstants.ECORE_DIAGRAM_FILE_EXTENSION);
    // Get the ecore diagram file.
    IFile domainDiagramFile = hostingProject.getFile(domainDiagramPath.toString());
    result |= closeFileEditor(domainDiagramFile, IPreferenceConstants.GRAPHICAL_ECORE_EDITOR_ID);
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#doDeleteModelElement()
   */
  @Override
  protected void doDeleteModelElement() {
    // Close the equivalent editor if any.
    closeEditor(getModelElement());
    // Get the editing domain.
    AdapterFactoryEditingDomain editingDomain = getEditingDomain();
    // Get the domain.
    Domain domain = (Domain) getModelElement();
    // Get the feature related to the path on Domain model element.
    EStructuralFeature feature = ModelPackage.Literals.DOMAIN__PATH;
    // Create a command to set to null the path.
    SetModelElementCommand deleteCommand = new SetModelElementCommand(editingDomain, domain, feature, null);
    // Update the plug-in file.
    deleteCommand.setPluginChangeCommand(new RemoveDomainWrapperCommand(editingDomain, domain, feature, domain.getPath()));
    // Execute the command.
    executeCommand(editingDomain, deleteCommand);
  }
}