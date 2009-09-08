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
package org.eclipse.egf.core.ui.workbench.internal.navigator;

import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.pattern.ui.editor.PatternEditorHelper;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;


/**
 * Link helper to link a pattern editor with its pattern model in the FC views.
 * @author Guillaume Brocard
 */
public class PatternLinkHelper implements ILinkHelper {
  /**
   * @see org.eclipse.ui.navigator.ILinkHelper#activateEditor(org.eclipse.ui.IWorkbenchPage, org.eclipse.jface.viewers.IStructuredSelection)
   */
  public void activateEditor(IWorkbenchPage page_p, IStructuredSelection selection_p) {
    // Preconditions.
    if ((null == page_p) || (null == selection_p) || (selection_p.isEmpty())) {
      return;
    }
    Object element = selection_p.getFirstElement();
    if (element instanceof PatternModel) {
      IEditorPart part = PatternEditorHelper.isPatternEditorOpen((PatternModel) element);
      if (null != part) {
        page_p.activate(part);
      }
    }
  }

  /**
   * @see org.eclipse.ui.navigator.ILinkHelper#findSelection(org.eclipse.ui.IEditorInput)
   */
  public IStructuredSelection findSelection(IEditorInput anInput_p) {
    IStructuredSelection result = StructuredSelection.EMPTY;
    // Preconditions.
    if (null == anInput_p) {
      return result;
    }
    // Try to get its pattern model.
    PatternModel patternModel = (PatternModel) anInput_p.getAdapter(PatternModel.class);
    if (null != patternModel) {
      result = new StructuredSelection(patternModel);
    }
    return result;
  }
}
