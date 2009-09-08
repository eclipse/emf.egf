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

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ui.editor.PatternEditorHelper;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;


/**
 * Implements an action to delete a pattern.
 * @author Guillaume Brocard
 */
public class DeletePatternAction extends DeleteModelElementAction {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(DeletePatternAction.class.getPackage().getName());
  /**
   * Whether or not the project containing the selected pattern should be refreshed when the pattern is deleted.
   */
  private boolean _refreshProject;

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public DeletePatternAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    _refreshProject = true;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#getConfirmDeleteMessage()
   */
  @Override
  protected String[] getConfirmDeleteMessage() {
    String[] message = { Messages.DeletePatternAction_Message, getModelElement().getName() };
    return message;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return PatternModel.class;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#closeEditor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected boolean closeEditor(NamedModelElementWithId modelElement_p) {
    // Get an pattern editor opened on the selected pattern.
    IEditorPart patternEditorPart = PatternEditorHelper.isPatternEditorOpen(getPatternModel());
    boolean canDeletePattern = true;
    // Close the editor and discard changes.
    if (null != patternEditorPart) {
      // Close the editor and discard unsaved changes.
      canDeletePattern = WorkbenchHelper.closeEditor(patternEditorPart, false);
    }
    return canDeletePattern;
  }

  /**
   * Get the selected pattern element.
   * @return
   */
  private PatternModel getPatternModel() {
    return (PatternModel) getModelElement();
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#doDeleteModelElement()
   */
  @Override
  protected void doDeleteModelElement() {
    PatternModel pattern = getPatternModel();
    // Get the hosting project before removing the pattern for refresh purpose.
    IProject project = null;
    if (_refreshProject) {
      project = ModelHelper.getProject(pattern);
    }
    // Do delete model element please.
    super.doDeleteModelElement();
    // Perform additional stuffs.
    PatternHandler patternHandler = getPatternHandler(pattern);
    patternHandler.delete();
    if (_refreshProject) {
      // Refresh the project
      ProjectHelper.refreshProject(project, IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }
  }

  /**
   * Get pattern handler for given pattern.
   * @param pattern_p
   */
  protected PatternHandler getPatternHandler(PatternModel pattern_p) {
    PatternHandler patternHandler = null;
    // Precondition.
    if (null == pattern_p) {
      return patternHandler;
    }
    try {
      patternHandler = new PatternHandler();
      patternHandler.load(pattern_p.getPath());
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("DeletePatternAction.delete(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return patternHandler;
  }

  /**
   * Set whether or not the project is refresh when selected pattern is deleted.
   * @param refresh_p
   */
  public void setRefreshProject(boolean refresh_p) {
    _refreshProject = refresh_p;
  }
}