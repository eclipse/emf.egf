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
package org.eclipse.egf.core.ui.wizard;

import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;


/**
 * This wizard allows the end-user to create or edit a 'root' pattern library.<br>
 * A 'root' pattern library is a library which has a pattern viewpoint as parent.
 * @author Guillaume Brocard
 */
public class RootPatternLibraryWizard extends AbstractPatternLibraryWizard {
  /**
   * Constructor.
   * @param parent_p
   * @param modelElement_p
   * @param readOnlyMode_p
   * @param creationMode_p
   */
  public RootPatternLibraryWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p, boolean creationMode_p) {
    super(parent_p, modelElement_p, readOnlyMode_p, creationMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard#getAddCommandForCreatedElement(org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Command getAddCommandForCreatedElement(AdapterFactoryEditingDomain editingDomain_p, EObject parent_p, NamedModelElementWithId createdElement_p) {
    // Add the pattern library to its parent : ie a pattern viewpoint.
    return AddCommand.create(editingDomain_p, parent_p, ModelPackage.Literals.PATTERN_VIEWPOINT__LIBRARIES, createdElement_p);
  }
}