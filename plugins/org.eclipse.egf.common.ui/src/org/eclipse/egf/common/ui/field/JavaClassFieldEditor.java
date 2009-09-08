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

import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.ui.JavaUIMessages;
import org.eclipse.jdt.internal.ui.dialogs.OpenTypeSelectionDialog;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.common.ui.internal.validators.JavaClassValidator;
import org.eclipse.egf.common.ui.toolkit.validators.IValidator;


/**
 * Implements a field editor that allows the end-user to select a Java type.
 * @author fournier
 */
public class JavaClassFieldEditor extends ValidatingStringButtonFieldEditor {
  
  /**
   * Title displayed in the open type dialog.
   */
  private String _openTypeDialogTitle;   

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
  public JavaClassFieldEditor(
    String title_p, 
    String openTypeDialogTitle_p, 
    Composite parent_p,      
    Class<?> classTypeFilter_p
  ) {
    super(parent_p, title_p, null);
    _openTypeDialogTitle = openTypeDialogTitle_p;
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
    // Create a Java open type dialog.
    SelectionDialog dialog = new OpenTypeSelectionDialog(
      getShell(), 
      false, 
      PlatformUI.getWorkbench().getProgressService(), 
      null, 
      IJavaSearchConstants.CLASS_AND_INTERFACE,
      null
    );
    // Default dialog title.
    String dialogTitle = _openTypeDialogTitle;
    if (_classTypeFilter != null) {
      // Update the open type dialog title with filtered class name.
      String fullyQualifiedFilteredClassName = _classTypeFilter.getName();
      dialogTitle = getFormattedOpenTypeDialogTitle(fullyQualifiedFilteredClassName);
    }    
    // Set title and message.
    dialog.setTitle(dialogTitle);
    dialog.setMessage(JavaUIMessages.OpenTypeAction_dialogMessage);    
    return dialog;
  }

  /**
   * Set the class type filter used when opening the open type dialog.
   * @param classTypeFilter_p the classTypeFilter to set
   */
  public void setClassTypeFilter(Class<?> classTypeFilter_p) {
    _classTypeFilter = classTypeFilter_p;
    IValidator validator = getValidator();
    // Update the java class validator if any.
    if (validator != null && validator instanceof JavaClassValidator) {
      JavaClassValidator javaClassValidator = (JavaClassValidator) validator;
      javaClassValidator.setExpectedClassType(_classTypeFilter);
    }
  }
  
  /**
   * Get the formatted open type dialog title to take into account the filtered class name.
   * @param fullyQualifiedFilteredClassName_p
   */
  private String getFormattedOpenTypeDialogTitle(String fullyQualifiedFilteredClassName_p) {
    // Get the class short name.
    int lastDotIndex = fullyQualifiedFilteredClassName_p.lastIndexOf(ICommonConstants.DOT_CHARACTER);
    return MessageFormatHelper.formatMessage(
      _openTypeDialogTitle, new 
      String[] { 
        fullyQualifiedFilteredClassName_p.substring(lastDotIndex + 1) 
      }
    );
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