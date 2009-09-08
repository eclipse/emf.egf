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
package org.eclipse.egf.model.edit.command.plugin.pattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.common.helper.PatternLibrarySequenceHelper;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.pde.pattern.plugin.command.PatternExtensionFactory;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements a command that wraps a pattern modification in a pattern extension.
 * @author Guillaume Brocard
 */
public class RemovePatternWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public RemovePatternWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#getExecutablePluginChangeCommand()
   */
  @Override
  protected List<IPluginChangesCommand> getExecutablePluginChangeCommand() {
    // Get the removed pattern.
    PatternModel pattern = (PatternModel) getValue();
    // Create a command to change the plug-in file accordingly.
    ArrayList<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(2);
    // Remove the pattern as definition.
    String patternFullId = pattern.getId();
    commands.add(PatternExtensionFactory.unsetPatternExtension(patternFullId));
    // Remove the generated pattern.
    // commands.add(PatternExtensionFactory.unsetGeneratedPatternExtension(patternFullId));
    // Update orchestrations.
    PatternLibrary library = (PatternLibrary) getModelElement();
    // Update production orchestration, based on short id.
    updateOrchestration(ModelPackage.Literals.PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION, library, ModelHelper.getPatternElementShortId(pattern));
    // Update runtime orchestration based on full id.
    updateOrchestration(ModelPackage.Literals.PATTERN_LIBRARY__RUNTIME_ORCHESTRATION, library, patternFullId);
    return commands;
  }

  /**
   * Update orchestration specified by given attributes.
   * @param orchestrationAttribute_p
   * @param patternLibrary_p
   * @param previousPatternId_p
   * @param newPatternId_p
   */
  private void updateOrchestration(EAttribute orchestrationAttribute_p, PatternLibrary patternLibrary_p, String previousPatternId_p) {
    String orchestrationValue = (String) patternLibrary_p.eGet(orchestrationAttribute_p);
    if ((null != orchestrationValue) && (orchestrationValue.length() > 0)) {
      orchestrationValue = PatternLibrarySequenceHelper.removeIdFromSequence(orchestrationValue, previousPatternId_p);
      // Add a command to change the pattern library through editing domain mechanism to get plug-in file modification in benefit.
      Command command = SetCommand.create(domain, patternLibrary_p, orchestrationAttribute_p, orchestrationValue);
      domain.getCommandStack().execute(command);
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