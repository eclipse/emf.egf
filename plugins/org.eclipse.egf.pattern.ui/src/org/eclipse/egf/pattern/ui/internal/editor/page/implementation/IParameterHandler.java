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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation;

import org.eclipse.egf.pattern.relations.ParameterRelation;

/**
 * Silly handler that allows the outline page and the pattern specification page to exchange parameters.
 * @author Guillaume Brocard
 */
public interface IParameterHandler {
  /**
   * Get parameter.
   * @return
   */
  ParameterRelation getParameter();
  /**
   * Is parameter inherited or not ?
   * @return
   */
  boolean isInherited();
}
