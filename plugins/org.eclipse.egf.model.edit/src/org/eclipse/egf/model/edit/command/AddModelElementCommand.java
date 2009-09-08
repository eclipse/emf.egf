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

import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * Implements an Add command that modifies a {@link NamedModelElementWithId} object with forwarding model element changes to related plug-in file.
 * @author fournier
 */
public class AddModelElementCommand extends AbstractModelElementCommand {

  /**
   * Constructor.
   * @param editingDomain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   */
  public AddModelElementCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    super(editingDomain_p, modelElement_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.edit.command.AbstractModelElementCommand#getCrudCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected Command getCrudCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p) {
    return new AddCommand(editingDomain_p, modelElement_p, feature_p, value_p);
  }
}
