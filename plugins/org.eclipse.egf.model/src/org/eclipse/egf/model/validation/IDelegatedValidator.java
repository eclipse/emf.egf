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
package org.eclipse.egf.model.validation;

import java.util.Map;

import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * Provides a method to implement a model element delegated validator.
 * @author Guillaume Brocard
 */
public interface IDelegatedValidator {
  /**
   * Validate specified model element.<br>
   * Diagnostics are added in provided diagnostic chain if rules are not fulfilled.
   * @param modelElement_p
   * @param diagnostics_p
   * @param context_p
   * @return <code>false</code> means some rules are not fulfilled.
   */
  public boolean validate(NamedModelElementWithId modelElement_p, DiagnosticChain diagnostics_p, Map<Object, Object> context_p);
}
