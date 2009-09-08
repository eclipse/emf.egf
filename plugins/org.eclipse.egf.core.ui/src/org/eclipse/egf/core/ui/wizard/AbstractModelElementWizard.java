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
package org.eclipse.egf.core.ui.wizard;

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.command.ChangeRecorderWrapperCommand;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;


/**
 * Base class to implement wizards to create or edit EGF model element objects.
 * @author fournier
 */
public abstract class AbstractModelElementWizard extends Wizard {
  
  /**
   * Change recorder used to listen to model element changes.
   */
  private ChangeRecorder _changeRecorder;
  
  /**
   * Parent of edited or created model element object.
   */
  private EObject _parent;
  
  /**
   * Model element object displayed in this page.
   */
  private NamedModelElementWithId _modelElement;
  
  /**
   * Is the displayed object created when finishing ?
   */
  private boolean _isInCreationMode;
  
  /**
   * Is the wizard in read only mode : true means data can not be changed.
   */
  private boolean _isInReadOnly;
  
  /**
   * Wizard description.
   */
  private String _description;
  
  /**
   * ChangeDescription resulting from listening changes on the object handled by the wizard.
   */
  private ChangeDescription _changeDescription;

  /**
   * Constructor.<br>
   * Both parameters can not be null at the same time.
   * @param parent_p model element used as parent of given model element can NOT be null.
   * @param modelElement_p the model element to display, can not be null if readOnly is set to <code>true</code>
   * @param readOnlyMode_p Whether or not the wizard is in read only mode : data can not be changed.
   */
  protected AbstractModelElementWizard(EObject parent_p, NamedModelElementWithId modelElement_p, boolean readOnlyMode_p) {
    _isInReadOnly = readOnlyMode_p;
    initialize(parent_p, modelElement_p);
  }

  /**
   * Initialization of the wizard.
   * @param parent_p
   * @param modelElement_p
   */
  private void initialize(EObject parent_p, NamedModelElementWithId modelElement_p) {
    // Precondition
    if (null == parent_p) {
      throw new IllegalArgumentException("Argument parent_p can not be null"); //$NON-NLS-1$
    }
    // Set Parent object.
    _parent = parent_p;
    // Set model element that this wizard is open for.
    _modelElement = modelElement_p;
    // If the wizard is NOT in read only, handle creation or edit mode.
    if (!_isInReadOnly) {
      // If given model element is null, this wizard is in creation mode.
      if (null == _modelElement) {
        // Create an empty model element for this wizard.
        _modelElement = doCreateModelElement();
        // Set the creation mode.
        _isInCreationMode = true;
      } else {
        // This wizard is in edit mode.
        // Listening changes on model element when editing model element.
        startChangesRecording(_modelElement);
      }
    }
    // Handle description.
    handleWizardDescription();
    // Get the image descriptor if provided.
    ImageDescriptor wizardDefaultPageImage = getWizardDefaultPageImageDescriptor();
    // Set it if provided.
    if (null != wizardDefaultPageImage) {
      setDefaultPageImageDescriptor(wizardDefaultPageImage);
    }
  }

  /**
   * Create concrete model element.
   * @return a not null {@link NamedModelElementWithId} object.
   */
  protected abstract NamedModelElementWithId doCreateModelElement();

  /**
   * Returns the description when this wizard creates the displayed object.
   * @return a not null {@link String} instance.
   */
  protected abstract String getCreationDescription();

  /**
   * Returns the description when this wizard modifies the displayed object.
   * @return a not null {@link String} instance.
   */
  protected abstract String getEditDescription();

  /**
   * Returns the title message of this wizard.
   * @return
   */
  protected abstract String getTitle();

  /**
   * Handle wizard description between the creation and edit modes.
   */
  private void handleWizardDescription() {
    if (_isInCreationMode) {
      _description = getCreationDescription();
    } else {
      _description = getEditDescription();
    }
  }

