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
 * Implementors of this interface are trying to make use of an external selection
 * that takes place elsewhere. Typically, an editor page might listen to the selection
 * in the outline, so as to show related details.<br>
 * This is intended to take place between UI concepts.
 * @author Guillaume Brocard
 */
public interface IExternalSelectionHandler {
  
  /**
   * Handle selection.
   * @param firstSelectedObject_p The first object selected in given structured selection.
   * @param selection_p The whole selection.
   */
  public void handleSelection(Object firstSelectedObject_p, IStructuredSelection selection_p);
  
}
