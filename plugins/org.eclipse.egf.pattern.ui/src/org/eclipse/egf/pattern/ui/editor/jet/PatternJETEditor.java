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
package org.eclipse.egf.pattern.ui.editor.jet;

import org.eclipse.emf.codegen.jet.editor.presentation.JETEditor;

/**
 * @author Guillaume Brocard
 *
 */
public class PatternJETEditor extends JETEditor {
  /**
   * Pattern JET editor id.
   */
  public static final String EDITOR_ID = PatternJETEditor.class.getName();

  /**
   * @see org.eclipse.ui.part.EditorPart#setPartName(java.lang.String)
   */
  @Override
  public void setPartName(String partName_p) {
    super.setPartName(partName_p);
  }
  
}
