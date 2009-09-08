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
package org.eclipse.egf.core.ui.workbench.action.navigator;

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.provider.FactoryComponentEditPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.plugin.AbstractUIPlugin;


/**
 * Base class to implement action dealing with a model element.
 * @author fournier
 */
public abstract class AbstractModelElementAction extends AbstractNavigatorAction {
  
  /**
   * Managed model element.
   */
  private NamedModelElementWithId _modelElement;
  
  /**
   * Is the open wizard by this action in read only mode ?
   */
  private boolean _isReadOnly;

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p whether or not the open wizard is in read only.
   */
  protected AbstractModelElementAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p);
    // Set action id based on class name.
    setId(getClass().getName());
    _isReadOnly = readOnlyMode_p;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#setSelectedElement(java.lang.Object)
   */
  @Override
  public void setSelectedElement(Object object_p) {
    if (object_p instanceof NamedModelElementWithId) {
      _modelElement = (NamedModelElementWithId) object_p;
    }
  }

  /**
   * Get the editing model element.
   * @return the modelElement
   */
  public NamedModelElementWithId getModelElement() {
    return _modelElement;
  }

  /**
   * Execute the command.
   * @param editingDomain_p
   * @param command_p
   */
  protected void executeCommand(AdapterFactoryEditingDomain editingDomain_p, Command command_p) {
    // Execute the command.
    editingDomain_p.getCommandStack().execute(command_p);
  }

  /**
   * Get the editing domain.
   * @return
   */
  protected AdapterFactoryEditingDomain getEditingDomain() {
    // Get the editing domain.
    AdapterFactoryEditingDomain editingDomain =
        isReadOnly() 
      ? EgfUiActivator.getDefault().getEditingDomainInReadOnly() 
      : EgfUiActivator.getDefault().getEditingDomain();
    return editingDomain;
  }

  /**
   * Compute an image descriptor for a model element.<br>
   * The file related to the image must be related to {@link FactoryComponentEditPlugin}.
   * @return an {@link ImageDescriptor} or null if not found.
   */
  protected ImageDescriptor computeImageDescriptorForModelElement(String pluginRelatedImagePath_p) {
    return AbstractUIPlugin.imageDescriptorFromPlugin(FactoryComponentEditPlugin.getPlugin().getSymbolicName(), pluginRelatedImagePath_p);
  }

  /**
   * Whether or not the open wizard is in read only ?
   * @return the isReadOnly
   */
  protected boolean isReadOnly() {
    return _isReadOnly;
  }

  /**
   * Get the wizard that handles with given model element.
   * @param selectedModelElement_p the selected element that triggers this action.
   * @return a not null {@link Wizard} instance.
   */
  protected abstract Wizard getWizardFor(NamedModelElementWithId selectedModelElement_p);

  /**
   * Open a wizard dialog for given wizard.
   * @param wizard_p
   */
  protected void openWizardDialog(Wizard wizard_p) {
    WizardDialog dialog = new WizardDialog(getShell(), wizard_p);
    dialog.open();
  }
  
}