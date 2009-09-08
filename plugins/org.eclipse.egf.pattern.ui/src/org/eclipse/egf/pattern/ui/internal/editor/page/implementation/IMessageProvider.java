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

/**
 * Get a displayable message from various inputs.
 * @author Guillaume Brocard
 */
public interface IMessageProvider {
  /**
   * Get displayable message from given object.
   * @param object_p
   * @return
   */
  public String getMessageFor(Object object_p);
}
