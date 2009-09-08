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
package org.eclipse.egf.model.edit.command.plugin.fci;

import java.util.Collections;

import org.eclipse.egf.common.misc.PlatformLocationType;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.helper.FactoryComponentHelper;
import org.eclipse.egf.pde.plugin.manifest.command.ManifestChangeCommandFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Base class to implement that wraps an factory component invocation modification in plug-in files.
 * @author Guillaume Brocard
 */
public abstract class AbstractFactoryComponentInvocationWrapperCommand extends PluginChangeWrapperCommand {
  /**
   * Constructor.
   * @param domain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  protected AbstractFactoryComponentInvocationWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * Remove a factory component dependency related to given factory component id.
   * @param fcIdDependency_p
   */
  protected void removeFactoryComponentDependency(String fcIdDependency_p) {
    // Get the plug-in that hosts given factory component id dependency.
    String[] requiredPlugin = { getFactoryComponentDependencyPluginId(fcIdDependency_p) };
    // Remove this plug-in id as a new required plug-in from the plug-in that hosts handled factory component invocation.
    getCommandRunner().performChangesOnManifest(getPluginId(), Collections.singletonList(ManifestChangeCommandFactory.unsetRequiredPlugins(requiredPlugin)));
  }

  /**
   * Add a factory component dependency related to given factory component id.
   * @param fcIdDependency_p
   */
  protected void addFactoryComponentDependency(String fcIdDependency_p) {
    // Get the plug-in that hosts given factory component id dependency.
    String[] requiredPlugin = { getFactoryComponentDependencyPluginId(fcIdDependency_p) };
    // Add this plug-in id as a new required plug-in for the plug-in that hosts handled factory component invocation.
    getCommandRunner().performChangesOnManifest(getPluginId(), Collections.singletonList(ManifestChangeCommandFactory.setRequiredPlugins(requiredPlugin)));
  }

  /**
   * Return the id of the plug-in that hosts given factory component id dependency.
   * @param fcIdDependency_p
   * @return
   */
  protected String getFactoryComponentDependencyPluginId(String fcIdDependency_p) {
    return FactoryComponentHelper.getPluginId(fcIdDependency_p, PlatformLocationType.WORKSPACE_THEN_TARGET_PLATFORM);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand#doCanUndo()
   */
  @Override
  public boolean doCanUndo() {
    return true;
  }
}