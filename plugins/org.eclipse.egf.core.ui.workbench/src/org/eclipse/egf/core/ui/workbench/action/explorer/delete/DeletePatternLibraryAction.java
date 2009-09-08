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

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;


/**
 * Implements an action to delete a pattern library.
 * @author Guillaume Brocard
 */
public class DeletePatternLibraryAction extends DeleteModelElementAction {
  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public DeletePatternLibraryAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#getConfirmDeleteMessage()
   */
  @Override
  protected String[] getConfirmDeleteMessage() {
    String[] message = { Messages.DeletePatternLibraryAction_Message, getModelElement().getName() };
    return message;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return PatternLibrary.class;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#doDeleteModelElement()
   */
  @Override
  protected void doDeleteModelElement() {
    PatternLibrary patternLibrary = getPatternLibrary();
    // Get the hosting project before removing the pattern.
    IProject project = ModelHelper.getProject(patternLibrary);
    // Before removing the selected library, remove all contained patterns and pattern libraries.
    deleteSubLibraries(patternLibrary);
    // Delete the selected library in plug-in file.
    super.doDeleteModelElement();
    // Refresh the project
    ProjectHelper.refreshProject(project, IResource.DEPTH_INFINITE, new NullProgressMonitor());
  }

  /**
   * Delete sub libraries for specified library.
   * @param library_p
   */
  private void deleteSubLibraries(PatternLibrary library_p) {
    // Clone the list to prevent from concurrent modifications.
    ArrayList<AbstractPatternElement> patternElementList = new ArrayList<AbstractPatternElement>(library_p.getPatternElements());
    // Iterate over contained patterns and sub libraries to delete.
    Iterator<AbstractPatternElement> patternElements = patternElementList.iterator();
    while (patternElements.hasNext()) {
      AbstractPatternElement currentPatternElement = patternElements.next();
      // If current pattern element is a pattern library recurse on it.
      if (currentPatternElement instanceof PatternLibrary) {
        // Don't delete a sub pattern library itself because deleting parent library also delete libraries as children in plug-in file.
        deleteSubLibraries((PatternLibrary) currentPatternElement);
      }
      // If current pattern element is a pattern, close the open pattern editor if any and delete it.
      else if (currentPatternElement instanceof PatternModel) {
        deletePattern((PatternModel) currentPatternElement);
      }
    }
  }

  /**
   * Delete given pattern.
   * @param pattern_p
   */
  private void deletePattern(PatternModel pattern_p) {
    DeletePatternAction deletePatternAction = new DeletePatternAction(getShell(), getSelectionProvider(), isReadOnly());
    deletePatternAction.setSelectedElement(pattern_p);
    deletePatternAction.setUserConfirmationRequested(false);
    deletePatternAction.setRefreshProject(false);
    deletePatternAction.run();
  }

  /**
   * Get the pattern library.
   * @return
   */
  private PatternLibrary getPatternLibrary() {
    return (PatternLibrary) getModelElement();
  }
}