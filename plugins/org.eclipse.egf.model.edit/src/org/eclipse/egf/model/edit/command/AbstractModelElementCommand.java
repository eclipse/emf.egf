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
package org.eclipse.egf.model.edit.command;

import java.util.Collection;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.misc.PlatformLocationType;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.helper.FactoryComponentHelper;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Base class to implement commands that modify a {@link NamedModelElementWithId} object with forwarding model element changes to related plug-in file.
 * @author fournier
 */
public abstract class AbstractModelElementCommand extends CompoundCommand {

  /**
   * Command to forward model element object changes in plug-in file.
   */
  private PluginChangeWrapperCommand _pluginChangeWrapperCommand;

  /**
   * The id of the plug-in in workspace that hosts the factory component that contains a model element object.
   */
  private String _workspacePluginId;

  private String _detailedLabel;

  /**
   * Constructor.
   * @param editingDomain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  protected AbstractModelElementCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(0);
    Command crudCommand = getCrudCommand(editingDomain_p, modelElement_p, feature_p, value_p);
    // If there is no crud command to run, do not append an useless command.
    if (null != crudCommand) {
      append(crudCommand);
    }
    _workspacePluginId = getPluginId((NamedModelElementWithId) modelElement_p);
  }

  /**
   * Get the initial EMF CRUD command to execute : SetCommand, AddCommand, ...
   * @param editingDomain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   * @return
   */
  protected abstract Command getCrudCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p);

  /**
   * Set the plug-in change command upon which the model element changes will be forwarded.
   * @param command_p
   */
  public void setPluginChangeCommand(PluginChangeWrapperCommand command_p) {
    _pluginChangeWrapperCommand = command_p;
  }

  /**
   * @see org.eclipse.emf.common.command.CompoundCommand#execute()
   */
  @Override
  public void execute() {
    // Execute the command appended in the constructor.
    super.execute();
    // Execute the plugin change wrapper command.
    doExecute();
  }

  /**
   * Forward modifications on plug-in file.
   */
  protected void doExecute() {
    // It should be not necessary to check this condition, command is only performed when a factory component is under development.
    if (isPluginLocatedInWorkspace() && (null != _pluginChangeWrapperCommand)) {
      // Set the plug-in id, the commands needs it to know which file (plug-in file) to modify.
      _pluginChangeWrapperCommand.setPluginId(_workspacePluginId);
      // Forward command changes to the plug-in file.
      appendAndExecute(_pluginChangeWrapperCommand);
    }
  }

  /**
   * Returns whether or not the model element object is contained into a factory component located in the workspace.
   * @return
   */
  private boolean isPluginLocatedInWorkspace() {
    return (null != _workspacePluginId);
  }

  /**
   * Get the id of the plug-in in workspace that hosts the factory component that contains model element object.
   * @return a string or null if the factory component is not defined in a plug-in located into the workspace.
   */
  private String getPluginId(NamedModelElementWithId modelElement_p) {
    FactoryComponent fc = ModelHelper.getFactoryComponentContainer(modelElement_p);
    return FactoryComponentHelper.getPluginId(fc.getId(), PlatformLocationType.WORKSPACE_ONLY);
  }

  /**
   * @see org.eclipse.emf.common.command.CompoundCommand#getLabel()
   */
  @Override
  public String getLabel() {
    if (null == _detailedLabel) {
      _detailedLabel = getDetailedLabel();
    }
    return _detailedLabel;
  }

  /**
   * Get the detailed label for this command.
   */
  protected String getDetailedLabel() {
    StringBuilder detailedLabel = new StringBuilder(super.getLabel());
    Collection<?> affectedObjects = getAffectedObjects();
    Object element = affectedObjects.iterator().next();
    // If affected object is one of our metamodel, let's go...
    if (element instanceof NamedModelElementWithId) {
      NamedModelElementWithId namedElement = (NamedModelElementWithId) element;
      // Get its name.
      String name = null;
      if (namedElement instanceof ContextElement) {
        name = DataHelper.getLabel((ContextElement) namedElement);
      } else {
        name = namedElement.getName();
      }
      // Avoid to get a not named model element.
      name = (null == name) ? ICommonConstants.EMPTY_STRING : name;
      // Append its classifier name and its name.
      detailedLabel.append(ICommonConstants.WHITE_SPACE_CHARACTER).append(namedElement.eClass().getName()).append(ICommonConstants.WHITE_SPACE_CHARACTER)
          .append(name);
    }
    return detailedLabel.toString();
  }
}
