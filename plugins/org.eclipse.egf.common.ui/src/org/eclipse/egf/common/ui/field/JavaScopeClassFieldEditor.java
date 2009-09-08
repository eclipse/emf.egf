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
package org.eclipse.egf.common.ui.field;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.ui.JavaUIMessages;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jdt.internal.ui.dialogs.OpenTypeSelectionDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.SelectionDialog;

import org.eclipse.egf.common.ui.internal.field.FilteredJavaTypeSelectionExtension;


/**
 * Implements a field editor that allows the end-user to select a Java type.
 * @author Xavier Maysonnave
 */
public class JavaScopeClassFieldEditor extends ValidatingStringButtonFieldEditor {
  
  /**
   * Title displayed in the open type dialog.
   */
  private String _openTypeDialogTitle;
  
  /**
   * Java Project
   */
  private IJavaProject _javaProject;  
  
  /**
   * Class type used to filter end-user selection.
   */
  private Class<?> _classTypeFilter;  

  /**
   * Constructor.
   * @param title_p label of the text widget.
   * @param openTypeDialogTitle_p label displayed in the open type dialog.
   * @param parent_p
   * @param classTypeFilter_p class type filter used to filter end-user class selection.
   */
  public JavaScopeClassFieldEditor(
    String title_p, 
    String openTypeDialogTitle_p, 
    Composite parent_p, 
    IJavaProject javaProject_p,
    Class<?> classTypeFilter_p
  ) {
    super(parent_p, title_p, null);
    _openTypeDialogTitle = openTypeDialogTitle_p;
    _javaProject = javaProject_p;
    _classTypeFilter = classTypeFilter_p;
    addListeners();
  }

  /**
   * @see org.eclipse.egf.common.ui.field.ValidatingStringButtonFieldEditor#handleSelection(java.lang.Object)
   */
  @Override
  protected String handleSelection(Object selectedObject_p) {
    IType type = (IType) selectedObject_p;
    return type.getFullyQualifiedName();
  }

  /**
   * Create an {@link OpenTypeSelectionDialog}
   * @see org.eclipse.egf.common.ui.field.ValidatingStringButtonFieldEditor#createDialog()
   */
  @Override
  protected SelectionDialog createDialog() {
    FilteredTypesSelectionDialog dialog = new FilteredTypesSelectionDialog(
      getShell(),
      false, 
      new ProgressMonitorDialog(getShell()), 
      null,
      IJavaSearchConstants.CLASS,
      new FilteredJavaTypeSelectionExtension(_javaProject, _classTypeFilter)
    );
    dialog.setTitle(_openTypeDialogTitle);    
    dialog.setMessage(JavaUIMessages.OpenTypeAction_dialogMessage);
    dialog.setBlockOnOpen(true);
    return dialog;
  }

  /**
   * Add listeners on widgets contained by this field editor.
   */
  protected void addListeners() {
    getTextControl().addModifyListener(
      new ModifyListener() {
        /**
         * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
         */
        @SuppressWarnings("synthetic-access")
        public void modifyText(ModifyEvent e_p) {
          refreshValidState();
        }
      }
    );
  }
  
}