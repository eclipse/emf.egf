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
package org.eclipse.egf.core.ui.workbench.action.open;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.mapping.ui.editor.EGFMappingEditor;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;


/**
 * Implement an action that opens a mapping editor for a mapping model content.
 * @author Guillaume Brocard
 */
public class OpenMappingAction extends OpenModelElementAction {

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public OpenMappingAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.open.OpenModelElementAction#getEditorId()
   */
  @Override
  protected String getEditorId() {
    return EGFMappingEditor.ID;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.open.OpenModelElementAction#shouldSaveEditorAfterOpening()
   */
  @Override
  protected boolean shouldSaveEditorAfterOpening() {
    return true;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.open.OpenModelElementAction#getEditorInput()
   */
  @Override
  protected IEditorInput getEditorInput() {
    IEditorInput result = null;
    // Get the mapping model.
    MappingModel mappingModel = (MappingModel) getModelElement();
    // Get the project that hosts this mapping model.
    IProject project = ModelHelper.getProject(mappingModel);
    if (null != project) {
      // Get the mapping file.
      IFile mappingFile = project.getFile(new Path(mappingModel.getPath()));
      if (null != mappingFile) {
        // Create the editor input handled by the Mapping editor.
        result = new FileEditorInput(mappingFile);
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return MappingModel.class;
  }
}