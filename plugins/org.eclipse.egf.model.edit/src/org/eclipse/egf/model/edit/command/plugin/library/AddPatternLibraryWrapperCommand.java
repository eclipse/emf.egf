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
package org.eclipse.egf.model.edit.command.plugin.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.pde.pattern.plugin.command.PatternExtensionFactory;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a pattern library modification in a pattern extension.
 * @author Guillaume Brocard
 */
public class AddPatternLibraryWrapperCommand extends PluginChangeWrapperCommand {
  
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AddPatternLibraryWrapperCommand(
    EditingDomain domain_p, 
    EObject modelElement_p, 
    EStructuralFeature feature_p, 
    Object value_p
  ) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    // Get the added pattern library.
    PatternLibrary patternLibrary = (PatternLibrary) getValue();
    // Create a command to change the plug-in file accordingly.
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Add commands for the library and its children (recursively).
    addLibraryCommands(patternLibrary, commands);
    return commands;
  }

  /**
   * Add library commands recursively (including itself).
   * @param library_p
   * @param commands_p
   */
  private void addLibraryCommands(PatternLibrary library_p, List<IPluginChangesCommand> commands_p) {
    // Add library command.
    commands_p.add(
      PatternExtensionFactory.setPatternLibraryExtension(
        library_p.getId(), 
        library_p.getName(), 
        library_p.getProductionOrchestration(), 
        library_p.getRuntimeOrchestration()
      )
    );
    // Add children commands.
    EList<AbstractPatternElement> patternElements = library_p.getPatternElements();
    if (patternElements.isEmpty() == false) {
      for (AbstractPatternElement abstractPatternElement : patternElements) {
        if (abstractPatternElement instanceof PatternLibrary) {
          // This child is a library, go for it recursively.
          addLibraryCommands((PatternLibrary) abstractPatternElement, commands_p);
        } else {
          // This child is a pattern, add it.
          PatternModel pattern = (PatternModel) abstractPatternElement;
          commands_p.add(
            PatternExtensionFactory.setPatternExtension(
              pattern.getId(), 
              pattern.getName(), 
              pattern.getPath()
            )
          );
        }
      }
    }
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