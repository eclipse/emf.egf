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
package org.eclipse.egf.core.ui.workbench.internal.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.internal.data.ModelElement;
import org.eclipse.egf.pattern.ui.editor.PatternEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;


/**
 * Class for listening for pattern editor closing event.
 * @author Guillaume Brocard
 */
class ClosePatternEditorListener implements IPartListener {
  /**
   * Monitored open pattern editors.
   */
  private Map<IEditorPart, PatternModel> _handledPatternEditors;

  /**
   * Add given pattern editor and its pattern model in the list of pattern editors to monitor.
   * @param patternEditorPart_p
   * @param pattern_p
   */
  public void addPatternEditorToMonitor(IEditorPart patternEditorPart_p, PatternModel pattern_p) {
    // Lazy creation pattern.
    if (null == _handledPatternEditors) {
      _handledPatternEditors = new HashMap<IEditorPart, PatternModel>(1);
    }
    _handledPatternEditors.put(patternEditorPart_p, pattern_p);
  }

  /**
   * @see org.eclipse.ui.IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
   */
  public void partClosed(IWorkbenchPart part_p) {
    // Check if given part is one of our monitored pattern editors :
    // Try to remove the given part, and get the underlying pattern model.
    PatternModel pattern = _handledPatternEditors.remove(part_p);
    if (null != pattern) {
      // Given part is one of our pattern editors.
      // Reset the editor input on retrieved pattern model.
      ((ModelElement) pattern).setAdapter(PatternEditorInput.class, null);
    }
  }

  /**
   * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
   */
  public void partActivated(IWorkbenchPart part_p) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
   */
  public void partBroughtToTop(IWorkbenchPart part_p) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
   */
  public void partDeactivated(IWorkbenchPart part_p) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
   */
  public void partOpened(IWorkbenchPart part_p) {
    // Do nothing.
  }
}