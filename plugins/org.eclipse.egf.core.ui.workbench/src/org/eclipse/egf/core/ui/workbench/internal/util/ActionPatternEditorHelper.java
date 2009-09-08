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

import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.pattern.ui.editor.PatternEditorHelper;
import org.eclipse.ui.IEditorPart;


/**
 * A pattern editor helper dedicated to actions.<br>
 * For a more general helper, see {@link PatternEditorHelper}.
 * @author Guillaume Brocard
 */
public class ActionPatternEditorHelper {
  /**
   * The unique pattern editor listener used to monitor closing event for all open pattern editors.
   */
  private static ClosePatternEditorListener _patternEditorListener;

  /**
   * Add given pattern editor part and its pattern model to the listener that listens to pattern editor closing event.
   * @param patternEditorPart_p
   * @param pattern_p
   */
  public static void addPatternEditorToListener(IEditorPart patternEditorPart_p, PatternModel pattern_p) {
    // Lazy pattern creation.
    if (null == _patternEditorListener) {
      // Create it.
      _patternEditorListener = new ClosePatternEditorListener();
      // Add it to the active workbench page.
      WorkbenchHelper.addPartListener(_patternEditorListener);
    }
    _patternEditorListener.addPatternEditorToMonitor(patternEditorPart_p, pattern_p);
  }
}
