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
package org.eclipse.egf.model.contract.type;

import org.eclipse.egf.common.misc.ISelectionHandler;

/**
 * Hosts a java type to avoid Eclipse class loader issues through extension mechanism.<br>
 * Implementors have to provide a default constructor with no arguments.
 * @author fournier
 */
public interface ITypeHolder {
  /**
   * Is it standing for a java type (ie a class) ?
   * @return
   */
  public boolean isJava();

  /**
   * Is value string representation valid ?
   * @param value_p
   * @return
   */
  public boolean isValid(String value_p);

  /**
   * Convert value from string to object.
   * @param value_p
   * @return
   */
  public Object getValue(String value_p);

  /**
   * Set the id of the plug-in responsible to deal with the given value in {@link #getValue(String)} and {@link #isValid(String)}.<br>
   * The plug-in id is provided to get the related bundle to figure out class loader issues for instance.
   * @param pluginId_p must be the id of the plug-in not its name (e.g "org.eclipse.core.runtime").
   */
  public void setPluginId(String pluginId_p);

  /**
   * Return the class name of the selection dialog to open when 'Browse' button is pressed to enter the value of a type holder.<br>
   * The returned class must extend org.eclipse.ui.dialogs.SelectionDialog.<br>
   * The class must implement the following constructor <code>SelectionDialog(Shell parentShell)</code>.<br>
   * @return null if no selection dialog is provided.
   * @see #getSelectionHandler().
   */
  public String getSelectionDialog();

  /**
   * Return a class that is able to handle selected object returned by the selection dialog.<br>
   * @return null if no selection handler is provided.
   * @see #getSelectionDialog().
   */
  public ISelectionHandler getSelectionHandler();
}
