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
package org.eclipse.jet.internal.editor.outline;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jet.core.parser.ast.JETCompilationUnit;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class JETOutlinePage extends ContentOutlinePage implements IAdaptable {
  private JETTextEditor editor;

  private TreeViewer contentOutlineViewer;

  public JETOutlinePage(JETTextEditor editor) {
    this.editor = editor;
  }

  public void createControl(Composite parent) {
    super.createControl(parent);
    contentOutlineViewer = getTreeViewer();
    contentOutlineViewer.addSelectionChangedListener(this);
    contentOutlineViewer.setContentProvider(new JETOutlineContentProvider(editor));
    contentOutlineViewer.setLabelProvider(new JETOutlineLabelProvider(editor));
    setInput();
  }

  public void setInput() {
    JETCompilationUnit cu = editor.requestCompilationUnit();
    contentOutlineViewer.setInput(cu);
    contentOutlineViewer.refresh();
  }

  public Object getAdapter(Class adapter) {
    return null;
  }
}
