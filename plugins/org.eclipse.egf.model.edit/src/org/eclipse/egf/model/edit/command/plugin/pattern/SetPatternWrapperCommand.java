/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.edit.command.plugin.pattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.pde.pattern.plugin.command.PatternExtensionFactory;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a pattern modification in a pattern extension.
 * @author Guillaume Brocard
 */
public class SetPatternWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public SetPatternWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    ArrayList<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Get the modified pattern.
    PatternModel pattern = (PatternModel) getModelElement();
    // Create a command to change the plug-in file accordingly.
    commands.add(
      PatternExtensionFactory.setPatternExtension(
        pattern.getId(), 
        pattern.getName(), 
        pattern.getPath()
      )
    );
    return commands;
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