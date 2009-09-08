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
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.mapping.ui.editor.EGFMappingEditor;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;


/**
 * Implements an action to delete a mapping.
 * @author Guillaume Brocard
 */
public class DeleteMappingAction extends DeleteModelElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public DeleteMappingAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#getConfirmDeleteMessage()
   */
  @Override
  protected String[] getConfirmDeleteMessage() {
    MappingModel mapping = (MappingModel) getModelElement();
    String[] message = { Messages.DeleteMappingAction_Message, mapping.getPath() };
    return message;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return MappingModel.class;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#closeEditor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected boolean closeEditor(NamedModelElementWithId modelElement_p) {
    // Get the hosting project for given model element.
    IProject hostingProject = ModelHelper.getProject(modelElement_p);
    // Get the mapping file.
    IFile mappingFile = hostingProject.getFile(((MappingModel) modelElement_p).getPath());
    return closeFileEditor(mappingFile, EGFMappingEditor.ID);
  }
}