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
package org.eclipse.egf.core.ui.command;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Implements a runnable command by the EMF command stack.<br>
 * This command deals with modified model element objects described in a change description.<br>
 * @author fournier
 */
public class ChangeDescriptionWrapperCommand extends AbstractOverrideableCommand {

  /**
   * Change description that contains changes on a model element object.
   */
  private ChangeDescription _changeDescription;

  /**
   * Constructor.
   * @param domain_p
   */
  public ChangeDescriptionWrapperCommand(EditingDomain domain_p) {
    this(domain_p, Messages.ChangeDescriptionWrapperCommand_Command_Title);
  }

  /**
   * Constructor.
   * @param domain_p
   * @param label_p
   */
  public ChangeDescriptionWrapperCommand(EditingDomain domain_p, String label_p) {
    super(domain_p, label_p);
  }

  /**
   * Constructor.
   * @param domain_p
   * @param label_p
   * @param description_p
   */
  public ChangeDescriptionWrapperCommand(EditingDomain domain_p, String label_p, String description_p) {
    super(domain_p, label_p, description_p);
  }

  /**
   * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doExecute()
   */
  @Override
  public void doExecute() {
    // Do nothing because changes are already done by the change recorder.
  }

  /**
   * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doRedo()
   */
  @Override
  public void doRedo() {
    _changeDescription.applyAndReverse();

  }

  /**
   * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doUndo()
   */
  @Override
  public void doUndo() {
    _changeDescription.applyAndReverse();
  }

  /**
   * Set given change description.
   * @param changeDescription_p the changeDescription to set
   */
  protected void setChangeDescription(ChangeDescription changeDescription_p) {
    _changeDescription = changeDescription_p;
  }

  /**
   * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
   */
  @Override
  protected boolean prepare() {
    // Can be executed if change description is set.
    return (null != _changeDescription);
  }

  /**
   * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doGetAffectedObjects()
   */
  @Override
  public Collection<?> doGetAffectedObjects() {
    return new ArrayList<Object>(_changeDescription.getObjectChanges().keySet());
  }
}
