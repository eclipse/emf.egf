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
package org.eclipse.egf.model.edit.command.plugin;

import java.util.List;

import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * @author fournier
 */
public abstract class PluginChangeWrapperCommand extends AbstractOverrideableCommand {
  /**
   * This is the model element object upon which the command will act.
   */
  private NamedModelElementWithId _modelElement;

  /**
   * The value.
   */
  private Object _value;

  /**
   * This is the feature of the model element object upon the command will act.
   */
  private EStructuralFeature _feature;
  /**
   * Id of the plug-in that hosts the factory component where the model element object is contained by.
   */
  private String _pluginId;

  /**
   * Constructor.
   * @param domain_p
   */
  protected PluginChangeWrapperCommand(EditingDomain domain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(domain_p);
    _modelElement = (NamedModelElementWithId) modelElement_p;
    _feature = feature_p;
    _value = value_p;
  }

  /**
   * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doExecute()
   */
  @Override
  public final void doExecute() {
    performExecution(getExecutablePluginChangeCommand());
  }

  /**
   * Returns the extension changes command used in the execute call.
   * @return
   */
  protected abstract List<IPluginChangesCommand> getExecutablePluginChangeCommand();

  /**
   * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doCanUndo()
   */
  @Override
  public boolean doCanUndo() {
    // Default behavior is to not allow the undo.
    // Each command has to tell if it is possible or not to undo the regarding operation.
    return false;
  }

  /**
   * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doRedo()
   */
  @Override
  public final void doRedo() {
    performExecution(getRedoablePluginChangeCommand());
  }

  /**
   * Returns the extension changes command used in the redo call.<br>
   * Default implementation calls {@link #getExecutablePluginChangeCommand()}
   * @return
   */
  protected List<IPluginChangesCommand> getRedoablePluginChangeCommand() {
    return getExecutablePluginChangeCommand();
  }

  /**
   * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doUndo()
   */
  @Override
  public final void doUndo() {
    performExecution(getUndoablePluginChangeCommand());
  }

  /**
   * Returns the extension changes command used in the undo call.
   * @return
   */
  protected abstract List<IPluginChangesCommand> getUndoablePluginChangeCommand();

  /**
   * Perform the execution of an {@link IPluginChangesCommand}
   * @param commandList_p
   */
  private void performExecution(List<IPluginChangesCommand> commandList_p) {
    getCommandRunner().performChangesOnPlugin(getPluginId(), commandList_p);
  }

  /**
   * Get the plug-in changes command runner.
   * @return
   */
  protected IPluginChangesCommandRunner getCommandRunner() {
    return getMDSoFaPde().getPluginChangesCommandRunner();
  }

  /**
   * Get the model element object upon which this command will act.
   * @return
   */
  protected NamedModelElementWithId getModelElement() {
    return _modelElement;
  }

  /**
   * Get the feature of the model element object upon the command will act.
   * @return
   */
  protected EStructuralFeature getFeature() {
    return _feature;
  }

  /**
   * Get the modified value.
   * @return
   */
  protected Object getValue() {
    return _value;
  }

  /**
   * Set given plug-in id.
   * @param pluginId_p
   */
  public void setPluginId(String pluginId_p) {
    _pluginId = pluginId_p;
  }

  /**
   * Get Id of the plug-in that hosts the factory component where the model element object is contained by.
   * @return can be null if not set by {@link #setPluginId(String)}
   */
  protected String getPluginId() {
    return _pluginId;
  }

  /**
   * Return the MDSoFA PDE activator.
   * @return
   */
  protected EgfPdeActivator getMDSoFaPde() {
    return EgfPdeActivator.getDefault();
  }

  /**
   * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
   */
  @Override
  protected boolean prepare() {
    // If plug-in id is retrieved, it means the plug-in is located in workspace, all right !
    return (null != getPluginId());
  }
}
