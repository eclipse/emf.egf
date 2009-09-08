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
package org.eclipse.egf.pattern.ui.editor;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.internal.data.ModelElement;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;


/**
 * Provides services dealing with pattern editors.
 * @author Guillaume Brocard
 */
public class PatternEditorHelper {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternEditorHelper.class.getPackage().getName());

  /**
   * Return whether or not a pattern editor is already open for given pattern.
   * @param patternModel_p
   * @return <code>null</code> means no editor opened for given pattern; otherwise the related {@link IEditorPart}.
   */
  public static IEditorPart isPatternEditorOpen(PatternModel patternModel_p) {
    IEditorPart result = null;
    // Precondition : the first check is to see if the given pattern model as an editor input.
    IEditorInput patternEditorInput = (IEditorInput) ((ModelElement) patternModel_p).getAdapter(PatternEditorInput.class);
    if (patternEditorInput == null) {
      // No editor input means no open editor.
      return result;
    }
    // Get all open pattern editors.
    IEditorReference[] allOpenPatternEditors = WorkbenchHelper.getAllOpenEditors(PatternEditor.class.getName());
    // Loop over the open ones, to seek for an editor opened for given pattern.
    for (int i = 0; i < allOpenPatternEditors.length && (null == result); i++) {
      IEditorReference currentEditor = allOpenPatternEditors[i];
      IEditorInput currentEditorInput = null;
      try {
        // Get the editor input.
        currentEditorInput = currentEditor.getEditorInput();
        // Check if a pattern is successfully retrieved.
        if (patternEditorInput == currentEditorInput) {
          result = currentEditor.getEditor(false);
        }
      } catch (PartInitException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("PatternEditorHelper.isPatternEditorOpen(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
    return result;
  }

  /**
   * Get the editor input for given {@link PatternModel} element.
   * @param pattern_p
   * @param editable_p whether or not the pattern is editable.
   * @return a not null editor input.
   */
  public static IEditorInput getEditorInput(PatternModel pattern_p, boolean editable_p) {
    ModelElement patternAsModelElement = (ModelElement) pattern_p;
    // Get a potential editor input registered on the selected pattern.
    PatternEditorInput editorInput = (PatternEditorInput) patternAsModelElement.getAdapter(PatternEditorInput.class);
    // If not found, create it.
    if (editorInput == null) {
      // Get the plug-in id of the factory component container for created pattern.
      FactoryComponent fc = ModelHelper.getFactoryComponentContainer(pattern_p);
      // Create an editor input regarding the selected pattern and factory component id.
      editorInput = new PatternEditorInput(fc.getId(), pattern_p, editable_p);
      patternAsModelElement.setAdapter(PatternEditorInput.class, editorInput);
    }
    return editorInput;
  }
  
}