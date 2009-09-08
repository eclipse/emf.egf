/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.ui.editor.page;

import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * An external selection provider.<br>
 * See {@link IExternalSelectionHandler} for a definition of an external selection.
 * @author Guillaume Brocard
 */
public interface IExternalSelectionProvider {
  
  /**
   * Fire an external selection.
   * @param firstSelectedObject_p The first selected object of the selection.
   * @param selection_p The whole selection.
   */
  public void fireExternalSelection(Object firstSelectedObject_p, IStructuredSelection selection_p);
  
}
