/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.core.ui.contributor;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class MenuContributor {

  public static final String EXTENSION_ID = "org.eclipse.egf.core.ui.editor.menu.contributor"; //$NON-NLS-1$

  protected ISelection _selection;

  protected EditorActionBarContributor _parent;

  protected IEditorPart _activeEditorPart;

  public void setParentContributor(EditorActionBarContributor parent) {
    _parent = parent;
  }

  public abstract void menuAboutToShow(IMenuManager menuManager);

  public void setActiveEditor(IEditorPart part) {
    _activeEditorPart = part;
  }

  public void selectionChanged(SelectionChangedEvent event) {
    _selection = event.getSelection();
  }

}
