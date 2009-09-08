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

import java.util.List;

import org.eclipse.egf.model.edit.command.AbstractModelElementCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Provides a support to have undo, redo mechanism for model element object changes performed through a change recorder.
 * @author fournier
 */
public class ChangeRecorderWrapperCommand extends AbstractModelElementCommand {
  /**
   * Constructor.
   * @param editingDomain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public ChangeRecorderWrapperCommand(ChangeDescription changes, EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p,
      Object value_p) {
    super(editingDomain_p, modelElement_p, feature_p, value_p);
    // Set given change description on the "crud" equivalent command.
    List<Command> commands = getCommandList();
    if (!commands.isEmpty()) {
      ChangeDescriptionWrapperCommand command = (ChangeDescriptionWrapperCommand) commands.get(0);
      command.setChangeDescription(changes);
    }
  }

  /**
   * @see org.eclipse.egf.model.edit.command.AbstractModelElementCommand#getCrudCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected Command getCrudCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    return new ChangeDescriptionWrapperCommand(editingDomain_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.AbstractModelElementCommand#getLabel()
   */
  @Override
  public String getLabel() {
    // Compute systematically the label.
    return getDetailedLabel();
  }
}
