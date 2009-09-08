/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.action.explorer.create;

import org.eclipse.egf.core.ui.wizard.MappingWizard;
import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.core.ui.workbench.action.open.OpenMappingAction;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.MappingViewpoint;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Open a wizard to create a {@link MappingModel} model element.
 * @author Guillaume Brocard
 */
public class CreateMappingAction extends CreateModelElementAction {
  protected MappingModel _createdMappingModel;

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public CreateMappingAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setText(Messages.CreateMappingAction_Title);
    setToolTipText(Messages.CreateMappingAction_Tooltip);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_NEW_MAPPING));
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    return new MappingWizard(modelElement_p, null, isReadOnly());
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.create.CreateModelElementAction#run()
   */
  @Override
  public void run() {
    _createdMappingModel = null;
    NamedModelElementWithId mappingViewpoint = getModelElement();
    // Create a mapping model creation listener on the mapping viewpoint to detect the created object.
    AdapterImpl mappingCreationListener = new AdapterImpl() {
      /**
       * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
       */
      @Override
      public void notifyChanged(Notification msg_p) {
        if (msg_p.getEventType() == Notification.ADD) {
          _createdMappingModel = (MappingModel) msg_p.getNewValue();
        }
      }
    };
    EList<Adapter> mappingViewpointAdapters = mappingViewpoint.eAdapters();
    // Add the mapping model creation listener.
    mappingViewpointAdapters.add(mappingCreationListener);
    // Execute the standard creation action.
    super.run();
    // If a mapping was created, open it.
    if (null != _createdMappingModel) {
      OpenMappingAction openMappincAction = new OpenMappingAction(getShell(), getSelectionProvider(), isReadOnly());
      // Set the current selection.
      openMappincAction.setSelectedElement(_createdMappingModel);
      // Execute the 'open' action.
      openMappincAction.run();
    }
    // Remove the mapping model creation listener.
    mappingViewpointAdapters.remove(mappingCreationListener);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return MappingViewpoint.class;
  }
}