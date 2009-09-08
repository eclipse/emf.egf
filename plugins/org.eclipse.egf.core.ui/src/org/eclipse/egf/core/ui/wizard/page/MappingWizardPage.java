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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.ui.field.ValidatingStringButtonFieldEditor;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.internal.databinding.ReferencedFactoryComponent;
import org.eclipse.egf.core.ui.internal.databinding.ValueChangeHandler;
import org.eclipse.egf.core.ui.internal.dialogs.FactoryComponentSelectionDialog;
import org.eclipse.egf.core.ui.internal.field.ModelElementButtonFieldEditor;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.internal.validators.ReferencedFactoryComponentValidator;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Implement the mapping wizard page.
 * @author Guillaume Brocard
 */
public class MappingWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Relative domain folder path where mapping files are located.
   */
  protected static final String MAPPING_RELATIVE_FOLDER_PATH = "model/mapping"; //$NON-NLS-1$
  
  /**
   * Mapping extension file.
   */
  private static final String MAPPING_FILE_EXTENSION = ".ecore2ecore"; //$NON-NLS-1$
  
  /**
   * Field editor used to enter the mapping name.
   */
  private ValidatingStringFieldEditor _mappingNameFieldEditor;
  
  /**
   * Field editor used to enter the mapping id.
   */
  private ValidatingStringFieldEditor _mappingIdFieldEditor;
  
  /**
   * Field editor used to select the factory component that the domain is coming from as source of the created mapping.
   */
  private ValidatingStringButtonFieldEditor _fcAsSourceFieldEditor;
  
  /**
   * Store the id of the factory component that the domain is coming from as source of the created mapping.
   */
  protected String _fcIdForSource;
  
  /**
   * Field editor used to select the factory component that the domain is coming from as target of the created mapping.
   */
  private ValidatingStringButtonFieldEditor _fcAsTargetFieldEditor;

  /**
   * Store the id of the factory component that the domain is coming from as target of the created mapping.
   */
  protected String _fcIdForTarget;

  /**
   * Constructor.
   * @param pageName_p
   */
  public MappingWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public MappingWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create a field editor to enter the mapping id.
    createMappingIdFieldEditor(parent_p);
    // Create a field editor to enter the mapping name.
    createMappingNameFieldEditor(parent_p);
    // Create a field editor to enter the factory component used as source.
    createMappingSourceFieldEditor(parent_p);
    // Create a field editor to enter the factory component used as target.
    createMappingTargetFieldEditor(parent_p);
    // Finally, call the super method to layout the page.
    handlePageLayout(parent_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#handlePageLayout(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void handlePageLayout(Composite parent_p) {
    // Force to layout the text field editor on the right size.
    FieldEditorHelper.layoutFieldEditor(parent_p, _mappingIdFieldEditor, 3);
    FieldEditorHelper.layoutFieldEditor(parent_p, _mappingNameFieldEditor, 3);
  }

  /**
   * Create the mapping source field editor.
   * @param parent_p
   */
  private void createMappingSourceFieldEditor(Composite parent_p) {
    ReferencedFactoryComponentValidator validator = new ReferencedFactoryComponentValidator(Messages.MappingWizardPage_FcAsSource_ErrorMessage) {
      /**
       * @see org.eclipse.egf.core.ui.internal.validators.ReferencedFactoryComponentValidator#handleReferencedFactoryComponentChange(java.lang.String)
       */
      @Override
      protected void handleReferencedFactoryComponentChange(String newReferencedFcIdValue_p) {
        _fcIdForSource = newReferencedFcIdValue_p;
      }
    };
    _fcAsSourceFieldEditor = ModelElementButtonFieldEditor.createModelElementButtonFieldEditor(
      parent_p, 
      this,
      Messages.MappingWizardPage_FcAsSource_Title,
      Messages.MappingWizardPage_FcAsSource_Tooltip,
      createFactoryComponentSelectionDialog(), 
      validator,
      isReadOnly()
    );
    // Get the referenced factory component as source from the mapping model source feature if any.
    NamedModelElementWithId fcAsSource = CoreActivator.getDefault().getFactoryComponent(getMappingModel().getSource());
    String referencedFcSourceName = (null != fcAsSource) ? fcAsSource.getName() : ICommonConstants.EMPTY_STRING;
    ReferencedFactoryComponent referencedFcAsSource = new ReferencedFactoryComponent(referencedFcSourceName);
    // Referenced factory component source name text
    Text referencedFcSourceNameText = _fcAsSourceFieldEditor.getTextControl(parent_p);
    // Create a value change listener to compute the referenced factory component id according to referenced factory component name.
    ValueChangeHandler valueChangeHandler = new ValueChangeHandler(this) {
      /**
       * @see org.eclipse.egf.core.ui.internal.databinding.ValueChangeHandler#doHandleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
       */
      @Override
      protected void doHandleValueChange(ValueChangeEvent event_p) {
        // Either set a null value (means no referenced factory component is retrieved) or a right one.
        getMappingModel().setSource(_fcIdForSource);
      }
    };
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(
      referencedFcSourceNameText, 
      ReferencedFactoryComponent.PROPERTY_NAME, 
      referencedFcAsSource, 
      valueChangeHandler
    );
    // Update valid state.
    _fcAsSourceFieldEditor.isValid(true);
  }

  /**
   * Create the mapping target field editor.
   * @param parent_p
   */
  private void createMappingTargetFieldEditor(Composite parent_p) {
    ReferencedFactoryComponentValidator validator = new ReferencedFactoryComponentValidator(Messages.MappingWizardPage_FcAsTarget_ErrorMessage) {
      /**
       * @see org.eclipse.egf.core.ui.internal.validators.ReferencedFactoryComponentValidator#handleReferencedFactoryComponentChange(java.lang.String)
       */
      @Override
      protected void handleReferencedFactoryComponentChange(String newReferencedFcIdValue_p) {
        _fcIdForTarget = newReferencedFcIdValue_p;
      }
    };
    _fcAsTargetFieldEditor = ModelElementButtonFieldEditor.createModelElementButtonFieldEditor(
      parent_p, 
      this,
      Messages.MappingWizardPage_FcAsTarget_Title,
      Messages.MappingWizardPage_FcAsTarget_Tooltip,
      createFactoryComponentSelectionDialog(), 
      validator,
      isReadOnly()
    );
    // Get the referenced factory component as target from the mapping model target feature if any.
    NamedModelElementWithId fcAsTarget = CoreActivator.getDefault().getFactoryComponent(getMappingModel().getTarget());
    String referencedFcTargetName = (null != fcAsTarget) ? fcAsTarget.getName() : ICommonConstants.EMPTY_STRING;
    ReferencedFactoryComponent referencedFcAsTarget = new ReferencedFactoryComponent(referencedFcTargetName);
    // Referenced factory component name text
    Text referencedFcNameAsTargetText = _fcAsTargetFieldEditor.getTextControl(parent_p);
    // Create a value change listener to compute the referenced factory component id according to referenced factory component name.
    ValueChangeHandler valueChangeHandler = new ValueChangeHandler(this) {
      /**
       * @see org.eclipse.egf.core.ui.internal.databinding.ValueChangeHandler#doHandleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
       */
      @Override
      protected void doHandleValueChange(ValueChangeEvent event_p) {
        // Either set a null value (means no referenced factory component is retrieved) or a right one.
        getMappingModel().setTarget(_fcIdForTarget);
      }
    };
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(
      referencedFcNameAsTargetText, 
      ReferencedFactoryComponent.PROPERTY_NAME, 
      referencedFcAsTarget, 
      valueChangeHandler
    );
    // Update valid state.
    _fcAsTargetFieldEditor.isValid(true);
  }

  /**
   * Create a factory component selection dialog.
   * @return
   */
  private FactoryComponentSelectionDialog createFactoryComponentSelectionDialog() {
    FactoryComponentSelectionDialog fcSelectionDialog = new FactoryComponentSelectionDialog(getShell());
    // Filtered factory components that do not have domains.
    List<FactoryComponent> filteredFcs = EgfUiActivator.getDefault().getTargetPlatformFactoryComponents();
    // Iterate over all factory components, remove the ones that do not have a domain.
    Iterator<FactoryComponent> iterator = filteredFcs.iterator();
    while (iterator.hasNext()) {
      FactoryComponent currentFc = iterator.next();
      // Remove the factory component that has a domain.
      if (ModelHelper.isDomainDefined(currentFc.getDomain())) {
        iterator.remove();
      }
    }
    // Append in filtered factory components those ones that come from the workspace.
    // At runtime the Ecore models involved as input or output must be in the target platform.
    // At the moment, the ecore2ecore serialization handles in different ways the reference to an Ecore model (for input or output) located in workspace than in
    // the target platform.
    // Hence, at runtime, an input (or output) that references a workspace Ecore model can not run because the path is wrong.
    filteredFcs.addAll(EgfUiActivator.getDefault().getWorkspaceFactoryComponents());
    fcSelectionDialog.setFilteredFactoryComponents(filteredFcs);
    return fcSelectionDialog;
  }

  /**
   * Create the mapping id field editor.
   * @param parent_p
   */
  private void createMappingIdFieldEditor(Composite parent_p) {
    // Entered string can not be null.
    _mappingIdFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.MappingWizardPage_Id_Title,
      Messages.MappingWizardPage_Id_Tooltip, 
      null, 
      SWT.DEFAULT,
      new NotEmptyStringValidator(Messages.MappingWizardPage_Id_ErrorMessage),
      isReadOnly()      
    );
    // Mapping ID text
    Text mappingIdText = _mappingIdFieldEditor.getTextControl();
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(mappingIdText, ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__ID, getModelElement(), null);
    // Update valid state.
    _mappingIdFieldEditor.isValid(true);
  }

  /**
   * Create the mapping name field editor.
   * @param parent_p
   */
  private void createMappingNameFieldEditor(Composite parent_p) {
    // Entered string can not be null.
    _mappingNameFieldEditor = FieldEditorHelper.createStringFieldEditor(
      parent_p, 
      this, 
      Messages.MappingWizardPage_Name_Title,
      Messages.MappingWizardPage_Name_Tooltip, 
      null, 
      SWT.DEFAULT,
      new NotEmptyStringValidator(Messages.MappingWizardPage_Name_ErrorMessage),
      isReadOnly()
    );
    // Mapping name text
    Text mappingNameText = _mappingNameFieldEditor.getTextControl();
    // Create a value change handler to compute the path according to the mapping name attribute.
    ValueChangeHandler handler = new ValueChangeHandler(this) {
      /**
       * @see org.eclipse.egf.core.ui.internal.databinding.ValueChangeHandler#doHandleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
       */
      @Override
      protected void doHandleValueChange(ValueChangeEvent event_p) {
        String mappingName = (String) event_p.diff.getNewValue();
        String mappingFilePath = null;
        if (null != mappingName) {
          // Avoid to have not compatible characters in file name.
          String mappingfileName = StringHelper.replaceNonWordCharactersWithDot(mappingName);
          mappingFilePath = new StringBuilder(
              MAPPING_RELATIVE_FOLDER_PATH
            ).append(
              ICommonConstants.SLASH_CHARACTER
            ).append(
              mappingfileName
            ).append(
              MAPPING_FILE_EXTENSION
            ).toString();
        }
        // Set the new path according to the new mapping file name.
        getMappingModel().setPath(mappingFilePath);
      }
    };
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(
      mappingNameText, 
      ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME, 
      getModelElement(), 
      handler
    );
    // Update valid state.
    _mappingNameFieldEditor.isValid(true);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // Field editors to validate.
    IFieldEditor[] fieldEditors = { 
      _mappingIdFieldEditor, 
      _mappingNameFieldEditor, 
      _fcAsSourceFieldEditor, 
      _fcAsTargetFieldEditor 
    };
    // Compute validation state.
    return handleFieldEditorValidation(fieldEditors);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.MappingWizardPage_Title;
  }

  /**
   * Return the mapping model.
   * @return
   */
  protected MappingModel getMappingModel() {
    return (MappingModel) getModelElement();
  }

  /**
   * Return the folder where mapping files are located.
   * @return
   */
  protected IFolder getMappingFolder() {
    IFolder result = null;
    // Get hosting project.
    IJavaProject hostingProject = getHostingProject();
    if (null != hostingProject) {
      IProject project = hostingProject.getProject();
      result = project.getFolder(MAPPING_RELATIVE_FOLDER_PATH);
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_MAPPING_WIZARD_PAGE;
  }
  
}