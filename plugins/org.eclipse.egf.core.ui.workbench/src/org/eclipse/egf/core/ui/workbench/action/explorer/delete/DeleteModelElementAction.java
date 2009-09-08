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
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.helper.DialogHelper;
import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.actions.ActionFactory;


/**
 * Base class to implement an action that deletes a model element object.
 * @author fournier
 */
public abstract class DeleteModelElementAction extends AbstractModelElementAction {
  /**
   * Whether or not a dialog is pop-up to ask an user confirmation.
   */
  private boolean _isUserConfirmationRequested;

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  protected DeleteModelElementAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    _isUserConfirmationRequested = true;
    setId(ActionFactory.DELETE.getId());
    setActionDefinitionId("org.eclipse.ui.edit.delete"); //$NON-NLS-1$
    ISharedImages sharedImages = getSharedImages();
    setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
    setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
    setText(Messages.DeleteAction_Title);
    setToolTipText(Messages.DeleteAction_Tooltip);
  }

  /**
   * Set whether or not a user confirmation is requested when running.
   * @param userConfirmation_p
   */
  public void setUserConfirmationRequested(boolean userConfirmation_p) {
    _isUserConfirmationRequested = userConfirmation_p;
  }

  /**
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    boolean deleteConfirmed = true;
    if (_isUserConfirmationRequested) {
      String[] arguments = getConfirmDeleteMessage();
      deleteConfirmed = DialogHelper.openDeleteConfirmationDialog(getShell(), arguments);
    }
    if (deleteConfirmed) {
      doDeleteModelElement();
    }
  }

  /**
   * Performs the model element delete and call the closeEditor method.
   */
  protected void doDeleteModelElement() {
    // Get the model element to delete.
    NamedModelElementWithId modelElement = getModelElement();
    // Close the related editor and discard unsaved changes if open.
    boolean canDelete = closeEditor(modelElement);
    if (canDelete) {
      executeDeleteCommand(modelElement);
    }
  }

  /**
   * Execute the EMF delete command.
   * @param modelElement_p
   */
  private void executeDeleteCommand(NamedModelElementWithId modelElement_p) {
    AdapterFactoryEditingDomain editingDomain = getEditingDomain();
    // Create the delete command.
    Command command = DeleteCommand.create(editingDomain, modelElement_p);
    updateLabel(command, editingDomain.getAdapterFactory(), modelElement_p);
    // Finally, execute the command.
    executeCommand(editingDomain, command);
  }

  /**
   * Update the label for specified command with given element.
   * @param command_p
   * @param adapterFactory_p
   * @param element_p
   */
  private void updateLabel(Command command_p, AdapterFactory adapterFactory_p, NamedModelElementWithId element_p) {
    // Preconditions.
    if ((null == command_p) || (null == adapterFactory_p) || (null == element_p)) {
      return;
    }
    // Get a label provider.
    IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory_p.adapt(element_p, IItemLabelProvider.class);
    if (null != labelProvider) {
      // Compute the updated label.
      String elementText = labelProvider.getText(element_p);
      if ((null != elementText) && (elementText.length() > 0)) {
        StringBuilder updatedLabel =
                                     new StringBuilder(command_p.getLabel()).append(ICommonConstants.WHITE_SPACE_CHARACTER)
                                         .append(element_p.eClass().getName()).append(ICommonConstants.WHITE_SPACE_CHARACTER).append(elementText);
        // Update the command label.
        ((AbstractCommand) command_p).setLabel(updatedLabel.toString());
      }
    }
  }

  /**
   * Get the message used when displaying confirm delete dialog to the end-user.
   * @return
   */
  protected abstract String[] getConfirmDeleteMessage();

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    // Do nothing.
    return null;
  }

  /**
   * Close the editor related to given model element if any.<br>
   * Default implementation does nothing.
   * @param modelElement_p
   * @return <code>true</code> means the editor is correctly closed and given model element can be safely deleted.<br>
   *         Default implementation returns <code>true</code>.
   */
  protected boolean closeEditor(NamedModelElementWithId modelElement_p) {
    // Do nothing.
    return true;
  }

  /**
   * Close the editor for given model element file (if an editor is open).
   * @param modelElementFile_p a file that an editor is open for.
   * @param editorId_p the id of the editor responsible to open given model element.
   * @return true if successfully performed.
   */
  protected boolean closeFileEditor(IFile modelElementFile_p, String editorId_p) {
    boolean result = true;
    // Get the path for given model element file.
    String modelElementPath = modelElementFile_p.getFullPath().toString();
    // Get all open editors for given id.
    IEditorReference[] allOpenMappingEditors = WorkbenchHelper.getAllOpenEditors(editorId_p);
    IEditorPart modelElementEditor = null;
    // Loop over the open ones, to seek for an editor opened on given model element.
    for (int i = 0; i < allOpenMappingEditors.length && (null == modelElementEditor); i++) {
      IEditorReference currentEditorRefernce = allOpenMappingEditors[i];
      // Get the editor for the current editor reference.
      IEditorPart currentEditor = currentEditorRefernce.getEditor(false);
      // Get the editor input.
      IEditorInput editorInput = currentEditor.getEditorInput();
      URI resourceURI = EditUIUtil.getURI(editorInput);
      String currentEditorInputPath = resourceURI.toPlatformString(true);
      if (modelElementPath.equals(currentEditorInputPath)) {
        modelElementEditor = currentEditor;
      }
    }
    // If found, close it.
    if (null != modelElementEditor) {
      result = WorkbenchHelper.closeEditor(modelElementEditor, false);
    }
    return result;
  }
}