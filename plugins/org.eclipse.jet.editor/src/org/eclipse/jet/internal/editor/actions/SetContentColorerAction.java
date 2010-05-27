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
package org.eclipse.jet.internal.editor.actions;

import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.configuration.delegates.IJETDefaultTextColorerDelegate;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.*;
import org.eclipse.ui.dialogs.ListDialog;

public class SetContentColorerAction implements IEditorActionDelegate {
  private JETTextEditor editor;

  public SetContentColorerAction() {
  }

  public void setActiveEditor(IAction action, IEditorPart targetEditor) {
    editor = (JETTextEditor) targetEditor;
    action.setText("Set default content colorer ...");
  }

  public void run(IAction action) {
    ListDialog dialog = new ListDialog(editor.getSite().getShell());
    dialog.setLabelProvider(new LabelProvider() {
      public String getText(Object element) {
        if (element instanceof IJETDefaultTextColorerDelegate)
          return ((IJETDefaultTextColorerDelegate) element).getName();
        else
          return super.getText(element);
      }

      public Image getImage(Object element) {
        if (element instanceof IJETDefaultTextColorerDelegate)
          return ((IJETDefaultTextColorerDelegate) element).getImage();
        else
          return super.getImage(element);
      }
    });
    dialog.setContentProvider(new IStructuredContentProvider() {
      public Object[] getElements(Object inputElement) {
        return editor.getColorerDelegates();
      }
      public void dispose() {
      }
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO Auto-generated method stub        
      }
    });
    dialog.setTitle("JET default text content colorer");
    dialog.setMessage("Select the content colorer to the default text embeded in the JET template");
    dialog.setInitialSelections(editor.getColorerDelegates());
    dialog.setInput(editor);
    int result = dialog.open();
    if (result == 0) {
      IJETDefaultTextColorerDelegate delegate = (IJETDefaultTextColorerDelegate) dialog.getResult()[0];
      editor.setCurrentColorerDelegate(delegate);
    }
  }

  public void selectionChanged(IAction iaction, ISelection iselection) {
  }
}