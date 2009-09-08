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

import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Text;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EAttribute;

import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.misc.PlatformLocationType;
import org.eclipse.egf.common.ui.helper.DataBindingHelper;
import org.eclipse.egf.common.ui.toolkit.fields.CStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.internal.databinding.UpdateWizardPage;
import org.eclipse.egf.core.ui.wizard.AbstractModelElementWizard;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.helper.FactoryComponentHelper;


/**
 * Base class to implement wizard pages for EGF model element objects.
 * @author fournier
 */
public abstract class AbstractModelElementWizardPage extends AbstractWizardPage {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractModelElementWizardPage.class.getPackage().getName());
  
  /**
   * Class loader of the project where displayed data are stored.
   */
  private ClassLoader _hostingProjectClassLoader;
  
  /**
   * Bundle where displayed data are stored.
   */
  private Bundle _hostingBundle;  

  /**
   * Constructor.
   * @param pageName_p
   * @param modelElement_p
   */
  public AbstractModelElementWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   * @param modelElement_p
   */
  public AbstractModelElementWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * Get the model element object displayed in this page.
   * @return the modelElement
   */
  protected NamedModelElementWithId getModelElement() {
    return getModelElementWizard().getModelElement();
  }

  /**
   * Get the parent object of the handled model element.
   * @return
   */
  protected NamedModelElementWithId getParent() {
    return (NamedModelElementWithId) getModelElementWizard().getParent();
  }

  /**
   * Return the wizard that contains this page as an {@link AbstractModelElementWizard} instance.
   * @return
   */
  protected AbstractModelElementWizard getModelElementWizard() {
    return (AbstractModelElementWizard) getWizard();
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#isReadOnly()
   */
  @Override
  protected boolean isReadOnly() {
    return getModelElementWizard().isInReadOnlyMode();
  }

  /**
   * Validate given field editors
   * @param fieldEditors_p
   * @return true means all field editors are valid; false otherwise.
   */
  protected boolean handleFieldEditorValidation(IFieldEditor[] fieldEditors_p) {
    // Overall validation state
    boolean isValid = true;
    // Precondition: read only means the page is not editable hence it is useless to valid contained field editors.
    if (getModelElementWizard().isInReadOnlyMode()) {
      // Clear the potential error message if any.
      setErrorMessage(null);
      // Return the page is valid.
      return isValid;
    }
    // Error message is one of given field editors is not valid.
    String errorMessage = null;
    // Loop over given field editors.
    for (int i = 0; i < fieldEditors_p.length && isValid; i++) {
      IFieldEditor fieldEditor = fieldEditors_p[i];
      isValid = fieldEditor.isValid();
      // If not valid, get the error message
      if (!isValid) {
        errorMessage = fieldEditor.getErrorMessage();
      }
    }
    // Set the wizard page error message, if one field is not validated.
    if (null != errorMessage) {
      setErrorMessage(errorMessage);
    }
    return isValid;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return ((AbstractModelElementWizard) getWizard()).getDescription();
  }

  /**
   * Set and show an error for given {@link CStringFieldEditor} instance.
   * @param fieldEditor_p
   * @param errorMessage_p
   */
  protected void showErrorMessage(CStringFieldEditor fieldEditor_p, String errorMessage_p) {
    fieldEditor_p.setErrorMessage(errorMessage_p);
    fieldEditor_p.showErrorMessage();
  }

  /**
   * Create a data binding between given Text control and a given attribute for given model element.
   * @param text_p the control.
   * @param event_p event type to register for change events.
   * @param feature_p the observed feature.
   * @param modelElement_p the object.
   * @param featureValueChangeListener_p if provided, it is registered to the created {@link IObservableValue} object based on feature_p.
   */
  protected void bindTextToAttribute(Text text_p, EAttribute feature_p, NamedModelElementWithId modelElement_p, UpdateWizardPage featureValueChangeListener_p) {
    bindTextToAttribute(text_p, feature_p.getName(), modelElement_p, featureValueChangeListener_p);
  }

  /**
   * Create a data binding between given Text control and a given property name for given model element.
   * @param text_p the control.
   * @param event_p event type to register for change events
   * @param propertyName_p the observed property name.
   * @param modelObject_p the object.
   * @param featureValueChangeListener_p if provided, it is registered to the created {@link IObservableValue} object based on feature_p.
   */
  protected void bindTextToAttribute(Text text_p, String propertyName_p, Object modelElement_p, UpdateWizardPage featureValueChangeListener_p) {
    UpdateWizardPage featureValueChangeListener = (null != featureValueChangeListener_p) ? featureValueChangeListener_p : new UpdateWizardPage(this);
    DataBindingHelper.bindTextToProperty(text_p, propertyName_p, modelElement_p, featureValueChangeListener);
  }

  /**
   * Return the project that hosts model element parent object.
   * @return null if the project is not found (the model element is located in an installed plug-in).
   */
  protected IJavaProject getHostingProject() {
    IJavaProject javaProject = null;
    // Get the project that hosts the retrieved factory component.
    IProject project = ModelHelper.getProject(getParent());
    if (project != null) {
      // Get the java project for the retrieved factory component project.
      javaProject = ProjectHelper.getJavaProject(project.getName());
    }
    return javaProject;
  }

  /**
   * Return the id of the plug-in that hosts model element parent object.
   * @return null if not found.
   */
  protected String getHostingPluginId() {
    // Get the factory component that hosts current model element.
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(getParent());
    // Get the plug-in id that hosts the retrieved factory component.
    String hostingPluginId = FactoryComponentHelper.getPluginId(fcContainer.getId(), PlatformLocationType.WORKSPACE_ONLY);
    return hostingPluginId;
  }

  /**
   * Return the class loader of the hosting project {@link #getHostingProject()}.
   * @return a class loader or null if an error occurs.
   */
  protected ClassLoader getHostingProjectClassLoader() {
    // Lazy creation pattern.
    if (_hostingProjectClassLoader == null) {
      // Get the java project for the hosting project.
      IJavaProject javaProject = getHostingProject();
      // Precondition.
      if (javaProject == null) {
        return _hostingProjectClassLoader;
      }
      try {
        // Get the class loader of the retrieved java project.
        _hostingProjectClassLoader = ProjectHelper.getClassLoaderFor(javaProject, getClass().getClassLoader());
      } catch (Exception exception_p) {
        StringBuilder loggerMessage = new StringBuilder("AbstractNamedElementWizardPage.getHostingProjectClassLoader(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
    return _hostingProjectClassLoader;
  }

  
  /**
   * Return the bundle of the hosting project {@link #getBundle()}.
   * @return a bundle or null.
   */
  protected Bundle getHostingBundle() {
    if (_hostingBundle == null) {
      _hostingBundle = CoreActivator.getDefault().getBundleForFactoryComponent(getParent());
    }
    return _hostingBundle;
  }
  
  /**
   * Return the adapter factory to use in EMF-based label and content provider.
   * @return a not null {@link AdapterFactory} instance.
   */
  protected AdapterFactory getAdapterFactory() {
    AdapterFactory result = 
        getModelElementWizard().isInReadOnlyMode() 
      ? EgfUiActivator.getDefault().getEditingDomainInReadOnly().getAdapterFactory()
      : EgfUiActivator.getDefault().getEditingDomain().getAdapterFactory();
    return result;
  }
  
}