  /**
   * Start model element changes recording.
   * @param modelElement_p
   */
  protected void startChangesRecording(EObject modelElement_p) {
    _changeRecorder = new ChangeRecorder(modelElement_p) {
      /**
       * @see org.eclipse.emf.ecore.change.util.BasicChangeRecorder#eliminateEmptyChanges()
       */
      @Override
      protected void eliminateEmptyChanges() {
        // Due to the way data are lazy loaded, the super method can eliminate right changes.
        // For instance : a contract element with contract element references not loaded (EReference is null).
        // When the page is created contract element references are loaded (EReference is not null and contains data), the change recorder detects that.
        // Now let's imagine the end-user changed its mind: he changes the contract element nature to a self-describing contract element.
        // The related contract element references are cleared, the change recorder detects that.
        // The state of this reference is the same as the one at display time.
        // Then the ChangeRecorder thinks its an unnecessary change when it computes the change description.
        // Do nothing prevents from this behavior.
      }
    };
  }

  /**
   * End model element changes recording.
   * @return
   */
  protected ChangeDescription endChangesRecording() {
    ChangeDescription changeDescription = _changeRecorder.endRecording();
    // Clean stuff.
    _changeRecorder.dispose();
    return changeDescription;
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#performCancel()
   */
  @Override
  public boolean performCancel() {
    // If the wizard is NOT in read only, handle creation or edit mode.
    if (!_isInReadOnly) {
      // Handle cancellation in creation or edit mode.
      if (_isInCreationMode) {
        _modelElement = null;
        _parent = null;
      } else {
        // Change recorder is only used in modification mode.
        ChangeDescription changes = endChangesRecording();
        // null if there is nothing being recorded.
        if (null != changes) {
          // Revert the potential changes made.
          changes.applyAndReverse();
        }
      }
    }
    return super.performCancel();
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    boolean result = true;
    // This method can only be called when the wizard is not in read only mode.
    // If the wizard is in creation mode, add the created factory component invocation to its parent.
    if (_isInCreationMode) {
      Command command = getAddCommandForCreatedElement(getEditingDomain(), _parent, _modelElement);
      executeCommand(command);
    } else {
      // Modification mode : end recording.
      _changeDescription = endChangesRecording();
      result = handleChangeDescription();
    }
    return result;
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#canFinish()
   */
  @Override
  public final boolean canFinish() {
    // In read only mode, we can not finish a wizard.
    boolean canFisnish = !_isInReadOnly;
    if (canFisnish) {
      canFisnish = handleCanFinish();
    }
    return canFisnish;
  }

  /**
   * Handle the canFinish condition in wizard mode (Read only or not) context.
   * @return true means ({@link #performFinish()} method can be called); false otherwise.
   */
  protected boolean handleCanFinish() {
    // Default behavior is the one from the method Wizard.canFinish.
    return super.canFinish();
  }

  /**
   * Get the command responsible of adding the created element to given parent when performing finish.
   * @param parent_p
   */
  protected abstract Command getAddCommandForCreatedElement(AdapterFactoryEditingDomain editingDomain_p, EObject parent_p, NamedModelElementWithId createdElement_p);

  /**
   * Handle change description.
   */
  protected boolean handleChangeDescription() {
    // Get the change description.
    ChangeDescription changes = getChangeDescription();
    // Check if changes were performed ?
    if (containsChanges(changes)) {
      // Modified object.
      EObject modifiedObject = getModelElement();
      Couple<EStructuralFeature, Object> modifiedFeature = getModifiedFeature(changes, modifiedObject);
      EStructuralFeature feature = modifiedFeature.getKey();
      Object value = modifiedFeature.getValue();
      // Get the editing domain.
      AdapterFactoryEditingDomain editingDomain = getEditingDomain();
      // Create the command to forward changes.
      ChangeRecorderWrapperCommand command = new ChangeRecorderWrapperCommand(changes, editingDomain, modifiedObject, feature, value);
      // Set the plug-in change command.
      command.setPluginChangeCommand(getPluginChangeCommand(editingDomain, modifiedObject, feature, value));
      // Run a command to forward changes on plug-in file.
      executeCommand(command);
    }
    return true;
  }

  /**
   * Return whether or not specified change description contains changes.
   * @param changes_p
   * @return
   */
  protected boolean containsChanges(ChangeDescription changes_p) {
    boolean result = false;
    // Precondition.
    if (null != changes_p) {
      // Get all changes on the model element object.
      EMap<EObject, EList<FeatureChange>> objectChanges = changes_p.getObjectChanges();
      result = !objectChanges.isEmpty();
    }
    return result;
  }

  /**
   * Get the modified feature with its new value from specified change description and given object.
   * @param changes_p
   * @param modifiedObject_p
   * @return a not null object, key is the modified feature and the value is the new feature value.
   */
  protected Couple<EStructuralFeature, Object> getModifiedFeature(ChangeDescription changes_p, EObject modifiedObject_p) {
    // Get all changes on the model element object.
    EMap<EObject, EList<FeatureChange>> objectChanges = changes_p.getObjectChanges();
    // Get changes made on the parent.
    EList<FeatureChange> objectChangeList = objectChanges.get(modifiedObject_p);
    // First feature change.
    FeatureChange featureChange = objectChangeList.get(0);
    // Feature
    EStructuralFeature feature = featureChange.getFeature();
    // New value
    Object value = featureChange.getValue();
    return new Couple<EStructuralFeature, Object>(feature, value);
  }

  /**
   * Execute given command.
   * @param command_p
   */
  private void executeCommand(Command command_p) {
    getEditingDomain().getCommandStack().execute(command_p);
  }

  /**
   * Get the editing domain.
   * @return
   */
  private AdapterFactoryEditingDomain getEditingDomain() {
    AdapterFactoryEditingDomain result =
        isInReadOnlyMode() 
      ? EgfUiActivator.getDefault().getEditingDomainInReadOnly() 
      : EgfUiActivator.getDefault().getEditingDomain();
    return result;
  }

  /**
   * Get the plugin change command.
   * @param editingDomain_p
   * @param modelElement_p
   * @param feature_p
   * @param value_p
   * @return
   */
  protected abstract PluginChangeWrapperCommand getPluginChangeCommand(EditingDomain editingDomain_p, EObject modelElement_p, EStructuralFeature feature_p, Object value_p);

  /**
   * @see org.eclipse.jface.wizard.Wizard#addPages()
   */
  @Override
  public void addPages() {
    String[] arguments = new String[2];
    if (_isInCreationMode) {
      arguments[0] = Messages.CreationWizard_Prefix;
    } else {
      arguments[0] = Messages.EditWizard_Prefix;
    }
    // set the wizard title
    arguments[1] = getTitle();
    // Create the composed title.
    String titleMessage = MessageFormatHelper.formatMessage(Messages.Wizard_Title, arguments);
    // Set the wizard title.
    setWindowTitle(titleMessage);
  }

  /**
   * Get the change recorder that listens to model element changes.
   * @return the changeRecorder
   */
  protected ChangeRecorder getChangeRecorder() {
    return _changeRecorder;
  }

  /**
   * Get the model element object handled by this wizard.
   * @return a not null model element.
   */
  public NamedModelElementWithId getModelElement() {
    return _modelElement;
  }

  /**
   * Get the wizard description.
   * @return the description
   */
  public String getDescription() {
    return _description;
  }

  /**
   * Return the change description when perform finish is called.
   * @return the changeDescription
   */
  protected ChangeDescription getChangeDescription() {
    return _changeDescription;
  }

  /**
   * Get the parent object of the handled model element.
   * @return the parent
   */
  public EObject getParent() {
    return _parent;
  }

  /**
   * Whether or not this wizard is in read only.
   * @return true means data can not be changed.
   */
  public boolean isInReadOnlyMode() {
    return _isInReadOnly;
  }

  /**
   * Get the wizard default image.<br>
   * Recommended image size is 75x66.
   * @return <code>null<code/> means no image set on the wizard.
   */
  protected ImageDescriptor getWizardDefaultPageImageDescriptor() {
    // Do nothing.
    return null;
  }
  
}
