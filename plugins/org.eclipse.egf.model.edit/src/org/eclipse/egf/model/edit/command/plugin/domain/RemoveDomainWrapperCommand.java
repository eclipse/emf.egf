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
package org.eclipse.egf.model.edit.command.plugin.domain;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a domain modification in factoryComponent extension.<br>
 * This command handles domain ecore file delete.
 * @author fournier
 */
public class RemoveDomainWrapperCommand extends AbstractDomainWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public RemoveDomainWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.domain.AbstractDomainWrapperCommand#handleDomainFile(java.lang.String)
   */
  @Override
  protected void handleDomainFile(String workspaceRelativeDomainPath_p) {
    // Delete file on disk.
    FileHelper.deleteFile(workspaceRelativeDomainPath_p);
    // Delete the potential diagram file.
    IPath diagramFile = new Path(workspaceRelativeDomainPath_p).removeFileExtension().addFileExtension(ICommonConstants.ECORE_DIAGRAM_FILE_EXTENSION);
    FileHelper.deleteFile(diagramFile.toString());
    // Delete the potential genmodel file.
    IPath genModelFile = new Path(workspaceRelativeDomainPath_p).removeFileExtension().addFileExtension(ICommonConstants.GENMODEL_FILE_EXTENSION);
    FileHelper.deleteFile(genModelFile.toString());
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.domain.AbstractDomainWrapperCommand#getRelativeToProjectDomainPath()
   */
  @Override
  protected String getRelativeToProjectDomainPath() {
    // Trick to get the removed path value.
    // Have a look at DeleteDomainAction (used open type dialog to retrieve this class).
    return (String) getValue();
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getUndoablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getUndoablePluginChangeCommand() {
    // Do nothing.
    return null;
  }
}