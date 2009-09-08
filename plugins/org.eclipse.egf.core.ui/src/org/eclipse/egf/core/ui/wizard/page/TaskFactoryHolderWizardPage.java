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
package org.eclipse.egf.core.ui.wizard.page;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.egf.common.ui.field.JavaClassFieldEditor;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.core.task.ITaskFactory;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.ModelPackage;


/**
 * Implements the task factory holder wizard page.
 * @author fournier
 */
public class TaskFactoryHolderWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Field editor used to enter the task factory holder class.
   */
  private JavaClassFieldEditor _classFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   */
  public TaskFactoryHolderWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public TaskFactoryHolderWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create a field editor to enter the task factory class name.
    createClassFieldEditor(parent_p);
  }

  /**
   * Create the field editor to select the class.
   * @param parent_p
   */
  private void createClassFieldEditor(Composite parent_p) {
    // Entered name can not be null.
    _classFieldEditor = FieldEditorHelper.createJavaClassFieldEditor(
      parent_p, 
      this, 
      Messages.TaskFactoryHolderWizardPage_Class_Title,
      Messages.TaskFactoryHolderWizardPage_OpenTypeDialog_Title, 
      getHostingProjectClassLoader(),
      getHostingBundle(),
      ITaskFactory.class,
      isReadOnly()
    );
    // Task factory holder class name text.
    Text className = _classFieldEditor.getTextControl(parent_p);
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(
      className, 
      ModelPackage.Literals.TASK_FACTORY_HOLDER__FACTORY_CLASS, 
      getModelElement(), 
      null
    );
    // Update valid state.
    _classFieldEditor.isValid(true);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { _classFieldEditor };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.TaskFactoryHolderWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_TASK_FACTORY_PAGE;
  }
  
}
