/*******************************************************************************
 * Copyright (c) 2005, 2007 ILOG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Joel Cheuoua - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jet.internal.editor.contentassist;

import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

public abstract class AbstractJETAssistProcessor implements IContentAssistProcessor {
  protected JETTextEditor editor;
  public AbstractJETAssistProcessor(JETTextEditor editor) {
    this.editor = editor;
  }

  public String getErrorMessage() {
    // TODO Auto-generated method stub
    return null;
  }

}
